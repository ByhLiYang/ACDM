package com.hq.acdm.model.monitoring.position;

import lombok.Getter;
import lombok.Setter;

/** 远机位候机厅
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class farArea {//登机口使用明细
    private String AIRLINE_CODE_IATA;//航空公司
    private String OPERATIONAL_DATE;//计划日期

    //登机口
    private String AREAID;
    //COBT
    private String FLIGHT_COUNT;
    //日期时间
    private String SOBT_DATE;
    private String SOBT;

    private String HIGH_HOUR;
    private String HIGH_FLIGHT_NUMS;
    private String HIGH_MAX_NUMS;
    //使用次数
     private String USEDTIMES;

    private String PAX_NUM;
    //使用时间
    private String MAX_NUM;

}