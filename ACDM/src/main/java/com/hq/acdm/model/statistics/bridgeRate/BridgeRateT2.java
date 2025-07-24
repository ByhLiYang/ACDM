package com.hq.acdm.model.statistics.bridgeRate;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/9/25 0025 14:50
 */
@Setter
@Getter
public class BridgeRateT2 {
    //航空公司
    private String AIRLINE_CODE_IATA;
    //可靠
    private int S;
    //实靠
    private int K;
    //大型机实靠率
    private int DS;
    //靠桥率
    private String close_rate;
    //中文名
    private String name;
}
