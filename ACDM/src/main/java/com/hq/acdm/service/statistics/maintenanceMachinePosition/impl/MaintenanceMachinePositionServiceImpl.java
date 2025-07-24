package com.hq.acdm.service.statistics.maintenanceMachinePosition.impl;

import com.hq.acdm.dao.statistics.MaintenanceMachinePositionMapper;
import com.hq.acdm.model.statistics.maintenanceMachinePosition.CameraStand;
import com.hq.acdm.model.statistics.maintenanceMachinePosition.StandAdd;
import com.hq.acdm.service.statistics.maintenanceMachinePosition.MaintenanceMachinePositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 机位状态维护 服务实现类
 */
@Service
public class MaintenanceMachinePositionServiceImpl implements MaintenanceMachinePositionService {
    @Resource
    private MaintenanceMachinePositionMapper maintenanceMachinePositionMapper;

    @Override
    public List<String> getSMMStandList() {
        return maintenanceMachinePositionMapper.getSMMStandList();
    }

    @Override
    public List<CameraStand> getSMMAllRecord(Map params) {
        return maintenanceMachinePositionMapper.getSMMAllRecord(params);
    }

    @Override
    public void addStand(StandAdd standAdd) {
        maintenanceMachinePositionMapper.addStand(standAdd);
    }

    @Override
    public void delStand(String standno) {
        maintenanceMachinePositionMapper.delStand(standno);
    }

    @Override
    public void updateStand(Map params) {
        maintenanceMachinePositionMapper.updateStand(params);
    }

    @Override
    public void updateStandAdd(Map params) {
        maintenanceMachinePositionMapper.updateStandAdd(params);
    }
}
