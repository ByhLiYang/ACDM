package com.hq.acdm.controller.monitoring.flightSorting;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.monitoring.flightSorting.FlightSorting;
import com.hq.acdm.service.monitoring.flightSorting.FlightSortingService;
import com.hq.acdm.service.monitoring.sameDayFlight.SameDayFlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
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

@Api(description = "CDM TOBT遵从度")
@RestController
@RequestMapping("/situationalMonitoring/flightSorting")
@Slf4j
public class FlightSortingController {

    @Resource
    private FlightSortingService flightSortingService;
    @Resource
    private SameDayFlightService sameDayFlightService;
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryArrival.json", method = RequestMethod.POST)
    public ServerResponse queryArrival(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airCompany,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------FlightSortingController-----------------");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("airCompany",airCompany);

        List<FlightSorting> flightSorting = flightSortingService.queryArrival(queryMap);
        return ServerResponse.createBySuccess(flightSorting);
    }
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryDeparture.json", method = RequestMethod.POST)
    public ServerResponse queryDeparture(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                       @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                       @ApiParam("航空公司") @RequestParam("airCompany") String airline_code_iata,
                                       HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------FlightSortingController-----------------");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("airCompany",airline_code_iata);

        List<FlightSorting> flightSorting = flightSortingService.queryDeparture(queryMap);
        Iterator it = flightSorting.iterator();

        while(it.hasNext()){
            FlightSorting flight=(FlightSorting)it.next();
            Map<String, Object> queryMap2 = new HashMap<>();
            queryMap2.put("OPERATIONAL_DATE",flight.getOPERATIONAL_DATE());
            queryMap2.put("flight_no_iata",flight.getFLIGHT_NO_IATA_A());
            queryMap2.put("a_or_d","A");
            System.out.println("------------------------queryMap2:"+queryMap2);
             com.hq.acdm.model.monitoring.sameDayFlight.FlightInfo info =sameDayFlightService.queryFlightInfo(queryMap2);
             if(info!=null) {
                 Map map=new LinkedHashMap();
                 map.put("PRE_ATOT","前站起飞");
                 map.put("ALDT","落地");
                 map.put("A_GROUND_TRANSFER","地面移交");
                 map.put("AIBT","挡轮档");
                 map.put("ARSL","靠桥_客梯对接");
                 map.put("ATDO","开客舱门");
                 map.put("ATFO","开货舱门");
                 map.put("ASCT","开始保洁");
                 map.put("AFCT","完成保洁");
                 map.put("ASR","开始加油");
                 map.put("AER","完成加油");
                 map.put("TASC","开始配餐");
                 map.put("AEC","完成配餐");
                 map.put("ASBT","实际开始登机时间");
                 map.put("AEBT","完成登机");
                 map.put("ATDC","关客舱门");
                 map.put("AACT","关货仓门");
                 map.put("LSW","离桥/客梯撤离");
                 map.put("AOBT","实际撤轮档时间");
                 map.put("D_GROUND_TRANSFER","离港地面移交");
                 map.put("ATOT","起飞");
                  System.out.println("-------------------------map:"+map);

                 int count=0; int current=0;
                 for(count=0;count<22;count++){
                     String time="";
                     if(count==1)time=info.getPRE_ATOT();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==2)time=info.getALDT();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==3)time=info.getA_GROUND_TRANSFER();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==4)time=info.getAIBT();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==5)time=info.getARSL();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==6)time=info.getATDO();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==7)time=info.getATFO();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==8)time=info.getASCT();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==9)time=info.getAFCT();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==10)time=info.getASR();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==11)time=info.getAER();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==12)time=info.getTASC();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==13)time=info.getAEC();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==14)time=info.getASBT();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==15)time=info.getAEBT();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==16)time=info.getATDC();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==17)time=info.getAACT();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==18)time=info.getLSW();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==19)time=info.getAOBT();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==20)time=info.getD_GROUND_TRANSFER();
                     if(time!=null&&!time.equals(""))current=count;
                     if(count==21)time=info.getATOT();
                     if(time!=null&&!time.equals(""))current=count;
                 }System.out.println("-------------------:current"+current);

                 int progress=0;
                 progress=(int)(current*100/22);
                 System.out.println("------------------------queryMap2:"+queryMap2+"-step:"+progress);
                 flight.setProgress(progress);
             }

        }

        return ServerResponse.createBySuccess(flightSorting);
    }
}
