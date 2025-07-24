package com.hq.acdm.dao.effectAnalysis;

import com.hq.acdm.vo.dynamicFlight.FishboneDiagramVo;
import com.hq.acdm.vo.dynamicFlight.FlightDetailsInfoVo;
import com.hq.acdm.vo.dynamicFlight.TControlInfoVo;
import com.hq.acdm.vo.dynamicFlight.TLocalFlightInfoVo;
import com.hq.acdm.vo.effectAnalysis.FltDelayTypeVo;
import com.hq.acdm.vo.effectAnalysis.InsufficientTTTVo;
import com.hq.acdm.vo.realtimeSituation.FlightBackAVo;
import com.hq.acdm.vo.realtimeSituation.FlightBackVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:38
 * @Description
 */
public interface InsufficientTTTMapper {

    //查询过站不足
    List<InsufficientTTTVo> selectGZBZ(@Param("params") Map params);
    //查询历史过站不足
    List<InsufficientTTTVo> selectGZBZHis(@Param("params") Map params);
    //始发正常性
    double getFltNormIdxByD(@Param("params") Map params);
    //进港正常性
    double getFltNormIdxByA(@Param("params") Map params);

    int selectYWYWSC();
    int selectYW015();
    int selectYW1530();
    int selectYW3060();
    int selectYW60120();
    int selectYW120();
    List<FltDelayTypeVo> selectYWType();

    //得到当天所有符合条件的航班
    List<FlightBackVo> getAllFlightD(@Param("params") Map params);
    //得到当天所有符合条件的航班
    List<FlightBackAVo> getAllFlightA(@Param("params") Map params);
}
