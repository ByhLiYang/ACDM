package com.hq.acdm.controller.statistics.runningGuarantee;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.optimize.optimizeModel;
import com.hq.acdm.service.statistics.runningGuarantee.RunningGuaranteeService;
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
import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/12/7 0007 9:33
 */
@Api(description = "运行保障")
@RestController
@RequestMapping("/running/guarantee")
@Slf4j
public class RunningGuaranteeController {
    @Resource
    private RunningGuaranteeService runningGuaranteeService;


    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse queryOne(
                                   @ApiParam("起始时间") @RequestParam("start") String start,
                                   @ApiParam("操作日期") @RequestParam("operational_date") String operationalDate,
                                   @ApiParam("截止时间") @RequestParam("end") String end,
                                   HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<>();
        map.put("operational_date",operationalDate);
        map.put("start",start);
        map.put("end",end);
        return ServerResponse.createBySuccess(runningGuaranteeService.query(map));
    }
}
