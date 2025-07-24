package com.hq.acdm.service.statistics.detainedPassage;

import com.hq.acdm.model.statistics.detainedPassage.DetainedPassage;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface DetainedPassageService {
    //滞留旅客状态查询

    List<DetainedPassage> queryDetainedPassage(Map params);
    //登机异常
    List<DetainedPassage> queryAnomalyPassage(Map params);

}
