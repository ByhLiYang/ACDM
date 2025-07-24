package com.hq.acdm.vo.index;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2018/11/16 15:27
 * @Description
 */
@Data
public class SceneMoniterVo {
    private String flightSum;
    private String arrival;
    private String departure;
    private String inland;
    private String international;
    private String normalRateA;
    private String normalRateD;
    private String freeStandT1;
    private String freeStandT2;
    private String reversal;
}
