package com.hq.acdm.model.statistics.gateAreaMaintenance;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/9/27 0027 9:09
 */
@Getter
@Setter
public class GateAreaMaintenance {
    //登机口
    private String GATE;
    //登机区域
    private String AREAID;
    //航站楼
    private String TERMINAL;
    //都是active
    private String STAND_LAYOUT;
    //状态
    private String STATUS;
    //登机桥1
    private String BOARDING_BRIDGE_1;
    //登机桥2
    private String BOARDING_BRIDGE_2;
    //关联区域
    private String BLOCK_ASSOCIATED_GATE;
    //旅客阈值
    private String PAX_THRESHOLD;
    //描述
    private String NAME;
}
