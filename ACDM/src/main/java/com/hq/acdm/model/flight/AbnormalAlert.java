package com.hq.acdm.model.flight;

public class AbnormalAlert {
    private String flightNoIata; //航班号
    private String gate1OpenDateTime;
    private String gate2OpenDateTime;
    private String gate3OpenDateTime;
    private String openDateTime; //开始登机时间
    private String belt1;
    private String belt2;
    private String belt3;
    private String belt; // 登机门
    private String gate1CloseDateTime;
    private String gate2CloseDateTime;
    private String gate3CloseDateTime;
    private String gateCloseDateTime; //登机结束时间
    private String aobt;
    private String atot;
    private String sobt;
    private String operationalDate;
    private String aOrD;
    private String flightRepeatCount;
    private String chkcnt;
    private String boarcnt;
    private String secucnt;
    private String reason;
    private String rate;

    public String getOpenDateTime() {
        return openDateTime;
    }

    public void setOpenDateTime(String openDateTime) {
        this.openDateTime = openDateTime;
    }

    public String getFlightNoIata() {
        return flightNoIata;
    }

    public void setFlightNoIata(String flightNoIata) {
        this.flightNoIata = flightNoIata;
    }

    public String getGate1OpenDateTime() {
        return gate1OpenDateTime;
    }

    public void setGate1OpenDateTime(String gate1OpenDateTime) {
        this.gate1OpenDateTime = gate1OpenDateTime;
    }

    public String getGate2OpenDateTime() {
        return gate2OpenDateTime;
    }

    public void setGate2OpenDateTime(String gate2OpenDateTime) {
        this.gate2OpenDateTime = gate2OpenDateTime;
    }

    public String getGate3OpenDateTime() {
        return gate3OpenDateTime;
    }

    public void setGate3OpenDateTime(String gate3OpenDateTime) {
        this.gate3OpenDateTime = gate3OpenDateTime;
    }

    public String getBelt1() {
        return belt1;
    }

    public void setBelt1(String belt1) {
        this.belt1 = belt1;
    }

    public String getBelt2() {
        return belt2;
    }

    public void setBelt2(String belt2) {
        this.belt2 = belt2;
    }

    public String getBelt3() {
        return belt3;
    }

    public void setBelt3(String belt3) {
        this.belt3 = belt3;
    }

    public String getBelt() {
        return belt;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    public String getGate1CloseDateTime() {
        return gate1CloseDateTime;
    }

    public void setGate1CloseDateTime(String gate1CloseDateTime) {
        this.gate1CloseDateTime = gate1CloseDateTime;
    }

    public String getGate2CloseDateTime() {
        return gate2CloseDateTime;
    }

    public void setGate2CloseDateTime(String gate2CloseDateTime) {
        this.gate2CloseDateTime = gate2CloseDateTime;
    }

    public String getGate3CloseDateTime() {
        return gate3CloseDateTime;
    }

    public void setGate3CloseDateTime(String gate3CloseDateTime) {
        this.gate3CloseDateTime = gate3CloseDateTime;
    }

    public String getGateCloseDateTime() {
        return gateCloseDateTime;
    }

    public void setGateCloseDateTime(String gateCloseDateTime) {
        this.gateCloseDateTime = gateCloseDateTime;
    }

    public String getAobt() {
        return aobt;
    }

    public void setAobt(String aobt) {
        this.aobt = aobt;
    }

    public String getAtot() {
        return atot;
    }

    public void setAtot(String atot) {
        this.atot = atot;
    }

    public String getSobt() {
        return sobt;
    }

    public void setSobt(String sobt) {
        this.sobt = sobt;
    }

    public String getOperationalDate() {
        return operationalDate;
    }

    public void setOperationalDate(String operationalDate) {
        this.operationalDate = operationalDate;
    }

    public String getaOrD() {
        return aOrD;
    }

    public void setaOrD(String aOrD) {
        this.aOrD = aOrD;
    }

    public String getFlightRepeatCount() {
        return flightRepeatCount;
    }

    public void setFlightRepeatCount(String flightRepeatCount) {
        this.flightRepeatCount = flightRepeatCount;
    }

    public String getChkcnt() {
        return chkcnt;
    }

    public void setChkcnt(String chkcnt) {
        this.chkcnt = chkcnt;
    }

    public String getBoarcnt() {
        return boarcnt;
    }

    public void setBoarcnt(String boarcnt) {
        this.boarcnt = boarcnt;
    }

    public String getSecucnt() {
        return secucnt;
    }

    public void setSecucnt(String secucnt) {
        this.secucnt = secucnt;
    }

    public String getReason() {
        return reason;
    }
    public String getRate() {
       int boarcnt1=Integer.parseInt(this.boarcnt);
        int chkcnt1=Integer.parseInt(this.chkcnt);
        int f=(boarcnt1*100)/chkcnt1;
      //  System.out.println("----------boarcnt1:"+boarcnt1+"-------chkcnt1:"+chkcnt1+"- rate:"+f);
        return String.valueOf(f);

    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
