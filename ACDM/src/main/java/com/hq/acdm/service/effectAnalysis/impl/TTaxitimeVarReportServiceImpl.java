package com.hq.acdm.service.effectAnalysis.impl;

import com.hq.acdm.dao.effectAnalysis.TTaxitimeVarReportMapper;
import com.hq.acdm.service.effectAnalysis.TTaxitimeVarReportService;
import com.hq.acdm.vo.effectAnalysis.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class TTaxitimeVarReportServiceImpl implements TTaxitimeVarReportService {


    @Resource
    private TTaxitimeVarReportMapper tTaxitimeVarReportMapper;


    @Override
    public List<TTaxitimeVarReportVo> findTTaxitimeVarInfo(Map params) {
        return tTaxitimeVarReportMapper.findTTaxitimeVarInfo(params);
    }

    @Override
    public List<String> findAllRunway() {
        return tTaxitimeVarReportMapper.findAllRunway();
    }

    @Override
    public List<String> findAllStand() {
        return tTaxitimeVarReportMapper.findAllStand();
    }

    @Override
    public List<String> findAllCraftTypeIcao() {
        return tTaxitimeVarReportMapper.findAllCraftTypeIcao();
    }

    @Override
    public List<String> findAllPeriod() {
        return tTaxitimeVarReportMapper.findAllPeriod();
    }


}


