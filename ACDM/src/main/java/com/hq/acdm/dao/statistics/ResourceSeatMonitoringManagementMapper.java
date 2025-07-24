package com.hq.acdm.dao.statistics;

import java.util.List;
import java.util.Map;

/**
 * 资源席位监控管理DAO
 */
public interface ResourceSeatMonitoringManagementMapper {

    //查询实时靠桥率
    List<Map> queryRealTimeBridgeApproach();

    //查询滞留航班延误排行
    List<Map> queryDelayedFlightTop();

    //查询滞留航线延误排行
    List<Map> queryDelayedFlightLineTop();

    //查询机位冲突预警
    List<Map> queryCollisionWarning();

    //机位空闲停机位总数
    int queryFreeSpaceCount();


    //机位空闲停机位 航站楼、停机位类型、停机位数量
    List<Map> queryFreeStandSum();

    //机位空闲停机位类型、总数
    List<Map> queryFreeStandGroup();

}
