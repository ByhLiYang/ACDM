package com.hq.acdm.controller.index;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.index.SceneMoniterService;
import com.hq.acdm.vo.index.FlightFulInfoVo;
import com.hq.acdm.vo.index.SceneMoniterVo;
import com.hq.acdm.vo.index.StandStatusVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/11/16 15:10
 * @Description
 */
@Api(description = "场面监管")
@RestController
@RequestMapping("/index/sceneMoniter")
public class SceneMoniterController {
    @Resource
    private SceneMoniterService sceneMoniterService;
    @ApiOperation(httpMethod = "GET", value = "顶部数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/top.json", method = RequestMethod.GET)
    public ServerResponse<SceneMoniterVo> getSceneMoniter() {
        return ServerResponse.createBySuccess(sceneMoniterService.getSceneMoniter());
    }
    @ApiOperation(httpMethod = "POST", value = "航班信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFlightFullInfo.json", method = RequestMethod.POST)
    public ServerResponse<FlightFulInfoVo> findFlightFullInfo(@RequestParam(value = "flight_no_iata", defaultValue = "") String flight_no_iata,
                                                              @RequestParam(value = "a_or_d", defaultValue = "") String a_or_d) {
        FlightFulInfoVo flightFulInfoVo = sceneMoniterService.findFlightFullInfo(flight_no_iata,a_or_d);
        if(null==flightFulInfoVo){
            flightFulInfoVo = new FlightFulInfoVo();
        }
        return ServerResponse.createBySuccess(flightFulInfoVo);
    }
    @ApiOperation(httpMethod = "GET", value = "机位信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findOccupyStand.json", method = RequestMethod.GET)
    public ServerResponse<List<StandStatusVo>> findOccupyStand() {
        return ServerResponse.createBySuccess(sceneMoniterService.findOccupyStand());
    }
}
