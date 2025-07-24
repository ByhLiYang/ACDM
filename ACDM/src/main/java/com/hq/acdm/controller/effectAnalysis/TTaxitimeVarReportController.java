package com.hq.acdm.controller.effectAnalysis;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.effectAnalysis.TTaxitimeVarReportService;
import com.hq.acdm.vo.effectAnalysis.*;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "平均滑行时长")
@RestController
@RequestMapping("/effectAnalysis/ttaxitimeVarReport")
public class TTaxitimeVarReportController {

    @Resource
    private TTaxitimeVarReportService tTaxitimeVarReportService;

    @ApiOperation(httpMethod = "POST", value = "平均滑行时长", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findTTaxitimeVarInfo.json", method = RequestMethod.POST)
    public ServerResponse findTTaxitimeVarInfo(@ApiParam("类型") @RequestParam("dora") String dora,
                                            @ApiParam("时间段") @RequestParam("period") String period,
                                            @ApiParam("跑道方向") @RequestParam("runway") String runway,
                                            @ApiParam("机位号") @RequestParam("stand") String stand,
                                            @ApiParam("机型") @RequestParam("craftTypeIcao") String craftTypeIcao,
                         HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("dora",dora);
        queryMap.put("period",period);
        queryMap.put("runway",runway);
        queryMap.put("stand",stand);
        queryMap.put("craftTypeIcao",craftTypeIcao);
        List<TTaxitimeVarReportVo> list = tTaxitimeVarReportService.findTTaxitimeVarInfo(queryMap);

        return ServerResponse.createBySuccess(list);
    }

    @ApiOperation(httpMethod = "GET", value = "跑道方向查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAllRunway.json", method = RequestMethod.GET)
    public ServerResponse findAllRunway() {
        List<String> allRunway = tTaxitimeVarReportService.findAllRunway();
        return ServerResponse.createBySuccess(allRunway);
    }

    @ApiOperation(httpMethod = "GET", value = "机位号查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAllStand.json", method = RequestMethod.GET)
    public ServerResponse findAllStand() {
        List<String> allStand = tTaxitimeVarReportService.findAllStand();
        return ServerResponse.createBySuccess(allStand);
    }

    @ApiOperation(httpMethod = "GET", value = "机型查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAllCraftTypeIcao.json", method = RequestMethod.GET)
    public ServerResponse findAllCraftTypeIcao() {
        List<String> allCraftTypeIcao = tTaxitimeVarReportService.findAllCraftTypeIcao();
        return ServerResponse.createBySuccess(allCraftTypeIcao);
    }

    @ApiOperation(httpMethod = "GET", value = "时间段查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAllPeriod.json", method = RequestMethod.GET)
    public ServerResponse findAllPeriod() {
        List<String> allPeriod = tTaxitimeVarReportService.findAllPeriod();
        return ServerResponse.createBySuccess(allPeriod);
    }

}
