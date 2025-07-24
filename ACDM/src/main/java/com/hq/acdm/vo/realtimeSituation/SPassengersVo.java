package com.hq.acdm.vo.realtimeSituation;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2019/04/15 01:31
 * @Description
 */
@Data
public class SPassengersVo {

    private int [] countEOne;//东一滞留旅客
    private int [] countETwo;//东二滞留旅客
    private int [] countWOne;//西一滞留旅客
    private int [] countWTwo;//西二滞留旅客
    private int [] countEAll;//延误次数
}
