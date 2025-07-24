package com.hq.acdm.vo.rscMonitors;

import com.hq.acdm.util.DateTimeUtil;

/**
 * @author LiFaQiang
 * @date 2019/06/24 12:29
 * @Description
 */

public class DeicingOverVo {

    private String flightId;
    private String flno;
    private String stand;
    private String aedt;
    private String cobt;
    private String tobt;
    private String deicingFluid;
    private String deicingCar;
    private String jetLag;

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

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public String getAedt() {
        return aedt;
    }

    public void setAedt(String aedt) {
        this.aedt = DateTimeUtil.timeDayFormatByStr(aedt);
    }

    public String getCobt() {
        return cobt;
    }

    public void setCobt(String cobt) {
        this.cobt = DateTimeUtil.timeDayFormatByStr(cobt);
    }

    public String getTobt() {
        return tobt;
    }

    public void setTobt(String tobt) {
        this.tobt = DateTimeUtil.timeDayFormatByStr(tobt);
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

    public String getJetLag() {
        return jetLag;
    }

    public void setJetLag(String jetLag) {
        this.jetLag = jetLag;
    }
}
