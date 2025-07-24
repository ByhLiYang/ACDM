package com.hq.acdm.controller.effectAnalysis;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.effectAnalysis.NodeCoverageReportService;
import com.hq.acdm.service.effectAnalysis.SmallDelayAnalysisService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.vo.effectAnalysis.NodeCoverageBarVo;
import com.hq.acdm.vo.effectAnalysis.NodeCoveragePieVo;
import com.hq.acdm.vo.effectAnalysis.NodeCoverageReportVo;
import com.hq.acdm.vo.effectAnalysis.NodeCoverageTableVo;
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
@Api(description = "小延误分析")
@RestController
@RequestMapping("/effectAnalysis/smallDelayAnalysis")
public class SmallDelayAnalysisController {

    @Resource
    private SmallDelayAnalysisService smallDelayAnalysisService;

    @ApiOperation(httpMethod = "POST", value = "未选择航线查询小延误", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findSmallDelayAllInfo.json", method = RequestMethod.POST)
    public ServerResponse findSmallDelayAllInfo(@ApiParam("查询开始时间") @RequestParam("startDate") String startDate,
                                              @ApiParam("查询结束时间") @RequestParam("endDate") String endDate,
                                              HttpServletRequest request, HttpServletResponse response) {
        Date startTime = DateTimeUtil.strToDate(startDate,"yyyy-MM-dd");
        Date endTime = DateTimeUtil.strToDate(endDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startTime);
        queryMap.put("endDate",endTime);
        queryMap.put("startDateStr",startDate);
        queryMap.put("endDateStr",endDate);
        Map<String, Object> map = smallDelayAnalysisService.findSmallDelayAllInfo(queryMap);

        return ServerResponse.createBySuccess(map);
    }


    @ApiOperation(httpMethod = "POST", value = "选择航线查询小延误", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findSmallDelayAllInfoByAdes.json", method = RequestMethod.POST)
    public ServerResponse findSmallDelayAllInfoByAdes(@ApiParam("查询开始时间") @RequestParam("startDate") String startDate,
                                                      @ApiParam("查询结束时间") @RequestParam("endDate") String endDate,
                                                      @ApiParam("目的站") @RequestParam("ades") String ades,
                                            HttpServletRequest request, HttpServletResponse response) {
        Date startTime = DateTimeUtil.strToDate(startDate,"yyyy-MM-dd");
        Date endTime = DateTimeUtil.strToDate(endDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startTime);
        queryMap.put("endDate",endTime);
        queryMap.put("ades",ades);
        queryMap.put("startDateStr",startDate);
        queryMap.put("endDateStr",endDate);
        Map<String, Object> map = smallDelayAnalysisService.findSmallDelayAllInfoByAdes(queryMap);

        return ServerResponse.createBySuccess(map);
    }

    @ApiOperation(httpMethod = "POST", value = "查询小延误详细信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findSmallDelayDetails.json", method = RequestMethod.POST)
    public ServerResponse findSmallDelayDetails(@ApiParam("查询开始时间") @RequestParam("startDate") String startDate,
                                                @ApiParam("查询结束时间") @RequestParam("endDate") String endDate,
                                                HttpServletRequest request, HttpServletResponse response) {
        Date startTime = DateTimeUtil.strToDate(startDate,"yyyy-MM-dd");
        Date endTime = DateTimeUtil.strToDate(endDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startTime);
        queryMap.put("endDate",endTime);
        queryMap.put("startDateStr",startDate);
        queryMap.put("endDateStr",endDate);
        Map<String, Object> map = smallDelayAnalysisService.findSmallDelayDetails(queryMap);

        return ServerResponse.createBySuccess(map);
    }



}
