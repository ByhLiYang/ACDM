package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

import java.util.List;

@Data
public class PDFListVo {

    private List<RunQualityReportYLTJVo> yltj;//运量统计

    private List<RunQualityReportYLTJVo> hbzcxtj;//航班正常性统计

    private List<RunQualityReportYWYYVo> ywyy;//延误原因统计

    private List<RunQualityReportJCZLJGVo> jczljg;//航班进程质量管控

    private List<RunQualityReportFXZCLPMVo> fxzclpm;//加权平均值排名

    private List<RunQualityReportTipsVo> tips;//航班正常管理提示

    private List<RunQualityPDFEChartVo> echartD;//小时架次图



}
