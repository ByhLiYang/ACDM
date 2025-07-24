package com.hq.acdm.util;


import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.model.sys.UserM;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.sys.UsersService;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/*
import com.ias.res.pageModel.UserM;
import com.ias.res.util.Encodes;
import com.misgws.service.UsersService;
*/

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 系统安全认证实现类
 * @author ThinkGem
 * @version 2014-7-5
 */
//@Service
//@DependsOn({"userDao","roleDao","menuDao"})
public class SystemAuthorizingRealm extends CasRealm {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //private SystemService systemService;
    //private SessionDAO sessionDao;

    public SystemAuthorizingRealm() {
        this.setCachingEnabled(false);
    }
    @Resource
    private UsersService userService;
    /**
     * 认证回调函数, 登录时调用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
        CasToken casToken = (CasToken) authcToken;
        if (authcToken == null) {
            return null;
        }

        String ticket = (String) casToken.getCredentials();
        if (!org.apache.shiro.util.StringUtils.hasText(ticket)) {
            return null;
        }

        TicketValidator ticketValidator = ensureTicketValidator();

        Assertion casAssertion;
        try {
            casAssertion = ticketValidator.validate(ticket, getCasService());
            AttributePrincipal casPrincipal = casAssertion.getPrincipal();
            String userName = casPrincipal.getName();
            logger.info("Validate ticket : {} in CAS server : {} to retrieve user : {}", new Object[]{
                    ticket, getCasServerUrlPrefix(), userName
            });

            logger.info("认证回调函数, 登录时调用");
            //int activeSessionSize = getSessionDAO().getActiveSessions(false).size();
            if (logger.isDebugEnabled()) {
                //logger.debug("login submit, active session size: {}, username: {}", activeSessionSize,
                //userName);
            }

            // 校验登录验证码
//			if (UserUtils.isValidateCodeLogin(userName, false, false)) {
//				Session session = UserUtils.getSession();
//				String code = (String) session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
//				if (casToken.getCaptcha() == null || !casToken.getCaptcha().toUpperCase().equals(code)) {
//					throw new AuthenticationException("msg:验证码错误, 请重试.");
//				}
//			}

            // 校验用户名密码
            /*SysUser user = new SysUser();
            user.setUsername("9995");
            user.setPassword("1bbd886460827015e5d605ed44252251");*/
            Users users = userService.findByUsername(userName);
            UserM user = new UserM();
            user.setName(userName);
            user.setPassword(users.getPassword());
            if (user != null) {
                return new SimpleAuthenticationInfo(userName, user.getPassword(),
                        getName());
            } else {
                return null;
            }
        } catch (TicketValidationException e) {
            logger.info("info: {validate fail}",e.getMessage());
            return null;
        }

    }



    /**
     * 获取权限授权信息，如果缓存中存在，则直接从缓存中获取，否则就重新获取， 登录成功后调用
     */
	/*protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) {
			return null;
		}

		AuthorizationInfo info = null;

		info = (AuthorizationInfo) UserUtils.getCache(UserUtils.CACHE_AUTH_INFO);
		if (info == null) {
			info = doGetAuthorizationInfo(principals);
			if (info != null) {
				UserUtils.putCache(UserUtils.CACHE_AUTH_INFO, info);
			}
		}

		return info;
	}*/

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
     *//*
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Principal principal = (Principal) getAvailablePrincipal(principals);
		// 获取当前已登录的用户
		if (!Global.TRUE.equals(Global.getConfig("user.multiAccountLogin"))) {
			Collection<Session> sessions = getSessionDAO().getActiveSessions(true, principal,
					UserUtils.getSession());
			if (sessions.size() > 0) {
				// 如果是登录进来的，则踢出已在线用户
				if (UserUtils.getSubject().isAuthenticated()) {
					for (Session session : sessions) {
						getSessionDAO().delete(session);
					}
				}
				// 记住我进来的，并且当前用户已登录，则退出当前用户提示信息。
				else {
					System.out.println("170===========--================");
					UserUtils.getSubject().logout();
					throw new AuthenticationException("msg:账号已在其它地方登录，请重新登录。");
				}
			}
		}
		User user = getSystemService().getUserByLoginName(principal.getLoginName());
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			List<Menu> list = UserUtils.getMenuList();
			for (Menu menu : list) {
				if (StringUtils.isNotBlank(menu.getPermission())) {
					// 添加基于Permission的权限信息
					for (String permission : StringUtils.split(menu.getPermission(), ",")) {
						info.addStringPermission(permission);
					}
				}
			}
			// 添加用户权限
			info.addStringPermission("user");
			// 添加用户角色信息
			for (Role role : user.getRoleList()) {
				info.addRole(role.getEnname());
			}
			// 更新登录IP和时间
			getSystemService().updateUserLoginInfo(user);
			// 记录登录日志
			LogUtils.saveLog(Servlets.getRequest(), "系统登录");
			return info;
		} else {
			return null;
		}
	}*/

    @Override
    protected void checkPermission(Permission permission, AuthorizationInfo info) {
        authorizationValidate(permission);
        super.checkPermission(permission, info);
    }

    @Override
    protected boolean[] isPermitted(List<Permission> permissions, AuthorizationInfo info) {
        if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
                authorizationValidate(permission);
            }
        }
        return super.isPermitted(permissions, info);
    }

    @Override
    public boolean isPermitted(PrincipalCollection principals, Permission permission) {
        authorizationValidate(permission);
        return super.isPermitted(principals, permission);
    }

    @Override
    protected boolean isPermittedAll(Collection<Permission> permissions, AuthorizationInfo info) {
        if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
                authorizationValidate(permission);
            }
        }
        return super.isPermittedAll(permissions, info);
    }

    /**
     * 授权验证方法
     *
     * @param permission
     */
    private void authorizationValidate(Permission permission) {
        // 模块授权预留接口
    }

    /**
     * 设定密码校验的Hash算法与迭代次数
     */
    @PostConstruct
    public void initCredentialsMatcher() {
//		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(SystemService.HASH_ALGORITHM);
//		matcher.setHashIterations(SystemService.HASH_INTERATIONS);
        setCredentialsMatcher(new MyCredentialsMatcher());
    }

    /**
     * 定义自己的密码验证类
     * @author angus
     *
     */
    protected class MyCredentialsMatcher extends SimpleCredentialsMatcher {
        @Override
        public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
            CasToken casToken = (CasToken) authcToken;
            if (authcToken == null) {
                return false;
            }
            String ticket = (String) casToken.getCredentials();
            if (!org.apache.shiro.util.StringUtils.hasText(ticket)) {
                return false;
            }

            TicketValidator ticketValidator = ensureTicketValidator();
            String tokenPassword = "";
            Assertion casAssertion;
            try {
                casAssertion = ticketValidator.validate(ticket, getCasService());
                AttributePrincipal casPrincipal = casAssertion.getPrincipal();
                Map<String, Object> maps = casPrincipal.getAttributes();
                if(maps!=null&&maps.size()>0){
                    //获取从CAS返回的密码串
                    tokenPassword = maps.get("password").toString();
                }
            }catch(Exception e){
                //logger.error("error", e);
                //logger.error("error:{}",e);
                tokenPassword = "";
            }
            //获取从数据库中得到的密码
            String accountCredentials = getCredentials(info).toString();
            return equals(tokenPassword, accountCredentials);
        }
    }

    // /**
    // * 清空用户关联权限认证，待下次使用时重新加载
    // */
    // public void clearCachedAuthorizationInfo(Principal principal) {
    // SimplePrincipalCollection principals = new
    // SimplePrincipalCollection(principal, getName());
    // clearCachedAuthorizationInfo(principals);
    // }

    /**
     * 清空所有关联认证
     *
     * @Deprecated 不需要清空，授权缓存保存到session中
     */
    @Deprecated
    public void clearAllCachedAuthorizationInfo() {
        // Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        // if (cache != null) {
        // for (Object key : cache.keys()) {
        // cache.remove(key);
        // }
        // }
    }

    /**
     * 获取系统业务对象
     */
	/*public SystemService getSystemService() {
		if (systemService == null){
			systemService = SpringContextHolder.getBean(SystemService.class);
		}
		return systemService;
	}*/

    /**
     * 获取系统业务对象
     */
