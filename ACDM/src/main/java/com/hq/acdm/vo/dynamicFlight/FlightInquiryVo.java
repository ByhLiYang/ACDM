package com.hq.acdm.vo.dynamicFlight;

import com.hq.acdm.util.DateTimeUtil;


public class FlightInquiryVo {

    private String flightId ;
    private String associatedFlightId ;
    private String flno ;
    private String flnoAssociated;
    private String execDate;
    private String flStatus ;
    private String flabStatus;
    private String reasonsForDelay;
    private String airlines ;
    private String craftTypeIcao ;
    private String regn ;
    private String dOrA;
    private String flightTask;
    private String attribute;
    private String adep ;
    private String ades ;
    private String adepName;
    private String adesName;
    private String planTime;
    private String realTime;
    private String stdc;
    private String atdc;
    private String delayTime;
    private String isYw;
    private String isNormal;
    private String isFxNormal;
    private String isSf;
    private String isSfNormal;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getAssociatedFlightId() {
        return associatedFlightId;
    }

    public void setAssociatedFlightId(String associatedFlightId) {
        this.associatedFlightId = associatedFlightId;
    }

    public String getFlno() {
        return flno;
    }

    public void setFlno(String flno) {
        this.flno = flno;
    }

    public String getFlnoAssociated() {
        return flnoAssociated;
    }

    public void setFlnoAssociated(String flnoAssociated) {
        this.flnoAssociated = flnoAssociated;
    }

    public String getExecDate() {
        return execDate;
    }

    public void setExecDate(String execDate) {
        this.execDate = execDate;
    }

    public String getFlStatus() {
        return flStatus;
    }

    public void setFlStatus(String flStatus) {
        this.flStatus = flStatus;
    }

    public String getFlabStatus() {
        return flabStatus;
    }

    public void setFlabStatus(String flabStatus) {
        this.flabStatus = flabStatus;
    }

    public String getReasonsForDelay() {
        return reasonsForDelay;
    }

    public void setReasonsForDelay(String reasonsForDelay) {
        this.reasonsForDelay = reasonsForDelay;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public String getCraftTypeIcao() {
        return craftTypeIcao;
    }

    public void setCraftTypeIcao(String craftTypeIcao) {
        this.craftTypeIcao = craftTypeIcao;
    }

    public String getRegn() {
        return regn;
    }

    public void setRegn(String regn) {
        this.regn = regn;
    }

    public String getdOrA() {
        return dOrA;
    }

    public void setdOrA(String dOrA) {
        this.dOrA = dOrA;
    }

    public String getFlightTask() {
        return flightTask;
    }

    public void setFlightTask(String flightTask) {
        this.flightTask = flightTask;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAdep() {
        return adep;
    }

    public void setAdep(String adep) {
        this.adep = adep;
    }

    public String getAdes() {
        return ades;
    }

    public void setAdes(String ades) {
        this.ades = ades;
    }

    public String getAdepName() {
        return adepName;
    }

    public void setAdepName(String adepName) {
        this.adepName = adepName;
    }

    public String getAdesName() {
        return adesName;
    }

    public void setAdesName(String adesName) {
        this.adesName = adesName;
    }

    public String getPlanTime() {
        return planTime;
    }

    public void setPlanTime(String planTime) {
        this.planTime = DateTimeUtil.timeDayFormatByStr(planTime);
    }

    public String getRealTime() {
        return realTime;
    }

    public void setRealTime(String realTime) {
        this.realTime = DateTimeUtil.timeDayFormatByStr(realTime);
    }

    public String getStdc() {
        return stdc;
    }

    public void setStdc(String stdc) {
        this.stdc = DateTimeUtil.timeDayFormatByStr(stdc);
    }

    public String getAtdc() {
        return atdc;
    }

    public void setAtdc(String atdc) {
        this.atdc = DateTimeUtil.timeDayFormatByStr(atdc);
    }

    public String getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime;
    }

    public String getIsYw() {
        return isYw;
    }

    public void setIsYw(String isYw) {
        this.isYw = isYw;
    }

    public String getIsNormal() {
        return isNormal;
    }

    public void setIsNormal(String isNormal) {
        this.isNormal = isNormal;
    }

    public String getIsFxNormal() {
        return isFxNormal;
    }

    public void setIsFxNormal(String isFxNormal) {
        this.isFxNormal = isFxNormal;
    }

    public String getIsSf() {
        return isSf;
    }

    public void setIsSf(String isSf) {
        this.isSf = isSf;
    }

    public String getIsSfNormal() {
        return isSfNormal;
    }

    public void setIsSfNormal(String isSfNormal) {
        this.isSfNormal = isSfNormal;
    }
}
