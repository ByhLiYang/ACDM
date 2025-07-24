package com.hq.acdm.service.passengerFlowSupervision;

import com.hq.acdm.model.passengerFlowSupervision.BoardingPort;
import com.hq.acdm.model.passengerFlowSupervision.HourlyPassengerCountT2;
import com.hq.acdm.model.passengerFlowSupervision.HourlyPassengerCountT2;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/10/23 16:48
 * @Description
 */
public interface BoardingPortService {
    List<BoardingPort> findGatePassengerSumT1();
    List<BoardingPort> findGatePassengerSumT2();

}
