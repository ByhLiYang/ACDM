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

public interface NodeCoverageReportService {

    //查询单进航班保障节点数据
    List<NodeCoverageReportVo> findNodeCoverageA(@Param("params") Map params);

    //查询单出航班保障节点数据
    List<NodeCoverageReportVo> findNodeCoverageD(@Param("params") Map params);

    //查询过站（进出港）航班保障节点数据
    List<NodeCoverageReportVo> findNodeCoverageDandA(@Param("params") Map params);

    //查询南航、东航，国航，地服所有单进航班保障节点数据
    List<NodeCoverageReportVo> findAllNodeCoverageA(@Param("params") Map params);

    //查询南航、东航，国航，地服所有单出航班保障节点数据
    List<NodeCoverageReportVo> findAllNodeCoverageD(@Param("params") Map params);

    //查询南航、东航，国航，地服所有过站（进出港）航班保障节点数据
    List<NodeCoverageReportVo> findAllNodeCoverageDandA(@Param("params") Map params);
    //查询饼图数据
    NodeCoveragePieVo findPieData(@Param("params") Map params);
    //查询柱状图数据
    NodeCoverageBarVo findBarData(@Param("params") Map params);
    //查询列表数据
    List<NodeCoverageTableVo> findTableData(@Param("params") Map params);

    //查询出航班邮件数据
    MAILCoveragePieAndBarVo findMAILCoverageD(@Param("params") Map params);

}
