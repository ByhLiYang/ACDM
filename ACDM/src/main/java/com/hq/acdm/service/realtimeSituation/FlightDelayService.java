package com.hq.acdm.service.realtimeSituation;

import com.hq.acdm.vo.realtimeSituation.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/04/01 09:11
 * @Description
 */
public interface FlightDelayService {
    //延误态势放行正常率
    FlightDelayVo findDelayRlsIdx(@Param("params") Map params);
    //延误时间段次数
    FDelayVo findDelayTimeCount(@Param("params") Map params);
    //延误时间段次数
    SPassengersVo findSPassengersCount(String [] hours);
    //得到当天所有符合条件的航班
    BackVo findAllFlight(String [] hours);
    //旅客热力分布
    List<TmdmcDgrmVo> findTmdmcDgrm();
    //旅客热力分布，楼层
    int findPsgCountByFloor(@Param("floor") String floor);
    //每小时平均等待分钟
    int []  findAvgWaitTime(String [] hours);
    //各航司滞留旅客占比率
    FlightDelayVo findDelayRetentionP(@Param("params") Map params);
    //查询机位占用时间范围
    List<FltDelayStartEndTimeVo> findStandStartEndTime();
    //查询跑道承载进港数据
    List<FltDelayTimeAndNumVo> findRunwayInfoA();
    //查询跑道承载出港数据
    List<FltDelayTimeAndNumVo> findRunwayInfoD();
    //查询航站楼承载时间范围
    List<FltDelayStartEndTimeVo> findTerminalBuilding();
    //机场承载数据
    Map<String,Object> findAirportBearerInfo();

}
