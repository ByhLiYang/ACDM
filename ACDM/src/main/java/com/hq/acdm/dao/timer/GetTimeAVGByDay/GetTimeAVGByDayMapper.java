package com.hq.acdm.dao.timer.GetTimeAVGByDay;

import com.hq.acdm.model.timer.GetTimeAVGByDay.GetTimeAVGByDay;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 9:27
 */
public interface GetTimeAVGByDayMapper {
    List<GetTimeAVGByDay> queryHISTORY_TAXI_TIME_AVG_By10_12();
    List<GetTimeAVGByDay> queryHISTORY_TAXI_TIME_AVG_By7_10();
    List<GetTimeAVGByDay> queryHISTORY_TAXI_TIME_AVG_ByOTHER();
    List<GetTimeAVGByDay> queryTAXI_TIME_TABLE_BYPK(@Param("params") Map<String,Object> map);
    int insertTAXI_TIME_TABLE(@Param("params") Map<String,Object> map);
    int updateTAXI_TIME_TABLE(@Param("params") Map<String,Object> map);
}
