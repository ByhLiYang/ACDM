package com.hq.acdm.vo.dynamicFlight;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2019/04/23 14:34
 * @Description
 */
@Data
public class PrcsLDHXVo {
    private String flightId;
    private String flnoA;
    private String flnoD;
    private String standA;
    private String standD;
    private String adepA;
    private String adepD;
    private String adesA;
    private String adesD;
    private String runwayA;
    private String isDelay;
    private String isControl;
    private String aldt;
    private String exit;
    private String aGrndTsfTm;
    private String cobt;
    private String etot;
    private String sobt;
}
