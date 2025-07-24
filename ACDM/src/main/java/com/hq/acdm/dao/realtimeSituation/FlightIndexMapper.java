package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.vo.realtimeSituation.FlightHandTerminalVo;
import com.hq.acdm.vo.realtimeSituation.FltDetailIdxVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/31 23:57
 * @Description
 */
public interface FlightIndexMapper {
    int getZCS(@Param("params") Map params);
    int getZCSA(@Param("params") Map params);
    int getZCSD(@Param("params") Map params);
    int getFHSA(@Param("params") Map params);
    int getBJSA(@Param("params") Map params);
    int getFHSD(@Param("params") Map params);
    int getBJSD(@Param("params") Map params);
    int getYWS(@Param("params") Map params);
    int getYWSA(@Param("params") Map params);
    int getFXYWS(@Param("params") Map params);
    int getQXS(@Param("params") Map params);
    int getQXSA(@Param("params") Map params);
    int getQXSD(@Param("params") Map params);
    int getETA30(@Param("params") Map params);
    int getLDHX(@Param("params") Map params);
    int getDMBZ(@Param("params") Map params);
    int getZBJX(@Param("params") Map params);
    int getLGHX(@Param("params") Map params);
    int getZYJW(@Param("params") Map params);
    int getJWZS(@Param("params") Map params);
    double getKQL(@Param("params") Map params);
    int getZHB(@Param("params") Map params);
    int getLK(@Param("params") Map params);
    int getXL(@Param("params") Map params);
    double getJGZXL(@Param("params") Map params);
    String getGMZDL(@Param("params") Map params);
    double getCGZXL(@Param("params") Map params);
    FltDetailIdxVo getAGNDetails(@Param("params") Map params);
    FltDetailIdxVo getAGJDetails(@Param("params") Map params);
    FltDetailIdxVo getADQDetails(@Param("params") Map params);
    FltDetailIdxVo getAHHDetails(@Param("params") Map params);
    FltDetailIdxVo getAHJDetails(@Param("params") Map params);
    FltDetailIdxVo getDGNDetails(@Param("params") Map params);
    FltDetailIdxVo getDGJDetails(@Param("params") Map params);
    FltDetailIdxVo getDDQDetails(@Param("params") Map params);
    FltDetailIdxVo getDHHDetails(@Param("params") Map params);
    FltDetailIdxVo getDHJDetails(@Param("params") Map params);
    FlightHandTerminalVo getFltToHandTerminal(@Param("params") Map params);
    FlightHandTerminalVo findFltJGS(@Param("params") Map params);
    FlightHandTerminalVo findFltCGS(@Param("params") Map params);
    FlightHandTerminalVo findFltCountByAttribute(@Param("params") Map params);

}
