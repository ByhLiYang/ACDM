package com.hq.acdm.controller.effectAnalysis;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.effectAnalysis.NodeCoverageReportService;
import com.hq.acdm.util.DateTimeUtil;
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
@Api(description = "保障节点覆盖率报表")
@RestController
@RequestMapping("/effectAnalysis/nodeCoverageReport")
public class NodeCoverageReportController {

    @Resource
    private NodeCoverageReportService nodeCoverageReportService;

    @ApiOperation(httpMethod = "POST", value = "查询单进航班保障节点数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findNodeCoverageA.json", method = RequestMethod.POST)
    public ServerResponse findNodeCoverageA(@ApiParam("查询开始时间") @RequestParam("startDate") String startDate,
                                            @ApiParam("查询结束时间") @RequestParam("endDate") String endDate,
                         HttpServletRequest request, HttpServletResponse response) {
        Date startTime = DateTimeUtil.strToDate(startDate,"yyyy-MM-dd");
        Date endTime = DateTimeUtil.strToDate(endDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startTime);
        queryMap.put("endDate",endTime);
        List<NodeCoverageReportVo> list = nodeCoverageReportService.findAllNodeCoverageA(queryMap);

        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "POST", value = "查询单出航班保障节点数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findNodeCoverageD.json", method = RequestMethod.POST)
    public ServerResponse findNodeCoverageD(@ApiParam("查询开始时间") @RequestParam("startDate") String startDate,
                                            @ApiParam("查询结束时间") @RequestParam("endDate") String endDate,
                                            HttpServletRequest request, HttpServletResponse response) {
        Date startTime = DateTimeUtil.strToDate(startDate,"yyyy-MM-dd");
        Date endTime = DateTimeUtil.strToDate(endDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startTime);
        queryMap.put("endDate",endTime);
        List<NodeCoverageReportVo> list = nodeCoverageReportService.findAllNodeCoverageD(queryMap);

        return ServerResponse.createBySuccess(list);
    }

    @ApiOperation(httpMethod = "POST", value = "查询过站(进出港)航班保障节点数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findNodeCoverageDandA.json", method = RequestMethod.POST)
    public ServerResponse findNodeCoverageDandA(@ApiParam("查询开始时间") @RequestParam("startDate") String startDate,
                                            @ApiParam("查询结束时间") @RequestParam("endDate") String endDate,
                                            HttpServletRequest request, HttpServletResponse response) {
        Date startTime = DateTimeUtil.strToDate(startDate,"yyyy-MM-dd");
        Date endTime = DateTimeUtil.strToDate(endDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startTime);
        queryMap.put("endDate",endTime);
        List<NodeCoverageReportVo> list = nodeCoverageReportService.findAllNodeCoverageDandA(queryMap);

        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "POST", value = "查询饼图数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findPieData.json", method = RequestMethod.POST)
    public ServerResponse findPieData(@ApiParam("查询开始时间") @RequestParam("startDate") String startDate,
                                                @ApiParam("查询结束时间") @RequestParam("endDate") String endDate,
                                                HttpServletRequest request, HttpServletResponse response) {
        Date startTime = DateTimeUtil.strToDate(startDate,"yyyy-MM-dd");
        Date endTime = DateTimeUtil.strToDate(endDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startTime);
        queryMap.put("endDate",endTime);
        NodeCoveragePieVo vo = nodeCoverageReportService.findPieData(queryMap);

        return ServerResponse.createBySuccess(vo);
    }

    @ApiOperation(httpMethod = "POST", value = "查询柱状图数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findBarData.json", method = RequestMethod.POST)
    public ServerResponse findBarData(@ApiParam("查询开始时间") @RequestParam("startDate") String startDate,
                                      @ApiParam("查询结束时间") @RequestParam("endDate") String endDate,
                                      HttpServletRequest request, HttpServletResponse response) {
        Date startTime = DateTimeUtil.strToDate(startDate,"yyyy-MM-dd");
        Date endTime = DateTimeUtil.strToDate(endDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startTime);
        queryMap.put("endDate",endTime);
        NodeCoverageBarVo vo = nodeCoverageReportService.findBarData(queryMap);

        return ServerResponse.createBySuccess(vo);
    }


    @ApiOperation(httpMethod = "POST", value = "查询列表数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findTableData.json", method = RequestMethod.POST)
    public ServerResponse findTableData(@ApiParam("查询开始时间") @RequestParam("startDate") String startDate,
                                      @ApiParam("查询结束时间") @RequestParam("endDate") String endDate,
                                      HttpServletRequest request, HttpServletResponse response) {
        Date startTime = DateTimeUtil.strToDate(startDate,"yyyy-MM-dd");
        Date endTime = DateTimeUtil.strToDate(endDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startTime);
        queryMap.put("endDate",endTime);
        List<NodeCoverageTableVo> list = nodeCoverageReportService.findTableData(queryMap);

        return ServerResponse.createBySuccess(list);
    }



    @ApiOperation(httpMethod = "POST", value = "查询邮件统计数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findMAILData.json", method = RequestMethod.POST)
    public ServerResponse findMAILData(@ApiParam("查询开始时间") @RequestParam("startDate") String startDate,
                                      @ApiParam("查询结束时间") @RequestParam("endDate") String endDate,
                                      HttpServletRequest request, HttpServletResponse response) {
        Date startTime = DateTimeUtil.strToDate(startDate,"yyyy-MM-dd");
        Date endTime = DateTimeUtil.strToDate(endDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startTime);
        queryMap.put("endDate",endTime);
        MAILCoveragePieAndBarVo vo = nodeCoverageReportService.findMAILCoverageD(queryMap);

        return ServerResponse.createBySuccess(vo);
    }
}
