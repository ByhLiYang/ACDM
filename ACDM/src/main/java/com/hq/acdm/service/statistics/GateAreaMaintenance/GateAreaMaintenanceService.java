package com.hq.acdm.service.statistics.GateAreaMaintenance;

import com.hq.acdm.model.statistics.gateAreaMaintenance.GateAreaMaintenance;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/9/27 0027 9:10
 */
public interface GateAreaMaintenanceService {
    //登机区域维护查询
    List<GateAreaMaintenance> queryGateAreaMaintenance(Map params);
    //查询GATE
    List<GateAreaMaintenance> queryGate(@Param("terminal")String terminal);
    //查询AREA
    List<GateAreaMaintenance> queryArea();
    Map<String,Object> insert(String terminal,String gate,String description,String passengerMax,String gateArea);
    Map<String,Object> delete(String terminal,String gate,String description,String passengerMax,String gateArea,String oldTerminal);
    Map<String,Object> modify(String terminal,String gate,String description,String passengerMax,String gateArea,String oldTerminal);
}
