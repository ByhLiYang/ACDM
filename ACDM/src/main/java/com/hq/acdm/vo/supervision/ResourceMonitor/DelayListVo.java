package com.hq.acdm.vo.supervision.ResourceMonitor;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2018/11/11 17:32
 * @Description
 */
@Data
public class DelayListVo {
    private String flightNo;
    private String destAirport;
    private String sobt;
    private String flightDate;
    private String paxNum;
    private String delayTime;
}
