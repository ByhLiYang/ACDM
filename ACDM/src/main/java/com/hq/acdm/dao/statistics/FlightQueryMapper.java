package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.flightQuery.FlightQueryResult;
import com.hq.acdm.model.statistics.flightQuery.Location;
import com.hq.acdm.model.statistics.flightQuery.ReduceCalculateResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/10/17 0017 9:31
 */
public interface FlightQueryMapper {
    List<Map<String,Object>> getDetail();
    List<Map<String,Object>> getCount();
    //查询始发站和下拉框
    List<Location> get_location();
    List<FlightQueryResult> queryWithoutAORD(@Param("params")Map params);
    List<FlightQueryResult> queryWithAORD(@Param("params")Map params);
    List<ReduceCalculateResult> xuejianA(@Param("params")Map params);
    List<ReduceCalculateResult> xuejianD(@Param("params")Map params);
}
