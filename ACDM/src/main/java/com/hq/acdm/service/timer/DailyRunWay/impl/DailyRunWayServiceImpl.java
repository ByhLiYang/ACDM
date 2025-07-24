package com.hq.acdm.service.timer.DailyRunWay.impl;

import com.hq.acdm.dao.flight.DailyFlightMasterMapper;
import com.hq.acdm.dao.timer.DailyRunWay.DailyRunWayMapper;
import com.hq.acdm.dao.timer.Historical_Flight_Master.HistoricalFlightMasterMapper;
import com.hq.acdm.model.timer.DailyRunWay.DailyRunWay;
import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightMaster;
import com.hq.acdm.service.timer.DailyRunWay.DailyRunWayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 8:45
 */
@Service("DailyRunWayService")
public class DailyRunWayServiceImpl implements DailyRunWayService {
    @Resource
    private DailyRunWayMapper dailyRunWayMapper;
    @Resource
    private HistoricalFlightMasterMapper historicalFlightMasterMapper;
    @Override
    public int insertDRWA() {
        return dailyRunWayMapper.insertDRWA();
    }

    @Override
    public int insertDRWD() {
        return dailyRunWayMapper.insertDRWD();
    }

    @Override
    public int insertCondition(Map<String, Object> map) {
        return dailyRunWayMapper.insertCondition(map);
    }

    @Override
    public List<DailyRunWay> queryDRW() {
        return dailyRunWayMapper.queryDRW();
    }

    @Override
    public List<DailyRunWay> queryLastest() {
        return dailyRunWayMapper.queryLastest();
    }

    @Override
    public List<DailyFlightMaster> queryLatestRWY() {
        return historicalFlightMasterMapper.queryLatestRWY();
    }

    @Override
    public List<DailyRunWay> queryByConditionIfExist(Map<String, Object> map) {
        return dailyRunWayMapper.queryByConditionIfExist(map);
    }

    @Override
    public int updateDailyRunWay(DailyRunWay dailyRunWay) {
        return dailyRunWayMapper.updateDailyRunWay(dailyRunWay);
    }

    @Override
    public List<DailyRunWay> queryLastDailyRunWay() {
        return dailyRunWayMapper.queryLastDailyRunWay();
    }

    @Override
    public List<DailyRunWay> queryTodayDailyRunWay() {
        return dailyRunWayMapper.queryTodayDailyRunWay();
    }
}
