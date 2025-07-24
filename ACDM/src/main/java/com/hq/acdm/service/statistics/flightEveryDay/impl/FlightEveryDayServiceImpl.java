package com.hq.acdm.service.statistics.flightEveryDay.impl;

import com.hq.acdm.dao.statistics.FlightEveryDayMapper;
import com.hq.acdm.model.statistics.flightEveryDay.FlightEveryDayModel;
import com.hq.acdm.service.statistics.flightEveryDay.FlightEveryDaySevice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2019/1/10 0010 13:53
 */
@Service("FlightEveryDayService")
public class FlightEveryDayServiceImpl implements FlightEveryDaySevice {
    @Resource
    private FlightEveryDayMapper flightEveryDayMapper;
    @Override
    public List<FlightEveryDayModel> queryByDate(Map<String, Object> map) {
        return flightEveryDayMapper.queryByDate(map);
    }
}
