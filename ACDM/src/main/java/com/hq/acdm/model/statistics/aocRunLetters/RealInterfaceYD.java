package com.hq.acdm.model.statistics.aocRunLetters;

import lombok.Data;

/**
 * 总计划 实际 正常率 放行正常率
 */

@Data
public class RealInterfaceYD {

    private String OPERATIONAL_DATE;
    private String FLIGHT_NUM;
    private String CANCEL_NUM;
    private String ALREADY_NUM;
    private String READY_NUM;
    private String GOOD_NUM;
    private String GOOD_FLI_NUM;
    private String FLI_TOT_NUM;
    private String DEPART_NUM;
    private String ARRIVED_NUM;
    private String FLIGHT_R_RATE_NUMERATOR;
    private String FLIGHT_R_RATE_DENOMINATOR;
    private String FLIGHT_RATE_NUMERATOR;
    private String FLIGHT_RATE_DENOMINATOR;
}
