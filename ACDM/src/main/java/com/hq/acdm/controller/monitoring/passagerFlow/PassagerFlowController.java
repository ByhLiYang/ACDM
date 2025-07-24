package com.hq.acdm.controller.monitoring.passagerFlow;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.monitoring.passager.PassagerFlow;
import com.hq.acdm.service.monitoring.passagerFlow.PassagerFlowService;
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

@Api(description = "COBT跳变")
@RestController
@RequestMapping("/flightSupervision/passengerFlow")
@Slf4j
public class PassagerFlowController {

    @Resource
    private PassagerFlowService passagerFlowService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryTerminal.json", method = RequestMethod.POST)
    public ServerResponse queryTerminal(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航站楼") @RequestParam("terminal") String terminal,
                                @ApiParam("目的地") @RequestParam("destination") String destination,


                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------PassagerFlowController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("terminal",terminal);
        queryMap.put("destination",destination);


        List<PassagerFlow> passagerFlow = passagerFlowService.queryTerminalPassager(queryMap);
        return ServerResponse.createBySuccess(passagerFlow);
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryAirCompany.json", method = RequestMethod.POST)
    public ServerResponse queryAirCompanyPassager(   @ApiParam("航空公司") @RequestParam("airCompany") String airCompany,
                                                     @ApiParam("目的地") @RequestParam("destination") String destination,


                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------PassagerFlowController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
     //   queryMap.put("startDate",startDate);
   //     queryMap.put("endDate",endDate);
        queryMap.put("airCompany",airCompany);
        queryMap.put("destination",destination);


        List<PassagerFlow> passagerFlow = passagerFlowService.queryAirCompanyPassager(queryMap);
        return ServerResponse.createBySuccess(passagerFlow);
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryHourPassager.json", method = RequestMethod.POST)
    public ServerResponse queryHourPassager(@ApiParam("开始时间")@RequestParam("planDate") String startDate,
                                        @ApiParam("航站楼") @RequestParam("terminal") String terminal,
                                        HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------PassagerFlowController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("planDate",startDate);
        queryMap.put("terminal",terminal);


        List<PassagerFlow> passagerFlow = passagerFlowService.queryHourPassager(queryMap);
        return ServerResponse.createBySuccess(passagerFlow);
    }
}
