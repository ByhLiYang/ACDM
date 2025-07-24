package com.hq.acdm.service.flight.impl;

import com.hq.acdm.dao.flight.DailyFlightMasterMapper;
import com.hq.acdm.service.flight.DailyFlightMasterService;
import org.springframework.stereotype.Service;
import com.hq.acdm.model.flight.DailyFlightMaster;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Auther: pengzhanghua
 * @Date: 2018/9/18 10:52
 * @Description:
 */
@Service("FlighStartService")
public class DailyFlightMasterServiceImpl implements DailyFlightMasterService {

    @Resource
    private DailyFlightMasterMapper dailyFlightMasterMapper;

    @Override
    public List<String> getAllCompany() {
        return dailyFlightMasterMapper.findAllCompany();
    }

    @Override
    public List<DailyFlightMaster> queryList(Map params) {
        return dailyFlightMasterMapper.queryList(params);
    }

    @Override
    public List<Map> queryFlightList(Map params) {
        return dailyFlightMasterMapper.queryFlightList(params);
    }
}
