package com.hq.acdm.model.index;

import java.math.BigDecimal;

public class VPaxSum {
    private BigDecimal paxNum;

    private String type;

    private BigDecimal sHour;

    public BigDecimal getPaxNum() {
        return paxNum;
    }

    public void setPaxNum(BigDecimal paxNum) {
        this.paxNum = paxNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public BigDecimal getsHour() {
        return sHour;
    }

    public void setsHour(BigDecimal sHour) {
        this.sHour = sHour;
    }
}