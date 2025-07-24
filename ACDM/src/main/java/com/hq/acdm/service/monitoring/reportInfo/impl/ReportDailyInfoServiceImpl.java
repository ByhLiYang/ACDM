package com.hq.acdm.service.monitoring.reportInfo.impl;

import com.hq.acdm.dao.monitioring.ReportDailyInfoMapper;
import com.hq.acdm.model.monitoring.reportInfo.ReportDailyInfo;
import com.hq.acdm.service.monitoring.reportInfo.ReportDailyInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("ReportDailyInfoService")
public class ReportDailyInfoServiceImpl implements ReportDailyInfoService {
    @Resource
    private ReportDailyInfoMapper taskMapper;

    @Override
    public List<ReportDailyInfo> queryList(Map params) {
        System.out.println("------------ReportDailyInfoService query-----------------");
        List<ReportDailyInfo> list = taskMapper.queryList(params);
        System.out.println(list);
        return list;
    }

    //从数据库统计数据
    public ReportDailyInfo queryDaily( Map params){
        System.out.println("------------ReportDailyInfoService query-----------------");
        ReportDailyInfo list = taskMapper.queryDaily(params);
        System.out.println(list);
        return list;
    }


    
    public void save(ReportDailyInfo task){
        System.out.println("------------TaskServiceImpl save-----------------");
        int result = taskMapper.insert(task);
        System.out.println(result);
    }

    public void update(ReportDailyInfo task){
        System.out.println("------------TaskServiceImpl save-----------------");
        int result = taskMapper.update(task);
        System.out.println(result);
    }

    public void updateStatus(ReportDailyInfo task){
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
