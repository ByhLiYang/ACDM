package com.hq.acdm.service.statistics.multiDataSourceManagement.impl;


import com.hq.acdm.dao.statistics.MultiDataSourceManagementMapper;
import com.hq.acdm.service.statistics.multiDataSourceManagement.MultiDataSourceManagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
 * 多数据源管理
 */
@Service
public class MultiDataSourceManagementServiceImpl implements MultiDataSourceManagementService {

    @Resource
    private MultiDataSourceManagementMapper multiDataSourceManagementMapper;

    @Override
    public List<Map> getDSMDataSourceList() {
        return multiDataSourceManagementMapper.getDSMDataSourceList();
    }

    @Override
    public List<Map> getDSMMileStoneList() {
        return multiDataSourceManagementMapper.getDSMMileStoneList();
    }

    @Override
    public List<Map> getDSMAllDataSource() {
        return multiDataSourceManagementMapper.getDSMAllDataSource();
    }

    @Override
    public String getDefinedPriority(Map map) {
        return multiDataSourceManagementMapper.getDefinedPriority(map);
    }

    @Override
    public void updateLowerPriority(Map map) {
        multiDataSourceManagementMapper.updateLowerPriority(map);
    }

    @Override
    public void updateHigherPriority(Map map) {
        multiDataSourceManagementMapper.updateHigherPriority(map);
    }

    @Override
    public void updateDefinedPriority(Map map) {
        multiDataSourceManagementMapper.updateDefinedPriority(map);
    }

    @Override
    public void updatePriorityBeforedel(Map map) {
        multiDataSourceManagementMapper.updatePriorityBeforedel(map);
    }

    @Override
    public void deleteRecordLogic(Map map) {
        multiDataSourceManagementMapper.deleteRecordLogic(map);
    }

    @Override
    public int insertRecordLogic(Map map) {
        return multiDataSourceManagementMapper.insertRecordLogic(map);
    }

    @Override
    public int insertRecordPhysical(Map map) {
        return multiDataSourceManagementMapper.insertRecordPhysical(map);
    }

    @Override
    public int updateInsertRecord(Map map) {
        return multiDataSourceManagementMapper.updateInsertRecord(map);
    }
}
