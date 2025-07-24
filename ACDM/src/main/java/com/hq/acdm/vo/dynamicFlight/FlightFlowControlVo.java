package com.hq.acdm.vo.dynamicFlight;

import com.hq.acdm.util.DateTimeUtil;

public class FlightFlowControlVo {

    private String flightId;
    private String flno;
    private String ades;
    private String sobt;
    private String tobt;
    private String ctot;

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

    public String getAdes() {
        return ades;
    }

    public void setAdes(String ades) {
        this.ades = ades;
    }

    public String getSobt() {
        return sobt;
    }

    public void setSobt(String sobt) {
        this.sobt = DateTimeUtil.timeDayFormatByStr(sobt);
    }

    public String getTobt() {
        return tobt;
    }

    public void setTobt(String tobt) {
        this.tobt = DateTimeUtil.timeDayFormatByStr(tobt);
    }

    public String getCtot() {
        return ctot;
    }

    public void setCtot(String ctot) {
        this.ctot = DateTimeUtil.timeDayFormatByStr(ctot);
    }
}
