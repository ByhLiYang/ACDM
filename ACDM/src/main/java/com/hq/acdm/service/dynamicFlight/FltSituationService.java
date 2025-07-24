package com.hq.acdm.service.dynamicFlight;

import com.hq.acdm.model.realtimeSituation.TDelayCoordination;
import com.hq.acdm.vo.dynamicFlight.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface FltSituationService {

    //航班动态航班态势临界落地
    public List<CriticalFltAVo> findCriticalFltA();
    //临界航班(已关舱门)
    List<CriticalFltRlsVo> findCriticalFltRls(Map params);
    //临界航班(未关舱门)
    List<CriticalFltRlsVo> findCriticalFltRlsOpen(@Param("params") Map params);
    //机上等待
    List<CriticalFltRlsVo> findCriticalFltIWt(Map params);
    //航班动态航班态势临界起飞
    public List<CriticalFltDVo> findCriticalFltD();
    //航班关注
    public int updateFlightFocus(@Param("params") Map params);
    //查询航班时间轴
    public List<FltSchedulingVo> findFltScheduling();
    //查询航班时间轴
    public List<FltTimeAxisVo> findFltTimeAxis(@Param("params") Map params);
    //查询今日有效航班id
    public List<ControlInfoVo> findControlId(@Param("params") Map params);
    //修改航班时间轴
    int updateTimeAxis(@Param("params") Map params);
    //查询航班时间轴Tobt
    public List<FltTimeAxisVo> findFltTimeAxisTobt(@Param("params") Map params);
    TCoordinatedDisposal selectByFlid(String id);
    int insertCDSelective(TCoordinatedDisposal record);
    int updateCDByPrimaryKeySelective(TCoordinatedDisposal record);
    //查询航班时间轴区分相同时间
    public List<FltSchedulingVo> findFltSchedulingByTime();
    //小延误协调
    public List<DelayCoordinationVo> findDelayCoordinationInfo(@Param("params") Map params);
    //协调完成（以前方法TOBT大于COBT）
    public List<DelayCoordinationVo> findTobtToCobtInfo(@Param("params") Map params);
    //小延误协调数据查询
    public List<TDelayCoordination> selectDelayCoordinationInfo(@Param("params") Map params);
    //保存小延误协调数据
    public int insertTDelayCoordination(@Param("params")TDelayCoordination model);
    //根据航班ID查询小延误表数据
    List<TDelayCoordination> selectByFlightId(String flightId);

    String findIsCoordination(String flightId);
    String findFlightTm(String flightId);
    //航班取消协调
    int updateTDelayCoordinationState(@Param("params") Map params);
    //查询协调延误统计数据信息
    List<CoordinationDelayCountVo> findCoordinationDelayCountInfo(@Param("params") Map params);
    //修改小延误表TDelayCoordination流量控制原因，协调单位和内容，协调员
    int updateTDelayCoordinationContent(@Param("params") Map params);
}
