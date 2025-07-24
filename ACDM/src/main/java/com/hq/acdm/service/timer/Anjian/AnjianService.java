package com.hq.acdm.service.timer.Anjian;

import com.hq.acdm.mysql.AreaPeopleNumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 16:26
 */
public interface AnjianService {
    Map<String,String> queryPax_num();
    List<AreaPeopleNumber> queryHistoricalPax_num();
    int insertHistoricalPax_num(Map<String,Object> map);
    int deleteHistoricalPax_num(Map<String,Object> map);
    List<AreaPeopleNumber> queryByCondition(Map<String,Object> map);
    int deleteDuplicateDate(Map<String,Object> map);
}
