package com.hq.acdm.model.statistics.delayCoordinate;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/12/6 0006 13:47
 */
@Getter
@Setter
public class DelayCoordinateModel {
    private String FLIGHT_NO_IATA;
    private String A_OR_D;
    private String SOBT;
    private String OPERATIONAL_DATE;
    private String ATOT;
    private String PAX_NUM;
    private String DELAY_TIME;
    private String STAND;
    private String DEST_AIRPORT_IATA;
    private String ORIGIN_AIRPORT_IATA;
    private String GATE_1;
    private String RWY;
    private String BELT_1;
    private String ELDT;
    private String ALDT;
    private String SIBT;
    private String EET;
    private String ACCT_4;
    private String AOBT;
    private String ATOT_1;
    private String FLIGHT_REPEAT_COUNT;
    private String ISSTRICTCTRL;
    private String CTRLCONTENT;
    private String CTRLPOINT;
    private double PROCESS;
}
