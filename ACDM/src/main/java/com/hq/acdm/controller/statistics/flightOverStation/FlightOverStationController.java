package com.hq.acdm.controller.statistics.flightOverStation;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.flightOverStation.Delay;
import com.hq.acdm.service.statistics.flightOverStation.FlightOverStationService;
import com.hq.acdm.vo.statistics.flightOverStation.DelayVo;
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
import java.util.ArrayList;
import java.util.List;

@Api(description = "航班过站时间")
@RestController
@RequestMapping("/statisticalReport/standingTime")
@Slf4j
public class FlightOverStationController {

    @Resource
    private FlightOverStationService flightOverStationService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("延误") @RequestParam("delay") String delay,
                                @ApiParam("开始时间") @RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate") String endDate,
                                HttpServletRequest request, HttpServletResponse response) {
        List<Delay> list;
        if(delay!=null && delay.equals("Y"))
            list =flightOverStationService.queryDelay(startDate,endDate);
        else if(delay!=null && delay.equals("N"))
            list =flightOverStationService.queryNotDelay(startDate,endDate);
        else
            list =flightOverStationService.queryFlightOver(startDate,endDate);

        List<DelayVo> delayVoList=new ArrayList<>();
        for (Delay delays:list){
            DelayVo delayVo=new DelayVo();
            delayVo.setA_IATA(delays.getIATA_A());//进港航班号
            delayVo.setA_DATE(delays.getOPERATIONAL_DATE());//日期

            delayVo.setD_IATA(delays.getIATA_D());
            delayVo.setD_DATE(delays.getDATE_D());
            delayVo.setOverTime(delays.getTM());

            if(delays.getSOBT()!=null&&delays.getSOBT().length()>0){
                delayVo.setSOBT(formatdate(delays.getSOBT(), delays.getDATE_D()));//实际起飞时间
            }else{
                delayVo.setSOBT("");
            }
            if(delays.getSIBT()!=null&&delays.getSIBT().length()>0){
                delayVo.setSIBT(formatdate(delays.getSIBT(),delays.getOPERATIONAL_DATE()));//实际起飞时间
            }else{
                delayVo.setSIBT("");
            }
            delayVoList.add(delayVo);
        }
        return ServerResponse.createBySuccess(delayVoList);

    }

    public String formatdate(String param1,String param2){
        String yandm = "";
        String Stime = "";
        String yandm1 = "";
        if(param2==null&&param1!=null&&param1!=""){
            return param1.split(" ")[1];
        }else if(param2!=null){
            if("".equals(param1)||param1==null){
                return param1;
            }else{
                yandm = param1.split(" ")[0];
                Stime = yandm.split("-")[2];
                yandm1 = param2.split("-")[2];
                int temp1 = Integer.parseInt(Stime);
                int temp2 = Integer.parseInt(yandm1);
                if(temp1-temp2>0){
                    temp1 = temp1-temp2;
                    yandm = temp1+"";
                    param1 = param1+"("+"+"+yandm+")";
                }else if(temp1-temp2<0){
                    temp1 = temp1-temp2;
                    yandm = temp1+"";
                    param1 = param1+"("+yandm+")";
                }
            }
        }

        return param1.split(" ")[1];

    }
}
