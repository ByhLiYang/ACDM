package com.hq.acdm.model.monitoring.flightSorting;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class FlightSorting {
   //进港
    private String FLIGHT_NO_IATA;
 private String FLIGHT_NO_IATA_A;
 private String STAND;

 private String  OPERATIONAL_DATE;

    //
    private String FLDT;
    //
    private String ETA;
    //
    private String A_TMO;
    //
    private String A_AIBT;

    //出港航班
    private String FLIGHT_NO_IATA_D;


    //正常起点航班
    private String COBT;


    private String CTOT;
    //
    private String ETOT;

    private String ATOT;
    private String SIBT;
   private String SOBT;
    private String ALDT;
    private String ELDT;
    private int progress;



}