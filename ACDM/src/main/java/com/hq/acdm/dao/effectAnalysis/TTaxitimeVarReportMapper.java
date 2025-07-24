package com.hq.acdm.dao.effectAnalysis;

import com.hq.acdm.vo.effectAnalysis.TTaxitimeVarReportVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:38
 * @Description
 */
public interface TTaxitimeVarReportMapper {

    //查询单进航班保障节点数据
    List<TTaxitimeVarReportVo> findTTaxitimeVarInfo(@Param("params") Map params);

    List<String> findAllRunway();

    List<String> findAllStand();

    List<String> findAllCraftTypeIcao();

    List<String> findAllPeriod();



}
