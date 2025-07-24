package com.hq.acdm.vo.passengerFlowSupervision;

import lombok.Data;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/10/25 13:55
 * @Description
 */
@Data
public class BoardingPortVo {
    private String gate;
    private List<String> flightNum;
    private List<String> paxSecurityareaSum;
    private List<String> cOBT;
}
