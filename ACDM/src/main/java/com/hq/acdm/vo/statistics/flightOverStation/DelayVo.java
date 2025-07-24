package com.hq.acdm.vo.statistics.flightOverStation;

import lombok.Data;

@Data
public class DelayVo {
    private String A_IATA;

    private String A_DATE;

    private String D_IATA;

    private String D_DATE;

    private String OverTime;

    private String SOBT;

    private String SIBT;

}
