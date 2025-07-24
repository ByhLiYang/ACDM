package com.hq.acdm.dao.monitioring;

import com.hq.acdm.model.monitoring.smallDelay.smallDelay;
import com.hq.acdm.model.monitoring.smallDelay.SmallDelayStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface SmallDelayMapper {
    //小延误查询
    List<smallDelay> queryList(@Param("params") Map params);

    //小延误状态查询
    List<SmallDelayStatus> queryStatusList(@Param("params") Map params);

    //新增状态
    int insert(SmallDelayStatus delayStatus);

    //更新
    int updateStatus(SmallDelayStatus delayStatus);
}
