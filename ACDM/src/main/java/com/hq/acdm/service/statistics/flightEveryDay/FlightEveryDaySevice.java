package com.hq.acdm.service.statistics.flightEveryDay;

import com.hq.acdm.model.statistics.flightEveryDay.FlightEveryDayModel;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2019/1/10 0010 13:53
 */
public interface FlightEveryDaySevice {
    List<FlightEveryDayModel> queryByDate(Map<String,Object> map);
}
