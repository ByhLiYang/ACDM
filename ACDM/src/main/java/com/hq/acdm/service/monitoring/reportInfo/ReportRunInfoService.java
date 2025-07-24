package com.hq.acdm.service.monitoring.reportInfo;

import com.hq.acdm.model.monitoring.reportInfo.ReportRunInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author lizhifeng
 * @Date 2018/8/21 0021
 * @Description:
 */
public interface ReportRunInfoService {

    void save(ReportRunInfo task);

    void update(ReportRunInfo task);

    void updateStatus(ReportRunInfo task);

    void delete(Integer taskid);

     List<ReportRunInfo> queryList(Map params) ;

     List<ReportRunInfo> queryFlightList(Map params) ;

}
