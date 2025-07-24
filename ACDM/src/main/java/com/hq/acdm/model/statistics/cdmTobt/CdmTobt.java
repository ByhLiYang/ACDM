package com.hq.acdm.model.statistics.cdmTobt;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class CdmTobt {


    //日期
    private String operational_date;
    //航空公司
    private String AIRLINE_CODE_IATA;
    //执行航班数
    private int executeCount;
    //旅行正常率
    private String executeRate;
    //超时航班
    private int overFlight;

    //起点航班
    private int startFlight;
    //正常起点航班
    private int normalStartFlight;
    //正常非起点航班
    private int normalOverFlight;

    private int tobt_Ardt;
    //tobt遵从度
    private String tobtRate;

    private int cobt_Ardt;

    //cobt遵从度
    private String cobtRate;
    //cobt执行
    private String cobt;

    private int cobt_Aodt;
    private int cobt_Aobt;


    private int a_tobt_ardt;
    //a_tobt遵从度
    private String a_tobtRate;

}