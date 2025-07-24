package com.hq.acdm.model.timer.HourlyPassengerCount;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author wangshuhao
 * @date 2018/11/9 0009 11:14
 */
@Getter
@Setter
public class initialData {
     private int countHour24h;
     private Date countDate;
     private int countCheckedIn;
     private int countInSecurityZone;
     private int onFlights;
     private int terminal;

    public initialData(int countHour24h, Date countDate, int countCheckedIn, int countInSecurityZone, int onFlights,int terminal) {
        this.countHour24h = countHour24h;
        this.countDate = countDate;
        this.countCheckedIn = countCheckedIn;
        this.countInSecurityZone = countInSecurityZone;
        this.onFlights = onFlights;
        this.terminal = terminal;
    }
}
