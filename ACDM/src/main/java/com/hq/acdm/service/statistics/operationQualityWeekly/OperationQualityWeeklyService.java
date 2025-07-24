package com.hq.acdm.service.statistics.operationQualityWeekly;

import com.hq.acdm.model.statistics.operationQualityWeekly.*;

import java.util.List;

public interface OperationQualityWeeklyService {
    List<TotalReleaseRate> queryTotalReleaseRate(String startDate, String endDate);

    List<TotalDelay> queryTotalDelay(String startDate, String endDate);

    List<DomesticReleaseRate> queryDomesticReleaseRate(String startDate, String endDate);

    List<DomesticDelay> queryDomesticDelay(String startDate, String endDate);

    List<InternationalReaseRate> queryInternationalReaseRate(String startDate, String endDate);

    List<InternationalDelay> queryInternationalDelay(String startDate, String endDate);
}
