package com.hq.acdm.model.monitoring.reportInfo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/** 日报信息
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class ReportRunInfo {
    private Integer id;
    private String flight_a;
    private String flight_d;
    private String flight_cancel;//机位
    private String delay_2hour;//航班号
    private String delay_4hour;//机位
    private String flight_schedule;//机位

    private String report_user;//标题
    private Timestamp report_time;//标题
    private String content;//标题


    private Timestamp schedule_date;
    private String operational_date;

    private Integer status;//状态 0 未发送 1-发送  2-接收   3-处理







}