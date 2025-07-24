package com.hq.acdm.vo.dynamicFlight;

import com.hq.acdm.util.DateTimeUtil;

import java.util.List;

public class FlightDetailsInfoVo {

    private String 	flightIdD;
    private String 	flightIdA;
    private String 	airlines;
    private String 	flnoD;
    private String 	flnoA;
    private String 	exec_dateD;
    private String 	exec_dateA;
    private String 	flightIdentyManageDate;
    private String 	flightTask;
    private String 	attribute;
    private String 	agency;
    private String 	craftTypeIcao;
    private String 	classification;
    private String 	regn;
    private String 	flStatus;
    private String 	flStatusA;
    private String 	sobt;
    private String 	etot;
    private String 	atot;
    private String 	sobtA;
    private String 	etotA;
    private String 	atotA;
    private String 	sibt;
    private String 	eldt;
    private String 	aldt;
    private String 	sibtD;
    private String 	eldtD;
    private String 	aldtD;
    private String 	eibt;
    private String 	aibt;
    private String 	eobt;
    private String 	aobt;
    private String 	shareFlno;
    private String 	adepA;
    private String 	adesA;
    private String 	adepD;
    private String 	adesD;
    private String 	startStation;
    private String 	startSobt;
    private String 	startSibt;
    private String 	startEobt;
    private String 	startEibt;
    private String 	startAobt;
    private String 	startAibt;
    private String 	exit;
    private String 	exot;
    private String 	axit;
    private String 	axot;
    private String 	standA;
    private String 	standD;
    private String 	gate;
    private String 	checkStartTime;
    private String 	checkEndTime;
    private String 	cobt;
    private String 	ctot;
    private String 	tobt;
    private String 	ttot;
    private String 	aTobt;
    private String 	dobt;
    private String 	fct;
    private String 	rpot;
    private String 	apot;
    private String 	asat;
    private String 	runwayA;
    private String 	runwayD;
    private String 	ersl;
    private String 	elsw;
    private String 	arsl;
    private String 	alsw;
    private String 	etdo;
    private String 	etdc;
    private String 	atdo;
    private String 	atdc;
    private String 	etfo;
    private String 	etfc;
    private String 	atfo;
    private String 	atfc;
    private String 	esct;
    private String 	efct;
    private String 	asct;
    private String 	afct;
    private String 	esc;
    private String 	eec;
    private String 	asc;
    private String 	aec;
    private String 	esr;
    private String 	eer;
    private String 	asr;
    private String 	aer;
    private String 	esbt;
    private String 	eebt;
    private String 	lcbt;
    private String 	asbt;
    private String 	aebt;
    private String 	ecdt;
    private String 	acdt;
    private String 	eedt;
    private String 	aedt;
    private String 	aact;
    private String 	aGrndTsfTm;
    private String 	dGrndTsfTm;
    private String 	terminal;
    private String 	bagCount;
    private String 	bagCountA;
    private String 	bagWeight;
    private String 	bagWeightA;
    private String 	paxCount;
    private String  checkIn;
    private String  securityCheck;
    private String  overStation;
    private String  boarding;
    private String planOverStatTm;
    private String usedTime;
    private String remainTime;
    private List<FlowControlVo> flowControlList;
    private String isdeicing;
    private String cargoWeightA;
    private String cargoWeightD;
    private String mailWeightA;
    private String mailWeightD;
    private String reservationsA;
    private String reservationsD;
    private String reasonsForAuto;
    private String isfocusA;
    private String isfocusD;

    private int  jgxlzs;//行李流程进港行李总数
    private int  xj;//卸机总数
    private String xjs;//卸机开始
    private String xjend;//卸机结束
    private int  dd;//到达
    private String dds;//到达开始
    private String ddend;//到达结束
    private int  zj;//值机
    private String zjs;//值机开始
    private String zjend;//值机结束
    private int  aj;//安检
    private String ajs;//安检开始
    private String ajend;//安检结束
    private int   fj;//分拣
    private String fjs;//分拣开始
    private String fjend;//分拣结束
    private int   zc;//装车
    private String zcs;//装车开始
    private String zcend;//装车结束
    private int  zji;//装机
    private String zjis;//装机开始
    private String zjiend;//装机结束

