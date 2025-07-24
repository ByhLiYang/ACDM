package com.hq.acdm.service.flight.impl;

import com.hq.acdm.dao.flight.VKeyTimesHisMapper;

import com.hq.acdm.model.flight.VKeyTimesHis;

import com.hq.acdm.service.flight.VKeyTimesHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service("vKeyTimesHisService")
public class VKeyTimesHisServiceImpl implements VKeyTimesHisService {

    public static String BEGIN_DATE = "beginDate";
    public static String END_DATE = "endDate";

    public static String FLIGHT_NO_IATA = "flightNoIata";
    public static String AIRLINE = "airline";
    public static String DEST = "dest";
    public static String A_OR_D = "aOrD";
    public static String TERMINAL = "terminal";
    public static String AREAID = "areaid";
    public static String GATE = "gate";

    public static String FLIGHT_STATUS = "flightstatus";
    public static String PASS_STATUS="passstatus";

    public static String IN_DELAY = "inDelay";
    public static String OUT_DELAY = "outDelay";

    //public static final String[] EQUALPARAMS = {FLIGHT_NO_IATA};
    @Autowired
    VKeyTimesHisMapper vKeyTimesHisMapper;

    @Override
    public List<VKeyTimesHis> query(Map params) {


        return vKeyTimesHisMapper.query(params);
    }
}
