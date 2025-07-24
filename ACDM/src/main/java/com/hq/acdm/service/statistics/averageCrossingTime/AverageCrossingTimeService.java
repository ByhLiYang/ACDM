package com.hq.acdm.service.statistics.averageCrossingTime;

import com.hq.acdm.model.statistics.averageCrossingTime.AverageCrossingTime;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/9/20 0020 14:36
 */
public interface AverageCrossingTimeService {
    //查询滑行时间预测准确率
    List<AverageCrossingTime> queryAverageCrossingTime(Map params);
}
