package com.hq.acdm.service.monitoring.broadingPort.impl;

import com.hq.acdm.model.monitoring.broadingPort.BroadingPortDetail;
import com.hq.acdm.service.monitoring.broadingPort.BroadingPortService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("BroadingPortService")
public class BroadingPortServiceImpl implements BroadingPortService {
    @Resource
    private com.hq.acdm.dao.monitioring.BroadingPortMapper broadingPortMapper;

    @Override
    public List<BroadingPortDetail> queryDetail(Map params) {
        System.out.println("------------SmallDelayServiceImpl-----------------");
        List<BroadingPortDetail> list = broadingPortMapper.queryDetail(params);
        System.out.println(list);
        return list;
    }

    @Override
    public List<BroadingPortDetail> querySummary(Map params) {
        System.out.println("------------SmallDelayServiceImpl-----------------");
        List<BroadingPortDetail> list = broadingPortMapper.querySummary(params);
        System.out.println(list);
        return list;
    }

    //查询靠桥率
    public BroadingPortDetail queryBridgeRate(Map params) {
        System.out.println("------------SmallDelayServiceImpl-----------------");
        BroadingPortDetail de = broadingPortMapper.queryBridgeRate(params);
        System.out.println(de);
        return de;
    }
}
