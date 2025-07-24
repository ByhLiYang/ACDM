package com.hq.acdm.service.realtimeSituation;

import com.hq.acdm.vo.realtimeSituation.SpecialSafeguardVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface SpecialSafeguardService {

    //获取特殊航班信息
    public List<SpecialSafeguardVo> findSpecialFltInfo(@Param("params")Map params);

    //查询流控信息（T_MDRS表信息）
    List<String> findTMdrsInfo(@Param("params") Map params);

    //查询放行临界延误临界告警信息
    List<String> findFlightCaveatInfo(@Param("params") Map params);

}
