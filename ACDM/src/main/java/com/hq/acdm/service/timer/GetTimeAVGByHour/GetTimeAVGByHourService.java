package com.hq.acdm.service.timer.GetTimeAVGByHour;

import com.hq.acdm.model.timer.GetTimeAVGByHour.GetTimeAVGByHour;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 9:26
 */
public interface GetTimeAVGByHourService {
    int updateDailyRunway(Map<String,Object> map);
    int updateHistoricalTaxiTimeRecord(Map<String,Object> map);
    int insertHistoricalTaxiTimeRecord(Map<String,Object> map);
    List<GetTimeAVGByHour> queryHistoricalTaxiTimeRecord(Map<String,Object> map);
    List<GetTimeAVGByHour> queryRecord();
}
