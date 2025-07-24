package com.hq.acdm.model.statistics.maintenanceMachinePosition;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class StandAdd {
    private String STAND;
    private String STAND_LAYOUT;
    private String TERMINAL;
    private String GATE;
    private String DESCRIPTION;
    private String AUTO_TOW;
    private String UCT_NOTICE;
    private String STAND_IS_SECURE;
    private String STATUS;
    private String STATUS_START;
    private String STATUS_END;
    private String STATUS_REASON;
    private String IS_REMOTE;
    private String AIRCRAFTTYPE;
    private String COORDINATE;
    private Integer TYPE;
}
