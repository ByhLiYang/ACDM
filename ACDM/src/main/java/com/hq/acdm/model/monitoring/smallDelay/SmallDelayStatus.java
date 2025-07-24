package com.hq.acdm.model.monitoring.smallDelay;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class SmallDelayStatus {
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
    private String A_OR_D;

    //出港航班/日期/机位
    private String FLIGHT_NO_IATA_D;

    //开始协调时间
   private Timestamp BEGIN_TIME;
   //结束协调时间
   private Timestamp END_TIME;
   //计划协调时间
   private Timestamp SCHEDULE_TIME;
   //计划协调时间
   private Timestamp CONCERT_TIME;
   //发送账号
   private String SENDER;
   //接受账号
   private String RECEIVER;

    //SOBT
    private String SOBT;
    private String STATUS;

    //正常起点航班
    private String COBT;


    private String CTOT;
    //tobt遵从度
    private String AOBT;

    private String ATOT;

    public void setCONCERT_TIME(Timestamp CONCERT_TIME){
        this.CONCERT_TIME=CONCERT_TIME;
    }
    public void setBEGIN_TIME(Timestamp BEGIN_TIME){
        this.BEGIN_TIME=BEGIN_TIME;
    }
    public void setEND_TIME(Timestamp END_TIME){
        this.END_TIME=END_TIME;
    }

}