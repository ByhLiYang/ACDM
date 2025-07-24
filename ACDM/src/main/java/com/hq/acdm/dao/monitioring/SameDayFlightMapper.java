package com.hq.acdm.dao.monitioring;

import com.hq.acdm.model.monitoring.sameDayFlight.SameDayFlight;
import org.apache.ibatis.annotations.Param;
import com.hq.acdm.model.monitoring.sameDayFlight.FlightInfo;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface SameDayFlightMapper {
    //当日航班监管
    List<SameDayFlight> queryList(@Param("params") Map<String,Object>  params);
    //22个时间节点查询
    FlightInfo queryFlightInfo(@Param("params") Map<String ,Object> params);
    //多出的3个节点信息
    List queryFlightInfoMore(@Param("params") Map params);

    void updateFlightNode(@Param("params") Map<String ,Object> params);
}
