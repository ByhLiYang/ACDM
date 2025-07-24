package com.hq.acdm.service.statistics.flightOverStation;

import com.hq.acdm.model.statistics.flightOverStation.Delay;
import java.util.List;

public interface FlightOverStationService {
    List<Delay> queryDelay(String startDate, String endDate);

    List<Delay> queryNotDelay(String startDate, String endDate);

    List<Delay> queryFlightOver(String startDate, String endDate);
}
