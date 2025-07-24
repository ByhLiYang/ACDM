package com.hq.acdm.service.monitoring.CobtJump.impl;

import com.hq.acdm.model.monitoring.cobtJump.CobtJump;
import com.hq.acdm.service.monitoring.CobtJump.CobtJumpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("CobtJumpService")
public class CobtJumpServiceImpl implements CobtJumpService {
    @Resource
    private com.hq.acdm.dao.monitioring.CobtJumpMapper cobtJumpMapper;

    @Override
    public List<CobtJump> queryList(Map params) {
        System.out.println("------------SmallDelayServiceImpl-----------------");
        List<CobtJump> list = cobtJumpMapper.queryList(params);
        System.out.println(list);
        return list;
    }
}
