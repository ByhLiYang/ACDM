package com.hq.acdm.dao.monitioring;

import com.hq.acdm.model.monitoring.reportInfo.ReportRunInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface ReportRunInfoMapper {
    //简报-运行简报
    //查询任务列表
    List<ReportRunInfo> queryList(@Param("params") Map params);

    List<ReportRunInfo> queryFlightList(@Param("params") Map params);
    //新增任务
    int insert(ReportRunInfo task);

    int update(ReportRunInfo task);
    //更新
    int updateStatus(ReportRunInfo task);

    ReportRunInfo selectByPrimaryKey(Integer id);
    int deleteByPrimaryKey(Integer id);
}
