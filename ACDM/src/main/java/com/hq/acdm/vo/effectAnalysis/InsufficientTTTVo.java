package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

@Data
public class InsufficientTTTVo {

    private String flightId;
    private String flnod;
    private String craftTypeIcao;
    private String chineseName;
    private String sobt;
    private String sibt;
    private String airlines;
    private String duration;
    private String passingTime;

}
