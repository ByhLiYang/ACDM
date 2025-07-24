package com.hq.acdm.service.statistics.maintenanceMachinePosition;

import com.hq.acdm.model.statistics.maintenanceMachinePosition.CameraStand;
import com.hq.acdm.model.statistics.maintenanceMachinePosition.StandAdd;

import java.util.List;
import java.util.Map;

/**
 * 机位状态维护 服务接口类
 */
public interface MaintenanceMachinePositionService {
    //取得机位列表
    List<String> getSMMStandList();

    //取得机位所有记录
    List<CameraStand> getSMMAllRecord(Map params);

    //新增机位
    void addStand(StandAdd standAdd);

    //删除机位
    void delStand(String standno);

    //基础机位的更新
    void updateStand(Map params);

    //非基础机位的更新
    void updateStandAdd(Map params);

}
