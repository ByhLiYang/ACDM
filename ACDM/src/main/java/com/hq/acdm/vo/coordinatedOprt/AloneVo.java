package com.hq.acdm.vo.coordinatedOprt;

import com.hq.acdm.util.DateTimeUtil;
import lombok.Data;
import lombok.Getter;

/**
 * @author LiFaQiang
 * @date 2019/06/12 13:25
 * @Description
 */
@Data
public class AloneVo {
    private String flight_id;//航班ID
    private String exec_date;//航班执行日期;D根据起飞时间，A根据落地时间

    private String flno;//航班号
    private String d_or_a;//进出港
    private String jhsj;//计划时间
    private String adep;//起飞机场
    private String ades;//目的机场

    private String status;//状态
    private String craft_type_icao;//机型
    private String regn;//机号
    private String stand;//机位
    private String atot;//实起
    private String aldt;//实落



}
