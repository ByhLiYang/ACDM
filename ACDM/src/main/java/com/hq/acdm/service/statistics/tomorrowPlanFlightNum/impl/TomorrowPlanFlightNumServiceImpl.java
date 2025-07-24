package com.hq.acdm.service.statistics.tomorrowPlanFlightNum.impl;

import com.hq.acdm.dao.statistics.TomorrowPlanFlightNumMapper;
import com.hq.acdm.model.statistics.tomorrowPlanFlightNum.TomorrowPlanFlightNum;
import com.hq.acdm.service.statistics.tomorrowPlanFlightNum.TomorrowPlanFlightNumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangshuhao
 * @date 2018/10/16 0016 17:31
 */
@Service("TomorrowPlanFlightNumService")
public class TomorrowPlanFlightNumServiceImpl implements TomorrowPlanFlightNumService {
    @Resource
    private TomorrowPlanFlightNumMapper tomorrowPlanFlightNumMapper;

    @Override
    public List<TomorrowPlanFlightNum> query() {
        TomorrowPlanFlightNum a = new TomorrowPlanFlightNum();
        TomorrowPlanFlightNum d = new TomorrowPlanFlightNum();
        TomorrowPlanFlightNum total = new TomorrowPlanFlightNum();
        a = tomorrowPlanFlightNumMapper.queryA();
        d = tomorrowPlanFlightNumMapper.queryD();
        List<TomorrowPlanFlightNum> list = new ArrayList<>();
        total.setCount_a(a.getCount_a());
        total.setCount_d(d.getCount_d());
        list.add(total);

        return list;
    }
}
