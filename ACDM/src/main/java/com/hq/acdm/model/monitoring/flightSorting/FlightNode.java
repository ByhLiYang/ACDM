package com.hq.acdm.model.monitoring.flightSorting;

import lombok.Getter;
import lombok.Setter;

/** 22个节点查询
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class FlightNode {
   // var data={"SIBT":"计划上轮挡时间","ALDT":"实际落地时间","AIBT":"实际上轮档时间","AXIT":"实际滑入时间","SOBT":"计划撤轮档时间","TOBT":"目标撤轮档时间",
   // "COBT":"空管计算撤轮档时间","T_TOBT":"空管目标撤轮档时间","A_TOBT":"机场目标撤轮档时间","ASBT":"实际开始登机时间","ARDT":"实际结束登机时间","ACCT":"实际关舱门时间",
   // "AOBT":"实际撤轮档时间","CTOT":"空管计算起飞时间","ATOT":"实际起飞时间","AXOT":"实际滑出时间","ATTT":"实际过站时间","A_TMO":"十海里时间","A_AIBT":"入位时间",
   // "A_AOBT":"离位时间"};
    //进港航班
    private String FLIGHT_NO_IATA;
    //日期
    private String OPERATIONAL_DATE;
    //1前站起飞
    private int PRE_ATOT;
    //2落地
    private String ALDT;
    //3挡轮挡
    private String AIBT;
    //4靠桥/客梯车对接
    private String ARSL;

    //5开客舱门
    private String ATDO;

    //6开货舱门
    private String ATFO;

    //7开始保洁
    private String ASCT;

    //8完成保洁
    private String AFCT;

    //9开始加油
    private String ASR;
    //10完成加油
    private String AER;
    //11开始配餐
    private String TASC;
    //12完成配餐
     private String AEC;
    //13开始登机
    private String ASBT;
    //完成登机
    private String AEBT;
    //关客舱门
    private String ATDC;
    //关货舱门
    private String ATFC;
    //机务放行
    private String AACI;
    //离桥/客梯车撤离
    private String LSW;
    //撤轮挡
    private String AOBT;
    //离港航班地面移交
    private String ATOT;
    //起飞
  //  private String ATOT;
}