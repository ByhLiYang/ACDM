package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.operationQualityWeekly.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperationQualityWeeklyMapper {

    //总的放行率
    List<TotalReleaseRate> queryTotalReleaseRate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    //总的延误
    List<TotalDelay> queryTotalDelay(@Param("startDate") String startDate, @Param("endDate") String endDate);

    //国内放行率
    List<DomesticReleaseRate> queryDomesticReleaseRate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    //国内延误
    List<DomesticDelay> queryDomesticDelay(@Param("startDate") String startDate, @Param("endDate") String endDate);

    //国际放行率
    List<InternationalReaseRate> queryInternationalReaseRate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    //国际延误
    List<InternationalDelay> queryInternationalDelay(@Param("startDate") String startDate, @Param("endDate") String endDate);

}
