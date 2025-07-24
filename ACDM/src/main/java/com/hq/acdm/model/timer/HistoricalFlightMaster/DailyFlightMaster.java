package com.hq.acdm.model.timer.HistoricalFlightMaster;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangshuhao
 * @date 2018/11/11 0011 8:57
 */
@Getter
@Setter
public class DailyFlightMaster {
    private String arn;

    private String type;

    private String flight_no_icao;

    private String airline_code_iata;

    private String airline_code_icao;

    private String origin_airport_iata;

    private String origin_airport_icao;

    private String dest_airport_iata;

    private String dest_airport_icao;

    private String prev_flight_no_iata;

    private String prev_flight_no_icao;

    private String nxt_flight_no_iata;

    private String nxt_flight_no_icao;

    private String stand;

    private String gate1;

    private String gate2;

    private String gate3;

    private String rwy;

    private String belt1;

    private String belt2;

    private String belt3;

    private String counters;

    private String taxiway;

    private String deicing_gate;

    private String d_or_i;

    private String milestone_status;

    private String delay_status;

    private String current_delay_code;

    private Date atmo;

    private Date fadt;

    private Date atot;

    private Date sldt;

    private Date eldt;

    private Date aldt;

    private Date sibt;

    private Date eibt;

    private Date aibt;

    private BigDecimal exit;

    private BigDecimal axit;

    private Date scgt;

    private Date ecgt;

    private Date acgt;

    private Date aegt;

    private BigDecimal mttt;

    private BigDecimal ettt;

    private BigDecimal sttt;

    private BigDecimal aght;

    private Date ssbt;

    private Date esbt;

    private Date asbt;

    private Date srdt;

    private Date erdt;

    private Date ardt;

    private Date esrt;

    private Date asrt;

    private Date ssat;

    private Date esat;

    private Date tsat;

    private Date asat;

    private Date sobt;

    private Date eobt;

    private Date tobt;

    private Date aobt;

    private BigDecimal exot;

    private BigDecimal axot;

    private Date erzt;

    private Date sczt;

    private Date eczt;

    private Date aczt;

    private Date sezt;

    private Date eezt;

    private Date aezt;

    private BigDecimal adit;

    private Date stot;

    private Date etot;

    private Date ttot;

    private String eet;

    private String diversionstatus;

    private String flight_repeat_count;

    private int countNumber;

    private Date operational_date;

    private String flight_no_iata;

    private String a_or_d;

    @Override
    public String toString() {
        return "DailyFlightMaster{" +
                ", operational_date=" + operational_date +
                ", flight_no_iata='" + flight_no_iata + '\'' +
                ", a_or_d='" + a_or_d + '\'' +
                ", flight_repeat_count='" + flight_repeat_count + '\'' +
                '}';
    }


}
