package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MAILCoveragePieAndBarVo {


    private List<MAILCoverageReportVo> staticDataPieW;//邮件重量饼图成分值

    private String []legendDataBarW;//邮件重量柱状图成分名
    private int[] staticDataBarW;//邮件重量柱状图成分值


    private List<MAILCoverageReportVo> staticDataPieC;//邮件数量饼图成分值

    private String []legendDataBarC;//邮件数量柱状图成分名
    private int[] staticDataBarC;//邮件数量柱状图成分值
}
