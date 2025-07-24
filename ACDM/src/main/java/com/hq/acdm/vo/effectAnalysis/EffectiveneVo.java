package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EffectiveneVo {

    private double zcl;//起飞正常率
    private double fxl;//放行放行率
    private double ariNom;//机场正常性
    private double afxl;//始发正常性
    private double dzcl;//进港正常性

    private int planA;//进港计划总数
    private int actualA;//进港已执行正常
    private int delayA;//进港已执行异常
    private int planHomeA;//进港国内计划总数
    private int actualHomeA;//进港国内已执行
    private int planInlA;//进港国际计划总数
    private int actualInlA;//进港国际已执行

    private int planD;//离港计划总数
    private int actualD;//离港已执行正常
    private int delayD;//离港已执行异常
    private int planHomeD;//离港国内计划总数
    private int actualHomeD;//离港国内已执行
    private int planInlD;//离港国际计划总数
    private int actualInlD;//离港国际已执行

    private LlgkVo llgkA;//进港流量概况
    private LlgkVo llgkD;//离港流量概况

    private int ywywsl;//放行延误数量
    private int ywywsc;//放行延误时长
    private int yw015;//放行延误小于15分钟
    private int yw1530;//放行延误15到30分钟
    private int yw3060;//放行延误30到60分钟
    private int yw60120;//放行延误60到120分钟
    private int yw120;//放行延误大于等于120分钟

    private List<FltDelayTypeVo> ywyy;//延误原因列表
    private List<InsufficientTTTVo> gzbu;//过站不足列表

}
