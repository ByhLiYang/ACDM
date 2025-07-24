package com.hq.acdm.vo.coordinatedOprt;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TEdDynTaskVo {
    private String id;

    private String edId;

    private String taskName;

    private String startTime;

    private String endTime;

    private Boolean isfinished;

    private String remark;

    private String createTime;

    private String updateTime;

}