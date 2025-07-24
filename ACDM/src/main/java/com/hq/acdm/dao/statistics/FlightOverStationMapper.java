package com.hq.acdm.dao.statistics;
import com.hq.acdm.model.statistics.flightOverStation.Delay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlightOverStationMapper {

    List<Delay> queryDelay(@Param("startDate") String startDate, @Param("endDate") String endDate);

    List<Delay> queryNotDelay(@Param("startDate") String startDate, @Param("endDate") String endDate);

    List<Delay> queryFlightOver(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
