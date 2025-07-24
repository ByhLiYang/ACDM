package com.hq.acdm.model.statistics.flightQuery;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/11/26 0026 16:46
 */
@Getter
@Setter
public class ReduceModel {
    private String FLIGHT_NO_IATA;
    private String OPERATIONAL_DATE;
    private String A_OR_D;
    private String OPERATIONAL_USER;
    private String OPERATIONAL_FLAG;
    private String OPERATE_TIME;
    private String DA;
    private String OA;
}
