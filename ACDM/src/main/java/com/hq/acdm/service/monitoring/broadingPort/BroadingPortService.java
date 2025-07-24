package com.hq.acdm.service.monitoring.broadingPort;

import com.hq.acdm.model.monitoring.broadingPort.BroadingPortDetail;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface BroadingPortService {
    //查询登机口使用明细表

    public List<BroadingPortDetail> queryDetail(Map params)  ;
    public List<BroadingPortDetail> querySummary(Map params)  ;
    //查询靠桥率
    BroadingPortDetail  queryBridgeRate(Map params)  ;
}
