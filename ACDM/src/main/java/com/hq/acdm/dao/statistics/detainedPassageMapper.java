package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.detainedPassage.DetainedPassage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface detainedPassageMapper {
    //滞留旅客状态
    List<DetainedPassage> queryDetainedPassage(@Param("params") Map params);

    //登机异常
    List<DetainedPassage> queryAnomalyPassage(@Param("params") Map params);
}
