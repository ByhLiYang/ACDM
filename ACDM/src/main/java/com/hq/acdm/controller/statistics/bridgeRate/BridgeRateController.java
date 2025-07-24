package com.hq.acdm.controller.statistics.bridgeRate;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.bridgeRate.BridgeRateT1;
import com.hq.acdm.model.statistics.bridgeRate.BridgeRateT2;
import com.hq.acdm.model.statistics.bridgeRate.T1;
import com.hq.acdm.model.statistics.bridgeRate.T2;
import com.hq.acdm.service.statistics.bridgeRate.BridgeRateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/9/25 0025 15:27
 */
@Api(description = "靠桥率")
@RestController
@RequestMapping("/statisticalReport/bridgeRate")
@Slf4j
public class BridgeRateController {
    @Resource
    private BridgeRateService bridgeRateService;
    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/t1query.json", method = RequestMethod.GET)
    public ServerResponse t1overAquery() {

        return ServerResponse.createBySuccess(bridgeRateService.queryT1());
    }

//K 可靠
//S 实靠
//DS 大型机实靠
    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/t2query.json", method = RequestMethod.GET)
    public ServerResponse t2query() {

        return ServerResponse.createBySuccess(bridgeRateService.queryT2());
    }
}
