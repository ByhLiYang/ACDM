package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.gateAreaMaintenance.GateAreaMaintenance;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/9/27 0027 9:07
 */
public interface GateAreaMaintenanceMapper {
    //登机区域维护查询
    List<GateAreaMaintenance> queryGateAreaMaintenance(@Param("params")Map params);
    //插入登机口
    int insertGate(List<GateAreaMaintenance> gateAreaMaintenance);
    //修改登机口
    int modifyGate(List<GateAreaMaintenance> gateAreaMaintenance);
    //修改区域
    int insertArea(@Param("params")Map params);
    //查询GATE
    List<GateAreaMaintenance> queryGate(@Param("terminal")String terminal);
    //查询AREA
    List<GateAreaMaintenance> queryArea();
    //删除AREA
    int deleteArea(@Param("AREAID")String AREAID);
    //修改AREA
    int updateArea(@Param("params")Map params);
    //根据gate找到terminal
    List<GateAreaMaintenance>queryGateFromTerminal(@Param("gate")String gate);
}
