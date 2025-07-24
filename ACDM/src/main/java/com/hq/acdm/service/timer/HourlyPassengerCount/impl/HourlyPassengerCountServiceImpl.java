package com.hq.acdm.service.timer.HourlyPassengerCount.impl;

import com.hq.acdm.dao.timer.HourlyPassengerCount.HourlyPassengerCountMapper;
import com.hq.acdm.model.timer.HourlyPassengerCount.initialData;
import com.hq.acdm.service.timer.HourlyPassengerCount.HourlyPassengerCountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/8 0008 16:40
 */
@Service("HourlyPassengerCountService")
public class HourlyPassengerCountServiceImpl implements HourlyPassengerCountService {
    @Resource
    private HourlyPassengerCountMapper hourlyPassengerCountMapper;
    @Override
    public int updateHourlyPassengerCountT1() {
        return hourlyPassengerCountMapper.updateHourlyPassengerCountT1();
    }

    @Override
    public int updateHourlyPassengerCountT2() {
        return hourlyPassengerCountMapper.updateHourlyPassengerCountT2();
    }

    @Override
    public int initialHourlyPassengerCount(List<initialData> list) {
        return hourlyPassengerCountMapper.initialHourlyPassengerCount(list);
    }

    @Override
    public Map<String, BigDecimal> queryHourlyPassengerCount() {
        return hourlyPassengerCountMapper.queryHourlyPassengerCount();
    }
}
