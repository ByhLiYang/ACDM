package com.hq.acdm.controller.flight;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.flight.DailyFlightMasterService;
import com.hq.acdm.service.flight.VStartFlightLvService;
import com.hq.acdm.model.flight.DailyFlightMaster;
import com.hq.acdm.vo.flight.VStartFlightLvVo;
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
 * @Auther: tonychen
 * @Date: 2018/9/18 10:38
 * @Description:
 */
@Api(description = "航班查询")
@RestController
@RequestMapping("/statisticalReport/dailyFlight")
@Slf4j
public class DailyFlightMasterController {

    @Resource
    private DailyFlightMasterService dailyFlightMasterService;


    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/airCompany.json", method = RequestMethod.GET)
    public ServerResponse findAllCompany() {
        List<String> allCompany = dailyFlightMasterService.getAllCompany();
        return ServerResponse.createBySuccess(allCompany);
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("开始时间")@RequestParam("operationalDate") String operationalDate,
                                @ApiParam("航空公司") @RequestParam("flight_no_iata") String flight_no_iata,
                                HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("operationalDate",operationalDate);
        queryMap.put("flight_no_iata",flight_no_iata);
        List<DailyFlightMaster> dailyFlightMaster = dailyFlightMasterService.queryList(queryMap);
        return ServerResponse.createBySuccess(dailyFlightMaster);
    }

    @ApiOperation(httpMethod = "GET", value = "航班下拉列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryFlightList.json", method = RequestMethod.GET)
    public ServerResponse queryFlightList(@ApiParam("航空公司") @RequestParam("flight_no_iata") String flight_no_iata,
                                HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("flight_no_iata",flight_no_iata);
        List<Map> dailyFlightMaster = dailyFlightMasterService.queryFlightList(queryMap);

        return ServerResponse.createBySuccess(dailyFlightMaster);
    }
}
