package com.hq.acdm.service.monitoring.smallDelay.impl;

import com.hq.acdm.model.monitoring.smallDelay.SmallDelayStatus;
import com.hq.acdm.model.monitoring.smallDelay.smallDelay;
import com.hq.acdm.service.monitoring.smallDelay.SmallDelayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("SmallDelayService")
public class SmallDelayServiceImpl implements SmallDelayService {
    @Resource
    private com.hq.acdm.dao.monitioring.SmallDelayMapper smallDelayMapper;

    @Override
    public List<smallDelay> queryList(Map params) {
        System.out.println("------------SmallDelayServiceImpl-----------------");
        List<smallDelay> list = smallDelayMapper.queryList(params);
        System.out.println(list);
        return list;
    }
    public List<SmallDelayStatus> queryStatusList(Map params)  {
        System.out.println("------------SmallDelayServiceImpl queryStatusList-----------------");
        List<SmallDelayStatus> list = smallDelayMapper.queryStatusList(params);
        System.out.println(list);
        return list;
    }

    public int insert(SmallDelayStatus delayStatus){
        smallDelayMapper.insert(delayStatus);
        return 0;
    }

    //更新
    public int updateStatus(SmallDelayStatus delayStatus){
        smallDelayMapper.updateStatus(delayStatus);
        return 0;
    }
}
