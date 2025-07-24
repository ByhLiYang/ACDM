package com.hq.acdm.service.timer.HourlyPassengerCount;

import com.hq.acdm.model.timer.HourlyPassengerCount.initialData;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/8 0008 16:39
 */
public interface HourlyPassengerCountService {
    int updateHourlyPassengerCountT1();
    int updateHourlyPassengerCountT2();
    int initialHourlyPassengerCount(@Param("params")List<initialData> list);
    Map<String,BigDecimal> queryHourlyPassengerCount();
}
