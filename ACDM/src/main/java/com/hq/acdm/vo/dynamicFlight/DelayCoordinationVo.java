package com.hq.acdm.vo.dynamicFlight;

import com.hq.acdm.util.DateTimeUtil;

import java.util.Date;


public class DelayCoordinationVo {

    private String id;

    private String flightId;

    private String flno;

    private String sobt;

    private String sibt;

    private String ades;

    private String ywlj;

    private String fxlj;

    private String cobt;

    private String tobt;

    private String ctot;

    private String ttot;

    private String atdc;

    private String aobt;

    private String atot;

    private String state;

    private String priority;

    private String rmk;

    private String createTm;

    private String createEmp;

    private String updateTm;

    private String updateEmp;

    private String isfocus;

    private String iscontrol;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlno() {
        return flno;
    }

    public void setFlno(String flno) {
        this.flno = flno;
    }

    public String getSobt() {
        return sobt;
    }

    public void setSobt(String sobt) {
        this.sobt = DateTimeUtil.timeDayFormatByStr(sobt);
    }

    public String getSibt() {
        return sibt;
    }

    public void setSibt(String sibt) {
        this.sibt = DateTimeUtil.timeDayFormatByStr(sibt);
    }

    public String getAdes() {
        return ades;
    }

    public void setAdes(String ades) {
        this.ades = ades;
    }

    public String getYwlj() {
        return ywlj;
    }

    public void setYwlj(String ywlj) {
        this.ywlj = DateTimeUtil.timeDayFormatByStr(ywlj);
    }

    public String getFxlj() {
        return fxlj;
    }

    public void setFxlj(String fxlj) {
        this.fxlj = DateTimeUtil.timeDayFormatByStr(fxlj);
    }

    public String getTobt() {
        return tobt;
    }

    public void setTobt(String tobt) {
        this.tobt = DateTimeUtil.timeDayFormatByStr(tobt);
    }

    public String getCobt() { return cobt; }

    public void setCobt(String cobt) { this.cobt = DateTimeUtil.timeDayFormatByStr(cobt); }

    public String getCtot() { return ctot; }

    public void setCtot(String ctot) { this.ctot = DateTimeUtil.timeDayFormatByStr(ctot); }

    public String getTtot() {
        return ttot;
    }

    public void setTtot(String ttot) {
        this.ttot = DateTimeUtil.timeDayFormatByStr(ttot);
    }

    public String getAtdc() {
        return atdc;
    }

    public void setAtdc(String atdc) {
        this.atdc = DateTimeUtil.timeDayFormatByStr(atdc);
    }

    public String getAobt() {
        return aobt;
    }

    public void setAobt(String aobt) {
        this.aobt = DateTimeUtil.timeDayFormatByStr(aobt);
    }

    public String getAtot() {
        return atot;
    }

    public void setAtot(String atot) {
        this.atot = DateTimeUtil.timeDayFormatByStr(atot);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    public String getCreateTm() {
        return createTm;
    }

    public void setCreateTm(String createTm) {
        this.createTm = createTm;
    }

    public String getCreateEmp() {
        return createEmp;
    }

    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp;
    }

    public String getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(String updateTm) {
        this.updateTm = updateTm;
    }

    public String getUpdateEmp() {
        return updateEmp;
    }

    public void setUpdateEmp(String updateEmp) {
        this.updateEmp = updateEmp;
    }

    public String getIsfocus() {
        return isfocus;
    }

    public void setIsfocus(String isfocus) {
        this.isfocus = isfocus;
    }

    public String getIscontrol() { return iscontrol; }

    public void setIscontrol(String iscontrol) {
        this.iscontrol = iscontrol;
    }
}
