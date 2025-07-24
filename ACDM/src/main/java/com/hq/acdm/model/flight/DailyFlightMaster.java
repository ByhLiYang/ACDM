package com.hq.acdm.model.flight;

import java.math.BigDecimal;
import java.util.Date;

public class DailyFlightMaster extends DailyFlightMasterKey {
    private String arn;

    private String type;

    private String flightNoIcao;

    private String airlineCodeIata;

    private String airlineCodeIcao;

    private String originAirportIata;

    private String originAirportIcao;

    private String destAirportIata;

    private String destAirportIcao;

    private String prevFlightNoIata;

    private String prevFlightNoIcao;

    private String nxtFlightNoIata;

    private String nxtFlightNoIcao;

    private String stand;

    private String gate1;

    private String gate2;

    private String gate3;

    private String rwy;

    private String belt1;

    private String belt2;

    private String belt3;

    private String counters;

    private String taxiway;

    private String deicingGate;

    private String dOrI;

    private String milestoneStatus;

    private String delayStatus;

    private String currentDelayCode;

    private Date atmo;

    private Date fadt;

    private Date atot;

    private Date sldt;

    private Date eldt;

    private Date aldt;

    private Date sibt;

    private Date eibt;

    private Date aibt;

    private BigDecimal exit;

    private BigDecimal axit;

    private Date scgt;

    private Date ecgt;

    private Date acgt;

    private Date aegt;

    private BigDecimal mttt;

    private BigDecimal ettt;

    private BigDecimal sttt;

    private BigDecimal aght;

    private Date ssbt;

    private Date esbt;

    private Date asbt;

    private Date srdt;

    private Date erdt;

    private Date ardt;

    private Date esrt;

    private Date asrt;

    private Date ssat;

    private Date esat;

    private Date tsat;

    private Date asat;

    private Date sobt;

    private Date eobt;

    private Date tobt;

    private Date aobt;

    private BigDecimal exot;

    private BigDecimal axot;

    private Date erzt;

    private Date sczt;

    private Date eczt;

    private Date aczt;

    private Date sezt;

    private Date eezt;

    private Date aezt;

    private BigDecimal adit;

    private Date stot;

    private Date etot;

    private Date ttot;

    private String eet;

    private String diversionstatus;

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        this.arn = arn == null ? null : arn.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFlightNoIcao() {
        return flightNoIcao;
    }

    public void setFlightNoIcao(String flightNoIcao) {
        this.flightNoIcao = flightNoIcao == null ? null : flightNoIcao.trim();
    }

    public String getAirlineCodeIata() {
        return airlineCodeIata;
    }

    public void setAirlineCodeIata(String airlineCodeIata) {
        this.airlineCodeIata = airlineCodeIata == null ? null : airlineCodeIata.trim();
    }

    public String getAirlineCodeIcao() {
        return airlineCodeIcao;
    }

    public void setAirlineCodeIcao(String airlineCodeIcao) {
        this.airlineCodeIcao = airlineCodeIcao == null ? null : airlineCodeIcao.trim();
    }

    public String getOriginAirportIata() {
        return originAirportIata;
    }

    public void setOriginAirportIata(String originAirportIata) {
        this.originAirportIata = originAirportIata == null ? null : originAirportIata.trim();
    }

    public String getOriginAirportIcao() {
        return originAirportIcao;
    }

    public void setOriginAirportIcao(String originAirportIcao) {
        this.originAirportIcao = originAirportIcao == null ? null : originAirportIcao.trim();
    }

    public String getDestAirportIata() {
        return destAirportIata;
    }

    public void setDestAirportIata(String destAirportIata) {
        this.destAirportIata = destAirportIata == null ? null : destAirportIata.trim();
    }

    public String getDestAirportIcao() {
        return destAirportIcao;
    }

    public void setDestAirportIcao(String destAirportIcao) {
        this.destAirportIcao = destAirportIcao == null ? null : destAirportIcao.trim();
    }

    public String getPrevFlightNoIata() {
        return prevFlightNoIata;
    }

    public void setPrevFlightNoIata(String prevFlightNoIata) {
        this.prevFlightNoIata = prevFlightNoIata == null ? null : prevFlightNoIata.trim();
    }

    public String getPrevFlightNoIcao() {
        return prevFlightNoIcao;
    }

    public void setPrevFlightNoIcao(String prevFlightNoIcao) {
        this.prevFlightNoIcao = prevFlightNoIcao == null ? null : prevFlightNoIcao.trim();
    }

    public String getNxtFlightNoIata() {
        return nxtFlightNoIata;
    }

    public void setNxtFlightNoIata(String nxtFlightNoIata) {
        this.nxtFlightNoIata = nxtFlightNoIata == null ? null : nxtFlightNoIata.trim();
    }

