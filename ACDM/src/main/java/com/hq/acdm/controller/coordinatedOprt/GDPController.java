package com.hq.acdm.controller.coordinatedOprt;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.coordinatedOprt.GDPService;
import com.hq.acdm.vo.coordinatedOprt.GDPNumVo;
import com.hq.acdm.vo.coordinatedOprt.GDPPostponeCKVo;
import com.hq.acdm.vo.coordinatedOprt.GDPPostponeVo;
import com.hq.acdm.vo.coordinatedOprt.GDPVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/07/04 13:58
 * @Description
 */
@Api(description = "GDP")
@RestController
@RequestMapping("/coordinatedOprt/GDP")
public class GDPController {
    @Resource
    private GDPService gDPService;

    @ApiOperation(httpMethod = "GET", value = "GDP查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getGDPChat.json", method = RequestMethod.GET)
    public ServerResponse getDelayRlsIdx(HttpServletRequest request, HttpServletResponse response){
//      查询GDP对象
        List<GDPVo> listOri = gDPService.findGDPChat();
//        总进港小时均值（小时航班计划数之和）
        int zHBS = 0;
        int zYDG = 0;
        int zYQF = 0;
        int zXY2 = 0;
        int zDY2 = 0;
//        GDP柱状图数据对象
        GDPNumVo gDPNumVo = new GDPNumVo();
        List<Integer> hBSList = new ArrayList<>();
        List<Integer> yDGList = new ArrayList<>();
        List<Integer> yQFList = new ArrayList<>();
        List<Integer> xY2List = new ArrayList<>();
        List<Integer> dY2List = new ArrayList<>();
        for (int i = 0 ; i < 24; i++){
            hBSList.add(0);
            yDGList.add(0);
            yQFList.add(0);
            xY2List.add(0);
            dY2List.add(0);
        }
        for (int i = 0; i < listOri.size(); i++) {
            zHBS=zHBS+Integer.parseInt(listOri.get(i).getHBS());
            zYDG=zYDG+Integer.parseInt(listOri.get(i).getYDG());
            zYQF=zYQF+Integer.parseInt(listOri.get(i).getYQF());
            zXY2=zXY2+Integer.parseInt(listOri.get(i).getXY2());
            zDY2=zDY2+Integer.parseInt(listOri.get(i).getDY2());
            if (Integer.parseInt(listOri.get(i).getTIME_H())>=6&&Integer.parseInt(listOri.get(i).getTIME_H())<=23){
                hBSList.set(Integer.parseInt(listOri.get(i).getTIME_H())-6,Integer.parseInt(listOri.get(i).getHBS()));
                yDGList.set(Integer.parseInt(listOri.get(i).getTIME_H())-6,Integer.parseInt(listOri.get(i).getYDG()));
                yQFList.set(Integer.parseInt(listOri.get(i).getTIME_H())-6,Integer.parseInt(listOri.get(i).getYQF()));
                xY2List.set(Integer.parseInt(listOri.get(i).getTIME_H())-6,Integer.parseInt(listOri.get(i).getXY2()));
                dY2List.set(Integer.parseInt(listOri.get(i).getTIME_H())-6,Integer.parseInt(listOri.get(i).getDY2()));
            }else if(Integer.parseInt(listOri.get(i).getTIME_H())>=0&&Integer.parseInt(listOri.get(i).getTIME_H())<=5){
                hBSList.set(Integer.parseInt(listOri.get(i).getTIME_H())+18,Integer.parseInt(listOri.get(i).getHBS()));
                yDGList.set(Integer.parseInt(listOri.get(i).getTIME_H())+18,Integer.parseInt(listOri.get(i).getYDG()));
                yQFList.set(Integer.parseInt(listOri.get(i).getTIME_H())+18,Integer.parseInt(listOri.get(i).getYQF()));
                xY2List.set(Integer.parseInt(listOri.get(i).getTIME_H())+18,Integer.parseInt(listOri.get(i).getXY2()));
                dY2List.set(Integer.parseInt(listOri.get(i).getTIME_H())+18,Integer.parseInt(listOri.get(i).getDY2()));
            }
        }
        gDPNumVo.setHBS(hBSList);
        gDPNumVo.setYDG(yDGList);
        gDPNumVo.setYQF(yQFList);
        gDPNumVo.setXY2(xY2List);
        gDPNumVo.setDY2(dY2List);
        List<Map<String,String>> listResult = new ArrayList<>();
        Map<String,String> tempMap1 = new HashMap<>();
        tempMap1.put("sk","进港小时均值");
        tempMap1.put("hj",""+zHBS);
        Map<String,String> tempMap2 = new HashMap<>();
        tempMap2.put("sk","已到港");
        tempMap2.put("hj",""+zYDG);
        Map<String,String> tempMap3 = new HashMap<>();
        tempMap3.put("sk","前站已起飞");
        tempMap3.put("hj",""+zYQF);
        Map<String,String> tempMap4 = new HashMap<>();
        tempMap4.put("sk","前场计划≦2H");
        tempMap4.put("hj",""+zXY2);
        Map<String,String> tempMap5 = new HashMap<>();
        tempMap5.put("sk","前场计划>2H");
        tempMap5.put("hj",""+zDY2);

        for (int i = 0; i < 24; i++) {
            if (i<10){
                tempMap1.put("h0"+i,"0");
                tempMap2.put("h0"+i,"0");
                tempMap3.put("h0"+i,"0");
                tempMap4.put("h0"+i,"0");
                tempMap5.put("h0"+i,"0");
            }else{
                tempMap1.put("h"+i,"0");
                tempMap2.put("h"+i,"0");
                tempMap3.put("h"+i,"0");
                tempMap4.put("h"+i,"0");
                tempMap5.put("h"+i,"0");
            }
        }
        for (int i = 0; i < listOri.size(); i++) {
            tempMap1.put("h"+listOri.get(i).getTIME_H(),listOri.get(i).getHBS());
            tempMap2.put("h"+listOri.get(i).getTIME_H(),listOri.get(i).getYDG());
            tempMap3.put("h"+listOri.get(i).getTIME_H(),listOri.get(i).getYQF());
            tempMap4.put("h"+listOri.get(i).getTIME_H(),listOri.get(i).getXY2());
            tempMap5.put("h"+listOri.get(i).getTIME_H(),listOri.get(i).getDY2());
        }
        listResult.add(tempMap1);
        listResult.add(tempMap2);
        listResult.add(tempMap3);
        listResult.add(tempMap4);
        listResult.add(tempMap5);

        Map<String,Object> map = new HashMap<>();
        map.put("gDPNumVo",gDPNumVo);
        map.put("listGDPChat",listResult);
        return ServerResponse.createBySuccess(map);
    }

