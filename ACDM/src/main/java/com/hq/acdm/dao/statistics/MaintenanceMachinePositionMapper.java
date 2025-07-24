package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.maintenanceMachinePosition.CameraStand;
import com.hq.acdm.model.statistics.maintenanceMachinePosition.StandAdd;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 机位状态维护接口
 */
public interface MaintenanceMachinePositionMapper {

    //取得机位列表
    List<String> getSMMStandList();

    //取得机位所有记录
    List<CameraStand> getSMMAllRecord(@Param("params")Map params);

    //新增机位
    void addStand(StandAdd standAdd);

    //删除机位
    void delStand(String standno);

    //基础机位的更新
    void updateStand(Map params);

    //非基础机位的更新
    void updateStandAdd(Map params);

}
