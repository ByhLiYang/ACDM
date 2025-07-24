package com.hq.acdm.service.monitoring.taskStatus.impl;

import com.hq.acdm.dao.monitioring.TaskStatusMapper;
import com.hq.acdm.model.monitoring.taskStatus.TaskStatus;
import com.hq.acdm.service.monitoring.taskStatus.TaskStatusService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("TaskService")
public class TaskServiceImpl implements TaskStatusService {
    @Resource
    private TaskStatusMapper taskMapper;

    @Override
    public List<TaskStatus> queryList(Map params) {
        System.out.println("------------TaskServiceImpl query-----------------");
        List<TaskStatus> list = taskMapper.queryList(params);
        System.out.println(list);
        return list;
    }

    @Override
    public List<TaskStatus> queryFlightList(Map params) {
        System.out.println("------------TaskServiceImpl query-----------------");
        List<TaskStatus> list = taskMapper.queryFlightList(params);
        System.out.println(list);
        return list;
    }
    
    public void save(TaskStatus task){
        System.out.println("------------TaskServiceImpl save-----------------");
        int result = taskMapper.insert(task);
        System.out.println(result);
    }

    public void update(TaskStatus task){
        System.out.println("------------TaskServiceImpl save-----------------");
        int result = taskMapper.updateStatus(task);
        System.out.println(result);
    }

    public void delete(String taskid){}
}
