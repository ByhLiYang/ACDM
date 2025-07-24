package com.hq.acdm.service.statistics.operationQualityWeekly.impl;
import com.hq.acdm.dao.statistics.OperationQualityWeeklyMapper;
import com.hq.acdm.model.statistics.operationQualityWeekly.*;
import com.hq.acdm.service.statistics.operationQualityWeekly.OperationQualityWeeklyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OperationQualityWeeklyServiceImpl implements OperationQualityWeeklyService{

    @Resource
    private OperationQualityWeeklyMapper operationQualityWeeklyMapper;

    @Override
    public List<TotalReleaseRate> queryTotalReleaseRate(String startDate, String endDate) {
        List<TotalReleaseRate> list=operationQualityWeeklyMapper.queryTotalReleaseRate(startDate,endDate);
        return list;
    }

    @Override
    public List<TotalDelay> queryTotalDelay(String startDate, String endDate) {
        List<TotalDelay> list=operationQualityWeeklyMapper.queryTotalDelay(startDate,endDate);
        return list;
    }

    @Override
    public List<DomesticReleaseRate> queryDomesticReleaseRate(String startDate, String endDate) {
        List<DomesticReleaseRate> list=operationQualityWeeklyMapper.queryDomesticReleaseRate(startDate,endDate);
        return list;
    }

    @Override
    public List<DomesticDelay> queryDomesticDelay(String startDate, String endDate) {
        List<DomesticDelay> list=operationQualityWeeklyMapper.queryDomesticDelay(startDate,endDate);
        return list;
    }

    @Override
    public List<InternationalReaseRate> queryInternationalReaseRate(String startDate, String endDate) {
        List<InternationalReaseRate> list=operationQualityWeeklyMapper.queryInternationalReaseRate(startDate,endDate);
        return list;
    }

    @Override
    public List<InternationalDelay> queryInternationalDelay(String startDate, String endDate) {
        List<InternationalDelay> list=operationQualityWeeklyMapper.queryInternationalDelay(startDate,endDate);
        return list;
    }
}
