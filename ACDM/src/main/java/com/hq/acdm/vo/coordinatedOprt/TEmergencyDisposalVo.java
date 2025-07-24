package com.hq.acdm.vo.coordinatedOprt;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TEmergencyDisposalVo {
    private String id;

    private String level;

    private String startTime;

    private String endTime;

    private String reason;

    private String remark;

}