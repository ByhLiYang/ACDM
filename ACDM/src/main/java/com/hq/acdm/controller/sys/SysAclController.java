package com.hq.acdm.controller.sys;

import com.google.common.collect.Maps;
import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.SysRole;
import com.hq.acdm.param.sys.AclParam;
import com.hq.acdm.service.sys.ISysAclService;
import com.hq.acdm.service.sys.ISysRoleService;
import com.hq.acdm.service.sys.ISysTreeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Api(description = "权限管理Api")
@RestController
@RequestMapping("/sys/resource")
@Slf4j
public class SysAclController {

    @Resource
    private ISysAclService sysAclService;
    @Resource
    private ISysRoleService sysRoleService;
    @Resource
    private ISysTreeService sysTreeService;

    @ApiOperation(httpMethod = "POST", value = "新增权限", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add.json", method = RequestMethod.POST)
    public ServerResponse saveAclModule(AclParam param) {
        sysAclService.save(param);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "更新权限", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    public ServerResponse updateAclModule(AclParam param) {
        sysAclService.update(param);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "删除权限", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delete.json", method = RequestMethod.GET)
    public ServerResponse deleteAclModule(@RequestParam("resourceIds") String resourceIds) {
        sysAclService.delete(resourceIds);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "权限列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    public ServerResponse list() {
        return ServerResponse.createBySuccess(sysTreeService.aclTree());
    }

    @ApiOperation(httpMethod = "GET", value = "拥有当前权限的角色和用户列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "acls.json", method = RequestMethod.GET)
    public ServerResponse acls(@RequestParam("aclId") int aclId) {
        Map<String, Object> map = Maps.newHashMap();
        List<SysRole> roleList = sysRoleService.getRoleListByAclId(aclId);
        map.put("roles", roleList);
        map.put("users", sysRoleService.getUserListByRoleList(roleList));
        return ServerResponse.createBySuccess(map);
    }
}