/*	public SessionDAO getSessionDAO() {
		if (sessionDao == null) {
			sessionDao = SpringContextHolder.getBean(SessionDAO.class);
		}
		return sessionDao;
	}*/

    /**
     * 授权用户信息
     */
	/*public static class Principal implements Serializable {

		private static final long serialVersionUID = 1L;

		private String id; // 编号
		private String loginName; // 登录名
		private String name; // 姓名
		private boolean mobileLogin; // 是否手机登录

//		private Map<String, Object> cacheMap;

		public Principal(User user, boolean mobileLogin) {
			this.id = user.getId();
			this.loginName = user.getLoginName();
			this.name = user.getName();
			this.mobileLogin = mobileLogin;
		}

		public String getId() {
			return id;
		}

		public String getLoginName() {
			return loginName;
		}

		public String getName() {
			return name;
		}

		public boolean isMobileLogin() {
			return mobileLogin;
		}

//		@JsonIgnore
//		public Map<String, Object> getCacheMap() {
//			if (cacheMap==null){
//				cacheMap = new HashMap<String, Object>();
//			}
//			return cacheMap;
//		}

		*//**
     * 获取SESSIONID
     *//*
		public String getSessionid() {
			try{
				return (String) UserUtils.getSession().getId();
			}catch (Exception e) {
				return "";
			}
		}

		@Override
		public String toString() {
			return id;
		}

	}
*/
}

