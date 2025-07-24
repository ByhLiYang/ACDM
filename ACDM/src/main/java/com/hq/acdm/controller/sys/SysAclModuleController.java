package com.hq.acdm.controller.sys;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.param.sys.AclModuleParam;
import com.hq.acdm.service.sys.ISysAclModuleService;
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

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Api(description="菜单管理Api")
@RestController
@RequestMapping("/sys/menu")
@Slf4j
public class SysAclModuleController {

    @Resource
    private ISysAclModuleService sysAclModuleService;
    @Resource
    private ISysTreeService sysTreeService;

    @ApiOperation(httpMethod = "POST", value = "新增菜单模块", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add.json", method = RequestMethod.POST)
    public ServerResponse saveAclModule(AclModuleParam param) {
        sysAclModuleService.save(param);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "更新菜单模块", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    public ServerResponse updateAclModule(AclModuleParam param) {
        sysAclModuleService.update(param);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "菜单列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    public ServerResponse tree() {
        return ServerResponse.createBySuccess(sysTreeService.aclModuleTree());
    }

    @ApiOperation(httpMethod = "GET", value = "用户菜单列表树", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/user_menu_view.json", method = RequestMethod.GET)
    public ServerResponse userTree() {
        return ServerResponse.createBySuccess(sysTreeService.userAclModuleTree());
    }

    @ApiOperation(httpMethod = "GET", value = "删除菜单模块", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delete.json", method = RequestMethod.GET)
    public ServerResponse delete(@ApiParam("模块ID数组") @RequestParam("menuIds") String menuIds) {

        sysAclModuleService.delete(menuIds);
        return ServerResponse.createBySuccess();
    }
}
