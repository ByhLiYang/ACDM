package com.hq.acdm.service.monitoring.reportInfo;

import com.hq.acdm.model.monitoring.reportInfo.ReportDailyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author lizhifeng
 * @Date 2018/8/21 0021
 * @Description:
 */
public interface ReportDailyInfoService {

    void save(ReportDailyInfo task);

    void update(ReportDailyInfo task);

    void updateStatus(ReportDailyInfo task);

    void delete(Integer taskid);

     List<ReportDailyInfo> queryList(Map params) ;

    //从数据库统计数据
    ReportDailyInfo queryDaily( Map params);



}
