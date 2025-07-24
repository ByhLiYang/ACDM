package com.hq.acdm.vo.index;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2018/11/18 17:22
 * @Description
 */
@Data
public class StandStatusVo {
    private int occupySum;
    private int freeSum;
    private int confictSum;
    private String StandStatus;
    private String FLIGHT_NO_IATA;
    private String OPERATIONAL_DATE;
    private String A_OR_D;
    private String DESCRIPTION;
    private String TERMINAL;
    private String IS_REMOTE;
    private String STAND;
//    预计占用时间
    private String SIT;
    private String SIT_D;
//    预计结束时间（预计冲突结束时间）
    private String SOT;
    private String SOT_D;
//    实际占用时间
    private String AIT;
    private String AIT_D;
//    预计占用时长
    private String SKT;
//    预计冲突时间
    private String SCT;
    private String SCT_D;
//    预计冲突时长
    private String SCKT;
//    冲突航班计划撤轮档时间
    private String CSOBT;
    private String CSOBT_D;
//    预计冲突航班
    private String FLIGHT_NO_IATA_C;
}
