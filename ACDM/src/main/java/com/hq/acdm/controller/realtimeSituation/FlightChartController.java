package com.hq.acdm.controller.realtimeSituation;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.realtimeSituation.FlightChartService;
import com.hq.acdm.service.sys.UsersService;
import com.hq.acdm.util.ConstantUtil;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.vo.realtimeSituation.HBSPerHour;
import com.hq.acdm.vo.realtimeSituation.HBSPerHourVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "实况图表")
@RestController
@RequestMapping("/realtimeSituation/flightChart")
public class FlightChartController {
    @Resource
    private FlightChartService flightChartService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private com.hq.acdm.service.sys.UsersService UsersService;
    @ApiOperation(httpMethod = "GET", value = "每小时计划进港数", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getAJHSPerHour.json", method = RequestMethod.GET)
    public ServerResponse<List<HBSPerHour>> getAJHSPerHour(HttpServletRequest request) {
        Map<String, Object> queryMap = new HashMap<>();
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String condition = "";
        String dept = "";
        if(sysUser != null){
            dept = UsersService.findDepartment(sysUser.getEmployeeId());
            //用户为地服用户时，设置查询条件
            if ("IGO".equals(dept)){
                condition= ConstantUtil.IGO;
            }
            //用户为国航用户时，设置查询条件
            if ("CCA".equals(dept)){
                condition= ConstantUtil.CCA;
            }
            //用户为南航用户时，设置查询条件
            if ("CSN".equals(dept)){
                condition= ConstantUtil.CSN;
            }
            //用户为东航用户时，设置查询条件
            if ("CES".equals(dept)){
                condition= ConstantUtil.CES;
            }
        }
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        return ServerResponse.createBySuccess(flightChartService.findAJHSPerHour(queryMap));
    }
    @ApiOperation(httpMethod = "GET", value = "每小时实际进港数", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getASJSPerHour.json", method = RequestMethod.GET)
    public ServerResponse<List<HBSPerHour>> getASJSPerHour(HttpServletRequest request) {
        Map<String, Object> queryMap = new HashMap<>();
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String condition = "";
        String dept = "";
        if(sysUser != null){
            dept = UsersService.findDepartment(sysUser.getEmployeeId());
            //用户为地服用户时，设置查询条件
            if ("IGO".equals(dept)){
                condition= ConstantUtil.IGO;
            }
            //用户为国航用户时，设置查询条件
            if ("CCA".equals(dept)){
                condition= ConstantUtil.CCA;
            }
            //用户为南航用户时，设置查询条件
            if ("CSN".equals(dept)){
                condition= ConstantUtil.CSN;
            }
            //用户为东航用户时，设置查询条件
            if ("CES".equals(dept)){
                condition= ConstantUtil.CES;
            }
        }
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        return ServerResponse.createBySuccess(flightChartService.findASJSPerHour(queryMap));
    }
    @ApiOperation(httpMethod = "GET", value = "每小时进出港航班", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getHBSPerHour.json", method = RequestMethod.GET)
    public ServerResponse<HBSPerHourVo> getHBSPerHour(HttpServletRequest request) {
        Map<String, Object> queryMap = new HashMap<>();
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String condition = "";
        String dept = "";
        if(sysUser != null){
            dept = UsersService.findDepartment(sysUser.getEmployeeId());
            //用户为地服用户时，设置查询条件
            if ("IGO".equals(dept)){
                condition= ConstantUtil.IGO;
            }
            //用户为国航用户时，设置查询条件
            if ("CCA".equals(dept)){
                condition= ConstantUtil.CCA;
            }
            //用户为南航用户时，设置查询条件
            if ("CSN".equals(dept)){
                condition= ConstantUtil.CSN;
            }
            //用户为东航用户时，设置查询条件
            if ("CES".equals(dept)){
                condition= ConstantUtil.CES;
            }
        }
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        return ServerResponse.createBySuccess(flightChartService.findHBSPerHour(queryMap));
    }
}
