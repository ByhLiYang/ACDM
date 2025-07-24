package com.hq.acdm.model.statistics.flightOverStation;

import lombok.Data;

@Data
public class Delay {
    private String OPERATIONAL_DATE;
    private String IATA_A;
    private String IATA_D;
    private String SIBT;
    private String SOBT;
    private String TM;
    private String DATE_D;
}
