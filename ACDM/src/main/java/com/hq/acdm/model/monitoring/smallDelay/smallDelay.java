package com.hq.acdm.model.monitoring.smallDelay;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class smallDelay {
   // var data={"SIBT":"计划上轮挡时间","ALDT":"实际落地时间","AIBT":"实际上轮档时间","AXIT":"实际滑入时间","SOBT":"计划撤轮档时间","TOBT":"目标撤轮档时间",
   // "COBT":"空管计算撤轮档时间","T_TOBT":"空管目标撤轮档时间","A_TOBT":"机场目标撤轮档时间","ASBT":"实际开始登机时间","ARDT":"实际结束登机时间","ACCT":"实际关舱门时间",
   // "AOBT":"实际撤轮档时间","CTOT":"空管计算起飞时间","ATOT":"实际起飞时间","AXOT":"实际滑出时间","ATTT":"实际过站时间","A_TMO":"十海里时间","A_AIBT":"入位时间",
   // "A_AOBT":"离位时间"};
    //进港航班/日期/机位
    private String FLIGHT_NO_IATA;
 private String OPERATIONAL_DATE;

    //始发站/经停站
    private String ORIGIN_AIRPORT_IATA;
    //SIBT
    private String SIBT;

    //ALDT
    private String ALDT;
    //AIBT
    private String AIBT;
    //A_AIBT
    private String A_AIBT;

    //出港航班/日期/机位
    private String ORIGIN_AIRPORT_IATA_D;
   private String OPERATIONAL_DATE_D;
   private String FLIGHT_NO_IATA_D;
    //目的站/经停站
    private String DEST_AIRPORT_IATA;

    private String  airline_code_icao;

    //SOBT
    private String SOBT;

    //正常起点航班
    private String COBT;
    private String  ctot_Sobt;


    private String CTOT;
    //tobt遵从度
    private String AOBT;
    private String isStrictCtrl;

    private String ATOT;
    private Integer STATUS;//小延误协同状态
    private String SENDER;//小延误协同发送人
    private String RECEIVER;//小延误协同接受人

}