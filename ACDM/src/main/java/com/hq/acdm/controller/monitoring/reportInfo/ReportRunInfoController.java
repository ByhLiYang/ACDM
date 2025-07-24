package com.hq.acdm.controller.monitoring.reportInfo;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.monitoring.reportInfo.ReportRunInfo;
import com.hq.acdm.service.monitoring.reportInfo.ReportRunInfoService;
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

@Api(description = "查询简报，带状态，运行信息")
@RestController
@RequestMapping("/flightSupervision/reportRunInfo")
@Slf4j
public class ReportRunInfoController {

    @Resource
    private ReportRunInfoService taskService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("查询日期") @RequestParam("query_date") String query_date,
                                @ApiParam("状态") @RequestParam("status") String status,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------ReportRunInfoController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("query_date",query_date);
        queryMap.put("status",status);
        List<ReportRunInfo> task = taskService.queryList(queryMap);
        return ServerResponse.createBySuccess(task);
    }
    @ApiOperation(httpMethod = "POST", value = "增加任务", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    public ServerResponse saveReportInfo(ReportRunInfo task,@ApiParam("submitType") @RequestParam("submitType") String submitType) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        java.util.Date date = new java.util.Date();
        java.sql.Timestamp t=new java.sql.Timestamp(System.currentTimeMillis());
        System.out.println("-------------submitType:"+submitType);
        task.setReport_time(t);
        String taskid= sdf.format(date);
        System.out.println("------------ReportRunInfoController saveUser"+taskid+"-----------------");
      //  task.setTaskid(Integer.parseInt(taskid));
        if(submitType!=null&&submitType.equals("1")){//update
            taskService.update(task);

        }else {
            taskService.save(task);
        }
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "新增用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    public ServerResponse updateReportInfo(ReportRunInfo status) {
        System.out.println("------------ReportRunInfoController updateTaskStatus-----------------");
        java.sql.Timestamp t=new java.sql.Timestamp(System.currentTimeMillis());
        status.setReport_time(t);
        //status.setEND_TIME(t);
        //向移动端推送信息
//        com.hq.acdm.controller.monitoring.mobile.MsgPush.sendAll("简报-运行信息",status.getContent());


        taskService.updateStatus(status);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "新增用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delete.json", method = RequestMethod.GET)
    public ServerResponse delete(ReportRunInfo info) {
        System.out.println("------------ReportRunInfoController delete-----------------");

        taskService.delete(info.getId());
        return ServerResponse.createBySuccess();
    }
}
