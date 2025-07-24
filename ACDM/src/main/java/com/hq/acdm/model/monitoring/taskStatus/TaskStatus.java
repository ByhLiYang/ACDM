package com.hq.acdm.model.monitoring.taskStatus;

import lombok.*;

import java.sql.Timestamp;

/** 任务管理
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class TaskStatus {
    private Integer taskid;


    private String flight_NO_IATA_D;
    private String stand_D;//机位
    private String flight_NO_IATA_A;//航班号
    private String stand_A;//机位

    //进出港标识
    private String A_OR_D;
    //SIBT
    private String SIBT;

    //ELDT
    private String ELDT;

    //AIBT
    private String AIBT;

    private String ALDT;//实际落地实际



    private String OPERATIONAL_DATE;//航班日期
    private String OPERATIONAL_DATE_D;//航班日期
    private String progress;//任务进度
    private String airline_code_icao;//任务进度

    private String title;//标题
    private String advise;//标题

    private String sender;//发送者
    private String companyName;//航空公司

    private Timestamp send_Time;

    private Integer status;//状态 0 未发送 1-发送  2-接收   3-处理

    private String receiver;

    private String receiveDept;//发送者

    private Timestamp receive_Time;

    public void setTaskid(Integer taskid){
        this.taskid=taskid;
    }

    public void setSend_Time(Timestamp send_Time){
        this.send_Time=send_Time;
    }public void setReceive_Time(Timestamp receive_Time){
        this.receive_Time=receive_Time;
    }
    public void setStatus(Integer status){
         this.status=status;

    }



}