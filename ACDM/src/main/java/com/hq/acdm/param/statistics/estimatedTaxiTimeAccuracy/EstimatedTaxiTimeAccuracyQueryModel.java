package com.hq.acdm.param.statistics.estimatedTaxiTimeAccuracy;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * @Auther: wangshuhao
 * @Date: 2018/9/19 10:38
 * @Description:
 */
@Getter
@Setter
public class EstimatedTaxiTimeAccuracyQueryModel {
    //开始日期
    private Date start_time;
    //结束日期
    private Date end_time;
    //航空公司
    private String airline_code_iata;
    //机型
    private String plane_model;
    //滑动类型
    private String taxi_type;
}
