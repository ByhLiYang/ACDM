package com.hq.acdm.model.statistics.baggageFlight;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class baggageFlight {

    //
    private String sibt;
    //日期
    private String operational_date;
    //航空公司
    private String AIRLINE_CODE_IATA;
    //执行航班数
    private int executeCount;
    //达标航班数
    private int normal;

    //未达标航班数
    private int unormal;
    //达标率（avg)
    private String reach;
    //未达标率
    private String unreach;

}