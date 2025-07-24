package com.hq.acdm.vo.realtimeSituation;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2019/04/15 01:31
 * @Description
 */
@Data
public class FlightDelayVo {
    private double zCL;//正常率
    private double fXL;//放率
    private int yW;//延误数
    private int yWZS;//延误总数
    private int qX;//取消数
    private int qXZS;//取消总数
    private int zL;//滞留数

    private int [] countEHours;//小时积压
    private int [] countETotal;//累计积压
    private int [] countAll;//连线积压
    private int [] countEOne;//东一滞留旅客
    private int [] countETwo;//东二滞留旅客
    private int [] countWOne;//西一滞留旅客
    private int [] countWTwo;//西二滞留旅客
    private int [] countEAll;//滞留旅客总数
    private int [] count;//下面航班延误次数

    private int [] countAVG;//每小时平均等待分钟数组
    private double gh;//国航滞留旅客占比率
    private double nh;//南航滞留旅客占比率
    private double dh;//东航滞留旅客占比率
    private double df;//地服滞留旅客占比率

    private String [] timese;//时间数组

    private int jwzs;//机位总数
    private int bkys;//不可用
    private int cqzy;//长期占用
    private int jjwzy;//近机位占用
    private int jjwzs;//近机位总数
    private int jrtc;//今日停场
    private int syjw;//剩余机位
    private int gyhb;//过夜航班
    private int yjwzy;//远机位占用
    private int yjwzs;//远机位总数
    private int bzy;//B占用
    private int bsy;//B剩余
    private int czy;//C占用
    private int csy;//C剩余
    private int dzy;//D占用
    private int dsy;//D剩余
    private int ezy;//E占用
    private int esy;//E剩余
    private int fzy;//F占用
    private int fsy;//F剩余

}
