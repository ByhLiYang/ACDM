package com.hq.acdm.controller.statistics.warningInfo;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.warningInfo.*;
import com.hq.acdm.service.statistics.warningInfo.WarningInfoService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/11/30 0030 10:22
 */
@Api(description = "大面积延误处置")
@RestController
@RequestMapping("/unfavorableSynergy/bigDelay")
@Slf4j
public class WarningInfoController {
    @Resource
    private WarningInfoService warningInfoService;
    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.GET)
    public ServerResponse findLocation() throws ParseException {
        return ServerResponse.createBySuccess(warningInfoService.queryWarningInfo());
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/start.json", method = RequestMethod.POST)
    public ServerResponse findDirection(@ApiParam("操作人") @RequestParam("user") String user,
                                        @ApiParam("状态") @RequestParam("status") String status,
                                        HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("status",status);
        int result = 0;
        result = warningInfoService.INSERT_OPERATION_LOG(map);
        return ServerResponse.createBySuccess(status);
    }
}
