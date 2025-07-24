package com.hq.acdm.service.effectAnalysis;

import com.hq.acdm.vo.effectAnalysis.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface SmallDelayAnalysisService {

    List<SmallDelayAnalysisVo> findSmallDelayInfo(@Param("params") Map params);

    List<SmallDelaySumVo> findSmallDelaySum(@Param("params") Map params);

    List<SmallDelaySumVo> findSmallDelayInfoByAdes(@Param("params") Map params);

    List<SmallDelayNameValueVo> findSmallDelayInfoByCraftTypeIcao(@Param("params") Map params);

    List<SmallDelayNameValueVo> findSmallDelayInfoByAirlines(@Param("params") Map params);

    List<SmallDelayAnalysisVo> findSmallDelayInfoByTimeSegment(@Param("params") Map params);

    Map<String,Object> findSmallDelayAllInfo(@Param("params") Map params);

    Map<String,Object> findSmallDelayAllInfoByAdes(@Param("params") Map params);

    Map<String,Object> findSmallDelayDetails(@Param("params") Map params);

    List<SmallDelayAdesVo> findSmallDelayAdes(@Param("params") Map params);

}
