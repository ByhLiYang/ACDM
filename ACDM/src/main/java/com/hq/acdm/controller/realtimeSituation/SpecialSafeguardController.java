package com.hq.acdm.controller.realtimeSituation;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.realtimeSituation.SpecialSafeguardService;
import com.hq.acdm.vo.realtimeSituation.SpecialSafeguardVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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


@Api(description = "特殊保障")
@RestController
@RequestMapping("/realtimeSituation/specialSafeguard")
public class SpecialSafeguardController {

    @Resource
    private SpecialSafeguardService specialSafeguardService;

    @ApiOperation(httpMethod = "GET", value = "特殊保障", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findSpecialFltInfo.json", method = RequestMethod.GET)
    public ServerResponse findSpecialFltInfo(@ApiParam("特殊保障")
                                           HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("agent","");
        List<SpecialSafeguardVo> list = specialSafeguardService.findSpecialFltInfo(queryMap);
        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "POST", value = "流控信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findTMdrsInfo.json", method = RequestMethod.POST)
    public ServerResponse findTMdrsInfo(@ApiParam("流控信息")
                                            @RequestParam("content") String content,
                                            HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("content",content);
        List<String> list = specialSafeguardService.findTMdrsInfo(queryMap);
        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "POST", value = "放行临界延误临界告警信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFlightCaveatInfo.json", method = RequestMethod.POST)
    public ServerResponse findFlightCaveatInfo(
                                        HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> queryMap = new HashMap<>();
        List<String> list = specialSafeguardService.findFlightCaveatInfo(queryMap);
        return ServerResponse.createBySuccess(list);
    }

}
