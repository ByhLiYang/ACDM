package com.hq.acdm.vo.coordinatedOprt;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TEdWarningVo {
    private String id;

    private String edId;

    private String level;

    private String factorsPeriod;

    private String descendCapacity;

    private String isCoordinated;

    private String isScheduleAdjustmnet;

    private String adjustPeriod;

    private String adjustRatio;

    private String originalPlanGs;

    private String originalPlanMu;

    private String originalPlanCz;

    private String originalPlanCa;

    private String originalPlanBk;

    private String originalPlanHj;

    private String adjustPlanGs;

    private String adjustPlanMu;

    private String adjustPlanCz;

    private String adjustPlanCa;

    private String adjustPlanBk;

    private String adjustPlanHj;

    private String adjustedGs;

    private String adjustedMu;

    private String adjustedCz;

    private String adjustedCa;

    private String adjustedBk;

    private String adjustedHj;

    private String adjustedPlanSum;

    private String adjustedPlandSum;

    private String adjustedPlanaSum;

    private String specialPlane;

    private String mattersCoordinated;

    private String otherSpecial;

    private String ndManager;

    private String ndManagerPhone;

    private String ndApmng;

    private String ndApmngPhone;

    private String preparer;

    private String fillingTime;

    private String cutoffTime;

    private String remark;

    private String createTime;

    private String updateTime;

}