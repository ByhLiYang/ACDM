package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.flightEveryDay.FlightEveryDayModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2019/1/10 0010 13:50
 */
public interface FlightEveryDayMapper {
    List<FlightEveryDayModel> queryByDate(@Param("params")Map<String,Object> map);
}
