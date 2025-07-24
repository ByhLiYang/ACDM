package com.hq.acdm.service.statistics.monthlyStatistics;

import com.hq.acdm.vo.statistics.monthlyStatistics.MonthlyStatisticsVo;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/12/25 14:40
 * @Description
 */
public interface MonthlyStatisticsService {
    List<MonthlyStatisticsVo> findMonthlyStatistics(String startDate, String endDate);
}
