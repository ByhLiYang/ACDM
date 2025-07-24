package com.hq.acdm.service.timer.GetTimeAVGByDay.impl;

import com.hq.acdm.dao.timer.GetTimeAVGByDay.GetTimeAVGByDayMapper;
import com.hq.acdm.model.timer.GetTimeAVGByDay.GetTimeAVGByDay;
import com.hq.acdm.service.timer.GetTimeAVGByDay.GetTimeAVGByDayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/15 0015 10:07
 */
@Service("GetTimeAVGByDayService")
public class GetTimeAVGByDayServiceImpl implements GetTimeAVGByDayService {
    @Resource
    private GetTimeAVGByDayMapper getTimeAVGByDayMapper;
    @Override
    public List<GetTimeAVGByDay> queryHISTORY_TAXI_TIME_AVG_By10_12() {
        return getTimeAVGByDayMapper.queryHISTORY_TAXI_TIME_AVG_By10_12();
    }

    @Override
    public List<GetTimeAVGByDay> queryHISTORY_TAXI_TIME_AVG_By7_10() {
        return getTimeAVGByDayMapper.queryHISTORY_TAXI_TIME_AVG_By7_10();
    }

    @Override
    public List<GetTimeAVGByDay> queryHISTORY_TAXI_TIME_AVG_ByOTHER() {
        return getTimeAVGByDayMapper.queryHISTORY_TAXI_TIME_AVG_ByOTHER();
    }

    @Override
    public List<GetTimeAVGByDay> queryTAXI_TIME_TABLE_BYPK(Map<String, Object> map) {
        return getTimeAVGByDayMapper.queryTAXI_TIME_TABLE_BYPK(map);
    }

    @Override
    public int insertTAXI_TIME_TABLE(Map<String, Object> map) {
        return getTimeAVGByDayMapper.insertTAXI_TIME_TABLE(map);
    }

    @Override
    public int updateTAXI_TIME_TABLE(Map<String, Object> map) {
        return getTimeAVGByDayMapper.updateTAXI_TIME_TABLE(map);
    }
}
