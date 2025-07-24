package com.hq.acdm.service.statistics.flightQuery;

import com.hq.acdm.model.statistics.flightQuery.ReduceModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/26 0026 17:11
 */
public interface ReduceService {
    List<ReduceModel> queryReduce(Map<String,Object> map);
    int insertIntoReduce(Map<String,Object> map);
    int updateReduce(Map<String,Object> map);
}
