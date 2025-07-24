package com.hq.acdm.vo.realtimeSituation;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2019/04/15 01:31
 * @Description
 */
@Data
public class FDelayVo {

    private int count0;//延误30分以下
    private int count1;//延误30-60
    private int count2;//延误60-120
    private int count3;//延误120-240
    private int count4;//延误240分以上

}
