package com.hq.acdm.controller.supervision;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.supervision.IManagerMonitorService;
import com.hq.acdm.vo.supervision.managermonitor.OutBoundDelayVo;
import com.hq.acdm.vo.supervision.managermonitor.ParkingSpaceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author lizhifeng
 * @Date 2018/9/17 0017
 * @Description:
 */
@Api(description = "值班经理监管Api")
@RestController
@RequestMapping("/supervision/managerMonitor")
public class ManagerMonitorController {

    @Resource
    private IManagerMonitorService managerMonitorService;

    @ApiOperation(httpMethod = "GET", value = "当日跑道方向 出港延误", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("getOne.json")
    public ServerResponse<OutBoundDelayVo> getOne() {
        OutBoundDelayVo one = managerMonitorService.getOne();
        return ServerResponse.createBySuccess(one);
    }

    @ApiOperation(httpMethod = "GET", value = "本小时和未来一小时起降航班数量 机场空闲停机位", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("getTwo.json")
    public ServerResponse<ParkingSpaceVo> getTwo() {
        ParkingSpaceVo two = managerMonitorService.getTwo();
        return ServerResponse.createBySuccess(two);
    }
}
