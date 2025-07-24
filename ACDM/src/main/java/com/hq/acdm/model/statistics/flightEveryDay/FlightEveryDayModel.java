package com.hq.acdm.model.statistics.flightEveryDay;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2019/1/10 0010 14:27
 */
@Getter
@Setter
public class FlightEveryDayModel {
    private String FLIGHT_NO_IATA_A;
    private String AIRPORT_VIA_IATA_A;
    private String ORIGIN_AIRPORT_IATA;
    private String SOBT_A;
    private String PRE_ATOT;
    private String SIBT;
    private String ALDT;
    private String STAND_A;
    private String ARN_A;
    private String TYPE_A;
    private String FLIGHT_CLASS_CODE_A;
    private String FLIGHT_SECTOR_CODE_A;
    private String OPERATION_TYPE_CODE_1_A;
    private String AIBT;
    private String ISSTRICTCTRL_A;
    private String CTRLCONTENT_A;
    private String CTRLPOINT_A;
    private String CTRLREASON_A;
    private String RWY_A;
    private String FLIGHT_NO_IATA_D;
    private String AIRPORT_VIA_IATA_D;
    private String DEST_AIRPORT_IATA;
    private String SOBT_D;
    private String ATOT;
    private String STAND_D;
    private String ARN_D;
    private String TYPE_D;
    private String FLIGHT_CLASS_CODE_D;
    private String FLIGHT_SECTOR_CODE_D;
    private String OPERATION_TYPE_CODE_1_D;
    private String CTOT;
    private String COBT;
    private String AOBT;
    private String ISSTRICTCTRL_D;
    private String CTRLCONTENT_D;
    private String CTRLPOINT_D;
    private String CTRLREASON_D;
    private String RWY_D;
}