    public String getNxtFlightNoIcao() {
        return nxtFlightNoIcao;
    }

    public void setNxtFlightNoIcao(String nxtFlightNoIcao) {
        this.nxtFlightNoIcao = nxtFlightNoIcao == null ? null : nxtFlightNoIcao.trim();
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand == null ? null : stand.trim();
    }

    public String getGate1() {
        return gate1;
    }

    public void setGate1(String gate1) {
        this.gate1 = gate1 == null ? null : gate1.trim();
    }

    public String getGate2() {
        return gate2;
    }

    public void setGate2(String gate2) {
        this.gate2 = gate2 == null ? null : gate2.trim();
    }

    public String getGate3() {
        return gate3;
    }

    public void setGate3(String gate3) {
        this.gate3 = gate3 == null ? null : gate3.trim();
    }

    public String getRwy() {
        return rwy;
    }

    public void setRwy(String rwy) {
        this.rwy = rwy == null ? null : rwy.trim();
    }

    public String getBelt1() {
        return belt1;
    }

    public void setBelt1(String belt1) {
        this.belt1 = belt1 == null ? null : belt1.trim();
    }

    public String getBelt2() {
        return belt2;
    }

    public void setBelt2(String belt2) {
        this.belt2 = belt2 == null ? null : belt2.trim();
    }

    public String getBelt3() {
        return belt3;
    }

    public void setBelt3(String belt3) {
        this.belt3 = belt3 == null ? null : belt3.trim();
    }

    public String getCounters() {
        return counters;
    }

    public void setCounters(String counters) {
        this.counters = counters == null ? null : counters.trim();
    }

    public String getTaxiway() {
        return taxiway;
    }

    public void setTaxiway(String taxiway) {
        this.taxiway = taxiway == null ? null : taxiway.trim();
    }

    public String getDeicingGate() {
        return deicingGate;
    }

    public void setDeicingGate(String deicingGate) {
        this.deicingGate = deicingGate == null ? null : deicingGate.trim();
    }

    public String getdOrI() {
        return dOrI;
    }

    public void setdOrI(String dOrI) {
        this.dOrI = dOrI == null ? null : dOrI.trim();
    }

    public String getMilestoneStatus() {
        return milestoneStatus;
    }

    public void setMilestoneStatus(String milestoneStatus) {
        this.milestoneStatus = milestoneStatus == null ? null : milestoneStatus.trim();
    }

    public String getDelayStatus() {
        return delayStatus;
    }

    public void setDelayStatus(String delayStatus) {
        this.delayStatus = delayStatus == null ? null : delayStatus.trim();
    }

    public String getCurrentDelayCode() {
        return currentDelayCode;
    }

    public void setCurrentDelayCode(String currentDelayCode) {
        this.currentDelayCode = currentDelayCode == null ? null : currentDelayCode.trim();
    }

    public Date getAtmo() {
        return atmo;
    }

    public void setAtmo(Date atmo) {
        this.atmo = atmo;
    }

    public Date getFadt() {
        return fadt;
    }

    public void setFadt(Date fadt) {
        this.fadt = fadt;
    }

    public Date getAtot() {
        return atot;
    }

    public void setAtot(Date atot) {
        this.atot = atot;
    }

    public Date getSldt() {
        return sldt;
    }

    public void setSldt(Date sldt) {
        this.sldt = sldt;
    }

    public Date getEldt() {
        return eldt;
    }

    public void setEldt(Date eldt) {
        this.eldt = eldt;
    }

    public Date getAldt() {
        return aldt;
    }

    public void setAldt(Date aldt) {
        this.aldt = aldt;
    }

    public Date getSibt() {
        return sibt;
    }

    public void setSibt(Date sibt) {
        this.sibt = sibt;
    }

    public Date getEibt() {
        return eibt;
    }

    public void setEibt(Date eibt) {
        this.eibt = eibt;
    }

    public Date getAibt() {
        return aibt;
    }

    public void setAibt(Date aibt) {
        this.aibt = aibt;
    }

    public BigDecimal getExit() {
        return exit;
    }

    public void setExit(BigDecimal exit) {
        this.exit = exit;
    }

    public BigDecimal getAxit() {
        return axit;
    }

    public void setAxit(BigDecimal axit) {
        this.axit = axit;
    }

    public Date getScgt() {
        return scgt;
    }

    public void setScgt(Date scgt) {
        this.scgt = scgt;
    }

    public Date getEcgt() {
        return ecgt;
    }

    public void setEcgt(Date ecgt) {
        this.ecgt = ecgt;
    }

    public Date getAcgt() {
        return acgt;
    }

    public void setAcgt(Date acgt) {
        this.acgt = acgt;
    }

    public Date getAegt() {
        return aegt;
    }

    public void setAegt(Date aegt) {
        this.aegt = aegt;
    }

