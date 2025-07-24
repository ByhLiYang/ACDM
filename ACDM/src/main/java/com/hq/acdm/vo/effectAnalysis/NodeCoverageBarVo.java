package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class NodeCoverageBarVo {

    private String []legendData;
    private List<BigDecimal[]> staticData;



}
