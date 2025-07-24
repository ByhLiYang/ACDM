package com.hq.acdm.service.monitoring.sameDayFlight;

import com.hq.acdm.model.monitoring.sameDayFlight.SameDayFlight;
import com.hq.acdm.model.monitoring.sameDayFlight.FlightInfo;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface SameDayFlightService {
    //当日航班监管

    public List<SameDayFlight> queryList(Map<String,Object> params)  ;

    public  FlightInfo queryFlightInfo (Map params)  ;

    public  void updateFlightNode (Map params)  ;

    public List queryFlightInfoMore(Map params);


}
