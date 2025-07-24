package com.hq.acdm.controller.coordinatedOprt;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.coordinatedOprt.FlightCutsService;
import com.hq.acdm.util.ConstantUtil;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.util.excel.JxlsBuilder;
import com.hq.acdm.vo.coordinatedOprt.*;
import com.hq.acdm.vo.dynamicFlight.TLocalFlightInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.ArrayStack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/06/12 10:25
 * @Description
 */
@Api(description = "航班削减")
@RestController
@RequestMapping("/coordinatedOprt/flightCuts")
public class FlightCutsController {
    @Resource
    private FlightCutsService flightCutsService;

    @ApiOperation(httpMethod = "POST", value = "航班削减查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getCutFlights.json", method = RequestMethod.POST)
    public ServerResponse getDelayRlsIdx(@ApiParam("起始时间") @RequestParam("startDate") String startDate,
                                         @ApiParam("结束时间") @RequestParam("endDate") String endDate,
                                         @ApiParam("是否取消") @RequestParam("cancel") String cancel,
                                         @ApiParam("目的地") @RequestParam("destination") String destination,
                                         @ApiParam("是否执行") @RequestParam("execute") String execute,
                                         @ApiParam("航空公司") @RequestParam("airCompany") String airCompany,
                                         @ApiParam("通行量下降百分比") @RequestParam("downPercentage") String downPercentage,
                                         @ApiParam("架次") @RequestParam("downPerHour") String downPerHour,
                                         HttpServletRequest request, HttpServletResponse response) throws ParseException {
        //判断是否为取消航班
        if("false".equals(cancel)){
            cancel = "0";
        }else if("true".equals(cancel)){
            cancel = "1";
        }
        //判断是否为已执行航班
        if("false".equals(execute)){
            execute = "0";
        }else if("true".equals(execute)){
            execute = "1";
        }
        //判断航空公司
        List<String> airCompanyModify = new ArrayList<>();
        //判断目的地
        List<String> mudidi = new ArrayList<>();
        if(airCompany.length()>0){
            String[] airCompany_arr = airCompany.substring(0,airCompany.length()).split(",");
            for(int i=0;i<airCompany_arr.length;i++){
                String[] temp = airCompany_arr[i].split("/");
                for (int j=0;j<temp.length;j++){
                    airCompanyModify.add(temp[j]);
                }
            }
        }
        if(destination.length()>0){
            String[] mudidi_arr = destination.substring(0,destination.length()).split(",");
            for(int i=0;i<mudidi_arr.length;i++){
                mudidi.add(mudidi_arr[i]);
            }
        }
//        查询条件集合
        Map<Object,Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("cancel",cancel);
        queryMap.put("destinationList",mudidi);
        queryMap.put("execute",execute);
        queryMap.put("airCompanyList",airCompanyModify);
//        查询计划航班
        List<FlightCutsVo> list = flightCutsService.findCutFlights(queryMap);
        StatisticalInfoVo jhhbs = new StatisticalInfoVo();
        StatisticalInfoVo jhsxj = new StatisticalInfoVo();
        StatisticalInfoVo jhaxj = new StatisticalInfoVo();
        StatisticalInfoVo sjaxj = new StatisticalInfoVo();
        StatisticalInfoVo sjatz = new StatisticalInfoVo();
        jhhbs.setOperationType("计划航班数");
        jhsxj.setOperationType("计划应削减");
        jhaxj.setOperationType("计划已削减");
        sjaxj.setOperationType("实际已削减");
        sjatz.setOperationType("计划已调整");
        int jhhbs1=0;
        int jhhbs2=0;
        int jhhbs3=0;
        int jhhbs9=0;

        Double jhsxj1=0.0;
        Double jhsxj2=0.0;
        Double jhsxj3=0.0;
        Double jhsxj9=0.0;

        int jhaxj1=0;
        int jhaxj2=0;
        int jhaxj3=0;
        int jhaxj9=0;

        int sjyxj1=0;
        int sjyxj2=0;
        int sjyxj3=0;
        int sjyxj9=0;

        int sjatz1=0;
        int sjatz2=0;
        int sjatz3=0;
        int sjatz9=0;
//以小时为key，放入以SOBT排序好的FltCutsHourVo对象
        Map<String,List<FltCutsHourVo>> seqMap = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            if ("MU".equals(list.get(i).getAIRLINES())||"FM".equals(list.get(i).getAIRLINES())){
//                计划航班数
                jhhbs1++;
                if ("1".equals(list.get(i).getYYJ())){
//                    实际已削减
                    sjyxj1++;
                }
                if("1".equals(list.get(i).getJHXJ())){
//                    计划已削减
                    jhaxj1++;
                }
                if("2".equals(list.get(i).getJHXJ())){
//                    计划已调整
                    sjatz1++;
                }
            }else if ("CA".equals(list.get(i).getAIRLINES())||"ZH".equals(list.get(i).getAIRLINES())){
                jhhbs2++;
                if ("1".equals(list.get(i).getYYJ())){
                    sjyxj2++;
                }
                if("1".equals(list.get(i).getJHXJ())){
                    jhaxj2++;
                }
                if("2".equals(list.get(i).getJHXJ())){
//                    计划已调整
                    sjatz2++;
                }
            }else if ("CZ".equals(list.get(i).getAIRLINES())||"OQ".equals(list.get(i).getAIRLINES())){
                jhhbs3++;
                if ("1".equals(list.get(i).getYYJ())){
                    sjyxj3++;
                }
                if("1".equals(list.get(i).getJHXJ())){
                    jhaxj3++;
                }
                if("2".equals(list.get(i).getJHXJ())){
//                    计划已调整
                    sjatz3++;
                }
            }else{
                jhhbs9++;
                if ("1".equals(list.get(i).getYYJ())){
                    sjyxj9++;
                }
                if("1".equals(list.get(i).getJHXJ())){
                    jhaxj9++;
                }
                if("2".equals(list.get(i).getJHXJ())){
//                    计划已调整
                    sjatz9++;
                }
            }
//            将计划航班放入TreeMap，用于后面计算
            FltCutsHourVo fchv = new FltCutsHourVo();
            fchv.setFlight_id(list.get(i).getFLIGHT_ID());
            fchv.setFlight_name(list.get(i).getFLNO());
            fchv.setStatus(list.get(i).getJHXJ());
            fchv.setSobt(DateTimeUtil.timeDayFormatByStr(list.get(i).getSOBT()));
            if (seqMap.containsKey(DateTimeUtil.getHour(list.get(i).getSOBT()))){
                seqMap.get(DateTimeUtil.getHour(list.get(i).getSOBT())).add(fchv);
            }else{
                List<FltCutsHourVo> fchvList = new ArrayList<>();
                fchvList.add(fchv);
                seqMap.put(DateTimeUtil.getHour(list.get(i).getSOBT()),fchvList);
            }
        }
//      各小时一个航班对象放一个map对象作为页面的一列
        List<Map<String, FltCutsHourVo>> results = new ArrayList<>();
//        小时最大航班数
        int hourMax = 0 ;
//        按小时削减列头信息
        List<String> hours = new ArrayList<>();
        for (String key : seqMap.keySet()){
            hours.add(key);
            if (seqMap.get(key).size()>hourMax){
                hourMax=seqMap.get(key).size();
            }
        }
//        按小时削减航班计算
        for (int i = 0; i < hourMax; i++) {
            Map<String, FltCutsHourVo> tempMap = new HashMap<>();
            for (String key: seqMap.keySet()){
                if (seqMap.get(key).size()>i){
                    tempMap.put(key,seqMap.get(key).get(i));
                }else{
                    FltCutsHourVo fch = new FltCutsHourVo();
                    fch.setFlight_id("");
                    fch.setFlight_name("");
                    fch.setStatus("");
                    fch.setSobt("");
                    tempMap.put(key,fch);
                }
            }
            results.add(tempMap);
        }

