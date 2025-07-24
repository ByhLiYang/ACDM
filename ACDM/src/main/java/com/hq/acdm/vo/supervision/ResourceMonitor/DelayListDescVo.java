package com.hq.acdm.vo.supervision.ResourceMonitor;

import lombok.Data;
import lombok.Getter;

/**
 * @author LiFaQiang
 * @date 2018/11/11 17:33
 * @Description
 */
@Getter
public class DelayListDescVo {
    private String airport;
    private String delayFlight;
    private String delayPassenger;
    private String delayRate;
    private String delayAverage;

    public void setAirport(String airport) {
        this.airport = null==airport?"":airport;
    }

    public void setDelayFlight(String delayFlight) {
        this.delayFlight = null==delayFlight?"":delayFlight;
    }

    public void setDelayPassenger(String delayPassenger) {
        this.delayPassenger = null==delayPassenger?"":delayPassenger;
    }

    public void setDelayRate(String delayRate) {
        this.delayRate = null==delayRate?"":delayRate;
    }

    public void setDelayAverage(String delayAverage) {
        this.delayAverage = null==delayAverage?"":delayAverage;
    }
}
