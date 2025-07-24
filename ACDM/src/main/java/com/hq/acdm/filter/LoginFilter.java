package com.hq.acdm.filter;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import com.hq.acdm.common.ApplicationContextHelper;
import com.hq.acdm.common.Const;
import com.hq.acdm.common.RequestHolder;
import com.hq.acdm.exception.LoginExpireException;
import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.type.TypeReference;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @Author: lizhifeng
 * @Date: 2018/8/18
 * @Description:
 */
@Slf4j
public class LoginFilter implements Filter {

    private static Set<String> exclusionUrlSet = Sets.newConcurrentHashSet();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String exclusionUrls = filterConfig.getInitParameter("exclusionUrls");
        List<String> exclusionUrlList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(exclusionUrls);
        exclusionUrlSet = Sets.newConcurrentHashSet(exclusionUrlList);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String servletPath = req.getServletPath();
    /*    SysCacheService sysCacheService = ApplicationContextHelper.popBean(SysCacheService.class);
        if (exclusionUrlSet.contains(servletPath)) {
            RequestHolder.add(req);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String loginToken = CookieUtil.readLoginToken(req, CookieUtil.COOKIE_SESSION_NAME);
        if (loginToken == null) {
            throw new LoginExpireException();
        }
        String cacheValue = sysCacheService.getFromCache(loginToken);
        SysUser sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<SysUser>() {
        });
        if (sysUser == null) {
            throw new LoginExpireException();
        } else {
            //重置session的过期时间
            sysCacheService.expire(loginToken, Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
        }
        RequestHolder.add(sysUser);*/
        RequestHolder.add(req);
        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }

    @Override
    public void destroy() {

    }
}
