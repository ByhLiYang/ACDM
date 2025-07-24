package com.hq.acdm.service.statistics.lnitialNormalRate.impl;

import com.hq.acdm.model.statistics.lnitialNormalRate.LnitialNormalRate;
import com.hq.acdm.model.statistics.lnitialNormalRate.LnitialNormalRate1;
import com.hq.acdm.model.statistics.lnitialNormalRate.LnitialNormalRate2;
import com.hq.acdm.service.statistics.lnitialNormalRate.LnitialNormalRateService;
import com.hq.acdm.dao.statistics.LnitialNormalRateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LnitialNormalRateServiceImpl implements LnitialNormalRateService {

    @Resource
    private LnitialNormalRateMapper lnitialNormalRateMapper;

    @Override
    public List<LnitialNormalRate> queryLnitialNormalRate(String startDate, String endDate) {
        List<LnitialNormalRate> list=lnitialNormalRateMapper.queryLnitialNormalRate(startDate, endDate);
        return list;
    }

    @Override
    public List<LnitialNormalRate1> queryLnitialNormalRate1(String startDate, String endDate) {
        List<LnitialNormalRate1> list=lnitialNormalRateMapper.queryLnitialNormalRate1(startDate,endDate);
        return list;
    }

    @Override
    public List<LnitialNormalRate2> queryLnitialNormalRate2(String startDate, String endDate) {
        List<LnitialNormalRate2> list=lnitialNormalRateMapper.queryLnitialNormalRate2(startDate, endDate);
        return list;
    }
}
