package com.hq.acdm.service.statistics.monthlyStatistics.impl;

import com.hq.acdm.dao.statistics.MonthlyStatisticsMapper;
import com.hq.acdm.service.statistics.monthlyStatistics.MonthlyStatisticsService;
import com.hq.acdm.vo.statistics.monthlyStatistics.MonthlyStatisticsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/12/25 14:41
 * @Description
 */
@Service
public class MonthlyStatisticsServiceImpl implements MonthlyStatisticsService {
    @Resource
    private MonthlyStatisticsMapper monthlyStatisticsMapper;
    @Override
    public List<MonthlyStatisticsVo> findMonthlyStatistics(String startDate, String endDate) {
        return monthlyStatisticsMapper.findMonthlyStatistics(startDate,endDate);
    }
}
