package com.hq.acdm.model.index;

import java.math.BigDecimal;

public class VDelayFlightSum {
    private BigDecimal flightNum;

    private BigDecimal delayFlightNum;

    private BigDecimal passengerNum;

    private String type;

    public BigDecimal getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(BigDecimal flightNum) {
        this.flightNum = flightNum;
    }

    public BigDecimal getDelayFlightNum() {
        return delayFlightNum;
    }

    public void setDelayFlightNum(BigDecimal delayFlightNum) {
        this.delayFlightNum = delayFlightNum;
    }

    public BigDecimal getPassengerNum() {
        return passengerNum;
    }

    public void setPassengerNum(BigDecimal passengerNum) {
        this.passengerNum = passengerNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}