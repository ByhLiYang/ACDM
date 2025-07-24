package com.hq.acdm.service.statistics.nodeQuery.impl;

import com.hq.acdm.dao.statistics.nodeQueryMapper;
import com.hq.acdm.model.statistics.nodeQuery.NodeDetail;
import com.hq.acdm.model.statistics.nodeQuery.NodeQuery;
import com.hq.acdm.service.statistics.nodeQuery.NodeQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("NodeQueryService")
public class NodeQueryServiceImpl implements NodeQueryService {
    @Resource
    private nodeQueryMapper nodeQueryMapper;

    @Override
    public List<NodeQuery> queryList(Map<String,Object> params) {
        System.out.println("------------NodeQueryServiceImpl-----------------");
        List<NodeQuery> list = nodeQueryMapper.queryList(params);
        System.out.println(list);
        return list;
    }
    public NodeDetail queryDetailD(Map params){
        NodeDetail detail=nodeQueryMapper.queryDetailD(params);
        return detail;
    }
    public NodeDetail queryDetailA(Map params)
    {
        NodeDetail detail=nodeQueryMapper.queryDetailA(params);
        System.out.println("------------NodeQueryServiceImpl NodeDetail"+detail.toString()+"-----------------");
        return detail;
    }
}
