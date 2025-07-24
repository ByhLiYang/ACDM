package com.hq.acdm.service.statistics.DelayCoordinate.impl;

import com.hq.acdm.dao.statistics.DelayCoordinateMapper;
import com.hq.acdm.model.statistics.delayCoordinate.DelayCoordinateModel;
import com.hq.acdm.service.statistics.DelayCoordinate.DelayCoordinateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangshuhao
 * @date 2018/12/6 0006 13:46
 */
@Service("DelayCoordinateService")
public class DelayCoordinateServiceImpl implements DelayCoordinateService {
    @Resource
    private DelayCoordinateMapper delayCoordinateMapper;

    @Override
    public List<DelayCoordinateModel> queryDelay() {
        List<DelayCoordinateModel> list = delayCoordinateMapper.queryDelay();
        return list;
    }
}
