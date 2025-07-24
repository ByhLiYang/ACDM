package com.hq.acdm.service.statistics.baggageFlight;

import com.hq.acdm.model.statistics.baggageFlight.baggageFlight;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/9/20 0020 14:36
 */
public interface BaggaegFlightService {
    //查询滑行时间预测准确率
    List<baggageFlight> queryBaggageFlight(Map params);
}
