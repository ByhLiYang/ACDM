package com.hq.acdm.controller.sys;

import com.google.common.collect.Maps;
import com.hq.acdm.beans.PageQuery;
import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.dto.sys.RoleDto;
import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.param.sys.UserParam;
import com.hq.acdm.param.sys.user.ChangePwdParam;
import com.hq.acdm.service.sys.ISysRoleService;
import com.hq.acdm.service.sys.ISysRoleUserService;
import com.hq.acdm.service.sys.ISysTreeService;
import com.hq.acdm.service.sys.ISysUserService;
import com.hq.acdm.vo.sys.UserPageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Api(description = "用户管理Api")
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;
    @Resource
    private ISysTreeService sysTreeService;
    @Resource
    private ISysRoleService sysRoleService;
    @Resource
    private ISysRoleUserService sysRoleUserService;

    @ApiOperation(httpMethod = "POST", value = "新增用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add.json", method = RequestMethod.POST)
    public ServerResponse saveUser(UserParam param) {
        sysUserService.save(param);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "修改用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    public ServerResponse updateUser(UserParam param) {
        sysUserService.update(param);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "修改用户状态", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateStatus.json", method = RequestMethod.POST)
    public ServerResponse updateStatus(@RequestParam("userId")  String userId, @ApiParam("1：正常，0：冻结状态") @RequestParam("status") String status) {
        sysUserService.updateStatus(userId, status);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "分页查询用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/page.json", method = RequestMethod.GET)
    public ServerResponse page(@RequestParam("key") String key, PageQuery pageQuery) {
        UserPageVo result = sysUserService.getByPageList(key, pageQuery);
        return ServerResponse.createBySuccess(result);
    }

    @ApiOperation(httpMethod = "GET", value = "用户列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/listdsd.json", method = RequestMethod.GET)
    public ServerResponse list() {
        List<SysUser> result = sysUserService.getAll();
        return ServerResponse.createBySuccess(result);
    }

    @ApiOperation(httpMethod = "GET", value = "根据Id获取用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/get.json", method = RequestMethod.GET)
    public ServerResponse get(@RequestParam("id") String userId) {
        UserParam result = sysUserService.findByUserId(Integer.parseInt(userId));
        return ServerResponse.createBySuccess(result);
    }

/*    @ApiOperation(httpMethod = "GET", value = "角色列表树", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/roleIds.json", method = RequestMethod.GET)
    public ServerResponse roleIds() {
        List<RoleDto> result = sysTreeService.roleListTree();
        return ServerResponse.createBySuccess(result);
    }*/

    @ApiOperation(httpMethod = "GET", value = "删除用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delete.json", method = RequestMethod.GET)
    public ServerResponse delete(@RequestParam("userIds") int usrId) {
        sysUserService.delete(usrId);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "重置密码", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/resetPassword.json", method = RequestMethod.POST)
    public ServerResponse resetPassword(@RequestParam("username") String username, @RequestParam("newPassword")String newPassword) {
        sysUserService.updatePassword(username, newPassword);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "修改密码", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/changePwd.json", method = RequestMethod.POST)
    public ServerResponse changePwd(ChangePwdParam param) {
        sysUserService.changePwd(param);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "当前用户所拥有的权限和角色列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/acls.json", method = RequestMethod.GET)
    public ServerResponse acls(@RequestParam("userId") int userId) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("acls", sysTreeService.userAclTree(userId));
        map.put("roles", sysRoleService.getRoleListByUserId(userId));
        return ServerResponse.createBySuccess(map);
    }

    @ApiOperation(httpMethod = "POST", value = "新增或更新用户的角色", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/setRoles.json")
    public ServerResponse setRoles(@RequestParam("userId") int userId, @ApiParam("角色") @RequestParam(value = "roleIds") String roleIds) {

        sysRoleUserService.changeRoleUsers(userId, roleIds);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "用户已有角色", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/roleIds.json", method = RequestMethod.GET)
    public ServerResponse roleIds(@RequestParam("id") int id) {
        List<Integer> result = sysUserService.get(id);
        return ServerResponse.createBySuccess(result);
    }
}
