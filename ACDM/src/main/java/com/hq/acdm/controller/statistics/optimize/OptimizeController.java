package com.hq.acdm.controller.statistics.optimize;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.optimize.optimizeModel;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/12/3 0003 15:10
 */
@Api(description = "优化建议")
@RestController
@RequestMapping("/unfavorableSynergy/bigDelay/optimize")
@Slf4j
public class OptimizeController {
    @Resource
    private OptimizeService optimizeService;
    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.GET)
    public ServerResponse query() throws ParseException {
        Map<String,Object> map = optimizeService.queryByTime();
        return ServerResponse.createBySuccess(map);
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryOne.json", method = RequestMethod.POST)
    public ServerResponse queryOne(@ApiParam("航班号") @RequestParam("flight_number") String flightNumber,
                                        @ApiParam("进出港") @RequestParam("a_or_d") String a_or_d,
                                        @ApiParam("操作日期") @RequestParam("operational_date") String operationalDate,
                                        @ApiParam("重复航班号") @RequestParam("flight_repeat_count") String flightRepeatCount,
                                        HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<>();
        map.put("flightNumber",flightNumber);
        map.put("a_or_d",a_or_d);
        map.put("operationalDate",operationalDate.substring(0,10));
        map.put("flightRepeatCount",flightRepeatCount);
        optimizeModel optimizeModel = optimizeService.queryOne(map);
        return ServerResponse.createBySuccess(optimizeModel);
    }
}
