package com.hq.acdm.service.effectAnalysis;

import com.hq.acdm.vo.effectAnalysis.DelayReasonVo;
import com.hq.acdm.vo.effectAnalysis.DelayedAnlssVo;
import com.hq.acdm.vo.effectAnalysis.TAtcDelayStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface DelayedAnlssService {
    //查询延误分析
    List<DelayedAnlssVo> selectDelayedAnlssByDate(@Param("params") Map params);
    //查询历史延误分析
    List<DelayedAnlssVo> selectDelayedAnlssByDateHistory(@Param("params") Map params);
    //根据离港标识更新延误原因，原因类型，原因反馈单位
    int updateReason(DelayedAnlssVo record);
    //查询延误延误原因列表
    List<DelayReasonVo> selectDelayedReason(@Param("params") Map params);
    //查询延误航班统计
    List<TAtcDelayStatistics> selectDelayedReasonforCTOT(@Param("params") Map params);
    //根据航班id更新ATC延误航班原因
    int updateATCReason(TAtcDelayStatistics record);
}
