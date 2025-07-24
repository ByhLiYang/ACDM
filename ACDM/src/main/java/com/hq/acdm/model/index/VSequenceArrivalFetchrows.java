package com.hq.acdm.model.index;

public class VSequenceArrivalFetchrows {
    private String flightId;
    private String flightNoIata;

    private String eldt;

    private String eta;
    private String sibt;

    private String aTmo;
    private String stand;

    public String getFlightNoIata() {
        return flightNoIata;
    }

    public void setFlightNoIata(String flightNoIata) {
        this.flightNoIata = flightNoIata == null ? null : flightNoIata.trim();
    }

    public String getEldt() {
        return eldt;
    }

    public void setEldt(String eldt) {
        this.eldt = eldt;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getaTmo() {
        return aTmo;
    }

    public void setaTmo(String aTmo) {
        this.aTmo = aTmo;
    }

    public String getSibt() {
        return sibt;
    }

    public void setSibt(String sibt) {
        this.sibt = sibt;
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
}