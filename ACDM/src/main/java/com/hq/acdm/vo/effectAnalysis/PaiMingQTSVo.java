package com.hq.acdm.vo.effectAnalysis;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaiMingQTSVo {

    private List<PaiMingQTVo> mu_tableData=new ArrayList<>();

    private List<PaiMingQTVo> cz_tableData=new ArrayList<>();

    private List<PaiMingQTVo> ca_tableData=new ArrayList<>();

    private List<PaiMingQTVo> df_tableData=new ArrayList<>();

    private PaiMingQTVo mu_sumData;
    private PaiMingQTVo cz_sumData;
    private PaiMingQTVo ca_sumData;
    private PaiMingQTVo df_sumData;
}
