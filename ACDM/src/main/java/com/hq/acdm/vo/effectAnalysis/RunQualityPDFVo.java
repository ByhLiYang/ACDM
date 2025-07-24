package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

import java.util.Date;

@Data
public class RunQualityPDFVo {

    private String execdate;

    private String agent;
    //机场运量统计
    private String yltj0;//项目日期
    private String yltj1;//本日运输量
    private String yltj2;//本日运输量同比
    private String yltj3;//月度运输量
    private String yltj4;//月度运输量同比
    private String yltj5;//年度运输量
    private String yltj6;//年度运输量同比
    private String yltj7;//本日人数
    private String yltj8;//本日人数同比
    private String yltj9;//月度人数
    private String yltj10;//月度人数同比
    private String yltj11;//年度人数
    private String yltj12;//年度人数同比
    private String yltj13;//年月日

    //【航班正常性统计
    private String hbzcxtj0;//项目日期
    private String hbzcxtj1;//本日加权平均值
    private String hbzcxtj2;//本日加权平均同比
    private String hbzcxtj3;//月度加权平均值
    private String hbzcxtj4;//月度加权平均值同比
    private String hbzcxtj5;//年度加权平均值
    private String hbzcxtj6;//年度加权平均值同比
    private String hbzcxtj7;//本日始发正常率
    private String hbzcxtj8;//本日始发正常率
    private String hbzcxtj9;//月度始发正常率
    private String hbzcxtj10;//月度始发正常率同比
    private String hbzcxtj11;//年度始发正常率
    private String hbzcxtj12;//年度始发正常率同比
    private String hbzcxtj13;//本日航班正确率
    private String hbzcxtj14;//本日航班正确率同比
    private String hbzcxtj15;//月度航班正确率
    private String hbzcxtj16;//月度航班正确率同比
    private String hbzcxtj17;//年度航班正确率
    private String hbzcxtj18;//年度航班正确率同比

    //延误原因统计
    private String ywyy0;//天气
    private String ywyy1;//公司
    private String ywyy2;//流量
    private String ywyy3;//航班时刻
    private String ywyy4;//军事活动
    private String ywyy5;//空管
    private String ywyy6;//机场
    private String ywyy7;//联检
    private String ywyy8;//油料
    private String ywyy9;//离港系统
    private String ywyy10;//旅客
    private String ywyy11;//公告安全
    private String ywyy12; //延误原因统计总数
    private String ywyy13;

    //航班进程质量管控
    private String jczljg0;//项目日期
    private String jczljg1;//航班靠桥率
    private String jczljg2;//关门准点率
    private String jczljg3;//晚关舱门航班
    private String jczljg4;//延误原因具体航班
    private String jczljg5;//实际小时起降架次
    private String jczljg6;//平均进港滑行时间
    private String jczljg7;//平均出港滑行时间

    //加权平均值排名
    private String fxzclpm0;//项目日期
    private String fxzclpm1;//本日国航代理
    private String fxzclpm2;//本日南航代理
    private String fxzclpm3;//本日东航代理
    private String fxzclpm4;//本日地服代理
    private String fxzclpm5;//
    private String fxzclpm6;//月度累计
    private String fxzclpm7;//月度累计国航代理
    private String fxzclpm8;//月度累计南航代理
    private String fxzclpm9;//月度累计东航代理
    private String fxzclpm10;//月度累计地服代理
    private String fxzclpm11;//

    private String flTips;//航班正常管理提示

    private String rmk;
    private String rmk2;
    private String rmk3;

    //计划架次
    private String echartDjhs0;//7点航班数
    private String echartDjhs1;//8
    private String echartDjhs2;//9
    private String echartDjhs3;//10
    private String echartDjhs4;//11
    private String echartDjhs5;//12
    private String echartDjhs6;//13
    private String echartDjhs7;//14
    private String echartDjhs8;//15
    private String echartDjhs9;//16
    private String echartDjhs10;//17
    private String echartDjhs11;//18
    private String echartDjhs12;//19
    private String echartDjhs13;//20
    private String echartDjhs14;//21
    private String echartDjhs15;//22
    private String echartDjhs16;//23

    //实际架次
    private String echartDsjs0;//7点航班数
    private String echartDsjs1;//8
    private String echartDsjs2;//9
    private String echartDsjs3;//10
    private String echartDsjs4;//11
    private String echartDsjs5;//12
    private String echartDsjs6;//13
    private String echartDsjs7;//14
    private String echartDsjs8;//15
    private String echartDsjs9;//16
    private String echartDsjs10;//17
    private String echartDsjs11;//18
    private String echartDsjs12;//19
    private String echartDsjs13;//20
    private String echartDsjs14;//21
    private String echartDsjs15;//22
    private String echartDsjs16;//23
    private Date createTm;

    private Date updateTm;

    private String createUsr;

    private String updateUsr;
}
