package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.nodeQuery.NodeDetail;
import com.hq.acdm.model.statistics.nodeQuery.NodeQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface nodeQueryMapper {
    //关键时间点查询
    List<NodeQuery> queryList(@Param("params") Map<String,Object> params);
    NodeDetail queryDetailD(@Param("params") Map params);
    NodeDetail queryDetailA(@Param("params") Map params);
}
