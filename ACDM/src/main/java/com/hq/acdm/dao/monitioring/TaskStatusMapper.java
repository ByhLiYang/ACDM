package com.hq.acdm.dao.monitioring;

import com.hq.acdm.model.monitoring.taskStatus.TaskStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface TaskStatusMapper {
    //任务管理
    //查询任务列表
    List<TaskStatus> queryList(@Param("params") Map params);

    List<TaskStatus> queryFlightList(@Param("params") Map params);
    //新增任务
    int insert(TaskStatus task);
    //更新
    int updateStatus(TaskStatus task);

    TaskStatus selectByPrimaryKey(Integer id);
}
