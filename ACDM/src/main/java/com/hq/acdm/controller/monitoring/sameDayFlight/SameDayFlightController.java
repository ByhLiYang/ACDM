package com.hq.acdm.controller.monitoring.sameDayFlight;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.monitoring.sameDayFlight.SameDayFlight;
import com.hq.acdm.model.monitoring.sameDayFlight.FlightInfo;
import com.hq.acdm.model.monitoring.sameDayFlight.FlightInfoNode;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.dynamicFlight.FltMonitorService;
import com.hq.acdm.service.monitoring.sameDayFlight.SameDayFlightService;
import com.hq.acdm.service.realtimeSituation.FlightIndexService;
import com.hq.acdm.util.ConstantUtil;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.vo.dynamicFlight.FishboneDiagramVo;
import com.hq.acdm.vo.dynamicFlight.TLocalFlightInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:40
 */

@Api(description = "当日航班监管")
@RestController
@RequestMapping("/flightSupervision/sameDayFlight")
@Slf4j
public class SameDayFlightController {

    @Resource
    private SameDayFlightService sameDayFlightService;
    @Resource
    private FltMonitorService fltMonitorService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private com.hq.acdm.service.sys.UsersService UsersService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("计划日期")@RequestParam("planDate") String planDate,
                                  @ApiParam("航空公司") @RequestParam("airCompany") String airCompany,
                                  @ApiParam("航班号") @RequestParam("flight_no_iata") String flight_no_iata,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------SameDayFlightController-----------------");
        /*
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("planDate",planDate);
        queryMap.put("airCompany",airCompany);
        queryMap.put("flight_no_iata",flight_no_iata);
        List<SameDayFlight> broadingPortDetail = sameDayFlightService.queryList(queryMap);
        */
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
        queryMap.put("flno",flight_no_iata);
        queryMap.put("airlines",airCompany);
        queryMap.put("appExecDate",planDate);
        queryMap.put("notRun","");
        queryMap.put("delay","");
        queryMap.put("agent","");
        queryMap.put("dept",dept);
        queryMap.put("agentSys",condition);
        List<SameDayFlight> broadingPortDetail = new ArrayList<SameDayFlight>();
        if("".equals(flight_no_iata)){
            return ServerResponse.createBySuccess(broadingPortDetail);
        }else{
            List<TLocalFlightInfoVo> tLocalFlightInfoList = fltMonitorService.findFltInfo(queryMap);
            for(int i=0;i<tLocalFlightInfoList.size();i++){
                TLocalFlightInfoVo vo = tLocalFlightInfoList.get(i);
                SameDayFlight sdf = new SameDayFlight();
                sdf.setFlightIdA(vo.getFlightIdA());
                sdf.setFlightIdD(vo.getFlightIdD());
                sdf.setFLIGHT_NO_IATA(vo.getFlnoA());
                sdf.setFLIGHT_NO_IATA_D(vo.getFlnoD());
                sdf.setORIGIN_AIRPORT_IATA(vo.getAdepD());
                sdf.setDEST_AIRPORT_IATA(vo.getAdesD());
                sdf.setPRE_ATOT(vo.getAtotATime());
                sdf.setALDT(vo.getAldtATime());
                sdf.setATOT(vo.getAtotDTime());
                sdf.setAirCompany(vo.getAirlines());
                broadingPortDetail.add(sdf);
            }
            return ServerResponse.createBySuccess(broadingPortDetail);
        }
    }

    /*0-未完成 1-进行中 2-已完成 3-未录入
    {
	"sobt": "09:55",
	"sibt": "09:55",
	"eldt": "09:55",
	"cobt": "09:55",
	"flight_NO_IATA_A": "MU5555",
	"operational_DATE_A": "2018-11-08",
	"operational_DATE_D": "2018-11-08",
	"stand_A": "355",
	"flight_NO_IATA_D": "MU5555",
	"stand_D": "355",
	"status": "1",
	"data": [{
			"label": "PRE_ATOT",
			"index": "1",
			"value": "10:55",
			"state": "2"
		},
		{
			"label": "ALDT",
			"index": "2",
			"value": "10:55",
			"state": "2"
		},
		{
			"label": "ALDT",
			"index": "3",
			"value": "10:55",
			"state": "1"
		},
		{
			"label": "A_GROUND_TRANSFER",
			"value": "10:55",
			"index": "4",
			"state": "0"
		}
	]


}
     */
    //查询22个时间节点
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryFlight.json", method = RequestMethod.POST)
    public ServerResponse queryFlightInfo(//@ApiParam("出发航班号")@RequestParam("flight_no_iata_d") String flight_no_iata_d,
                                       //@ApiParam("出发日期") @RequestParam("OPERATIONAL_DATE_D")String OPERATIONAL_DATE_D,
                                       @ApiParam("到达航班号") @RequestParam("flight_no_iata") String flight_no_iata,
                                       //@ApiParam("到达日期") @RequestParam("OPERATIONAL_DATE") String OPERATIONAL_DATE,
                                          @ApiParam("航班唯一ID号") @RequestParam("flightId") String flightId,
                                       HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("------------SameDayFlightController queryFlightInfo-----------------:"+flight_no_iata+"-"+OPERATIONAL_DATE);
//        Map<String, Object> queryMap = new HashMap<>();
//        String a_or_d =request.getParameter("a_or_d");
//        if(a_or_d==null||a_or_d.equals(""))a_or_d="A";
//        queryMap.put("flight_no_iata",flight_no_iata);
//        queryMap.put("a_or_d",a_or_d);
//        queryMap.put("OPERATIONAL_DATE",OPERATIONAL_DATE);
//    //    queryMap.put("flight_no_iata_d",flight_no_iata);
//     //   queryMap.put("OPERATIONAL_DATE_D",OPERATIONAL_DATE);
//        FlightInfo info = sameDayFlightService.queryFlightInfo(queryMap);
//        System.out.println(info);
//        Map map=new LinkedHashMap();
//        if(info!=null)
//        queryMap.put("flight_no_iata",info.getFLIGHT_NO_IATA_D());
//        StringBuffer buf =new StringBuffer();
//        List list=sameDayFlightService.queryFlightInfoMore(queryMap);
//        Map map1=new LinkedHashMap();
//        Iterator it1 =list.iterator();
//        if(it1.hasNext())
//          map1=(Map)it1.next();
//        java.math.BigDecimal   checkin=(java.math.BigDecimal )map1.get("COUNT1");//值机人数
//        System.out.println("-------------------------a:"+map1+"-"+checkin);
//        info.setCheckin(String .valueOf(checkin.intValue()) );
//        //if(it1.hasNext())
//        //    map1=(Map)it1.next();
//        java.math.BigDecimal  check=(java.math.BigDecimal)map1.get("COUNT2");
//        System.out.println("-------------------------b:"+map1+"-"+check);
//        info.setCheck(String .valueOf(check.intValue()) );
//        java.math.BigDecimal  bording=(java.math.BigDecimal)map1.get("COUNT3");
//        info.setBoarding(String .valueOf(bording.intValue()) );
//        System.out.println("-------------------------c:"+check);
//
//
//
//
//        map.put("PRE_ATOT","前站起飞");
//        map.put("ALDT","落地");
//        map.put("A_GROUND_TRANSFER","地面移交");
//        map.put("AIBT","挡轮档");
//        map.put("ARSL","靠桥_客梯对接");
//        map.put("ATDO","开客舱门");
//        map.put("ATFO","开货舱门");
//        map.put("ASCT","开始保洁");
//        map.put("AFCT","完成保洁");
//        map.put("ASR","开始加油");
//        map.put("AER","完成加油");
//        map.put("TASC","开始配餐");
//        map.put("AEC","完成配餐");
//        map.put("ASBT","实际开始登机时间");
//        map.put("AEBT","完成登机");
//        map.put("ATDC","关客舱门");
//        map.put("ATFC","关货仓门");
//        map.put("AACT","机务放行");
//        map.put("LSW","离桥/客梯撤离");
//        map.put("AOBT","实际撤轮档时间");
//        map.put("D_GROUND_TRANSFER","离港地面移交");
//        map.put("ATOT","起飞");
//       // map.put("PRE_ATOT","前站起飞");
//
//        System.out.println("-------------------------map:"+map);
//        Iterator it = map.keySet().iterator();
//        int count=0; int current=0;
//        for(count=0;count<22;count++){
//
//            String time="";
//            if(count==1)time=info.getPRE_ATOT();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==2)time=info.getALDT();//System.out.println("time------2"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==3)time=info.getA_GROUND_TRANSFER();//System.out.println("time------3"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==4)time=info.getAIBT();//System.out.println("time------4"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==5)time=info.getARSL();//System.out.println("time------4"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==6)time=info.getATDO();//System.out.println("time------5"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==7)time=info.getATFO();//System.out.println("time------6"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==8)time=info.getASCT();//System.out.println("time------7"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==9)time=info.getAFCT();//System.out.println("time------8"+time);
//             if(time!=null&&!time.equals(""))current=count;
//            if(count==10)time=info.getASR();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==11)time=info.getAER();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==12)time=info.getTASC();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==13)time=info.getAEC();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==14)time=info.getASBT();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==15)time=info.getAEBT();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==16)time=info.getATDC();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==17)time=info.getATFC();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==18)time=info.getAACT();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==19)time=info.getLSW();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==20)time=info.getAOBT();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==21)time=info.getD_GROUND_TRANSFER();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//            if(count==22)time=info.getATOT();//System.out.println("time------1"+time);
//            if(time!=null&&!time.equals(""))current=count;
//           // if(count==22)time=info.getALDT();//System.out.println("time------1"+time);
//      //      if(time!=null&&!time.equals(""))current=count;
//       //    System.out.println("-------------------:current"+current+"-count:"+count);
//
//        }System.out.println("-------------------:current"+current);
//        info.setCurrentStep(new Integer(current));
//         count=0;
//        it = map.keySet().iterator();
//        while(it.hasNext()){count++;
//            String key = (String)it.next();
//            int state=2;
//            if(count>current)state=0;
//            if(count==current)state=1;
//            String value=(String)map.get(key);
//
//
//            FlightInfoNode node2=new FlightInfoNode();
//            node2.setCHNAME(value);
//            node2.setINDEX(String.valueOf(count));
//            node2.setLABEL(key);
//            String time="";
//            if(count==1)time=info.getPRE_ATOT();
//            if(count==2)time=info.getALDT();
//            if(count==3)time=info.getA_GROUND_TRANSFER();
//            if(count==4)time=info.getAIBT();
//            if(count==5)time=info.getARSL();
//            if(count==6)time=info.getATDO();
//            if(count==7)time=info.getATFO();
//            if(count==8)time=info.getASCT();
//            if(count==9)time=info.getAFCT();
//            if(count==10)time=info.getASR();
//            if(count==11)time=info.getAER();
//            if(count==12)time=info.getTASC();
//            if(count==13)time=info.getAEC();
//            if(count==14)time=info.getASBT();
//            if(count==15)time=info.getAEBT();
//            if(count==16)time=info.getATDC();
//            if(count==17)time=info.getATFC();
//            if(count==18)time=info.getAACT();
//            if(count==19)time=info.getLSW();
//            if(count==20)time=info.getAOBT();
//            if(count==21)time=info.getD_GROUND_TRANSFER();
//            if(count==22)time=info.getATOT();
//          //  if(count==21)time=info.getALDT();
//            if(time==null)time="";
//            if((time==null||time.equals(""))&&state==2)state=3;//无值 设置未状态3
//            node2.setVALUE(time);
//            node2.setSTATE(String.valueOf(state));
//         //   System.out.println("-------------------:key"+key+"--------value:"+value+"--------time:"+time+"--------state:"+state);
//            info.addNode(node2);
//        }
//      //return buf.toString();

        FlightInfo info = new FlightInfo();
        List<FlightInfoNode> finList = new ArrayList<FlightInfoNode>();

        Map<String, Object> queryMap = new HashMap<>();
        int flightIdInt = 0;
        if (flightId != null && !"".equals(flightId)){
            flightIdInt = Integer.parseInt(flightId);
        }
        queryMap.put("flightId",flightIdInt);


        String nowTime = DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm");
        //Random random = new Random();
        List<FishboneDiagramVo> listReturn = new ArrayList<FishboneDiagramVo>();
        List<FishboneDiagramVo> list = new ArrayList<FishboneDiagramVo>();
        List<FishboneDiagramVo> listFishboneDiagramVo = fltMonitorService.findNodeConfigColumnInfo();
        for (int i=0;i<listFishboneDiagramVo.size();i++){
            FishboneDiagramVo fdVo = listFishboneDiagramVo.get(i);
            String NODE_COLUMN = fdVo.getNodeColumn();
            String NODE_ESTIMATE_COLUMN = fdVo.getNodeEstimateColumn();
            if(i==0){
                queryMap.put("nodeColumn",NODE_COLUMN);
                queryMap.put("nodeEstimateColumn",NODE_ESTIMATE_COLUMN);
            }else{
                queryMap.remove("nodeColumn");
                queryMap.remove("nodeEstimateColumn");
                queryMap.put("nodeColumn",NODE_COLUMN);
                queryMap.put("nodeEstimateColumn",NODE_ESTIMATE_COLUMN);
            }
            Map<String,Object> map = fltMonitorService.findFishboneDiagramInfo(queryMap);
            if(map != null){
                fdVo.setValue(map.get(NODE_COLUMN) == null ? "" : map.get(NODE_COLUMN).toString());
                fdVo.setEstimateValue(map.get(NODE_ESTIMATE_COLUMN) == null ? "" : map.get(NODE_ESTIMATE_COLUMN).toString());
            }else{
                fdVo.setValue("");
                fdVo.setEstimateValue("");
            }
            //判断状态//状态最新：正常2、未录入0、晚于正常完成3，应开始实际未开始1
            if("".equals(fdVo.getEstimateValue())){
                if(!"".equals(fdVo.getValue())){
                    fdVo.setState("2");
                }else{
                    fdVo.setState("0");
                }
            }else{
                if(!"".equals(fdVo.getValue())){
                    if(fdVo.getEstimateValue().compareTo(fdVo.getValue()) > 0){
                        fdVo.setState("2");
                    }
                    if(fdVo.getEstimateValue().compareTo(fdVo.getValue()) == 0){
                        fdVo.setState("2");
                    }
                    if(fdVo.getEstimateValue().compareTo(fdVo.getValue()) < 0){
                        fdVo.setState("3");
                    }
                }else{
                    if(fdVo.getEstimateValue().compareTo(nowTime) > 0){
                        fdVo.setState("0");
                    }
                    if(fdVo.getEstimateValue().compareTo(nowTime) == 0){
                        fdVo.setState("1");
                    }
                    if(fdVo.getEstimateValue().compareTo(nowTime) < 0){
                        fdVo.setState("1");
                    }
                }
            }
            //fdVo.setState("2");//String.valueOf(random.nextInt(4))
            list.add(fdVo);
        }

        for(int j=0;j<list.size();j++){
            FishboneDiagramVo vo = list.get(j);
            vo.setValue(DateTimeUtil.timeDayFormatByStr(vo.getValue()));
            listReturn.add(vo);
        }

        for(int k=0;k<listReturn.size();k++){
            FishboneDiagramVo vo = listReturn.get(k);
            FlightInfoNode fn = new FlightInfoNode();
            fn.setCHNAME(vo.getNodeName());
            fn.setLABEL(vo.getNodeColumn());
            fn.setVALUE(vo.getValue());
            fn.setINDEX(k+"");
            fn.setSTATE(vo.getState());
            finList.add(fn);
        }
        info.setData(finList);
        info.setFLIGHT_NO_IATA_D(flight_no_iata);

        return ServerResponse.createBySuccess(info);
    }


    /*修改接口
    {       "flight_NO_IATA_A": "MU5555",
            "operational_DATE_A": "2018-11-08",
            "flight_NO_IATA_D": "MU5556",
            "operational_DATE_D": "2018-11-08",
			"label": "ALDT",
			"index": "2",
			"value": "10:55",
		}
     */
    //
    @ApiOperation(httpMethod = "POST", value = "更新时间", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateFlight.json", method = RequestMethod.POST)
    public ServerResponse saveFlightInfo(@ApiParam("到达航班号") @RequestParam("flight_NO_IATA_A") String flight_NO_IATA_A,
                                //   @ApiParam("到达日期") @RequestParam("operational_DATE_A") String operational_DATE_A,
                                   @ApiParam("出发航班号") @RequestParam("flight_NO_IATA_D") String flight_NO_IATA_D,
                                   @ApiParam("出发日期") @RequestParam("operational_DATE_D") String operational_DATE_D,
                                   @ApiParam("22个节点名称") @RequestParam("label") String label,
                                   @ApiParam("修改时间") @RequestParam("value") String value,
                                   @ApiParam("s索引") @RequestParam("index") String index

     ) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("ddhhmmsss");
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp t=new java.sql.Timestamp(System.currentTimeMillis());
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("flight_NO_IATA_A",flight_NO_IATA_A);
       // queryMap.put("operational_DATE_A",operational_DATE_A);
        queryMap.put("flight_NO_IATA_D",flight_NO_IATA_D);
        if(operational_DATE_D!=null&&operational_DATE_D.length()>10)operational_DATE_D=operational_DATE_D.substring(0,10);
        queryMap.put("operational_DATE_D",operational_DATE_D);
        queryMap.put("label",label);
        queryMap.put("value",value);
        queryMap.put("index",index);System.out.println("--------------saveFlightInfo:"+queryMap);
        sameDayFlightService.updateFlightNode(queryMap);
        return ServerResponse.createBySuccess(queryMap);
    }
}
