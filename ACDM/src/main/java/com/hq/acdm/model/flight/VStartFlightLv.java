package com.hq.acdm.model.flight;

import java.math.BigDecimal;
import java.util.Date;
public class VStartFlightLv {
    private Date sobt;

    private Date operationalDate;

    private String airlineCodeIata;

    private BigDecimal plancount;

    private BigDecimal executecount;

    private BigDecimal normal;

    public Date getSobt() {
        return sobt;
    }

    public void setSobt(Date sobt) {
        this.sobt = sobt;
    }

    public Date getOperationalDate() {
        return operationalDate;
    }

    public void setOperationalDate(Date operationalDate) {
        this.operationalDate = operationalDate;
    }

    public String getAirlineCodeIata() {
        return airlineCodeIata;
    }

    public void setAirlineCodeIata(String airlineCodeIata) {
        this.airlineCodeIata = airlineCodeIata == null ? null : airlineCodeIata.trim();
    }

    public BigDecimal getPlancount() {
        return plancount;
    }

    public void setPlancount(BigDecimal plancount) {
        this.plancount = plancount;
    }

    public BigDecimal getExecutecount() {
        return executecount;
    }

    public void setExecutecount(BigDecimal executecount) {
        this.executecount = executecount;
    }

    public BigDecimal getNormal() {
        return normal;
    }

    public void setNormal(BigDecimal normal) {
        this.normal = normal;
    }
}