package com.hq.acdm.dao.dump1090;

import com.hq.acdm.controller.req.AircraftSaveReq;
import com.hq.acdm.model.dump1090.Aircraft;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Dump1090Mapper {
    boolean checkAircraftExists(@Param("hex") String hex);

    void updateByHex(@Param("aircraftSaveReq") AircraftSaveReq aircraftSaveReq);

    void save(@Param("aircraft")  Aircraft aircraft);
}
