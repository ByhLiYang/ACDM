package com.hq.acdm.model.statistics.flightQuery;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/10/22 0022 9:26
 */
@Getter
@Setter
public class FlightQueryResult {
    private String ARN ;
    private String TYPE ;
    private String OPERATIONAL_DATE ;
    private String FLIGHT_NO_IATA ;
    private String FLIGHT_NO_ICAO ;
    private String A_OR_D ;
    private String D_OR_I ;
    private String AIRLINE_CODE_IATA ;
    private String AIRLINE_CODE_ICAO ;
    private String ORIGIN_AIRPORT_IATA ;
    private String ORIGIN_AIRPORT_ICAO ;
    private String DEST_AIRPORT_IATA ;
    private String DEST_AIRPORT_ICAO ;
    private String STAND ;
    private String GATE_1 ;
    private String GATE_2 ;
    private String GATE_3 ;
    private String GATE_1_CLOSEDATETIME ;
    private String GATE_2_CLOSEDATETIME ;
    private String GATE_3_CLOSEDATETIME ;
    private String RWY ;
    private String BELT_1 ;
    private String BELT_2 ;
    private String BELT_3 ;
    private String COUNTERS ;
    private String PREV_FLIGHT_NO_IATA ;
    private String PREV_FLIGHT_NO_ICAO ;
    private String NXT_FLIGHT_NO_IATA ;
    private String NXT_FLIGHT_NO_ICAO ;
    private String MILESTONE_STATUS ;
    private String LNK_CARRIER_CODE ;
    private String LNK_FLIGHT_NO ;
    private String LNK_FLIGHT_IATA ;
    private String ATOT ;
    private String EET ;
    private String SLDT ;
    private String ELDT ;
    private String ALDT ;
    private String SIBT ;
    private String EIBT ;
    private String AIBT ;
    private String EXIT ;
    private String AXIT ;
    private String SCGT ;
    private String ECGT ;
    private String ACGT ;
    private String AEGT ;
    private String MTTT ;
    private String ETTT ;
    private String STTT ;
    private String AGHT ;
    private String SSBT ;
    private String ESBT ;
    private String SRDT ;
    private String ERDT ;
    private String ARDT ;
    private String ESRT ;
    private String ASRT ;
    private String SSAT ;
    private String ESAT ;
    private String TSAT ;
    private String ASAT ;
    private String SOBT ;
    private String EOBT ;
    private String TOBT ;
    private String AOBT ;
    private String EXOT ;
    private String AXOT ;
    private String ERZT ;
    private String SCZT ;
    private String ECZT ;
    private String ACZT ;
    private String SEZT ;
    private String EEZT ;
    private String AEZT ;
    private String ADIT ;
    private String STOT ;
    private String ETOT ;
    private String TTOT ;
    private String ATMO ;
    private String DEICING_GATE ;
    private String AIRCRAFT_TERMINAL_CODE ;
    private String IS_OVERNIGHT ;
    private String FLIGHT_REPEAT_COUNT ;
    private String LNK_FLIGHT_REPEAT_COUNT ;
    private String FLIGHT_CANCEL_CODE ;


    private String OPERATIONAL_DATE_A ;
    private String FLIGHT_NO_IATA_A ;
    private String STAND_A ;
    private String FLIGHT_NO_ICAO_A ;
    private String AIRLINE_CODE_IATA_A ;
    private String AIRLINE_CODE_ICAO_A ;
    private String OPERATIONAL_DATE_D ;
    private String A ;
    private String FLIGHT_NO_IATA_D ;
    private String FLIGHT_NO_ICAO_D ;
    private String AIRLINE_CODE_IATA_D ;
    private String AIRLINE_CODE_ICAO_D ;
    private String STAND_D ;
    private String D ;
    private String COBT ;
    private String A_TOBT ;
    private String AEBT ;
    private String GCLT ;
    private String AIRPORT_VIA_IATA_7;
    private String AIRPORT_VIA_IATA_1;
    private String AIRPORT_VIA_IATA_2;
    private int ISSTRICTCTRL;
    private String OPERATIONAL_FLAG;
}
