package com.hq.acdm.controller.monitoring.task;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.monitoring.taskStatus.TaskStatus;
import com.hq.acdm.service.monitoring.taskStatus.TaskStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:40
 */

@Api(description = "查询当日航班，带状态，与task_status关联")
@RestController
@RequestMapping("/flightSupervision/taskStatus")
@Slf4j
public class TaskStatusController {

    @Resource
    private TaskStatusService taskService;


    @ApiOperation(httpMethod = "POST", value = "查询当日航班，带状态，与task_status关联", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryFlight.json", method = RequestMethod.POST)
    public ServerResponse queryFlight(@ApiParam("计划日期")@RequestParam("planDate") String planDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airCompany,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------TaskStatusController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("planDate",planDate);
        queryMap.put("airCompany",airCompany);

        List<TaskStatus> broadingPortDetail = taskService.queryFlightList(queryMap);
        return ServerResponse.createBySuccess(broadingPortDetail);
    }


    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("航班号")@RequestParam("flight_no_iata") String flight_no_iata,
                                @ApiParam("查询日期") @RequestParam("query_date") String query_date,
                                @ApiParam("接受人") @RequestParam("receiver") String receiver,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------TaskController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("flight_no_iata",flight_no_iata);
        queryMap.put("query_date",query_date);
        queryMap.put("receiver",receiver);
        List<TaskStatus> task = taskService.queryList(queryMap);
        return ServerResponse.createBySuccess(task);
    }
    @ApiOperation(httpMethod = "POST", value = "增加任务", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    public ServerResponse saveTask(TaskStatus task) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp t=new java.sql.Timestamp(System.currentTimeMillis());
        task.setSend_Time(t);
        String taskid= sdf.format(date);
        System.out.println("------------TaskController saveUser"+taskid+"-----------------");
      //  task.setTaskid(Integer.parseInt(taskid));
        taskService.save(task);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "新增用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    public ServerResponse updateTaskStatus(TaskStatus status) {
        System.out.println("------------TaskStatusController updateTaskStatus-----------------");
        java.sql.Timestamp t=new java.sql.Timestamp(System.currentTimeMillis());
        status.setReceive_Time(t);
        //status.setEND_TIME(t);
        taskService.update(status);
        return ServerResponse.createBySuccess();
    }
}
