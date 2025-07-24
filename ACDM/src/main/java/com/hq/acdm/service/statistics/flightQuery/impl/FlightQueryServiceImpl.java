package com.hq.acdm.service.statistics.flightQuery.impl;

import com.hq.acdm.dao.statistics.FlightQueryMapper;
import com.hq.acdm.model.statistics.flightQuery.FlightQueryResult;
import com.hq.acdm.model.statistics.flightQuery.Location;
import com.hq.acdm.model.statistics.flightQuery.ReduceCalculateResult;
import com.hq.acdm.service.statistics.flightQuery.FlightQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/10/17 0017 9:33
 */
@Service("FlightQueryService")
public class FlightQueryServiceImpl implements FlightQueryService{
    @Resource
    private FlightQueryMapper flightQueryMapper;
    @Override
    public List<Map<String, Object>> getDetail() {
        return null;
    }

    @Override
    public List<Map<String, Object>> getCount() {
        return null;
    }

    @Override
    public List<Location> get_location() {
        return flightQueryMapper.get_location();
    }

    @Override
    public List<FlightQueryResult> queryWithoutAORD(Map params) {
        return flightQueryMapper.queryWithoutAORD(params);
    }

    @Override
    public List<FlightQueryResult> queryWithAORD(Map params) {
        return flightQueryMapper.queryWithAORD(params);
    }

    @Override
    public List<ReduceCalculateResult> xuejianA(Map params) {
        return flightQueryMapper.xuejianA(params);
    }

    @Override
    public List<ReduceCalculateResult> xuejianD(Map params) {
        return flightQueryMapper.xuejianD(params);
    }
}
