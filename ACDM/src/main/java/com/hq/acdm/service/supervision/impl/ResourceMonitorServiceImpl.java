package com.hq.acdm.service.supervision.impl;

import com.hq.acdm.dao.supervision.RecourceMonitorMapper;
import com.hq.acdm.service.supervision.ResourceMonitorService;
import com.hq.acdm.vo.supervision.ResourceMonitor.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/11/12 10:08
 * @Description
 */
@Service
public class ResourceMonitorServiceImpl implements ResourceMonitorService {
    @Resource
    private RecourceMonitorMapper recourceMonitorMapper;
    @Override
    public List<CurBoardingRateVo> findCurBoardingRate() {
        return recourceMonitorMapper.findCurBoardingRate();
    }

    @Override
    public List<DelayListVo> findDelayList() {
        return recourceMonitorMapper.findDelayList();
    }

    @Override
    public List<DelayListDescVo> findDelayListDesc() {
        return recourceMonitorMapper.findDelayListDesc();
    }

    @Override
    public List<StandConflictVo> findConflictAlarm() {
        return recourceMonitorMapper.findConflictAlarm();
    }

    @Override
    public int findConflictAlarmCount() {
        return recourceMonitorMapper.findConflictAlarmCount();
    }

    @Override
    public List<FreeStandVo> findFreeStand() {
        return recourceMonitorMapper.findFreeStand();
    }

    @Override
    public int findFreeStandCount() {
        return recourceMonitorMapper.findFreeStandCount();
    }
}
