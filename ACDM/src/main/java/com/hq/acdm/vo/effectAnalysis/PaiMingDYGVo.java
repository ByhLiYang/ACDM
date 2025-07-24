package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

import java.util.Date;

@Data
public class PaiMingDYGVo {

    private String execdate;
    //12月排名
    //以下名称航司名＋单元格名
    private int mub3;//起飞正常率-计划—MU数量
    private int fmc3;//起飞正常率-计划—FM数量
    private int mue3;//放行正常率-计划—MU数量
    private int fmf3;//放行正常率-计划—FM数量
    private int mun3;//放行正常率-正常—MU数量
    private int fmo3;//放行正常率-正常—FM数量

    private int czb3;//
    private int oqc3;//
    private int cze3;//
    private int oqf3;//
    private int czn3;//
    private int oqo3;//



    private int cab3;//
    private int zhc3;//
    private int cae3;//
    private int zhf3;//
    private int can3;//
    private int zho3;//

    private int dfb3;//
    private int dfe3;//
    private int dfn3;//



}
