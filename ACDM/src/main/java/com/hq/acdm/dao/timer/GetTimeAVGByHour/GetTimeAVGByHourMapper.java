package com.hq.acdm.dao.timer.GetTimeAVGByHour;

import com.hq.acdm.model.timer.GetTimeAVGByHour.GetTimeAVGByHour;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 9:28
 */
public interface GetTimeAVGByHourMapper {
    int updateDailyRunway(@Param("params") Map<String,Object> map);
    int updateHistoricalTaxiTimeRecord(@Param("params") Map<String,Object> map);
    int insertHistoricalTaxiTimeRecord(@Param("params") Map<String,Object> map);
    List<GetTimeAVGByHour> queryHistoricalTaxiTimeRecord(@Param("params") Map<String,Object> map);
    List<GetTimeAVGByHour> queryRecord();
}
