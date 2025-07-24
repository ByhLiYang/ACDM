package com.hq.acdm.service.statistics.nodeQuery;

import com.hq.acdm.model.statistics.nodeQuery.NodeQuery;
import com.hq.acdm.model.statistics.nodeQuery.NodeDetail;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface NodeQueryService {
    //关节节点查询

    List<NodeQuery> queryList(Map<String,Object> params);
    NodeDetail queryDetailD(Map params);
    NodeDetail queryDetailA(Map params);


}
