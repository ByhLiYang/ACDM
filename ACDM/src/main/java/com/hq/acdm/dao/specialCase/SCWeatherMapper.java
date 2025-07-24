package com.hq.acdm.dao.specialCase;

import com.hq.acdm.model.index.Weather;
import com.hq.acdm.model.specialCase.weather.WeatherModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/12/29 0029 13:45
 */
public interface SCWeatherMapper {
    List<WeatherModel> getWeatherByDay();
    List<WeatherModel> getWeatherByAirport(@Param("params")Map<String,Object> map);
}
