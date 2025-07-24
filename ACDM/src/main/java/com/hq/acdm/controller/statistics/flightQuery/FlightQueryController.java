package com.hq.acdm.controller.statistics.flightQuery;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.flightQuery.*;
import com.hq.acdm.service.flight.VStartFlightLvService;
import com.hq.acdm.service.statistics.flightQuery.FlightQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javafx.beans.binding.ObjectExpression;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/10/17 0017 9:30
 */
@Api(description = "航班查询")
@RestController
@RequestMapping("/statisticalReport/flightQuery")
@Slf4j
public class FlightQueryController {
    @Resource
    private FlightQueryService flightQueryService;
    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/location.json", method = RequestMethod.GET)
    public ServerResponse findLocation() {
        List<Location> location = flightQueryService.get_location();
        for(int i=0;i<location.size();i++){
            location.get(i).setFlag(false);
        }
        return ServerResponse.createBySuccess(location);
    }
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/direction.json", method = RequestMethod.POST)
    public ServerResponse findDirection(@ApiParam("进出港") @RequestParam("inORout") String inORout,
                                        HttpServletRequest request, HttpServletResponse response) {
        List<SelectModel> direction = new ArrayList<>();
        direction.add(new SelectModel("NXD","NXD","D",false));
        direction.add(new SelectModel("PIKAS","PIKAS","D",false));
        direction.add(new SelectModel("AND","AND","A",false));
        direction.add(new SelectModel("ODULO","ODULO","A",false));
        direction.add(new SelectModel("SASAN","SASAN","A",false));
        direction.add(new SelectModel("HSN","HSN","A",false));
        direction.add(new SelectModel("AKARA","AKARA","A",false));
        direction.add(new SelectModel("BOLEX","BOLEX","A",false));
        List<SelectModel> dealDirection = new ArrayList<>();
        if("".equals(inORout)||inORout==null){
            dealDirection = direction;
        }else {
            for(int i=0;i<direction.size();i++){
                if(inORout.equals(direction.get(i).getRelation())){
                    dealDirection.add(new SelectModel(direction.get(i).getLabel(),direction.get(i).getValue(),direction.get(i).getRelation(),false));
                }else{
                    dealDirection.add(new SelectModel(direction.get(i).getLabel(),direction.get(i).getValue(),direction.get(i).getRelation(),true));
                }
            }
        }
        return ServerResponse.createBySuccess(dealDirection);
    }
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/way.json", method = RequestMethod.POST)
    public ServerResponse findWay(@ApiParam("方向") @RequestParam("direction") String direction,
                                  HttpServletRequest request, HttpServletResponse response) {
        List<SelectModel> way = new ArrayList<>();
        if(direction.length()>0){
            way.add(new SelectModel("A470","A470","NXD",true));
            way.add(new SelectModel("A599","A599","NXD",true));
            way.add(new SelectModel("H24","H24","NXD",true));
            way.add(new SelectModel("H26","H26","NXD",true));
            way.add(new SelectModel("G204","G204","AND",true));
            way.add(new SelectModel("A593","A593","PIKAS",true));
            way.add(new SelectModel("R343武汉区域","R343武汉区域","PIKAS",true));
            way.add(new SelectModel("B208郑州区域","B208郑州区域","PIKAS",true));
            way.add(new SelectModel("G330","G330","PIKAS",true));
            way.add(new SelectModel("H28","H28","PIKAS",true));
            way.add(new SelectModel("W50","W50","PIKAS",true));
            way.add(new SelectModel("B221","B221","ODULO",true));
            way.add(new SelectModel("W13","W13","HSN",true));
            String[] direction_arr = direction.split(",");
            List<String> temp_str = new ArrayList<>();
            if("".equals(direction)||direction==null){
            }else{
                for(int i=0;i<way.size();i++){
                    for(int j=0;j<direction_arr.length;j++){
                        if(direction_arr[j].equals(way.get(i).getRelation())){
                            temp_str.add(way.get(i).getRelation());
                        }
                    }
                }
                for(int i=0;i<way.size();i++){
                    for(int j=0;j<temp_str.size();j++){
                        if(temp_str.get(j).equals(way.get(i).getRelation())){
                            way.get(i).setFlag(false);
                        }else{
                        }
                    }
                }
            }
        }else{
            way.add(new SelectModel("A470","A470","NXD",false));
            way.add(new SelectModel("A599","A599","NXD",false));
            way.add(new SelectModel("H24","H24","NXD",false));
            way.add(new SelectModel("H26","H26","NXD",false));
            way.add(new SelectModel("G204","G204","AND",false));
            way.add(new SelectModel("A593","A593","PIKAS",false));
            way.add(new SelectModel("R343武汉区域","R343武汉区域","PIKAS",false));
            way.add(new SelectModel("B208郑州区域","B208郑州区域","PIKAS",false));
            way.add(new SelectModel("G330","G330","PIKAS",false));
            way.add(new SelectModel("H28","H28","PIKAS",false));
            way.add(new SelectModel("W50","W50","PIKAS",false));
            way.add(new SelectModel("B221","B221","ODULO",false));
            way.add(new SelectModel("W13","W13","HSN",false));
        }
        return ServerResponse.createBySuccess(way);
    }
    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/stop.json", method = RequestMethod.GET)
    public ServerResponse findStop() {
        List<SelectModel> stop = new ArrayList<>();
        stop.add(new SelectModel("CAN","CAN","",false));
        stop.add(new SelectModel("SZX","SZX","",false));
        stop.add(new SelectModel("XMN","XMN","",false));
        stop.add(new SelectModel("PEK","PEK","",false));
        stop.add(new SelectModel("KMG","KMG","",false));
        return ServerResponse.createBySuccess(stop);
    }
    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/airline.json", method = RequestMethod.GET)
    public ServerResponse findAirLine() {
        List<SelectModel> airline = new ArrayList<>();
        airline.add(new SelectModel("MU/FM/KN","MU/FM/KN","",false));
        airline.add(new SelectModel("CA/ZH","CA/ZH","",false));
        airline.add(new SelectModel("CZ","CZ","",false));
        airline.add(new SelectModel("HO","HO","",false));
        airline.add(new SelectModel("9C","9C","",false));
        airline.add(new SelectModel("MF","MF","",false));
        airline.add(new SelectModel("HU/8L/GS","HU/8L/GS","",false));
        airline.add(new SelectModel("SC","SC","",false));
        airline.add(new SelectModel("TV/NS/EU","TV/NS/EU","",false));
        return ServerResponse.createBySuccess(airline);
    }
    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/reducePercentage.json", method = RequestMethod.GET)
    public ServerResponse findReducePercentage() {
        List<SelectModel> reducePercentage = new ArrayList<>();
        for(int i=1;i<=100;i++){
            reducePercentage.add(new SelectModel(String.valueOf(i)+"%",String.valueOf(i)+"%","",true));
        }
        return ServerResponse.createBySuccess(reducePercentage);
    }
    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/reducePlanNum.json", method = RequestMethod.GET)
    public ServerResponse findReduce() {
        List<SelectModel> reducePlanNum = new ArrayList<>();
        for(int i=1;i<=50;i++){
            reducePlanNum.add(new SelectModel(String.valueOf(i),String.valueOf(i),"",true));
        }
        return ServerResponse.createBySuccess(reducePlanNum);
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse queryFlight(@ApiParam("方向") @RequestParam("direction") String direction,
                                  @ApiParam("航路") @RequestParam("way") String way,
                                  @ApiParam("起始时间") @RequestParam("startDate") String startDate,
                                  @ApiParam("结束时间") @RequestParam("endDate") String endDate,
                                  @ApiParam("是否取消") @RequestParam("cancel") String cancel,
                                  @ApiParam("进出港") @RequestParam("a_or_d") String a_or_d,
                                  @ApiParam("经停站") @RequestParam("jinting") String jinting,
                                  @ApiParam("目的地") @RequestParam("destination") String destination,
                                  @ApiParam("是否执行") @RequestParam("execute") String execute,
                                  @ApiParam("航空公司") @RequestParam("airCompany") String airCompany,
                                  @ApiParam("通行量下降百分比") @RequestParam("downPercentage") String downPercentage,
                                  @ApiParam("通行量下降") @RequestParam("down") String down2,
                                  @ApiParam("架次") @RequestParam("downPerHour") String downPerHour,
                                  HttpServletRequest request, HttpServletResponse response) throws ParseException {
        //判断是否为取消航班
        if("false".equals(cancel)){
            cancel = "0";
        }else if("true".equals(cancel)){
            cancel = "1";
        }
        MudidiAirport mudidiAirport = new MudidiAirport();
        //判断是否为已执行航班
        if("false".equals(execute)){
            execute = "0";
        }else if("true".equals(execute)){
            execute = "1";
        }
        //判断经停
        List<String> jintingModify = new ArrayList<>();
        //判断航空公司
        List<String> airCompanyModify = new ArrayList<>();
        //判断方向
        String fangxiang = "";
        List<String> fangxiangList = new ArrayList<>();
        //判断航路
        String hanglu = "";
        List<String> hangluList = new ArrayList<>();
        //判断目的地
        List<String> mudidi = new ArrayList<>();
        Map<Object,Object> queryMap = new HashMap<>();
        if(jinting.length()>0){
            String[] jinting_arr = jinting.substring(0,jinting.length()).split(",");
            for(int i=0;i<jinting_arr.length;i++){
                jintingModify.add(jinting_arr[i]);
            }
        }
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
        if(way.length()>0){
            hanglu = way.substring(0,way.length());
            String[] hanglu_arr = hanglu.split(",");
            hanglu = "";
            for(int i=0;i<hanglu_arr.length;i++){
                if("A470".equals(hanglu_arr[i])){
                    hanglu =hanglu + mudidiAirport.getA470()+",";
                }else if("A599".equals(hanglu_arr[i])){
                    hanglu =hanglu + mudidiAirport.getA599()+",";
                }else if("H24".equals(hanglu_arr[i])){
                    hanglu =hanglu + mudidiAirport.getH24()+",";
                }else if("H26".equals(hanglu_arr[i])){
                    hanglu =hanglu + mudidiAirport.getH26()+",";
                }else if("G204".equals(hanglu_arr[i])){
                    hanglu =hanglu + mudidiAirport.getG204()+",";
                }else if("A593".equals(hanglu_arr[i])){
                    hanglu =hanglu + mudidiAirport.getA593()+",";
                }else if("R343武汉区域".equals(hanglu_arr[i])){
                    hanglu =hanglu + mudidiAirport.getR343()+",";
                }else if("B208郑州区域".equals(hanglu_arr[i])){
                    hanglu =hanglu + mudidiAirport.getB208()+",";
                }else if("G330".equals(hanglu_arr[i])){
                    hanglu =hanglu + mudidiAirport.getG330()+",";
                }else if("H28".equals(hanglu_arr[i])){
                    hanglu =hanglu + mudidiAirport.getH28()+",";
                }else if("W50".equals(hanglu_arr[i])){
                    hanglu =hanglu + mudidiAirport.getW50()+",";
                }else if("B221".equals(hanglu_arr[i])){
                    hanglu =hanglu + mudidiAirport.getB221()+",";
                }else if("W13".equals(hanglu_arr[i])){
                    hanglu =hanglu + mudidiAirport.getW13()+",";
                }
            }
        }else{
            hanglu = "";
        }
        if(hanglu.length()>0){
            String[] temp_hanglu = hanglu.substring(0,hanglu.length()-1).split(",");
            for(int i=0;i<temp_hanglu.length;i++){
                hangluList.add(temp_hanglu[i].toString());
            }
        }
        if(direction.length()>0){
            fangxiang = direction.substring(0,direction.length());
            String[] fangxiang_arr = fangxiang.split(",");
            fangxiang = "";
            for(int i=0;i<fangxiang_arr.length;i++){
                if("NXD".equals(fangxiang_arr[i])){
                    fangxiang =fangxiang+ mudidiAirport.getA470()+","
                            +mudidiAirport.getA599()+","
                            +mudidiAirport.getH24()+","
                            +mudidiAirport.getH26()+","
                            +mudidiAirport.getOtherNXD()+",";
                }else if("AND".equals(fangxiang_arr[i])){
                    fangxiang =fangxiang + mudidiAirport.getG204()+",";
                }else if("PIKAS".equals(fangxiang_arr[i])){
                    fangxiang = fangxiang + mudidiAirport.getA593()+","
                            +mudidiAirport.getR343()+","
                            +mudidiAirport.getB208()+","
                            +mudidiAirport.getH28()+","
                            +mudidiAirport.getW50()+","
                            +mudidiAirport.getG330()+","
                            +mudidiAirport.getOtherPKS()+",";
                }else if("ODULO".equals(fangxiang_arr[i])){
                    fangxiang =fangxiang + mudidiAirport.getB221()+",";
                }else if("SASAN".equals(fangxiang_arr[i])){
                    fangxiang =fangxiang + mudidiAirport.getSASAN()+",";
                }else if("HSN".equals(fangxiang_arr[i])){
                    fangxiang =fangxiang + mudidiAirport.getW13()+",";
                }else if("AKARA".equals(fangxiang_arr[i])){
                    fangxiang =fangxiang + mudidiAirport.getAKARA()+",";
                }else if("BOLEX".equals(fangxiang_arr[i])){
                    fangxiang =fangxiang + mudidiAirport.getBOLEX()+",";
                }
            }
        }else{
            fangxiang = "";
        }
        if(fangxiang.length()>0){
            String[] temp_fangxiang = fangxiang.substring(0,fangxiang.length()-1).split(",");
            for(int i=0;i<temp_fangxiang.length;i++){
                fangxiangList.add(temp_fangxiang[i].toString());
            }
        }

//        if("A470".equals(way)){
//            way = mudidiAirport.getA470();
//        }else if("A599".equals(way)){
//            way = mudidiAirport.getA599();
//        }else if("H24".equals(way)){
//            way = mudidiAirport.getH24();
//        }else if("H26".equals(way)){
//            way = mudidiAirport.getH26();
//        }else if("G204".equals(way)){
//            way = mudidiAirport.getG204();
//        }else if("A593".equals(way)){
//            way = mudidiAirport.getA593();
//        }else if("R343武汉区域".equals(way)){
//            way = mudidiAirport.getR343();
//        }else if("B208郑州区域".equals(way)){
//            way = mudidiAirport.getB208();
//        }else if("G330".equals(way)){
//            way = mudidiAirport.getG330();
//        }else if("H28".equals(way)){
//            way = mudidiAirport.getH28();
//        }else if("W50".equals(way)){
//            way = mudidiAirport.getW50();
//        }else if("B221".equals(way)){
//            way = mudidiAirport.getB221();
//        }else if("W13".equals(way)){
//            way = mudidiAirport.getW13();
//        }
//        if("NXD".equals(direction)){
//            direction = mudidiAirport.getA470()+","
//                    +mudidiAirport.getA599()+","
//                    +mudidiAirport.getH24()+","
//                    +mudidiAirport.getH26()+","
//                    +mudidiAirport.getOtherNXD();
//        }else if("AND".equals(direction)){
//            direction = mudidiAirport.getG204();
//        }else if("PIKAS".equals(direction)){
//            direction = mudidiAirport.getA593()+","
//                    +mudidiAirport.getR343()+","
//                    +mudidiAirport.getB208()+","
//                    +mudidiAirport.getH28()+","
//                    +mudidiAirport.getW50()+","
//                    +mudidiAirport.getG330()+","
//                    +mudidiAirport.getOtherPKS();
//        }else if("ODULO".equals(direction)){
//            direction = mudidiAirport.getB221();
//        }else if("SASAN".equals(direction)){
//            direction = mudidiAirport.getSASAN();
//        }else if("HSN".equals(direction)){
//            direction = mudidiAirport.getW13();
//        }else if("AKARA".equals(direction)){
//            direction = mudidiAirport.getAKARA();
//        }else if("BOLEX".equals(direction)){
//            direction = mudidiAirport.getBOLEX();
//        }

        queryMap.put("fangxiangList",fangxiangList);
        queryMap.put("hangluList",hangluList);
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("cancel",cancel);
        queryMap.put("a_or_d",a_or_d);
        queryMap.put("jintingList",jintingModify);
        queryMap.put("destinationList",mudidi);
        queryMap.put("execute",execute);
        queryMap.put("airCompanyList",airCompanyModify);
        List<FlightQueryResult> list = flightQueryService.queryWithAORD(queryMap);
        Map<String,Integer> jihuahangbanshuMap = new HashMap<>();
        Map<String,Integer> jihuayingxuejianMap = new HashMap<>();
        Map<String,Integer> jihuayixuejianMap = new HashMap<>();
        Map<String,Integer> shijiyixuejianMap = new HashMap<>();
        Map<String,String> jisuanhouxuejianMap = new HashMap<>();
        jisuanhouxuejianMap.put("MU/FM/KN","0");
        jisuanhouxuejianMap.put("CA/ZH","0");
        jisuanhouxuejianMap.put("CZ","0");
        jisuanhouxuejianMap.put("HO","0");
        jisuanhouxuejianMap.put("9C","0");
        jisuanhouxuejianMap.put("MF","0");
        jisuanhouxuejianMap.put("HU/8L/GS","0");
        jisuanhouxuejianMap.put("SC","0");
        jisuanhouxuejianMap.put("difu","0");
        jisuanhouxuejianMap.put("total","0");
        jihuahangbanshuMap.put("MU/FM/KN",0);
        jihuayingxuejianMap.put("MU/FM/KN",0);
        jihuayixuejianMap.put("MU/FM/KN",0);
        shijiyixuejianMap.put("MU/FM/KN",0);
        jihuahangbanshuMap.put("CA/ZH",0);
        jihuayingxuejianMap.put("CA/ZH",0);
        jihuayixuejianMap.put("CA/ZH",0);
        shijiyixuejianMap.put("CA/ZH",0);
        jihuahangbanshuMap.put("CZ",0);
        jihuayingxuejianMap.put("CZ",0);
        jihuayixuejianMap.put("CZ",0);
        shijiyixuejianMap.put("CZ",0);
        jihuahangbanshuMap.put("HO",0);
        jihuayingxuejianMap.put("HO",0);
        jihuayixuejianMap.put("HO",0);
        shijiyixuejianMap.put("HO",0);
        jihuahangbanshuMap.put("9C",0);
        jihuayingxuejianMap.put("9C",0);
        jihuayixuejianMap.put("9C",0);
        shijiyixuejianMap.put("9C",0);
        jihuahangbanshuMap.put("MF",0);
        jihuayingxuejianMap.put("MF",0);
        jihuayixuejianMap.put("MF",0);
        shijiyixuejianMap.put("MF",0);
        jihuahangbanshuMap.put("HU/8L/GS",0);
        jihuayingxuejianMap.put("HU/8L/GS",0);
        jihuayixuejianMap.put("HU/8L/GS",0);
        shijiyixuejianMap.put("HU/8L/GS",0);
        jihuahangbanshuMap.put("SC",0);
        jihuayingxuejianMap.put("SC",0);
        jihuayixuejianMap.put("SC",0);
        shijiyixuejianMap.put("SC",0);
        jihuahangbanshuMap.put("difu",0);
        jihuayingxuejianMap.put("difu",0);
        jihuayixuejianMap.put("difu",0);
        shijiyixuejianMap.put("difu",0);
        jihuahangbanshuMap.put("total",0);
        jihuayingxuejianMap.put("total",0);
        jihuayixuejianMap.put("total",0);
        shijiyixuejianMap.put("total",0);

        for (int i=0;i<list.size();i++){
            jihuahangbanshuMap.put("total",jihuahangbanshuMap.get("total")+1);
            if(("MU").equals(list.get(i).getAIRLINE_CODE_IATA())
                    || ("FM").equals(list.get(i).getAIRLINE_CODE_IATA())
                    || ("KN").equals(list.get(i).getAIRLINE_CODE_IATA())){
                jihuahangbanshuMap.put("MU/FM/KN",jihuahangbanshuMap.get("MU/FM/KN")+1);
            }else if(("CA").equals(list.get(i).getAIRLINE_CODE_IATA())
                    || ("ZH").equals(list.get(i).getAIRLINE_CODE_IATA())){
                jihuahangbanshuMap.put("CA/ZH",jihuahangbanshuMap.get("CA/ZH")+1);
            }else if(("CZ").equals(list.get(i).getAIRLINE_CODE_IATA())){
                jihuahangbanshuMap.put("CZ",jihuahangbanshuMap.get("CZ")+1);
            }else if(("HO").equals(list.get(i).getAIRLINE_CODE_IATA())){
                jihuahangbanshuMap.put("HO",jihuahangbanshuMap.get("HO")+1);
            }else if(("9C").equals(list.get(i).getAIRLINE_CODE_IATA())){
                jihuahangbanshuMap.put("9C",jihuahangbanshuMap.get("9C")+1);
            }else if(("MF").equals(list.get(i).getAIRLINE_CODE_IATA())){
                jihuahangbanshuMap.put("MF",jihuahangbanshuMap.get("MF")+1);
            }else if(("HU").equals(list.get(i).getAIRLINE_CODE_IATA())
                    || ("8L").equals(list.get(i).getAIRLINE_CODE_IATA())
                    ||("GS").equals(list.get(i).getAIRLINE_CODE_IATA())){
                jihuahangbanshuMap.put("HU/8L/GS",jihuahangbanshuMap.get("HU/8L/GS")+1);
            }else if(("SC").equals(list.get(i).getAIRLINE_CODE_IATA())){
                jihuahangbanshuMap.put("SC",jihuahangbanshuMap.get("SC")+1);
            }else if(("TV").equals(list.get(i).getAIRLINE_CODE_IATA())
                    || ("NS").equals(list.get(i).getAIRLINE_CODE_IATA())
                    ||("EU").equals(list.get(i).getAIRLINE_CODE_IATA())){
                jihuahangbanshuMap.put("difu",jihuahangbanshuMap.get("difu")+1);
            }
        }

        for (int i=0;i<list.size();i++){
            if(list.get(i).getAIRPORT_VIA_IATA_7()!=null && !("").equals(list.get(i).getAIRPORT_VIA_IATA_7())){
                jihuayixuejianMap.put("total",jihuayixuejianMap.get("total")+1);
                if(("MU").equals(list.get(i).getAIRPORT_VIA_IATA_7())
                        || ("FM").equals(list.get(i).getAIRPORT_VIA_IATA_7())
                        || ("KN").equals(list.get(i).getAIRPORT_VIA_IATA_7())){
                    jihuayixuejianMap.put("MU/FM/KN",jihuayixuejianMap.get("MU/FM/KN")+1);
                }else if(("CA").equals(list.get(i).getAIRPORT_VIA_IATA_7())
                        || ("ZH").equals(list.get(i).getAIRPORT_VIA_IATA_7())){
                    jihuayixuejianMap.put("CA/ZH",jihuayixuejianMap.get("CA/ZH")+1);
                }else if(("CZ").equals(list.get(i).getAIRPORT_VIA_IATA_7())){
                    jihuayixuejianMap.put("CZ",jihuayixuejianMap.get("CZ")+1);
                }else if(("HO").equals(list.get(i).getAIRPORT_VIA_IATA_7())){
                    jihuayixuejianMap.put("HO",jihuayixuejianMap.get("HO")+1);
                }else if(("9C").equals(list.get(i).getAIRPORT_VIA_IATA_7())){
                    jihuayixuejianMap.put("9C",jihuayixuejianMap.get("9C")+1);
                }else if(("MF").equals(list.get(i).getAIRPORT_VIA_IATA_7())){
                    jihuayixuejianMap.put("MF",jihuayixuejianMap.get("MF")+1);
                }else if(("HU").equals(list.get(i).getAIRPORT_VIA_IATA_7())
                        || ("8L").equals(list.get(i).getAIRPORT_VIA_IATA_7())
                        ||("GS").equals(list.get(i).getAIRPORT_VIA_IATA_7())){
                    jihuayixuejianMap.put("HU/8L/GS",jihuayixuejianMap.get("HU/8L/GS")+1);
                }else if(("SC").equals(list.get(i).getAIRPORT_VIA_IATA_7())){
                    jihuayixuejianMap.put("SC",jihuayixuejianMap.get("SC")+1);
                }else if(("TV").equals(list.get(i).getAIRPORT_VIA_IATA_7())
                        || ("NS").equals(list.get(i).getAIRPORT_VIA_IATA_7())
                        ||("EU").equals(list.get(i).getAIRPORT_VIA_IATA_7())){
                    jihuayixuejianMap.put("difu",jihuayixuejianMap.get("difu")+1);
                }
            }
        }

        for (int i=0;i<list.size();i++){
            if(list.get(i).getFLIGHT_CANCEL_CODE()!=null && !("").equals(list.get(i).getFLIGHT_CANCEL_CODE()) && list.get(i).getFLIGHT_CANCEL_CODE().length()>0){
                shijiyixuejianMap.put("total",shijiyixuejianMap.get("total")+1);
                if(("MU").equals(list.get(i).getAIRLINE_CODE_IATA())
                        || ("FM").equals(list.get(i).getAIRLINE_CODE_IATA())
                        || ("KN").equals(list.get(i).getAIRLINE_CODE_IATA())){
                    shijiyixuejianMap.put("MU/FM/KN",shijiyixuejianMap.get("MU/FM/KN")+1);
                }else if(("CA").equals(list.get(i).getAIRLINE_CODE_IATA())
                        || ("ZH").equals(list.get(i).getAIRLINE_CODE_IATA())){
                    shijiyixuejianMap.put("CA/ZH",shijiyixuejianMap.get("CA/ZH")+1);
                }else if(("CZ").equals(list.get(i).getAIRLINE_CODE_IATA())){
                    shijiyixuejianMap.put("CZ",shijiyixuejianMap.get("CZ")+1);
                }else if(("HO").equals(list.get(i).getAIRLINE_CODE_IATA())){
                    shijiyixuejianMap.put("HO",shijiyixuejianMap.get("HO")+1);
                }else if(("9C").equals(list.get(i).getAIRLINE_CODE_IATA())){
                    shijiyixuejianMap.put("9C",shijiyixuejianMap.get("9C")+1);
                }else if(("MF").equals(list.get(i).getAIRLINE_CODE_IATA())){
                    shijiyixuejianMap.put("MF",shijiyixuejianMap.get("MF")+1);
                }else if(("HU").equals(list.get(i).getAIRLINE_CODE_IATA())
                        || ("8L").equals(list.get(i).getAIRLINE_CODE_IATA())
                        ||("GS").equals(list.get(i).getAIRLINE_CODE_IATA())){
                    shijiyixuejianMap.put("HU/8L/GS",shijiyixuejianMap.get("HU/8L/GS")+1);
                }else if(("SC").equals(list.get(i).getAIRLINE_CODE_IATA())){
                    shijiyixuejianMap.put("SC",shijiyixuejianMap.get("SC")+1);
                }else if(("TV").equals(list.get(i).getAIRLINE_CODE_IATA())
                        || ("NS").equals(list.get(i).getAIRLINE_CODE_IATA())
                        ||("EU").equals(list.get(i).getAIRLINE_CODE_IATA())){
                    shijiyixuejianMap.put("difu",shijiyixuejianMap.get("difu")+1);
                }
            }else{
                continue;
            }
        }

        List<CalculateResult> resultList = new ArrayList<>();
        CalculateResult calculateResult = new CalculateResult();
        calculateResult.setOperationType("计划航班数");
        calculateResult.setMU(jihuahangbanshuMap.get("MU/FM/KN"));
        calculateResult.setCA(jihuahangbanshuMap.get("CA/ZH"));
        calculateResult.setCZ(jihuahangbanshuMap.get("CZ"));
        calculateResult.setHO(jihuahangbanshuMap.get("HO"));
        calculateResult.setC9(jihuahangbanshuMap.get("9C"));
        calculateResult.setMF(jihuahangbanshuMap.get("MF"));
        calculateResult.setHU(jihuahangbanshuMap.get("HU/8L/GS"));
        calculateResult.setDF(jihuahangbanshuMap.get("difu"));
        calculateResult.setSC(jihuahangbanshuMap.get("SC"));
        calculateResult.setTOTAL(jihuahangbanshuMap.get("total"));
        resultList.add(calculateResult);

        Map<String,Object> map = new HashMap<>();

        DecimalFormat ddff = new DecimalFormat("######0.00");
        if(downPercentage!=null && !("").equals(downPercentage)){
            double xiajiang = Double.parseDouble(downPercentage.substring(0, downPercentage.lastIndexOf("%")))*0.01;
            double xiajiang2 = 1;
            if (down2 != null && !"".equals(down2)) {
                xiajiang2 = Double.parseDouble(down2.substring(0, down2.lastIndexOf("%")))*0.01;
            }
            jisuanhouxuejianMap.put("MU/FM/KN",String.format("%.2f",jihuahangbanshuMap.get("MU/FM/KN")*xiajiang*xiajiang2));
            jisuanhouxuejianMap.put("CA/ZH",String.format("%.2f",jihuahangbanshuMap.get("CA/ZH")*xiajiang*xiajiang2));
            jisuanhouxuejianMap.put("CZ",String.format("%.2f",jihuahangbanshuMap.get("CZ")*xiajiang*xiajiang2));
            jisuanhouxuejianMap.put("HO",String.format("%.2f",jihuahangbanshuMap.get("HO")*xiajiang*xiajiang2));
            jisuanhouxuejianMap.put("9C",String.format("%.2f",jihuahangbanshuMap.get("9C")*xiajiang*xiajiang2));
            jisuanhouxuejianMap.put("MF",String.format("%.2f",jihuahangbanshuMap.get("MF")*xiajiang*xiajiang2));
            jisuanhouxuejianMap.put("HU/8L/GS",String.format("%.2f",jihuahangbanshuMap.get("HU/8L/GS")*xiajiang*xiajiang2));
            jisuanhouxuejianMap.put("SC",String.format("%.2f",jihuahangbanshuMap.get("SC")*xiajiang*xiajiang2));
            jisuanhouxuejianMap.put("difu",String.format("%.2f",jihuahangbanshuMap.get("difu")*xiajiang*xiajiang2));
            jisuanhouxuejianMap.put("total",String.format("%.2f",jihuahangbanshuMap.get("total")*xiajiang*xiajiang2));
            CalculateResult calculateResult_jihuaying = new CalculateResult();
            calculateResult_jihuaying.setOperationType("计划应削减");
            calculateResult_jihuaying.setMU(Double.parseDouble(jisuanhouxuejianMap.get("MU/FM/KN")));
            calculateResult_jihuaying.setCA(Double.parseDouble(jisuanhouxuejianMap.get("CA/ZH")));
            calculateResult_jihuaying.setCZ(Double.parseDouble(jisuanhouxuejianMap.get("CZ")));
            calculateResult_jihuaying.setHO(Double.parseDouble(jisuanhouxuejianMap.get("HO")));
            calculateResult_jihuaying.setC9(Double.parseDouble(jisuanhouxuejianMap.get("9C")));
            calculateResult_jihuaying.setMF(Double.parseDouble(jisuanhouxuejianMap.get("MF")));
            calculateResult_jihuaying.setHU(Double.parseDouble(jisuanhouxuejianMap.get("HU/8L/GS")));
            calculateResult_jihuaying.setSC(Double.parseDouble(jisuanhouxuejianMap.get("SC")));
            calculateResult_jihuaying.setDF(Double.parseDouble(jisuanhouxuejianMap.get("difu")));
            calculateResult_jihuaying.setTOTAL(Double.parseDouble(jisuanhouxuejianMap.get("total")));
            resultList.add(calculateResult_jihuaying);
        }else if(downPerHour !=null && !"".equals(downPerHour)){
            List<ReduceCalculateResult> reduceList = new ArrayList<>();
            if(!"".equals(a_or_d) && a_or_d!=null && "A".equals(a_or_d)){
                reduceList = flightQueryService.xuejianA(queryMap);
            }else if(!"".equals(a_or_d) && a_or_d!=null && "D".equals(a_or_d)){
                reduceList = flightQueryService.xuejianD(queryMap);
            }
            Set<String> hourSet = new TreeSet<>();
            Map<String,Integer> hourMap = new HashMap<>();
            for(int i=0;i<reduceList.size()-1;i++) {
                ReduceCalculateResult reduceCalculateResult = reduceList.get(i);
                int sumnum = reduceCalculateResult.getNUM();
                if(hourSet.contains(reduceCalculateResult.getAT())){
                    System.out.println("已存在该小时");
                    continue;
                }
                for (int j = i + 1; j < reduceList.size(); j++) {
//                    if (reduceList.get(j).getAT() != null && !"".equals(reduceList.get(j).getAT()) && reduceCalculateResult.getAT() != null && !"".equals(reduceCalculateResult.getAT()))
                    if (reduceCalculateResult.getAT().equals(reduceList.get(j).getAT())) {
                        sumnum += reduceList.get(j).getNUM();

                    }
                }
                hourSet.add(reduceCalculateResult.getAT());
                hourMap.put(reduceCalculateResult.getAT(),sumnum);
            }
                for(Map.Entry<String,Integer> entry:hourMap.entrySet()){
                    double BILI = Double.parseDouble(ddff.format((entry.getValue() * 1.0 - Double.parseDouble(downPerHour)) / entry.getValue() * 1.0));
                    if (BILI > 0) {
                        System.out.println("BILI大于0");
                    } else {
                        continue;

                    }
                    for(int i=0;i<reduceList.size();i++){
                        if(reduceList.get(i).getAT().equals(entry.getKey())){
                            double timenum = 0;
                            timenum = Double.parseDouble(ddff.format(reduceList.get(i).getNUM() * 1.0 * BILI));//当前小时应削减
                            if ("MU".equals(reduceList.get(i).getAIRLINE_CODE_IATA())
                                    || "FM".equals(reduceList.get(i).getAIRLINE_CODE_IATA())
                                    || "KN".equals(reduceList.get(i).getAIRLINE_CODE_IATA())) {
                                jisuanhouxuejianMap.put("MU/FM/KN", ddff.format(timenum + Double.parseDouble(jisuanhouxuejianMap.get("MU/FM/KN"))));
                            } else if ("CA".equals(reduceList.get(i).getAIRLINE_CODE_IATA())
                                    || "ZH".equals(reduceList.get(i).getAIRLINE_CODE_IATA())) {
                                jisuanhouxuejianMap.put("CA/ZH", ddff.format(timenum + Double.parseDouble(jisuanhouxuejianMap.get("CA/ZH"))));
                            } else if ("CZ".equals(reduceList.get(i).getAIRLINE_CODE_IATA())) {
                                jisuanhouxuejianMap.put("CZ", ddff.format(timenum + Double.parseDouble(jisuanhouxuejianMap.get("CZ"))));
                            } else if ("HO".equals(reduceList.get(i).getAIRLINE_CODE_IATA())) {
                                jisuanhouxuejianMap.put("HO", ddff.format(timenum + Double.parseDouble(jisuanhouxuejianMap.get("HO"))));
                            } else if ("9C".equals(reduceList.get(i).getAIRLINE_CODE_IATA())) {
                                jisuanhouxuejianMap.put("9C", ddff.format(timenum + Double.parseDouble(jisuanhouxuejianMap.get("9C"))));
                            } else if ("MF".equals(reduceList.get(i).getAIRLINE_CODE_IATA())) {
                                jisuanhouxuejianMap.put("MF", ddff.format(timenum + Double.parseDouble(jisuanhouxuejianMap.get("MF"))));
                            } else if ("HU".equals(reduceList.get(i).getAIRLINE_CODE_IATA())
                                    || "8L".equals(reduceList.get(i).getAIRLINE_CODE_IATA())
                                    || "GS".equals(reduceList.get(i).getAIRLINE_CODE_IATA())) {
                                jisuanhouxuejianMap.put("HU/8L/GS", ddff.format(timenum + Double.parseDouble(jisuanhouxuejianMap.get("HU/8L/GS"))));
                            } else if ("TV".equals(reduceList.get(i).getAIRLINE_CODE_IATA())
                                    || "NS".equals(reduceList.get(i).getAIRLINE_CODE_IATA())
                                    || "EU".equals(reduceList.get(i).getAIRLINE_CODE_IATA())) {
                                jisuanhouxuejianMap.put("difu", ddff.format(timenum + Double.parseDouble(jisuanhouxuejianMap.get("difu"))));
                            } else if ("SC".equals(reduceList.get(i).getAIRLINE_CODE_IATA())) {
                                jisuanhouxuejianMap.put("SC", ddff.format(timenum + Double.parseDouble(jisuanhouxuejianMap.get("SC"))));
                            }
                        }
                    }
                }
            double total_temp = 0;
            CalculateResult calculateResult_jihuaying = new CalculateResult();
            calculateResult_jihuaying.setOperationType("计划应削减");
            if(jisuanhouxuejianMap.get("MU/FM/KN")!=null && !"".equals(jisuanhouxuejianMap.get("MU/FM/KN"))){
                total_temp = total_temp + Double.parseDouble(jisuanhouxuejianMap.get("MU/FM/KN"));
                calculateResult_jihuaying.setMU(Double.parseDouble(jisuanhouxuejianMap.get("MU/FM/KN")));
            }
            if(jisuanhouxuejianMap.get("CA/ZH")!=null && !"".equals(jisuanhouxuejianMap.get("CA/ZH"))){
                calculateResult_jihuaying.setCA(Double.parseDouble(jisuanhouxuejianMap.get("CA/ZH")));
                total_temp = total_temp + Double.parseDouble(jisuanhouxuejianMap.get("CA/ZH"));
            }
            if(jisuanhouxuejianMap.get("CZ")!=null && !"".equals(jisuanhouxuejianMap.get("CZ"))){
                calculateResult_jihuaying.setCZ(Double.parseDouble(jisuanhouxuejianMap.get("CZ")));
                total_temp = total_temp + Double.parseDouble(jisuanhouxuejianMap.get("CZ"));
            }
            if(jisuanhouxuejianMap.get("HO")!=null && !"".equals(jisuanhouxuejianMap.get("HO"))){
                calculateResult_jihuaying.setHO(Double.parseDouble(jisuanhouxuejianMap.get("HO")));
                total_temp = total_temp + Double.parseDouble(jisuanhouxuejianMap.get("HO"));
            }
            if(jisuanhouxuejianMap.get("9C")!=null && !"".equals(jisuanhouxuejianMap.get("9C"))){
                calculateResult_jihuaying.setC9(Double.parseDouble(jisuanhouxuejianMap.get("9C")));
                total_temp = total_temp + Double.parseDouble(jisuanhouxuejianMap.get("9C"));
            }
            if(jisuanhouxuejianMap.get("MF")!=null && !"".equals(jisuanhouxuejianMap.get("MF"))){
                calculateResult_jihuaying.setMF(Double.parseDouble(jisuanhouxuejianMap.get("MF")));
                total_temp = total_temp + Double.parseDouble(jisuanhouxuejianMap.get("MF"));
            }
            if(jisuanhouxuejianMap.get("HU/8L/GS")!=null && !"".equals(jisuanhouxuejianMap.get("HU/8L/GS"))){
                calculateResult_jihuaying.setHU(Double.parseDouble(jisuanhouxuejianMap.get("HU/8L/GS")));
                total_temp = total_temp + Double.parseDouble(jisuanhouxuejianMap.get("HU/8L/GS"));
            }
            if(jisuanhouxuejianMap.get("difu")!=null && !"".equals(jisuanhouxuejianMap.get("difu"))){
                calculateResult_jihuaying.setDF(Double.parseDouble(jisuanhouxuejianMap.get("difu")));
                total_temp = total_temp + Double.parseDouble(jisuanhouxuejianMap.get("difu"));
            }
            if(jisuanhouxuejianMap.get("SC")!=null && !"".equals(jisuanhouxuejianMap.get("SC"))){
                calculateResult_jihuaying.setSC(Double.parseDouble(jisuanhouxuejianMap.get("SC")));
                total_temp = total_temp + Double.parseDouble(jisuanhouxuejianMap.get("SC"));
            }
            jisuanhouxuejianMap.put("total",ddff.format(total_temp));


            calculateResult_jihuaying.setTOTAL(Double.parseDouble(jisuanhouxuejianMap.get("total")));
            resultList.add(calculateResult_jihuaying);
        }else{
            CalculateResult calculateResult_jihuaying = new CalculateResult();
            calculateResult_jihuaying.setOperationType("计划应削减");
            calculateResult_jihuaying.setMU(0);
            calculateResult_jihuaying.setCA(0);
            calculateResult_jihuaying.setCZ(0);
            calculateResult_jihuaying.setHO(0);
            calculateResult_jihuaying.setC9(0);
            calculateResult_jihuaying.setMF(0);
            calculateResult_jihuaying.setHU(0);
            calculateResult_jihuaying.setDF(0);
            calculateResult_jihuaying.setSC(0);
            calculateResult_jihuaying.setTOTAL(0);
            resultList.add(calculateResult_jihuaying);
        }
        CalculateResult calculateResult1 = new CalculateResult();
        calculateResult1.setOperationType("计划已削减");
        calculateResult1.setMU(jihuayixuejianMap.get("MU/FM/KN"));
        calculateResult1.setCA(jihuayixuejianMap.get("CA/ZH"));
        calculateResult1.setCZ(jihuayixuejianMap.get("CZ"));
        calculateResult1.setHO(jihuayixuejianMap.get("HO"));
        calculateResult1.setC9(jihuayixuejianMap.get("9C"));
        calculateResult1.setMF(jihuayixuejianMap.get("MF"));
        calculateResult1.setHU(jihuayixuejianMap.get("HU/8L/GS"));
        calculateResult1.setDF(jihuayixuejianMap.get("difu"));
        calculateResult1.setSC(jihuayixuejianMap.get("SC"));
        calculateResult1.setTOTAL(jihuayixuejianMap.get("total"));
        resultList.add(calculateResult1);
        CalculateResult calculateResult2 = new CalculateResult();
        calculateResult2.setOperationType("实际已削减");
        calculateResult2.setMU(shijiyixuejianMap.get("MU/FM/KN"));
        calculateResult2.setCA(shijiyixuejianMap.get("CA/ZH"));
        calculateResult2.setCZ(shijiyixuejianMap.get("CZ"));
        calculateResult2.setHO(shijiyixuejianMap.get("HO"));
        calculateResult2.setC9(shijiyixuejianMap.get("9C"));
        calculateResult2.setMF(shijiyixuejianMap.get("MF"));
        calculateResult2.setHU(shijiyixuejianMap.get("HU/8L/GS"));
        calculateResult2.setDF(shijiyixuejianMap.get("difu"));
        calculateResult2.setSC(shijiyixuejianMap.get("SC"));
        calculateResult2.setTOTAL(shijiyixuejianMap.get("total"));
        resultList.add(calculateResult2);
        Map<String,String> barResult = new HashMap<>();

        Set<String> keySet = new TreeSet<>();
        List<TableRow> tableRowList = new ArrayList<>();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormat = simpleDateFormat.format(date);
        int dateResult = dataFormat.compareTo(startDate);
        if(dateResult==0){
            dataFormat = startDate.substring(0,10);
        }else if(dateResult>0){
            dataFormat = simpleDateFormat.format(date);
        }else if(dateResult<0){
            dataFormat = simpleDateFormat.format(date);
        }
//取出对应时间的航班号
        for(int i=0;i<list.size();i++){
            list.get(i).setOPERATIONAL_DATE(list.get(i).getOPERATIONAL_DATE().substring(0,10));
            if(list.get(i).getSOBT()!=null && !"".equals(list.get(i).getSOBT())){
                String temp_sobt = list.get(i).getSOBT();
                String hour = "";

                int compareResult = list.get(i).getOPERATIONAL_DATE().substring(0,10).compareTo(dataFormat);
                Date date1 = simpleDateFormat.parse(dataFormat);
                Date date2 = simpleDateFormat.parse(list.get(i).getOPERATIONAL_DATE().substring(0,10));
                long days = (date2.getTime()-date1.getTime())/(1000*3600*24);
                if(compareResult>0){
                    hour = temp_sobt.substring(11,13)+"(+"+days+")";
                }else if(compareResult<0){
                    hour = temp_sobt.substring(11,13)+"("+days+")";
                }else if(compareResult == 0){
                    hour = temp_sobt.substring(11,13);
                }
                list.get(i).setSOBT(list.get(i).getSOBT().substring(11,list.get(i).getSOBT().length()));

                //通过循环把对应航班号放入这个map中
                if(keySet.contains(hour)){

                }else{
                    keySet.add(hour);
                    barResult.put(hour,"");
                    TableRow tableRow = new TableRow();
                    tableRow.setName(hour);
                    tableRowList.add(tableRow);
                }
                if("1".equals(list.get(i).getOPERATIONAL_FLAG())){
                    barResult.put(hour,barResult.get(hour)+list.get(i).getFLIGHT_NO_IATA()+"2,");
                }else{
                    if(list.get(i).getISSTRICTCTRL()==1){
                        barResult.put(hour,barResult.get(hour)+list.get(i).getFLIGHT_NO_IATA()+"1,");
                    }else{
                        if(list.get(i).getFLIGHT_NO_IATA()==null){
                        barResult.put(hour,barResult.get(hour)+",");
                        }else{
                            barResult.put(hour,barResult.get(hour)+list.get(i).getFLIGHT_NO_IATA()+"0,");
                            }
                    }
                }
            }else if(list.get(i).getATOT()!=null && !"".equals(list.get(i).getATOT())){
                String temp_atot = list.get(i).getATOT();
                String hour = temp_atot.substring(11,13);
                list.get(i).setATOT(list.get(i).getATOT().substring(11,list.get(i).getATOT().length()));
                if(keySet.contains(hour)){

                }else{
                    keySet.add(hour);
                    barResult.put(hour,"");
                }
                if("1".equals(list.get(i).getOPERATIONAL_FLAG())){
                    barResult.put(hour,barResult.get(hour)+list.get(i).getFLIGHT_NO_IATA()+"2,");
                }else{
                    if(list.get(i).getISSTRICTCTRL()==1){
                        barResult.put(hour,barResult.get(hour)+list.get(i).getFLIGHT_NO_IATA()+"1,");
                    }else{
                        if(list.get(i).getFLIGHT_NO_IATA()==null){
                            barResult.put(hour,barResult.get(hour)+",");
                        }else{
                            barResult.put(hour,barResult.get(hour)+list.get(i).getFLIGHT_NO_IATA()+"0,");
                        }

                    }
                }

            }
        }
        int map_long = 0;
        Map<String,String[]>  dealMap3 = new HashMap<>();
        Map<String,List<String>>  dealMap33 = new HashMap<>();
        for (Map.Entry<String, String> entry : barResult.entrySet()) {
            String str_temp = "";
            if(entry.getValue().length()>0){
                str_temp = entry.getValue().substring(0,entry.getValue().length()-1);
                String[] arr_str = str_temp.split(",");
                dealMap3.put(entry.getKey(),arr_str);
                if(map_long<=arr_str.length){
                    map_long = arr_str.length;
                }
            }else{
                String [] temp_arr = new String[map_long];
                dealMap3.put(entry.getKey(),temp_arr);
            }
        }
        for (Map.Entry<String, String[]> entry : dealMap3.entrySet()) {
            if(entry.getValue().length<=map_long){
                int temp_distance = map_long - entry.getValue().length;
                List<String> flightList = new ArrayList<>(Arrays.asList(entry.getValue()));
                for(int i=0;i<temp_distance;i++){
                    flightList.add(" ");
                }
                dealMap33.put(entry.getKey(),flightList);
            }
        }

        List<Map<String,Object>> list_barList = new ArrayList<>();
        for(int i=0;i<map_long;i++){
            Map<String,Object> mapConcat = new HashMap<>();
            for (Map.Entry<String, String> entry : barResult.entrySet()) {
                if (dealMap33.get(entry.getKey()).get(i)!=null){
                    mapConcat.put(entry.getKey(),dealMap33.get(entry.getKey()).get(i));

                }else{
                    continue;
                }

            }
            list_barList.add(mapConcat);
        }
        System.out.println("");

        map.put("table1",resultList);
        map.put("table2",list);
        map.put("table3",list_barList);
        map.put("table4",tableRowList);
        return ServerResponse.createBySuccess(map);
    }
}
