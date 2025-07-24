package com.hq.acdm.service.specialCase.weather;

import com.hq.acdm.model.specialCase.weather.WeatherWarningModel;

import java.util.List;

/**
 * @author wangshuhao
 * @date 2019/1/15 0015 15:21
 */
public interface WeatherWarningService {
    List<WeatherWarningModel> queryWeatherWarningByAirport();
    List<WeatherWarningModel> queryWeatherWarningByArea();
}
