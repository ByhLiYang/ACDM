package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

import java.util.List;

@Data
public class NodeCoveragePieVo {

    private String []legendData;
    private List<NodeCoveragePieStaticVo> staticData;



}
