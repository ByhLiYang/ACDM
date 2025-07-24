package com.hq.acdm.dao.effectAnalysis;

import com.hq.acdm.vo.dynamicFlight.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:38
 * @Description
 */
public interface FltHistoryMonitorMapper {
    //tony add 查询所有航班列表
    List<TLocalFlightInfoVo> getFltInfo(@Param("params") Map params);
    //查询航空公司列表
    List<String> findAllCompany();
    //查询机场三字码列表
    List<String> findAllAirCode();
    //根据航班唯一标识查询所有对应的流控信息
    List<TControlInfoVo> findAllControlInfo(@Param("params") Map params);
    //航班详细信息
    List<FlightDetailsInfoVo> findFlightDetails(@Param("params") Map params);
    //航班旅客信息
    List<FlightDetailsGuestInfoVo> findFlightPassenger(@Param("params") Map params);
    //航班鱼骨图详细信息
    Map<String,Object> findFishboneDiagramInfo(@Param("params") Map params);
    //鱼骨图节点对应字段信息
    List<FishboneDiagramVo> findNodeConfigColumnInfo();
    //航班事件查询
    List<FlightEventVo> findFlightEvent(@Param("params") Map params);
}
