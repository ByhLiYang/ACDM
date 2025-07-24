package com.hq.acdm.dao.timer.DailyRunWay;

import com.hq.acdm.model.timer.DailyRunWay.DailyRunWay;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/13 0013 16:59
 */
public interface DailyRunWayMapper {
    int insertDRWA();
    int insertDRWD();
    int insertCondition(@Param("params") Map<String,Object> map);
    List<DailyRunWay> queryDRW();
    List<DailyRunWay> queryLastest();
    List<DailyRunWay> queryByConditionIfExist(@Param("params") Map<String,Object> map);
    int updateDailyRunWay(DailyRunWay dailyRunWay);
    List<DailyRunWay> queryLastDailyRunWay();
    List<DailyRunWay> queryTodayDailyRunWay();
}
