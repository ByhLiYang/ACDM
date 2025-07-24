package com.hq.acdm.service.monitoring.smallDelay;

import com.hq.acdm.model.monitoring.smallDelay.SmallDelayStatus;
import com.hq.acdm.model.monitoring.smallDelay.smallDelay;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface SmallDelayService {
    //查询小延误

    public List<smallDelay> queryList(Map params)  ;

    public List<SmallDelayStatus> queryStatusList(Map params)  ;

    int insert(SmallDelayStatus delayStatus);

    //更新
    int updateStatus(SmallDelayStatus delayStatus);

}
