package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.optimize.optimizeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/12/3 0003 15:03
 */
public interface OptimizeMapper {
    List<optimizeModel> queryD();
    List<optimizeModel> queryA();
    optimizeModel queryOne(@Param("params")Map<String,Object> map);
}
