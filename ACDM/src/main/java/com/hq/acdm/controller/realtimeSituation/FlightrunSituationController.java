package com.hq.acdm.controller.realtimeSituation;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.realtimeSituation.TSectionWt;
import com.hq.acdm.service.realtimeSituation.FlightrunSituationService;
import com.hq.acdm.vo.realtimeSituation.FlightrunSituationVo;
import com.hq.acdm.model.realtimeSituation.TRunwayMode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/25 11:24
 * @Description
 */
@Api(description = "跑道运行模式信息")
@RestController
@RequestMapping("/realtimeSituation/flightrunSituation")
public class FlightrunSituationController {

    @Resource
    private FlightrunSituationService flightrunSituationService;

    @ApiOperation(httpMethod = "GET", value = "跑道运行模式信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findRunwayModeInfo.json", method = RequestMethod.GET)
    public ServerResponse findSpecialFltInfo(@ApiParam("跑道运行模式信息")
                                                     HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> queryMap = new HashMap<>();
        List<TRunwayMode> listTRunwayMode = flightrunSituationService.findRunwayModeInfo(queryMap);
        List<FlightrunSituationVo> list = new ArrayList<FlightrunSituationVo>();
        FlightrunSituationVo vo = new FlightrunSituationVo();
        if(listTRunwayMode != null && listTRunwayMode.size()>0){
            for (int i=0;i<listTRunwayMode.size();i++){
                TRunwayMode  mode = listTRunwayMode.get(i);
                if(mode.getType().equals("DEP")){
                    vo.setRunwayDep(mode.getRunway());
                }
                if(mode.getType().equals("ARR")){
                    vo.setRunwayArr(mode.getRunway());
                }
            }
            list.add(vo);
        }
        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "POST", value = "飞行区运行情况保存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertTSectionWt.json", method = RequestMethod.POST)
    public ServerResponse insertTSectionWt(@ApiParam("飞行区运行情况保存")
                                           @RequestParam("section") String section,
                                           @RequestParam("visb") String visb,
                                           @RequestParam("wspd") String wspd,
                                           @RequestParam("wdrt") String wdrt,
                                           @RequestParam("cbht") String cbht,
                                           HttpServletRequest request, HttpServletResponse response) {
        TSectionWt sw = new TSectionWt();
        sw.setId((UUID.randomUUID().toString().replaceAll("-","")));
        sw.setSection(section);
        sw.setVisb(visb);
        sw.setWspd(wspd);
        sw.setWdrt(wdrt);
        sw.setCbht(cbht);
        return ServerResponse.createBySuccess(flightrunSituationService.insert(sw));
    }

