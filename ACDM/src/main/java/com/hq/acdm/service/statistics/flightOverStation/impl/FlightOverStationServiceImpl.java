package com.hq.acdm.service.statistics.flightOverStation.impl;

import com.hq.acdm.dao.statistics.FlightOverStationMapper;
import com.hq.acdm.model.statistics.flightOverStation.Delay;
import com.hq.acdm.service.statistics.flightOverStation.FlightOverStationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FlightOverStationServiceImpl implements FlightOverStationService{

    @Resource
    private FlightOverStationMapper flightOverStationMapper;

    @Override
    public List<Delay> queryDelay(String startDate, String endDate) {
        return flightOverStationMapper.queryDelay(startDate,endDate);
    }

    @Override
    public List<Delay> queryNotDelay(String startDate, String endDate) {
        return flightOverStationMapper.queryNotDelay(startDate,endDate);
    }

    @Override
    public List<Delay> queryFlightOver(String startDate, String endDate) {
        return flightOverStationMapper.queryFlightOver(startDate,endDate);
    }
}
