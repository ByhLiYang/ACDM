package com.hq.acdm.service.monitoring.flightSorting.impl;

import com.hq.acdm.model.monitoring.flightSorting.FlightSorting;
import com.hq.acdm.service.monitoring.flightSorting.FlightSortingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("FlightSortingService")
public class FlightSortingServiceImpl implements FlightSortingService {
    @Resource
    private com.hq.acdm.dao.monitioring.FlightSortingMapper flightSortingMapper;

    @Override
    public List<FlightSorting> queryArrival(Map<String, Object> params) {
        System.out.println("------------BaggageFlightServiceImpl-----------------");
        List<FlightSorting> list = flightSortingMapper.queryArrival(params);
        System.out.println(list);
        return list;
    }
    @Override
    public List<FlightSorting> queryDeparture(Map<String, Object> params) {
        System.out.println("------------BaggageFlightServiceImpl-----------------");
        List<FlightSorting> list = flightSortingMapper.queryDeparture(params);
        System.out.println(list);
        return list;
    }
}
