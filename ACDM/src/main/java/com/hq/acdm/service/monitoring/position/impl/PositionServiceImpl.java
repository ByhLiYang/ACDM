package com.hq.acdm.service.monitoring.position.impl;

import com.hq.acdm.model.monitoring.position.availablePosition;
import com.hq.acdm.service.monitoring.position.PositionService;
import org.springframework.stereotype.Service;
import com.hq.acdm.model.monitoring.position.farArea;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("PositionService")
public class PositionServiceImpl implements PositionService {
    @Resource
    private com.hq.acdm.dao.monitioring.PositionMapper positionMapper;

    @Override
    public List<availablePosition> queryFree(Map params) {
        System.out.println("------------SmallDelayServiceImpl-----------------");
        List<availablePosition> list = positionMapper.queryFree(params);
        System.out.println(list);
        return list;
    }

    @Override
    public List<availablePosition> queryDetail(Map params) {
        System.out.println("------------SmallDelayServiceImpl-----------------");
        List<availablePosition> list = positionMapper.queryDetail(params);
        System.out.println(list);
        return list;
    }

    @Override
    public List<availablePosition> querySummary(Map params) {
        System.out.println("------------SmallDelayServiceImpl-----------------");
        List<availablePosition> list = positionMapper.querySummary(params);
        System.out.println(list);
        return list;
    }
    @Override
    public List<farArea> queryFar(Map params) {
        System.out.println("------------SmallDelayServiceImpl-----------------");
        List<farArea> list = positionMapper.queryFar(params);
        System.out.println(list);
        return list;
    }
}
