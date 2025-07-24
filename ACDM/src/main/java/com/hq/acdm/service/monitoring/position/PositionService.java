package com.hq.acdm.service.monitoring.position;

import com.hq.acdm.model.monitoring.position.availablePosition;
import com.hq.acdm.model.monitoring.position.farArea;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface PositionService {
    //查询可使用机位
    public List<availablePosition> queryFree(Map params)  ;

    //查询可机位使用明细
    public List<availablePosition> queryDetail(Map params)  ;

    //查询可机位使用汇总
    public List<availablePosition> querySummary(Map params)  ;

    //查询远可机位使用汇总
    public List<farArea> queryFar(Map params)  ;
}
