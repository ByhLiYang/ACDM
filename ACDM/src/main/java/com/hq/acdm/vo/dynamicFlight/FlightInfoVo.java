package com.hq.acdm.vo.dynamicFlight;

import com.hq.acdm.util.DateTimeUtil;
import lombok.Data;


public class FlightInfoVo {

    private String flightId ;
    private String flno ;
    private String execDate;
    private String flStatus ;
    private String airlines ;
    private String craftTypeIcao ;
    private String regn ;
    private String dOrA;
    private String adep ;
    private String ades ;
    private String sobt;
    private String sibt;
    private String eldt;
    private String aldt;
    private String etot;
    private String atot;
    private String stand ;
    private String runway ;
    private String axit ;
    private String axot ;
    private String cobt ;
    private String ctot ;
    private String tobt ;
    private String aTobt ;
    private String iscontrol ;
    private String eibt ;
    private String aibt ;
    private String eobt ;
    private String aobt ;
    private String etdo ;
    private String etdc ;
    private String atdo ;
    private String atdc ;
    private String etfo ;
    private String etfc ;
    private String atfo ;
    private String atfc ;
    private String esct ;
    private String efct ;
    private String asct ;
    private String afct ;
    private String esc ;
    private String eec ;
    private String asc ;
    private String aec ;
    private String esr ;
    private String eer ;
    private String asr ;
    private String aer ;
    private String esbt ;
    private String eebt ;
    private String asbt ;
    private String aebt ;
    private String ersl ;
    private String elsw ;
    private String arsl ;
    private String alsw ;
    private String aGrndTsfTm ;
    private String dGrndTsfTm ;
    private String isfocus;
    private String delayTime;

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

    public String getExecDate() { return execDate; }

    public void setExecDate(String execDate) { this.execDate = execDate; }

    public String getFlStatus() {
        return flStatus;
    }

