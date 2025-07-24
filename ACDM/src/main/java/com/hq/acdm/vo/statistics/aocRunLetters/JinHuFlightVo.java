package com.hq.acdm.vo.statistics.aocRunLetters;

import lombok.Data;

/**
 * 京沪航班 总数 正常数 不正常数量 正常率
 */
@Data
public class JinHuFlightVo {
    private String airport;//机场名称
    private String normalNum;//正常数
    private String abNormalNum;//不正常数量
    private String totalNum;//总数
    private String normalRate;//正常率
}
