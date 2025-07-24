package com.hq.acdm.service.timer.DailyRunWay;

import com.hq.acdm.model.timer.DailyRunWay.DailyRunWay;
import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightMaster;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 8:44
 */
public interface DailyRunWayService {
    int insertDRWA();
    int insertDRWD();
    int insertCondition(Map<String,Object> map);
    List<DailyRunWay> queryDRW();
    List<DailyRunWay> queryLastest();
    List<DailyFlightMaster> queryLatestRWY();
    List<DailyRunWay> queryByConditionIfExist(Map<String,Object> map);
    int updateDailyRunWay(DailyRunWay dailyRunWay);
    List<DailyRunWay> queryLastDailyRunWay();
    List<DailyRunWay> queryTodayDailyRunWay();
}
