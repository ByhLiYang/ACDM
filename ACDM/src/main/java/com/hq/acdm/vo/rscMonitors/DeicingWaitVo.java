package com.hq.acdm.vo.rscMonitors;

import com.hq.acdm.util.DateTimeUtil;
import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2019/06/24 12:29
 * @Description
 */

public class DeicingWaitVo {

    private String flightId;
    private String flno;
    private String stand;
    private String ecdt;
    private String ecdts;
    private String eedt;
    private String state;
    private String tobt;
    private String deicingFluid;
    private String deicingCar;

    public String getEcdts() {
        return ecdts;
    }

    public void setEcdts(String ecdts) {
        this.ecdts = ecdts;
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

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public String getEcdt() {
        return ecdt;
    }

    public void setEcdt(String ecdt) {
        this.ecdt = DateTimeUtil.timeDayFormatByStr(ecdt);
    }

    public String getEedt() {
        return eedt;
    }

    public void setEedt(String eedt) {
        this.eedt = DateTimeUtil.timeDayFormatByStr(eedt);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
}
