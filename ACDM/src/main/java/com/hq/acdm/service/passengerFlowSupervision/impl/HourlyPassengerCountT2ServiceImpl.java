package com.hq.acdm.service.passengerFlowSupervision.impl;

import com.hq.acdm.dao.passengerFlowSupervision.HourlyPassengerCountT2Mapper;
import com.hq.acdm.model.passengerFlowSupervision.HourlyPassengerCountT2;
import com.hq.acdm.service.passengerFlowSupervision.HourlyPassengerCountT2Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangshuhao
 * @date 2018/11/13 0013 9:10
 */
@Service("HourlyPassengerCountT2Service")
public class HourlyPassengerCountT2ServiceImpl implements HourlyPassengerCountT2Service{
    @Resource
    private HourlyPassengerCountT2Mapper hourlyPassengerCountT2Mapper;
    @Override
    public List<HourlyPassengerCountT2> queryTerminal2() {
        return hourlyPassengerCountT2Mapper.queryTerminal2();
    }
}
