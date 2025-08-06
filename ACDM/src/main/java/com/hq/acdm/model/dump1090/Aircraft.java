package com.hq.acdm.model.dump1090;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Aircraft {
    // ID
    private String id;
    // 飞机唯一标识
    private String hex;
    // 航班号
    private String flight;
    // 纬度
    private BigDecimal lat;
    // 经度
    private BigDecimal lon;
    // 高度（英尺）
    private Integer altitude;
    // 航向
    private Integer track;
    // 速度（节）
    private Integer speed;
    // 创建时间
    private Date createTm;
    // 更新时间
    private Date updateTm;
}
