package com.hq.acdm.model.statistics.maintenanceMachinePosition;

import lombok.Data;

/**
 * 机位所有记录
 */
@Data
public class CameraStand {

    private String STAND;//机位号
    private String TERMINAL;// 航站楼
    private String TYPE;//机位类型
    private String STATUS_START;// 维护开始时间
    private String STATUS_END;// 维护结束时间
    private String STATUS_REASON;//维护原因
}
