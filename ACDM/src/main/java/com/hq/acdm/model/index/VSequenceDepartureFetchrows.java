package com.hq.acdm.model.index;

public class VSequenceDepartureFetchrows {
    private String flightId;
    private String flightNoIata;

    private String cobt;

    private String ctot;

    private String etot;

    public String getFlightNoIata() {
        return flightNoIata;
    }

    public void setFlightNoIata(String flightNoIata) {
        this.flightNoIata = flightNoIata == null ? null : flightNoIata.trim();
    }

    public String getCobt() {
        return cobt;
    }

    public void setCobt(String cobt) {
        this.cobt = cobt;
    }

    public String getCtot() {
        return ctot;
    }

    public void setCtot(String ctot) {
        this.ctot = ctot;
    }

    public String getEtot() {
        return etot;
    }

    public void setEtot(String etot) {
        this.etot = etot;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
}