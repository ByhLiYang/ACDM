package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.estimatedTaxiTimeAccuracy.EstimatedTaxiTimeAccuracy;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * @Auther: wangshuhao
 * @Date: 2018/9/19 10:38
 * @Description:
 */
public interface EstimatedTaxiTimeAccuracyMapper {
    //查询滑行时间预测准确率
    List<EstimatedTaxiTimeAccuracy> queryEstimatedTaxiTimeAccuracyInfo(@Param("params")Map params);
}
