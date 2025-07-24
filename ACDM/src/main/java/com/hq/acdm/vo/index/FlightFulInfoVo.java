package com.hq.acdm.vo.index;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2018/11/20 15:28
 * @Description
 */
@Data
public class FlightFulInfoVo {
    private String FLIGHT_NO_IATA;
    private String ARN;
    private String ORIGIN_CNAME;
    private String DEST_CNAME;
    private String VIA_CNAME;
    private String AIRCRAFT_TERMINAL_CODE;
    private String GATE;
    private String STAND;
    private String TYPE;
    private String EXOT;
    private String AXOT;
    private String FLIGHT_CLASS_CODE;
    private String FLIGHT_SERVICE_TYPE;
    private String FLIGHT_NATURE_CODE;
    private String SIBT;
    private String SOBT;
//    关键时间节点
    private String FLIGHT_NO_IATA_A;
    private String OPERATIONAL_DATE_A;
    private String PRE_ATOT;
    private String ALDT;
    private String A_GROUND_TRANSFER;
    private String AIBT_SHORT;
    private String AIBT;
    private String ARSL;
    private String ATDO;
    private String ATFO;
    private String FLIGHT_NO_IATA_D;
    private String OPERATIONAL_DATE_D;
    private String ASCT;
    private String AFCT;
    private String ASR;
    private String AER;
    private String ASC;
    private String AEC;
    private String ASBT;
    private String AEBT;
    private String ATDC;
    private String ATFC;
    private String AACT;
    private String LSW;
    private String AOBT_SHORT;
    private String AOBT;
    private String D_GROUND_TRANSFER;
    private String ATOT;
}
