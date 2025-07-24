package com.hq.acdm.service.effectAnalysis;

import com.hq.acdm.vo.dynamicFlight.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface FltHistoryMonitorService {
    /**
     * 获取所有航班公司
     * @return
     */
    public List<String> findAllCompany();
    //机场三字码
    public List<String> findAllAirCode();
    //获取所有航班列表
    public List<TLocalFlightInfoVo> findFltInfo(@Param("params") Map params);
    //根据航班唯一标识查询所有对应的流控信息
    public List<TControlInfoVo> findAllControlInfo(@Param("params") Map params);
    //航班详细信息
    public List<FlightDetailsInfoVo> findFlightDetails(@Param("params") Map params);
    //航班详细信息
    public List<FlightDetailsGuestInfoVo> findFlightPassenger(@Param("params") Map params);
    //航班鱼骨图详细信息
    Map<String,Object> findFishboneDiagramInfo(@Param("params") Map params);
    //鱼骨图节点对应字段信息
    List<FishboneDiagramVo> findNodeConfigColumnInfo();
    //航班事件查询
    FlightEventReturnVo findFlightEvent(@Param("params") Map params);
    //航班监控预设字段查询
    List<PresetFieldJKVo> findPresetFieldJK(@Param("params") Map params);
    //保存预设字段
    int insertPresetFieldJK(@Param("params") Map params);
    //获取所有航班列表不时间格式化
    public List<TLocalFlightInfoVo> findFltInfoNoDateFormat(@Param("params") Map params);
}
