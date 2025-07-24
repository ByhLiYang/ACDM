package com.hq.acdm.model.statistics.averageCrossingTime;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author wangshuhao
 * @date 2018/9/20 0020 14:29
 */
@Getter
@Setter
public class AverageCrossingTime {
    //返回总数
    private String sobt_date;
    //航空公司
    private String AIRLINE_CODE_IATA;
    //机型
    private String AIRPORTTYPE;
    //总过站
    private int pstt;
    //平均过站（avg)
    private int avgpst;
    //总数
    private int total;

}