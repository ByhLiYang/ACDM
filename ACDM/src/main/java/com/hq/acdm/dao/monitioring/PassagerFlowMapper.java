package com.hq.acdm.dao.monitioring;

import com.hq.acdm.model.monitoring.passager.PassagerFlow;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface PassagerFlowMapper {
    //CobtJump 跳跃监管
    List<PassagerFlow> queryAirCompanyPassager(@Param("params") Map params);
    List<PassagerFlow> queryTerminalPassager(@Param("params") Map params);
    List<PassagerFlow> queryHourPassager(@Param("params") Map params);
}
