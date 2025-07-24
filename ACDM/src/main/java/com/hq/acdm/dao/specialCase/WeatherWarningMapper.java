package com.hq.acdm.dao.specialCase;

import com.hq.acdm.model.specialCase.weather.WeatherWarningModel;

import java.util.List;

/**
 * @author wangshuhao
 * @date 2019/1/15 0015 15:19
 */
public interface WeatherWarningMapper {
    List<WeatherWarningModel> queryWeatherWarningByAirport();
    List<WeatherWarningModel> queryWeatherWarningByArea();
}
