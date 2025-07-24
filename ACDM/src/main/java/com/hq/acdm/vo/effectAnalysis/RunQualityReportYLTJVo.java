package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

@Data
public class RunQualityReportYLTJVo {

    private String []title;
    private String []dayHbs;
    private String []dayTb;
    private String []monthHbs;
    private String []monthTb;
    private String []yearHbs;
    private String []yearTb;
    private String execDate;
}
