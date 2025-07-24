package com.hq.acdm.vo.rscMonitors;

import lombok.Getter;

/**
 * @author LiFaQiang
 * @date 2019/04/28 14:40
 * @Description
 */
@Getter
public class StandVo {
    private String flightId;
    private String flno;
    private String dOrA;
    private String stand;
    private String estTime;
    private String actTime;

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setFlno(String flno) {
        this.flno = flno;
    }

    public void setdOrA(String dOrA) {
        this.dOrA = dOrA;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public void setEstTime(String estTime) {
        this.estTime = estTime.replace(".0","");
    }

    public void setActTime(String actTime) {
        this.actTime = actTime.replace(".0","");
    }
}
