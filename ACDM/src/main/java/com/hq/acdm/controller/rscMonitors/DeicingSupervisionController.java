package com.hq.acdm.controller.rscMonitors;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.rscMonitors.DeicingSupervisionService;
import com.hq.acdm.service.rscMonitors.RealtimeStandService;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.rscMonitors.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/04/28 16:21
 * @Description
 */
@Api(description = "除冰监管")
@RestController
@RequestMapping("/rscMonitors/deicingSupervision")
public class DeicingSupervisionController {
    @Resource
    private DeicingSupervisionService deicingSupervisionService;
    @Resource
    private SysCacheService sysCacheService;

    @ApiOperation(httpMethod = "POST", value = "待除冰航班", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDeicingWait.json", method = RequestMethod.POST)
    public ServerResponse<List<DeicingWaitVo>> findDeicingWait() {
        return ServerResponse.createBySuccess(deicingSupervisionService.findDeicingWait());
    }

    @ApiOperation(httpMethod = "POST", value = "正在除冰航班", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDeicingNow.json", method = RequestMethod.POST)
    public ServerResponse<List<DeicingNowVo>> findDeicingNow() {
        return ServerResponse.createBySuccess(deicingSupervisionService.findDeicingNow());
    }

    @ApiOperation(httpMethod = "POST", value = "已除冰航班", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDeicingOver.json", method = RequestMethod.POST)
    public ServerResponse<List<DeicingOverVo>> findDeicingOver() {
        return ServerResponse.createBySuccess(deicingSupervisionService.findDeicingOver());
    }

    @ApiOperation(httpMethod = "GET", value = "除冰信息除冰位及除冰车", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDeicingInfo.json", method = RequestMethod.GET)
    public ServerResponse<List<DeicingInfoVo>> findDeicingInfo() {
        return ServerResponse.createBySuccess(deicingSupervisionService.findDeicingInfo());
    }

    @ApiOperation(httpMethod = "POST", value = "添加除冰航班", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updDeicingFlt.json", method = RequestMethod.POST)
    public ServerResponse findDeicingInfo(@ApiParam("航班ID") @RequestParam("flightId") String flightId,
                                          @ApiParam("除冰标记") @RequestParam("flag") String flag,
                                          HttpServletRequest request, HttpServletResponse response) {
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String userId = "";
        if (null!=sysUser){
            userId=sysUser.getUserId();
        }
        return ServerResponse.createBySuccess(deicingSupervisionService.updateDeicingFlt(userId,flag,flightId));
    }


    @ApiOperation(httpMethod = "POST", value = "修改除冰信息除冰位", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateDeicingBit.json", method = RequestMethod.POST)
    public ServerResponse updateDeicingBit(@ApiParam("修改除冰数") @RequestBody String number) {
        JSONObject j= null;
        String numberStr = "0";
        try {
            j = new JSONObject(number);
            numberStr = j.getString("number");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess(deicingSupervisionService.updateDeicingBit(numberStr));
    }

    @ApiOperation(httpMethod = "POST", value = "修改除冰信息除冰车", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateDeicingCar.json", method = RequestMethod.POST)
    public ServerResponse updateDeicingCar(@ApiParam("修改除冰数") @RequestBody String number) {
        JSONObject j= null;
        String numberStr = "0";
        try {
            j = new JSONObject(number);
            numberStr = j.getString("number");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess(deicingSupervisionService.updateDeicingCar(numberStr));
    }

    @ApiOperation(httpMethod = "GET", value = "每小时除冰航班图", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDeicingEChartData.json", method = RequestMethod.GET)
    public ServerResponse findDeicingEChartData() {
        return ServerResponse.createBySuccess(deicingSupervisionService.findDeicingEChartData());
    }

    @ApiOperation(httpMethod = "GET", value = "除冰资源数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDeicingResourcesData.json", method = RequestMethod.GET)
    public ServerResponse findDeicingResourcesData() {
        return ServerResponse.createBySuccess(deicingSupervisionService.findDeicingResourcesData());
    }


    @ApiOperation(httpMethod = "POST", value = "添加修改除冰跑道信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateDeicingRunwayData.json", method = RequestMethod.POST)
    public ServerResponse updateDeicingRunwayData(@ApiParam("添加修改除冰跑道信息")
                                                  @RequestParam("execDate") String execDate,
                                                  @RequestParam("duration04r") String duration04r,
                                                  @RequestParam("num04r") String num04r,
                                                  @RequestParam("duration04l") String duration04l,
                                                  @RequestParam("num04l") String num04l) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("duration04r",duration04r);
        queryMap.put("num04r",num04r);
        queryMap.put("duration04l",duration04l);
        queryMap.put("num04l",num04l);
        queryMap.put("execDate",execDate);
        queryMap.put("updateTime",new Date());

        int i = 0;
        DeicingRunwayVo vo = deicingSupervisionService.findDeicingRunwayData(queryMap);
        if(vo != null){
            i = deicingSupervisionService.updateDeicingRunwayData(queryMap);
        }else{
            queryMap.put("id", UUID.randomUUID().toString().replaceAll("-",""));
            i = deicingSupervisionService.insertDeicingRunwayData(queryMap);
        }


        return ServerResponse.createBySuccess(i);
    }


    @ApiOperation(httpMethod = "POST", value = "查询除冰跑道信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDeicingRunwayData.json", method = RequestMethod.POST)
    public ServerResponse findDeicingRunwayData(@ApiParam("查询除冰跑道信息")
                                                  @RequestParam("execDate") String execDate) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("execDate",execDate);
        return ServerResponse.createBySuccess(deicingSupervisionService.findDeicingRunwayData(queryMap));
    }


    @ApiOperation(httpMethod = "POST", value = "新增或修改除冰液信息包括除冰液和除冰车", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateDeicingFluidByFlightId.json", method = RequestMethod.POST)
    public ServerResponse updateDeicingFluidByFlightId(
                            @ApiParam("航班ID号") @RequestParam("flightId") String flightId,
                            @ApiParam("除冰液") @RequestParam("deicingFluid") String deicingFluid,
                            @ApiParam("除冰车") @RequestParam("deicingCar") String deicingCar) {

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("flightId",flightId);
        queryMap.put("deicingFluid",deicingFluid);
        queryMap.put("deicingCar",deicingCar);

        int i = 0;
        DeicingFluidVo vo = deicingSupervisionService.selectDeicingFluidByFlightId(queryMap);
        if(vo != null){
           i = deicingSupervisionService.updateDeicingFluidByFlightId(queryMap);
        }else{
           queryMap.put("id",UUID.randomUUID().toString().replaceAll("-",""));
           i = deicingSupervisionService.insertDeicingFluidByFlightId(queryMap);
        }

        return ServerResponse.createBySuccess(i);
    }

    @ApiOperation(httpMethod = "GET", value = "查询除冰车状态信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectDeicingCarInfo.json", method = RequestMethod.GET)
    public ServerResponse<List<DeicingCarVo>> selectDeicingCarInfo() {
        return ServerResponse.createBySuccess(deicingSupervisionService.selectDeicingCarInfo());
    }

    @ApiOperation(httpMethod = "POST", value = "查询车辆轨迹", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findVehicleTracks.json", method = RequestMethod.POST)
    public ServerResponse findVehicleTracks(@ApiParam("查询车辆轨迹")  @RequestParam("startTime") String startTime,
                                             @RequestParam("endTime") String endTime,
                                             @RequestParam("vehicleNo") String vehicleNo) {
        JSONObject j= null;
        String numberStr = "0";
        Map<String,Object> map = new HashMap<>();

            map.put("startTime",startTime);
            map.put("endTime",endTime);
            if (StringUtil.isNotEmpty(vehicleNo)){
                map.put("vehicleNo",vehicleNo);
                List<String> list =new ArrayList();
                String nos[]=vehicleNo.split(",");
                for (int i = 0; i <nos.length ; i++) {
                    list.add(nos[i]);
                }
                map.put("list",list);
            }


        return ServerResponse.createBySuccess(deicingSupervisionService.selectTVehicleTracksInfo(map));
    }
    @ApiOperation(httpMethod = "POST", value = "查询最近车辆号", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findLatelyVehicleTracks.json", method = RequestMethod.POST)
    public ServerResponse findLatelyVehicleTracks() {
        JSONObject j= null;
        String numberStr = "0";
        Map<String,Object> map = new HashMap<>();



        return ServerResponse.createBySuccess(deicingSupervisionService.findLatelyVehicleTracks(map));
    }

    @ApiOperation(httpMethod = "POST", value = "查询最近车辆号", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectTVehicleTracksInfoGroupBy3.json", method = RequestMethod.POST)
    public ServerResponse selectTVehicleTracksInfoGroupBy3() {
        JSONObject j= null;
        String numberStr = "0";
        Map<String,Object> map = new HashMap<>();



        return ServerResponse.createBySuccess(deicingSupervisionService.selectTVehicleTracksInfoGroupBy3(map));
    }
}
