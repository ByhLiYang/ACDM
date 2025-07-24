package com.hq.acdm.vo.coordinatedOprt;


import com.hq.acdm.util.DateTimeUtil;

public class FlightWightInfoUpdVo {

    private String flightIdA;
    private String flightIdD;
    private String flnoA;
    private String flnoD;
    private String adepAdesA;
    private String adepAdesD;
    private String sibt;
    private String sobt;
    private String cargoWeightA;
    private String cargoWeightD;
    private String mailWeightA;
    private String mailWeightD;
    private String bagWeightA;
    private String bagWeightD;
    private String reservationsA;
    private String reservationsD;

    public String getFlightIdA() {
        return flightIdA;
    }

    public void setFlightIdA(String flightIdA) {
        this.flightIdA = flightIdA;
    }

    public String getFlightIdD() {
        return flightIdD;
    }

    public void setFlightIdD(String flightIdD) {
        this.flightIdD = flightIdD;
    }

    public String getFlnoA() {
        return flnoA;
    }

    public void setFlnoA(String flnoA) {
        this.flnoA = flnoA;
    }

    public String getFlnoD() {
        return flnoD;
    }

    public void setFlnoD(String flnoD) {
        this.flnoD = flnoD;
    }

    public String getAdepAdesA() {
        return adepAdesA;
    }

    public void setAdepAdesA(String adepAdesA) {
        this.adepAdesA = adepAdesA;
    }

    public String getAdepAdesD() {
        return adepAdesD;
    }

    public void setAdepAdesD(String adepAdesD) {
        this.adepAdesD = adepAdesD;
    }

    public String getSibt() {
        return sibt;
    }

    public void setSibt(String sibt) {
        this.sibt = DateTimeUtil.timeDayFormatByStr(sibt);
    }

    public String getSobt() {
        return sobt;
    }

    public void setSobt(String sobt) {
        this.sobt = DateTimeUtil.timeDayFormatByStr(sobt);
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

    public String getBagWeightA() {
        return bagWeightA;
    }

    public void setBagWeightA(String bagWeightA) {
        this.bagWeightA = bagWeightA;
    }

    public String getBagWeightD() {
        return bagWeightD;
    }

    public void setBagWeightD(String bagWeightD) {
        this.bagWeightD = bagWeightD;
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
}
