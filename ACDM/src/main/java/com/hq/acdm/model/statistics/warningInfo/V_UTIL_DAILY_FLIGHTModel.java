package com.hq.acdm.model.statistics.warningInfo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/11/29 0029 15:32
 */
@Getter
@Setter
public class V_UTIL_DAILY_FLIGHTModel {
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
    private String FLIGHT_RELEASE_RATE_NUMERATOR;
    private String F_RELEASE_RATE_DENOMINATOR;
    private String FLIGHT_NORMAL_RATE_NUMERATOR;
    private String FLIGHT_NORMAL_RATE_DENOMINATOR;

}
