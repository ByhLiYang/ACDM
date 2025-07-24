package com.hq.acdm.controller.specialCase;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.specialCase.weather.WeatherModel;
import com.hq.acdm.service.specialCase.weather.SCWeatherService;
import com.hq.acdm.service.specialCase.weather.WeatherWarningService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/12/29 0029 13:47
 */
@Api(description = "天气")
@RestController
@RequestMapping("/specialCase/weather")
@Slf4j
public class WeatherController {
    @Resource
    private SCWeatherService SCWeatherService;
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryByAirport.json", method = RequestMethod.POST)
    public ServerResponse queryByAirport(@ApiParam("机场")@RequestParam("airportCode") String airportCode,
                                HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        List<WeatherModel> list = new ArrayList<>();
        if(airportCode.length()==4){
            queryMap.put("airportCode",airportCode);
            list =  SCWeatherService.queryWeatherInfoByAirport(queryMap);
        }
        return ServerResponse.createBySuccess(list);
    }

    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryByDay.json", method = RequestMethod.GET)
    public ServerResponse queryByDay() {
        return ServerResponse.createBySuccess(SCWeatherService.queryWeatherInfoByDay());
    }
    @Resource
    private WeatherWarningService weatherWarningService;

    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryByWarningAirport.json", method = RequestMethod.GET)
    public ServerResponse queryByWarningAirport() {
        return ServerResponse.createBySuccess(weatherWarningService.queryWeatherWarningByAirport());
    }

    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryByWarningArea.json", method = RequestMethod.GET)
    public ServerResponse queryByWarningArea() {
        return ServerResponse.createBySuccess(weatherWarningService.queryWeatherWarningByArea());
    }
}
