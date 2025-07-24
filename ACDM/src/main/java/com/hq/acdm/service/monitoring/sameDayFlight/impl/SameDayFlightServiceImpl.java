package com.hq.acdm.service.monitoring.sameDayFlight.impl;

import com.hq.acdm.model.monitoring.sameDayFlight.SameDayFlight;
import com.hq.acdm.model.monitoring.sameDayFlight.FlightInfo;
import com.hq.acdm.service.monitoring.sameDayFlight.SameDayFlightService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("SameDelayFlightService")
public class SameDayFlightServiceImpl implements SameDayFlightService {
    @Resource
    private com.hq.acdm.dao.monitioring.SameDayFlightMapper sameDayFlightMapper;

    @Override
    public List<SameDayFlight> queryList(Map params) {
        System.out.println("------------SameDayFlightServiceImpl-----------------");
        List<SameDayFlight> list = sameDayFlightMapper.queryList(params);
        System.out.println(list);
        return list;
    }
    public FlightInfo queryFlightInfo(Map params){
        FlightInfo detail=sameDayFlightMapper.queryFlightInfo(params);
        return detail;
    }
    public List queryFlightInfoMore(Map params){
        List list=sameDayFlightMapper.queryFlightInfoMore(params);
        return list;
    }

    public void updateFlightNode(Map params){
         sameDayFlightMapper.updateFlightNode(params);
    }
}
