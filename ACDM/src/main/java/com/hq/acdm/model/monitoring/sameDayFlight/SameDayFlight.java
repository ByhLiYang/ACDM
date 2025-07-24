package com.hq.acdm.model.monitoring.sameDayFlight;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class SameDayFlight {
    private String flightIdA;//进港航班唯一ID
    private String flightIdD;//出港航班唯一ID
    private String FLIGHT_NO_IATA;//航班号
    private String OPERATIONAL_DATE;//计划日期
    private String FLIGHT_NO_IATA_D;//航班号
    private String airCompany;//航司二码
    //进出港标识
    private String A_OR_D;
    //SIBT
    private String SIBT;

    //ELDT
    private String ELDT;

    private String PRE_ATOT;//前站起飞

    private String ALDT;//实际落地时间

    private String ATOT;//实际起飞时间

    //AIBT
    private String AIBT;

    //跑道
    private String STAND;

    //目的站/经停站
    private String DEST_AIRPORT_IATA;

    //始发站/经停站
    private String ORIGIN_AIRPORT_IATA;

   //SOBT
   private String SOBT;

    //是否严格流控
    private int isstrictctrl_a;

    private String flight_status_code_a;//状态

    private String isstrictctrl_d;

    private String flight_status_code_d;//状态

    private String isdelay;//小延误

   //AOBT
   private String AOBT;

}