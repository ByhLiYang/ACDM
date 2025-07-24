package com.hq.acdm.vo.index;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
/**
 * @author LiFaQiang
 * @date 2018/10/23 10:04
 * @Description
 */
@Setter
@Getter
public class CompanyDutyVo {
    private String id;

    private String dutyDate;

    private String hqCompanyDuty;

    private String aocManager;

    private String aocExternalManager;

    private String aocInternalManager;

    private String flightAreaDuty;

    private String operator;

    private String operateTime;

    private String operateIp;

    private String remarks;
}