    private int  zjLK;//旅客值机总数,安检总数,侯机总数,登机总数
    private String zjLKS;//旅客值机开始
    private String zjLKEND;//旅客值机结束
    private int  ajLK;//旅客安检数
    private String ajLKS;//旅客安检开始
    private String ajLKEND;//旅客安检结束
    private int   hj;//旅客侯机数
    private String hjS;//旅客侯机开始
    private String hjEND;//旅客侯机结束
    private int   dj;//旅客登机数
    private String djS;//旅客登机开始
    private String djEND;//旅客登机结束

    private int   hjVIP;//旅客侯机VIP数
    private int   hj2c;//旅客侯机2舱休息室数

    public int getZjLK() {
        return zjLK;
    }

    public String getZjLKS() {
        return zjLKS;
    }

    public String getZjLKEND() {
        return zjLKEND;
    }

    public int getAjLK() {
        return ajLK;
    }

    public String getAjLKS() {
        return ajLKS;
    }

    public String getAjLKEND() {
        return ajLKEND;
    }

    public int getHj() {
        return hj;
    }

    public String getHjS() {
        return hjS;
    }

    public String getHjEND() {
        return hjEND;
    }

    public int getDj() {
        return dj;
    }

    public String getDjS() {
        return djS;
    }

    public String getDjEND() {
        return djEND;
    }

    public int getHjVIP() {
        return hjVIP;
    }

    public int getHj2c() {
        return hj2c;
    }

    public void setZjLK(int zjLK) {
        this.zjLK = zjLK;
    }

    public void setZjLKS(String zjLKS) {
        this.zjLKS = zjLKS;
    }

    public void setZjLKEND(String zjLKEND) {
        this.zjLKEND = zjLKEND;
    }

    public void setAjLK(int ajLK) {
        this.ajLK = ajLK;
    }

    public void setAjLKS(String ajLKS) {
        this.ajLKS = ajLKS;
    }

    public void setAjLKEND(String ajLKEND) {
        this.ajLKEND = ajLKEND;
    }

    public void setHj(int hj) {
        this.hj = hj;
    }

    public void setHjS(String hjS) {
        this.hjS = hjS;
    }

    public void setHjEND(String hjEND) {
        this.hjEND = hjEND;
    }

    public void setDj(int dj) {
        this.dj = dj;
    }

    public void setDjS(String djS) {
        this.djS = djS;
    }

    public void setDjEND(String djEND) {
        this.djEND = djEND;
    }

    public void setHjVIP(int hjVIP) {
        this.hjVIP = hjVIP;
    }

    public void setHj2c(int hj2c) {
        this.hj2c = hj2c;
    }

    public String getBagCountA() {
        return bagCountA;
    }

    public int getJgxlzs() {
        return jgxlzs;
    }

    public void setBagCountA(String bagCountA) {
        this.bagCountA = bagCountA;
    }

    public void setJgxlzs(int jgxlzs) {
        this.jgxlzs = jgxlzs;
    }

    public int getXj() {
        return xj;
    }

    public String getXjs() {
        return xjs;
    }

    public String getXjend() {
        return xjend;
    }

    public int getDd() {
        return dd;
    }

    public String getDds() {
        return dds;
    }

    public String getDdend() {
        return ddend;
    }

    public int getZj() {
        return zj;
    }

    public String getZjs() {
        return zjs;
    }

    public String getZjend() {
        return zjend;
    }

    public int getAj() {
        return aj;
    }

    public String getAjs() {
        return ajs;
    }

    public String getAjend() {
        return ajend;
    }

    public int getFj() {
        return fj;
    }

    public String getFjs() {
        return fjs;
    }

    public String getFjend() {
        return fjend;
    }

    public int getZc() {
        return zc;
    }

    public String getZcs() {
        return zcs;
    }

    public String getZcend() {
        return zcend;
    }

    public int getZji() {
        return zji;
    }

    public String getZjis() {
        return zjis;
    }

    public String getZjiend() {
        return zjiend;
    }

    public void setXj(int xj) {
        this.xj = xj;
    }

    public void setXjs(String xjs) {
        this.xjs = xjs;
    }

