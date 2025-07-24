package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.vo.realtimeSituation.FltRlsIdxVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/04/15 01:56
 * @Description
 */
public interface FltRlsIdxMapper {
    double getFltRlsIdx(@Param("params") Map params);
    double getFltNormIdx(@Param("params") Map params);
    double getFltRlsIdxByApts( String[] airports);
    double getFltRlsIdxByApt(@Param("params") Map params);
}
