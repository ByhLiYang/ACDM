package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.flightQuery.ReduceModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/26 0026 17:06
 */
public interface ReduceMapper {
    List<ReduceModel> queryReduce(@Param("params")Map<String,Object> map);
    int insertIntoReduce(@Param("params")Map<String,Object> map);
    int updateReduce(@Param("params")Map<String,Object> map);
}
