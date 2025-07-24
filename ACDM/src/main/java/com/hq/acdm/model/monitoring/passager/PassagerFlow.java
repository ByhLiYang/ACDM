package com.hq.acdm.model.monitoring.passager;

import lombok.Getter;
import lombok.Setter;

/** 客流监管
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class PassagerFlow {//出港航班客流监管
    private String DPERATION_DATE;//航空公司
    private String AIRPORT_DEST;//计划日期
    private String dest_AIRPORT_IATA;//航空公司
    private String TERMINAL;//航空公司
    private String AREAID;//航空公司

    private String STAND;//航班号
    private String GATE1;//航班号

    //登机口
    private String PAX_FLIGHTNO;

    //登机口
    private String PAX_CHECKIN_TIME;
    //COBT
    private String PAX_BOARDING_TIME;
    //目的地
        private String PAX_SECURITYCHECK_TIME;

    //使用时间
     private String USED_TIME;

    //登机口
     private String PAX_BOARDING_SUM;
      private String PAX_CHECKED_SUM;
    private String PAX_CHECKINGAREA_SUM;
     private String PAX_SECURITY_SUM;
    private String PAX_SECURITYAREA_SUM;

    private String airline_Code_Iata;

 //  private String airport_Dest;

    private Short checkin;

    private Short security;

    private Short notsecurity;

    private String pax_count_hour24h;
    private String pax_count_date;

    private Short boarding;

    private Short waiting;
}