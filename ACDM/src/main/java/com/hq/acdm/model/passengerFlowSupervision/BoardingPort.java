package com.hq.acdm.model.passengerFlowSupervision;

import lombok.Getter;
import lombok.Setter;

/**
 * @author LiFaQiang
 * @date 2018/10/23 15:36
 * @Description
 */
@Getter
@Setter
public class BoardingPort {
    private String gate;
    private String flightNum;
    private String paxSecurityareaSum;
    private String cOBT;
}
