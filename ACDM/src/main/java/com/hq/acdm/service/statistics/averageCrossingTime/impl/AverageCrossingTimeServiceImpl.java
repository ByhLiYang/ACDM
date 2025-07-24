package com.hq.acdm.service.statistics.averageCrossingTime.impl;

import com.hq.acdm.dao.statistics.AverageCrossingTimeMapper;
import com.hq.acdm.model.statistics.averageCrossingTime.AverageCrossingTime;
import com.hq.acdm.service.statistics.averageCrossingTime.AverageCrossingTimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/9/20 0020 14:37
 */
@Service("AverageCrossingTimeService")
public class AverageCrossingTimeServiceImpl implements AverageCrossingTimeService{
    @Resource
    private AverageCrossingTimeMapper averageCrossingTimeMapper;

    @Override
    public List<AverageCrossingTime> queryAverageCrossingTime(Map params) {
        List<AverageCrossingTime> list = averageCrossingTimeMapper.queryAverageCrossingTime(params);
        return list;
    }
}
