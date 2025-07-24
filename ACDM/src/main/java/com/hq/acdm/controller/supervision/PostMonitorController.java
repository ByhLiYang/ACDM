package com.hq.acdm.controller.supervision;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.supervision.PostMonitorService;
import com.hq.acdm.vo.supervision.ResourceMonitor.StandConflictVo;
import com.hq.acdm.vo.supervision.postMonitor.PostMonitor;
import com.hq.acdm.vo.supervision.postMonitor.PostMonitorVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/11/07 10:30
 * @Description
 */
@Api(description = "监管岗位监控管理Api")
@RestController
@RequestMapping("/supervision/postMonitor")
public class PostMonitorController {
    @Resource
    private PostMonitorService postMonitorService;
    @ApiOperation(httpMethod = "GET", value = "预计延误时间超过预警值", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getTheDelay.json", method = RequestMethod.GET)
    public ServerResponse<PostMonitorVo> getTheDelay() {
        PostMonitorVo postMonitorVo = new PostMonitorVo();
        postMonitorVo.setPostMonitorList(postMonitorService.findTheDelay());
        postMonitorVo.setSum(postMonitorService.findTheDelayCount());
        return ServerResponse.createBySuccess(postMonitorVo);
    }
    @ApiOperation(httpMethod = "GET", value = "机上等待时间超过预警值", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getForthe.json", method = RequestMethod.GET)
    public ServerResponse<PostMonitorVo> getForthe() {
        PostMonitorVo postMonitorVo = new PostMonitorVo();
        postMonitorVo.setPostMonitorList(postMonitorService.findForthe());
        postMonitorVo.setSum(postMonitorService.findFortheCount());
        return ServerResponse.createBySuccess(postMonitorVo);
    }
    @ApiOperation(httpMethod = "GET", value = "登机开始时间超过预警值", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getStartBoarding.json", method = RequestMethod.GET)
    public ServerResponse<PostMonitorVo> getStartBoarding() {
        PostMonitorVo postMonitorVo = new PostMonitorVo();
        postMonitorVo.setPostMonitorList(postMonitorService.findStartBoarding());
        postMonitorVo.setSum(postMonitorService.findStartBoardingCount());
        return ServerResponse.createBySuccess(postMonitorVo);
    }
    @ApiOperation(httpMethod = "GET", value = "滑入超过预警值", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getRollIn.json", method = RequestMethod.GET)
    public ServerResponse<PostMonitorVo> getRollIn() {
        PostMonitorVo postMonitorVo = new PostMonitorVo();
        postMonitorVo.setPostMonitorList(postMonitorService.findRollIn());
        postMonitorVo.setSum(postMonitorService.findRollInCount());
        return ServerResponse.createBySuccess(postMonitorVo);
    }
    @ApiOperation(httpMethod = "GET", value = "滑出超过预警值", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getRollOut.json", method = RequestMethod.GET)
    public ServerResponse<PostMonitorVo> getRollOut() {
        PostMonitorVo postMonitorVo = new PostMonitorVo();
        postMonitorVo.setPostMonitorList(postMonitorService.findRollOut());
        postMonitorVo.setSum(postMonitorService.findRollOutCount());
        return ServerResponse.createBySuccess(postMonitorVo);
    }
}
