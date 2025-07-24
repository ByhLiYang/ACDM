package com.hq.acdm.model.flight;

import java.util.Date;

public class DailyFlightMasterKey {
    private String flightNoIata;

    private Date operationalDate;

    private String aOrD;

    private String flightRepeatCount;

    public String getFlightNoIata() {
        return flightNoIata;
    }

    public void setFlightNoIata(String flightNoIata) {
        this.flightNoIata = flightNoIata == null ? null : flightNoIata.trim();
    }

    public Date getOperationalDate() {
        return operationalDate;
    }

    public void setOperationalDate(Date operationalDate) {
        this.operationalDate = operationalDate;
    }

    public String getaOrD() {
        return aOrD;
    }

    public void setaOrD(String aOrD) {
        this.aOrD = aOrD == null ? null : aOrD.trim();
    }

    public String getFlightRepeatCount() {
        return flightRepeatCount;
    }

    public void setFlightRepeatCount(String flightRepeatCount) {
        this.flightRepeatCount = flightRepeatCount == null ? null : flightRepeatCount.trim();
    }
}