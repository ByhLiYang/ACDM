package com.hq.acdm.service.statistics.flightQuery.impl;

import com.hq.acdm.dao.statistics.ReduceMapper;
import com.hq.acdm.model.statistics.flightQuery.ReduceModel;
import com.hq.acdm.service.statistics.flightQuery.ReduceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/26 0026 17:11
 */
@Service("ReduceService")
public class ReduceServiceImpl implements ReduceService {
    @Resource
    private ReduceMapper reduceMapper;
    @Override
    public List<ReduceModel> queryReduce(Map<String, Object> map) {
        return reduceMapper.queryReduce(map);
    }

    @Override
    public int insertIntoReduce(Map<String,Object> map) {
        return reduceMapper.insertIntoReduce(map);
    }

    @Override
    public int updateReduce(Map<String, Object> map) {
        return reduceMapper.updateReduce(map);
    }
}
