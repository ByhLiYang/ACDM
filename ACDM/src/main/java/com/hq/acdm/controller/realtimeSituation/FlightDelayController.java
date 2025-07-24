package com.hq.acdm.controller.realtimeSituation;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.realtimeSituation.FlightDelayService;
import com.hq.acdm.service.realtimeSituation.FlightIndexService;
import com.hq.acdm.service.rscMonitors.RealtimeStandService;
import com.hq.acdm.vo.realtimeSituation.*;
import com.hq.acdm.vo.rscMonitors.BaseStand;
import com.hq.acdm.vo.rscMonitors.StandStatusVo;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/25 11:09
 * @Description
 */
@Api(description = "延误态势")
@RestController
@RequestMapping("/realtimeSituation/flightDelay")
public class FlightDelayController {
    @Resource
    private FlightDelayService flightDelayService;
    @Resource
    private FlightIndexService flightIndexService;
    @Resource
    private RealtimeStandService realtimeStandService;

    @ApiOperation(httpMethod = "POST", value = "延误态势", produces = MediaType.APPLICATION_JSON_VALUE)
        @RequestMapping(value = "/getDelayRlsIdx.json", method = RequestMethod.POST)
    public ServerResponse<FlightDelayVo> getDelayRlsIdx(@ApiParam("延误态势")
                                                            @RequestBody String AddDataObject) {
        String startTime="";
        String endTime="";
        JSONArray jsonArray = null;
        Date today=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String now=format.format(today);
        FlightDelayVo returnVo=new FlightDelayVo();
        SPassengersVo svo=new SPassengersVo();//滞留旅客
        String h="";
        int starts=0;
        int ends=0;
        try {
            JSONObject json=new JSONObject(AddDataObject);
            jsonArray = json.getJSONArray("times");
            for(int i=0 ; i < jsonArray.length() ;i++) {
                h=jsonArray.get(i)+"";
                if(h.length()==1)h="0"+h;
                if(i==0){
                    startTime=now+h+"0000";
                    starts=Integer.parseInt(h);
                }else if(i==jsonArray.length()-1) {
                    endTime=now+h+"5959";
                    ends=Integer.parseInt(h);
                }
            }
            int aa=0;
            String [] pa=new String [ends-starts+1];
            for (int i = starts; i <= ends; i++) {
                h=i+"";
                if(h.length()==1)h="0"+h;
                pa[aa]=h;
                aa++;
            }
            Map<String, Object> queryMap = new HashMap<>();
            queryMap.put("startTime",startTime);
            queryMap.put("endTime",endTime);
            //returnVo=flightDelayService.getDelayRlsIdx(queryMap);//放行正常率
            svo=flightDelayService.findSPassengersCount(pa);//滞留旅客
            returnVo.setTimese(pa);
            if (svo!=null){
                //滞留
                returnVo.setCountEOne(svo.getCountEOne());
                returnVo.setCountETwo(svo.getCountETwo());
                returnVo.setCountWOne(svo.getCountWOne());
                returnVo.setCountWTwo(svo.getCountWTwo());
                returnVo.setCountEAll(svo.getCountEAll());
            }
            FDelayVo fvo=flightDelayService.findDelayTimeCount(queryMap);//航班延误次数
            int [] count=new int[5];
            count[0]=fvo!=null?fvo.getCount0():0;
            count[1]=fvo!=null?fvo.getCount1():0;
            count[2]=fvo!=null?fvo.getCount2():0;
            count[3]=fvo!=null?fvo.getCount3():0;
            count[4]=fvo!=null?fvo.getCount4():0;
            returnVo.setCount(count);
            //积压
            BackVo bv=flightDelayService.findAllFlight(pa);
            if(bv!=null){
                returnVo.setCountEHours(bv.getCountEHours());
                returnVo.setCountETotal(bv.getCountETotal());
                returnVo.setCountAll(bv.getCountAll());
            }
            //每小时平均等待分钟
//            int [] countAVG=flightDelayService.getAvgWaitTime(pa);
//            returnVo.setCountAVG(countAVG);

            //各航司滞留旅客占比率
            FlightDelayVo SS=flightDelayService.findDelayRetentionP(queryMap);
            returnVo.setDf(SS.getDf());
            returnVo.setDh(SS.getDh());
            returnVo.setNh(SS.getNh());
            returnVo.setGh(SS.getGh());
            //实况航班总览指标
            queryMap.put("dept","");
            queryMap.put("agent","");
            FlightHandTerminalVo fhtv = flightIndexService.findFltToHandTerminal(queryMap);
            fhtv.setJwzs(realtimeStandService.findJWZS());
            fhtv.setBkys(realtimeStandService.findBKYS());
            fhtv.setJrtc(realtimeStandService.findJRTC());
            fhtv.setGyhb(realtimeStandService.findGYHB());
            List<StandStatusVo> list = realtimeStandService.findStandInfo();
            List<BaseStand> baseList = realtimeStandService.findBaseStand();
            int JJWZS = 0;
            int YJWZS = 0;
            int JJWZY = 0;
            int YJWZY = 0;
            int CQZY = 0;
            int BZY = 0;
            int BZS = 0;
            int CZY = 0;
            int CZS = 0;
            int DZY = 0;
            int DZS = 0;
            int EZY = 0;
            int EZS = 0;
            int FZY = 0;
            int FZS = 0;
            for (int i = 0; i < list.size(); i++) {
                if ("1".equals(list.get(i).getStatus())){
                    CQZY++;
                }
                if ("1".equals(list.get(i).getStatus())||"3".equals(list.get(i).getStatus())){
                    for (int j = 0; j < baseList.size(); j++) {
                        if (list.get(i).getStand().equals(baseList.get(j).getStand())){
                            if ("Y".equals(baseList.get(j).getIsremote())){
                                YJWZY++;
                            }else{
                                JJWZY++;
                            }
                            if (null!=baseList.get(j).getType()&&"B".equals(baseList.get(j).getType())){
                                BZY++;
                            }else if (null!=baseList.get(j).getType()&&"C".equals(baseList.get(j).getType())){
                                CZY++;
                            }else if (null!=baseList.get(j).getType()&&"D".equals(baseList.get(j).getType())){
                                DZY++;
                            }else if (null!=baseList.get(j).getType()&&"E".equals(baseList.get(j).getType())){
                                EZY++;
                            }else if (null!=baseList.get(j).getType()&&"F".equals(baseList.get(j).getType())){
                                FZY++;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < baseList.size(); i++) {
                if ("Y".equals(baseList.get(i).getIsremote())){
                    YJWZS++;
                }else{
                    JJWZS++;
                }
                if (null!=baseList.get(i).getType()&&"B".equals(baseList.get(i).getType())){
                    BZS++;
                }else if (null!=baseList.get(i).getType()&&"C".equals(baseList.get(i).getType())){
                    CZS++;
                }else if (null!=baseList.get(i).getType()&&"D".equals(baseList.get(i).getType())){
                    DZS++;
                }else if (null!=baseList.get(i).getType()&&"E".equals(baseList.get(i).getType())){
                    EZS++;
                }else if (null!=baseList.get(i).getType()&&"F".equals(baseList.get(i).getType())){
                    FZS++;
                }
            }
            fhtv.setCqzy(CQZY);
            fhtv.setJjwzy(JJWZY);
            fhtv.setJjwzs(JJWZS);
            fhtv.setYjwzy(YJWZY);
            fhtv.setYjwzs(YJWZS);
            fhtv.setBzy(BZY);
            fhtv.setBsy(BZS-BZY);
            fhtv.setCzy(CZY);
            fhtv.setCsy(CZS-CZY);
            fhtv.setDzy(DZY);
            fhtv.setDsy(DZS-DZY);
            fhtv.setEzy(EZY);
            fhtv.setEsy(EZS-EZY);
            fhtv.setFzy(FZY);
            fhtv.setFsy(FZS-FZY);

            returnVo.setJwzs(fhtv.getJwzs());
            returnVo.setBkys(fhtv.getBkys());
            returnVo.setCqzy(fhtv.getCqzy());
            returnVo.setJjwzy(fhtv.getJjwzy());
            returnVo.setJjwzs(fhtv.getJjwzs());
            returnVo.setJrtc(fhtv.getJrtc());
            returnVo.setSyjw(fhtv.getSyjw());
            returnVo.setGyhb(fhtv.getGyhb());
            returnVo.setYjwzy(fhtv.getYjwzy());
            returnVo.setYjwzs(fhtv.getYjwzs());
            returnVo.setBzy(fhtv.getBzy());
            returnVo.setBsy(fhtv.getBsy());
            returnVo.setCzy(fhtv.getCzy());
            returnVo.setCsy(fhtv.getCsy());
            returnVo.setDzy(fhtv.getDzy());
            returnVo.setDsy(fhtv.getDsy());
            returnVo.setEzy(fhtv.getEzy());
            returnVo.setEsy(fhtv.getEsy());
            returnVo.setFzy(fhtv.getFzy());
            returnVo.setFsy(fhtv.getFsy());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess(returnVo);
    }

    @ApiOperation(httpMethod = "GET", value = "旅客分布热力图", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getTmdmcDgrm.json", method = RequestMethod.GET)
    public ServerResponse getTmdmcDgrm() {
        List<TmdmcDgrmVo> list = flightDelayService.findTmdmcDgrm();
        Map<String, Object> resultMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getArea().endsWith("A")||list.get(i).getArea().endsWith("B")){
                if (resultMap.containsKey(list.get(i).getArea().replace("A","").replace("B",""))){
                    resultMap.put("g"+list.get(i).getArea().replace("A","").replace("B",""),
                            (Integer)resultMap.get(list.get(i).getArea().replace("A","").replace("B",""))+Integer.parseInt(list.get(i).getNum()));
                }
            }
            resultMap.put("g"+list.get(i).getArea(),list.get(i).getNum());
        }
        return ServerResponse.createBySuccess(resultMap);
    }

    @ApiOperation(httpMethod = "GET", value = "旅客分布热力图", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getFloorPsgCount.json", method = RequestMethod.GET)
    public ServerResponse getFloorPsgCount() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("F1",flightDelayService.findPsgCountByFloor("1F"));
        resultMap.put("F2",flightDelayService.findPsgCountByFloor("2F"));
        resultMap.put("F4",flightDelayService.findPsgCountByFloor("4F"));
        return ServerResponse.createBySuccess(resultMap);
    }

    @ApiOperation(httpMethod = "GET", value = "机场承载能力信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAirportBearerInfo.json", method = RequestMethod.GET)
    public ServerResponse findAirportBearerInfo() {
        Map<String,Object> resultMap = flightDelayService.findAirportBearerInfo();
        return ServerResponse.createBySuccess(resultMap);
    }
}
