package com.hq.acdm.controller.dynamicFlight;

import com.alibaba.fastjson.JSON;
import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.dynamicFlight.FltMonitorService;
import com.hq.acdm.service.dynamicFlight.PrcsSupervisionService;
import com.hq.acdm.service.sys.UsersService;
import com.hq.acdm.util.ConstantUtil;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.vo.coordinatedOprt.TFlightSchedulingVo;
import com.hq.acdm.vo.dynamicFlight.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
@Api(description = "航班动态进程监控")
@RestController
@RequestMapping("/dynamicFlight/prcsSupervision")
public class PrcsSupervisionController {
    @Resource
    private PrcsSupervisionService prcsSupervisionService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private com.hq.acdm.service.sys.UsersService UsersService;
    @ApiOperation(httpMethod = "POST", value = "即将进港", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getJJJG.json", method = RequestMethod.POST)
    public ServerResponse<List<PrcsJJJGVo>> getJJJG(@RequestBody String AddDataObject,HttpServletRequest request) {

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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        List<PrcsJJJGVo> list=prcsSupervisionService.findJJJG(queryMap);
        JSONArray jsonArray = null;
        try {
            JSONObject j = new JSONObject(AddDataObject);


            jsonArray = j.getJSONArray("data");
            List<PrcsJJJGVo> rilist=new ArrayList<PrcsJJJGVo>();
            PrcsJJJGVo ttvo = new PrcsJJJGVo();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jb = jsonArray.getJSONObject(i);
                PrcsJJJGVo bus = new PrcsJJJGVo();
                bus = JSON.parseObject(jb.toString(), PrcsJJJGVo.class);
                rilist.add(bus);
            }
            if (rilist!=null&&rilist.size()>0){
                for (int i = 0; i <list.size() ; i++) {
                    PrcsJJJGVo busi=list.get(i);
                    for (int k = 0; k <rilist.size() ; k++) {
                        PrcsJJJGVo busk=rilist.get(k);
                        if (busi.getFlnoA().equals(busk.getFlnoA())){
                            busi.setSeq(busk.getSeq());
                            break;
                        }
                    }
                }
            }else {
                for (int i = 0; i <list.size() ; i++) {
                    PrcsJJJGVo busi = list.get(i);
                    busi.setSeq(i+1);
                }
            }
            if (list!=null&&list.size()>0){
                Collections.sort(list);
            }
            for (int i = 0; i <list.size() ; i++) {
                PrcsJJJGVo busi = list.get(i);
                busi.setSeq(i+1);
            }
        }catch (JSONException e) {
                e.printStackTrace();
            }
        return ServerResponse.createBySuccess(list);
    }

    @ApiOperation(httpMethod = "GET", value = "提前起飞", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getTQQF.json", method = RequestMethod.GET)
    public ServerResponse<List<PrcsQZYWVo>> getTQQF(HttpServletRequest request) {
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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        return ServerResponse.createBySuccess(prcsSupervisionService.findTQQF(queryMap));
    }

    @ApiOperation(httpMethod = "GET", value = "落地滑行", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getLDHX.json", method = RequestMethod.GET)
    public ServerResponse<List<PrcsLDHXVo>> getLDHX(HttpServletRequest request) {
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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        return ServerResponse.createBySuccess(prcsSupervisionService.findLDHX(queryMap));
    }
    @ApiOperation(httpMethod = "GET", value = "离港滑行", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getLGHX.json", method = RequestMethod.GET)
    public ServerResponse<List<PrcsLGHXVo>> getLGHX(HttpServletRequest request) {
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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        return ServerResponse.createBySuccess(prcsSupervisionService.findLGHX(queryMap));
    }
    @ApiOperation(httpMethod = "GET", value = "前站起飞", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getQZYW.json", method = RequestMethod.GET)
    public ServerResponse<List<PrcsQZYWVo>> getQZYW(HttpServletRequest request) {
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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        return ServerResponse.createBySuccess(prcsSupervisionService.findQZYW(queryMap));
    }
    @ApiOperation(httpMethod = "GET", value = "过站保障", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getGZBZ.json", method = RequestMethod.GET)
    public ServerResponse<List<Map<String,Object>>> getGZBZ(HttpServletRequest request) {
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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        return ServerResponse.createBySuccess(prcsSupervisionService.findGZBZ(queryMap));
    }

    @ApiOperation(httpMethod = "POST", value = "过站保障按钮事件", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/SelectNoticeTime.json", method = RequestMethod.POST)
    public ServerResponse<Map<String,Object>> SelectNoticeTime(@ApiParam("过站保障按钮事件")
                                                                   @RequestParam("flightId") String flightId,@RequestParam("ename") String ename,
                                                                   HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("ename",ename);
        queryMap.put("flightId",flightId);
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        list = prcsSupervisionService.selectNoticeTime(queryMap);

        return ServerResponse.createBySuccess(list.get(0));
    }


    @ApiOperation(httpMethod = "POST", value = "过站保障任务节点调度通知信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findSchedulingNoticeInfo.json", method = RequestMethod.POST)
    public ServerResponse<List<String>> findSchedulingNoticeInfo(@ApiParam("过站保障任务节点调度通知信息")
                                                            @RequestParam("flightId") String flightId,
                                                            @RequestParam("ename") String ename,
                                                            @RequestParam("cname") String cname,
                                                            @RequestParam("flno") String flno,
                                                            HttpServletRequest request) {
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String employeeId = "Admin";
        if(sysUser != null){
            employeeId = sysUser.getEmployeeId();
        }
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("employeeId",employeeId);
        queryMap.put("flightId",flightId);
        queryMap.put("flno",flno);
        queryMap.put("ename",ename);
        queryMap.put("cname",cname);
        return ServerResponse.createBySuccess(prcsSupervisionService.findSchedulingNoticeInfo(queryMap));
    }

}
