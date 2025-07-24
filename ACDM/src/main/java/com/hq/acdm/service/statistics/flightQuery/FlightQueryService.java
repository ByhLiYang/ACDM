package com.hq.acdm.service.statistics.flightQuery;

import com.hq.acdm.model.statistics.flightQuery.FlightQueryResult;
import com.hq.acdm.model.statistics.flightQuery.Location;
import com.hq.acdm.model.statistics.flightQuery.ReduceCalculateResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/10/17 0017 9:32
 */
public interface FlightQueryService {
    List<Map<String,Object>> getDetail();
    List<Map<String,Object>> getCount();
    //查询始发站和下拉框
    List<Location> get_location();
    List<FlightQueryResult> queryWithoutAORD(Map params);
    List<FlightQueryResult> queryWithAORD(Map params);
    List<ReduceCalculateResult> xuejianA(Map params);
    List<ReduceCalculateResult> xuejianD(Map params);
}
