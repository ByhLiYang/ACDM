package com.hq.acdm.vo.coordinatedOprt;

import lombok.Data;

@Data
public class ZHDelayedDisposalVo {

    private String     flop;//"航班日期",
    private String     airlineCode;//""航司",
    private String     flno;//""航班号",
    private String     regnumber;//""机号",
    private String     vial;//""航线",
    private String     dlreason;//""延误原因",
    private String     type;//""旅客/机组",
    private String     projectType;//""类别（住宿/餐饮/用车）",
    private String     project;//""项目（中餐午餐晚餐饮料..）",
    private String     number;//""数量"
    private String     supplier;//""供应人"
    private String     attribute;//'航班属性；2403 国内、2401 国际、2404 混合、2402 地区'
}