    public BigDecimal getMttt() {
        return mttt;
    }

    public void setMttt(BigDecimal mttt) {
        this.mttt = mttt;
    }

    public BigDecimal getEttt() {
        return ettt;
    }

    public void setEttt(BigDecimal ettt) {
        this.ettt = ettt;
    }

    public BigDecimal getSttt() {
        return sttt;
    }

    public void setSttt(BigDecimal sttt) {
        this.sttt = sttt;
    }

    public BigDecimal getAght() {
        return aght;
    }

    public void setAght(BigDecimal aght) {
        this.aght = aght;
    }

    public Date getSsbt() {
        return ssbt;
    }

    public void setSsbt(Date ssbt) {
        this.ssbt = ssbt;
    }

    public Date getEsbt() {
        return esbt;
    }

    public void setEsbt(Date esbt) {
        this.esbt = esbt;
    }

    public Date getAsbt() {
        return asbt;
    }

    public void setAsbt(Date asbt) {
        this.asbt = asbt;
    }

    public Date getSrdt() {
        return srdt;
    }

    public void setSrdt(Date srdt) {
        this.srdt = srdt;
    }

    public Date getErdt() {
        return erdt;
    }

    public void setErdt(Date erdt) {
        this.erdt = erdt;
    }

    public Date getArdt() {
        return ardt;
    }

    public void setArdt(Date ardt) {
        this.ardt = ardt;
    }

    public Date getEsrt() {
        return esrt;
    }

    public void setEsrt(Date esrt) {
        this.esrt = esrt;
    }

    public Date getAsrt() {
        return asrt;
    }

    public void setAsrt(Date asrt) {
        this.asrt = asrt;
    }

    public Date getSsat() {
        return ssat;
    }

    public void setSsat(Date ssat) {
        this.ssat = ssat;
    }

    public Date getEsat() {
        return esat;
    }

    public void setEsat(Date esat) {
        this.esat = esat;
    }

    public Date getTsat() {
        return tsat;
    }

    public void setTsat(Date tsat) {
        this.tsat = tsat;
    }

    public Date getAsat() {
        return asat;
    }

    public void setAsat(Date asat) {
        this.asat = asat;
    }

    public Date getSobt() {
        return sobt;
    }

    public void setSobt(Date sobt) {
        this.sobt = sobt;
    }

    public Date getEobt() {
        return eobt;
    }

    public void setEobt(Date eobt) {
        this.eobt = eobt;
    }

    public Date getTobt() {
        return tobt;
    }

    public void setTobt(Date tobt) {
        this.tobt = tobt;
    }

    public Date getAobt() {
        return aobt;
    }

    public void setAobt(Date aobt) {
        this.aobt = aobt;
    }

    public BigDecimal getExot() {
        return exot;
    }

    public void setExot(BigDecimal exot) {
        this.exot = exot;
    }

    public BigDecimal getAxot() {
        return axot;
    }

    public void setAxot(BigDecimal axot) {
        this.axot = axot;
    }

    public Date getErzt() {
        return erzt;
    }

    public void setErzt(Date erzt) {
        this.erzt = erzt;
    }

    public Date getSczt() {
        return sczt;
    }

    public void setSczt(Date sczt) {
        this.sczt = sczt;
    }

    public Date getEczt() {
        return eczt;
    }

    public void setEczt(Date eczt) {
        this.eczt = eczt;
    }

    public Date getAczt() {
        return aczt;
    }

    public void setAczt(Date aczt) {
        this.aczt = aczt;
    }

    public Date getSezt() {
        return sezt;
    }

    public void setSezt(Date sezt) {
        this.sezt = sezt;
    }

    public Date getEezt() {
        return eezt;
    }

    public void setEezt(Date eezt) {
        this.eezt = eezt;
    }

    public Date getAezt() {
        return aezt;
    }

    public void setAezt(Date aezt) {
        this.aezt = aezt;
    }

    public BigDecimal getAdit() {
        return adit;
    }

    public void setAdit(BigDecimal adit) {
        this.adit = adit;
    }

    public Date getStot() {
        return stot;
    }

    public void setStot(Date stot) {
        this.stot = stot;
    }

    public Date getEtot() {
        return etot;
    }

    public void setEtot(Date etot) {
        this.etot = etot;
    }

    public Date getTtot() {
        return ttot;
    }

    public void setTtot(Date ttot) {
        this.ttot = ttot;
    }

    public String getEet() {
        return eet;
    }

    public void setEet(String eet) {
        this.eet = eet == null ? null : eet.trim();
    }

    public String getDiversionstatus() {
        return diversionstatus;
    }

    public void setDiversionstatus(String diversionstatus) {
        this.diversionstatus = diversionstatus == null ? null : diversionstatus.trim();
    }
}