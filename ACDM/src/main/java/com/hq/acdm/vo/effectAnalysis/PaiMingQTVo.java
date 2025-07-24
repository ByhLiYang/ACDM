package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

@Data
public class PaiMingQTVo {

    private String date;
    private String agent;
    //12月排名
    //以下名称航司名＋单元格名
    private int qf_j1;//起飞正常率-计划—数量1
    private int qf_j2;//起飞正常率-计划—数量2
    private int qf_j3;//起飞正常率-计划—数量3
    private int qf_z1;//起飞正常率-正常—数量1
    private int qf_z2;//起飞正常率-正常—数量2
    private int qf_z3;//起飞正常率-正常—数量3
    private String qf_b1;//起飞正常率-正常率—百分比1
    private String qf_b2;//起飞正常率-正常率—百分比2
    private String qf_b3;//起飞正常率-正常率—百分比3

    private int fx_j1;//放行正常率-计划—数量1
    private int fx_j2;//放行正常率-计划—数量2
    private int fx_j3;//放行正常率-计划—数量3
    private int fx_z1;//放行正常率-正常—数量1
    private int fx_z2;//放行正常率-正常—数量2
    private int fx_z3;//放行正常率-正常—数量3
    private String fx_b1;//放行正常率-正常率—百分比1
    private String fx_b2;//放行正常率-正常率—百分比2
    private String fx_b3;//放行正常率-正常率—百分比3


    private String jq1;//加权平均率-百分比1
    private String jq2;//加权平均率-百分比2
    private String jq3;//加权平均率-百分比3

    private String createUsr="AocU01";//创建人
    private String updateUsr="AocU01";//修改人

    private boolean isupd=false;
}
