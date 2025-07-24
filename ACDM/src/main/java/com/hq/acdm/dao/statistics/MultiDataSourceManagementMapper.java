package com.hq.acdm.dao.statistics;

import java.util.List;
import java.util.Map;

/**
 * 多数据源管理
 */
public interface MultiDataSourceManagementMapper {
    //查询有效的数据源
    List<Map> getDSMDataSourceList();

    //查询有效的里程碑
    List<Map> getDSMMileStoneList();

    //查询所有的数据源
    List<Map> getDSMAllDataSource();

    //取得数据库中的指定记录的优先级
    String getDefinedPriority(Map map);

    //指定记录优先级下移，相邻记录上移
    void updateLowerPriority(Map map);

    //指定记录优先级下移，相邻记录上移
    void updateHigherPriority(Map map);

    //指定记录的优先级变更
    void updateDefinedPriority(Map map);

    //删除前先将优先级小于待删除记录的优先级全部提升一级
    void updatePriorityBeforedel(Map map);

    //删除该记录(逻辑删除)
    void deleteRecordLogic(Map map);

    //新增数据源记录(逻辑插入)
    int insertRecordLogic(Map map);

    //新增数据源记录(物理插入)
    int insertRecordPhysical(Map map);

    //更新插入记录的里程碑名和数据源名
    int updateInsertRecord(Map map);




}
