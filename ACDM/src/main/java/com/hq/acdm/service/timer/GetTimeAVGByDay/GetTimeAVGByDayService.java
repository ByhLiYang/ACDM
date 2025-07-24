package com.hq.acdm.service.timer.GetTimeAVGByDay;

import com.hq.acdm.model.timer.GetTimeAVGByDay.GetTimeAVGByDay;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 9:26
 */
public interface GetTimeAVGByDayService {
    List<GetTimeAVGByDay> queryHISTORY_TAXI_TIME_AVG_By10_12();
    List<GetTimeAVGByDay> queryHISTORY_TAXI_TIME_AVG_By7_10();
    List<GetTimeAVGByDay> queryHISTORY_TAXI_TIME_AVG_ByOTHER();
    List<GetTimeAVGByDay> queryTAXI_TIME_TABLE_BYPK(Map<String,Object> map);
    int insertTAXI_TIME_TABLE(Map<String,Object> map);
    int updateTAXI_TIME_TABLE(Map<String,Object> map);
}
