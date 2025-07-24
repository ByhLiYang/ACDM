package com.hq.acdm.model.statistics.estimatedTaxiTimeAccuracy;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/9/20 0020 14:06
 */
@Getter
@Setter
public class EstimatedTaxiTimeAccuracy {
    //返回总数
    private int total;
    //航空公司
    private String airline_CODE_IATA;
    //机型
    private String AIRPORTTYPE;
    //进港EXIT
    private int inbound;
    //出港EXOT
    private int outbound;
    //操作日期
    private String operational_date;
    //百分比
    private String percentage;
    //进港或出港
    private String A_OR_D;
}
