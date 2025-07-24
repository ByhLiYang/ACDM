package com.hq.acdm.service.monitoring.passagerFlow;

import com.hq.acdm.model.monitoring.passager.PassagerFlow;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface PassagerFlowService {
    //客流监管

    public List<PassagerFlow> queryAirCompanyPassager(Map params)  ;
    public List<PassagerFlow> queryTerminalPassager(Map params)  ;
    public List<PassagerFlow> queryHourPassager(Map params)  ;
}
