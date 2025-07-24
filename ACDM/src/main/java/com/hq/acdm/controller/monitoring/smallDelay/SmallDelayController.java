package com.hq.acdm.controller.monitoring.smallDelay;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.monitoring.smallDelay.smallDelay;
import com.hq.acdm.model.monitoring.smallDelay.SmallDelayStatus;
import com.hq.acdm.service.monitoring.smallDelay.SmallDelayService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:40
 */

@Api(description = "航班小延误")
@RestController
@RequestMapping("/unfavorableSynergy/smallDelay")
@Slf4j
public class SmallDelayController {

    @Resource
    private SmallDelayService smallDelayService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airline_code_iata,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------SmallDelayController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("airCompany",airline_code_iata);

        List<smallDelay> baggageFlights = smallDelayService.queryList(queryMap);
        return ServerResponse.createBySuccess(baggageFlights);
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryStatus.json", method = RequestMethod.POST)
    public ServerResponse queryDelayStatus(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airline_code_iata,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------SmallDelayController queryStatus-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("airCompany",airline_code_iata);

        List<SmallDelayStatus> smallDelayStatus = smallDelayService.queryStatusList(queryMap);
        return ServerResponse.createBySuccess(smallDelayStatus);
    }

    @ApiOperation(httpMethod = "POST", value = "新增用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    public ServerResponse insertDelayStatus(SmallDelayStatus status) {
        System.out.println("------------SmallDelayController insertDelayStatus-----------------");
        java.sql.Timestamp t=new java.sql.Timestamp(System.currentTimeMillis());
        status.setCONCERT_TIME(t);
        smallDelayService.insert(status);
        status.setRECEIVER("atcu01");//同时发送给空管
        smallDelayService.insert(status);
        return ServerResponse.createBySuccess();
    }
    @ApiOperation(httpMethod = "POST", value = "新增用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    public ServerResponse updateDelayStatus(SmallDelayStatus status) {
        System.out.println("------------SmallDelayController insertDelayStatus-----------------");
        java.sql.Timestamp t=new java.sql.Timestamp(System.currentTimeMillis());
        status.setBEGIN_TIME(t);
        status.setEND_TIME(t);
        smallDelayService.updateStatus(status);
        return ServerResponse.createBySuccess();
    }
}
