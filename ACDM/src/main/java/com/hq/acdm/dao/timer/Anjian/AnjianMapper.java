package com.hq.acdm.dao.timer.Anjian;

import com.hq.acdm.mysql.AreaPeopleNumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 16:24
 */
public interface AnjianMapper {
    List<AreaPeopleNumber> queryPax_num();
    List<AreaPeopleNumber> queryHistoricalPax_num();
    int insertHistoricalPax_num(@Param("params")Map<String,Object> map);
    int deleteHistoricalPax_num(@Param("params")Map<String,Object> map);
    List<AreaPeopleNumber> queryByCondition(@Param("params")Map<String,Object> map);
    int deleteDuplicateDate(@Param("params")Map<String,Object> map);
}
