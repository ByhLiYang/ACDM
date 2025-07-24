package com.hq.acdm.service.specialCase.weather.impl;

import com.hq.acdm.dao.specialCase.WeatherWarningMapper;
import com.hq.acdm.model.specialCase.weather.WeatherWarningModel;
import com.hq.acdm.service.specialCase.weather.WeatherWarningService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangshuhao
 * @date 2019/1/15 0015 15:22
 */
@Service("WeatherWarningService")
public class WeatherWarningServiceImpl implements WeatherWarningService {
    @Resource
    private WeatherWarningMapper weatherWarningMapper;
    @Override
    public List<WeatherWarningModel> queryWeatherWarningByAirport() {
        return weatherWarningMapper.queryWeatherWarningByAirport();
    }

    @Override
    public List<WeatherWarningModel> queryWeatherWarningByArea() {
        return weatherWarningMapper.queryWeatherWarningByArea();
    }
}
