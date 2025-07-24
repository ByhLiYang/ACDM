package com.hq.acdm.service.statistics.releaseNormal.impl;

import com.hq.acdm.dao.index.WeatherMapper;
import com.hq.acdm.model.statistics.releaseNormal.ReleaseNormal;
import org.springframework.stereotype.Service;
import com.hq.acdm.service.statistics.releaseNormal.ReleaseNormalService;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author yangrui
 * @date 2018/9/21 0020 14:37
 */
@Service("ReleaseNormalService")
public class ReleaseNormalServiceImpl implements ReleaseNormalService{
    @Resource
    private WeatherMapper weatherMapper;

    @Override
    public List<ReleaseNormal> queryReleaseNormal(String startDate, String endDate) {
        List<ReleaseNormal> list = weatherMapper.queryReleaseNormal(startDate,endDate);
        return list;
    }
}
