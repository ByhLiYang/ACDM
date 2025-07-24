package com.hq.acdm.controller.monitoring.mobile;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.monitoring.mobile.MobileCheckin;
import com.hq.acdm.service.monitoring.mobile.MobileCheckinService;
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
@RequestMapping("/mobile/mobileCheckin")
@Slf4j
public class MobileCheckinController {

    @Resource
    private MobileCheckinService taskService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("查询日期") @RequestParam("query_date") String query_date,
                                @ApiParam("状态") @RequestParam("status") String status,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------ReportRunInfoController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("query_date",query_date);
        queryMap.put("status",status);
        List<MobileCheckin> task = taskService.queryList(queryMap);
        return ServerResponse.createBySuccess(task);
    }
    @ApiOperation(httpMethod = "POST", value = "移动登录", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/save.json", method = RequestMethod.POST)
    public ServerResponse saveReportInfo(MobileCheckin mobile) {

      //  taskService.queryList()
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp t=new java.sql.Timestamp(System.currentTimeMillis());


        String taskid= sdf.format(date);

        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("devicetoken",mobile.getDeviceToken());
        queryMap.put("deviceType",mobile.getDeviceType());
       queryMap.put("userId",mobile.getUserId());
        List<MobileCheckin> list = taskService.queryList(queryMap);
        if(list!=null&&list.size()>0) {//update
            System.out.println("------------MobileCheckinController update-----------------");
            mobile.setLoginTime(t);
            taskService.update(mobile);
        }else {     System.out.println("------------MobileCheckinController insert-----------------");
            mobile.setCreateTime(t);
            taskService.save(mobile);
        }

        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "新增用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    public ServerResponse updateReportInfo(MobileCheckin status) {
        System.out.println("------------ReportRunInfoController updateTaskStatus-----------------");
        java.sql.Timestamp t=new java.sql.Timestamp(System.currentTimeMillis());
   //     status.setReport_time(t);
        //status.setEND_TIME(t);
        taskService.update(status);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "新增用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delete.json", method = RequestMethod.POST)
    public ServerResponse delete(MobileCheckin info) {
        System.out.println("------------ReportRunInfoController delete-----------------");

        taskService.delete(info.getId());
        return ServerResponse.createBySuccess();
    }
}
