package com.hq.acdm.model.index;

import java.math.BigDecimal;
import java.util.Date;

public class VRealInterface {
    private Date operationalDate;

    private BigDecimal flightNum;

    private BigDecimal cancelNum;

    private BigDecimal alreadyNum;

    private BigDecimal readyNum;

    private BigDecimal goodNum;

    private BigDecimal goodFliNum;

    private BigDecimal fliTotNum;

    private BigDecimal departNum;

    private BigDecimal arrivedNum;

    private BigDecimal flightReleaseRateNumerator;

    private BigDecimal fReleaseRateDenominator;

    private BigDecimal flightNormalRateNumerator;

    private BigDecimal flightNormalRateDenominator;

    public Date getOperationalDate() {
        return operationalDate;
    }

    public void setOperationalDate(Date operationalDate) {
        this.operationalDate = operationalDate;
    }

    public BigDecimal getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(BigDecimal flightNum) {
        this.flightNum = flightNum;
    }

    public BigDecimal getCancelNum() {
        return cancelNum;
    }

    public void setCancelNum(BigDecimal cancelNum) {
        this.cancelNum = cancelNum;
    }

    public BigDecimal getAlreadyNum() {
        return alreadyNum;
    }

    public void setAlreadyNum(BigDecimal alreadyNum) {
        this.alreadyNum = alreadyNum;
    }

    public BigDecimal getReadyNum() {
        return readyNum;
    }

    public void setReadyNum(BigDecimal readyNum) {
        this.readyNum = readyNum;
    }

    public BigDecimal getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(BigDecimal goodNum) {
        this.goodNum = goodNum;
    }

    public BigDecimal getGoodFliNum() {
        return goodFliNum;
    }

    public void setGoodFliNum(BigDecimal goodFliNum) {
        this.goodFliNum = goodFliNum;
    }

    public BigDecimal getFliTotNum() {
        return fliTotNum;
    }

    public void setFliTotNum(BigDecimal fliTotNum) {
        this.fliTotNum = fliTotNum;
    }

    public BigDecimal getDepartNum() {
        return departNum;
    }

    public void setDepartNum(BigDecimal departNum) {
        this.departNum = departNum;
    }

    public BigDecimal getArrivedNum() {
        return arrivedNum;
    }

    public void setArrivedNum(BigDecimal arrivedNum) {
        this.arrivedNum = arrivedNum;
    }

    public BigDecimal getFlightReleaseRateNumerator() {
        return flightReleaseRateNumerator;
    }

    public void setFlightReleaseRateNumerator(BigDecimal flightReleaseRateNumerator) {
        this.flightReleaseRateNumerator = flightReleaseRateNumerator;
    }

    public BigDecimal getfReleaseRateDenominator() {
        return fReleaseRateDenominator;
    }

    public void setfReleaseRateDenominator(BigDecimal fReleaseRateDenominator) {
        this.fReleaseRateDenominator = fReleaseRateDenominator;
    }

    public BigDecimal getFlightNormalRateNumerator() {
        return flightNormalRateNumerator;
    }

    public void setFlightNormalRateNumerator(BigDecimal flightNormalRateNumerator) {
        this.flightNormalRateNumerator = flightNormalRateNumerator;
    }

    public BigDecimal getFlightNormalRateDenominator() {
        return flightNormalRateDenominator;
    }

    public void setFlightNormalRateDenominator(BigDecimal flightNormalRateDenominator) {
        this.flightNormalRateDenominator = flightNormalRateDenominator;
    }
}