    public void setXjend(String xjend) {
        this.xjend = xjend;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public void setDds(String dds) {
        this.dds = dds;
    }

    public void setDdend(String ddend) {
        this.ddend = ddend;
    }

    public void setZj(int zj) {
        this.zj = zj;
    }

    public void setZjs(String zjs) {
        this.zjs = zjs;
    }

    public void setZjend(String zjend) {
        this.zjend = zjend;
    }

    public void setAj(int aj) {
        this.aj = aj;
    }

    public void setAjs(String ajs) {
        this.ajs = ajs;
    }

    public void setAjend(String ajend) {
        this.ajend = ajend;
    }

    public void setFj(int fj) {
        this.fj = fj;
    }

    public void setFjs(String fjs) {
        this.fjs = fjs;
    }

    public void setFjend(String fjend) {
        this.fjend = fjend;
    }

    public void setZc(int zc) {
        this.zc = zc;
    }

    public void setZcs(String zcs) {
        this.zcs = zcs;
    }

    public void setZcend(String zcend) {
        this.zcend = zcend;
    }

    public void setZji(int zji) {
        this.zji = zji;
    }

    public void setZjis(String zjis) {
        this.zjis = zjis;
    }

    public void setZjiend(String zjiend) {
        this.zjiend = zjiend;
    }

    public String getFlightIdD() {
        return flightIdD;
    }

    public void setFlightIdD(String flightIdD) {
        this.flightIdD = flightIdD;
    }

    public String getFlightIdA() {
        return flightIdA;
    }

    public void setFlightIdA(String flightIdA) {
        this.flightIdA = flightIdA;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public String getFlnoD() {
        return flnoD;
    }

    public void setFlnoD(String flnoD) {
        this.flnoD = flnoD;
    }

    public String getFlnoA() {
        return flnoA;
    }

    public void setFlnoA(String flnoA) {
        this.flnoA = flnoA;
    }

    public String getExec_dateD() {
        return exec_dateD;
    }

    public void setExec_dateD(String exec_dateD) {
        this.exec_dateD = exec_dateD;
    }

    public String getExec_dateA() {
        return exec_dateA;
    }

    public void setExec_dateA(String exec_dateA) {
        this.exec_dateA = exec_dateA;
    }

    public String getFlightIdentyManageDate() {
        return flightIdentyManageDate;
    }

    public void setFlightIdentyManageDate(String flightIdentyManageDate) {
        this.flightIdentyManageDate = flightIdentyManageDate;
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

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
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

    public String getFlStatus() {
        return flStatus;
    }

    public void setFlStatus(String flStatus) {
        this.flStatus = flStatus;
    }

    public String getSobt() {
        return sobt;
    }

    public void setSobt(String sobt) {
        this.sobt = DateTimeUtil.timeDayFormatByStr(sobt);
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

    public String getShareFlno() {
        return shareFlno;
    }

    public void setShareFlno(String shareFlno) {
        this.shareFlno = shareFlno;
    }

    public String getAdepA() {
        return adepA;
    }

    public void setAdepA(String adepA) {
        this.adepA = adepA;
    }

    public String getAdesA() {
        return adesA;
    }

    public void setAdesA(String adesA) {
        this.adesA = adesA;
    }

    public String getAdepD() {
        return adepD;
    }

    public void setAdepD(String adepD) {
        this.adepD = adepD;
    }

    public String getAdesD() {
        return adesD;
    }

    public void setAdesD(String adesD) {
        this.adesD = adesD;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getStartSobt() {
        return startSobt;
    }

    public void setStartSobt(String startSobt) {
        this.startSobt = DateTimeUtil.timeDayFormatByStr(startSobt);
    }

    public String getStartSibt() {
        return startSibt;
    }

    public void setStartSibt(String startSibt) {
        this.startSibt = DateTimeUtil.timeDayFormatByStr(startSibt);
    }

    public String getStartEobt() {
        return startEobt;
    }

    public void setStartEobt(String startEobt) {
        this.startEobt = DateTimeUtil.timeDayFormatByStr(startEobt);
    }

    public String getStartEibt() {
        return startEibt;
    }

    public void setStartEibt(String startEibt) {
        this.startEibt = DateTimeUtil.timeDayFormatByStr(startEibt);
    }

    public String getStartAobt() {
        return startAobt;
    }

    public void setStartAobt(String startAobt) {
        this.startAobt = DateTimeUtil.timeDayFormatByStr(startAobt);
    }

    public String getStartAibt() {
        return startAibt;
    }

    public void setStartAibt(String startAibt) {
        this.startAibt = DateTimeUtil.timeDayFormatByStr(startAibt);
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = DateTimeUtil.timeDayFormatByStr(exit);
    }

    public String getExot() {
        return exot;
    }

    public void setExot(String exot) {
        this.exot = DateTimeUtil.timeDayFormatByStr(exot);
    }

    public String getAxit() {
        return axit;
    }

    public void setAxit(String axit) {
        this.axit = axit;
    }

    public String getAxot() {
        return axot;
    }

    public void setAxot(String axot) {
        this.axot = axot;
    }

    public String getStandA() {
        return standA;
    }

    public void setStandA(String standA) {
        this.standA = standA;
    }

    public String getStandD() {
        return standD;
    }

    public void setStandD(String standD) {
        this.standD = standD;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getCheckStartTime() {
        return checkStartTime;
    }

    public void setCheckStartTime(String checkStartTime) {
        this.checkStartTime = DateTimeUtil.timeDayFormatByStr(checkStartTime);
    }

    public String getCheckEndTime() {
        return checkEndTime;
    }

    public void setCheckEndTime(String checkEndTime) {
        this.checkEndTime = DateTimeUtil.timeDayFormatByStr(checkEndTime);
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

    public String getTtot() {
        return ttot;
    }

    public void setTtot(String ttot) {
        this.ttot = DateTimeUtil.timeDayFormatByStr(ttot);
    }

    public String getaTobt() {
        return aTobt;
    }

    public void setaTobt(String aTobt) {
        this.aTobt = DateTimeUtil.timeDayFormatByStr(aTobt);
    }

    public String getDobt() {
        return dobt;
    }

    public void setDobt(String dobt) {
        this.dobt = DateTimeUtil.timeDayFormatByStr(dobt);
    }

    public String getFct() {
        return fct;
    }

    public void setFct(String fct) {
        this.fct = DateTimeUtil.timeDayFormatByStr(fct);
    }

    public String getRpot() {
        return rpot;
    }

    public void setRpot(String rpot) {
        this.rpot = DateTimeUtil.timeDayFormatByStr(rpot);
    }

    public String getApot() {
        return apot;
    }

    public void setApot(String apot) {
        this.apot = DateTimeUtil.timeDayFormatByStr(apot);
    }

    public String getAsat() {
        return asat;
    }

    public void setAsat(String asat) {
        this.asat = DateTimeUtil.timeDayFormatByStr(asat);
    }

    public String getRunwayA() {
        return runwayA;
    }

    public void setRunwayA(String runwayA) {
        this.runwayA = runwayA;
    }

    public String getRunwayD() {
        return runwayD;
    }

    public void setRunwayD(String runwayD) {
        this.runwayD = runwayD;
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

    public String getLcbt() {
        return lcbt;
    }

    public void setLcbt(String lcbt) {
        this.lcbt = DateTimeUtil.timeDayFormatByStr(lcbt);
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

    public String getEcdt() {
        return ecdt;
    }

    public void setEcdt(String ecdt) {
        this.ecdt = DateTimeUtil.timeDayFormatByStr(ecdt);
    }

    public String getAcdt() {
        return acdt;
    }

    public void setAcdt(String acdt) {
        this.acdt = DateTimeUtil.timeDayFormatByStr(acdt);
    }

    public String getEedt() {
        return eedt;
    }

    public void setEedt(String eedt) {
        this.eedt = DateTimeUtil.timeDayFormatByStr(eedt);
    }

    public String getAedt() {
        return aedt;
    }

    public void setAedt(String aedt) {
        this.aedt = DateTimeUtil.timeDayFormatByStr(aedt);
    }

    public String getAact() {
        return aact;
    }

    public void setAact(String aact) {
        this.aact = DateTimeUtil.timeDayFormatByStr(aact);
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

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getBagCount() {
        return bagCount;
    }

    public void setBagCount(String bagCount) {
        this.bagCount = bagCount;
    }

    public String getBagWeight() {
        return bagWeight;
    }

    public void setBagWeight(String bagWeight) {
        this.bagWeight = bagWeight;
    }

    public String getPaxCount() {
        return paxCount;
    }

    public void setPaxCount(String paxCount) {
        this.paxCount = paxCount;
    }

    public String getSobtA() {
        return sobtA;
    }

    public void setSobtA(String sobtA) {
        this.sobtA = DateTimeUtil.timeDayFormatByStr(sobtA);
    }

    public String getEtotA() {
        return etotA;
    }

    public void setEtotA(String etotA) {
        this.etotA = DateTimeUtil.timeDayFormatByStr(etotA);
    }

    public String getAtotA() {
        return atotA;
    }

    public void setAtotA(String atotA) {
        this.atotA = DateTimeUtil.timeDayFormatByStr(atotA);
    }

    public String getSibtD() {
        return sibtD;
    }

    public void setSibtD(String sibtD) {
        this.sibtD = DateTimeUtil.timeDayFormatByStr(sibtD);
    }

    public String getEldtD() {
        return eldtD;
    }

    public void setEldtD(String eldtD) {
        this.eldtD = DateTimeUtil.timeDayFormatByStr(eldtD);
    }

    public String getAldtD() {
        return aldtD;
    }

    public void setAldtD(String aldtD) {
        this.aldtD = DateTimeUtil.timeDayFormatByStr(aldtD);
    }

    public String getFlStatusA() {
        return flStatusA;
    }

    public void setFlStatusA(String flStatusA) {
        this.flStatusA = flStatusA;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getSecurityCheck() {
        return securityCheck;
    }

    public void setSecurityCheck(String securityCheck) {
        this.securityCheck = securityCheck;
    }

    public String getOverStation() {
        return overStation;
    }

    public void setOverStation(String overStation) {
        this.overStation = overStation;
    }

    public String getBoarding() {
        return boarding;
    }

    public void setBoarding(String boarding) {
        this.boarding = boarding;
    }

    public String getPlanOverStatTm() {
        return planOverStatTm;
    }

    public void setPlanOverStatTm(String planOverStatTm) {
        this.planOverStatTm = DateTimeUtil.timeDayFormatByStr(planOverStatTm);
    }

    public String getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(String usedTime) {
        this.usedTime = usedTime;
    }

    public String getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(String remainTime) {
        this.remainTime = remainTime;
    }

    public List<FlowControlVo> getFlowControlList() {
        return flowControlList;
    }

    public void setFlowControlList(List<FlowControlVo> flowControlList) {
        this.flowControlList = flowControlList;
    }

    public String getIsdeicing() {
        return isdeicing;
    }

    public void setIsdeicing(String isdeicing) {
        this.isdeicing = isdeicing;
    }

    public String getCargoWeightA() {
        return cargoWeightA;
    }

    public void setCargoWeightA(String cargoWeightA) {
        this.cargoWeightA = cargoWeightA;
    }

    public String getCargoWeightD() {
        return cargoWeightD;
    }

    public void setCargoWeightD(String cargoWeightD) {
        this.cargoWeightD = cargoWeightD;
    }

    public String getMailWeightA() {
        return mailWeightA;
    }

    public void setMailWeightA(String mailWeightA) {
        this.mailWeightA = mailWeightA;
    }

    public String getMailWeightD() {
        return mailWeightD;
    }

    public void setMailWeightD(String mailWeightD) {
        this.mailWeightD = mailWeightD;
    }

    public String getReservationsA() {
        return reservationsA;
    }

    public void setReservationsA(String reservationsA) {
        this.reservationsA = reservationsA;
    }

    public String getReservationsD() {
        return reservationsD;
    }

    public void setReservationsD(String reservationsD) {
        this.reservationsD = reservationsD;
    }

    public String getBagWeightA() {
        return bagWeightA;
    }

    public void setBagWeightA(String bagWeightA) {
        this.bagWeightA = bagWeightA;
    }

    public String getReasonsForAuto() {
        return reasonsForAuto;
    }

    public void setReasonsForAuto(String reasonsForAuto) {
        this.reasonsForAuto = reasonsForAuto;
    }

    public String getIsfocusA() {
        return isfocusA;
    }

    public void setIsfocusA(String isfocusA) {
        this.isfocusA = isfocusA;
    }

    public String getIsfocusD() {
        return isfocusD;
    }

    public void setIsfocusD(String isfocusD) {
        this.isfocusD = isfocusD;
    }
}
