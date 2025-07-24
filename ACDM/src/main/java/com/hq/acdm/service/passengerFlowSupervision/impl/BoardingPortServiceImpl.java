package com.hq.acdm.service.passengerFlowSupervision.impl;

import com.hq.acdm.dao.passengerFlowSupervision.BoardingPortMapper;
import com.hq.acdm.model.passengerFlowSupervision.HourlyPassengerCountT2;
import com.hq.acdm.service.passengerFlowSupervision.BoardingPortService;
import com.hq.acdm.model.passengerFlowSupervision.BoardingPort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/10/23 16:49
 * @Description
 */
@Service("BoardingPortService")
public class BoardingPortServiceImpl implements BoardingPortService {
    @Resource
    private BoardingPortMapper boardingPortMapper;
    @Override
    public List<BoardingPort> findGatePassengerSumT1() {
        return boardingPortMapper.findGatePassengerSumT1();
    }
    @Override
    public List<BoardingPort> findGatePassengerSumT2() {
        return boardingPortMapper.findGatePassengerSumT2();
    }

}
