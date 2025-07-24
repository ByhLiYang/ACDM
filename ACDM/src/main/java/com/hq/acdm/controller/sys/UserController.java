package com.hq.acdm.controller.sys;

import com.google.common.collect.Lists;
import com.hq.acdm.beans.CacheKeyConstants;
import com.hq.acdm.common.Const;
import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.model.sys.UserM;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.sys.*;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.util.MD5Util;
import com.hq.acdm.vo.sys.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Api(description="用户登录退出Api")
@RestController
public class UserController {

    @Resource
    private ISysUserService sysUserService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private ISysTreeService sysTreeService;
    @Resource
    private ISysRoleService sysRoleService;
    @Resource
    private UsersService userService;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private TUserActionLogsService tUserActionLogsService;

/*    @ApiOperation(httpMethod = "GET", value = "用户退出", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/logout.action", method = RequestMethod.GET)
    public ServerResponse logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        CookieUtil.delLoginToken(request, response, CookieUtil.COOKIE_SESSION_NAME);
        sysCacheService.delFromCache(loginToken);
        List<MenuListVo> list = Lists.newArrayList();
        list.add(new MenuListVo());
        return ServerResponse.createBySuccess(list);
//        return ServerResponse.createBySuccess();
    }*/
@ApiOperation(httpMethod = "GET/POST", value = "用户退出", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value = "/logout.action", method = {RequestMethod.GET,RequestMethod.POST})
public ServerResponse logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
    CookieUtil.delLoginToken(request, response, CookieUtil.COOKIE_SESSION_NAME);
    sysCacheService.delFromCache(loginToken);
    Subject subject = SecurityUtils.getSubject();
    logger.info("###########################"+subject);
    logger.info("###########################"+subject.getPrincipal().toString());
    subject.logout();
    logger.info("###########################登出完成");
    List<MenuListVo> list = Lists.newArrayList();
    list.add(new MenuListVo());
    return ServerResponse.createBySuccess(list);
//        return ServerResponse.createBySuccess();
}

    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "用户登录", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse<SysUserVo> login(@ApiParam("用户登录信息") @RequestBody String AddDataObject,
                                           HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

//       SysUser sysUser = sysUserService.findByKeyword(username);
        JSONArray jsonArray = null;
        JSONObject j=new JSONObject(AddDataObject);
        String username = j.getString("username");
        String password = j.getString("password");
        Users sysUser = userService.findByUsername(username);
        String errorMsg = "";

        if (StringUtils.isBlank(username)) {
            errorMsg = "用户名不可以为空";
            return ServerResponse.createByParamError(errorMsg);

        } else if (StringUtils.isBlank(password)) {
            errorMsg = "密码不可以为空";
            return ServerResponse.createByParamError(errorMsg);

        } else if (sysUser == null) {
            errorMsg = "查询不到指定的用户";
            return ServerResponse.createByOtherError(errorMsg);

        } else if (!sysUser.getPassword().equals(MD5Util.encrypt(password))) {
            errorMsg = "用户名或密码错误";
            return ServerResponse.createByOtherError(errorMsg);
        } else if (!sysUser.getPassword().equalsIgnoreCase(MD5Util.encrypt(password))) {
            errorMsg = "用户名或密码错误";
            return ServerResponse.createByOtherError(errorMsg);
//        } else if (sysUser.getStatus() != 1) {
//            errorMsg = "用户已被冻结，请联系管理员";
//            return ServerResponse.createByOtherError(errorMsg);

        } else {
            // login success
            //用户信息存入cookie与redis
            sysUser.setPassword("");
            CookieUtil.writeLoginToken(response, CacheKeyConstants.USER_SESSIONID+"_"+request.getSession().getId(), CookieUtil.COOKIE_SESSION_NAME);
            sysCacheService.saveCache(JsonMapper.obj2String(sysUser), Const.RedisCacheExtime.REDIS_SESSION_EXTIME, CacheKeyConstants.USER_SESSIONID+"_"+request.getSession().getId());
            SysUserVo userVo = new SysUserVo();
            userVo.setSid("1");
            userVo.adapt(sysUser);

            TUserActionLogs tual = new TUserActionLogs();
            tual.setId(UUID.randomUUID().toString().replace("-",""));
            tual.setUserId(sysUser.getUserId());
            tual.setActionType("login");
//            String datetime = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").format();
            Date date = new Date();
            tual.setActionTime(date);
            tual.setCreateTime(date);
            tUserActionLogsService.updateActionLogs(tual);
            return ServerResponse.createBySuccess(userVo);
        }
    }
