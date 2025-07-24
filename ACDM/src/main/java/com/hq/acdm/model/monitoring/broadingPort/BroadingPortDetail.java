package com.hq.acdm.model.monitoring.broadingPort;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class BroadingPortDetail {//登机口使用明细
    private String AIRLINE_CODE_IATA;//航空公司
    private String OPERATIONAL_DATE;//计划日期

    //登机口
    private String GATE;
    //COBT
    private String COBT;
    //日期时间
    private String SOBT;

    //使用时间
     private String USEDTIME;
    private String times;

    private String bridge_rate;//靠桥率

}