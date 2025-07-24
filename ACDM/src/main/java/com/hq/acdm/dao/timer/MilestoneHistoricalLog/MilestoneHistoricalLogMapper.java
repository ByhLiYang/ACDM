package com.hq.acdm.dao.timer.MilestoneHistoricalLog;

import com.hq.acdm.model.timer.MilestoneHistoricalLog.MilestoneHistoricalLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/12 0012 15:19
 */
public interface MilestoneHistoricalLogMapper {
    MilestoneHistoricalLog countMDL();
    List<MilestoneHistoricalLog> queryMDL();
    MilestoneHistoricalLog queryMHLByCondition(@Param("params")Map<String,Object> map);
    int deleteMHL(@Param("params")Map<String,Object> map);
    int deleteMDL(@Param("params")Map<String,Object> map);
    int insertMHL(@Param("params")Map<String,Object> map);

}
