package com.hq.acdm.service.specialCase.weather;

import com.hq.acdm.model.specialCase.weather.WeatherModel;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/12/29 0029 13:49
 */
public interface SCWeatherService {
    List<WeatherModel> queryWeatherInfoByDay();
    List<WeatherModel> queryWeatherInfoByAirport(Map<String,Object> map);
}
