package com.hq.acdm.vo.realtimeSituation;

import lombok.Data;

@Data
public class FlightBackAVo {
    //进港积压
    private String flightId;
    private String sibt;
    private String aldt;
    private int delayTime;

}
