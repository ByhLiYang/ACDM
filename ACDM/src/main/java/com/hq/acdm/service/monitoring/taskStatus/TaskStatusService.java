package com.hq.acdm.service.monitoring.taskStatus;

import com.hq.acdm.model.monitoring.taskStatus.TaskStatus;
 


import java.util.List;
import java.util.Map;

/**
 * @Author lizhifeng
 * @Date 2018/8/21 0021
 * @Description:
 */
public interface TaskStatusService {

    void save(TaskStatus task);

    void update(TaskStatus task);

    void delete(String taskid);

     List<TaskStatus> queryList(Map params) ;

     List<TaskStatus> queryFlightList(Map params) ;

}
