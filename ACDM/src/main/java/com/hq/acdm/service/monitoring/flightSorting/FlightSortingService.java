package com.hq.acdm.service.monitoring.flightSorting;

import com.hq.acdm.model.monitoring.flightSorting.FlightSorting;
import com.hq.acdm.model.statistics.cdmTobt.CdmTobt;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface FlightSortingService {
    //查询CDM TOBT遵从度

    public List<FlightSorting> queryArrival(Map<String, Object> params)  ;
    public List<FlightSorting> queryDeparture(Map<String, Object> params)  ;

}
