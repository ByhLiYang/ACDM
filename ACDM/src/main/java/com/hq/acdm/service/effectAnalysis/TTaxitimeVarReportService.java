package com.hq.acdm.service.effectAnalysis;

import com.hq.acdm.vo.effectAnalysis.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface TTaxitimeVarReportService {

    //查询平均滑行时长
    List<TTaxitimeVarReportVo> findTTaxitimeVarInfo(@Param("params") Map params);

    List<String> findAllRunway();

    List<String> findAllStand();

    List<String> findAllCraftTypeIcao();

    List<String> findAllPeriod();
}
