package com.hq.acdm.vo.dynamicFlight;

import com.hq.acdm.util.DateTimeUtil;
import lombok.Getter;

@Getter
public class CriticalFltRlsVo {

    private String flightId;
    private String task;
    private String flno;
    private String sobt;
    private String ywlj;
    private String fxlj;
    private String ddsc;
    private String atdc;
    private String aobt;
    private String status;
    private String ctot;
    private String ctotStatus;
    private String ttot;
    private String isfocus;
    private String asbt;
    private String aebt;
    private String tobt;
    private String state;
    private String trdtStatus;
    private String stand;
    private String tyStatus;

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setFlno(String flno) {
        this.flno = flno;
    }

    public void setSobt(String sobt) {
        this.sobt = DateTimeUtil.timeDayFormatByStr(sobt);
    }

    public void setYwlj(String ywlj) {
        this.ywlj = DateTimeUtil.timeDayFormatByStr(ywlj);
    }

    public void setFxlj(String fxlj) {
        this.fxlj = DateTimeUtil.timeDayFormatByStr(fxlj);
    }

    public void setDdsc(String ddsc) {
        this.ddsc = ddsc;
    }

    public void setAtdc(String atdc) {
        this.atdc = DateTimeUtil.timeDayFormatByStr(atdc);
    }

    public void setAobt(String aobt) {
        this.aobt = DateTimeUtil.timeDayFormatByStr(aobt);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCtot(String ctot) { this.ctot = DateTimeUtil.timeDayFormatByStr(ctot); }

    public void setCtotStatus(String ctotStatus) { this.ctotStatus = ctotStatus; }

    public void setTtot(String ttot) {
        this.ttot = DateTimeUtil.timeDayFormatByStr(ttot);
    }

    public void setIsfocus(String isfocus) {
        this.isfocus = isfocus;
    }

    public void setAsbt(String asbt) {
        this.asbt = DateTimeUtil.timeDayFormatByStr(asbt);
    }

    public void setAebt(String aebt) {
        this.aebt = DateTimeUtil.timeDayFormatByStr(aebt);
    }

    public void setTobt(String tobt) { this.tobt = DateTimeUtil.timeDayFormatByStr(tobt); }

    public void setState(String state) {
        this.state = state;
    }

    public void setTrdtStatus(String trdtStatus) { this.trdtStatus = trdtStatus; }

    public String getStand() { return stand; }

    public void setStand(String stand) { this.stand = stand; }

    public String getTyStatus() { return tyStatus; }

    public void setTyStatus(String tyStatus) { this.tyStatus = tyStatus; }
}
