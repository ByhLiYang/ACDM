package com.hq.acdm.controller.statistics.flightEveryDayExport;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.statistics.flightEveryDay.FlightEveryDaySevice;
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
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2019/1/10 0010 13:49
 */
@Api(description = "集团每日导出")
@RestController
@RequestMapping("/flightEveryDay/export")
@Slf4j
public class FlightEveryDayController {
    @Resource
    private FlightEveryDaySevice flightEveryDaySevice;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(
                                @ApiParam("日期") @RequestParam("queryDate") String queryDate,
                                HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("date",queryDate);
        return ServerResponse.createBySuccess(flightEveryDaySevice.queryByDate(queryMap));
    }
}
