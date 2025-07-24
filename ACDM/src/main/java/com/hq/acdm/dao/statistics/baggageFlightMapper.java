package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.baggageFlight.baggageFlight;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface baggageFlightMapper {
    //查询滑行时间预测准确率
    List<baggageFlight> queryBaggageFlight(@Param("params") Map params);
}