/*@RequestMapping(value = "/login.action", method = RequestMethod.POST)
@ResponseBody
@ApiOperation(httpMethod = "POST", value = "用户登录", produces = MediaType.APPLICATION_JSON_VALUE)
public ServerResponse<SysUserVo> login(@ApiParam("用户登录信息") @RequestBody String AddDataObject,
                                       HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

    logger.info("调用后台登录接口");
    String username =  (String) SecurityUtils.getSubject().getPrincipal();
//    UserM user = (UserM) SecurityUtils.getSubject().getPrincipal();
////    String username = user.getName();
////    logger.info("username",username);
////    String password = user.getPasswsord();
////    logger.info("password",password);
    Users sysUser = userService.findByUsername(username);
    String errorMsg = "";

    if (StringUtils.isBlank(username)) {
        errorMsg = "用户名不可以为空";
        return ServerResponse.createByParamError(errorMsg);

    } else if (sysUser == null) {
        errorMsg = "查询不到指定的用户";
        return ServerResponse.createByOtherError(errorMsg);

*//*        } else if (!sysUser.getPassword().equals(MD5Util.encrypt(password))) {
            errorMsg = "用户名或密码错误";
            return ServerResponse.createByOtherError(errorMsg);*//*
    } else {
        // login success
        //用户信息存入cookie与redis
        sysUser.setPassword("");
        CookieUtil.writeLoginToken(response, CacheKeyConstants.USER_SESSIONID+"_"+request.getSession().getId(), CookieUtil.COOKIE_SESSION_NAME);
        sysCacheService.saveCache(JsonMapper.obj2String(sysUser), Const.RedisCacheExtime.REDIS_SESSION_EXTIME, CacheKeyConstants.USER_SESSIONID+"_"+request.getSession().getId());
        SysUserVo userVo = new SysUserVo();
        userVo.setSid("1");
        userVo.adapt(sysUser);

        TUserActionLogs tual = new TUserActionLogs();
        tual.setId(UUID.randomUUID().toString().replace("-",""));
        tual.setUserId(sysUser.getUserId());
        tual.setActionType("login");
//            String datetime = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").format();
        Date date = new Date();
        tual.setActionTime(date);
        tual.setCreateTime(date);
        tUserActionLogsService.updateActionLogs(tual);
        return ServerResponse.createBySuccess(userVo);
    }
}*/

    @RequestMapping(value = "/ssoLogin.action", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "重定向到前端登录页", produces = MediaType.APPLICATION_JSON_VALUE)
    public void ssoLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {
        logger.info("重定向到/acdm/dist/#/login");
        response.sendRedirect("/dist/#/login");
//            return ServerResponse.createBySuccess("redirect:index.jsp");
//            return ServerResponse.createBySuccess(userVo);
    }

    @RequestMapping(value = "/applogin.action", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "APP用户登录", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse<SysUserVo> applogin(@ApiParam("用户名") @RequestParam("params[username]") String username,@ApiParam("密码") @RequestParam("params[password]") String password,
                                           HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {
        Users sysUser = userService.findByUsername(username);
        String errorMsg = "";

        if (StringUtils.isBlank(username)) {
            errorMsg = "用户名不可以为空";
            return ServerResponse.createByParamError(errorMsg);

        } else if (StringUtils.isBlank(password)) {
            errorMsg = "密码不可以为空";
            return ServerResponse.createByParamError(errorMsg);

        } else if (sysUser == null) {
            errorMsg = "查询不到指定的用户";
            return ServerResponse.createByOtherError(errorMsg);

/*        } else if (!sysUser.getPassword().equals(MD5Util.encrypt(password))) {
            errorMsg = "用户名或密码错误";
            return ServerResponse.createByOtherError(errorMsg);*/
        } else if (!sysUser.getPassword().equalsIgnoreCase(MD5Util.encrypt(password))) {
            errorMsg = "用户名或密码错误";
            return ServerResponse.createByOtherError(errorMsg);
//        } else if (sysUser.getStatus() != 1) {
//            errorMsg = "用户已被冻结，请联系管理员";
//            return ServerResponse.createByOtherError(errorMsg);

        } else {
            // login success
            //用户信息存入cookie与redis
            sysUser.setPassword("");
            CookieUtil.writeLoginToken(response, CacheKeyConstants.USER_SESSIONID+"_"+request.getSession().getId(), CookieUtil.COOKIE_SESSION_NAME);
            sysCacheService.saveCache(JsonMapper.obj2String(sysUser), Const.RedisCacheExtime.REDIS_SESSION_EXTIME, CacheKeyConstants.USER_SESSIONID+"_"+request.getSession().getId());
            SysUserVo userVo = new SysUserVo();
            userVo.setSid(sysUser.getUserId());
            userVo.adapt(sysUser);
            return ServerResponse.createBySuccess(userVo);
        }
    }


    @RequestMapping(value = "/updateLoginPassword.action", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "用户登录", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse updateLoginPassword(@ApiParam("用户登录信息") @RequestBody String AddDataObject,
                                           HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {


        JSONArray jsonArray = null;
        JSONObject j=new JSONObject(AddDataObject);
        String username = j.getString("username");
        String password = j.getString("password");
        Users user = userService.findByUsername(username);
        user.setPassword(MD5Util.encrypt(password));
        int i = userService.updateUserPassword(user);

        return ServerResponse.createBySuccess(i);
    }

    @RequestMapping(value = "/getAddressBook.action", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "获取通讯录", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse getAddressBook(@ApiParam("获取通讯录") @RequestBody String AddDataObject,
                                              HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {


        JSONArray jsonArray = null;
        JSONObject j=new JSONObject(AddDataObject);
        String username = j.getString("username");
        List<AddressBook> AddressBooks=new ArrayList<AddressBook>();
        AddressBook list111=new AddressBook();
        list111.setLabel("AOC用户");
        list111.setChildren(new ArrayList<AddressBookUsers>());
        AddressBookUsers a=new AddressBookUsers();
        a.setLabel("AOC用户3");
        a.setTelNum("1003");
        a.setSsNum("91003");
        a.setAcdmNum("AocU03");
        a.setIsonline(false);
        AddressBookUsers a1=new AddressBookUsers();
        a1.setLabel("AOC用户4");
        a1.setTelNum("1004");
        a1.setSsNum("1004");
        a1.setAcdmNum("AocU04");
        a1.setIsonline(false);
        AddressBookUsers a2=new AddressBookUsers();
        a2.setLabel("AOC用户5");
        a2.setTelNum("1005");
        a2.setSsNum("91005");
        a2.setAcdmNum("AocU05");
        a2.setIsonline(false);
        list111.getChildren().add(a);
        list111.getChildren().add(a1);
        list111.getChildren().add(a2);


        AddressBook list222=new AddressBook();
        list222.setLabel("地服用户");
        list222.setChildren(new ArrayList<AddressBookUsers>());
        AddressBookUsers a3=new AddressBookUsers();
        a3.setLabel("地服用户1");
        a3.setTelNum("1001");
        a3.setSsNum("91001");
        a3.setAcdmNum("HB01");
        a3.setIsonline(false);
        AddressBookUsers a4=new AddressBookUsers();
        a4.setLabel("地服用户2");
        a4.setTelNum("1002");
        a4.setSsNum("91002");
        a4.setAcdmNum("HB02");
        a4.setIsonline(false);
        AddressBookUsers a5=new AddressBookUsers();
        a5.setLabel("地服用户6");
//        a5.setTelNum("1006");
//        a5.setSsNum("91006");
//        a5.setAcdmNum("HB06");
        a5.setTelNum("56000126");
        a5.setSsNum("56000126");
        a5.setAcdmNum("HB06");
        a5.setIsonline(false);
        list222.getChildren().add(a3);
        list222.getChildren().add(a4);
        list222.getChildren().add(a5);


        AddressBooks.add(list111);
        AddressBooks.add(list222);

        return ServerResponse.createBySuccess(AddressBooks);
    }

}
