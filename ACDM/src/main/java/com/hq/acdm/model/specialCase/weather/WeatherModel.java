package com.hq.acdm.model.specialCase.weather;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/12/29 0029 13:41
 */
@Getter
@Setter
public class WeatherModel {
    //机场
    private String AIRPORTCODE;
    //观察时间
    private String OBSERVETIME;
    //风速
    private String WIND;
    //能见度
    private String VISIBILITY;
    //天气
    private String WEATHER;
    //云
    private String CLOUD;
    //温度
    private String TEMPERATURE;
    //气压
    private String AIRPRESSURE;
    //天气代码
    private String WEATHERCODE;
    //插入时间
    private String INSERTDATE;


}