    @ApiOperation(httpMethod = "POST", value = "航班暂缓操作", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/setPostpone.json")
    public ServerResponse setFlightCuts(@ApiParam("用户登录信息") @RequestBody String AddDataObject) throws JSONException {
        JSONObject j=new JSONObject(AddDataObject);
        String flightId = j.getString("flightId");
        String optFlag = j.getString("optFlag");
        String content=j.optString("content");
        gDPService.updatePostpone(flightId,optFlag,content);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "前站计划", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getQCJH.json", method = RequestMethod.GET)
    public ServerResponse<List<GDPPostponeVo>> getQCJH() {
        return ServerResponse.createBySuccess(gDPService.findQCJH());
    }

    @ApiOperation(httpMethod = "GET", value = "前站已起飞", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getQCYQF.json", method = RequestMethod.GET)
    public ServerResponse<List<GDPPostponeVo>> getQCYQF() {
        return ServerResponse.createBySuccess(gDPService.findQCYQF());
    }

    @ApiOperation(httpMethod = "GET", value = "暂缓值机查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getZHZJ.json", method = RequestMethod.GET)
    public ServerResponse<List<GDPPostponeCKVo>> getZHZJ() {
        return ServerResponse.createBySuccess(gDPService.findZHZJ());
    }

    @ApiOperation(httpMethod = "GET", value = "恢复值机查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getHFZJ.json", method = RequestMethod.GET)
    public ServerResponse<List<GDPPostponeCKVo>> getHFZJ() {
        return ServerResponse.createBySuccess(gDPService.findHFZJ());
    }


}
