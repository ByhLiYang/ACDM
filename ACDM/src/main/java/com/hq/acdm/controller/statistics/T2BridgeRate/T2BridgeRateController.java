package com.hq.acdm.controller.statistics.T2BridgeRate;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.T2BridgeRate.T2BridgeRate;
import com.hq.acdm.service.statistics.T2BridgeRate.T2BridgeRateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import sun.dc.pr.PRError;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/8 0008 10:23
 */
@Api(description = "T2靠桥率")
@Slf4j
@RestController
@RequestMapping("/statisticalReport/T2BridgeRate")
public class T2BridgeRateController {
    @Resource
    private T2BridgeRateService t2BridgeRateService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(
            @ApiParam("开始时间") @RequestParam("start") String startTime,
            @ApiParam("结束时间") @RequestParam("end") String endTime,
            @ApiParam("航空公司") @RequestParam("airCompany") String airCompany,
        HttpServletRequest request,HttpServletResponse response
    ){
        if("全部".equals(airCompany)){
            airCompany = "";
        }
        Map<String,Object> map = new HashMap<>();
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        map.put("airCompany",airCompany);
        return ServerResponse.createBySuccess(t2BridgeRateService.queryT2BridgeRate(map));
    }
}
