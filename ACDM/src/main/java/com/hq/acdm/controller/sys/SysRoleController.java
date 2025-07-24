package com.hq.acdm.controller.sys;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.param.sys.role.RoleParam;
import com.hq.acdm.service.sys.ISysRoleAclService;
import com.hq.acdm.service.sys.ISysRoleService;
import com.hq.acdm.service.sys.ISysTreeService;
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

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Api(description="角色管理Api")
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {

    @Resource
    private ISysRoleService sysRoleService;
    @Resource
    private ISysTreeService sysTreeService;
    @Resource
    private ISysRoleAclService sysRoleAclService;

    @ApiOperation(httpMethod = "POST", value = "新增角色", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add.json", method = RequestMethod.POST)
    public ServerResponse saveRole(RoleParam param) {
        sysRoleService.save(param);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "更新角色", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    public ServerResponse updateRole(RoleParam param) {
        sysRoleService.update(param);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "删除角色", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delete.json", method = RequestMethod.GET)
    public ServerResponse deleteRole(@RequestParam("roleIds") String roleIds) {
        sysRoleService.delete(roleIds);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "角色已有权限", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/resources.json", method = RequestMethod.GET)
    public ServerResponse resources(@RequestParam("id") String id) {
        List<Integer> result = sysRoleService.get(id);
        return ServerResponse.createBySuccess(result);
    }

    @ApiOperation(httpMethod = "GET", value = "角色列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    public ServerResponse list() {
        return ServerResponse.createBySuccess(sysTreeService.roleTree());
    }

/*    @RequestMapping("/roleTree.json")
    public ServerResponse roleTree(@RequestParam("roleId") int roleId) {
        return ServerResponse.createBySuccess(sysTreeService.roleTree(roleId));
    }*/

    @ApiOperation(httpMethod = "GET", value = "新增或更新角色的权限", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/setResources.json", method = RequestMethod.GET)
    public ServerResponse setResources(@RequestParam("roleId") int roleId, @ApiParam("权限") @RequestParam(value = "resourceIds") String resourceIds) {
        sysRoleAclService.changeRoleAcls(roleId, resourceIds);
        return ServerResponse.createBySuccess();
    }

}
