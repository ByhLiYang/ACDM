package com.hq.acdm.service.supervision;

import com.hq.acdm.vo.supervision.ResourceMonitor.*;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/11/12 10:08
 * @Description
 */
public interface ResourceMonitorService {
    List<CurBoardingRateVo> findCurBoardingRate();
    List<DelayListVo> findDelayList();
    List<DelayListDescVo> findDelayListDesc();
    List<StandConflictVo> findConflictAlarm();
    int findConflictAlarmCount();
    List<FreeStandVo> findFreeStand();
    int findFreeStandCount();
}
