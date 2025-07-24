package com.hq.acdm.service.monitoring.mobile.impl;

import com.hq.acdm.service.monitoring.mobile.MobileCheckinService;
import com.hq.acdm.model.monitoring.mobile.MobileCheckin;
import org.springframework.stereotype.Service;
import com.hq.acdm.dao.monitioring.MobileCheckinMapper;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("MobileCheckinService")
public class MobileCheckinServiceImpl implements MobileCheckinService {
    @Resource
    private MobileCheckinMapper taskMapper;

    @Override
    public List<MobileCheckin> queryList(Map params) {
        System.out.println("------------TaskServiceImpl query-----------------");
        List<MobileCheckin> list = taskMapper.queryList(params);
        System.out.println(list);
        return list;
    }

    @Override
    public List<MobileCheckin> queryFlightList(Map params) {
        System.out.println("------------TaskServiceImpl query-----------------");
        List<MobileCheckin> list = taskMapper.queryList(params);
        System.out.println(list);
        return list;
    }
    
    public void save(MobileCheckin task){
        System.out.println("------------TaskServiceImpl save-----------------");
        int result = taskMapper.insert(task);
        System.out.println(result);
    }

    public void update(MobileCheckin task){
        System.out.println("------------TaskServiceImpl save-----------------");
        int result = taskMapper.updateStatus(task);
        System.out.println(result);
    }

    public void delete(Integer taskid){
        System.out.println("------------TaskServiceImpl save-----------------");
        taskMapper.deleteByPrimaryKey(taskid);
        //System.out.println(result);
    }
}
