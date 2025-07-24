package com.hq.acdm.dao.supervision;

import com.hq.acdm.vo.supervision.ResourceMonitor.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/11/08 10:49
 * @Description
 */
public interface RecourceMonitorMapper {
    @Select({"select 类别 type,T1,T2 from V_CURBOARDINGRATE"})
    List<CurBoardingRateVo> findCurBoardingRate();
    @Select({"select FLIGHT_NO_IATA flightNo,DEST_AIRPORT_IATA destAirport,SOBT,OPERATIONAL_DATE flightDate,PAX_NUM paxNum,DELAY_TIME delayTime from V_FLIGHT_DELAY_DEPARTURE_MORE"})
    List<DelayListVo> findDelayList();
    @Select({"select \"目的地/经停站\" airport, 滞留航班数 delayFlight, 旅客数 delayPassenger, round(substr(延误率,0,instr(延误率,'%',1,1)-1),2)||'%'  delayRate, round(平均滞留时间,2) delayAverage from V_DAILY_FLIGHT_DELAY_DESC"})
    List<DelayListDescVo> findDelayListDesc();
    @Select({"select 机位号 stand,预计冲突时间 conflictTime from V_ALARM_STAND_CONFLICT_ALL"})
    List<StandConflictVo> findConflictAlarm();
    @Select({"select count(*) from V_ALARM_STAND_CONFLICT_ALL"})
    int findConflictAlarmCount();
    @Select({"select AA.DESCRIPTION,AA.T1,BB.T2,AA.STANDS from (" +
            "select ta.DESCRIPTION,ta.STANDS T1,tb.STANDS from V_FREESTAND_SUM ta left join V_FREESTAND_GROUP tb on ta.DESCRIPTION=tb.DESCRIPTION where ta.TERMINAL='1') AA left join (" +
            "select ta.STANDS T2,ta.DESCRIPTION from V_FREESTAND_SUM ta left join V_FREESTAND_GROUP tb on ta.DESCRIPTION=tb.DESCRIPTION where ta.TERMINAL='2') BB " +
            "on AA.DESCRIPTION=BB.DESCRIPTION"})
    List<FreeStandVo> findFreeStand();
    @Select({"select sum(STANDS) from V_FREESTAND_SUM"})
    int findFreeStandCount();
}
