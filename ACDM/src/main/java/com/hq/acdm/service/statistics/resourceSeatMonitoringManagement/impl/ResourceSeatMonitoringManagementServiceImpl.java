package com.hq.acdm.service.statistics.resourceSeatMonitoringManagement.impl;

import com.hq.acdm.dao.statistics.ResourceSeatMonitoringManagementMapper;
import com.hq.acdm.service.statistics.resourceSeatMonitoringManagement.ResourceSeatMonitoringManagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 资源席位监控管理ServiceImpl
 */
@Service
public class ResourceSeatMonitoringManagementServiceImpl implements ResourceSeatMonitoringManagementService {

    @Resource
    private ResourceSeatMonitoringManagementMapper resourceSeatMonitoringManagementMapper;

    @Override
    public List<Map> queryRealTimeBridgeApproach() {
        return resourceSeatMonitoringManagementMapper.queryRealTimeBridgeApproach();
    }

    @Override
    public List<Map> queryDelayedFlightTop() {
        return resourceSeatMonitoringManagementMapper.queryDelayedFlightTop();
    }

    @Override
    public List<Map> queryDelayedFlightLineTop() {
        return resourceSeatMonitoringManagementMapper.queryDelayedFlightLineTop();
    }

    @Override
    public List<Map> queryCollisionWarning() {
        return resourceSeatMonitoringManagementMapper.queryCollisionWarning();
    }

    @Override
    public int queryFreeSpaceCount() {
        return resourceSeatMonitoringManagementMapper.queryFreeSpaceCount();
    }

    @Override
    public List<Map> queryFreeStandSum() {
        return resourceSeatMonitoringManagementMapper.queryFreeStandSum();
    }

    @Override
    public List<Map> queryFreeStandGroup() {
        return resourceSeatMonitoringManagementMapper.queryFreeStandGroup();
    }
}
