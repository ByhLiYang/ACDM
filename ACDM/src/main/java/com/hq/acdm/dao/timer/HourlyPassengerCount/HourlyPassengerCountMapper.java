package com.hq.acdm.dao.timer.HourlyPassengerCount;

import com.hq.acdm.model.timer.HourlyPassengerCount.initialData;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/8 0008 16:43
 */
public interface HourlyPassengerCountMapper {
    int updateHourlyPassengerCountT1();
    int updateHourlyPassengerCountT2();
    int initialHourlyPassengerCount(List<initialData> list);
    Map<String,BigDecimal> queryHourlyPassengerCount();
}
