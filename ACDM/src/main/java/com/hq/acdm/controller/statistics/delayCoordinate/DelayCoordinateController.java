package com.hq.acdm.controller.statistics.delayCoordinate;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.monitoring.sameDayFlight.FlightInfo;
import com.hq.acdm.model.monitoring.sameDayFlight.FlightInfoNode;
import com.hq.acdm.model.statistics.delayCoordinate.DelayCoordinateModel;
import com.hq.acdm.model.statistics.flightQuery.Location;
import com.hq.acdm.model.statistics.optimize.optimizeModel;
import com.hq.acdm.service.monitoring.sameDayFlight.SameDayFlightService;
import com.hq.acdm.service.statistics.DelayCoordinate.DelayCoordinateService;
import com.hq.acdm.service.statistics.optimize.OptimizeService;
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
 * @author wangshuhao
 * @date 2018/12/6 0006 13:48
 */
@Api(description = "延误协调")
@RestController
@RequestMapping("/delay/coordinate")
@Slf4j
public class DelayCoordinateController {
    @Resource
    private DelayCoordinateService delayCoordinateService;
    @Resource
    private OptimizeService optimizeService;
    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.GET)
    public ServerResponse query() {
        List<DelayCoordinateModel> list = delayCoordinateService.queryDelay();
        for(DelayCoordinateModel delayCoordinateModel:list){
            Map<String, Object> queryMap = new HashMap<>();
            try {
                queryMap.put("flightNumber",delayCoordinateModel.getFLIGHT_NO_IATA());
                queryMap.put("operationalDate",delayCoordinateModel.getOPERATIONAL_DATE().substring(0,10));
                queryMap.put("a_or_d",delayCoordinateModel.getA_OR_D());
                queryMap.put("flightRepeatCount",delayCoordinateModel.getFLIGHT_REPEAT_COUNT());
                //    queryMap.put("flight_no_iata_d",flight_no_iata);
                //   queryMap.put("OPERATIONAL_DATE_D",OPERATIONAL_DATE);
                optimizeModel info = optimizeService.queryOne(queryMap);
                System.out.println(info);
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
                // map.put("PRE_ATOT","前站起飞");

                System.out.println("-------------------------map:"+map);
                Iterator it = map.keySet().iterator();
                int count=0; int current=8;
                for(count=0;count<22;count++){

                    String time="";
                    if(count==1)time=info.getATOT();System.out.println("time------1"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==2)time=info.getALDT();System.out.println("time------2"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==3)time=info.getA_GROUND_TRANSFER();System.out.println("time------3"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==4)time=info.getAIBT();//System.out.println("time------4"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==5)time=info.getARSL();//System.out.println("time------4"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==6)time=info.getATDO();//System.out.println("time------5"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==7)time=info.getATFO();//System.out.println("time------6"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==8)time=info.getASCT();//System.out.println("time------7"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==9)time=info.getAFCT();//System.out.println("time------8"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==10)time=info.getASR();//System.out.println("time------1"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==11)time=info.getAER();//System.out.println("time------1"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==12)time=info.getTASC();//System.out.println("time------1"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==13)time=info.getAEC();//System.out.println("time------1"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==14)time=info.getASBT();//System.out.println("time------1"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==15)time=info.getAEBT();//System.out.println("time------1"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==16)time=info.getATDC();//System.out.println("time------1"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==17)time=info.getAACT();//System.out.println("time------1"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==18)time=info.getLSW();//System.out.println("time------1"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==19)time=info.getAOBT();//System.out.println("time------1"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==20)time=info.getD_GROUND_TRANSFER();//System.out.println("time------1"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    if(count==21)time=info.getATOT();//System.out.println("time------1"+time);
                    if(time!=null&&!time.equals(""))current=count;
                    // if(count==22)time=info.getALDT();//System.out.println("time------1"+time);
                    //      if(time!=null&&!time.equals(""))current=count;
                    //    System.out.println("-------------------:current"+current+"-count:"+count);

                }
                System.out.println("-------------------:current"+current);
                double progress = Math.round(current*100.0/22);
                delayCoordinateModel.setPROCESS(progress);
            }
            catch (Exception e){
                System.out.println("error");
                System.out.println(e.toString());
            }

        }

        return ServerResponse.createBySuccess(list);
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryOne.json", method = RequestMethod.POST)
    public ServerResponse queryOne(@ApiParam("操作") @RequestParam("operation") String operation,
                                        HttpServletRequest request, HttpServletResponse response) {


        return null;
    }
}
