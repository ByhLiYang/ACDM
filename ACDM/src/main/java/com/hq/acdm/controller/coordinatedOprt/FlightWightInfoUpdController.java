package com.hq.acdm.controller.coordinatedOprt;

import com.alibaba.fastjson.JSON;
import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.coordinatedOprt.DelayPrejudgeService;
import com.hq.acdm.service.coordinatedOprt.FlightWightInfoUpdService;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.vo.coordinatedOprt.*;
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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "航班货邮行订坐信息修改")
@RestController
@RequestMapping("/coordinatedOprt/flightWightInfoUpd")
public class FlightWightInfoUpdController {

    @Resource
    private FlightWightInfoUpdService flightWightInfoUpdService;

    @Resource
    private SysCacheService sysCacheService;

    @ApiOperation(httpMethod = "POST", value = "航班货邮行订坐信息查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFligthInfo.json", method = RequestMethod.POST)
    public ServerResponse findFligthInfo(@RequestParam("startDate") String startDate,
                                         @RequestParam("endDate") String endDate,
                                         @RequestParam("flno") String flno) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("flno",flno);
        List<FlightWightInfoUpdVo> voList = flightWightInfoUpdService.findFligthInfo(queryMap);
        return ServerResponse.createBySuccess(voList);
    }

    @ApiOperation(httpMethod = "POST", value = "航班货邮行订坐信息修改", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateFltGoodsMailBagBookingWight.json", method = RequestMethod.POST)
    public ServerResponse updateFltGoodsMailBagBookingWight(@RequestBody String data) {
        String flightIdA = "";
        String flightIdD = "";
        String cargoWeightA = "";
        String cargoWeightD = "";
        String mailWeightA = "";
        String mailWeightD = "";
        String bagWeightA = "";
        String bagWeightD = "";
        String reservationsA = "";
        String reservationsD = "";
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(data);
            flightIdA = jsonObject.getString("flightIdA").equals("null") ? null : jsonObject.getString("flightIdA");
            flightIdD = jsonObject.getString("flightIdD").equals("null") ? null : jsonObject.getString("flightIdD");
            cargoWeightA = jsonObject.getString("cargoWeightA").equals("null") ? null : jsonObject.getString("cargoWeightA");
            cargoWeightD = jsonObject.getString("cargoWeightD").equals("null") ? null : jsonObject.getString("cargoWeightD");
            mailWeightA = jsonObject.getString("mailWeightA").equals("null") ? null : jsonObject.getString("mailWeightA");
            mailWeightD = jsonObject.getString("mailWeightD").equals("null") ? null : jsonObject.getString("mailWeightD");
            bagWeightA = jsonObject.getString("bagWeightA").equals("null") ? null : jsonObject.getString("bagWeightA");
            bagWeightD = jsonObject.getString("bagWeightD").equals("null") ? null : jsonObject.getString("bagWeightD");
            reservationsA = jsonObject.getString("reservationsA").equals("null") ? null : jsonObject.getString("reservationsA");
            reservationsD = jsonObject.getString("reservationsD").equals("null") ? null : jsonObject.getString("reservationsD");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int count = 0;
        int i = 0;
        int j = 0;
        Map<String, Object> queryMapA = new HashMap<>();
        queryMapA.put("flightId",flightIdA);
        queryMapA.put("cargoWeight",cargoWeightA);
        queryMapA.put("mailWeight",mailWeightA);
        queryMapA.put("bagWeight",bagWeightA);
        queryMapA.put("reservations",reservationsA);
        if(flightIdA != null){
            i = flightWightInfoUpdService.updateFltGoodsMailBagBookingWight(queryMapA);
            if(i==0){
                i = flightWightInfoUpdService.updateFltHisGoodsMailBagBookingWight(queryMapA);
            }
        }
        Map<String, Object> queryMapD = new HashMap<>();
        queryMapD.put("flightId",flightIdD);
        queryMapD.put("cargoWeight",cargoWeightD);
        queryMapD.put("mailWeight",mailWeightD);
        queryMapD.put("bagWeight",bagWeightD);
        queryMapD.put("reservations",reservationsD);
        if(flightIdD != null){
            j = flightWightInfoUpdService.updateFltGoodsMailBagBookingWight(queryMapD);
            if(j==0){
                j = flightWightInfoUpdService.updateFltHisGoodsMailBagBookingWight(queryMapD);
            }
        }
        count = i+j;
        return ServerResponse.createBySuccess(count);
    }

    @RequestMapping(value = "/findInterfaceInfo.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "获取接口监控信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse findInterfaceInfo(@ApiParam("获取接口监控信息") @RequestBody String AddDataObject,
                                         HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

        JSONArray jsonArray = null;
        JSONObject j=new JSONObject(AddDataObject);
        String fname = j.getString("fname");

        Map<String, Object> queryMap = new HashMap<>();

        queryMap.put("fname",fname);
        List<InterFaceVo> voList = flightWightInfoUpdService.findInterfaceInfo(queryMap);
        return ServerResponse.createBySuccess(voList);

    }

    @RequestMapping(value = "/findDateManagerInfo.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "获取数据管理信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse findDateManagerInfo(@ApiParam("获取数据管理信息") @RequestBody String AddDataObject,
                                            HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

        JSONArray jsonArray = null;
        JSONObject j=new JSONObject(AddDataObject);
        String fname = j.optString("dname");

        Map<String, Object> queryMap = new HashMap<>();

        queryMap.put("dname",fname);
        List<DateManagerVo> voList = flightWightInfoUpdService.findDateManagerInfo(queryMap);
        return ServerResponse.createBySuccess(voList);

    }

    @RequestMapping(value = "/updDateManagerInfo.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "修改数据管理信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse updDateManagerInfo(@ApiParam("修改数据管理信息") @RequestBody String AddDataObject,
                                              HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {


        JSONObject j=new JSONObject(AddDataObject);

        DateManagerVo bus=new DateManagerVo();
        bus= JSON.parseObject(j.toString(),DateManagerVo.class);


        int i = flightWightInfoUpdService.updDateManagerInfo(bus);
        return ServerResponse.createBySuccess(i);

    }

    @RequestMapping(value = "/insDateManagerInfo.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "新增数据管理信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse insDateManagerInfo(@ApiParam("新增数据管理信息") @RequestBody String AddDataObject,
                                             HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {


        JSONObject j=new JSONObject(AddDataObject);

        DateManagerVo bus=new DateManagerVo();
        bus= JSON.parseObject(j.toString(),DateManagerVo.class);


        int i = flightWightInfoUpdService.insDateManagerInfo(bus);
        return ServerResponse.createBySuccess(i);

    }

    @RequestMapping(value = "/delDateManagerInfo.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "删除数据管理信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse delDateManagerInfo(@ApiParam("删除数据管理信息") @RequestBody String AddDataObject,
                                             HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {


        JSONArray jsonArray = null;
        JSONObject j=new JSONObject(AddDataObject);
        String fname = j.getString("id");

        Map<String, Object> queryMap = new HashMap<>();

        queryMap.put("id",fname);


        int i = flightWightInfoUpdService.delDateManagerInfo(queryMap);
        return ServerResponse.createBySuccess(i);

    }


    @RequestMapping(value = "/findAirLineInfo.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "获取航司基础信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse findAirLineInfo(@ApiParam("获取航司基础信息") @RequestBody String AddDataObject,
                                              HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

        JSONArray jsonArray = null;
        JSONObject j=new JSONObject(AddDataObject);
        String gjz = j.optString("gjz");
        String qy = j.optString("qy");
        Map<String, Object> queryMap = new HashMap<>();

        queryMap.put("gjz",gjz);
        queryMap.put("qy",qy);
        queryMap.put("isDelete","0");
        List<AirLineVo> voList = flightWightInfoUpdService.findAirLineInfo(queryMap);
        return ServerResponse.createBySuccess(voList);

    }

    @RequestMapping(value = "/updAirLineInfo.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "修改航司基础信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse updAirLineInfo(@ApiParam("修改航司基础信息") @RequestBody String AddDataObject,
                                             HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

        Users sysUser =null;
        try {
            String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
            String cacheValue = sysCacheService.getFromCache(loginToken);
            sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
            });
        }catch (Exception ex){}

        String createUsr = "";
        if (null!=sysUser){
            createUsr=sysUser.getUserId();
        }else {
            //return ServerResponse.createByLoginExpire();
        }
        JSONObject j=new JSONObject(AddDataObject);

        AirLineVo bus=new AirLineVo();
        bus= JSON.parseObject(j.toString(),AirLineVo.class);
        bus.setIsDelete("0");
        bus.setCreateUsr(createUsr);
        bus.setUpdateUsr(createUsr);
        int i = flightWightInfoUpdService.updAirLineInfo(bus);
        return ServerResponse.createBySuccess(i);

    }

    @RequestMapping(value = "/insAirLineInfo.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "新增航司基础信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse insAirLineInfo(@ApiParam("新增航司基础信息") @RequestBody String AddDataObject,
                                             HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {


        Users sysUser =null;
        try {
            String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
            String cacheValue = sysCacheService.getFromCache(loginToken);
            sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
            });
        }catch (Exception ex){}

        String createUsr = "";
        if (null!=sysUser){
            createUsr=sysUser.getUserId();
        }else {
            //return ServerResponse.createByLoginExpire();
        }
        JSONObject j=new JSONObject(AddDataObject);

        AirLineVo bus=new AirLineVo();
        bus= JSON.parseObject(j.toString(),AirLineVo.class);
        bus.setIsDelete("0");
        bus.setCreateUsr(createUsr);
        bus.setUpdateUsr(createUsr);
        Map<String, Object> queryMap = new HashMap<>();

        queryMap.put("twoCharCd",bus.getTwoCharCd());
        //queryMap.put("isDelete","0");
        List<AirLineVo> voList = flightWightInfoUpdService.findAirLineInfo(queryMap);
        boolean istwo0=false;
        int aa=0;
        if (voList!=null&&voList.size()>0){
            for (int i = 0; i <voList.size() ; i++) {
                if ("0".equals(voList.get(i).getIsDelete())){
                    istwo0=true;
                }
            }
            if (istwo0){
                return ServerResponse.createByParamError("二字码已存在");
            }else {
                aa= flightWightInfoUpdService.updAirLineInfo(bus);
            }

        }else {
            aa=flightWightInfoUpdService.insAirLineInfo(bus);
        }

        return ServerResponse.createBySuccess(aa);

    }

    @RequestMapping(value = "/delAirLineInfo.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "删除航司基础信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse delAirLineInfo(@ApiParam("删除航司基础信息") @RequestBody String AddDataObject,
                                             HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

        Users sysUser =null;
        try {
            String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
            String cacheValue = sysCacheService.getFromCache(loginToken);
            sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
            });
        }catch (Exception ex){}

        String createUsr = "";
        if (null!=sysUser){
            createUsr=sysUser.getUserId();
        }else {
            //return ServerResponse.createByLoginExpire();
        }
        JSONObject j=new JSONObject(AddDataObject);

        AirLineVo bus=new AirLineVo();
        bus= JSON.parseObject(j.toString(),AirLineVo.class);
        bus.setIsDelete("1");
        bus.setCreateUsr(createUsr);
        bus.setUpdateUsr(createUsr);
        int i = flightWightInfoUpdService.updAirLineInfo(bus);
        return ServerResponse.createBySuccess(i);

    }

    }
