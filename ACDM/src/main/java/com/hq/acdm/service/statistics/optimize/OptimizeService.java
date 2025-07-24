package com.hq.acdm.service.statistics.optimize;

import com.hq.acdm.model.statistics.optimize.optimizeModel;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/12/3 0003 15:04
 */
public interface OptimizeService {
    Map<String,Object> queryByTime() throws ParseException;
    optimizeModel queryOne(Map<String,Object> map);
}
