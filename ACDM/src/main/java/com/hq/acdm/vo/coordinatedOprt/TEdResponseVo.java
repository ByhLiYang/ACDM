package com.hq.acdm.vo.coordinatedOprt;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TEdResponseVo {
    private String id;

    private String edId;

    private String level;

    private String factorsPeriod;

    private String descendCapacity;

    private String curdatePlana;

    private String curdatePland;

    private String curtimePlana;

    private String curtimePland;

    private String executedA;

    private String executedD;

    private String canceledA;

    private String canceledD;

    private String returnAlternate;

    private String hourPlana;

    private String hourActuala;

    private String hourPland;

    private String hourActuald;

    private String freeStand;

    private String delayRatio;

    private String delayFlno;

    private String dclsRatio;

    private String dclsFlno;

    private String executiveCdtn;

    private String specialPlane;

    private String terminalOrder;

    private String mattersCoordinated;

    private String otherSpecial;

    private String curdateManager;

    private String curdateManagerPhone;

    private String curdateApmng;

    private String curdateApmngPhone;

    private String preparer;

    private String fillingTime;

    private String cutoffTime;

    private String remark;

    private String createTime;

    private String updateTime;

}