package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.vo.realtimeSituation.HBSPerHour;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:38
 * @Description
 */
public interface FlightChartMapper {
    List<HBSPerHour> getAJHSPerHour(@Param("params") Map params);
    List<HBSPerHour> getASJSPerHour(@Param("params") Map params);
    List<HBSPerHour> getDJHSPerHour(@Param("params") Map params);
    List<HBSPerHour> getDSJSPerHour(@Param("params") Map params);
}
