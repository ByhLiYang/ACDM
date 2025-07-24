package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.vo.realtimeSituation.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/04/15 01:56
 * @Description
 */
public interface FlightDelayMapper {
    //延误态势放行正常率
    FlightDelayVo getDelayRlsIdx(@Param("params") Map params);
    //延误态势放行率
    FlightDelayVo getFXL(@Param("params") Map params);
    //延误态势正常率
    FlightDelayVo getZCL(@Param("params") Map params);
    //延误态势旅客滞留数
    FlightDelayVo getDelayZL(@Param("params") Map params);
    //延误时间段次数
    FDelayVo getDelayTimeCount(@Param("params") Map params);
    //西一指廊每小时延误人数
    List<HBSPerHour> getWDelayHourCount();
    //西2指廊每小时延误人数
    List<HBSPerHour> getWDelayHourCount2();
    //东一指廊每小时延误人数
    List<HBSPerHour> getEDelayHourCount();
    //东2指廊每小时延误人数
    List<HBSPerHour> getEDelayHourCount2();
    //得到当天所有符合条件的航班
    List<FlightBackVo> getAllFlight();
    //旅客热力分布
    List<TmdmcDgrmVo> getTmdmcDgrm();
    //旅客热力分布，楼层
    int getPsgCountByFloor(@Param("floor") String floor);
    //每小时平均等待分钟
    List<HBSPerHour> getAvgWaitTime();
    //各航司滞留旅客占比率
    FlightDelayVo getDelayRetentionP(@Param("params") Map params);
    //查询机位占用时间范围
    List<FltDelayStartEndTimeVo> findStandStartEndTime();
    //查询跑道承载进港数据
    List<FltDelayTimeAndNumVo> findRunwayInfoA();
    //查询跑道承载出港数据
    List<FltDelayTimeAndNumVo> findRunwayInfoD();
    //查询航站楼承载时间范围
    List<FltDelayStartEndTimeVo> findTerminalBuilding();

}
