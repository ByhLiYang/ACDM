package com.hq.acdm.service.dump1090;

import com.hq.acdm.controller.req.AircraftSaveReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Dump1090Service {
    void dataReception(@Param("aircraftDataList") List<AircraftSaveReq> aircraftDataList);
}
