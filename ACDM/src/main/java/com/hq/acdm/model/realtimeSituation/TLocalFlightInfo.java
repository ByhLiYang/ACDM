package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TLocalFlightInfo implements Serializable {
    private String id;

    private Integer flightId;

    private Integer associatedFlightId;

    private String ffid;

    private String airlines;

    private Date planTime;

    private String flno;

    private Date execDate;

    private Date flightIdentyManageDate;

    private String dOrA;

    private String flightTask;

    private String attribute;

    private Integer takeoffLandinCount;

    private String agency;

    private String craftTypeIcao;

    private String regn;

    private String normalFlightStatCd;

    private String abnormalFlightStatCd;

    private String isVip;

    private Integer vipNumber;

    private Date sobt;

    private Date sibt;

    private Date eobt;

    private Date eibt;

    private Date aobt;

    private Date aibt;

    private Date eldt;

    private Date etot;

    private Date aldt;

    private Date atot;

    private String shareFlno;

    private String adep;

    private String ades;

    private String startStation;

    private Date startSobt;

    private Date startSibt;

    private Date startEobt;

    private Date startEibt;

    private Date startAobt;

    private Date startAibt;

    private String bckOrAlt;

    private String altAdes;

    private Date altSibt;

    private Date altEldt;

    private Date altAldt;

    private Integer exit;

    private Integer exot;

    private Integer axit;

    private Integer axot;

    private Integer delayTime;

    private String stand;

    private String gate;

    private Date checkStartTime;

    private Date checkEndTime;

    private Date cobt;

    private Date ctot;

    private Date tobt;

    private Date ttot;

    private Date aTobt;

    private Date dobt;

    private Date fct;

    private Date rpot;

    private Date apot;

    private Date asat;

    private String runway;

    private Date ersl;

    private Date arsl;

    private Date elsw;

    private Date alsw;

    private Date stdc;

    private Date etdo;

    private Date atdo;

    private Date etdc;

    private Date atdc;

    private Date etfo;

    private Date atfo;

    private Date etfc;

    private Date atfc;

    private Date esr;

    private Date asr;

    private Date eer;

    private Date aer;

    private Date esc;

    private Date asc;

    private Date eec;

    private Date aec;

    private Date esct;

    private Date asct;

    private Date efct;

    private Date afct;

    private Date esbt;

    private Date asbt;

    private Date lcbt;

    private Date eebt;

    private Date aebt;

    private Date ecdt;

    private Date acdt;

    private Date eedt;

    private Date aedt;

    private Date aact;

    private Date aGrndTsfTm;

    private Date dGrndTsfTm;

    private Date mpbt;

    private Date mpet;

    private Date ldbt;

    private Date ldet;

    private Date trdt;

    private Date cdpt;

    private String terminal;

    private Integer bagCount;

    private Integer bagWeight;

    private Integer paxCount;

    private String isdel;

    private Integer isspecial;

    private Integer ismanualid;

    private Integer iscontrol;

    private Integer isfocus;

    private String rmk;

    private Date createTm;

    private Date updateTm;

    private String createUsr;

    private String updateUsr;

    private Date node1;

    private Date node2;

    private Date node3;

    private Date node4;

    private Date node5;

    private Date node6;

    private Date node7;

    private Date node8;

    private Date node9;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getAssociatedFlightId() {
        return associatedFlightId;
    }

    public void setAssociatedFlightId(Integer associatedFlightId) {
        this.associatedFlightId = associatedFlightId;
    }

    public String getFfid() {
        return ffid;
    }

    public void setFfid(String ffid) {
        this.ffid = ffid == null ? null : ffid.trim();
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines == null ? null : airlines.trim();
    }

    public Date getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Date planTime) {
        this.planTime = planTime;
    }

    public String getFlno() {
        return flno;
    }

    public void setFlno(String flno) {
        this.flno = flno == null ? null : flno.trim();
    }

    public Date getExecDate() {
        return execDate;
    }

    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }

    public Date getFlightIdentyManageDate() {
        return flightIdentyManageDate;
    }

    public void setFlightIdentyManageDate(Date flightIdentyManageDate) {
        this.flightIdentyManageDate = flightIdentyManageDate;
    }

    public String getdOrA() {
        return dOrA;
    }

    public void setdOrA(String dOrA) {
        this.dOrA = dOrA == null ? null : dOrA.trim();
    }

    public String getFlightTask() {
        return flightTask;
    }

    public void setFlightTask(String flightTask) {
        this.flightTask = flightTask == null ? null : flightTask.trim();
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
    }

    public Integer getTakeoffLandinCount() {
        return takeoffLandinCount;
    }

    public void setTakeoffLandinCount(Integer takeoffLandinCount) {
        this.takeoffLandinCount = takeoffLandinCount;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency == null ? null : agency.trim();
    }

    public String getCraftTypeIcao() {
        return craftTypeIcao;
    }

    public void setCraftTypeIcao(String craftTypeIcao) {
        this.craftTypeIcao = craftTypeIcao == null ? null : craftTypeIcao.trim();
    }

    public String getRegn() {
        return regn;
    }

    public void setRegn(String regn) {
        this.regn = regn == null ? null : regn.trim();
    }

    public String getNormalFlightStatCd() {
        return normalFlightStatCd;
    }

    public void setNormalFlightStatCd(String normalFlightStatCd) {
        this.normalFlightStatCd = normalFlightStatCd == null ? null : normalFlightStatCd.trim();
    }

    public String getAbnormalFlightStatCd() {
        return abnormalFlightStatCd;
    }

    public void setAbnormalFlightStatCd(String abnormalFlightStatCd) {
        this.abnormalFlightStatCd = abnormalFlightStatCd == null ? null : abnormalFlightStatCd.trim();
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip == null ? null : isVip.trim();
    }

    public Integer getVipNumber() {
        return vipNumber;
    }

    public void setVipNumber(Integer vipNumber) {
        this.vipNumber = vipNumber;
    }

    public Date getSobt() {
        return sobt;
    }

    public void setSobt(Date sobt) {
        this.sobt = sobt;
    }

    public Date getSibt() {
        return sibt;
    }

    public void setSibt(Date sibt) {
        this.sibt = sibt;
    }

    public Date getEobt() {
        return eobt;
    }

    public void setEobt(Date eobt) {
        this.eobt = eobt;
    }

    public Date getEibt() {
        return eibt;
    }

    public void setEibt(Date eibt) {
        this.eibt = eibt;
    }

    public Date getAobt() {
        return aobt;
    }

    public void setAobt(Date aobt) {
        this.aobt = aobt;
    }

    public Date getAibt() {
        return aibt;
    }

    public void setAibt(Date aibt) {
        this.aibt = aibt;
    }

    public Date getEldt() {
        return eldt;
    }

    public void setEldt(Date eldt) {
        this.eldt = eldt;
    }

    public Date getEtot() {
        return etot;
    }

    public void setEtot(Date etot) {
        this.etot = etot;
    }

    public Date getAldt() {
        return aldt;
    }

    public void setAldt(Date aldt) {
        this.aldt = aldt;
    }

    public Date getAtot() {
        return atot;
    }

    public void setAtot(Date atot) {
        this.atot = atot;
    }

    public String getShareFlno() {
        return shareFlno;
    }

    public void setShareFlno(String shareFlno) {
        this.shareFlno = shareFlno == null ? null : shareFlno.trim();
    }

    public String getAdep() {
        return adep;
    }

    public void setAdep(String adep) {
        this.adep = adep == null ? null : adep.trim();
    }

    public String getAdes() {
        return ades;
    }

    public void setAdes(String ades) {
        this.ades = ades == null ? null : ades.trim();
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation == null ? null : startStation.trim();
    }

    public Date getStartSobt() {
        return startSobt;
    }

    public void setStartSobt(Date startSobt) {
        this.startSobt = startSobt;
    }

    public Date getStartSibt() {
        return startSibt;
    }

    public void setStartSibt(Date startSibt) {
        this.startSibt = startSibt;
    }

    public Date getStartEobt() {
        return startEobt;
    }

    public void setStartEobt(Date startEobt) {
        this.startEobt = startEobt;
    }

    public Date getStartEibt() {
        return startEibt;
    }

    public void setStartEibt(Date startEibt) {
        this.startEibt = startEibt;
    }

    public Date getStartAobt() {
        return startAobt;
    }

    public void setStartAobt(Date startAobt) {
        this.startAobt = startAobt;
    }

    public Date getStartAibt() {
        return startAibt;
    }

    public void setStartAibt(Date startAibt) {
        this.startAibt = startAibt;
    }

    public String getBckOrAlt() {
        return bckOrAlt;
    }

    public void setBckOrAlt(String bckOrAlt) {
        this.bckOrAlt = bckOrAlt == null ? null : bckOrAlt.trim();
    }

    public String getAltAdes() {
        return altAdes;
    }

    public void setAltAdes(String altAdes) {
        this.altAdes = altAdes == null ? null : altAdes.trim();
    }

    public Date getAltSibt() {
        return altSibt;
    }

    public void setAltSibt(Date altSibt) {
        this.altSibt = altSibt;
    }

    public Date getAltEldt() {
        return altEldt;
    }

    public void setAltEldt(Date altEldt) {
        this.altEldt = altEldt;
    }

    public Date getAltAldt() {
        return altAldt;
    }

    public void setAltAldt(Date altAldt) {
        this.altAldt = altAldt;
    }

    public Integer getExit() {
        return exit;
    }

    public void setExit(Integer exit) {
        this.exit = exit;
    }

    public Integer getExot() {
        return exot;
    }

    public void setExot(Integer exot) {
        this.exot = exot;
    }

    public Integer getAxit() {
        return axit;
    }

    public void setAxit(Integer axit) {
        this.axit = axit;
    }

    public Integer getAxot() {
        return axot;
    }

    public void setAxot(Integer axot) {
        this.axot = axot;
    }

    public Integer getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Integer delayTime) {
        this.delayTime = delayTime;
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand == null ? null : stand.trim();
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate == null ? null : gate.trim();
    }

    public Date getCheckStartTime() {
        return checkStartTime;
    }

    public void setCheckStartTime(Date checkStartTime) {
        this.checkStartTime = checkStartTime;
    }

    public Date getCheckEndTime() {
        return checkEndTime;
    }

    public void setCheckEndTime(Date checkEndTime) {
        this.checkEndTime = checkEndTime;
    }

    public Date getCobt() {
        return cobt;
    }

    public void setCobt(Date cobt) {
        this.cobt = cobt;
    }

    public Date getCtot() {
        return ctot;
    }

    public void setCtot(Date ctot) {
        this.ctot = ctot;
    }

    public Date getTobt() {
        return tobt;
    }

    public void setTobt(Date tobt) {
        this.tobt = tobt;
    }

    public Date getTtot() {
        return ttot;
    }

    public void setTtot(Date ttot) {
        this.ttot = ttot;
    }

    public Date getaTobt() {
        return aTobt;
    }

    public void setaTobt(Date aTobt) {
        this.aTobt = aTobt;
    }

    public Date getDobt() {
        return dobt;
    }

    public void setDobt(Date dobt) {
        this.dobt = dobt;
    }

    public Date getFct() {
        return fct;
    }

    public void setFct(Date fct) {
        this.fct = fct;
    }

    public Date getRpot() {
        return rpot;
    }

    public void setRpot(Date rpot) {
        this.rpot = rpot;
    }

    public Date getApot() {
        return apot;
    }

    public void setApot(Date apot) {
        this.apot = apot;
    }

    public Date getAsat() {
        return asat;
    }

    public void setAsat(Date asat) {
        this.asat = asat;
    }

    public String getRunway() {
        return runway;
    }

    public void setRunway(String runway) {
        this.runway = runway == null ? null : runway.trim();
    }

    public Date getErsl() {
        return ersl;
    }

    public void setErsl(Date ersl) {
        this.ersl = ersl;
    }

    public Date getArsl() {
        return arsl;
    }

    public void setArsl(Date arsl) {
        this.arsl = arsl;
    }

    public Date getElsw() {
        return elsw;
    }

    public void setElsw(Date elsw) {
        this.elsw = elsw;
    }

    public Date getAlsw() {
        return alsw;
    }

    public void setAlsw(Date alsw) {
        this.alsw = alsw;
    }

    public Date getStdc() {
        return stdc;
    }

    public void setStdc(Date stdc) {
        this.stdc = stdc;
    }

    public Date getEtdo() {
        return etdo;
    }

    public void setEtdo(Date etdo) {
        this.etdo = etdo;
    }

    public Date getAtdo() {
        return atdo;
    }

    public void setAtdo(Date atdo) {
        this.atdo = atdo;
    }

    public Date getEtdc() {
        return etdc;
    }

    public void setEtdc(Date etdc) {
        this.etdc = etdc;
    }

    public Date getAtdc() {
        return atdc;
    }

    public void setAtdc(Date atdc) {
        this.atdc = atdc;
    }

    public Date getEtfo() {
        return etfo;
    }

    public void setEtfo(Date etfo) {
        this.etfo = etfo;
    }

    public Date getAtfo() {
        return atfo;
    }

    public void setAtfo(Date atfo) {
        this.atfo = atfo;
    }

    public Date getEtfc() {
        return etfc;
    }

    public void setEtfc(Date etfc) {
        this.etfc = etfc;
    }

    public Date getAtfc() {
        return atfc;
    }

    public void setAtfc(Date atfc) {
        this.atfc = atfc;
    }

    public Date getEsr() {
        return esr;
    }

    public void setEsr(Date esr) {
        this.esr = esr;
    }

    public Date getAsr() {
        return asr;
    }

    public void setAsr(Date asr) {
        this.asr = asr;
    }

    public Date getEer() {
        return eer;
    }

    public void setEer(Date eer) {
        this.eer = eer;
    }

    public Date getAer() {
        return aer;
    }

    public void setAer(Date aer) {
        this.aer = aer;
    }

    public Date getEsc() {
        return esc;
    }

    public void setEsc(Date esc) {
        this.esc = esc;
    }

    public Date getAsc() {
        return asc;
    }

    public void setAsc(Date asc) {
        this.asc = asc;
    }

    public Date getEec() {
        return eec;
    }

    public void setEec(Date eec) {
        this.eec = eec;
    }

    public Date getAec() {
        return aec;
    }

    public void setAec(Date aec) {
        this.aec = aec;
    }

    public Date getEsct() {
        return esct;
    }

    public void setEsct(Date esct) {
        this.esct = esct;
    }

    public Date getAsct() {
        return asct;
    }

    public void setAsct(Date asct) {
        this.asct = asct;
    }

    public Date getEfct() {
        return efct;
    }

    public void setEfct(Date efct) {
        this.efct = efct;
    }

    public Date getAfct() {
        return afct;
    }

    public void setAfct(Date afct) {
        this.afct = afct;
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

    public Date getLcbt() {
        return lcbt;
    }

    public void setLcbt(Date lcbt) {
        this.lcbt = lcbt;
    }

    public Date getEebt() {
        return eebt;
    }

    public void setEebt(Date eebt) {
        this.eebt = eebt;
    }

    public Date getAebt() {
        return aebt;
    }

    public void setAebt(Date aebt) {
        this.aebt = aebt;
    }

    public Date getEcdt() {
        return ecdt;
    }

    public void setEcdt(Date ecdt) {
        this.ecdt = ecdt;
    }

    public Date getAcdt() {
        return acdt;
    }

    public void setAcdt(Date acdt) {
        this.acdt = acdt;
    }

    public Date getEedt() {
        return eedt;
    }

    public void setEedt(Date eedt) {
        this.eedt = eedt;
    }

    public Date getAedt() {
        return aedt;
    }

    public void setAedt(Date aedt) {
        this.aedt = aedt;
    }

    public Date getAact() {
        return aact;
    }

    public void setAact(Date aact) {
        this.aact = aact;
    }

    public Date getaGrndTsfTm() {
        return aGrndTsfTm;
    }

    public void setaGrndTsfTm(Date aGrndTsfTm) {
        this.aGrndTsfTm = aGrndTsfTm;
    }

    public Date getdGrndTsfTm() {
        return dGrndTsfTm;
    }

    public void setdGrndTsfTm(Date dGrndTsfTm) {
        this.dGrndTsfTm = dGrndTsfTm;
    }

    public Date getMpbt() {
        return mpbt;
    }

    public void setMpbt(Date mpbt) {
        this.mpbt = mpbt;
    }

    public Date getMpet() {
        return mpet;
    }

    public void setMpet(Date mpet) {
        this.mpet = mpet;
    }

    public Date getLdbt() {
        return ldbt;
    }

    public void setLdbt(Date ldbt) {
        this.ldbt = ldbt;
    }

    public Date getLdet() {
        return ldet;
    }

    public void setLdet(Date ldet) {
        this.ldet = ldet;
    }

    public Date getTrdt() {
        return trdt;
    }

    public void setTrdt(Date trdt) {
        this.trdt = trdt;
    }

    public Date getCdpt() {
        return cdpt;
    }

    public void setCdpt(Date cdpt) {
        this.cdpt = cdpt;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal == null ? null : terminal.trim();
    }

    public Integer getBagCount() {
        return bagCount;
    }

    public void setBagCount(Integer bagCount) {
        this.bagCount = bagCount;
    }

    public Integer getBagWeight() {
        return bagWeight;
    }

    public void setBagWeight(Integer bagWeight) {
        this.bagWeight = bagWeight;
    }

    public Integer getPaxCount() {
        return paxCount;
    }

    public void setPaxCount(Integer paxCount) {
        this.paxCount = paxCount;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }

    public Integer getIsspecial() {
        return isspecial;
    }

    public void setIsspecial(Integer isspecial) {
        this.isspecial = isspecial;
    }

    public Integer getIsmanualid() {
        return ismanualid;
    }

    public void setIsmanualid(Integer ismanualid) {
        this.ismanualid = ismanualid;
    }

    public Integer getIscontrol() {
        return iscontrol;
    }

    public void setIscontrol(Integer iscontrol) {
        this.iscontrol = iscontrol;
    }

    public Integer getIsfocus() {
        return isfocus;
    }

    public void setIsfocus(Integer isfocus) {
        this.isfocus = isfocus;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public Date getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(Date updateTm) {
        this.updateTm = updateTm;
    }

    public String getCreateUsr() {
        return createUsr;
    }

    public void setCreateUsr(String createUsr) {
        this.createUsr = createUsr == null ? null : createUsr.trim();
    }

    public String getUpdateUsr() {
        return updateUsr;
    }

    public void setUpdateUsr(String updateUsr) {
        this.updateUsr = updateUsr == null ? null : updateUsr.trim();
    }

    public Date getNode1() {
        return node1;
    }

    public void setNode1(Date node1) {
        this.node1 = node1;
    }

    public Date getNode2() {
        return node2;
    }

    public void setNode2(Date node2) {
        this.node2 = node2;
    }

    public Date getNode3() {
        return node3;
    }

    public void setNode3(Date node3) {
        this.node3 = node3;
    }

    public Date getNode4() {
        return node4;
    }

    public void setNode4(Date node4) {
        this.node4 = node4;
    }

    public Date getNode5() {
        return node5;
    }

    public void setNode5(Date node5) {
        this.node5 = node5;
    }

    public Date getNode6() {
        return node6;
    }

    public void setNode6(Date node6) {
        this.node6 = node6;
    }

    public Date getNode7() {
        return node7;
    }

    public void setNode7(Date node7) {
        this.node7 = node7;
    }

    public Date getNode8() {
        return node8;
    }

    public void setNode8(Date node8) {
        this.node8 = node8;
    }

    public Date getNode9() {
        return node9;
    }

    public void setNode9(Date node9) {
        this.node9 = node9;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TLocalFlightInfo other = (TLocalFlightInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFlightId() == null ? other.getFlightId() == null : this.getFlightId().equals(other.getFlightId()))
            && (this.getAssociatedFlightId() == null ? other.getAssociatedFlightId() == null : this.getAssociatedFlightId().equals(other.getAssociatedFlightId()))
            && (this.getFfid() == null ? other.getFfid() == null : this.getFfid().equals(other.getFfid()))
            && (this.getAirlines() == null ? other.getAirlines() == null : this.getAirlines().equals(other.getAirlines()))
            && (this.getPlanTime() == null ? other.getPlanTime() == null : this.getPlanTime().equals(other.getPlanTime()))
            && (this.getFlno() == null ? other.getFlno() == null : this.getFlno().equals(other.getFlno()))
            && (this.getExecDate() == null ? other.getExecDate() == null : this.getExecDate().equals(other.getExecDate()))
            && (this.getFlightIdentyManageDate() == null ? other.getFlightIdentyManageDate() == null : this.getFlightIdentyManageDate().equals(other.getFlightIdentyManageDate()))
            && (this.getdOrA() == null ? other.getdOrA() == null : this.getdOrA().equals(other.getdOrA()))
            && (this.getFlightTask() == null ? other.getFlightTask() == null : this.getFlightTask().equals(other.getFlightTask()))
            && (this.getAttribute() == null ? other.getAttribute() == null : this.getAttribute().equals(other.getAttribute()))
            && (this.getTakeoffLandinCount() == null ? other.getTakeoffLandinCount() == null : this.getTakeoffLandinCount().equals(other.getTakeoffLandinCount()))
            && (this.getAgency() == null ? other.getAgency() == null : this.getAgency().equals(other.getAgency()))
            && (this.getCraftTypeIcao() == null ? other.getCraftTypeIcao() == null : this.getCraftTypeIcao().equals(other.getCraftTypeIcao()))
            && (this.getRegn() == null ? other.getRegn() == null : this.getRegn().equals(other.getRegn()))
            && (this.getNormalFlightStatCd() == null ? other.getNormalFlightStatCd() == null : this.getNormalFlightStatCd().equals(other.getNormalFlightStatCd()))
            && (this.getAbnormalFlightStatCd() == null ? other.getAbnormalFlightStatCd() == null : this.getAbnormalFlightStatCd().equals(other.getAbnormalFlightStatCd()))
            && (this.getIsVip() == null ? other.getIsVip() == null : this.getIsVip().equals(other.getIsVip()))
            && (this.getVipNumber() == null ? other.getVipNumber() == null : this.getVipNumber().equals(other.getVipNumber()))
            && (this.getSobt() == null ? other.getSobt() == null : this.getSobt().equals(other.getSobt()))
            && (this.getSibt() == null ? other.getSibt() == null : this.getSibt().equals(other.getSibt()))
            && (this.getEobt() == null ? other.getEobt() == null : this.getEobt().equals(other.getEobt()))
            && (this.getEibt() == null ? other.getEibt() == null : this.getEibt().equals(other.getEibt()))
            && (this.getAobt() == null ? other.getAobt() == null : this.getAobt().equals(other.getAobt()))
            && (this.getAibt() == null ? other.getAibt() == null : this.getAibt().equals(other.getAibt()))
            && (this.getEldt() == null ? other.getEldt() == null : this.getEldt().equals(other.getEldt()))
            && (this.getEtot() == null ? other.getEtot() == null : this.getEtot().equals(other.getEtot()))
            && (this.getAldt() == null ? other.getAldt() == null : this.getAldt().equals(other.getAldt()))
            && (this.getAtot() == null ? other.getAtot() == null : this.getAtot().equals(other.getAtot()))
            && (this.getShareFlno() == null ? other.getShareFlno() == null : this.getShareFlno().equals(other.getShareFlno()))
            && (this.getAdep() == null ? other.getAdep() == null : this.getAdep().equals(other.getAdep()))
            && (this.getAdes() == null ? other.getAdes() == null : this.getAdes().equals(other.getAdes()))
            && (this.getStartStation() == null ? other.getStartStation() == null : this.getStartStation().equals(other.getStartStation()))
            && (this.getStartSobt() == null ? other.getStartSobt() == null : this.getStartSobt().equals(other.getStartSobt()))
            && (this.getStartSibt() == null ? other.getStartSibt() == null : this.getStartSibt().equals(other.getStartSibt()))
            && (this.getStartEobt() == null ? other.getStartEobt() == null : this.getStartEobt().equals(other.getStartEobt()))
            && (this.getStartEibt() == null ? other.getStartEibt() == null : this.getStartEibt().equals(other.getStartEibt()))
            && (this.getStartAobt() == null ? other.getStartAobt() == null : this.getStartAobt().equals(other.getStartAobt()))
            && (this.getStartAibt() == null ? other.getStartAibt() == null : this.getStartAibt().equals(other.getStartAibt()))
            && (this.getBckOrAlt() == null ? other.getBckOrAlt() == null : this.getBckOrAlt().equals(other.getBckOrAlt()))
            && (this.getAltAdes() == null ? other.getAltAdes() == null : this.getAltAdes().equals(other.getAltAdes()))
            && (this.getAltSibt() == null ? other.getAltSibt() == null : this.getAltSibt().equals(other.getAltSibt()))
            && (this.getAltEldt() == null ? other.getAltEldt() == null : this.getAltEldt().equals(other.getAltEldt()))
            && (this.getAltAldt() == null ? other.getAltAldt() == null : this.getAltAldt().equals(other.getAltAldt()))
            && (this.getExit() == null ? other.getExit() == null : this.getExit().equals(other.getExit()))
            && (this.getExot() == null ? other.getExot() == null : this.getExot().equals(other.getExot()))
            && (this.getAxit() == null ? other.getAxit() == null : this.getAxit().equals(other.getAxit()))
            && (this.getAxot() == null ? other.getAxot() == null : this.getAxot().equals(other.getAxot()))
            && (this.getDelayTime() == null ? other.getDelayTime() == null : this.getDelayTime().equals(other.getDelayTime()))
            && (this.getStand() == null ? other.getStand() == null : this.getStand().equals(other.getStand()))
            && (this.getGate() == null ? other.getGate() == null : this.getGate().equals(other.getGate()))
            && (this.getCheckStartTime() == null ? other.getCheckStartTime() == null : this.getCheckStartTime().equals(other.getCheckStartTime()))
            && (this.getCheckEndTime() == null ? other.getCheckEndTime() == null : this.getCheckEndTime().equals(other.getCheckEndTime()))
            && (this.getCobt() == null ? other.getCobt() == null : this.getCobt().equals(other.getCobt()))
            && (this.getCtot() == null ? other.getCtot() == null : this.getCtot().equals(other.getCtot()))
            && (this.getTobt() == null ? other.getTobt() == null : this.getTobt().equals(other.getTobt()))
            && (this.getTtot() == null ? other.getTtot() == null : this.getTtot().equals(other.getTtot()))
            && (this.getaTobt() == null ? other.getaTobt() == null : this.getaTobt().equals(other.getaTobt()))
            && (this.getDobt() == null ? other.getDobt() == null : this.getDobt().equals(other.getDobt()))
            && (this.getFct() == null ? other.getFct() == null : this.getFct().equals(other.getFct()))
            && (this.getRpot() == null ? other.getRpot() == null : this.getRpot().equals(other.getRpot()))
            && (this.getApot() == null ? other.getApot() == null : this.getApot().equals(other.getApot()))
            && (this.getAsat() == null ? other.getAsat() == null : this.getAsat().equals(other.getAsat()))
            && (this.getRunway() == null ? other.getRunway() == null : this.getRunway().equals(other.getRunway()))
            && (this.getErsl() == null ? other.getErsl() == null : this.getErsl().equals(other.getErsl()))
            && (this.getArsl() == null ? other.getArsl() == null : this.getArsl().equals(other.getArsl()))
            && (this.getElsw() == null ? other.getElsw() == null : this.getElsw().equals(other.getElsw()))
            && (this.getAlsw() == null ? other.getAlsw() == null : this.getAlsw().equals(other.getAlsw()))
            && (this.getStdc() == null ? other.getStdc() == null : this.getStdc().equals(other.getStdc()))
            && (this.getEtdo() == null ? other.getEtdo() == null : this.getEtdo().equals(other.getEtdo()))
            && (this.getAtdo() == null ? other.getAtdo() == null : this.getAtdo().equals(other.getAtdo()))
            && (this.getEtdc() == null ? other.getEtdc() == null : this.getEtdc().equals(other.getEtdc()))
            && (this.getAtdc() == null ? other.getAtdc() == null : this.getAtdc().equals(other.getAtdc()))
            && (this.getEtfo() == null ? other.getEtfo() == null : this.getEtfo().equals(other.getEtfo()))
            && (this.getAtfo() == null ? other.getAtfo() == null : this.getAtfo().equals(other.getAtfo()))
            && (this.getEtfc() == null ? other.getEtfc() == null : this.getEtfc().equals(other.getEtfc()))
            && (this.getAtfc() == null ? other.getAtfc() == null : this.getAtfc().equals(other.getAtfc()))
            && (this.getEsr() == null ? other.getEsr() == null : this.getEsr().equals(other.getEsr()))
            && (this.getAsr() == null ? other.getAsr() == null : this.getAsr().equals(other.getAsr()))
            && (this.getEer() == null ? other.getEer() == null : this.getEer().equals(other.getEer()))
            && (this.getAer() == null ? other.getAer() == null : this.getAer().equals(other.getAer()))
            && (this.getEsc() == null ? other.getEsc() == null : this.getEsc().equals(other.getEsc()))
            && (this.getAsc() == null ? other.getAsc() == null : this.getAsc().equals(other.getAsc()))
            && (this.getEec() == null ? other.getEec() == null : this.getEec().equals(other.getEec()))
            && (this.getAec() == null ? other.getAec() == null : this.getAec().equals(other.getAec()))
            && (this.getEsct() == null ? other.getEsct() == null : this.getEsct().equals(other.getEsct()))
            && (this.getAsct() == null ? other.getAsct() == null : this.getAsct().equals(other.getAsct()))
            && (this.getEfct() == null ? other.getEfct() == null : this.getEfct().equals(other.getEfct()))
            && (this.getAfct() == null ? other.getAfct() == null : this.getAfct().equals(other.getAfct()))
            && (this.getEsbt() == null ? other.getEsbt() == null : this.getEsbt().equals(other.getEsbt()))
            && (this.getAsbt() == null ? other.getAsbt() == null : this.getAsbt().equals(other.getAsbt()))
            && (this.getLcbt() == null ? other.getLcbt() == null : this.getLcbt().equals(other.getLcbt()))
            && (this.getEebt() == null ? other.getEebt() == null : this.getEebt().equals(other.getEebt()))
            && (this.getAebt() == null ? other.getAebt() == null : this.getAebt().equals(other.getAebt()))
            && (this.getEcdt() == null ? other.getEcdt() == null : this.getEcdt().equals(other.getEcdt()))
            && (this.getAcdt() == null ? other.getAcdt() == null : this.getAcdt().equals(other.getAcdt()))
            && (this.getEedt() == null ? other.getEedt() == null : this.getEedt().equals(other.getEedt()))
            && (this.getAedt() == null ? other.getAedt() == null : this.getAedt().equals(other.getAedt()))
            && (this.getAact() == null ? other.getAact() == null : this.getAact().equals(other.getAact()))
            && (this.getaGrndTsfTm() == null ? other.getaGrndTsfTm() == null : this.getaGrndTsfTm().equals(other.getaGrndTsfTm()))
            && (this.getdGrndTsfTm() == null ? other.getdGrndTsfTm() == null : this.getdGrndTsfTm().equals(other.getdGrndTsfTm()))
            && (this.getMpbt() == null ? other.getMpbt() == null : this.getMpbt().equals(other.getMpbt()))
            && (this.getMpet() == null ? other.getMpet() == null : this.getMpet().equals(other.getMpet()))
            && (this.getLdbt() == null ? other.getLdbt() == null : this.getLdbt().equals(other.getLdbt()))
            && (this.getLdet() == null ? other.getLdet() == null : this.getLdet().equals(other.getLdet()))
            && (this.getTrdt() == null ? other.getTrdt() == null : this.getTrdt().equals(other.getTrdt()))
            && (this.getCdpt() == null ? other.getCdpt() == null : this.getCdpt().equals(other.getCdpt()))
            && (this.getTerminal() == null ? other.getTerminal() == null : this.getTerminal().equals(other.getTerminal()))
            && (this.getBagCount() == null ? other.getBagCount() == null : this.getBagCount().equals(other.getBagCount()))
            && (this.getBagWeight() == null ? other.getBagWeight() == null : this.getBagWeight().equals(other.getBagWeight()))
            && (this.getPaxCount() == null ? other.getPaxCount() == null : this.getPaxCount().equals(other.getPaxCount()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()))
            && (this.getIsspecial() == null ? other.getIsspecial() == null : this.getIsspecial().equals(other.getIsspecial()))
            && (this.getIsmanualid() == null ? other.getIsmanualid() == null : this.getIsmanualid().equals(other.getIsmanualid()))
            && (this.getIscontrol() == null ? other.getIscontrol() == null : this.getIscontrol().equals(other.getIscontrol()))
            && (this.getIsfocus() == null ? other.getIsfocus() == null : this.getIsfocus().equals(other.getIsfocus()))
            && (this.getRmk() == null ? other.getRmk() == null : this.getRmk().equals(other.getRmk()))
            && (this.getCreateTm() == null ? other.getCreateTm() == null : this.getCreateTm().equals(other.getCreateTm()))
            && (this.getUpdateTm() == null ? other.getUpdateTm() == null : this.getUpdateTm().equals(other.getUpdateTm()))
            && (this.getCreateUsr() == null ? other.getCreateUsr() == null : this.getCreateUsr().equals(other.getCreateUsr()))
            && (this.getUpdateUsr() == null ? other.getUpdateUsr() == null : this.getUpdateUsr().equals(other.getUpdateUsr()))
            && (this.getNode1() == null ? other.getNode1() == null : this.getNode1().equals(other.getNode1()))
            && (this.getNode2() == null ? other.getNode2() == null : this.getNode2().equals(other.getNode2()))
            && (this.getNode3() == null ? other.getNode3() == null : this.getNode3().equals(other.getNode3()))
            && (this.getNode4() == null ? other.getNode4() == null : this.getNode4().equals(other.getNode4()))
            && (this.getNode5() == null ? other.getNode5() == null : this.getNode5().equals(other.getNode5()))
            && (this.getNode6() == null ? other.getNode6() == null : this.getNode6().equals(other.getNode6()))
            && (this.getNode7() == null ? other.getNode7() == null : this.getNode7().equals(other.getNode7()))
            && (this.getNode8() == null ? other.getNode8() == null : this.getNode8().equals(other.getNode8()))
            && (this.getNode9() == null ? other.getNode9() == null : this.getNode9().equals(other.getNode9()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFlightId() == null) ? 0 : getFlightId().hashCode());
        result = prime * result + ((getAssociatedFlightId() == null) ? 0 : getAssociatedFlightId().hashCode());
        result = prime * result + ((getFfid() == null) ? 0 : getFfid().hashCode());
        result = prime * result + ((getAirlines() == null) ? 0 : getAirlines().hashCode());
        result = prime * result + ((getPlanTime() == null) ? 0 : getPlanTime().hashCode());
        result = prime * result + ((getFlno() == null) ? 0 : getFlno().hashCode());
        result = prime * result + ((getExecDate() == null) ? 0 : getExecDate().hashCode());
        result = prime * result + ((getFlightIdentyManageDate() == null) ? 0 : getFlightIdentyManageDate().hashCode());
        result = prime * result + ((getdOrA() == null) ? 0 : getdOrA().hashCode());
        result = prime * result + ((getFlightTask() == null) ? 0 : getFlightTask().hashCode());
        result = prime * result + ((getAttribute() == null) ? 0 : getAttribute().hashCode());
        result = prime * result + ((getTakeoffLandinCount() == null) ? 0 : getTakeoffLandinCount().hashCode());
        result = prime * result + ((getAgency() == null) ? 0 : getAgency().hashCode());
        result = prime * result + ((getCraftTypeIcao() == null) ? 0 : getCraftTypeIcao().hashCode());
        result = prime * result + ((getRegn() == null) ? 0 : getRegn().hashCode());
        result = prime * result + ((getNormalFlightStatCd() == null) ? 0 : getNormalFlightStatCd().hashCode());
        result = prime * result + ((getAbnormalFlightStatCd() == null) ? 0 : getAbnormalFlightStatCd().hashCode());
        result = prime * result + ((getIsVip() == null) ? 0 : getIsVip().hashCode());
        result = prime * result + ((getVipNumber() == null) ? 0 : getVipNumber().hashCode());
        result = prime * result + ((getSobt() == null) ? 0 : getSobt().hashCode());
        result = prime * result + ((getSibt() == null) ? 0 : getSibt().hashCode());
        result = prime * result + ((getEobt() == null) ? 0 : getEobt().hashCode());
        result = prime * result + ((getEibt() == null) ? 0 : getEibt().hashCode());
        result = prime * result + ((getAobt() == null) ? 0 : getAobt().hashCode());
        result = prime * result + ((getAibt() == null) ? 0 : getAibt().hashCode());
        result = prime * result + ((getEldt() == null) ? 0 : getEldt().hashCode());
        result = prime * result + ((getEtot() == null) ? 0 : getEtot().hashCode());
        result = prime * result + ((getAldt() == null) ? 0 : getAldt().hashCode());
        result = prime * result + ((getAtot() == null) ? 0 : getAtot().hashCode());
        result = prime * result + ((getShareFlno() == null) ? 0 : getShareFlno().hashCode());
        result = prime * result + ((getAdep() == null) ? 0 : getAdep().hashCode());
        result = prime * result + ((getAdes() == null) ? 0 : getAdes().hashCode());
        result = prime * result + ((getStartStation() == null) ? 0 : getStartStation().hashCode());
        result = prime * result + ((getStartSobt() == null) ? 0 : getStartSobt().hashCode());
        result = prime * result + ((getStartSibt() == null) ? 0 : getStartSibt().hashCode());
        result = prime * result + ((getStartEobt() == null) ? 0 : getStartEobt().hashCode());
        result = prime * result + ((getStartEibt() == null) ? 0 : getStartEibt().hashCode());
        result = prime * result + ((getStartAobt() == null) ? 0 : getStartAobt().hashCode());
        result = prime * result + ((getStartAibt() == null) ? 0 : getStartAibt().hashCode());
        result = prime * result + ((getBckOrAlt() == null) ? 0 : getBckOrAlt().hashCode());
        result = prime * result + ((getAltAdes() == null) ? 0 : getAltAdes().hashCode());
        result = prime * result + ((getAltSibt() == null) ? 0 : getAltSibt().hashCode());
        result = prime * result + ((getAltEldt() == null) ? 0 : getAltEldt().hashCode());
        result = prime * result + ((getAltAldt() == null) ? 0 : getAltAldt().hashCode());
        result = prime * result + ((getExit() == null) ? 0 : getExit().hashCode());
        result = prime * result + ((getExot() == null) ? 0 : getExot().hashCode());
        result = prime * result + ((getAxit() == null) ? 0 : getAxit().hashCode());
        result = prime * result + ((getAxot() == null) ? 0 : getAxot().hashCode());
        result = prime * result + ((getDelayTime() == null) ? 0 : getDelayTime().hashCode());
        result = prime * result + ((getStand() == null) ? 0 : getStand().hashCode());
        result = prime * result + ((getGate() == null) ? 0 : getGate().hashCode());
        result = prime * result + ((getCheckStartTime() == null) ? 0 : getCheckStartTime().hashCode());
        result = prime * result + ((getCheckEndTime() == null) ? 0 : getCheckEndTime().hashCode());
        result = prime * result + ((getCobt() == null) ? 0 : getCobt().hashCode());
        result = prime * result + ((getCtot() == null) ? 0 : getCtot().hashCode());
        result = prime * result + ((getTobt() == null) ? 0 : getTobt().hashCode());
        result = prime * result + ((getTtot() == null) ? 0 : getTtot().hashCode());
        result = prime * result + ((getaTobt() == null) ? 0 : getaTobt().hashCode());
        result = prime * result + ((getDobt() == null) ? 0 : getDobt().hashCode());
        result = prime * result + ((getFct() == null) ? 0 : getFct().hashCode());
        result = prime * result + ((getRpot() == null) ? 0 : getRpot().hashCode());
        result = prime * result + ((getApot() == null) ? 0 : getApot().hashCode());
        result = prime * result + ((getAsat() == null) ? 0 : getAsat().hashCode());
        result = prime * result + ((getRunway() == null) ? 0 : getRunway().hashCode());
        result = prime * result + ((getErsl() == null) ? 0 : getErsl().hashCode());
        result = prime * result + ((getArsl() == null) ? 0 : getArsl().hashCode());
        result = prime * result + ((getElsw() == null) ? 0 : getElsw().hashCode());
        result = prime * result + ((getAlsw() == null) ? 0 : getAlsw().hashCode());
        result = prime * result + ((getStdc() == null) ? 0 : getStdc().hashCode());
        result = prime * result + ((getEtdo() == null) ? 0 : getEtdo().hashCode());
        result = prime * result + ((getAtdo() == null) ? 0 : getAtdo().hashCode());
        result = prime * result + ((getEtdc() == null) ? 0 : getEtdc().hashCode());
        result = prime * result + ((getAtdc() == null) ? 0 : getAtdc().hashCode());
        result = prime * result + ((getEtfo() == null) ? 0 : getEtfo().hashCode());
        result = prime * result + ((getAtfo() == null) ? 0 : getAtfo().hashCode());
        result = prime * result + ((getEtfc() == null) ? 0 : getEtfc().hashCode());
        result = prime * result + ((getAtfc() == null) ? 0 : getAtfc().hashCode());
        result = prime * result + ((getEsr() == null) ? 0 : getEsr().hashCode());
        result = prime * result + ((getAsr() == null) ? 0 : getAsr().hashCode());
        result = prime * result + ((getEer() == null) ? 0 : getEer().hashCode());
        result = prime * result + ((getAer() == null) ? 0 : getAer().hashCode());
        result = prime * result + ((getEsc() == null) ? 0 : getEsc().hashCode());
        result = prime * result + ((getAsc() == null) ? 0 : getAsc().hashCode());
        result = prime * result + ((getEec() == null) ? 0 : getEec().hashCode());
        result = prime * result + ((getAec() == null) ? 0 : getAec().hashCode());
        result = prime * result + ((getEsct() == null) ? 0 : getEsct().hashCode());
        result = prime * result + ((getAsct() == null) ? 0 : getAsct().hashCode());
        result = prime * result + ((getEfct() == null) ? 0 : getEfct().hashCode());
        result = prime * result + ((getAfct() == null) ? 0 : getAfct().hashCode());
        result = prime * result + ((getEsbt() == null) ? 0 : getEsbt().hashCode());
        result = prime * result + ((getAsbt() == null) ? 0 : getAsbt().hashCode());
        result = prime * result + ((getLcbt() == null) ? 0 : getLcbt().hashCode());
        result = prime * result + ((getEebt() == null) ? 0 : getEebt().hashCode());
        result = prime * result + ((getAebt() == null) ? 0 : getAebt().hashCode());
        result = prime * result + ((getEcdt() == null) ? 0 : getEcdt().hashCode());
        result = prime * result + ((getAcdt() == null) ? 0 : getAcdt().hashCode());
        result = prime * result + ((getEedt() == null) ? 0 : getEedt().hashCode());
        result = prime * result + ((getAedt() == null) ? 0 : getAedt().hashCode());
        result = prime * result + ((getAact() == null) ? 0 : getAact().hashCode());
        result = prime * result + ((getaGrndTsfTm() == null) ? 0 : getaGrndTsfTm().hashCode());
        result = prime * result + ((getdGrndTsfTm() == null) ? 0 : getdGrndTsfTm().hashCode());
        result = prime * result + ((getMpbt() == null) ? 0 : getMpbt().hashCode());
        result = prime * result + ((getMpet() == null) ? 0 : getMpet().hashCode());
        result = prime * result + ((getLdbt() == null) ? 0 : getLdbt().hashCode());
        result = prime * result + ((getLdet() == null) ? 0 : getLdet().hashCode());
        result = prime * result + ((getTrdt() == null) ? 0 : getTrdt().hashCode());
        result = prime * result + ((getCdpt() == null) ? 0 : getCdpt().hashCode());
        result = prime * result + ((getTerminal() == null) ? 0 : getTerminal().hashCode());
        result = prime * result + ((getBagCount() == null) ? 0 : getBagCount().hashCode());
        result = prime * result + ((getBagWeight() == null) ? 0 : getBagWeight().hashCode());
        result = prime * result + ((getPaxCount() == null) ? 0 : getPaxCount().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getIsspecial() == null) ? 0 : getIsspecial().hashCode());
        result = prime * result + ((getIsmanualid() == null) ? 0 : getIsmanualid().hashCode());
        result = prime * result + ((getIscontrol() == null) ? 0 : getIscontrol().hashCode());
        result = prime * result + ((getIsfocus() == null) ? 0 : getIsfocus().hashCode());
        result = prime * result + ((getRmk() == null) ? 0 : getRmk().hashCode());
        result = prime * result + ((getCreateTm() == null) ? 0 : getCreateTm().hashCode());
        result = prime * result + ((getUpdateTm() == null) ? 0 : getUpdateTm().hashCode());
        result = prime * result + ((getCreateUsr() == null) ? 0 : getCreateUsr().hashCode());
        result = prime * result + ((getUpdateUsr() == null) ? 0 : getUpdateUsr().hashCode());
        result = prime * result + ((getNode1() == null) ? 0 : getNode1().hashCode());
        result = prime * result + ((getNode2() == null) ? 0 : getNode2().hashCode());
        result = prime * result + ((getNode3() == null) ? 0 : getNode3().hashCode());
        result = prime * result + ((getNode4() == null) ? 0 : getNode4().hashCode());
        result = prime * result + ((getNode5() == null) ? 0 : getNode5().hashCode());
        result = prime * result + ((getNode6() == null) ? 0 : getNode6().hashCode());
        result = prime * result + ((getNode7() == null) ? 0 : getNode7().hashCode());
        result = prime * result + ((getNode8() == null) ? 0 : getNode8().hashCode());
        result = prime * result + ((getNode9() == null) ? 0 : getNode9().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", flightId=").append(flightId);
        sb.append(", associatedFlightId=").append(associatedFlightId);
        sb.append(", ffid=").append(ffid);
        sb.append(", airlines=").append(airlines);
        sb.append(", planTime=").append(planTime);
        sb.append(", flno=").append(flno);
        sb.append(", execDate=").append(execDate);
        sb.append(", flightIdentyManageDate=").append(flightIdentyManageDate);
        sb.append(", dOrA=").append(dOrA);
        sb.append(", flightTask=").append(flightTask);
        sb.append(", attribute=").append(attribute);
        sb.append(", takeoffLandinCount=").append(takeoffLandinCount);
        sb.append(", agency=").append(agency);
        sb.append(", craftTypeIcao=").append(craftTypeIcao);
        sb.append(", regn=").append(regn);
        sb.append(", normalFlightStatCd=").append(normalFlightStatCd);
        sb.append(", abnormalFlightStatCd=").append(abnormalFlightStatCd);
        sb.append(", isVip=").append(isVip);
        sb.append(", vipNumber=").append(vipNumber);
        sb.append(", sobt=").append(sobt);
        sb.append(", sibt=").append(sibt);
        sb.append(", eobt=").append(eobt);
        sb.append(", eibt=").append(eibt);
        sb.append(", aobt=").append(aobt);
        sb.append(", aibt=").append(aibt);
        sb.append(", eldt=").append(eldt);
        sb.append(", etot=").append(etot);
        sb.append(", aldt=").append(aldt);
        sb.append(", atot=").append(atot);
        sb.append(", shareFlno=").append(shareFlno);
        sb.append(", adep=").append(adep);
        sb.append(", ades=").append(ades);
        sb.append(", startStation=").append(startStation);
        sb.append(", startSobt=").append(startSobt);
        sb.append(", startSibt=").append(startSibt);
        sb.append(", startEobt=").append(startEobt);
        sb.append(", startEibt=").append(startEibt);
        sb.append(", startAobt=").append(startAobt);
        sb.append(", startAibt=").append(startAibt);
        sb.append(", bckOrAlt=").append(bckOrAlt);
        sb.append(", altAdes=").append(altAdes);
        sb.append(", altSibt=").append(altSibt);
        sb.append(", altEldt=").append(altEldt);
        sb.append(", altAldt=").append(altAldt);
        sb.append(", exit=").append(exit);
        sb.append(", exot=").append(exot);
        sb.append(", axit=").append(axit);
        sb.append(", axot=").append(axot);
        sb.append(", delayTime=").append(delayTime);
        sb.append(", stand=").append(stand);
        sb.append(", gate=").append(gate);
        sb.append(", checkStartTime=").append(checkStartTime);
        sb.append(", checkEndTime=").append(checkEndTime);
        sb.append(", cobt=").append(cobt);
        sb.append(", ctot=").append(ctot);
        sb.append(", tobt=").append(tobt);
        sb.append(", ttot=").append(ttot);
        sb.append(", aTobt=").append(aTobt);
        sb.append(", dobt=").append(dobt);
        sb.append(", fct=").append(fct);
        sb.append(", rpot=").append(rpot);
        sb.append(", apot=").append(apot);
        sb.append(", asat=").append(asat);
        sb.append(", runway=").append(runway);
        sb.append(", ersl=").append(ersl);
        sb.append(", arsl=").append(arsl);
        sb.append(", elsw=").append(elsw);
        sb.append(", alsw=").append(alsw);
        sb.append(", stdc=").append(stdc);
        sb.append(", etdo=").append(etdo);
        sb.append(", atdo=").append(atdo);
        sb.append(", etdc=").append(etdc);
        sb.append(", atdc=").append(atdc);
        sb.append(", etfo=").append(etfo);
        sb.append(", atfo=").append(atfo);
        sb.append(", etfc=").append(etfc);
        sb.append(", atfc=").append(atfc);
        sb.append(", esr=").append(esr);
        sb.append(", asr=").append(asr);
        sb.append(", eer=").append(eer);
        sb.append(", aer=").append(aer);
        sb.append(", esc=").append(esc);
        sb.append(", asc=").append(asc);
        sb.append(", eec=").append(eec);
        sb.append(", aec=").append(aec);
        sb.append(", esct=").append(esct);
        sb.append(", asct=").append(asct);
        sb.append(", efct=").append(efct);
        sb.append(", afct=").append(afct);
        sb.append(", esbt=").append(esbt);
        sb.append(", asbt=").append(asbt);
        sb.append(", lcbt=").append(lcbt);
        sb.append(", eebt=").append(eebt);
        sb.append(", aebt=").append(aebt);
        sb.append(", ecdt=").append(ecdt);
        sb.append(", acdt=").append(acdt);
        sb.append(", eedt=").append(eedt);
        sb.append(", aedt=").append(aedt);
        sb.append(", aact=").append(aact);
        sb.append(", aGrndTsfTm=").append(aGrndTsfTm);
        sb.append(", dGrndTsfTm=").append(dGrndTsfTm);
        sb.append(", mpbt=").append(mpbt);
        sb.append(", mpet=").append(mpet);
        sb.append(", ldbt=").append(ldbt);
        sb.append(", ldet=").append(ldet);
        sb.append(", trdt=").append(trdt);
        sb.append(", cdpt=").append(cdpt);
        sb.append(", terminal=").append(terminal);
        sb.append(", bagCount=").append(bagCount);
        sb.append(", bagWeight=").append(bagWeight);
        sb.append(", paxCount=").append(paxCount);
        sb.append(", isdel=").append(isdel);
        sb.append(", isspecial=").append(isspecial);
        sb.append(", ismanualid=").append(ismanualid);
        sb.append(", iscontrol=").append(iscontrol);
        sb.append(", isfocus=").append(isfocus);
        sb.append(", rmk=").append(rmk);
        sb.append(", createTm=").append(createTm);
        sb.append(", updateTm=").append(updateTm);
        sb.append(", createUsr=").append(createUsr);
        sb.append(", updateUsr=").append(updateUsr);
        sb.append(", node1=").append(node1);
        sb.append(", node2=").append(node2);
        sb.append(", node3=").append(node3);
        sb.append(", node4=").append(node4);
        sb.append(", node5=").append(node5);
        sb.append(", node6=").append(node6);
        sb.append(", node7=").append(node7);
        sb.append(", node8=").append(node8);
        sb.append(", node9=").append(node9);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}