        jhhbs.setMu(String.valueOf(jhhbs1));
        jhhbs.setCa(String.valueOf(jhhbs2));
        jhhbs.setCz(String.valueOf(jhhbs3));
        jhhbs.setDf(String.valueOf(jhhbs9));
        jhhbs.setTotal(String.valueOf(list.size()));
//        计划应削减总数
        double jhsxjTt = 0;
        if (!"".equals(downPerHour)){
            for (String key : seqMap.keySet()){
                if (Integer.parseInt(downPerHour)<seqMap.get(key).size()){
                    jhsxjTt=jhsxjTt+(seqMap.get(key).size()-Integer.parseInt(downPerHour));
                }
            }
            jhsxj1=new BigDecimal(jhsxjTt*(jhhbs1*1.00/list.size())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            jhsxj2=new BigDecimal(jhsxjTt*(jhhbs2*1.00/list.size())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            jhsxj3=new BigDecimal(jhsxjTt*(jhhbs3*1.00/list.size())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            jhsxj9=new BigDecimal(jhsxjTt*(jhhbs9*1.00/list.size())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }else if(!"".equals(downPercentage)){
            jhsxj1=new BigDecimal(jhhbs1*(Double.parseDouble(downPercentage)/100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            jhsxj2=new BigDecimal(jhhbs2*(Double.parseDouble(downPercentage)/100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            jhsxj3=new BigDecimal(jhhbs3*(Double.parseDouble(downPercentage)/100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            jhsxj9=new BigDecimal(jhhbs9*(Double.parseDouble(downPercentage)/100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            jhsxjTt=new BigDecimal(jhsxj1+jhsxj2+jhsxj3+jhsxj9).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        jhsxj.setMu(String.valueOf(jhsxj1));
        jhsxj.setCa(String.valueOf(jhsxj2));
        jhsxj.setCz(String.valueOf(jhsxj3));
        jhsxj.setDf(String.valueOf(jhsxj9));
        jhsxj.setTotal(String.valueOf(jhsxjTt));

        jhaxj.setMu(String.valueOf(jhaxj1));
        jhaxj.setCa(String.valueOf(jhaxj2));
        jhaxj.setCz(String.valueOf(jhaxj3));
        jhaxj.setDf(String.valueOf(jhaxj9));
        jhaxj.setTotal(String.valueOf(jhaxj1+jhaxj2+jhaxj3+jhaxj9));

        sjaxj.setMu(String.valueOf(sjyxj1));
        sjaxj.setCa(String.valueOf(sjyxj2));
        sjaxj.setCz(String.valueOf(sjyxj3));
        sjaxj.setDf(String.valueOf(sjyxj9));
        sjaxj.setTotal(String.valueOf(sjyxj1+sjyxj2+sjyxj3+sjyxj9));

        sjatz.setMu(String.valueOf(sjatz1));
        sjatz.setCa(String.valueOf(sjatz2));
        sjatz.setCz(String.valueOf(sjatz3));
        sjatz.setDf(String.valueOf(sjatz9));
        sjatz.setTotal(String.valueOf(sjatz1+sjatz2+sjatz3+sjatz9));

        Map<String,Object> map = new HashMap<>();
        for (FlightCutsVo fchv : list){
            fchv.setSOBT(DateTimeUtil.timeDayFormatByStr(fchv.getSOBT()));
            fchv.setN_SOBT(DateTimeUtil.timeDayFormatByStr(fchv.getN_SOBT()));
        }
        map.put("xjxq",list);
        map.put("jhhbs",jhhbs);
        map.put("jhsxj",jhsxj);
        map.put("jhaxj",jhaxj);
        map.put("sjaxj",sjaxj);
        map.put("sjatz",sjatz);
        map.put("results",results);
        map.put("hours",hours);
        return ServerResponse.createBySuccess(map);
    }

    @ApiOperation(httpMethod = "POST", value = "航班削减操作", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/setFlightCuts.json")
    public ServerResponse setFlightCuts(@ApiParam("航班标识") @RequestParam(value = "flightId") String flightId,@ApiParam("削减标记") @RequestParam(value = "optFlag") String optFlag) {
        flightCutsService.updateFlightCuts(flightId,optFlag);
        return ServerResponse.createBySuccess();
    }
    @ApiOperation(httpMethod = "POST", value = "航班调整操作", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/setFlightChgs.json")
    public ServerResponse setFlightChgs(@ApiParam("航班标识") @RequestParam(value = "flightId") String flightId,
                                        @ApiParam("调整标记") @RequestParam(value = "optFlag") String optFlag,
                                        @ApiParam("调整时间") @RequestParam(value = "nsobt") String nsobt) {
        flightCutsService.updateFlightCuts(flightId,optFlag,nsobt);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "预计航班削减查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getFlightScheduling.json", method = RequestMethod.POST)
    public ServerResponse getFlightScheduling(@ApiParam("起始时间") @RequestParam("startDate") String startDate,
                                         @ApiParam("结束时间") @RequestParam("endDate") String endDate,
                                         @ApiParam("航空公司") @RequestParam("airCompany") String airCompany,
                                         @ApiParam("通行量下降百分比") @RequestParam("downPercentage") String downPercentage,
                                         @ApiParam("架次") @RequestParam("downPerHour") String downPerHour,
                                         HttpServletRequest request, HttpServletResponse response) throws ParseException {

        //判断航空公司
        List<String> airCompanyModify = new ArrayList<>();
        String condition = "";
        //用户为地服用户时，设置查询条件

        if (airCompany.contains("IGO")){
            condition= ConstantUtil.IGO+",";
        }
        //用户为国航用户时，设置查询条件
        if (airCompany.contains("CCA")){
            if (airCompany.contains("IGO")){
                condition=condition.replace(ConstantUtil.CCA+",","");
            }else
            condition+= ConstantUtil.CCA+",";
        }
        //用户为南航用户时，设置查询条件
        if (airCompany.contains("CSN")){
            if (airCompany.contains("IGO")){
                condition=condition.replace(ConstantUtil.CSN+",","");
            }else
                condition+= ConstantUtil.CSN+",";
        }
        //用户为东航用户时，设置查询条件
        if (airCompany.contains("CES")){
            if (airCompany.contains("IGO")){
                condition=condition.replace(ConstantUtil.CES+",","");
            }else
                condition+= ConstantUtil.CES+",";
        }
        if (airCompany.contains("IGO")&&airCompany.contains("CSN")&&airCompany.contains("CCA")&&airCompany.contains("CES")){
            airCompany= "";
        }
        if (airCompany.contains("IGO")){
            airCompany= "IGO";
        }
        if (!"".equals(condition)){
            condition=condition.substring(0,condition.length()-1);
        }


//        查询条件集合
        Map<Object,Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("agent",airCompany);
        queryMap.put("dept",airCompany);
        queryMap.put("agentSys",condition);
//        查询计划航班
        List<TFlightScheduling> list = flightCutsService.findFlightScheduling(queryMap);
        TFlightSchedulingVo ttvo=new TFlightSchedulingVo();
        ttvo.setHour("总计");
        ttvo.setCcaAvos(new ArrayList<TFlightScheduling>());
        ttvo.setCcaDvos(new ArrayList<TFlightScheduling>());
        ttvo.setCcaSUMvos(new ArrayList<TFlightScheduling>());
        ttvo.setCsnAvos(new ArrayList<TFlightScheduling>());
        ttvo.setCsnDvos(new ArrayList<TFlightScheduling>());
        ttvo.setCsnSUMvos(new ArrayList<TFlightScheduling>());

        ttvo.setCesAvos(new ArrayList<TFlightScheduling>());
        ttvo.setCesDvos(new ArrayList<TFlightScheduling>());
        ttvo.setCesSUMvos(new ArrayList<TFlightScheduling>());

        ttvo.setIgoAvos(new ArrayList<TFlightScheduling>());
        ttvo.setIgoDvos(new ArrayList<TFlightScheduling>());
        ttvo.setIgoSUMvos(new ArrayList<TFlightScheduling>());

        ttvo.setSumvos(new ArrayList<TFlightScheduling>());
        Map<String, TFlightSchedulingVo> maps = new TreeMap<>();
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        SimpleDateFormat yFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //把查询出来的值按小时分组计算值放进map
        for (int i = 0; i < list.size(); i++) {

            TFlightScheduling vo=list.get(i);
            Date siso=DateTimeUtil.strToDate(vo.getFptt());
            Boolean dora=true;
            if ("A".equals(vo.getFlio())){
                siso=DateTimeUtil.strToDate(vo.getFplt());
                dora=false;
            }
            TFlightSchedulingVo rvo=new TFlightSchedulingVo();
            if (maps.containsKey(hourFormat.format(siso))){
                rvo=maps.get(hourFormat.format(siso));
            }else{
                rvo=new TFlightSchedulingVo();
                rvo.setExdt(vo.getExdt());
                rvo.setHour(hourFormat.format(siso));
                rvo.setCcaACount(0);
                rvo.setCcaDCount(0);
                rvo.setCcaSUMCount(0);
                rvo.setCcaAvos(new ArrayList<TFlightScheduling>());
                rvo.setCcaDvos(new ArrayList<TFlightScheduling>());
                rvo.setCcaSUMvos(new ArrayList<TFlightScheduling>());
                rvo.setCsnACount(0);
                rvo.setCsnDCount(0);
                rvo.setCsnSUMCount(0);
                rvo.setCsnAvos(new ArrayList<TFlightScheduling>());
                rvo.setCsnDvos(new ArrayList<TFlightScheduling>());
                rvo.setCsnSUMvos(new ArrayList<TFlightScheduling>());
                rvo.setCesACount(0);
                rvo.setCesDCount(0);
                rvo.setCesSUMCount(0);
                rvo.setCesAvos(new ArrayList<TFlightScheduling>());
                rvo.setCesDvos(new ArrayList<TFlightScheduling>());
                rvo.setCesSUMvos(new ArrayList<TFlightScheduling>());
                rvo.setIgoACount(0);
                rvo.setIgoDCount(0);
                rvo.setIgoSUMCount(0);
                rvo.setIgoAvos(new ArrayList<TFlightScheduling>());
                rvo.setIgoDvos(new ArrayList<TFlightScheduling>());
                rvo.setIgoSUMvos(new ArrayList<TFlightScheduling>());
                rvo.setSum(0);
                rvo.setSumvos(new ArrayList<TFlightScheduling>());
                rvo.setXj(0);
            }

            if (ConstantUtil.CCA.contains(vo.getAwcd())){
                if (dora){
                    rvo.setCcaDCount(rvo.getCcaDCount()+1);
                    rvo.getCcaDvos().add(vo);
                    ttvo.getCcaDvos().add(vo);

                }else {
                    rvo.getCcaAvos().add(vo);
                    ttvo.getCcaAvos().add(vo);
                    rvo.setCcaACount(rvo.getCcaACount()+1);
                }
                rvo.getCcaSUMvos().add(vo);
                ttvo.getCcaSUMvos().add(vo);
                rvo.setCcaSUMCount(rvo.getCcaDCount()+rvo.getCcaACount());
            }
            if (ConstantUtil.CSN.contains(vo.getAwcd())){
                if (dora){
                    rvo.setCsnDCount(rvo.getCsnDCount()+1);
                    rvo.getCsnDvos().add(vo);
                    ttvo.getCsnDvos().add(vo);
                }else {
                    rvo.setCsnACount(rvo.getCsnACount()+1);
                    rvo.getCsnAvos().add(vo);
                    ttvo.getCsnAvos().add(vo);
                }
                rvo.getCsnSUMvos().add(vo);
                ttvo.getCsnSUMvos().add(vo);
                rvo.setCsnSUMCount(rvo.getCsnDCount()+rvo.getCsnACount());
            }
            if (ConstantUtil.CES.contains(vo.getAwcd())){
                if (dora){
                    rvo.setCesDCount(rvo.getCesDCount()+1);
                    rvo.getCesDvos().add(vo);
                    ttvo.getCesDvos().add(vo);
                }else {
                    rvo.setCesACount(rvo.getCesACount()+1);
                    rvo.getCesAvos().add(vo);
                    ttvo.getCesAvos().add(vo);
                }
                rvo.getCesSUMvos().add(vo);
                ttvo.getCesSUMvos().add(vo);
                rvo.setCesSUMCount(rvo.getCesDCount()+rvo.getCesACount());
            }
            if (!ConstantUtil.IGO.contains(vo.getAwcd())){
                if (dora){
                    rvo.setIgoDCount(rvo.getIgoDCount()+1);
                    rvo.getIgoDvos().add(vo);
                    ttvo.getIgoDvos().add(vo);
                }else {
                    rvo.setIgoACount(rvo.getIgoACount()+1);
                    rvo.getIgoAvos().add(vo);
                    ttvo.getIgoAvos().add(vo);
                }
                rvo.getIgoSUMvos().add(vo);
                ttvo.getIgoSUMvos().add(vo);
                rvo.setIgoSUMCount(rvo.getIgoDCount()+rvo.getIgoACount());
            }
            rvo.getSumvos().add(vo);
            ttvo.getSumvos().add(vo);
            rvo.setSum(rvo.getCcaSUMCount()+rvo.getCsnSUMCount()+rvo.getCesSUMCount()+rvo.getIgoSUMCount());
            maps.put(hourFormat.format(siso),rvo);
        }
        //把map里面的对象放进list
        List<TFlightSchedulingVo> rilist=new ArrayList<TFlightSchedulingVo>();
        for (String key: maps.keySet()){
            rilist.add(maps.get(key));
            System.out.println("keycuts:"+key);
        }
        //总数实体类

        for (int i = 0; i <rilist.size() ; i++) {

            TFlightSchedulingVo tvo=rilist.get(i);
            ttvo.setCcaACount(ttvo.getCcaACount()+tvo.getCcaACount());
            ttvo.setCcaDCount(ttvo.getCcaDCount()+tvo.getCcaDCount());
            ttvo.setCcaSUMCount(ttvo.getCcaSUMCount()+tvo.getCcaSUMCount());


            ttvo.setCsnACount(ttvo.getCsnACount()+tvo.getCsnACount());
            ttvo.setCsnDCount(ttvo.getCsnDCount()+tvo.getCsnDCount());
            ttvo.setCsnSUMCount(ttvo.getCsnSUMCount()+tvo.getCsnSUMCount());

            ttvo.setCesACount(ttvo.getCesACount()+tvo.getCesACount());
            ttvo.setCesDCount(ttvo.getCesDCount()+tvo.getCesDCount());
            ttvo.setCesSUMCount(ttvo.getCesSUMCount()+tvo.getCesSUMCount());

            ttvo.setIgoACount(ttvo.getIgoACount()+tvo.getIgoACount());
            ttvo.setIgoDCount(ttvo.getIgoDCount()+tvo.getIgoDCount());
            ttvo.setIgoSUMCount(ttvo.getIgoSUMCount()+tvo.getIgoSUMCount());
            ttvo.setSum(ttvo.getSum()+tvo.getSum());
            ttvo.setXj(0);
            ttvo.setCcaxj(0);
            ttvo.setCsnxj(0);
            ttvo.setCesxj(0);
            ttvo.setIgoxj(0);

        }

    //  计划应削减总数
        int jhsxjTt = 0;
        if (!"".equals(downPerHour)){

            for (int i = 0; i <rilist.size() ; i++) {
                TFlightSchedulingVo tvo=rilist.get(i);
             jhsxjTt=tvo.getSum()-Integer.parseInt(downPerHour);
                if (jhsxjTt>0){


                     tvo.setXj(jhsxjTt);
                     tvo.setCcaxj(new BigDecimal(tvo.getXj()*(tvo.getCcaSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                     tvo.setCsnxj(new BigDecimal(tvo.getXj()*(tvo.getCsnSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                     tvo.setCesxj(new BigDecimal(tvo.getXj()*(tvo.getCesSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                     tvo.setIgoxj(new BigDecimal(tvo.getXj()*(tvo.getIgoSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());

                    ttvo.setXj(ttvo.getXj()+tvo.getXj());
                    ttvo.setCcaxj(ttvo.getCcaxj()+tvo.getCcaxj());
                    ttvo.setCsnxj(ttvo.getCsnxj()+tvo.getCsnxj());
                    ttvo.setCesxj(ttvo.getCesxj()+tvo.getCesxj());
                    ttvo.setIgoxj(ttvo.getIgoxj()+tvo.getIgoxj());
                 }
             }

        }else if(!"".equals(downPercentage)){
            for (int i = 0; i <rilist.size() ; i++) {
                TFlightSchedulingVo tvo = rilist.get(i);
                tvo.setXj(new BigDecimal(tvo.getSum()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setCcaxj(new BigDecimal(tvo.getCcaSUMCount()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setCsnxj(new BigDecimal(tvo.getCsnSUMCount()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setCesxj(new BigDecimal(tvo.getCesSUMCount()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setIgoxj(new BigDecimal(tvo.getIgoSUMCount()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setDownPercentage(downPercentage);
                ttvo.setXj(ttvo.getXj()+tvo.getXj());
                ttvo.setCcaxj(ttvo.getCcaxj()+tvo.getCcaxj());
                ttvo.setCsnxj(ttvo.getCsnxj()+tvo.getCsnxj());
                ttvo.setCesxj(ttvo.getCesxj()+tvo.getCesxj());
                ttvo.setIgoxj(ttvo.getIgoxj()+tvo.getIgoxj());
            }
            ttvo.setDownPercentage(downPercentage);
           // ttvo.setXj(new BigDecimal(ttvo.getSum()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());

        }
        ttvo.setXj(new BigDecimal(ttvo.getXj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        ttvo.setCcaxj(new BigDecimal(ttvo.getCcaxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        ttvo.setCsnxj(new BigDecimal(ttvo.getCsnxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        ttvo.setCesxj(new BigDecimal(ttvo.getCesxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        ttvo.setIgoxj(new BigDecimal(ttvo.getIgoxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        rilist.add(ttvo);

        for (int i = 0; i <rilist.size() ; i++) {
            TFlightSchedulingVo tvo = rilist.get(i);
            tvo.setCcaZX(new BigDecimal(tvo.getCcaSUMCount()-tvo.getCcaxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            tvo.setCsnZX(new BigDecimal(tvo.getCsnSUMCount()-tvo.getCsnxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            tvo.setCesZX(new BigDecimal(tvo.getCesSUMCount()-tvo.getCesxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            tvo.setIgoZX(new BigDecimal(tvo.getIgoSUMCount()-tvo.getIgoxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            tvo.setSumZX(new BigDecimal(tvo.getSum()-tvo.getXj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        return ServerResponse.createBySuccess(rilist);
    }

    @ApiOperation(httpMethod = "POST", value = "航班调减柱状图", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getFcutsHistogram.json", method = RequestMethod.POST)
    public ServerResponse getFcutsHistogram(@ApiParam("起始时间") @RequestParam("startDate") String startDate,
                                              @ApiParam("结束时间") @RequestParam("endDate") String endDate,
                                              @ApiParam("航空公司") @RequestParam("airCompany") String airCompany,
                                              @ApiParam("通行量下降百分比") @RequestParam("downPercentage") String downPercentage,
                                              @ApiParam("架次") @RequestParam("downPerHour") String downPerHour,
                                              HttpServletRequest request, HttpServletResponse response) throws ParseException {

        //判断航空公司
        List<String> airCompanyModify = new ArrayList<>();
        String condition = "";
        //用户为地服用户时，设置查询条件

        if (airCompany.contains("IGO")){
            condition= ConstantUtil.IGO+",";
        }
        //用户为国航用户时，设置查询条件
        if (airCompany.contains("CCA")){
            if (airCompany.contains("IGO")){
                condition=condition.replace(ConstantUtil.CCA+",","");
            }else
                condition+= ConstantUtil.CCA+",";
        }
        //用户为南航用户时，设置查询条件
        if (airCompany.contains("CSN")){
            if (airCompany.contains("IGO")){
                condition=condition.replace(ConstantUtil.CSN+",","");
            }else
                condition+= ConstantUtil.CSN+",";
        }
        //用户为东航用户时，设置查询条件
        if (airCompany.contains("CES")){
            if (airCompany.contains("IGO")){
                condition=condition.replace(ConstantUtil.CES+",","");
            }else
                condition+= ConstantUtil.CES+",";
        }
        if (airCompany.contains("IGO")&&airCompany.contains("CSN")&&airCompany.contains("CCA")&&airCompany.contains("CES")){
            airCompany= "";
        }
        if (airCompany.contains("IGO")){
            airCompany= "IGO";
        }
        if (!"".equals(condition)){
            condition=condition.substring(0,condition.length()-1);
        }


//        查询条件集合
        Map<Object,Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("agent",airCompany);
        queryMap.put("dept",airCompany);
        queryMap.put("agentSys",condition);
//        查询计划航班
        List<TFlightScheduling> list = flightCutsService.findFlightScheduling(queryMap);
        TFlightSchedulingVo ttvo=new TFlightSchedulingVo();
        ttvo.setHour("总计");
        ttvo.setCcaAvos(new ArrayList<TFlightScheduling>());
        ttvo.setCcaDvos(new ArrayList<TFlightScheduling>());
        ttvo.setCcaSUMvos(new ArrayList<TFlightScheduling>());
        ttvo.setCsnAvos(new ArrayList<TFlightScheduling>());
        ttvo.setCsnDvos(new ArrayList<TFlightScheduling>());
        ttvo.setCsnSUMvos(new ArrayList<TFlightScheduling>());

        ttvo.setCesAvos(new ArrayList<TFlightScheduling>());
        ttvo.setCesDvos(new ArrayList<TFlightScheduling>());
        ttvo.setCesSUMvos(new ArrayList<TFlightScheduling>());

        ttvo.setIgoAvos(new ArrayList<TFlightScheduling>());
        ttvo.setIgoDvos(new ArrayList<TFlightScheduling>());
        ttvo.setIgoSUMvos(new ArrayList<TFlightScheduling>());

        ttvo.setSumvos(new ArrayList<TFlightScheduling>());
        Map<String, TFlightSchedulingVo> maps = new TreeMap<>();
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        SimpleDateFormat yFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //把查询出来的值按小时分组计算值放进map
        for (int i = 0; i < list.size(); i++) {

            TFlightScheduling vo=list.get(i);
            Date siso=DateTimeUtil.strToDate(vo.getFptt());
            Boolean dora=true;
            if ("A".equals(vo.getFlio())){
                siso=DateTimeUtil.strToDate(vo.getFplt());
                dora=false;
            }
            TFlightSchedulingVo rvo=new TFlightSchedulingVo();
            if (maps.containsKey(hourFormat.format(siso))){
                rvo=maps.get(hourFormat.format(siso));
            }else{
                rvo=new TFlightSchedulingVo();
                rvo.setExdt(vo.getExdt());
                rvo.setHour(hourFormat.format(siso));
                rvo.setCcaACount(0);
                rvo.setCcaDCount(0);
                rvo.setCcaSUMCount(0);
                rvo.setCcaAvos(new ArrayList<TFlightScheduling>());
                rvo.setCcaDvos(new ArrayList<TFlightScheduling>());
                rvo.setCcaSUMvos(new ArrayList<TFlightScheduling>());
                rvo.setCsnACount(0);
                rvo.setCsnDCount(0);
                rvo.setCsnSUMCount(0);
                rvo.setCsnAvos(new ArrayList<TFlightScheduling>());
                rvo.setCsnDvos(new ArrayList<TFlightScheduling>());
                rvo.setCsnSUMvos(new ArrayList<TFlightScheduling>());
                rvo.setCesACount(0);
                rvo.setCesDCount(0);
                rvo.setCesSUMCount(0);
                rvo.setCesAvos(new ArrayList<TFlightScheduling>());
                rvo.setCesDvos(new ArrayList<TFlightScheduling>());
                rvo.setCesSUMvos(new ArrayList<TFlightScheduling>());
                rvo.setIgoACount(0);
                rvo.setIgoDCount(0);
                rvo.setIgoSUMCount(0);
                rvo.setIgoAvos(new ArrayList<TFlightScheduling>());
                rvo.setIgoDvos(new ArrayList<TFlightScheduling>());
                rvo.setIgoSUMvos(new ArrayList<TFlightScheduling>());
                rvo.setSum(0);
                rvo.setSumvos(new ArrayList<TFlightScheduling>());
                rvo.setXj(0);
            }

            if (ConstantUtil.CCA.contains(vo.getAwcd())){
                if (dora){
                    rvo.setCcaDCount(rvo.getCcaDCount()+1);
                    rvo.getCcaDvos().add(vo);
                    ttvo.getCcaDvos().add(vo);

                }else {
                    rvo.getCcaAvos().add(vo);
                    ttvo.getCcaAvos().add(vo);
                    rvo.setCcaACount(rvo.getCcaACount()+1);
                }
                rvo.getCcaSUMvos().add(vo);
                ttvo.getCcaSUMvos().add(vo);
                rvo.setCcaSUMCount(rvo.getCcaDCount()+rvo.getCcaACount());
            }
            if (ConstantUtil.CSN.contains(vo.getAwcd())){
                if (dora){
                    rvo.setCsnDCount(rvo.getCsnDCount()+1);
                    rvo.getCsnDvos().add(vo);
                    ttvo.getCsnDvos().add(vo);
                }else {
                    rvo.setCsnACount(rvo.getCsnACount()+1);
                    rvo.getCsnAvos().add(vo);
                    ttvo.getCsnAvos().add(vo);
                }
                rvo.getCsnSUMvos().add(vo);
                ttvo.getCsnSUMvos().add(vo);
                rvo.setCsnSUMCount(rvo.getCsnDCount()+rvo.getCsnACount());
            }
            if (ConstantUtil.CES.contains(vo.getAwcd())){
                if (dora){
                    rvo.setCesDCount(rvo.getCesDCount()+1);
                    rvo.getCesDvos().add(vo);
                    ttvo.getCesDvos().add(vo);
                }else {
                    rvo.setCesACount(rvo.getCesACount()+1);
                    rvo.getCesAvos().add(vo);
                    ttvo.getCesAvos().add(vo);
                }
                rvo.getCesSUMvos().add(vo);
                ttvo.getCesSUMvos().add(vo);
                rvo.setCesSUMCount(rvo.getCesDCount()+rvo.getCesACount());
            }
            if (!ConstantUtil.IGO.contains(vo.getAwcd())){
                if (dora){
                    rvo.setIgoDCount(rvo.getIgoDCount()+1);
                    rvo.getIgoDvos().add(vo);
                    ttvo.getIgoDvos().add(vo);
                }else {
                    rvo.setIgoACount(rvo.getIgoACount()+1);
                    rvo.getIgoAvos().add(vo);
                    ttvo.getIgoAvos().add(vo);
                }
                rvo.getIgoSUMvos().add(vo);
                ttvo.getIgoSUMvos().add(vo);
                rvo.setIgoSUMCount(rvo.getIgoDCount()+rvo.getIgoACount());
            }
            rvo.getSumvos().add(vo);
            ttvo.getSumvos().add(vo);
            rvo.setSum(rvo.getCcaSUMCount()+rvo.getCsnSUMCount()+rvo.getCesSUMCount()+rvo.getIgoSUMCount());
            maps.put(hourFormat.format(siso),rvo);
        }
        //把map里面的对象放进list
        List<TFlightSchedulingVo> rilist=new ArrayList<TFlightSchedulingVo>();
        for (String key: maps.keySet()){
            rilist.add(maps.get(key));
            System.out.println("keycuts:"+key);
        }
        //总数实体类

        for (int i = 0; i <rilist.size() ; i++) {

            TFlightSchedulingVo tvo=rilist.get(i);
            ttvo.setCcaACount(ttvo.getCcaACount()+tvo.getCcaACount());
            ttvo.setCcaDCount(ttvo.getCcaDCount()+tvo.getCcaDCount());
            ttvo.setCcaSUMCount(ttvo.getCcaSUMCount()+tvo.getCcaSUMCount());


            ttvo.setCsnACount(ttvo.getCsnACount()+tvo.getCsnACount());
            ttvo.setCsnDCount(ttvo.getCsnDCount()+tvo.getCsnDCount());
            ttvo.setCsnSUMCount(ttvo.getCsnSUMCount()+tvo.getCsnSUMCount());

            ttvo.setCesACount(ttvo.getCesACount()+tvo.getCesACount());
            ttvo.setCesDCount(ttvo.getCesDCount()+tvo.getCesDCount());
            ttvo.setCesSUMCount(ttvo.getCesSUMCount()+tvo.getCesSUMCount());

            ttvo.setIgoACount(ttvo.getIgoACount()+tvo.getIgoACount());
            ttvo.setIgoDCount(ttvo.getIgoDCount()+tvo.getIgoDCount());
            ttvo.setIgoSUMCount(ttvo.getIgoSUMCount()+tvo.getIgoSUMCount());
            ttvo.setSum(ttvo.getSum()+tvo.getSum());
            ttvo.setXj(0);
            ttvo.setCcaxj(0);
            ttvo.setCsnxj(0);
            ttvo.setCesxj(0);
            ttvo.setIgoxj(0);

        }

        //  计划应削减总数
        int jhsxjTt = 0;
        if (!"".equals(downPerHour)){

            for (int i = 0; i <rilist.size() ; i++) {
                TFlightSchedulingVo tvo=rilist.get(i);
                jhsxjTt=tvo.getSum()-Integer.parseInt(downPerHour);
                if (jhsxjTt>0){


                    tvo.setXj(jhsxjTt);
                    tvo.setCcaxj(new BigDecimal(tvo.getXj()*(tvo.getCcaSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                    tvo.setCsnxj(new BigDecimal(tvo.getXj()*(tvo.getCsnSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                    tvo.setCesxj(new BigDecimal(tvo.getXj()*(tvo.getCesSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                    tvo.setIgoxj(new BigDecimal(tvo.getXj()*(tvo.getIgoSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());

                    ttvo.setXj(ttvo.getXj()+tvo.getXj());
                    ttvo.setCcaxj(ttvo.getCcaxj()+tvo.getCcaxj());
                    ttvo.setCsnxj(ttvo.getCsnxj()+tvo.getCsnxj());
                    ttvo.setCesxj(ttvo.getCesxj()+tvo.getCesxj());
                    ttvo.setIgoxj(ttvo.getIgoxj()+tvo.getIgoxj());
                }
            }

        }else if(!"".equals(downPercentage)){
            for (int i = 0; i <rilist.size() ; i++) {
                TFlightSchedulingVo tvo = rilist.get(i);
                tvo.setXj(new BigDecimal(tvo.getSum()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setCcaxj(new BigDecimal(tvo.getCcaSUMCount()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setCsnxj(new BigDecimal(tvo.getCsnSUMCount()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setCesxj(new BigDecimal(tvo.getCesSUMCount()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setIgoxj(new BigDecimal(tvo.getIgoSUMCount()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setDownPercentage(downPercentage);
                ttvo.setXj(ttvo.getXj()+tvo.getXj());
                ttvo.setCcaxj(ttvo.getCcaxj()+tvo.getCcaxj());
                ttvo.setCsnxj(ttvo.getCsnxj()+tvo.getCsnxj());
                ttvo.setCesxj(ttvo.getCesxj()+tvo.getCesxj());
                ttvo.setIgoxj(ttvo.getIgoxj()+tvo.getIgoxj());
            }
            ttvo.setDownPercentage(downPercentage);
            // ttvo.setXj(new BigDecimal(ttvo.getSum()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());

        }
        ttvo.setXj(new BigDecimal(ttvo.getXj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        ttvo.setCcaxj(new BigDecimal(ttvo.getCcaxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        ttvo.setCsnxj(new BigDecimal(ttvo.getCsnxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        ttvo.setCesxj(new BigDecimal(ttvo.getCesxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        ttvo.setIgoxj(new BigDecimal(ttvo.getIgoxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        rilist.add(ttvo);

        for (int i = 0; i <rilist.size() ; i++) {
            TFlightSchedulingVo tvo = rilist.get(i);
            tvo.setCcaZX(new BigDecimal(tvo.getCcaSUMCount()-tvo.getCcaxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            tvo.setCsnZX(new BigDecimal(tvo.getCsnSUMCount()-tvo.getCsnxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            tvo.setCesZX(new BigDecimal(tvo.getCesSUMCount()-tvo.getCesxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            tvo.setIgoZX(new BigDecimal(tvo.getIgoSUMCount()-tvo.getIgoxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            tvo.setSumZX(new BigDecimal(tvo.getSum()-tvo.getXj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        //以下开始组装柱状图数据
        List<String> ghxj = new ArrayList<>();
        List<String> ghsy = new ArrayList<>();
        List<String> dhxj = new ArrayList<>();
        List<String> dhsy = new ArrayList<>();
        List<String> nhxj = new ArrayList<>();
        List<String> nhsy = new ArrayList<>();
        List<String> dfxj = new ArrayList<>();
        List<String> dfsy = new ArrayList<>();
        //先将每小时的数据都置0
        for (int i = 0; i < 24; i++) {
            ghxj.add("0");
            ghsy.add("0");
            dhxj.add("0");
            dhsy.add("0");
            nhxj.add("0");
            nhsy.add("0");
            dfxj.add("0");
            dfsy.add("0");
        }
        for (int i = 0; i < rilist.size(); i++) {
            if(!"总计".equals(rilist.get(i).getHour())){
                for (int j = 0; j < 24; j++) {
                    if (Integer.parseInt(rilist.get(i).getHour())==j){
                        ghxj.set(j,String.valueOf(rilist.get(i).getCcaxj()));
                        ghsy.set(j,String.valueOf(rilist.get(i).getCcaZX()));
                        dhxj.set(j,String.valueOf(rilist.get(i).getCesxj()));
                        dhsy.set(j,String.valueOf(rilist.get(i).getCesZX()));
                        nhxj.set(j,String.valueOf(rilist.get(i).getCsnxj()));
                        nhsy.set(j,String.valueOf(rilist.get(i).getCsnZX()));
                        dfxj.set(j,String.valueOf(rilist.get(i).getIgoxj()));
                        dfsy.set(j,String.valueOf(rilist.get(i).getIgoZX()));
                    }
                }
            }
        }
        Map<String,List<String>> histogram = new HashMap();
        histogram.put("ghxj",ghxj);
        histogram.put("ghsy",ghsy);
        histogram.put("dhxj",dhxj);
        histogram.put("dhsy",dhsy);
        histogram.put("nhxj",nhxj);
        histogram.put("nhsy",nhsy);
        histogram.put("dfxj",dfxj);
        histogram.put("dfsy",dfsy);
        return ServerResponse.createBySuccess(histogram);

    }


    @ApiOperation(httpMethod = "POST", value = "修改预计航班削减百分比", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updEsFlightXjInfo.json", method = RequestMethod.POST)
    public ServerResponse preservationHolBusInfo(@ApiParam("修改预计航班削减百分比")
                                                 @RequestBody String AddDataObject) {

        JSONArray jsonArray = null;
        // Date today=new Date();
        // SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        // String now=format.format(today);


        String isAdd="";
        List<TFlightSchedulingVo> rilist=new ArrayList<TFlightSchedulingVo>();
        try {
            JSONObject j=new JSONObject(AddDataObject);


            jsonArray = j.getJSONArray("data");
            int sum=0;
            double xj=0.0;
            TFlightSchedulingVo ttvo=new TFlightSchedulingVo();
            for(int i=0 ; i < jsonArray.length() ;i++) {
                JSONObject jb = jsonArray.getJSONObject(i);
                TFlightSchedulingVo bus=new TFlightSchedulingVo();
                bus= JSON.parseObject(jb.toString(),TFlightSchedulingVo.class);
                /*bus.setExdt(jb.optString("exdt"));
                bus.setHour(jb.optString("hour"));
                bus.setCcaACount(jb.optInt("ccaACount"));
                bus.setCcaDCount(jb.optInt("ccaDCount"));
                bus.setCcaSUMCount(jb.optInt("ccaSUMCount"));
                bus.setCcaxj(jb.optDouble("ccaxj"));
                bus.setCsnACount(jb.optInt("csnACount"));
                bus.setCsnDCount(jb.optInt("csnDCount"));
                bus.setCsnSUMCount(jb.optInt("csnSUMCount"));
                bus.setCsnxj(jb.optDouble("csnxj"));
                bus.setCesACount(jb.optInt("cesACount"));
                bus.setCesDCount(jb.optInt("cesDCount"));
                bus.setCesSUMCount(jb.optInt("cesSUMCount"));
                bus.setCesxj(jb.optDouble("cesxj"));
                bus.setIgoACount(jb.optInt("igoACount"));
                bus.setIgoDCount(jb.optInt("igoDCount"));
                bus.setIgoSUMCount(jb.optInt("igoSUMCount"));
                bus.setIgoxj(jb.optDouble("igoxj"));
                bus.setSum(jb.optInt("sum"));
                bus.setXj(jb.optDouble("xj"));
                bus.setOpt(jb.optString("opt"));
                bus.setDownPercentage(jb.optString("downPercentage"));*/
                if (!"总计".equals(bus.getHour())){
                    if (!"Y".equals(jb.optString("opt"))){
                        sum=sum+jb.optInt("sum");
                        xj=xj+jb.optDouble("xj");
                    }else {
                        double dxj=new BigDecimal(bus.getSum()*(Double.parseDouble(bus.getDownPercentage())/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                        xj=xj+jb.optDouble("xj")-dxj;
                    }

                    rilist.add(bus);
                }else {
                    ttvo=bus;
                }


            }
            xj=new BigDecimal(xj).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                if (xj>=0){
                    ttvo.setXj(0);
                    ttvo.setCcaxj(0);
                    ttvo.setCsnxj(0);
                    ttvo.setCesxj(0);
                    ttvo.setIgoxj(0);
                    for (int i = 0; i <rilist.size() ; i++) {
                        TFlightSchedulingVo tvo=rilist.get(i);
                        if ("Y".equals(tvo.getOpt())){
                            tvo.setXj(new BigDecimal(tvo.getSum()*(Double.parseDouble(tvo.getDownPercentage())/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                            //tvo.setOpt("");
                            tvo.setCcaxj(new BigDecimal(tvo.getCcaSUMCount()*(Double.parseDouble(tvo.getDownPercentage())/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                            tvo.setCsnxj(new BigDecimal(tvo.getCsnSUMCount()*(Double.parseDouble(tvo.getDownPercentage())/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                            tvo.setCesxj(new BigDecimal(tvo.getCesSUMCount()*(Double.parseDouble(tvo.getDownPercentage())/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                            tvo.setIgoxj(new BigDecimal(tvo.getIgoSUMCount()*(Double.parseDouble(tvo.getDownPercentage())/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());

                        }else {
                            if (sum>0){
                                int a= (int) (xj*100/sum);
                                tvo.setDownPercentage(a+"");
                                tvo.setXj(new BigDecimal(tvo.getSum()*(xj*100/sum/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                                //tvo.setOpt("");
                                tvo.setCcaxj(new BigDecimal(tvo.getCcaSUMCount()*(xj*100/sum/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                                tvo.setCsnxj(new BigDecimal(tvo.getCsnSUMCount()*(xj*100/sum/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                                tvo.setCesxj(new BigDecimal(tvo.getCesSUMCount()*(xj*100/sum/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                                tvo.setIgoxj(new BigDecimal(tvo.getIgoSUMCount()*(xj*100/sum/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());

                                /*tvo.setXj(new BigDecimal(xj*(tvo.getSum()*1.0/sum)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                                int a= (int) (tvo.getXj()*100/tvo.getSum());
                                tvo.setDownPercentage(a+"");
                                tvo.setCcaxj(new BigDecimal(tvo.getXj()*(tvo.getCcaSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                                tvo.setCsnxj(new BigDecimal(tvo.getXj()*(tvo.getCsnSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                                tvo.setCesxj(new BigDecimal(tvo.getXj()*(tvo.getCesSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                                tvo.setIgoxj(new BigDecimal(tvo.getXj()*(tvo.getIgoSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
*/
                            }


                        }

                        ttvo.setXj(ttvo.getXj()+tvo.getXj());
                        ttvo.setCcaxj(ttvo.getCcaxj()+tvo.getCcaxj());
                        ttvo.setCsnxj(ttvo.getCsnxj()+tvo.getCsnxj());
                        ttvo.setCesxj(ttvo.getCesxj()+tvo.getCesxj());
                        ttvo.setIgoxj(ttvo.getIgoxj()+tvo.getIgoxj());

                    }
                }
            ttvo.setXj(new BigDecimal(ttvo.getXj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            ttvo.setCcaxj(new BigDecimal(ttvo.getCcaxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            ttvo.setCsnxj(new BigDecimal(ttvo.getCsnxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            ttvo.setCesxj(new BigDecimal(ttvo.getCesxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            ttvo.setIgoxj(new BigDecimal(ttvo.getIgoxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            rilist.add(ttvo);
            for (int i = 0; i <rilist.size() ; i++) {
                TFlightSchedulingVo tvo = rilist.get(i);
                tvo.setCcaZX(new BigDecimal(tvo.getCcaSUMCount()-tvo.getCcaxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setCsnZX(new BigDecimal(tvo.getCsnSUMCount()-tvo.getCsnxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setCesZX(new BigDecimal(tvo.getCesSUMCount()-tvo.getCesxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setIgoZX(new BigDecimal(tvo.getIgoSUMCount()-tvo.getIgoxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setSumZX(new BigDecimal(tvo.getSum()-tvo.getXj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess(rilist);
    }

    @ApiOperation(httpMethod = "POST", value = "VRF计划航班削减操作", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/updateVrfFlightRmk.json")
    public ServerResponse updateVrfFlightRmk(@ApiParam("航班标识") @RequestParam(value = "id") String id,@ApiParam("削减标记") @RequestParam(value = "rmk") String rmk) {
        int r=flightCutsService.updateVrfFlightRmk(id,rmk);
        return ServerResponse.createBySuccess(r);
    }

    @ApiOperation(httpMethod = "POST", value = "异常分析列表导出", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/export.json", method = RequestMethod.POST)
    public void export(@ApiParam("起始时间") @RequestParam("startDate") String startDate,
                       @ApiParam("结束时间") @RequestParam("endDate") String endDate,
                       @ApiParam("航空公司") @RequestParam("airCompany") String airCompany,
                       @ApiParam("通行量下降百分比") @RequestParam("downPercentage") String downPercentage,
                       @ApiParam("架次") @RequestParam("downPerHour") String downPerHour,
                       HttpServletRequest request, HttpServletResponse response) throws Exception {

        OutputStream out = response.getOutputStream();
        //判断航空公司
        List<String> airCompanyModify = new ArrayList<>();
        String condition = "";
        //用户为地服用户时，设置查询条件

        if (airCompany.contains("IGO")){
            condition= ConstantUtil.IGO+",";
        }
        //用户为国航用户时，设置查询条件
        if (airCompany.contains("CCA")){
            if (airCompany.contains("IGO")){
                condition=condition.replace(ConstantUtil.CCA+",","");
            }else
                condition+= ConstantUtil.CCA+",";
        }
        //用户为南航用户时，设置查询条件
        if (airCompany.contains("CSN")){
            if (airCompany.contains("IGO")){
                condition=condition.replace(ConstantUtil.CSN+",","");
            }else
                condition+= ConstantUtil.CSN+",";
        }
        //用户为东航用户时，设置查询条件
        if (airCompany.contains("CES")){
            if (airCompany.contains("IGO")){
                condition=condition.replace(ConstantUtil.CES+",","");
            }else
                condition+= ConstantUtil.CES+",";
        }
        if (airCompany.contains("IGO")&&airCompany.contains("CSN")&&airCompany.contains("CCA")&&airCompany.contains("CES")){
            airCompany= "";
        }
        if (airCompany.contains("IGO")){
            airCompany= "IGO";
        }
        if (!"".equals(condition)){
            condition=condition.substring(0,condition.length()-1);
        }


//        查询条件集合
        Map<Object,Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("agent",airCompany);
        queryMap.put("dept",airCompany);
        queryMap.put("agentSys",condition);
//        查询计划航班
        List<TFlightScheduling> list = flightCutsService.findFlightScheduling(queryMap);
        TFlightSchedulingVo ttvo=new TFlightSchedulingVo();
        ttvo.setHour("总计");
        ttvo.setCcaAvos(new ArrayList<TFlightScheduling>());
        ttvo.setCcaDvos(new ArrayList<TFlightScheduling>());
        ttvo.setCcaSUMvos(new ArrayList<TFlightScheduling>());
        ttvo.setCsnAvos(new ArrayList<TFlightScheduling>());
        ttvo.setCsnDvos(new ArrayList<TFlightScheduling>());
        ttvo.setCsnSUMvos(new ArrayList<TFlightScheduling>());

        ttvo.setCesAvos(new ArrayList<TFlightScheduling>());
        ttvo.setCesDvos(new ArrayList<TFlightScheduling>());
        ttvo.setCesSUMvos(new ArrayList<TFlightScheduling>());

        ttvo.setIgoAvos(new ArrayList<TFlightScheduling>());
        ttvo.setIgoDvos(new ArrayList<TFlightScheduling>());
        ttvo.setIgoSUMvos(new ArrayList<TFlightScheduling>());

        ttvo.setSumvos(new ArrayList<TFlightScheduling>());
        Map<String, TFlightSchedulingVo> maps = new TreeMap<>();
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        SimpleDateFormat yFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<TFlightScheduling> listopt=new ArrayList<TFlightScheduling>();//标记list
        //把查询出来的值按小时分组计算值放进map
        for (int i = 0; i < list.size(); i++) {

            TFlightScheduling vo=list.get(i);

            Date siso=DateTimeUtil.strToDate(vo.getFptt());
            Boolean dora=true;
            vo.setUptm(vo.getFptt());
            if ("A".equals(vo.getFlio())){
                siso=DateTimeUtil.strToDate(vo.getFplt());
                dora=false;
                vo.setUptm(vo.getFplt());
            }
            if ("1".equals(vo.getRmk())){
                listopt.add(vo);
            }
            TFlightSchedulingVo rvo=new TFlightSchedulingVo();
            if (maps.containsKey(hourFormat.format(siso))){
                rvo=maps.get(hourFormat.format(siso));
            }else{
                rvo=new TFlightSchedulingVo();
                rvo.setExdt(vo.getExdt());
                rvo.setHour(hourFormat.format(siso));
                rvo.setCcaACount(0);
                rvo.setCcaDCount(0);
                rvo.setCcaSUMCount(0);
                rvo.setCcaAvos(new ArrayList<TFlightScheduling>());
                rvo.setCcaDvos(new ArrayList<TFlightScheduling>());
                rvo.setCcaSUMvos(new ArrayList<TFlightScheduling>());
                rvo.setCsnACount(0);
                rvo.setCsnDCount(0);
                rvo.setCsnSUMCount(0);
                rvo.setCsnAvos(new ArrayList<TFlightScheduling>());
                rvo.setCsnDvos(new ArrayList<TFlightScheduling>());
                rvo.setCsnSUMvos(new ArrayList<TFlightScheduling>());
                rvo.setCesACount(0);
                rvo.setCesDCount(0);
                rvo.setCesSUMCount(0);
                rvo.setCesAvos(new ArrayList<TFlightScheduling>());
                rvo.setCesDvos(new ArrayList<TFlightScheduling>());
                rvo.setCesSUMvos(new ArrayList<TFlightScheduling>());
                rvo.setIgoACount(0);
                rvo.setIgoDCount(0);
                rvo.setIgoSUMCount(0);
                rvo.setIgoAvos(new ArrayList<TFlightScheduling>());
                rvo.setIgoDvos(new ArrayList<TFlightScheduling>());
                rvo.setIgoSUMvos(new ArrayList<TFlightScheduling>());
                rvo.setSum(0);
                rvo.setSumvos(new ArrayList<TFlightScheduling>());
                rvo.setXj(0);
            }

            if (ConstantUtil.CCA.contains(vo.getAwcd())){
                if (dora){
                    rvo.setCcaDCount(rvo.getCcaDCount()+1);
                    //rvo.getCcaDvos().add(vo);
                    //ttvo.getCcaDvos().add(vo);

                }else {
                   //rvo.getCcaAvos().add(vo);
                   // ttvo.getCcaAvos().add(vo);
                    rvo.setCcaACount(rvo.getCcaACount()+1);
                }
               // rvo.getCcaSUMvos().add(vo);
                //ttvo.getCcaSUMvos().add(vo);
                rvo.setCcaSUMCount(rvo.getCcaDCount()+rvo.getCcaACount());
            }
            if (ConstantUtil.CSN.contains(vo.getAwcd())){
                if (dora){
                    rvo.setCsnDCount(rvo.getCsnDCount()+1);
                   // rvo.getCsnDvos().add(vo);
                   // ttvo.getCsnDvos().add(vo);
                }else {
                    rvo.setCsnACount(rvo.getCsnACount()+1);
                   // rvo.getCsnAvos().add(vo);
                   // ttvo.getCsnAvos().add(vo);
                }
                //rvo.getCsnSUMvos().add(vo);
                //ttvo.getCsnSUMvos().add(vo);
                rvo.setCsnSUMCount(rvo.getCsnDCount()+rvo.getCsnACount());
            }
            if (ConstantUtil.CES.contains(vo.getAwcd())){
                if (dora){
                    rvo.setCesDCount(rvo.getCesDCount()+1);
                   // rvo.getCesDvos().add(vo);
                    //ttvo.getCesDvos().add(vo);
                }else {
                    rvo.setCesACount(rvo.getCesACount()+1);
                   // rvo.getCesAvos().add(vo);
                   // ttvo.getCesAvos().add(vo);
                }
                //rvo.getCesSUMvos().add(vo);
               // ttvo.getCesSUMvos().add(vo);
               rvo.setCesSUMCount(rvo.getCesDCount()+rvo.getCesACount());
            }
            if (!ConstantUtil.IGO.contains(vo.getAwcd())){
                if (dora){
                    rvo.setIgoDCount(rvo.getIgoDCount()+1);
                   // rvo.getIgoDvos().add(vo);
                   // ttvo.getIgoDvos().add(vo);
                }else {
                    rvo.setIgoACount(rvo.getIgoACount()+1);
                    //rvo.getIgoAvos().add(vo);
                    //ttvo.getIgoAvos().add(vo);
                }
                //rvo.getIgoSUMvos().add(vo);
                //ttvo.getIgoSUMvos().add(vo);
                rvo.setIgoSUMCount(rvo.getIgoDCount()+rvo.getIgoACount());
            }
           // rvo.getSumvos().add(vo);
            //ttvo.getSumvos().add(vo);
            rvo.setSum(rvo.getCcaSUMCount()+rvo.getCsnSUMCount()+rvo.getCesSUMCount()+rvo.getIgoSUMCount());
            maps.put(hourFormat.format(siso),rvo);
        }
        //把map里面的对象放进list
        List<TFlightSchedulingVo> rilist=new ArrayList<TFlightSchedulingVo>();
        for (String key: maps.keySet()){
            rilist.add(maps.get(key));
            System.out.println("keycuts:"+key);
        }
        //总数实体类

        for (int i = 0; i <rilist.size() ; i++) {

            TFlightSchedulingVo tvo=rilist.get(i);
            ttvo.setCcaACount(ttvo.getCcaACount()+tvo.getCcaACount());
            ttvo.setCcaDCount(ttvo.getCcaDCount()+tvo.getCcaDCount());
            ttvo.setCcaSUMCount(ttvo.getCcaSUMCount()+tvo.getCcaSUMCount());


            ttvo.setCsnACount(ttvo.getCsnACount()+tvo.getCsnACount());
            ttvo.setCsnDCount(ttvo.getCsnDCount()+tvo.getCsnDCount());
            ttvo.setCsnSUMCount(ttvo.getCsnSUMCount()+tvo.getCsnSUMCount());

            ttvo.setCesACount(ttvo.getCesACount()+tvo.getCesACount());
            ttvo.setCesDCount(ttvo.getCesDCount()+tvo.getCesDCount());
            ttvo.setCesSUMCount(ttvo.getCesSUMCount()+tvo.getCesSUMCount());

            ttvo.setIgoACount(ttvo.getIgoACount()+tvo.getIgoACount());
            ttvo.setIgoDCount(ttvo.getIgoDCount()+tvo.getIgoDCount());
            ttvo.setIgoSUMCount(ttvo.getIgoSUMCount()+tvo.getIgoSUMCount());
            ttvo.setSum(ttvo.getSum()+tvo.getSum());
            ttvo.setXj(0);
            ttvo.setCcaxj(0);
            ttvo.setCsnxj(0);
            ttvo.setCesxj(0);
            ttvo.setIgoxj(0);

        }

        //  计划应削减总数
        int jhsxjTt = 0;
        if (!"".equals(downPerHour)){

            for (int i = 0; i <rilist.size() ; i++) {
                TFlightSchedulingVo tvo=rilist.get(i);
                jhsxjTt=tvo.getSum()-Integer.parseInt(downPerHour);
                if (jhsxjTt>0){


                    tvo.setXj(jhsxjTt);
                    tvo.setCcaxj(new BigDecimal(tvo.getXj()*(tvo.getCcaSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                    tvo.setCsnxj(new BigDecimal(tvo.getXj()*(tvo.getCsnSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                    tvo.setCesxj(new BigDecimal(tvo.getXj()*(tvo.getCesSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                    tvo.setIgoxj(new BigDecimal(tvo.getXj()*(tvo.getIgoSUMCount()*1.0/tvo.getSum())).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());

                    ttvo.setXj(ttvo.getXj()+tvo.getXj());
                    ttvo.setCcaxj(ttvo.getCcaxj()+tvo.getCcaxj());
                    ttvo.setCsnxj(ttvo.getCsnxj()+tvo.getCsnxj());
                    ttvo.setCesxj(ttvo.getCesxj()+tvo.getCesxj());
                    ttvo.setIgoxj(ttvo.getIgoxj()+tvo.getIgoxj());
                }
            }

        }else if(!"".equals(downPercentage)){
            for (int i = 0; i <rilist.size() ; i++) {
                TFlightSchedulingVo tvo = rilist.get(i);
                tvo.setXj(new BigDecimal(tvo.getSum()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setCcaxj(new BigDecimal(tvo.getCcaSUMCount()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setCsnxj(new BigDecimal(tvo.getCsnSUMCount()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setCesxj(new BigDecimal(tvo.getCesSUMCount()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setIgoxj(new BigDecimal(tvo.getIgoSUMCount()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                tvo.setDownPercentage(downPercentage);
                ttvo.setXj(ttvo.getXj()+tvo.getXj());
                ttvo.setCcaxj(ttvo.getCcaxj()+tvo.getCcaxj());
                ttvo.setCsnxj(ttvo.getCsnxj()+tvo.getCsnxj());
                ttvo.setCesxj(ttvo.getCesxj()+tvo.getCesxj());
                ttvo.setIgoxj(ttvo.getIgoxj()+tvo.getIgoxj());
            }
            ttvo.setDownPercentage(downPercentage);
            // ttvo.setXj(new BigDecimal(ttvo.getSum()*(Double.parseDouble(downPercentage)/100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());

        }
        ttvo.setXj(new BigDecimal(ttvo.getXj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        ttvo.setCcaxj(new BigDecimal(ttvo.getCcaxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        ttvo.setCsnxj(new BigDecimal(ttvo.getCsnxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        ttvo.setCesxj(new BigDecimal(ttvo.getCesxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        ttvo.setIgoxj(new BigDecimal(ttvo.getIgoxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        rilist.add(ttvo);

        for (int i = 0; i <rilist.size() ; i++) {
            TFlightSchedulingVo tvo = rilist.get(i);
            tvo.setCcaZX(new BigDecimal(tvo.getCcaSUMCount()-tvo.getCcaxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            tvo.setCsnZX(new BigDecimal(tvo.getCsnSUMCount()-tvo.getCsnxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            tvo.setCesZX(new BigDecimal(tvo.getCesSUMCount()-tvo.getCesxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            tvo.setIgoZX(new BigDecimal(tvo.getIgoSUMCount()-tvo.getIgoxj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            tvo.setSumZX(new BigDecimal(tvo.getSum()-tvo.getXj()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        }

        JxlsBuilder jxlsBuilder = JxlsBuilder
                .getBuilder(ResourceUtils.getFile("classpath:template/vrfFlightCuts.xlsx").getAbsolutePath())
                .out(out)
                .ignoreImageMiss(true)
                .putVar("rilist",rilist)
                .putVar("listopt", listopt)
                .build();

        out.close();
    }
}
