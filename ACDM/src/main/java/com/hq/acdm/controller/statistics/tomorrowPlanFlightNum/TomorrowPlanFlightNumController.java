package com.hq.acdm.controller.statistics.tomorrowPlanFlightNum;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.averageCrossingTime.AverageCrossingTime;
import com.hq.acdm.model.statistics.tomorrowPlanFlightNum.TomorrowPlanFlightNum;
import com.hq.acdm.service.statistics.tomorrowPlanFlightNum.TomorrowPlanFlightNumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * @author wangshuhao
 * @date 2018/10/16 0016 17:29
 */
@Api(description = "次日计划航班数")
@RestController
@RequestMapping("/statisticalReport/tomorrowPlanFlightNum")
@Slf4j
public class TomorrowPlanFlightNumController {
    @Resource
    private TomorrowPlanFlightNumService tomorrowPlanFlightNumService;

    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.GET)
    public ServerResponse query(HttpServletRequest request, HttpServletResponse response) {

        return ServerResponse.createBySuccess(tomorrowPlanFlightNumService.query());
    }
}
