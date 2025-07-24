package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TAtcDelayStatistics {
    private String id;

    private String flightId;

    private String airlines;

    private String flno;

    private String flno3;

    private String dOrA;

    private String execDate;

    private String sobt;

    private String fxlj;

    private String atot;

    private String delayTime;

    private String reasonsForDelay;

    private String ades;

    private String chineseName;

    private String rmk;

    private String createUsr;

    private String updateUsr;

    private String createTm;

    private String updateTm;


}