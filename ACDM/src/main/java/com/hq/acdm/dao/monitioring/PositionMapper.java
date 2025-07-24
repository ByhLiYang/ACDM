package com.hq.acdm.dao.monitioring;

import com.hq.acdm.model.monitoring.position.availablePosition;
import org.apache.ibatis.annotations.Param;
import com.hq.acdm.model.monitoring.position.farArea;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface PositionMapper {
    //查询可使用机位
    List<availablePosition> queryFree(@Param("params") Map params);

    //查询可机位使用明细
    List<availablePosition> queryDetail(@Param("params") Map params);

    //查询可机位使用汇总
    List<availablePosition> querySummary(@Param("params") Map params);

    //查询可机位使用汇总
    List<farArea> queryFar(@Param("params") Map params);
}
