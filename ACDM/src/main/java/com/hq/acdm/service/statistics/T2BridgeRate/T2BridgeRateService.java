package com.hq.acdm.service.statistics.T2BridgeRate;

import com.hq.acdm.model.statistics.T2BridgeRate.T2BridgeRate;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/8 0008 10:34
 */
public interface T2BridgeRateService {
    List<T2BridgeRate> queryT2BridgeRate(Map map);
}
