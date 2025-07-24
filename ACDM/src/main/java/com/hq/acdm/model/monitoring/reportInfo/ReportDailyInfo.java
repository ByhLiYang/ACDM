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
public class ReportDailyInfo {
    private Integer id;
    private String flight_run;
    private String flight_in_today;
    private String flight_out_today;
    private String flight_a;
    private String flight_cancel;//机位
    private String delay_2hour;//航班号
    private String delay_4hour;//机位
    private String flight_un;//公务机
    private String normal_rate;//正常率
    private String report_user;//标题
    private Timestamp report_time;//标题
    private String content;//标题

    private Timestamp schedule_date;
    private String operational_date;

    private Integer status;//状态 0 未发送 1-发送  2-接收   3-处理

    private String over_rate;
    private String flight_d;
    private String start_rate;
    private String jh_schedule;
    private String jh_run;
    private String free_pax;
    private String free_pax_east;
    private String flight_un_today;
    private String flight_run_today;
    private String level_today;
    private String network_opinion;
    private String airport_status;
    private String flight_schedule;
    private String passager_d;

  /*  public Integer getFlight_d(){
        int flight_run=Integer.parseInt(this.flight_run);
        int flight_a=Integer.parseInt(this.flight_a);
        int test=flight_run-flight_a;
        this.flight_d= String.valueOf(test);
        return Integer.parseInt(flight_d);
    }*/

    private String flight_schedule_today;//今日计划航班






}