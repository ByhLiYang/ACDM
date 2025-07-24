package com.hq.acdm.model.index;

import java.math.BigDecimal;
import java.util.Date;

public class VForecast {
    private BigDecimal hour;

    private BigDecimal tHour;

    private BigDecimal schNum;

    private BigDecimal realNum;

    private String aOrD;

    private BigDecimal sHour;

    private Date operationalDate;

    public BigDecimal getHour() {
        return hour;
    }

    public void setHour(BigDecimal hour) {
        this.hour = hour;
    }

    public BigDecimal gettHour() {
        return tHour;
    }

    public void settHour(BigDecimal tHour) {
        this.tHour = tHour;
    }

    public BigDecimal getSchNum() {
        return schNum;
    }

    public void setSchNum(BigDecimal schNum) {
        this.schNum = schNum;
    }

    public BigDecimal getRealNum() {
        return realNum;
    }

    public void setRealNum(BigDecimal realNum) {
        this.realNum = realNum;
    }

    public String getaOrD() {
        return aOrD;
    }

    public void setaOrD(String aOrD) {
        this.aOrD = aOrD == null ? null : aOrD.trim();
    }

    public BigDecimal getsHour() {
        return sHour;
    }

    public void setsHour(BigDecimal sHour) {
        this.sHour = sHour;
    }

    public Date getOperationalDate() {
        return operationalDate;
    }

    public void setOperationalDate(Date operationalDate) {
        this.operationalDate = operationalDate;
    }
}