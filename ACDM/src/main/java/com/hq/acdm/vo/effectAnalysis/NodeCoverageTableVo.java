package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class NodeCoverageTableVo {

    private String type;
    private String name;
    private String number;
    private List<NodeCoverageTableNodeVo> mechanism;



}