    public void setFlStatus(String flStatus) {
        this.flStatus = flStatus;
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

    public String getSobt() { return sobt; }

    public void setSobt(String sobt) {
        this.sobt = DateTimeUtil.timeDayFormatByStr(sobt);
    }

    public String getSibt() {
        return sibt;
    }

    public void setSibt(String sibt) {
        this.sibt = DateTimeUtil.timeDayFormatByStr(sibt);
    }

    public String getEldt() {
        return eldt;
    }

    public void setEldt(String eldt) {
        this.eldt = DateTimeUtil.timeDayFormatByStr(eldt);
    }

    public String getAldt() {
        return aldt;
    }

    public void setAldt(String aldt) {
        this.aldt = DateTimeUtil.timeDayFormatByStr(aldt);
    }

    public String getEtot() {
        return etot;
    }

    public void setEtot(String etot) {
        this.etot = DateTimeUtil.timeDayFormatByStr(etot);
    }

    public String getAtot() {
        return atot;
    }

    public void setAtot(String atot) {
        this.atot = DateTimeUtil.timeDayFormatByStr(atot);
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public String getRunway() {
        return runway;
    }

    public void setRunway(String runway) {
        this.runway = runway;
    }

    public String getAxit() {
        return axit;
    }

    public void setAxit(String axit) {
        this.axit = DateTimeUtil.timeDayFormatByStr(axit);
    }

    public String getAxot() {
        return axot;
    }

    public void setAxot(String axot) {
        this.axot = DateTimeUtil.timeDayFormatByStr(axot);
    }

    public String getCobt() {
        return cobt;
    }

    public void setCobt(String cobt) {
        this.cobt = DateTimeUtil.timeDayFormatByStr(cobt);
    }

    public String getCtot() {
        return ctot;
    }

    public void setCtot(String ctot) {
        this.ctot = DateTimeUtil.timeDayFormatByStr(ctot);
    }

    public String getTobt() {
        return tobt;
    }

    public void setTobt(String tobt) {
        this.tobt = DateTimeUtil.timeDayFormatByStr(tobt);
    }

    public String getaTobt() {
        return aTobt;
    }

    public void setaTobt(String aTobt) {
        this.aTobt = DateTimeUtil.timeDayFormatByStr(aTobt);
    }

    public String getIscontrol() {
        return iscontrol;
    }

    public void setIscontrol(String iscontrol) {
        this.iscontrol = iscontrol;
    }

    public String getEibt() {
        return eibt;
    }

    public void setEibt(String eibt) {
        this.eibt = DateTimeUtil.timeDayFormatByStr(eibt);
    }

    public String getAibt() {
        return aibt;
    }

    public void setAibt(String aibt) {
        this.aibt = DateTimeUtil.timeDayFormatByStr(aibt);
    }

    public String getEobt() {
        return eobt;
    }

    public void setEobt(String eobt) {
        this.eobt = DateTimeUtil.timeDayFormatByStr(eobt);
    }

    public String getAobt() {
        return aobt;
    }

    public void setAobt(String aobt) {
        this.aobt = DateTimeUtil.timeDayFormatByStr(aobt);
    }

    public String getEtdo() {
        return etdo;
    }

    public void setEtdo(String etdo) {
        this.etdo = DateTimeUtil.timeDayFormatByStr(etdo);
    }

    public String getEtdc() {
        return etdc;
    }

    public void setEtdc(String etdc) {
        this.etdc = DateTimeUtil.timeDayFormatByStr(etdc);
    }

    public String getAtdo() {
        return atdo;
    }

    public void setAtdo(String atdo) {
        this.atdo = DateTimeUtil.timeDayFormatByStr(atdo);
    }

    public String getAtdc() {
        return atdc;
    }

    public void setAtdc(String atdc) {
        this.atdc = DateTimeUtil.timeDayFormatByStr(atdc);
    }

    public String getEtfo() {
        return etfo;
    }

    public void setEtfo(String etfo) {
        this.etfo = DateTimeUtil.timeDayFormatByStr(etfo);
    }

    public String getEtfc() {
        return etfc;
    }

    public void setEtfc(String etfc) {
        this.etfc = DateTimeUtil.timeDayFormatByStr(etfc);
    }

    public String getAtfo() {
        return atfo;
    }

    public void setAtfo(String atfo) {
        this.atfo = DateTimeUtil.timeDayFormatByStr(atfo);
    }

    public String getAtfc() {
        return atfc;
    }

    public void setAtfc(String atfc) {
        this.atfc = DateTimeUtil.timeDayFormatByStr(atfc);
    }

    public String getEsct() {
        return esct;
    }

    public void setEsct(String esct) {
        this.esct = DateTimeUtil.timeDayFormatByStr(esct);
    }

    public String getEfct() {
        return efct;
    }

    public void setEfct(String efct) {
        this.efct = DateTimeUtil.timeDayFormatByStr(efct);
    }

    public String getAsct() {
        return asct;
    }

    public void setAsct(String asct) {
        this.asct = DateTimeUtil.timeDayFormatByStr(asct);
    }

    public String getAfct() {
        return afct;
    }

    public void setAfct(String afct) {
        this.afct = DateTimeUtil.timeDayFormatByStr(afct);
    }

    public String getEsc() {
        return esc;
    }

    public void setEsc(String esc) {
        this.esc = DateTimeUtil.timeDayFormatByStr(esc);
    }

    public String getEec() {
        return eec;
    }

    public void setEec(String eec) {
        this.eec = DateTimeUtil.timeDayFormatByStr(eec);
    }

    public String getAsc() {
        return asc;
    }

    public void setAsc(String asc) {
        this.asc = DateTimeUtil.timeDayFormatByStr(asc);
    }

    public String getAec() {
        return aec;
    }

    public void setAec(String aec) {
        this.aec = DateTimeUtil.timeDayFormatByStr(aec);
    }

    public String getEsr() {
        return esr;
    }

    public void setEsr(String esr) {
        this.esr = DateTimeUtil.timeDayFormatByStr(esr);
    }

    public String getEer() {
        return eer;
    }

    public void setEer(String eer) {
        this.eer = DateTimeUtil.timeDayFormatByStr(eer);
    }

    public String getAsr() {
        return asr;
    }

    public void setAsr(String asr) {
        this.asr = DateTimeUtil.timeDayFormatByStr(asr);
    }

    public String getAer() {
        return aer;
    }

    public void setAer(String aer) {
        this.aer = DateTimeUtil.timeDayFormatByStr(aer);
    }

    public String getEsbt() {
        return esbt;
    }

    public void setEsbt(String esbt) {
        this.esbt = DateTimeUtil.timeDayFormatByStr(esbt);
    }

    public String getEebt() {
        return eebt;
    }

    public void setEebt(String eebt) {
        this.eebt = DateTimeUtil.timeDayFormatByStr(eebt);
    }

    public String getAsbt() {
        return asbt;
    }

    public void setAsbt(String asbt) {
        this.asbt = DateTimeUtil.timeDayFormatByStr(asbt);
    }

    public String getAebt() {
        return aebt;
    }

    public void setAebt(String aebt) {
        this.aebt = DateTimeUtil.timeDayFormatByStr(aebt);
    }

    public String getErsl() {
        return ersl;
    }

    public void setErsl(String ersl) {
        this.ersl = DateTimeUtil.timeDayFormatByStr(ersl);
    }

    public String getElsw() {
        return elsw;
    }

    public void setElsw(String elsw) {
        this.elsw = DateTimeUtil.timeDayFormatByStr(elsw);
    }

    public String getArsl() {
        return arsl;
    }

    public void setArsl(String arsl) {
        this.arsl = DateTimeUtil.timeDayFormatByStr(arsl);
    }

    public String getAlsw() {
        return alsw;
    }

    public void setAlsw(String alsw) {
        this.alsw = DateTimeUtil.timeDayFormatByStr(alsw);
    }

    public String getaGrndTsfTm() {
        return aGrndTsfTm;
    }

    public void setaGrndTsfTm(String aGrndTsfTm) {
        this.aGrndTsfTm = DateTimeUtil.timeDayFormatByStr(aGrndTsfTm);
    }

    public String getdGrndTsfTm() {
        return dGrndTsfTm;
    }

    public void setdGrndTsfTm(String dGrndTsfTm) {
        this.dGrndTsfTm = DateTimeUtil.timeDayFormatByStr(dGrndTsfTm);
    }

    public String getIsfocus() {
        return isfocus;
    }

    public void setIsfocus(String isfocus) {
        this.isfocus = isfocus;
    }

    public String getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime;
    }
}
