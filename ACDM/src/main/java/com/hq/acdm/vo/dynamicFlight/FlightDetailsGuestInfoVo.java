package com.hq.acdm.vo.dynamicFlight;

import com.hq.acdm.util.DateTimeUtil;

public class FlightDetailsGuestInfoVo {


    private String 	bagCount;
    private String  checkIn;
    private String  securityCheck;
    private String  overStation;
    private String  boarding;

    public String getBagCount() {
        return bagCount;
    }

    public void setBagCount(String bagCount) {
        this.bagCount = bagCount;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getSecurityCheck() {
        return securityCheck;
    }

    public void setSecurityCheck(String securityCheck) {
        this.securityCheck = securityCheck;
    }

    public String getOverStation() {
        return overStation;
    }

    public void setOverStation(String overStation) {
        this.overStation = overStation;
    }

    public String getBoarding() {
        return boarding;
    }

    public void setBoarding(String boarding) {
        this.boarding = boarding;
    }
}
