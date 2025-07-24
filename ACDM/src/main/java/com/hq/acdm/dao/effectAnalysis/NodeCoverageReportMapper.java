package com.hq.acdm.dao.effectAnalysis;

import com.hq.acdm.vo.effectAnalysis.MAILCoverageReportVo;
import com.hq.acdm.vo.effectAnalysis.NodeCoverageReportVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:38
 * @Description
 */
public interface NodeCoverageReportMapper {

    //查询单进航班保障节点数据
    List<NodeCoverageReportVo> findNodeCoverageA(@Param("params") Map params);

    //查询单出航班保障节点数据
    List<NodeCoverageReportVo> findNodeCoverageD(@Param("params") Map params);

    //查询过站（进出港）航班保障节点数据
    List<NodeCoverageReportVo> findNodeCoverageDandA(@Param("params") Map params);

    //查询出航班邮件数据
    List<MAILCoverageReportVo> findMAILCoverageD(@Param("params") Map params);
}
