package com.hq.acdm.controller.statistics.aocRunLetters;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.aocRunLetters.BridgeRate;
import com.hq.acdm.model.statistics.aocRunLetters.RealInterfaceYD;
import com.hq.acdm.service.statistics.aocRunLetters.AocRunLettersService;
import com.hq.acdm.vo.statistics.aocRunLetters.JinHuFlightVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * AOC运行快报 控制类
 */
@Api(description = "AOC运行快报")
@RestController
@RequestMapping("/statisticalReport/AOCExpress") //前台访问地址
@Slf4j
public class AocRunLettersController {
    @Resource
    private AocRunLettersService aocRunLettersService;

    @ApiOperation(httpMethod = "GET", value = "AOC运行快报查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.GET)
    public ServerResponse queryFun() {

        Map<String,Object> mapRes=new HashMap<String,Object>();//AOC运行快报结果
        try{
            //总计划 实际 正常率 放行正常率
            List<RealInterfaceYD> realInterfaceYDList = aocRunLettersService.queryAllRealInterfaceYD();
            for (RealInterfaceYD realInterfaceYd:realInterfaceYDList) {
                mapRes.put("FLIGHT_NUM",realInterfaceYd.getFLIGHT_NUM());//计划执行航班
                mapRes.put("ALREADY_NUM",realInterfaceYd.getALREADY_NUM());//实际航班数

                double RNUMERATOR=Integer.parseInt(realInterfaceYd.getFLIGHT_R_RATE_NUMERATOR());//放行率分子 FLIGHT_RELEASE_RATE_NUMERATOR --> FLIGHT_R_RATE_NUMERATOR
                double RDENOMINATOR=Integer.parseInt(realInterfaceYd.getFLIGHT_R_RATE_DENOMINATOR());//放行率分母 FLIGHT_RELEASE_RATE_NUMERATOR-->FLIGHT_R_RATE_DENOMINATOR
                double NNUMERATOR=Integer.parseInt(realInterfaceYd.getFLIGHT_RATE_NUMERATOR());//正常率分子 FLIGHT_NORMAL_RATE_NUMERATOR-->FLIGHT_RATE_NUMERATOR
                double NDENOMINATOR=Integer.parseInt(realInterfaceYd.getFLIGHT_RATE_DENOMINATOR());//正常率分母 FLIGHT_NORMAL_RATE_DENOMINATOR-->FLIGHT_RATE_DENOMINATOR

                double RELEASE=0;
                if(RNUMERATOR!=0){
                    RELEASE=(RDENOMINATOR-RNUMERATOR)/RDENOMINATOR;
                    RELEASE=RELEASE*100;
                    RELEASE = (double)Math.round(RELEASE*100)/100;//保留两位小数
                    mapRes.put("RELEASE",RELEASE+"%");//放行率
                }else{
                    mapRes.put("RELEASE","0%");//放行率
                }

                double NORMAL=0;
                if(NNUMERATOR!=0){
                    NORMAL=(NDENOMINATOR-NNUMERATOR)/NDENOMINATOR;
                    NORMAL=NORMAL*100;
                    NORMAL = (double)Math.round(NORMAL*100)/100;//保留两位小数
                    mapRes.put("NORMAL",NORMAL+"%");//正常率
                }else{
                    mapRes.put("NORMAL","0%");//正常率
                }
            }


            //公务机数量
            int corporateAircraftCount=aocRunLettersService.queryCorporateAircraftCount();
            System.out.println("公务机数量："+corporateAircraftCount);
            mapRes.put("GWFlight",corporateAircraftCount);


            //旅客数量
            int numberOfPassengers=aocRunLettersService.queryNumberOfPassengers();
            System.out.println("旅客数量："+numberOfPassengers);
            mapRes.put("PASSENGER_NUM",numberOfPassengers);




            //始发放行率
            Map startRate=aocRunLettersService.queryStartRate();
            //判断数量为空
            //System.out.println("始发放行率："+startRate.get("ZX")+", "+startRate.get("ZC"));

            if(null!=startRate){
                double SFFX=0;
                double ZC=0;
                double ZX=0;
                if(startRate.get("ZC")!=null){
                    ZC=Integer.parseInt(startRate.get("ZC").toString());
                }
                if(startRate.get("ZX")!=null){
                    ZX=Integer.parseInt(startRate.get("ZX").toString());
                }

                if(ZC!=0){
                    SFFX=ZC/ZX;
                    SFFX=SFFX*100;
                    SFFX = (double)Math.round(SFFX*100)/100;//保留两位小数
                    mapRes.put("SFFX",SFFX+"%");//始发放行率
                }else{
                    mapRes.put("SFFX","0%");//始发放行率
                }
            }else{
                mapRes.put("SFFX","0%");//始发放行率
            }





            //靠桥率
            Map onTheBridgeRate=aocRunLettersService.queryStartRateOfGetFun();
            System.out.println("靠桥率："+onTheBridgeRate);
            if(null!=onTheBridgeRate){
                mapRes.put("T1SF",StringUtils.isBlank(onTheBridgeRate.get("T1SF").toString())?"0%":onTheBridgeRate.get("T1SF").toString());
                mapRes.put("T1GZ",StringUtils.isBlank(onTheBridgeRate.get("T1GZ").toString())?"0%":onTheBridgeRate.get("T1GZ").toString());
                mapRes.put("T2SF",StringUtils.isBlank(onTheBridgeRate.get("T2SF").toString())?"0%":onTheBridgeRate.get("T2SF").toString());
                mapRes.put("T2GZ",StringUtils.isBlank(onTheBridgeRate.get("T2GZ").toString())?"0%":onTheBridgeRate.get("T2GZ").toString());
            }else{
                mapRes.put("T1SF","0%");
                mapRes.put("T1GZ","0%");
                mapRes.put("T2SF","0%");
                mapRes.put("T2GZ","0%");
            }



            //京沪航班总数
            List<Map> bJtoSHflight=aocRunLettersService.queryBJtoSHflight();
            System.out.println("京沪航班总数:"+bJtoSHflight);

            List<JinHuFlightVo> jinHuFlightVoList=new ArrayList<>();
            for(Map map:bJtoSHflight){
                JinHuFlightVo jinHuFlightVo=new JinHuFlightVo();
                String airportIata=map.get("DEST_AIRPORT_IATA").toString();
                String totalNum=map.get("ZS").toString();
                String abNormalNum=map.get("BZC").toString();
                String normalNum=String.valueOf(Integer.parseInt(totalNum)- Integer.parseInt(abNormalNum));
                double jhNormal=0;
                jhNormal=(double)(Integer.parseInt(normalNum)) / (double)Integer.parseInt(totalNum);
                jhNormal=jhNormal*100;
                jhNormal = (double)Math.round(jhNormal*100)/100;//保留两位小数

                jinHuFlightVo.setNormalNum(normalNum);
                jinHuFlightVo.setAbNormalNum(abNormalNum);
                jinHuFlightVo.setTotalNum(totalNum);
                jinHuFlightVo.setNormalRate(jhNormal+"%");
                //PEK 北京/首都
                //CAN 广州/白云
                //SZX 深圳/宝安
                //XMN 厦门/高崎
                //KMG 昆明/长水
                //URC 乌鲁木齐/地窝堡
                //CKG 重庆/江北
                //CTU 成都/双流
                switch (airportIata)
                {
                    case "PEK":
                        jinHuFlightVo.setAirport("北京");
                        break;
                    case "CAN":
                        jinHuFlightVo.setAirport("广州");
                        break;
                    case "SZX":
                        jinHuFlightVo.setAirport("深圳");
                        break;
                    case "XMN":
                        jinHuFlightVo.setAirport("厦门");
                        break;
                    case "KMG":
                        jinHuFlightVo.setAirport("昆明");
                        break;
                    case "URC":
                        jinHuFlightVo.setAirport("乌鲁木齐");
                        break;
                    case "CKG":
                        jinHuFlightVo.setAirport("重庆");
                        break;
                    case "CTU":
                        jinHuFlightVo.setAirport("成都");
                        break;

                        default:
                            break;
                }

                if(StringUtils.isNoneBlank(jinHuFlightVo.getAirport())){
                    jinHuFlightVoList.add(jinHuFlightVo);
                }
            }

            //对无机场信息做补空数据处理


            if(jinHuFlightVoList.size()==0){
                //全部都是空数据
                JinHuFlightVo jinHuFlightVo=initJinHuFlightVo("PEK");
                jinHuFlightVoList.add(jinHuFlightVo);
                jinHuFlightVo=initJinHuFlightVo("CAN");
                jinHuFlightVoList.add(jinHuFlightVo);
                jinHuFlightVo=initJinHuFlightVo("SZX");
                jinHuFlightVoList.add(jinHuFlightVo);
                jinHuFlightVo=initJinHuFlightVo("XMN");
                jinHuFlightVoList.add(jinHuFlightVo);
                jinHuFlightVo=initJinHuFlightVo("KMG");
                jinHuFlightVoList.add(jinHuFlightVo);
                jinHuFlightVo=initJinHuFlightVo("URC");
                jinHuFlightVoList.add(jinHuFlightVo);
                jinHuFlightVo=initJinHuFlightVo("CKG");
                jinHuFlightVoList.add(jinHuFlightVo);
                jinHuFlightVo=initJinHuFlightVo("CTU");
                jinHuFlightVoList.add(jinHuFlightVo);
            }else{
                String[] allAirportArray={"北京","广州"};
                List<String> list=Arrays.asList(allAirportArray);
                List<String> allAirportList = new ArrayList(list);
                for(JinHuFlightVo jinHuFlightVo:jinHuFlightVoList){
                    String airport=jinHuFlightVo.getAirport();
                    if(allAirportList.contains(airport)){
                        allAirportList.remove(airport);//将已经有的机场移除
                    }
                }
                if(allAirportList.size()>0){//说明有空数据要补充
                    for(String str:allAirportList){
                        JinHuFlightVo jinHuFlightVo=initJinHuFlightVo(str);
                        jinHuFlightVoList.add(jinHuFlightVo);
                    }
                }
            }


            mapRes.put("tableData",jinHuFlightVoList);


            //靠桥率2
            List<BridgeRate> queryOnTheBridgeRateTwoList=aocRunLettersService.queryOnTheBridgeRateTwo();
            System.out.println("靠桥率2:"+queryOnTheBridgeRateTwoList.toString());

            for (BridgeRate bridgeRate: queryOnTheBridgeRateTwoList ) {
                if(bridgeRate.getTYPE().equals("≥30")){
                    mapRes.put("A",bridgeRate.getFlight_num());
                }
                if(bridgeRate.getTYPE().equals("≥60")){
                    mapRes.put("B",bridgeRate.getFlight_num());
                }
                if(bridgeRate.getTYPE().equals("≥120")){
                    mapRes.put("C",bridgeRate.getFlight_num());
                }
                if(bridgeRate.getTYPE().equals("≥240")){
                    mapRes.put("D",bridgeRate.getFlight_num());
                }
            }


            //CODE不合理
            int queryCodeUnreasonable=aocRunLettersService.queryCodeUnreasonable();
            System.out.println("CODE不合理："+queryCodeUnreasonable);
            mapRes.put("COBTBHL",queryCodeUnreasonable);


            //飞机晚到
            List<Map>  queryPlaneLateMap=aocRunLettersService.queryPlaneLate();
            int HJZS=0;
            for(Map map:queryPlaneLateMap){
                mapRes.put(map.get("AIRLINE_CODE_IATA")+"COBTBHL",map.get("COUNT"));
                HJZS+=Integer.parseInt(map.get("COUNT").toString());
            }
            //对没有晚到的航空公司做数量补零
            if(!mapRes.containsKey("MUCOBTBHL")){
                mapRes.put("MUCOBTBHL","0");
            }
            if(!mapRes.containsKey("FMCOBTBHL")){
                mapRes.put("FMCOBTBHL","0");
            }
            if(!mapRes.containsKey("CACOBTBHL")){
                mapRes.put("CACOBTBHL","0");
            }
            if(!mapRes.containsKey("CZCOBTBHL")){
                mapRes.put("CZCOBTBHL","0");
            }
            if(!mapRes.containsKey("9CCOBTBHL")){
                mapRes.put("9CCOBTBHL","0");
            }
            if(!mapRes.containsKey("HOCOBTBHL")){
                mapRes.put("HOCOBTBHL","0");
            }
            if(!mapRes.containsKey("DFCOBTBHL")){
                mapRes.put("DFCOBTBHL","0");
            }
            if(!mapRes.containsKey("QTCOBTBHL")){
                mapRes.put("QTCOBTBHL","0");
            }

            mapRes.put("HJZS",HJZS);

            //COBT与计划出港(SOBT)相差10-25分钟
            int cobtWithSobtLeavePort=aocRunLettersService.cobtWithSobtLeavePort();
            System.out.println("COBT与计划出港(SOBT)相差10-25分钟:"+cobtWithSobtLeavePort);

            mapRes.put("COSOXC",cobtWithSobtLeavePort);


            //Small delay 小延误
            List<Map> querySmallDelayMap=aocRunLettersService.querySmallDelay();
            int XYWZS=0;
            for (Map smallDelay:querySmallDelayMap) {
                mapRes.put("XYW"+smallDelay.get("MIS"),smallDelay.get("COUNT"));
                XYWZS+=Integer.parseInt(smallDelay.get("COUNT").toString());
            }
            //对小延误分钟无数据的做补零处理
            if(!mapRes.containsKey("XYW1")){
                mapRes.put("XYW1","0");
            }
            if(!mapRes.containsKey("XYW2")){
                mapRes.put("XYW2","0");
            }
            if(!mapRes.containsKey("XYW3")){
                mapRes.put("XYW3","0");
            }
            if(!mapRes.containsKey("XYW4")){
                mapRes.put("XYW4","0");
            }
            if(!mapRes.containsKey("XYW5")){
                mapRes.put("XYW5","0");
            }



            mapRes.put("XYWZS", XYWZS);

            //出港航班架次
            int queryLeavePortCount=aocRunLettersService.queryLeavePortCount();
            mapRes.put("CGHBZS", queryLeavePortCount);

            //COBT跳变次数
            Map querycobtSaltusStepMap=aocRunLettersService.querycobtSaltusStep();
            if(null!=querycobtSaltusStepMap){
                mapRes.put("COBTTB", querycobtSaltusStepMap.get("COUNT"));
            }else{
                mapRes.put("COBTTB", 0);
            }

            //COBT执行日率最佳
            List<Map>  cobtDailyBestMap=aocRunLettersService.querycobtDailyBest();
            String COBTRZJ="";
            for (Map cobtDailyBest:cobtDailyBestMap) {
                COBTRZJ+=cobtDailyBest.get("AIRLINE_CODE_IATA")+"("+cobtDailyBest.get("COUNT")+"次,"+cobtDailyBest.get("BFB")+"),";
            }
            mapRes.put("COBTRZJ", COBTRZJ);
        }catch(Exception ex){
            ex.printStackTrace();
            return ServerResponse.createByOtherError("AOC运行快报查询异常:"+ex.getMessage());
        }

        return ServerResponse.createBySuccess(mapRes);
    }

    /**
     *
     * @param s
     * @return
     */
    private JinHuFlightVo initJinHuFlightVo(String airportIata) {
        JinHuFlightVo jinHuFlightVo=new JinHuFlightVo();
        switch (airportIata)
        {
            case "PEK":
                jinHuFlightVo.setAirport("北京");
                break;
            case "CAN":
                jinHuFlightVo.setAirport("广州");
                break;
            case "SZX":
                jinHuFlightVo.setAirport("深圳");
                break;
            case "XMN":
                jinHuFlightVo.setAirport("厦门");
                break;
            case "KMG":
                jinHuFlightVo.setAirport("昆明");
                break;
            case "URC":
                jinHuFlightVo.setAirport("乌鲁木齐");
                break;
            case "CKG":
                jinHuFlightVo.setAirport("重庆");
                break;
            case "CTU":
                jinHuFlightVo.setAirport("成都");
                break;

            default:
                break;
        }

        jinHuFlightVo.setNormalNum("0");
        jinHuFlightVo.setAbNormalNum("0");
        jinHuFlightVo.setTotalNum("0");
        jinHuFlightVo.setNormalRate("0%");

        return jinHuFlightVo;
    }

}
