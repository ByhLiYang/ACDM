package com.hq.acdm.controller.monitoring.position;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.monitoring.position.availablePosition;
import com.hq.acdm.model.monitoring.position.farArea;
import com.hq.acdm.service.monitoring.position.PositionService;
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

@Api(description = "机位相关查询")
@RestController
@RequestMapping("/resourceRegulation/position")
@Slf4j
public class PositionController {

    @Resource
    private PositionService positionService;
    //可使用机位
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryFree1.json", method = RequestMethod.POST)
    public ServerResponse queryFree(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airline_code_iata,
                                @ApiParam("航站楼") @RequestParam("terminal") String terminal,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------PositionController queryFree-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("airCompany",airline_code_iata);
        queryMap.put("terminal",terminal);
        List<availablePosition> availablePosition = positionService.queryFree(queryMap);
        return ServerResponse.createBySuccess(availablePosition);
    }
    //机位使用明细
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryDetail.json", method = RequestMethod.POST)
    public ServerResponse queryDetail(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airline_code_iata,
                                @ApiParam("机位号") @RequestParam("stand") String stand,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------PositionController queryDetail-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("airCompany",airline_code_iata);
        queryMap.put("stand",stand);

        List<availablePosition> availablePosition = positionService.queryDetail(queryMap);
        return ServerResponse.createBySuccess(availablePosition);
    }
    //机位使用汇总
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/querySummary.json", method = RequestMethod.POST)
    public ServerResponse querySummary(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                      @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                      @ApiParam("航空公司") @RequestParam("airCompany") String airline_code_iata,
                                      HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------PositionController querySummary-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("airCompany",airline_code_iata);

        List<availablePosition> broadingPortDetail = positionService.querySummary(queryMap);
        return ServerResponse.createBySuccess(broadingPortDetail);
    }
    //远机位候机厅使用汇总
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryFar.json", method = RequestMethod.POST)
    public ServerResponse queryFar(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                       @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                       @ApiParam("候机厅") @RequestParam("areaid") String areaid,
                                       HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------PositionController querySummary-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("areaid",areaid);

        List<farArea> broadingPortDetail = positionService.queryFar(queryMap);
        return ServerResponse.createBySuccess(broadingPortDetail);
    }
}
