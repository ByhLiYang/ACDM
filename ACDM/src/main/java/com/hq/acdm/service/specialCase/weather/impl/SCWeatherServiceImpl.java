package com.hq.acdm.service.specialCase.weather.impl;

import com.hq.acdm.dao.specialCase.SCWeatherMapper;
import com.hq.acdm.model.specialCase.weather.WeatherModel;
import com.hq.acdm.service.specialCase.weather.SCWeatherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/12/29 0029 13:51
 */
@Service("WeatherService")
public class SCWeatherServiceImpl implements SCWeatherService {
    @Resource
    private SCWeatherMapper SCWeatherMapper;
    @Override
    public List<WeatherModel> queryWeatherInfoByDay() {
        return SCWeatherMapper.getWeatherByDay();
    }

    @Override
    public List<WeatherModel> queryWeatherInfoByAirport(Map<String, Object> map) {
        return SCWeatherMapper.getWeatherByAirport(map);
    }
}
