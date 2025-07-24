package com.hq.acdm.service.statistics.baggageFlight.impl;

import com.hq.acdm.dao.statistics.baggageFlightMapper;
import com.hq.acdm.model.statistics.baggageFlight.baggageFlight;
import com.hq.acdm.service.statistics.baggageFlight.BaggaegFlightService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/20 0020 14:37
 */
@Service("BaggaegFlightService")
public class BaggageFlightServiceImpl implements BaggaegFlightService{
    @Resource
    private baggageFlightMapper baggageFlightMapper;

    @Override
    public List<baggageFlight> queryBaggageFlight(Map params) {
        System.out.println("------------BaggageFlightServiceImpl-----------------");
        List<baggageFlight> list = baggageFlightMapper.queryBaggageFlight(params);
        System.out.println(list);
        return list;
    }
}
