package com.hq.acdm.controller.statistics.monthlyStatistics;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.statistics.monthlyStatistics.MonthlyStatisticsService;
import com.hq.acdm.vo.statistics.monthlyStatistics.MonthlyStatisticsVo;
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
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/12/25 14:53
 * @Description
 */
@Api(description = "月统计")
@RestController
@RequestMapping("/statisticalReport/monthlyStatistics")
@Slf4j
public class MonthlyStatisticsController {
    @Resource
    private MonthlyStatisticsService monthlyStatisticsService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse<List<MonthlyStatisticsVo>> query(@ApiParam("开始时间") @RequestParam("startDate") String startDate,
                                                           @ApiParam("结束时间") @RequestParam("endDate") String endDate, HttpServletRequest request, HttpServletResponse response) {
        return ServerResponse.createBySuccess(monthlyStatisticsService.findMonthlyStatistics(startDate,endDate));
    }
}
