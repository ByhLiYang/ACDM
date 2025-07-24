package com.hq.acdm.dao.dynamicFlight;

import com.hq.acdm.model.realtimeSituation.TDelayCoordination;
import com.hq.acdm.vo.dynamicFlight.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:38
 * @Description
 */
public interface FltSituationMapper {

    //查询航班动态航班态势临界落地
    List<CriticalFltAVo> getCriticalFltA();
    //临界航班(已关舱门)
    List<CriticalFltRlsVo> getCriticalFltRls(@Param("params") Map params);
    //临界航班(未关舱门)
    List<CriticalFltRlsVo> getCriticalFltRlsOpen(@Param("params") Map params);
    //机上等待
    List<CriticalFltRlsVo> getCriticalFltIWt(@Param("params") Map params);
    //查询航班动态航班态势临界起飞
    List<CriticalFltDVo> getCriticalFltD();
    //航班关注
    int updateFlightFocus(@Param("params") Map params);
    //查询航班时间轴
    List<FltSchedulingVo> getFltScheduling();
    //查询航班时间轴Ctot
    public List<FltTimeAxisVo> getFltTimeAxis(@Param("params") Map params);
    //查询航班时间轴Tobt
    public List<FltTimeAxisVo> getFltTimeAxisTobt(@Param("params") Map params);
    TCoordinatedDisposal selectByFlid(@Param("id") String id);
    int insertCDSelective(TCoordinatedDisposal record);
    int updateCDByPrimaryKeySelective(TCoordinatedDisposal record);
    //查询今日有效航班id
    public List<ControlInfoVo> findControlId(@Param("params") Map params);
    //修改航班时间轴
    int updateTimeAxis(@Param("params") Map params);
    //查询航班时间轴区分相同时间
    List<FltSchedulingVo> getFltSchedulingByTime();
    //小延误协调
    List<DelayCoordinationVo> getDelayCoordinationInfo(@Param("params") Map params);
    //协调完成（TOBT大于COBT）
    List<DelayCoordinationVo> getTobtToCobtInfo(@Param("params") Map params);
    //小延误协调数据查询
    List<TDelayCoordination> findDelayCoordinationInfo(@Param("params") Map params);
    //查询协调延误统计数据信息
    List<CoordinationDelayCountVo> findCoordinationDelayCountInfo(@Param("params") Map params);
    //修改小延误表TDelayCoordination流量控制原因，协调单位和内容，协调员
    int updateTDelayCoordinationContent(@Param("params") Map params);
}
