package com.hq.acdm.service.statistics.estimatedTaxiTimeAccuracy;



import com.hq.acdm.model.statistics.estimatedTaxiTimeAccuracy.EstimatedTaxiTimeAccuracy;

import java.util.List;
import java.util.Map;

/**
 * @Auther: wangshuhao
 * @Date: 2018/9/19 10:38
 * @Description:
 */
public interface EstimatedTaxiTimeAccuracyService {
    //查询滑行时间预测准确率
    List<EstimatedTaxiTimeAccuracy> queryEstimatedTaxiTimeAccuracyInfo(Map params);
}
