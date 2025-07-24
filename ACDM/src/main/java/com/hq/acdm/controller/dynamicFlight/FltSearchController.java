package com.hq.acdm.controller.dynamicFlight;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.dynamicFlight.FltSearchService;
import com.hq.acdm.service.sys.UsersService;
import com.hq.acdm.util.ConstantUtil;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.vo.dynamicFlight.FlightInfoVo;
import com.hq.acdm.vo.dynamicFlight.FlightInquiryVo;
import com.hq.acdm.vo.dynamicFlight.PresetFieldCXVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "航班全信息查询")
@RestController
@RequestMapping("/dynamicFlight/fltSearch")
public class FltSearchController {

    @Resource
    private FltSearchService fltSearchService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private com.hq.acdm.service.sys.UsersService UsersService;

    @ApiOperation(httpMethod = "POST", value = "航班全信息列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAllFltInfo.json", method = RequestMethod.POST)
    public ServerResponse findAllFltInfo(@ApiParam("航班全信息列表")
                         @RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,
                         @RequestParam("flno") String flno,@RequestParam("airlines") String airlines,
                         @RequestParam("dOrA") String dOrA,@RequestParam("status") String status,
                         @RequestParam("regn") String regn,
                         HttpServletRequest request, HttpServletResponse response) {
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
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startTime",startTime);
        queryMap.put("endTime",endTime);
        queryMap.put("flno",flno);
        queryMap.put("airlines",airlines);
        queryMap.put("regn",regn);
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        queryMap.put("dOrA",dOrA);
        if(status != null && !"".equals(status)){
            if(status.equals("NOL")){
                queryMap.put("normal","1");
            }else{
                queryMap.put("normal","0");
            }
            if(status.equals("RTN")){
                queryMap.put("retFl","1");
            }else{
                queryMap.put("retFl","0");
            }
            if(status.equals("ALT")){
                queryMap.put("alternate","1");
            }else{
                queryMap.put("alternate","0");
            }
            if(status.equals("DLY")){
                queryMap.put("delay","1");
            }else{
                queryMap.put("delay","0");
            }
            if(status.equals("CAN")){
                queryMap.put("cancel","1");
            }else{
                queryMap.put("cancel","0");
            }
        }
        List<FlightInfoVo> flightInfoList = fltSearchService.findAllFltInfo(queryMap);
        return ServerResponse.createBySuccess(flightInfoList);
    }


    @ApiOperation(httpMethod = "POST", value = "航班条件查询信息列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findIndexFltDetailInfo.json", method = RequestMethod.POST)
    public ServerResponse findIndexFltDetailInfo(@ApiParam("航班条件查询信息列表")
                                         @RequestParam("status") String status,
                                         HttpServletRequest request, HttpServletResponse response) {
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
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startTime","");
        queryMap.put("endTime","");
        queryMap.put("flno","");
        queryMap.put("airlines","");
        queryMap.put("dOrA","");
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        if(status != null && !"".equals(status)){
            if(status.equals("NORMAL")){
                queryMap.put("normal","1");
            }else{
                queryMap.put("normal","0");
            }
            if(status.equals("RTN")){
                queryMap.put("retFl","1");
            }else{
                queryMap.put("retFl","0");
            }
            if(status.equals("ALT")){
                queryMap.put("alternate","1");
            }else{
                queryMap.put("alternate","0");
            }
            if(status.equals("DLY")){
                queryMap.put("delay","1");
            }else{
                queryMap.put("delay","0");
            }
            if(status.equals("CAN")){
                queryMap.put("cancel","1");
            }else{
                queryMap.put("cancel","0");
            }
        }
        List<FlightInfoVo> flightInfoList = fltSearchService.findIndexFltDetailInfo(queryMap);
        return ServerResponse.createBySuccess(flightInfoList);
    }


    @ApiOperation(httpMethod = "GET", value = "航班查询预设字段查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findPresetFieldCX.json", method = RequestMethod.GET)
    public ServerResponse findPresetFieldCX(HttpServletRequest request) {
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("loginName",sysUser.getEmployeeId());
        List<PresetFieldCXVo> presetFieldCXList = fltSearchService.findPresetFieldCX(queryMap);
        return ServerResponse.createBySuccess(presetFieldCXList.get(0));
    }

    @ApiOperation(httpMethod = "POST", value = "航班查询预设字段存储", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertPresetFieldCX.json", method = RequestMethod.POST)
    public ServerResponse insertPresetFieldCX(@ApiParam("航班查询预设字段存储")
                                              @RequestParam("data") String data,
                                              HttpServletRequest request, HttpServletResponse response) {
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("data",data);
        queryMap.put("loginName",sysUser.getEmployeeId());
        return ServerResponse.createBySuccess(fltSearchService.insertPresetFieldCX(queryMap));
    }





    @ApiOperation(httpMethod = "POST", value = "航班查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectAllFlightInfo.json", method = RequestMethod.POST)
    public ServerResponse selectAllFlightInfo(@ApiParam("航班计划开始时间") @RequestParam("startTime") String startTime,
                                         @ApiParam("航班计划结束时间") @RequestParam("endTime") String endTime,
                                         @ApiParam("航班号") @RequestParam("flno") String flno,
                                         HttpServletRequest request, HttpServletResponse response) {
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
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startTime",startTime);
        queryMap.put("endTime",endTime);
        queryMap.put("flno",flno);
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        List<FlightInquiryVo> flightInfoList = fltSearchService.selectAllFlightInfo(queryMap);
        return ServerResponse.createBySuccess(flightInfoList);
    }

}
