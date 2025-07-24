package com.hq.acdm.service.realtimeSituation;

import com.hq.acdm.vo.realtimeSituation.FlightIndexVo;
import com.hq.acdm.vo.realtimeSituation.FlightHandTerminalVo;
import com.hq.acdm.vo.realtimeSituation.FltDetailIdxVo;
import com.hq.acdm.vo.realtimeSituation.FltRlsIdxAptVo;
import com.hq.acdm.vo.realtimeSituation.FltRlsIdxVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/04/01 09:11
 * @Description
 */
public interface FlightIndexService {
    FlightIndexVo findFlightIndex(@Param("params") Map params);
    List<FltDetailIdxVo> findAFltDetailIdx(@Param("params") Map params);
    List<FltDetailIdxVo> findDFltDetailIdx(@Param("params") Map params);
    FltRlsIdxVo findFltRlsIdx(@Param("params") Map params);
    FltRlsIdxAptVo findFltRlsIdxByApt(@Param("params") Map params);
    FlightHandTerminalVo findFltToHandTerminal(@Param("params") Map params);
    FlightHandTerminalVo findFltJGS(@Param("params") Map params);
    FlightHandTerminalVo findFltCGS(@Param("params") Map params);
    FlightHandTerminalVo findFltCountByAttribute(@Param("params") Map params);
    FlightHandTerminalVo findFltCountByDorA(@Param("params") Map params);
}
