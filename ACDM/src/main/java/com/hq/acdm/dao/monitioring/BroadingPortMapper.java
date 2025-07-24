package com.hq.acdm.dao.monitioring;

import com.hq.acdm.model.monitoring.broadingPort.BroadingPortDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface BroadingPortMapper {
    //登机口监管
    List<BroadingPortDetail> queryDetail(@Param("params") Map params);

    List<BroadingPortDetail> querySummary(@Param("params") Map params);

    BroadingPortDetail queryBridgeRate(@Param("params") Map params);
}
