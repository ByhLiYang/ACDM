package com.hq.acdm.service.monitoring.reportInfo.impl;

import com.hq.acdm.dao.monitioring.ReportRunInfoMapper;
import com.hq.acdm.model.monitoring.reportInfo.ReportRunInfo;
import com.hq.acdm.service.monitoring.reportInfo.ReportRunInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("ReportRunInfoService")
public class ReportRunInfoServiceImpl implements ReportRunInfoService {
    @Resource
    private ReportRunInfoMapper taskMapper;

    @Override
    public List<ReportRunInfo> queryList(Map params) {
        System.out.println("------------TaskServiceImpl query-----------------");
        List<ReportRunInfo> list = taskMapper.queryList(params);
        System.out.println(list);
        return list;
    }

    @Override
    public List<ReportRunInfo> queryFlightList(Map params) {
        System.out.println("------------TaskServiceImpl query-----------------");
        List<ReportRunInfo> list = taskMapper.queryFlightList(params);
        System.out.println(list);
        return list;
    }
    
    public void save(ReportRunInfo task){
        System.out.println("------------TaskServiceImpl save-----------------");
        int result = taskMapper.insert(task);
        System.out.println(result);
    }

    public void update(ReportRunInfo task){
        System.out.println("------------TaskServiceImpl save-----------------");
        int result = taskMapper.update(task);
        System.out.println(result);
    }

    public void updateStatus(ReportRunInfo task){
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
