package com.hq.acdm.vo.dynamicFlight;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2019/04/22 10:22
 * @Description
 */
@Data
public class FltTimeAxisVo {
    private String flid;//航班ID
    private String flno;//航班号
    private String type;//机型
    private String stand;//机位
    private String delaytime;//延误状态 0为不延误，大于0为延误
    private String isiteffective;//排序时间无效状态
    private String bigtimes;//排序时间（年月日时分）
    private String shorttimes;//排序时间（时分）
    private String isatot;//是否有起飞时间
    private String execDate;

}
