package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.vo.realtimeSituation.SpecialSafeguardVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface SpecialSafeguardMapper {
    /**查询所有特殊保障航班信息
     * @param params
     * @return
     */
    List<SpecialSafeguardVo> findSpecialFltInfo(@Param("params") Map params);

    //查询放行临界延误临界告警信息
    List<String> findFlightCaveatInfo(@Param("params") Map params);

}
