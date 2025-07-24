package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.averageCrossingTime.AverageCrossingTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/9/20 0020 14:35
 */
public interface AverageCrossingTimeMapper {
    //查询滑行时间预测准确率
    List<AverageCrossingTime> queryAverageCrossingTime(@Param("params")Map params);
}
