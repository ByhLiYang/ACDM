package com.hq.acdm.dao.monitioring;

import com.hq.acdm.model.monitoring.flightSorting.FlightSorting;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface FlightSortingMapper {
    //CDM TOBT遵从度
    List<FlightSorting> queryArrival(@Param("params") Map<String, Object> params);
    List<FlightSorting> queryDeparture(@Param("params") Map<String, Object> params);
}
