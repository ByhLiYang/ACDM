package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2020/04/06 23:53
 * @Description
 */
@Data
public class FltDelayVo {
    private int hbywsl;
    private int hbywsc;
    private int hb015;
    private int hb1530;
    private int hb3060;
    private int hb60120;
    private int hb120;
    private int ywywsl;//放行延误数量
    private int ywywsc;//放行延误时长
    private int yw015;//放行延误小于15分钟
    private int yw1530;//放行延误15到30分钟
    private int yw3060;//放行延误30到60分钟
    private int yw60120;//放行延误60到120分钟
    private int yw120;//放行延误大于等于120分钟
}
