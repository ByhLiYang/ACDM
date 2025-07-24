package com.hq.acdm.model.monitoring.position;

import lombok.Getter;
import lombok.Setter;

/** 可使用机位
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class availablePosition {//登机口使用明细
    private String AIRLINE_CODE_IATA;//航空公司
    private String OPERATIONAL_DATE;//计划日期

    //登机口
    private String GAGE;
    //COBT
    private String COBT;
    //日期时间
    private String SOBT;

    //使用次数
     private String USEDTIMES;

    private String STAND;
    //使用时间
    private String TIMESUM;

}