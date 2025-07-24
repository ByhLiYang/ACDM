package com.hq.acdm.model.specialCase.deicing;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author wangshuhao
 * @date 2018/10/31 0031 11:06
 */
@Getter
@Setter
public class deicingModel {
    private String COBTTIME;
    private String A_OR_D;
    private String FLIGHT_REPEAT_COUNT;
    private String OPERATIONAL_DATE;
    private String FLIGHT_NO_IATA;
    private String ACZT;
    private String AEZT;
    private String isRequiredDeicing;
    private String DeicingType;
    private String DecingStand;
    private String AIRLINE_CODE_IATA;
    private String TERMINAL;
}
