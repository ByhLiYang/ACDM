package com.hq.acdm.vo.rscMonitors;

import com.hq.acdm.util.DateTimeUtil;

/**
 * @author LiFaQiang
 * @date 2019/06/24 12:29
 * @Description
 */

public class DeicingNowVo {

    private String flightId;
    private String flno;
    private String deicingWay;
    private String acdt;
    private String eedt;
    private String tobt;
    private String fxlj;
    private String deicingFluid;
    private String deicingCar;

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

    public String getDeicingWay() {
        return deicingWay;
    }

    public void setDeicingWay(String deicingWay) {
        this.deicingWay = deicingWay;
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

    public String getTobt() {
        return tobt;
    }

    public void setTobt(String tobt) {
        this.tobt = DateTimeUtil.timeDayFormatByStr(tobt);
    }

    public String getFxlj() {
        return fxlj;
    }

    public void setFxlj(String fxlj) {
        this.fxlj = DateTimeUtil.timeDayFormatByStr(fxlj);
    }

    public String getDeicingFluid() {
        return deicingFluid;
    }

    public void setDeicingFluid(String deicingFluid) {
        this.deicingFluid = deicingFluid;
    }

    public String getDeicingCar() {
        return deicingCar;
    }

    public void setDeicingCar(String deicingCar) {
        this.deicingCar = deicingCar;
    }
}
