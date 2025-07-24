package com.hq.acdm.service.timer.MilestoneHistoricalLog;

import com.hq.acdm.model.timer.MilestoneHistoricalLog.MilestoneHistoricalLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/12 0012 15:18
 */
public interface MilestoneHistoricalLogService {
    MilestoneHistoricalLog countMDL();
    List<MilestoneHistoricalLog> queryMDL();
    MilestoneHistoricalLog queryMHLByCondition(Map<String,Object> map);
    int deleteMHL(Map<String,Object> map);
    int deleteMDL(Map<String,Object> map);
    int insertMHL(Map<String,Object> map);
}
