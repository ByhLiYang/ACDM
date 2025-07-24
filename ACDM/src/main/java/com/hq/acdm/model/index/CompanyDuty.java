package com.hq.acdm.model.index;

import java.math.BigDecimal;
import java.util.Date;

public class CompanyDuty {
    private BigDecimal id;

    private Date dutyDate;

    private String hqCompanyDuty;

    private String aocManager;

    private String aocExternalManager;

    private String aocInternalManager;

    private String flightAreaDuty;

    private String operator;

    private Date operateTime;

    private String operateIp;

    private String remarks;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getDutyDate() {
        return dutyDate;
    }

    public void setDutyDate(Date dutyDate) {
        this.dutyDate = dutyDate;
    }

    public String getHqCompanyDuty() {
        return hqCompanyDuty;
    }

    public void setHqCompanyDuty(String hqCompanyDuty) {
        this.hqCompanyDuty = hqCompanyDuty == null ? null : hqCompanyDuty.trim();
    }

    public String getAocManager() {
        return aocManager;
    }

    public void setAocManager(String aocManager) {
        this.aocManager = aocManager == null ? null : aocManager.trim();
    }

    public String getAocExternalManager() {
        return aocExternalManager;
    }

    public void setAocExternalManager(String aocExternalManager) {
        this.aocExternalManager = aocExternalManager == null ? null : aocExternalManager.trim();
    }

    public String getAocInternalManager() {
        return aocInternalManager;
    }

    public void setAocInternalManager(String aocInternalManager) {
        this.aocInternalManager = aocInternalManager == null ? null : aocInternalManager.trim();
    }

    public String getFlightAreaDuty() {
        return flightAreaDuty;
    }

    public void setFlightAreaDuty(String flightAreaDuty) {
        this.flightAreaDuty = flightAreaDuty == null ? null : flightAreaDuty.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}