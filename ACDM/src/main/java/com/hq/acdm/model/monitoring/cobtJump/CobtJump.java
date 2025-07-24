package com.hq.acdm.model.monitoring.cobtJump;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class CobtJump {
    private String FLIGHT_NO_IATA;//航班号
    private String OPERATIONAL_DATE;//计划日期

    //进出港标识
    private String A_OR_D;
    //COBT
    private String COBT;

   //流控信息
   private String CTRLCONTENT;

   //更新时间
   private String UPDATEDATETIME;

}