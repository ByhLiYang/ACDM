package com.hq.acdm.dao.monitioring;

import com.hq.acdm.model.monitoring.reportInfo.ReportDailyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface ReportDailyInfoMapper {
    //简报-一日简报
    //查询任务列表
    List<ReportDailyInfo> queryList(@Param("params") Map params);
   //从数据库统计数据
   ReportDailyInfo queryDaily(@Param("params") Map params);

    List<ReportDailyInfo> queryFlightList(@Param("params") Map params);
    //新增任务
    int insert(ReportDailyInfo task);
    //更新
    int update(ReportDailyInfo task);

    int updateStatus(ReportDailyInfo task);

    ReportDailyInfo selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);
}
