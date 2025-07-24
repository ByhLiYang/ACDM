package com.hq.acdm.service.statistics.bridgeRate;

import com.hq.acdm.model.statistics.bridgeRate.BridgeRateT1;
import com.hq.acdm.model.statistics.bridgeRate.BridgeRateT2;
import com.hq.acdm.model.statistics.bridgeRate.T1;
import com.hq.acdm.model.statistics.bridgeRate.T2;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/9/25 0025 14:59
 */
public interface BridgeRateService {


    List<T1> queryT1();

    List<T2> queryT2();
}
