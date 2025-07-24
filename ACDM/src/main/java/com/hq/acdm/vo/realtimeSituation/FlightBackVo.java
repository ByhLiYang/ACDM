package com.hq.acdm.vo.realtimeSituation;

import lombok.Data;

import java.util.Date;

@Data
public class FlightBackVo {
    //出港积压
    private String flightId;
    private String sobt;
    private String atot;
    private int delayTime;

}
