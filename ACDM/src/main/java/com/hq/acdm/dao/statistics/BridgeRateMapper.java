package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.bridgeRate.BridgeRateT1;
import com.hq.acdm.model.statistics.bridgeRate.BridgeRateT2;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/9/25 0025 14:48
 */
public interface BridgeRateMapper {
    //查询t1 始发
    List<BridgeRateT1> queryT1Init();
    //T2 overD
    List<BridgeRateT1> queryT1OverD();
    //T2 overA
    List<BridgeRateT1> queryT1OverA();
    //查询t2 始发
    List<BridgeRateT2> queryT2Init();
    //T2 overD
    List<BridgeRateT2> queryT2OverD();
    //T2 overA
    List<BridgeRateT2> queryT2OverA();
}
