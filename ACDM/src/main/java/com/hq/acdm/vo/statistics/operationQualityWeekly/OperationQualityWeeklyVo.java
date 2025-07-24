package com.hq.acdm.vo.statistics.operationQualityWeekly;

import lombok.Data;
import java.util.List;
@Data
public class OperationQualityWeeklyVo {



    private List<TotalVo> Total;

    private List<DomesticVo> Domestic;

    private List<InternationalVo> International;
}
