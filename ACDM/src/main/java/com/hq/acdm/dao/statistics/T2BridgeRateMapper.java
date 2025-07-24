package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.T2BridgeRate.T2BridgeRate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/8 0008 10:24
 */
public interface T2BridgeRateMapper {
    List<T2BridgeRate> queryT2BridgeRate(@Param("params")Map params);
}
