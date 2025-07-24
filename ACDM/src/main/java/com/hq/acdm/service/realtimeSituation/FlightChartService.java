package com.hq.acdm.service.realtimeSituation;

import com.hq.acdm.vo.realtimeSituation.HBSPerHour;
import com.hq.acdm.vo.realtimeSituation.HBSPerHourVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface FlightChartService {
    List<HBSPerHour> findAJHSPerHour(@Param("params") Map params);
    List<HBSPerHour> findASJSPerHour(@Param("params") Map params);
    List<HBSPerHour> findDJHSPerHour(@Param("params") Map params);
    List<HBSPerHour> findDSJSPerHour(@Param("params") Map params);
    HBSPerHourVo findHBSPerHour(@Param("params") Map params);
}
