package com.hq.acdm.model.statistics.T2BridgeRate;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/11/8 0008 10:27
 */
@Getter
@Setter
public class T2BridgeRate {
    //拼音：计划数
    private String JIHUASHU;
    //拼音：执行数
    private String ZHIXINGSHU;
    //拼音：进机位/靠桥数
    private String KAOQIAOSHU;
    private String KAOQIAOLV;
    private String AIRLINE_CODE_IATA;
    private String OPERATIONAL_DATE;

}