    @ApiOperation(httpMethod = "POST", value = "飞行区运行情况修改", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateByPrimaryKey.json", method = RequestMethod.POST)
    public ServerResponse updateByPrimaryKey(@ApiParam("飞行区运行情况修改")
                                                 @RequestParam("data") String data) {
        int count = 0;
        try {
            JSONArray jsonArray = new  JSONArray(data);
            for(int i=0 ; i < jsonArray.length() ;i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                TSectionWt sw = new TSectionWt();
                sw.setId(obj.getString("id"));
                sw.setSection(obj.getString("section"));
                sw.setVisb(obj.getString("visb"));
                sw.setWspd(obj.getString("wspd"));
                sw.setWdrt(obj.getString("wdrt"));
                sw.setCbht(obj.getString("cbht"));
                count += flightrunSituationService.updateByPrimaryKey(sw);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ServerResponse.createBySuccess(count);
    }

    @ApiOperation(httpMethod = "POST", value = "飞行区运行情况删除", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByPrimaryKey.json", method = RequestMethod.POST)
    public ServerResponse deleteByPrimaryKey(@ApiParam("飞行区运行情况修改")
                                             @RequestParam("id") String id,
                                             HttpServletRequest request, HttpServletResponse response) {

        return ServerResponse.createBySuccess(flightrunSituationService.deleteByPrimaryKey(id));
    }


    @ApiOperation(httpMethod = "POST", value = "飞行区运行情况查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectAllTSectionWt.json", method = RequestMethod.POST)
    public ServerResponse selectAllTSectionWt(@ApiParam("飞行区运行情况查询")
                                             HttpServletRequest request, HttpServletResponse response) {

        return ServerResponse.createBySuccess(flightrunSituationService.selectAllTSectionWt());
    }

    @ApiOperation(httpMethod = "POST", value = "修改跑道", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateRunway.json", method = RequestMethod.POST)
    public ServerResponse updateRunway(@ApiParam("修改跑道")
                                          @RequestBody String AddDataObject) {
        TRunwayMode recod=new TRunwayMode();
        JSONArray jsonArray = null;

        StringBuilder str =new StringBuilder();
        try {
            JSONObject j=new JSONObject(AddDataObject);
            jsonArray = j.getJSONArray("runwayDep");
            for(int i=0 ; i < jsonArray.length() ;i++) {
                if(i==jsonArray.length()-1){
                    str.append((String)jsonArray.get(i)) ;
                }else {
                    str.append((String)jsonArray.get(i)+",");
                }
            }
          //  System.out.println(str+"----------runwayDep------------");
            recod.setRunway(str.toString());
            recod.setType("DEP");
            flightrunSituationService.updateRunway(recod);
            if(!recod.getRunway().contains(",")){
                flightrunSituationService.updateRunwayD(recod);
            }else {
                recod.setRunway(null);
                flightrunSituationService.updateRunwayD(recod);
            }
            str.setLength(0);
            jsonArray = j.getJSONArray("runwayArr");
            for(int i=0 ; i < jsonArray.length() ;i++) {
                if(i==jsonArray.length()-1){
                    str.append((String)jsonArray.get(i)) ;
                }else {
                    str.append((String)jsonArray.get(i)+",");
                }
            }
            //System.out.println(str+"---------runwayArr-------------");
            recod.setRunway(str.toString());
            recod.setType("ARR");
            flightrunSituationService.updateRunway(recod);
            if(!recod.getRunway().contains(",")){
                flightrunSituationService.updateRunwayA(recod);
            }else {
                recod.setRunway(null);
                flightrunSituationService.updateRunwayA(recod);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "飞行区运行情况查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findRunwayAllInfo.json", method = RequestMethod.GET)
    public ServerResponse findRunwayAllInfo(HttpServletRequest request, HttpServletResponse response) {

        return ServerResponse.createBySuccess(flightrunSituationService.findRunwayAllInfo());
    }


    @ApiOperation(httpMethod = "POST", value = "飞行区运行情况修改", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateRunwayAllInfo.json", method = RequestMethod.POST)
    public ServerResponse updateRunwayAllInfo(@RequestBody String data,
                                                HttpServletRequest request, HttpServletResponse response) {
        int count = 0;
        String id = "";
        String mode = "";
        String status = "";
        String state = "";
        String dep = "";
        String arr = "";
        String capacity = "";
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(data);
            id = jsonObject.getString("id").equals("null") ? "" : jsonObject.getString("id");
            mode = jsonObject.getString("mode").equals("null") ? "" : jsonObject.getString("mode");
            status = jsonObject.getString("status").equals("null") ? "" : jsonObject.getString("status");
            state = jsonObject.getString("state").equals("null") ? "" : jsonObject.getString("state");
            dep = jsonObject.getString("dep").equals("null") ? "" : jsonObject.getString("dep");
            arr = jsonObject.getString("arr").equals("null") ? "" : jsonObject.getString("arr");
            capacity = jsonObject.getString("capacity").equals("null") ? "" : jsonObject.getString("capacity");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("id",id);
        queryMap.put("mode",mode);
        queryMap.put("status",status);
        queryMap.put("state",state);
        queryMap.put("dep",dep);
        queryMap.put("arr",arr);
        queryMap.put("capacity",capacity);
        count = flightrunSituationService.updateRunwayAllInfo(queryMap);
        return ServerResponse.createBySuccess(count);
    }

}
