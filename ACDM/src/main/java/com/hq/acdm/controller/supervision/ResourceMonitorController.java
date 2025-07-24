package com.hq.acdm.controller.supervision;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.supervision.ResourceMonitorService;
import com.hq.acdm.vo.supervision.ResourceMonitor.*;
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
 * @date 2018/11/07 10:33
 * @Description
 */
@Api(description = "资源席位监控管理Api")
@RestController
@RequestMapping("/supervision/resourceMonitor")
public class ResourceMonitorController {
    @Resource
    private ResourceMonitorService resourceMonitorService;
    @ApiOperation(httpMethod = "GET", value = "实时靠桥率", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findCurBoardingRate.json", method = RequestMethod.GET)
    public ServerResponse<List<CurBoardingRateVo>> findCurBoardingRate() {
        return ServerResponse.createBySuccess(resourceMonitorService.findCurBoardingRate());
    }
    @ApiOperation(httpMethod = "GET", value = "滞留航班延误排行", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDelayList.json", method = RequestMethod.GET)
    public ServerResponse<List<DelayListVo>> findDelayList() {
        return ServerResponse.createBySuccess(resourceMonitorService.findDelayList());
    }
    @ApiOperation(httpMethod = "GET", value = "滞留航线延误排行", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDelayListDesc.json", method = RequestMethod.GET)
    public ServerResponse<List<DelayListDescVo>> findDelayListDesc() {
        return ServerResponse.createBySuccess(resourceMonitorService.findDelayListDesc());
    }
    @ApiOperation(httpMethod = "GET", value = "机位冲突预警总数", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findConflictAlarm.json", method = RequestMethod.GET)
    public ServerResponse<StandConflict2Vo> findConflictAlarm() {
        StandConflict2Vo standConflict2Vo = new StandConflict2Vo();
        standConflict2Vo.setStandConflictVoList(resourceMonitorService.findConflictAlarm());
        standConflict2Vo.setSum(resourceMonitorService.findConflictAlarmCount());
        return ServerResponse.createBySuccess(standConflict2Vo);
    }
    @ApiOperation(httpMethod = "GET", value = "机场空闲停机位", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFreeStand.json", method = RequestMethod.GET)
    public ServerResponse<FreeStand2Vo> findFreeStand() {
        FreeStand2Vo freeStand2Vo = new FreeStand2Vo();
        freeStand2Vo.setFreeStandVoList(resourceMonitorService.findFreeStand());
        freeStand2Vo.setSum(resourceMonitorService.findFreeStandCount());
        return ServerResponse.createBySuccess(freeStand2Vo);
    }
}
