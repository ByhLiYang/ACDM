package com.hq.acdm.service.effectAnalysis;

import com.hq.acdm.vo.dynamicFlight.FishboneDiagramVo;
import com.hq.acdm.vo.dynamicFlight.FlightDetailsInfoVo;
import com.hq.acdm.vo.dynamicFlight.TControlInfoVo;
import com.hq.acdm.vo.dynamicFlight.TLocalFlightInfoVo;
import com.hq.acdm.vo.effectAnalysis.FltDelayTypeVo;
import com.hq.acdm.vo.effectAnalysis.FltDelayVo;
import com.hq.acdm.vo.effectAnalysis.InsufficientTTTVo;
import com.hq.acdm.vo.effectAnalysis.LlgkVo;
import com.hq.acdm.vo.realtimeSituation.FlightBackVo;
import com.hq.acdm.vo.realtimeSituation.FltDetailIdxVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface InsufficientTTTService {
    //查询过站不足
    List<InsufficientTTTVo> selectGZBZ(@Param("params") Map params);
    //查询历史过站不足
    List<InsufficientTTTVo> selectGZBZHis(@Param("params") Map params);
    //始发正常性
    double getFltNormIdxByD(@Param("params") Map params);
    //进港正常性
    double getFltNormIdxByA(@Param("params") Map params);
    //出港国内国际
    FltDetailIdxVo getDGNDetails(@Param("params") Map params);
    FltDetailIdxVo getDGJDetails(@Param("params") Map params);
    //进港国内国际
    FltDetailIdxVo getAGNDetails(@Param("params") Map params);
    FltDetailIdxVo getAGJDetails(@Param("params") Map params);
    FltDelayVo selectFltDelay();

    List<FltDelayTypeVo> selectYWType();

    //得到当天所有符合条件的航班
    LlgkVo getAllFlightD(@Param("params") Map params);
    //得到当天所有符合条件的航班
    LlgkVo getAllFlightA(@Param("params") Map params);
}
