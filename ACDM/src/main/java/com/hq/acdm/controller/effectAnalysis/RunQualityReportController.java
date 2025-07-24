package com.hq.acdm.controller.effectAnalysis;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.effectAnalysis.RunQualityReportService;
import com.hq.acdm.util.*;
import com.hq.acdm.util.excel.JxlsBuilder;
import com.hq.acdm.vo.effectAnalysis.*;
import com.hq.acdm.vo.statistics.lnitialNormalRate.LnitialNormalRateVo;
import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.type.TypeReference;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "运行品质简报")
@RestController
@Slf4j
@RequestMapping("/effectAnalysis/runQualityReport")
public class RunQualityReportController {

    @Resource
    private RunQualityReportService runQualityReportService;

    @Resource
    private SysCacheService sysCacheService;

    @ApiOperation(httpMethod = "GET", value = "运行品质简报", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findRunQualityReportByDate.json", method = RequestMethod.GET)
    public ServerResponse findRunQualityReportByDate(@ApiParam("运行品质简报")
                                         @RequestParam("execDate") String execDate,
                                         @RequestParam("agent") String agent,
                         HttpServletRequest request, HttpServletResponse response) {
        Date date = DateTimeUtil.strToDate(execDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("execDate",date);
        queryMap.put("agent",agent);
        queryMap.put("execDate2",execDate);
        List<RunQualityReportVo> list = runQualityReportService.findRunQualityReportByDate(queryMap);

        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "GET", value = "运行品质简报小时架次统计图", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findEChartsInfo.json", method = RequestMethod.GET)
    public ServerResponse findEChartsInfo(@ApiParam("运行品质简报小时架次统计图")
                                     @RequestParam("execDate") String execDate,
                                     @RequestParam("agent") String agent,
                                     HttpServletRequest request, HttpServletResponse response) {
        Date date = DateTimeUtil.strToDate(execDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("execDate",date);
        queryMap.put("agent",agent);
        queryMap.put("execDate2",execDate);
        List<RunQualityReportEChartVo> list = runQualityReportService.findEChartsInfo(queryMap);

        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "GET", value = "运行品质简报机场运量统计", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findYunLiangTJInfo.json", method = RequestMethod.GET)
    public ServerResponse findYunLiangTJInfo(@ApiParam("运行品质简报机场运量统计")
                                          @RequestParam("execDate") String execDate,
                                             @RequestParam("agent") String agent,
                                          HttpServletRequest request, HttpServletResponse response) {
        Date date = DateTimeUtil.strToDate(execDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("execDate",date);
        queryMap.put("agent",agent);
        queryMap.put("execDate2",execDate);
        List<RunQualityReportYLTJVo> list = runQualityReportService.findYunLiangTJInfo(queryMap);

        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "GET", value = "运行品质简报航班正常性统计", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findHBZCXTJInfo.json", method = RequestMethod.GET)
    public ServerResponse findHBZCXTJInfo(@ApiParam("运行品质简报航班正常性统计")
                                             @RequestParam("execDate") String execDate,
                                                @RequestParam("agent") String agent,
                                             HttpServletRequest request, HttpServletResponse response) {
        Date date = DateTimeUtil.strToDate(execDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("execDate",date);
        queryMap.put("agent",agent);
        queryMap.put("execDate2",execDate);
        List<RunQualityReportYLTJVo> list = runQualityReportService.findHBZCXTJInfo(queryMap);

        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "GET", value = "运行品质简报延误原因统计", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findYWYYTJInfo.json", method = RequestMethod.GET)
    public ServerResponse findYWYYTJInfo(@ApiParam("运行品质简报延误原因统计")
                                          @RequestParam("execDate") String execDate,
                                         @RequestParam("agent") String agent,
                                          HttpServletRequest request, HttpServletResponse response) {
        Date date = DateTimeUtil.strToDate(execDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("execDate",date);
        queryMap.put("agent",agent);
        queryMap.put("execDate2",execDate);
        List<RunQualityReportYWYYVo> list = runQualityReportService.findYWYYTJInfo(queryMap);

        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "GET", value = "运行品质简报航班进程质量管控", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findHBJCZLJGInfo.json", method = RequestMethod.GET)
    public ServerResponse findHBJCZLJGInfo(@ApiParam("运行品质简报航班进程质量管控")
                                         @RequestParam("execDate") String execDate,
                                           @RequestParam("agent") String agent,
                                         HttpServletRequest request, HttpServletResponse response) {
        Date date = DateTimeUtil.strToDate(execDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("execDate",date);
        queryMap.put("agent",agent);
        queryMap.put("execDate2",execDate);
        List<RunQualityReportJCZLJGVo> list = runQualityReportService.findHBJCZLJGInfo(queryMap);

        return ServerResponse.createBySuccess(list);
    }

    @ApiOperation(httpMethod = "GET", value = "运行品质简报放行正常率排名", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFXZCLPMInfo.json", method = RequestMethod.GET)
    public ServerResponse findFXZCLPMInfo(@ApiParam("运行品质简报放行正常率排名")
                                           @RequestParam("execDate") String execDate,
                                          @RequestParam("agent") String agent,
                                           HttpServletRequest request, HttpServletResponse response) {
        Date date = DateTimeUtil.strToDate(execDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("execDate",date);
        queryMap.put("agent",agent);
        queryMap.put("execDate2",execDate);
        List<RunQualityReportFXZCLPMVo> list = runQualityReportService.findFXZCLPMInfo(queryMap);
        return ServerResponse.createBySuccess(list);
    }

    @ApiOperation(httpMethod = "GET", value = "运行品质简报航班正常管理提示", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFltManageTipsInfo.json", method = RequestMethod.GET)
    public ServerResponse findFltManageTipsInfo(@ApiParam("运行品质简报航班正常管理提示")
                                          @RequestParam("execDate") String execDate,
                                           @RequestParam("agent") String agent,
                                          HttpServletRequest request, HttpServletResponse response) {
        Date date = DateTimeUtil.strToDate(execDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("execDate",date);
        queryMap.put("agent",agent);
        queryMap.put("execDate2",execDate);
        List<RunQualityReportTipsVo> list = runQualityReportService.findFltManageTipsInfo(queryMap);
        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "POST", value = "导出EXCEL报表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/exportReport.json", method = RequestMethod.POST)
    public void exportReport(@ApiParam("执行日期") @RequestParam("execDate") String execDate,
                             @ApiParam("航司二码") @RequestParam("agent") String agent,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        Date date = DateTimeUtil.strToDate(execDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("execDate",date);
        queryMap.put("agent",agent);
        queryMap.put("execDate2",execDate);
        //小时架次图
        List<RunQualityReportEChartVo> listEChart = runQualityReportService.findEChartsInfo(queryMap);
        //运量统计
        List<RunQualityReportYLTJVo> listYLTJ = runQualityReportService.findYunLiangTJInfo(queryMap);
        //航班正常性
        List<RunQualityReportYLTJVo> listHBZCXTJ = runQualityReportService.findHBZCXTJInfo(queryMap);
        //延误原因
        List<RunQualityReportYWYYVo> listYWYY = runQualityReportService.findYWYYTJInfo(queryMap);
        //航班进程质量监管
        List<RunQualityReportJCZLJGVo> listJCZLJG = runQualityReportService.findHBJCZLJGInfo(queryMap);
        //放行正常率排名
        List<RunQualityReportFXZCLPMVo> listFXZCLPM = runQualityReportService.findFXZCLPMInfo(queryMap);
        //航班正常管理提示
        List<RunQualityReportTipsVo> listTips = runQualityReportService.findFltManageTipsInfo(queryMap);


        List yltj = new ArrayList();
        List hbzcxtj = new ArrayList();
        List ywyy = new ArrayList();
        List jczljg = new ArrayList();
        List fxzclpm = new ArrayList();
        List tips = new ArrayList();
        List echartAsjs = new ArrayList();
        List echartDjhs = new ArrayList();
        List echartDsjs = new ArrayList();


        //----运输量统计
        RunQualityReportYLTJVo yltjVo = listYLTJ.get(0);
        yltj.add(yltjVo.getExecDate());
        //运输架次
        yltj.add(yltjVo.getDayHbs()[0]);
        yltj.add(yltjVo.getDayTb()[0]);
        yltj.add(yltjVo.getMonthHbs()[0]);
        yltj.add(yltjVo.getMonthTb()[0]);
        yltj.add(yltjVo.getYearHbs()[0]);
        yltj.add(yltjVo.getYearTb()[0]);
        //人数
        RunQualityReportYLTJVo rstjVo = listYLTJ.get(1);
        yltj.add(rstjVo.getDayHbs()[0]);
        yltj.add(rstjVo.getDayTb()[0]);
        yltj.add(rstjVo.getMonthHbs()[0]);
        yltj.add(rstjVo.getMonthTb()[0]);
        yltj.add(rstjVo.getYearHbs()[0]);
        yltj.add(rstjVo.getYearTb()[0]);


        //----航班正常性统计
        RunQualityReportYLTJVo fxlVo = listHBZCXTJ.get(0);
        hbzcxtj.add(yltjVo.getExecDate());
        //放行率
        hbzcxtj.add(fxlVo.getDayHbs()[0]);
        hbzcxtj.add(fxlVo.getDayTb()[0]);
        hbzcxtj.add(fxlVo.getMonthHbs()[0]);
        hbzcxtj.add(fxlVo.getMonthTb()[0]);
        hbzcxtj.add(fxlVo.getYearHbs()[0]);
        hbzcxtj.add(fxlVo.getYearTb()[0]);
        //始发正常率
        RunQualityReportYLTJVo sfzclVo = listHBZCXTJ.get(1);
        hbzcxtj.add(sfzclVo.getDayHbs()[0]);
        hbzcxtj.add(sfzclVo.getDayTb()[0]);
        hbzcxtj.add(sfzclVo.getMonthHbs()[0]);
        hbzcxtj.add(sfzclVo.getMonthTb()[0]);
        hbzcxtj.add(sfzclVo.getYearHbs()[0]);
        hbzcxtj.add(sfzclVo.getYearTb()[0]);
        //正常率
        RunQualityReportYLTJVo zclVo = listHBZCXTJ.get(2);
        hbzcxtj.add(zclVo.getDayHbs()[0]);
        hbzcxtj.add(zclVo.getDayTb()[0]);
        hbzcxtj.add(zclVo.getMonthHbs()[0]);
        hbzcxtj.add(zclVo.getMonthTb()[0]);
        hbzcxtj.add(zclVo.getYearHbs()[0]);
        hbzcxtj.add(zclVo.getYearTb()[0]);

        //----延误原因统计
        RunQualityReportYWYYVo ywyyVo = listYWYY.get(0);
        ywyy.add(ywyyVo.getDelayTq()[0]);
        ywyy.add(ywyyVo.getDelayGs()[0]);
        ywyy.add(ywyyVo.getDelayLl()[0]);
        ywyy.add(ywyyVo.getDelayHbsk()[0]);
        ywyy.add(ywyyVo.getDelayZshd()[0]);
        ywyy.add(ywyyVo.getDelayKg()[0]);
        ywyy.add(ywyyVo.getDelayJc()[0]);
        ywyy.add(ywyyVo.getDelayLj()[0]);
        ywyy.add(ywyyVo.getDelayYl()[0]);
        ywyy.add(ywyyVo.getDelayLgxt()[0]);
        ywyy.add(ywyyVo.getDelayLk()[0]);
        ywyy.add(ywyyVo.getDelayGgaq()[0]);
        ywyy.add(ywyyVo.getDelayCount());

        //----航班进程质量监管
        jczljg.add(listJCZLJG.get(0).getExecDate());
        for (int i=0;i<listJCZLJG.size();i++){
            RunQualityReportJCZLJGVo vo = listJCZLJG.get(i);
            jczljg.add(vo.getInfo()[0]);
        }

        //----放行正常率排名
        //当天排名
        RunQualityReportFXZCLPMVo fxzclpmVo = listFXZCLPM.get(0);
        fxzclpm.add(fxzclpmVo.getExceDate()[0]);
        fxzclpm.add(fxzclpmVo.getFxlGH()[0]);
        fxzclpm.add(fxzclpmVo.getFxlNH()[0]);
        fxzclpm.add(fxzclpmVo.getFxlDH()[0]);
        fxzclpm.add(fxzclpmVo.getFxlDF()[0]);
        fxzclpm.add(fxzclpmVo.getFxlHY()[0]);
        //累月排名
        RunQualityReportFXZCLPMVo fxzclpmMonthVo = listFXZCLPM.get(1);
        fxzclpm.add(fxzclpmMonthVo.getExceDate()[0]);
        fxzclpm.add(fxzclpmMonthVo.getFxlGH()[0]);
        fxzclpm.add(fxzclpmMonthVo.getFxlNH()[0]);
        fxzclpm.add(fxzclpmMonthVo.getFxlDH()[0]);
        fxzclpm.add(fxzclpmMonthVo.getFxlDF()[0]);
        fxzclpm.add(fxzclpmMonthVo.getFxlHY()[0]);


        //----航班正常管理提示
        if(listTips != null && listTips.size()>0){
            for (int j=0;j<listTips.size();j++){
                RunQualityReportTipsVo vo = listTips.get(j);
                tips.add(vo);
            }
        }

        //----航班小时架次图
        if(listEChart != null && listEChart.size()>0){
            for(int k=16;k>=0;k--){
                echartAsjs.add(listEChart.get(0).getAsjs()[k]);
                echartDjhs.add(listEChart.get(0).getDjhs()[k]);
                echartDsjs.add(listEChart.get(0).getDsjs()[k]);
            }
        }

        OutputStream out = response.getOutputStream();
        JxlsBuilder jxlsBuilder = JxlsBuilder
                .getBuilder(ResourceUtils.getFile("classpath:template/runQualityReport.xlsx").getAbsolutePath())
                .out(out)
                .ignoreImageMiss(true)
                .putVar("yltj", yltj)
                .putVar("hbzcxtj", hbzcxtj)
                .putVar("ywyy", ywyy)
                .putVar("jczljg", jczljg)
                .putVar("fxzclpm", fxzclpm)
                .putVar("tips", tips)
                .putVar("echartAsjs", echartAsjs)
                .putVar("echartDjhs", echartDjhs)
                .putVar("echartDsjs", echartDsjs)
                .build();
        out.close();
    }

    @ApiOperation(httpMethod = "POST", value = "导出PDF报表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/exportPDF.json", method = RequestMethod.POST)
    public void exportPDF(@ApiParam("执行日期") @RequestParam("execDate") String execDate,
                             @ApiParam("航司二码") @RequestParam("agent") String agent,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        Date date = DateTimeUtil.strToDate(execDate,"yyyy-MM-dd");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("execDate",date);
        queryMap.put("agent",agent);
        queryMap.put("execDate2",execDate);
        //小时架次图
        List<RunQualityReportEChartVo> listEChart = runQualityReportService.findEChartsInfo(queryMap);
        List echartAsjs = new ArrayList();
        List<Double> echartDjhs = new ArrayList();
        List<Double> echartDsjs = new ArrayList();
        //----航班小时架次图
        if(listEChart != null && listEChart.size()>0){
            for(int k=0;k<=16;k++){
                echartAsjs.add(listEChart.get(0).getAsjs()[k]);
                echartDjhs.add(listEChart.get(0).getDjhs()[k]+0d);
                echartDsjs.add(listEChart.get(0).getDsjs()[k]+0d);
            }
        }
        //折线图数据
        DefaultCategoryDataset lineDataset = new DefaultCategoryDataset();
        //添加数据 echartDsjs
        lineDataset.addValue(echartDsjs.get(0), "实际架次", "7");
        lineDataset.addValue(echartDsjs.get(1), "实际架次", "8");
        lineDataset.addValue(echartDsjs.get(2), "实际架次", "9");
        lineDataset.addValue(echartDsjs.get(3), "实际架次", "10");
        lineDataset.addValue(echartDsjs.get(4), "实际架次", "11");
        lineDataset.addValue(echartDsjs.get(5), "实际架次", "12");
        lineDataset.addValue(echartDsjs.get(6), "实际架次", "13");
        lineDataset.addValue(echartDsjs.get(7), "实际架次", "14");
        lineDataset.addValue(echartDsjs.get(8), "实际架次", "15");
        lineDataset.addValue(echartDsjs.get(9), "实际架次", "16");
        lineDataset.addValue(echartDsjs.get(10), "实际架次", "17");
        lineDataset.addValue(echartDsjs.get(11), "实际架次", "18");
        lineDataset.addValue(echartDsjs.get(12), "实际架次", "19");
        lineDataset.addValue(echartDsjs.get(13), "实际架次", "20");
        lineDataset.addValue(echartDsjs.get(14), "实际架次", "21");
        lineDataset.addValue(echartDsjs.get(15), "实际架次", "22");
        lineDataset.addValue(echartDsjs.get(16), "实际架次", "23");


        //柱状图数据
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //添加数据 echartDjhs
        dataset.addValue(echartDjhs.get(0), "计划架次", "7");
        dataset.addValue(echartDjhs.get(1), "计划架次", "8");
        dataset.addValue(echartDjhs.get(2), "计划架次", "9");
        dataset.addValue(echartDjhs.get(3), "计划架次", "10");
        dataset.addValue(echartDjhs.get(4), "计划架次", "11");
        dataset.addValue(echartDjhs.get(5), "计划架次", "12");
        dataset.addValue(echartDjhs.get(6), "计划架次", "13");
        dataset.addValue(echartDjhs.get(7), "计划架次", "14");
        dataset.addValue(echartDjhs.get(8), "计划架次", "15");
        dataset.addValue(echartDjhs.get(9), "计划架次", "16");
        dataset.addValue(echartDjhs.get(10), "计划架次", "17");
        dataset.addValue(echartDjhs.get(11), "计划架次", "18");
        dataset.addValue(echartDjhs.get(12), "计划架次", "19");
        dataset.addValue(echartDjhs.get(13), "计划架次", "20");
        dataset.addValue(echartDjhs.get(14), "计划架次", "21");
        dataset.addValue(echartDjhs.get(15), "计划架次", "22");
        dataset.addValue(echartDjhs.get(16), "计划架次", "23");
        //运量统计
        List<RunQualityReportYLTJVo> listYLTJ = runQualityReportService.findYunLiangTJInfo(queryMap);
        //航班正常性
        List<RunQualityReportYLTJVo> listHBZCXTJ = runQualityReportService.findHBZCXTJInfo(queryMap);
        //延误原因
        List<RunQualityReportYWYYVo> listYWYY = runQualityReportService.findYWYYTJInfo(queryMap);
        //航班进程质量监管
        List<RunQualityReportJCZLJGVo> listJCZLJG = runQualityReportService.findHBJCZLJGInfo(queryMap);
        //放行正常率排名
        List<RunQualityReportFXZCLPMVo> listFXZCLPM = runQualityReportService.findFXZCLPMInfo(queryMap);
        //航班正常管理提示
        List<RunQualityReportTipsVo> listTips = runQualityReportService.findFltManageTipsInfo(queryMap);


        List yltj = new ArrayList();
        List hbzcxtj = new ArrayList();
        List ywyy = new ArrayList();
        List jczljg = new ArrayList();
        List fxzclpm = new ArrayList();
        List tips = new ArrayList();



        //----运输量统计
        RunQualityReportYLTJVo yltjVo = listYLTJ.get(0);
        yltj.add(yltjVo.getExecDate());
        //运输架次
        yltj.add(yltjVo.getDayHbs()[0]);
        yltj.add(yltjVo.getDayTb()[0]);
        yltj.add(yltjVo.getMonthHbs()[0]);
        yltj.add(yltjVo.getMonthTb()[0]);
        yltj.add(yltjVo.getYearHbs()[0]);
        yltj.add(yltjVo.getYearTb()[0]);
        //人数
        RunQualityReportYLTJVo rstjVo = listYLTJ.get(1);
        yltj.add(rstjVo.getDayHbs()[0]);
        yltj.add(rstjVo.getDayTb()[0]);
        yltj.add(rstjVo.getMonthHbs()[0]);
        yltj.add(rstjVo.getMonthTb()[0]);
        yltj.add(rstjVo.getYearHbs()[0]);
        yltj.add(rstjVo.getYearTb()[0]);


        //----航班正常性统计
        RunQualityReportYLTJVo fxlVo = listHBZCXTJ.get(0);
        hbzcxtj.add(yltjVo.getExecDate());
        //放行率
        hbzcxtj.add(fxlVo.getDayHbs()[0]);
        hbzcxtj.add(fxlVo.getDayTb()[0]);
        hbzcxtj.add(fxlVo.getMonthHbs()[0]);
        hbzcxtj.add(fxlVo.getMonthTb()[0]);
        hbzcxtj.add(fxlVo.getYearHbs()[0]);
        hbzcxtj.add(fxlVo.getYearTb()[0]);
        //始发正常率
        RunQualityReportYLTJVo sfzclVo = listHBZCXTJ.get(1);
        hbzcxtj.add(sfzclVo.getDayHbs()[0]);
        hbzcxtj.add(sfzclVo.getDayTb()[0]);
        hbzcxtj.add(sfzclVo.getMonthHbs()[0]);
        hbzcxtj.add(sfzclVo.getMonthTb()[0]);
        hbzcxtj.add(sfzclVo.getYearHbs()[0]);
        hbzcxtj.add(sfzclVo.getYearTb()[0]);
        //正常率
        RunQualityReportYLTJVo zclVo = listHBZCXTJ.get(2);
        hbzcxtj.add(zclVo.getDayHbs()[0]);
        hbzcxtj.add(zclVo.getDayTb()[0]);
        hbzcxtj.add(zclVo.getMonthHbs()[0]);
        hbzcxtj.add(zclVo.getMonthTb()[0]);
        hbzcxtj.add(zclVo.getYearHbs()[0]);
        hbzcxtj.add(zclVo.getYearTb()[0]);

        //----延误原因统计
        RunQualityReportYWYYVo ywyyVo = listYWYY.get(0);
        ywyy.add(ywyyVo.getDelayTq()[0]);
        ywyy.add(ywyyVo.getDelayGs()[0]);
        ywyy.add(ywyyVo.getDelayLl()[0]);
        ywyy.add(ywyyVo.getDelayHbsk()[0]);
        ywyy.add(ywyyVo.getDelayZshd()[0]);
        ywyy.add(ywyyVo.getDelayKg()[0]);
        ywyy.add(ywyyVo.getDelayJc()[0]);
        ywyy.add(ywyyVo.getDelayLj()[0]);
        ywyy.add(ywyyVo.getDelayYl()[0]);
        ywyy.add(ywyyVo.getDelayLgxt()[0]);
        ywyy.add(ywyyVo.getDelayLk()[0]);
        ywyy.add(ywyyVo.getDelayGgaq()[0]);
        ywyy.add(ywyyVo.getDelayCount());

        //----航班进程质量监管
        jczljg.add(listJCZLJG.get(0).getExecDate());
        for (int i=0;i<listJCZLJG.size();i++){
            RunQualityReportJCZLJGVo vo = listJCZLJG.get(i);
            jczljg.add(vo.getInfo()[0]);
        }

        //----放行正常率排名
        //当天排名
        RunQualityReportFXZCLPMVo fxzclpmVo = listFXZCLPM.get(0);
        fxzclpm.add(fxzclpmVo.getExceDate()[0]);
        fxzclpm.add(fxzclpmVo.getFxlGH()[0]);
        fxzclpm.add(fxzclpmVo.getFxlNH()[0]);
        fxzclpm.add(fxzclpmVo.getFxlDH()[0]);
        fxzclpm.add(fxzclpmVo.getFxlDF()[0]);
        fxzclpm.add(fxzclpmVo.getFxlHY()[0]);
        //累月排名
        RunQualityReportFXZCLPMVo fxzclpmMonthVo = listFXZCLPM.get(1);
        fxzclpm.add(fxzclpmMonthVo.getExceDate()[0]);
        fxzclpm.add(fxzclpmMonthVo.getFxlGH()[0]);
        fxzclpm.add(fxzclpmMonthVo.getFxlNH()[0]);
        fxzclpm.add(fxzclpmMonthVo.getFxlDH()[0]);
        fxzclpm.add(fxzclpmMonthVo.getFxlDF()[0]);
        fxzclpm.add(fxzclpmMonthVo.getFxlHY()[0]);


        //----航班正常管理提示
        if(listTips != null && listTips.size()>0){
            for (int j=0;j<listTips.size();j++){
                RunQualityReportTipsVo vo = listTips.get(j);
                tips.add(vo.getFlTips());
            }
        }




        /*Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
        document.open();



        document.close();
        writer.close();*/
        Map<String, Object> resultMap=new HashMap<>();
        //机场运量统计
        resultMap.put("yltj0",yltj.get(0));
        resultMap.put("yltj1",yltj.get(1));
        resultMap.put("yltj2",yltj.get(2));
        resultMap.put("yltj3",yltj.get(3));
        resultMap.put("yltj4",yltj.get(4));
        resultMap.put("yltj5",yltj.get(5));
        resultMap.put("yltj6",yltj.get(6));
        resultMap.put("yltj7",yltj.get(7));
        resultMap.put("yltj8",yltj.get(8));
        resultMap.put("yltj9",yltj.get(9));
        resultMap.put("yltj10",yltj.get(10));
        resultMap.put("yltj11",yltj.get(11));
        resultMap.put("yltj12",yltj.get(12));
        resultMap.put("yltj13","("+execDate.substring(0,4)+"年"+yltj.get(0)+")");

        //【航班正常性统计
        resultMap.put("hbzcxtj0",hbzcxtj.get(0));
        resultMap.put("hbzcxtj1",hbzcxtj.get(1));
        resultMap.put("hbzcxtj2",hbzcxtj.get(2));
        resultMap.put("hbzcxtj3",hbzcxtj.get(3));
        resultMap.put("hbzcxtj4",hbzcxtj.get(4));
        resultMap.put("hbzcxtj5",hbzcxtj.get(5));
        resultMap.put("hbzcxtj6",hbzcxtj.get(6));
        resultMap.put("hbzcxtj7",hbzcxtj.get(7));
        resultMap.put("hbzcxtj8",hbzcxtj.get(8));
        resultMap.put("hbzcxtj9",hbzcxtj.get(9));
        resultMap.put("hbzcxtj10",hbzcxtj.get(10));
        resultMap.put("hbzcxtj11",hbzcxtj.get(11));
        resultMap.put("hbzcxtj12",hbzcxtj.get(12));
        resultMap.put("hbzcxtj13",hbzcxtj.get(13));
        resultMap.put("hbzcxtj14",hbzcxtj.get(14));
        resultMap.put("hbzcxtj15",hbzcxtj.get(15));
        resultMap.put("hbzcxtj16",hbzcxtj.get(16));
        resultMap.put("hbzcxtj17",hbzcxtj.get(17));
        resultMap.put("hbzcxtj18",hbzcxtj.get(18));

        //延误原因统计
        resultMap.put("ywyy0",ywyy.get(0));
        resultMap.put("ywyy1",ywyy.get(1));
        resultMap.put("ywyy2",ywyy.get(2));
        resultMap.put("ywyy3",ywyy.get(3));
        resultMap.put("ywyy4",ywyy.get(4));
        resultMap.put("ywyy5",ywyy.get(5));
        resultMap.put("ywyy6",ywyy.get(6));
        resultMap.put("ywyy7",ywyy.get(7));
        resultMap.put("ywyy8",ywyy.get(8));
        resultMap.put("ywyy9",ywyy.get(9));
        resultMap.put("ywyy10",ywyy.get(10));
        resultMap.put("ywyy11",ywyy.get(11));
        resultMap.put("ywyy12",ywyy.get(12));

        //航班进程质量管控
        resultMap.put("jczljg0",jczljg.get(0));
        resultMap.put("jczljg1",jczljg.get(1));
        resultMap.put("jczljg2",jczljg.get(2));
        resultMap.put("jczljg3",jczljg.get(3));
        resultMap.put("jczljg4",jczljg.get(4));
        resultMap.put("jczljg5",jczljg.get(5));
        resultMap.put("jczljg6",jczljg.get(6));
        resultMap.put("jczljg7",jczljg.get(7));


        //加权平均值排名
        resultMap.put("fxzclpm0",fxzclpm.get(0));
        resultMap.put("fxzclpm1",fxzclpm.get(1));
        resultMap.put("fxzclpm2",fxzclpm.get(2));
        resultMap.put("fxzclpm3",fxzclpm.get(3));
        resultMap.put("fxzclpm4",fxzclpm.get(4));
        resultMap.put("fxzclpm5",fxzclpm.get(5));
        resultMap.put("fxzclpm6",fxzclpm.get(6));
        resultMap.put("fxzclpm7",fxzclpm.get(7));
        resultMap.put("fxzclpm8",fxzclpm.get(8));
        resultMap.put("fxzclpm9",fxzclpm.get(9));
        resultMap.put("fxzclpm10",fxzclpm.get(10));
        resultMap.put("fxzclpm11",fxzclpm.get(11));

        //航班正常管理提示
        resultMap.put("flTips",tips.get(0));
        OutputStream out = response.getOutputStream();
        try {

            PdfReader reader = new PdfReader(ResourceUtils.getFile("classpath:template").getAbsolutePath() + "/cs.pdf" );
            PdfStamper stamp = new PdfStamper(reader, out);

            //使用字体
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

            /* 获取模版中的字段 */
            AcroFields form = stamp.getAcroFields();

            //填充表单
            if (resultMap != null) {
                for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
                    if (entry.getValue()!=null)
                        form.setField(entry.getKey(), entry.getValue().toString());
                }
            }



            //生成的柱状图
            JFreeChart chart = ChartFactory.createBarChart(
                    "",
                    "",//X轴的标签
                    "",//Y轴的标签
                    dataset, //图标显示的数据集合
                    PlotOrientation.VERTICAL, //图像的显示形式（水平或者垂直）
                    true,//是否显示子标题
                    false,//是否生成提示的标签
                    false); //是否生成URL链接

            /*
             * 处理图形上的乱码
             */
            //设置背景色
            chart.setBackgroundPaint(Color.white);
            //处理主标题的乱码
            chart.getTitle().setFont(new java.awt.Font("黑体", java.awt.Font.BOLD,18));
            chart.getLegend().setItemFont(new java.awt.Font("黑体", java.awt.Font.BOLD,18));
            chart.getLegend().setPosition(RectangleEdge.TOP);
            //获取图表区域对象
            CategoryPlot categoryPlot = (CategoryPlot)chart.getPlot();
            //设置画布背景色
            categoryPlot.setBackgroundPaint(Color.white);
            //设置网格竖线颜色
            //categoryPlot.setDomainGridlinePaint(Color.blue);
            //categoryPlot.setDomainGridlinesVisible(true);
            //设置网格横线颜色
            categoryPlot.setRangeGridlinePaint(Color.gray);
            categoryPlot.setRangeGridlinesVisible(true);
            //获取X轴的对象
            CategoryAxis categoryAxis3D = categoryPlot.getDomainAxis();

            //获取Y轴的对象
            NumberAxis numberAxis3D = (NumberAxis)categoryPlot.getRangeAxis();

            //处理X轴上的乱码
            categoryAxis3D.setTickLabelFont(new java.awt.Font("黑体", java.awt.Font.BOLD,12));

            //处理X轴外的乱码
            categoryAxis3D.setLabelFont(new java.awt.Font("黑体", java.awt.Font.BOLD,12));

            //处理Y轴上的乱码
            numberAxis3D.setTickLabelFont(new java.awt.Font("黑体", java.awt.Font.BOLD,12));

            //处理Y轴外的乱码
            numberAxis3D.setLabelFont(new java.awt.Font("黑体", java.awt.Font.BOLD,12));

            //自定义Y轴上显示的刻度，以10作为1格
            numberAxis3D.setAutoTickUnitSelection(false);
            NumberTickUnit unit = new NumberTickUnit(10);
            numberAxis3D.setRange(0,50);
            numberAxis3D.setTickUnit(unit);

            //获取绘图区域对象
            CategoryItemRenderer barRenderer3D = categoryPlot.getRenderer();

            //设置柱形图的宽度
            //barRenderer3D.setMaximumBarWidth(0.07);

            //在图形上显示数字
            barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            barRenderer3D.setBaseItemLabelsVisible(true);
            barRenderer3D.setBaseItemLabelFont(new java.awt.Font("黑体", java.awt.Font.BOLD,12));
            // barRenderer3D.setBaseItemLabelPaint(Color.blue);
            barRenderer3D.setSeriesPaint(0, new Color(142,180,227));
            barRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.BOTTOM_CENTER));
           // barRenderer3D.setItemLabelAnchorOffset(10);

            /*
             * 放折线图数据
             */
            categoryPlot.setDataset(1, lineDataset);
            //设置折线
            LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
            lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            lineandshaperenderer.setBaseItemLabelsVisible(true);
            lineandshaperenderer.setBaseSeriesVisible(true);
            lineandshaperenderer.setBaseItemLabelPaint(Color.RED);
            lineandshaperenderer.setSeriesPaint(0, Color.RED);

            categoryPlot.setRenderer(1, lineandshaperenderer);
            // 柱状图和纵轴紧靠
            categoryAxis3D.setLowerMargin(0.0);

            //categoryAxis3D.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
            //折线在柱面前面显示
            categoryPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

            /*
             * 在E盘目录下生成图片
             */
            File file = new File(ResourceUtils.getFile("classpath:template").getAbsolutePath() +"/A.png");
            try {
                ChartUtilities.saveChartAsJPEG(file,1, chart, 460, 250);
            } catch (IOException e) {
                e.printStackTrace();
            }

            PushbuttonField ad = form.getNewPushbuttonFromField("af_image");
            ad.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
            ad.setProportionalIcon(true);
            ad.setImage(Image.getInstance(ResourceUtils.getFile("classpath:template").getAbsolutePath() +"/A.png"));
            form.replacePushbuttonField("af_image", ad.getField());

            stamp.setFormFlattening(true);//不能编辑
            stamp.close();

            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (DocumentException documentException) {
            documentException.printStackTrace();
        }
    }

    @ApiOperation(httpMethod = "POST", value = "更新PDF表", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/updatePDF.json", method = RequestMethod.POST)
    public ServerResponse updatePDF(@ApiParam("更新PDF表") @RequestBody String AddDataObject,
                          HttpServletRequest request, HttpServletResponse response) throws Exception {
        //Date date = DateTimeUtil.strToDate(execDate, "yyyy-MM-dd");
        log.info("更新PDF表:"+AddDataObject);
        Map<String, Object> queryMap = new HashMap<>();
        JSONObject j=new JSONObject(AddDataObject);
        String execDate = j.getString("execDate");
        String agent = j.getString("agent");
        if (StringUtil.isEmpty(agent))agent="ALL";
        RunQualityPDFVo vo=new RunQualityPDFVo();
        vo.setExecdate(execDate);
        vo.setAgent(agent);

        String MM = execDate.substring(5,7);
        String dd = execDate.substring(8,10);
        if(MM.substring(0,1).equals("0")){
            MM = MM.substring(1,2);
        }
        if(dd.substring(0,1).equals("0")){
            dd = dd.substring(1,2);
        }
        String execDate2 = MM+"月"+dd+"日";
        vo.setYltj13("("+execDate.substring(0,4)+"年"+execDate2+")");
        try {
            JSONObject data=new JSONObject(j.getString("data"));
            PDFListVo listVo= JSON.parseObject(data.toString(),PDFListVo.class);
            if (listVo!=null){
                //运量统计
                List<RunQualityReportYLTJVo> yltj=listVo.getYltj();
                for (int i = 0; i <yltj.size() ; i++) {
                    RunQualityReportYLTJVo v=yltj.get(i);
                    if (i==0){
                        vo.setYltj0(v.getExecDate());
                        vo.setYltj1(v.getDayHbs()[0]);
                        vo.setYltj2(v.getDayTb()[0]);
                        vo.setYltj3(v.getMonthHbs()[0]);
                        vo.setYltj4(v.getMonthTb()[0]);
                        vo.setYltj5(v.getYearHbs()[0]);
                        vo.setYltj6(v.getYearTb()[0]);


                    }
                    if (i==1){
                        vo.setYltj7(v.getDayHbs()[0]);
                        vo.setYltj8(v.getDayTb()[0]);
                        vo.setYltj9(v.getMonthHbs()[0]);
                        vo.setYltj10(v.getMonthTb()[0]);
                        vo.setYltj11(v.getYearHbs()[0]);
                        vo.setYltj12(v.getYearTb()[0]);
                    }
                }
                //航班正常性统计
                List<RunQualityReportYLTJVo> hbzcxtj=listVo.getHbzcxtj();
                for (int i = 0; i <hbzcxtj.size() ; i++) {
                    RunQualityReportYLTJVo v=hbzcxtj.get(i);
                    if (i==0){
                        vo.setHbzcxtj0(v.getExecDate());
                        vo.setHbzcxtj1(v.getDayHbs()[0]);
                        vo.setHbzcxtj2(v.getDayTb()[0]);
                        vo.setHbzcxtj3(v.getMonthHbs()[0]);
                        vo.setHbzcxtj4(v.getMonthTb()[0]);
                        vo.setHbzcxtj5(v.getYearHbs()[0]);
                        vo.setHbzcxtj6(v.getYearTb()[0]);
                    }
                    if (i==1){
                        vo.setHbzcxtj7(v.getDayHbs()[0]);
                        vo.setHbzcxtj8(v.getDayTb()[0]);
                        vo.setHbzcxtj9(v.getMonthHbs()[0]);
                        vo.setHbzcxtj10(v.getMonthTb()[0]);
                        vo.setHbzcxtj11(v.getYearHbs()[0]);
                        vo.setHbzcxtj12(v.getYearTb()[0]);
                    }
                    if (i==2){
                        vo.setHbzcxtj13(v.getDayHbs()[0]);
                        vo.setHbzcxtj14(v.getDayTb()[0]);
                        vo.setHbzcxtj15(v.getMonthHbs()[0]);
                        vo.setHbzcxtj16(v.getMonthTb()[0]);
                        vo.setHbzcxtj17(v.getYearHbs()[0]);
                        vo.setHbzcxtj18(v.getYearTb()[0]);
                    }
                }
                //延误原因统计

                List<RunQualityReportYWYYVo> ywyy=listVo.getYwyy();
                for (int i = 0; i <ywyy.size() ; i++) {
                    RunQualityReportYWYYVo v=ywyy.get(i);
                    if (i==0){
                        vo.setYwyy0(v.getDelayTq()[0]+"");
                        vo.setYwyy1(v.getDelayGs()[0]+"");
                        vo.setYwyy2(v.getDelayLl()[0]+"");
                        vo.setYwyy3(v.getDelayHbsk()[0]+"");
                        vo.setYwyy4(v.getDelayZshd()[0]+"");
                        vo.setYwyy5(v.getDelayKg()[0]+"");
                        vo.setYwyy6(v.getDelayJc()[0]+"");

                        vo.setYwyy7(v.getDelayLj()[0]+"");
                        vo.setYwyy8(v.getDelayYl()[0]+"");
                        vo.setYwyy9(v.getDelayLgxt()[0]+"");
                        vo.setYwyy10(v.getDelayLk()[0]+"");
                        vo.setYwyy11(v.getDelayGgaq()[0]+"");
                        vo.setYwyy12(v.getDelayCount()+"");

                    }

                }

                //航班进程质量管控
                List<RunQualityReportJCZLJGVo> jczljg=listVo.getJczljg();
                for (int i = 0; i <jczljg.size() ; i++) {
                    RunQualityReportJCZLJGVo v=jczljg.get(i);
                    if (i==0){
                        vo.setJczljg0(v.getExecDate());
                        vo.setJczljg1(v.getInfo()[0]);
                    }
                    if (i==1){
                        vo.setJczljg2(v.getInfo()[0]);
                    }
                    if (i==2){
                        vo.setJczljg3(v.getInfo()[0]);
                    }
                    if (i==3){
                        vo.setJczljg4(v.getTitle()[0]);
                    }
                    if (i==4){
                        vo.setJczljg5(v.getInfo()[0]);
                    }
                    if (i==5){
                        vo.setJczljg6(v.getInfo()[0]);
                    }
                    if (i==6){
                        vo.setJczljg7(v.getInfo()[0]);
                    }

                }

                //加权平均值排名
                List<RunQualityReportFXZCLPMVo> fxzclpm=listVo.getFxzclpm();
                for (int i = 0; i <fxzclpm.size() ; i++) {
                    RunQualityReportFXZCLPMVo v=fxzclpm.get(i);
                    if (i==0){
                        vo.setFxzclpm0(v.getExceDate()[0]);
                        vo.setFxzclpm1(v.getFxlGH()[0]);
                        vo.setFxzclpm2(v.getFxlNH()[0]);
                        vo.setFxzclpm3(v.getFxlDH()[0]);
                        vo.setFxzclpm4(v.getFxlDF()[0]);
                    }
                    if (i==1){
                        vo.setFxzclpm6(v.getExceDate()[0]);
                        vo.setFxzclpm7(v.getFxlGH()[0]);
                        vo.setFxzclpm8(v.getFxlNH()[0]);
                        vo.setFxzclpm9(v.getFxlDH()[0]);
                        vo.setFxzclpm10(v.getFxlDF()[0]);
                    }
                }

                //航班正常管理提示
                List<RunQualityReportTipsVo> tips=listVo.getTips();
                vo.setFlTips(tips.get(0).getFlTips());

                //小时架次图
                List<RunQualityPDFEChartVo> echartD =listVo.getEchartD();
                for (int i = 0; i <echartD.size() ; i++) {
                    RunQualityPDFEChartVo v=echartD.get(i);
                    if ("计划架次".equals(v.getTitle())){
                        vo.setEchartDjhs0(v.getTime7());
                        vo.setEchartDjhs1(v.getTime8());
                        vo.setEchartDjhs2(v.getTime9());
                        vo.setEchartDjhs3(v.getTime10());
                        vo.setEchartDjhs4(v.getTime11());
                        vo.setEchartDjhs5(v.getTime12());
                        vo.setEchartDjhs6(v.getTime13());
                        vo.setEchartDjhs7(v.getTime14());
                        vo.setEchartDjhs8(v.getTime15());
                        vo.setEchartDjhs9(v.getTime16());
                        vo.setEchartDjhs10(v.getTime17());
                        vo.setEchartDjhs11(v.getTime18());
                        vo.setEchartDjhs12(v.getTime19());
                        vo.setEchartDjhs13(v.getTime20());
                        vo.setEchartDjhs14(v.getTime21());
                        vo.setEchartDjhs15(v.getTime22());
                        vo.setEchartDjhs16(v.getTime23());
                    }
                    if ("实际架次".equals(v.getTitle())){
                        vo.setEchartDsjs0(v.getTime7());
                        vo.setEchartDsjs1(v.getTime8());
                        vo.setEchartDsjs2(v.getTime9());
                        vo.setEchartDsjs3(v.getTime10());
                        vo.setEchartDsjs4(v.getTime11());
                        vo.setEchartDsjs5(v.getTime12());
                        vo.setEchartDsjs6(v.getTime13());
                        vo.setEchartDsjs7(v.getTime14());
                        vo.setEchartDsjs8(v.getTime15());
                        vo.setEchartDsjs9(v.getTime16());
                        vo.setEchartDsjs10(v.getTime17());
                        vo.setEchartDsjs11(v.getTime18());
                        vo.setEchartDsjs12(v.getTime19());
                        vo.setEchartDsjs13(v.getTime20());
                        vo.setEchartDsjs14(v.getTime21());
                        vo.setEchartDsjs15(v.getTime22());
                        vo.setEchartDsjs16(v.getTime23());
                    }

                }
                Date d=new Date();
                vo.setCreateTm(d);
                vo.setUpdateTm(d);
                vo.setCreateUsr("updatePDF");
                vo.setUpdateUsr("updatePDF");
                int rs=runQualityReportService.updateByPDFPrimaryKey(vo);
                if (rs==0){
                    rs=runQualityReportService.insertPDF(vo);
                }
                return ServerResponse.createBySuccess(rs);
            }
        }catch (Exception ex){
            log.info("简报修改报错日志:"+ex+"");
            return ServerResponse.createBySystemError();
        }



       // ObjectMapper mapper = new ObjectMapper();

        /*List<RunQualityReportYLTJVo> yltj = mapper.readValue(data.getString("yltj"), new com.fasterxml.jackson.core.type.TypeReference<List<RunQualityReportYLTJVo>>(){});

        List<RunQualityReportYLTJVo> hbzcxtj = mapper.readValue(data.getString("hbzcxtj"), new com.fasterxml.jackson.core.type.TypeReference<List<RunQualityReportYLTJVo>>(){});

        List<RunQualityReportYWYYVo> ywyy = mapper.readValue(data.getString("ywyy"), new com.fasterxml.jackson.core.type.TypeReference<List<RunQualityReportYWYYVo>>(){});

        List<RunQualityReportJCZLJGVo> jczljg = mapper.readValue(data.getString("jczljg"), new com.fasterxml.jackson.core.type.TypeReference<List<RunQualityReportJCZLJGVo>>(){});


        List<RunQualityReportFXZCLPMVo> fxzclpm = mapper.readValue(data.getString("fxzclpm"), new com.fasterxml.jackson.core.type.TypeReference<List<RunQualityReportFXZCLPMVo>>(){});

        List<RunQualityReportTipsVo> tips=mapper.readValue(data.getString("fxzclpm"), new com.fasterxml.jackson.core.type.TypeReference<List<RunQualityReportTipsVo>>(){});


        List<RunQualityReportEChartVo> echartD = mapper.readValue(data.getString("echartD"), new com.fasterxml.jackson.core.type.TypeReference<List<RunQualityReportEChartVo>>(){});
        */
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "查询某月航班正常率放行率加权排名", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/selectZclFxlMonthQn.json", method = RequestMethod.POST)
    public ServerResponse selectZclFxlMonthQn(@ApiParam("查询某月航班正常率放行率加权排名") @RequestBody String AddDataObject,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {
        //Date date = DateTimeUtil.strToDate(execDate, "yyyy-MM-dd");
        log.info("selectZclFxlMonthQn:"+AddDataObject);

        JSONObject j=new JSONObject(AddDataObject);
        String execDate = j.getString("execDate");
        if (execDate!=null&&execDate.length()>=7){
            execDate=execDate.substring(0,7)+"-01";
        }

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("execDate",execDate);
        List<PaiMingQTVo> mu_tableData=new ArrayList<>();

        List<PaiMingQTVo> cz_tableData=new ArrayList<>();

        List<PaiMingQTVo> ca_tableData=new ArrayList<>();

        List<PaiMingQTVo> df_tableData=new ArrayList<>();
        List<PaiMingDYGVo> list = runQualityReportService.selectZclFxlMonthQn(queryMap);
        List<PaiMingQTVo>  listRANKING = runQualityReportService.selectZclFxlRANKING(queryMap);
        PaiMingQTSVo revo=new PaiMingQTSVo();

        PaiMingQTVo mu_sumData=new PaiMingQTVo();
        mu_sumData.setDate("合计");
        mu_sumData.setAgent(execDate);
        mu_sumData.setQf_j1(0);
        mu_sumData.setQf_j2(0);
        mu_sumData.setQf_z1(0);
        mu_sumData.setQf_z2(0);
        mu_sumData.setFx_z1(0);
        mu_sumData.setFx_z2(0);
        PaiMingQTVo cz_sumData=new PaiMingQTVo();
        cz_sumData.setDate("合计");
        cz_sumData.setAgent(execDate);
        cz_sumData.setQf_j1(0);
        cz_sumData.setQf_j2(0);
        cz_sumData.setQf_z1(0);
        cz_sumData.setQf_z2(0);
        cz_sumData.setFx_z1(0);
        cz_sumData.setFx_z2(0);
        PaiMingQTVo ca_sumData=new PaiMingQTVo();
        ca_sumData.setDate("合计");
        ca_sumData.setAgent(execDate);
        ca_sumData.setQf_j1(0);
        ca_sumData.setQf_j2(0);
        ca_sumData.setQf_z1(0);
        ca_sumData.setQf_z2(0);
        ca_sumData.setFx_z1(0);
        ca_sumData.setFx_z2(0);
        PaiMingQTVo df_sumData=new PaiMingQTVo();
        df_sumData.setDate("合计");
        df_sumData.setAgent(execDate);
        df_sumData.setQf_j1(0);
        df_sumData.setQf_z1(0);
        df_sumData.setFx_z1(0);
        for (int i = 0; i <list.size() ; i++) {
            PaiMingDYGVo vo=list.get(i);
            PaiMingQTVo muvo=new PaiMingQTVo();
            PaiMingQTVo czvo=new PaiMingQTVo();
            PaiMingQTVo cavo=new PaiMingQTVo();
            PaiMingQTVo dfvo=new PaiMingQTVo();

            muvo.setDate(vo.getExecdate());
            muvo.setQf_j1(vo.getMub3());
            muvo.setQf_j2(vo.getFmc3());
            muvo.setQf_z1(vo.getMue3());
            muvo.setQf_z2(vo.getFmf3());
            muvo.setFx_z1(vo.getMun3());
            muvo.setFx_z2(vo.getFmo3());


            czvo.setDate(vo.getExecdate());
            czvo.setQf_j1(vo.getCzb3());
            czvo.setQf_j2(vo.getOqc3());
            czvo.setQf_z1(vo.getCze3());
            czvo.setQf_z2(vo.getOqf3());
            czvo.setFx_z1(vo.getCzn3());
            czvo.setFx_z2(vo.getOqo3());


            cavo.setDate(vo.getExecdate());
            cavo.setQf_j1(vo.getCab3());
            cavo.setQf_j2(vo.getZhc3());
            cavo.setQf_z1(vo.getCae3());
            cavo.setQf_z2(vo.getZhf3());
            cavo.setFx_z1(vo.getCan3());
            cavo.setFx_z2(vo.getZho3());

            dfvo.setDate(vo.getExecdate());
            dfvo.setQf_j1(vo.getDfb3());
            dfvo.setQf_j2(vo.getMub3()+vo.getFmc3()+vo.getCzb3()+vo.getOqc3()+vo.getCab3()+vo.getZhc3());
            dfvo.setQf_z1(vo.getDfe3());
            dfvo.setQf_z2(vo.getMue3()+vo.getFmf3()+vo.getCze3()+vo.getOqf3()+vo.getCae3()+vo.getZhf3());
            dfvo.setFx_z1(vo.getDfn3());
            dfvo.setFx_z2(vo.getMun3()+vo.getFmo3()+vo.getCzn3()+vo.getOqo3()+vo.getCan3()+vo.getZho3());

            if (listRANKING!=null&&listRANKING.size()>0){
                for (int k = 0; k < listRANKING.size(); k++) {
                    PaiMingQTVo rankingvo=listRANKING.get(k);
                    if ("DH".equals(rankingvo.getAgent())){
                        if (muvo.getDate().equals(rankingvo.getDate())){

                            muvo.setQf_j1(rankingvo.getQf_j1());
                            muvo.setQf_j2(rankingvo.getQf_j2());
                            muvo.setQf_z1(rankingvo.getQf_z1());
                            muvo.setQf_z2(rankingvo.getQf_z2());
                            muvo.setFx_z1(rankingvo.getFx_z1());
                            muvo.setFx_z2(rankingvo.getFx_z2());

                        }
                    }
                    if ("NH".equals(rankingvo.getAgent())){
                        if (czvo.getDate().equals(rankingvo.getDate())){
                            czvo.setQf_j1(rankingvo.getQf_j1());
                            czvo.setQf_j2(rankingvo.getQf_j2());
                            czvo.setQf_z1(rankingvo.getQf_z1());
                            czvo.setQf_z2(rankingvo.getQf_z2());
                            czvo.setFx_z1(rankingvo.getFx_z1());
                            czvo.setFx_z2(rankingvo.getFx_z2());

                        }
                    }
                    if ("GH".equals(rankingvo.getAgent())){
                        if (cavo.getDate().equals(rankingvo.getDate())){
                            cavo.setQf_j1(rankingvo.getQf_j1());
                            cavo.setQf_j2(rankingvo.getQf_j2());
                            cavo.setQf_z1(rankingvo.getQf_z1());
                            cavo.setQf_z2(rankingvo.getQf_z2());
                            cavo.setFx_z1(rankingvo.getFx_z1());
                            cavo.setFx_z2(rankingvo.getFx_z2());

                        }
                    }
                    if ("DF".equals(rankingvo.getAgent())){
                        if (dfvo.getDate().equals(rankingvo.getDate())){
                            dfvo.setQf_j1(rankingvo.getQf_j1());
                            dfvo.setQf_j2(rankingvo.getQf_j2());
                            dfvo.setQf_z1(rankingvo.getQf_z1());
                            dfvo.setQf_z2(rankingvo.getQf_z2());
                            dfvo.setFx_z1(rankingvo.getFx_z1());
                            dfvo.setFx_z2(rankingvo.getFx_z2());

                        }
                    }

                }
            }

            mu_sumData.setQf_j1(mu_sumData.getQf_j1()+muvo.getQf_j1());
            mu_sumData.setQf_j2(mu_sumData.getQf_j2()+muvo.getQf_j2());
            mu_sumData.setQf_z1(mu_sumData.getQf_z1()+muvo.getQf_z1());
            mu_sumData.setQf_z2(mu_sumData.getQf_z2()+muvo.getQf_z2());
            mu_sumData.setFx_z1(mu_sumData.getFx_z1()+muvo.getFx_z1());
            mu_sumData.setFx_z2(mu_sumData.getFx_z2()+muvo.getFx_z2());

            cz_sumData.setQf_j1(cz_sumData.getQf_j1()+czvo.getQf_j1());
            cz_sumData.setQf_j2(cz_sumData.getQf_j2()+czvo.getQf_j2());
            cz_sumData.setQf_z1(cz_sumData.getQf_z1()+czvo.getQf_z1());
            cz_sumData.setQf_z2(cz_sumData.getQf_z2()+czvo.getQf_z2());
            cz_sumData.setFx_z1(cz_sumData.getFx_z1()+czvo.getFx_z1());
            cz_sumData.setFx_z2(cz_sumData.getFx_z2()+czvo.getFx_z2());

            ca_sumData.setQf_j1(ca_sumData.getQf_j1()+cavo.getQf_j1());
            ca_sumData.setQf_j2(ca_sumData.getQf_j2()+cavo.getQf_j2());
            ca_sumData.setQf_z1(ca_sumData.getQf_z1()+cavo.getQf_z1());
            ca_sumData.setQf_z2(ca_sumData.getQf_z2()+cavo.getQf_z2());
            ca_sumData.setFx_z1(ca_sumData.getFx_z1()+cavo.getFx_z1());
            ca_sumData.setFx_z2(ca_sumData.getFx_z2()+cavo.getFx_z2());

            df_sumData.setQf_j1(df_sumData.getQf_j1()+dfvo.getQf_j1());
            df_sumData.setQf_j2(df_sumData.getQf_j2()+dfvo.getQf_j2());
            df_sumData.setQf_z1(df_sumData.getQf_z1()+dfvo.getQf_z1());
            df_sumData.setQf_z2(df_sumData.getQf_z2()+dfvo.getQf_z2());
            df_sumData.setFx_z1(df_sumData.getFx_z1()+dfvo.getFx_z1());
            df_sumData.setFx_z2(df_sumData.getFx_z2()+dfvo.getFx_z2());
            mu_tableData.add(muvo);
            cz_tableData.add(czvo);
            ca_tableData.add(cavo);
            df_tableData.add(dfvo);
        }
        mu_tableData.add(mu_sumData);
        cz_tableData.add(cz_sumData);
        ca_tableData.add(ca_sumData);
        df_tableData.add(df_sumData);
        revo.setCa_tableData(ca_tableData);
        revo.setCz_tableData(cz_tableData);
        revo.setDf_tableData(df_tableData);
        revo.setMu_tableData(mu_tableData);

        revo.setMu_sumData(mu_sumData);
        revo.setCz_sumData(cz_sumData);
        revo.setDf_sumData(df_sumData);
        revo.setCa_sumData(ca_sumData);
        return ServerResponse.createBySuccess(revo);
    }

    @ApiOperation(httpMethod = "POST", value = "修改某月航班正常率放行率加权排名", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/updZclFxlJqMonthQn.json", method = RequestMethod.POST)
    public ServerResponse updZclFxlJqMonthQn(@ApiParam("修改某月航班正常率放行率加权排名") @RequestBody String AddDataObject,
                                              HttpServletRequest request, HttpServletResponse response) throws Exception {
        //Date date = DateTimeUtil.strToDate(execDate, "yyyy-MM-dd");
        //log.info("selectZclFxlMonthQn:"+AddDataObject);

        int rs=0;
        int rsDH=0;
        int rsNH=0;
        int rsGH=0;
        int rsDF=0;
        Users sysUser =null;
        try {
            String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
            String cacheValue = sysCacheService.getFromCache(loginToken);
            sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
            });
            String createUsr = "";
            if (null!=sysUser){
                createUsr=sysUser.getUserId();
            }
            JSONObject j=new JSONObject(AddDataObject);
            PaiMingQTSVo requestvo = JSON.parseObject(j.toString(),PaiMingQTSVo.class);
            if (requestvo!=null){
                String execDate = null;
                List<PaiMingQTVo> mu_tableData=requestvo.getMu_tableData();
                if (mu_tableData!=null&&mu_tableData.size()>0){
                    for (int i = 0; i <mu_tableData.size() ; i++) {
                        PaiMingQTVo vo=mu_tableData.get(i);
                        if ("合计".equals(vo.getDate()))continue;
                        vo.setAgent("DH");
                        vo.setCreateUsr(createUsr);
                        vo.setUpdateUsr(createUsr);
                        execDate=vo.getDate();
                        rsDH=runQualityReportService.updateByZclFxlJqMonthQn(vo);
                        if (rsDH==0){
                            rsDH=runQualityReportService.insertZclFxlJqMonthQn(vo);
                        }
                    }
                }
                /*PaiMingQTVo mu_sumData=requestvo.getMu_sumData();
                if (mu_sumData!=null&&"合计".equals(mu_sumData.getDate())){
                    mu_sumData.setDate(mu_sumData.getAgent());
                    mu_sumData.setAgent("DHSUM");
                     rs=runQualityReportService.updateByZclFxlJqMonthQn(mu_sumData);
                    if (rs==0){
                        rs=runQualityReportService.insertZclFxlJqMonthQn(mu_sumData);
                    }
                }*/

                List<PaiMingQTVo> cz_tableData=requestvo.getCz_tableData();
                for (int i = 0; i <cz_tableData.size() ; i++) {
                    PaiMingQTVo vo=cz_tableData.get(i);
                    if ("合计".equals(vo.getDate()))continue;
                    vo.setAgent("NH");
                    vo.setCreateUsr(createUsr);
                    vo.setUpdateUsr(createUsr);
                    execDate=vo.getDate();
                    rsNH=runQualityReportService.updateByZclFxlJqMonthQn(vo);
                    if (rsNH==0){
                        rsNH=runQualityReportService.insertZclFxlJqMonthQn(vo);
                    }
                }
                /*PaiMingQTVo cz_sumData=requestvo.getCz_sumData();
                if (cz_sumData!=null&&"合计".equals(cz_sumData.getDate())){
                    cz_sumData.setDate(cz_sumData.getAgent());
                    cz_sumData.setAgent("NHSUM");
                     rs=runQualityReportService.updateByZclFxlJqMonthQn(cz_sumData);
                    if (rs==0){
                        rs=runQualityReportService.insertZclFxlJqMonthQn(cz_sumData);
                    }
                }*/

                List<PaiMingQTVo> ca_tableData=requestvo.getCa_tableData();
                for (int i = 0; i <ca_tableData.size() ; i++) {
                    PaiMingQTVo vo=ca_tableData.get(i);
                    if ("合计".equals(vo.getDate()))continue;
                    vo.setAgent("GH");
                    vo.setCreateUsr(createUsr);
                    vo.setUpdateUsr(createUsr);
                    execDate=vo.getDate();
                    rsGH=runQualityReportService.updateByZclFxlJqMonthQn(vo);
                    if (rsGH==0){
                        rsGH=runQualityReportService.insertZclFxlJqMonthQn(vo);
                    }
                }
                /*PaiMingQTVo ca_sumData=requestvo.getCa_sumData();
                if (ca_sumData!=null&&"合计".equals(ca_sumData.getDate())){
                    ca_sumData.setDate(ca_sumData.getAgent());
                    ca_sumData.setAgent("GHSUM");
                     rs=runQualityReportService.updateByZclFxlJqMonthQn(ca_sumData);
                    if (rs==0){
                        rs=runQualityReportService.insertZclFxlJqMonthQn(ca_sumData);
                    }
                }*/

                List<PaiMingQTVo> df_tableData=requestvo.getDf_tableData();
                for (int i = 0; i <df_tableData.size() ; i++) {
                    PaiMingQTVo vo=df_tableData.get(i);
                    if ("合计".equals(vo.getDate()))continue;
                    vo.setAgent("DF");
                    vo.setCreateUsr(createUsr);
                    vo.setUpdateUsr(createUsr);
                    execDate=vo.getDate();
                    rsDF=runQualityReportService.updateByZclFxlJqMonthQn(vo);
                    if (rsDF==0){
                        rsDF=runQualityReportService.insertZclFxlJqMonthQn(vo);
                    }
                }
                /*PaiMingQTVo df_sumData=requestvo.getDf_sumData();
                if (df_sumData!=null&&"合计".equals(df_sumData.getDate())){
                    df_sumData.setDate(df_sumData.getAgent());
                    df_sumData.setAgent("DFSUM");
                     rs=runQualityReportService.updateByZclFxlJqMonthQn(df_sumData);
                    if (rs==0){
                        rs=runQualityReportService.insertZclFxlJqMonthQn(df_sumData);
                    }
                }*/
                rs=rsDF+rsDH+rsGH+rsNH;

                if (execDate!=null&&execDate.length()>=7){
                    execDate=execDate.substring(0,7)+"-01";
                }
                Map<String, Object> queryMap = new HashMap<>();
                queryMap.put("execDate",execDate);
                 mu_tableData=new ArrayList<>();

                 cz_tableData=new ArrayList<>();

                 ca_tableData=new ArrayList<>();

                 df_tableData=new ArrayList<>();
                List<PaiMingDYGVo> list = runQualityReportService.selectZclFxlMonthQn(queryMap);
                List<PaiMingQTVo>  listRANKING = runQualityReportService.selectZclFxlRANKING(queryMap);
                PaiMingQTSVo revo=new PaiMingQTSVo();

                PaiMingQTVo mu_sumData=new PaiMingQTVo();
                mu_sumData.setDate("合计");
                mu_sumData.setCreateUsr(createUsr);
                mu_sumData.setUpdateUsr(createUsr);
                mu_sumData.setAgent(execDate);
                mu_sumData.setQf_j1(0);
                mu_sumData.setQf_j2(0);
                mu_sumData.setQf_z1(0);
                mu_sumData.setQf_z2(0);
                mu_sumData.setFx_z1(0);
                mu_sumData.setFx_z2(0);
                PaiMingQTVo cz_sumData=new PaiMingQTVo();
                cz_sumData.setDate("合计");
                cz_sumData.setCreateUsr(createUsr);
                cz_sumData.setUpdateUsr(createUsr);
                cz_sumData.setAgent(execDate);
                cz_sumData.setQf_j1(0);
                cz_sumData.setQf_j2(0);
                cz_sumData.setQf_z1(0);
                cz_sumData.setQf_z2(0);
                cz_sumData.setFx_z1(0);
                cz_sumData.setFx_z2(0);
                PaiMingQTVo ca_sumData=new PaiMingQTVo();
                ca_sumData.setDate("合计");
                ca_sumData.setCreateUsr(createUsr);
                ca_sumData.setUpdateUsr(createUsr);
                ca_sumData.setAgent(execDate);
                ca_sumData.setQf_j1(0);
                ca_sumData.setQf_j2(0);
                ca_sumData.setQf_z1(0);
                ca_sumData.setQf_z2(0);
                ca_sumData.setFx_z1(0);
                ca_sumData.setFx_z2(0);
                PaiMingQTVo df_sumData=new PaiMingQTVo();
                df_sumData.setDate("合计");
                df_sumData.setCreateUsr(createUsr);
                df_sumData.setUpdateUsr(createUsr);
                df_sumData.setAgent(execDate);
                df_sumData.setQf_j1(0);
                df_sumData.setQf_z1(0);
                df_sumData.setFx_z1(0);
                for (int i = 0; i <list.size() ; i++) {
                    PaiMingDYGVo vo=list.get(i);
                    PaiMingQTVo muvo=new PaiMingQTVo();
                    PaiMingQTVo czvo=new PaiMingQTVo();
                    PaiMingQTVo cavo=new PaiMingQTVo();
                    PaiMingQTVo dfvo=new PaiMingQTVo();

                    muvo.setDate(vo.getExecdate());
                    muvo.setQf_j1(vo.getMub3());
                    muvo.setQf_j2(vo.getFmc3());
                    muvo.setQf_z1(vo.getMue3());
                    muvo.setQf_z2(vo.getFmf3());
                    muvo.setFx_z1(vo.getMun3());
                    muvo.setFx_z2(vo.getFmo3());


                    czvo.setDate(vo.getExecdate());
                    czvo.setQf_j1(vo.getCzb3());
                    czvo.setQf_j2(vo.getOqc3());
                    czvo.setQf_z1(vo.getCze3());
                    czvo.setQf_z2(vo.getOqf3());
                    czvo.setFx_z1(vo.getCzn3());
                    czvo.setFx_z2(vo.getOqo3());


                    cavo.setDate(vo.getExecdate());
                    cavo.setQf_j1(vo.getCab3());
                    cavo.setQf_j2(vo.getZhc3());
                    cavo.setQf_z1(vo.getCae3());
                    cavo.setQf_z2(vo.getZhf3());
                    cavo.setFx_z1(vo.getCan3());
                    cavo.setFx_z2(vo.getZho3());

                    dfvo.setDate(vo.getExecdate());
                    dfvo.setQf_j1(vo.getDfb3());
                    dfvo.setQf_j2(vo.getMub3()+vo.getFmc3()+vo.getCzb3()+vo.getOqc3()+vo.getCab3()+vo.getZhc3());
                    dfvo.setQf_z1(vo.getDfe3());
                    dfvo.setQf_z2(vo.getMue3()+vo.getFmf3()+vo.getCze3()+vo.getOqf3()+vo.getCae3()+vo.getZhf3());
                    dfvo.setFx_z1(vo.getDfn3());
                    dfvo.setFx_z2(vo.getMun3()+vo.getFmo3()+vo.getCzn3()+vo.getOqo3()+vo.getCan3()+vo.getZho3());

                    if (listRANKING!=null&&listRANKING.size()>0){
                        for (int k = 0; k < listRANKING.size(); k++) {
                            PaiMingQTVo rankingvo=listRANKING.get(k);
                            if ("DH".equals(rankingvo.getAgent())){
                                if (muvo.getDate().equals(rankingvo.getDate())){

                                    muvo.setQf_j1(rankingvo.getQf_j1());
                                    muvo.setQf_j2(rankingvo.getQf_j2());
                                    muvo.setQf_z1(rankingvo.getQf_z1());
                                    muvo.setQf_z2(rankingvo.getQf_z2());
                                    muvo.setFx_z1(rankingvo.getFx_z1());
                                    muvo.setFx_z2(rankingvo.getFx_z2());

                                }
                            }
                            if ("NH".equals(rankingvo.getAgent())){
                                if (czvo.getDate().equals(rankingvo.getDate())){
                                    czvo.setQf_j1(rankingvo.getQf_j1());
                                    czvo.setQf_j2(rankingvo.getQf_j2());
                                    czvo.setQf_z1(rankingvo.getQf_z1());
                                    czvo.setQf_z2(rankingvo.getQf_z2());
                                    czvo.setFx_z1(rankingvo.getFx_z1());
                                    czvo.setFx_z2(rankingvo.getFx_z2());

                                }
                            }
                            if ("GH".equals(rankingvo.getAgent())){
                                if (cavo.getDate().equals(rankingvo.getDate())){
                                    cavo.setQf_j1(rankingvo.getQf_j1());
                                    cavo.setQf_j2(rankingvo.getQf_j2());
                                    cavo.setQf_z1(rankingvo.getQf_z1());
                                    cavo.setQf_z2(rankingvo.getQf_z2());
                                    cavo.setFx_z1(rankingvo.getFx_z1());
                                    cavo.setFx_z2(rankingvo.getFx_z2());

                                }
                            }
                            if ("DF".equals(rankingvo.getAgent())){
                                if (dfvo.getDate().equals(rankingvo.getDate())){
                                    dfvo.setQf_j1(rankingvo.getQf_j1());
                                    dfvo.setQf_j2(rankingvo.getQf_j2());
                                    dfvo.setQf_z1(rankingvo.getQf_z1());
                                    dfvo.setQf_z2(rankingvo.getQf_z2());
                                    dfvo.setFx_z1(rankingvo.getFx_z1());
                                    dfvo.setFx_z2(rankingvo.getFx_z2());

                                }
                            }

                        }
                    }

                    mu_sumData.setQf_j1(mu_sumData.getQf_j1()+muvo.getQf_j1());
                    mu_sumData.setQf_j2(mu_sumData.getQf_j2()+muvo.getQf_j2());
                    mu_sumData.setQf_z1(mu_sumData.getQf_z1()+muvo.getQf_z1());
                    mu_sumData.setQf_z2(mu_sumData.getQf_z2()+muvo.getQf_z2());
                    mu_sumData.setFx_z1(mu_sumData.getFx_z1()+muvo.getFx_z1());
                    mu_sumData.setFx_z2(mu_sumData.getFx_z2()+muvo.getFx_z2());

                    cz_sumData.setQf_j1(cz_sumData.getQf_j1()+czvo.getQf_j1());
                    cz_sumData.setQf_j2(cz_sumData.getQf_j2()+czvo.getQf_j2());
                    cz_sumData.setQf_z1(cz_sumData.getQf_z1()+czvo.getQf_z1());
                    cz_sumData.setQf_z2(cz_sumData.getQf_z2()+czvo.getQf_z2());
                    cz_sumData.setFx_z1(cz_sumData.getFx_z1()+czvo.getFx_z1());
                    cz_sumData.setFx_z2(cz_sumData.getFx_z2()+czvo.getFx_z2());

                    ca_sumData.setQf_j1(ca_sumData.getQf_j1()+cavo.getQf_j1());
                    ca_sumData.setQf_j2(ca_sumData.getQf_j2()+cavo.getQf_j2());
                    ca_sumData.setQf_z1(ca_sumData.getQf_z1()+cavo.getQf_z1());
                    ca_sumData.setQf_z2(ca_sumData.getQf_z2()+cavo.getQf_z2());
                    ca_sumData.setFx_z1(ca_sumData.getFx_z1()+cavo.getFx_z1());
                    ca_sumData.setFx_z2(ca_sumData.getFx_z2()+cavo.getFx_z2());

                    df_sumData.setQf_j1(df_sumData.getQf_j1()+dfvo.getQf_j1());
                    df_sumData.setQf_j2(df_sumData.getQf_j2()+dfvo.getQf_j2());
                    df_sumData.setQf_z1(df_sumData.getQf_z1()+dfvo.getQf_z1());
                    df_sumData.setQf_z2(df_sumData.getQf_z2()+dfvo.getQf_z2());
                    df_sumData.setFx_z1(df_sumData.getFx_z1()+dfvo.getFx_z1());
                    df_sumData.setFx_z2(df_sumData.getFx_z2()+dfvo.getFx_z2());
//                    mu_tableData.add(muvo);
//                    cz_tableData.add(czvo);
//                    ca_tableData.add(cavo);
//                    df_tableData.add(dfvo);
                }
//                mu_tableData.add(mu_sumData);
//                cz_tableData.add(cz_sumData);
//                ca_tableData.add(ca_sumData);
//                df_tableData.add(df_sumData);
//                revo.setCa_tableData(ca_tableData);
//                revo.setCz_tableData(cz_tableData);
//                revo.setDf_tableData(df_tableData);
//                revo.setMu_tableData(mu_tableData);
//
//                revo.setMu_sumData(mu_sumData);
//                revo.setCz_sumData(cz_sumData);
//                revo.setDf_sumData(df_sumData);
//                revo.setCa_sumData(ca_sumData);

                if (rsDH>0){
                    mu_sumData.setDate(mu_sumData.getAgent());
                    mu_sumData.setAgent("DHSUM");
                    mu_sumData.setQf_j3(mu_sumData.getQf_j1()+mu_sumData.getQf_j2());
                    mu_sumData.setQf_z3(mu_sumData.getQf_z1()+mu_sumData.getQf_z2());
                    mu_sumData.setQf_b1("0.00");
                    if (mu_sumData.getQf_j1()>0){
                        mu_sumData.setQf_b1(new BigDecimal(mu_sumData.getQf_z1()).divide(new BigDecimal(mu_sumData.getQf_j1()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    mu_sumData.setQf_b2("0.00");
                    if (mu_sumData.getQf_j2()>0){
                        mu_sumData.setQf_b2(new BigDecimal(mu_sumData.getQf_z2()).divide(new BigDecimal(mu_sumData.getQf_j2()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    mu_sumData.setQf_b3("0.00");
                    if (mu_sumData.getQf_j3()>0){
                        mu_sumData.setQf_b3(new BigDecimal(mu_sumData.getQf_z3()).divide(new BigDecimal(mu_sumData.getQf_j3()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    mu_sumData.setFx_j1(mu_sumData.getQf_j1());
                    mu_sumData.setFx_j2(mu_sumData.getQf_j2());
                    mu_sumData.setFx_j3(mu_sumData.getQf_j3());
                    mu_sumData.setFx_z3(mu_sumData.getFx_z1()+mu_sumData.getFx_z2());
                    mu_sumData.setFx_b1("0.00");
                    if (mu_sumData.getFx_j1()>0){
                        mu_sumData.setFx_b1(new BigDecimal(mu_sumData.getFx_z1()).divide(new BigDecimal(mu_sumData.getFx_j1()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    mu_sumData.setFx_b2("0.00");
                    if (mu_sumData.getFx_j2()>0){
                        mu_sumData.setFx_b2(new BigDecimal(mu_sumData.getFx_z2()).divide(new BigDecimal(mu_sumData.getFx_j2()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    mu_sumData.setFx_b3("0.00");
                    if (mu_sumData.getFx_j3()>0){
                        mu_sumData.setFx_b3(new BigDecimal(mu_sumData.getFx_z3()).divide(new BigDecimal(mu_sumData.getFx_j3()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    mu_sumData.setJq1(new BigDecimal(mu_sumData.getQf_b1()).multiply(new BigDecimal("0.3"))
                            .add(new BigDecimal(mu_sumData.getFx_b1()).multiply(new BigDecimal("0.7")))
                            .setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    mu_sumData.setJq2(new BigDecimal(mu_sumData.getQf_b2()).multiply(new BigDecimal("0.3"))
                            .add(new BigDecimal(mu_sumData.getFx_b2()).multiply(new BigDecimal("0.7")))
                            .setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    mu_sumData.setJq3(new BigDecimal(mu_sumData.getQf_b3()).multiply(new BigDecimal("0.3"))
                            .add(new BigDecimal(mu_sumData.getFx_b3()).multiply(new BigDecimal("0.7")))
                            .setScale(2, BigDecimal.ROUND_HALF_UP).toString());

                    int aa=runQualityReportService.updateByZclFxlJqMonthQn(mu_sumData);
                    if (aa==0){
                        aa=runQualityReportService.insertZclFxlJqMonthQn(mu_sumData);
                    }
                }

                if (rsNH>0){
                    cz_sumData.setDate(cz_sumData.getAgent());
                    cz_sumData.setAgent("NHSUM");
                    cz_sumData.setQf_j3(cz_sumData.getQf_j1()+cz_sumData.getQf_j2());
                    cz_sumData.setQf_z3(cz_sumData.getQf_z1()+cz_sumData.getQf_z2());
                    cz_sumData.setQf_b1("0.00");
                    if (cz_sumData.getQf_j1()>0){
                        cz_sumData.setQf_b1(new BigDecimal(cz_sumData.getQf_z1()).divide(new BigDecimal(cz_sumData.getQf_j1()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    cz_sumData.setQf_b2("0.00");
                    if (cz_sumData.getQf_j2()>0){
                        cz_sumData.setQf_b2(new BigDecimal(cz_sumData.getQf_z2()).divide(new BigDecimal(cz_sumData.getQf_j2()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    cz_sumData.setQf_b3("0.00");
                    if (cz_sumData.getQf_j3()>0){
                        cz_sumData.setQf_b3(new BigDecimal(cz_sumData.getQf_z3()).divide(new BigDecimal(cz_sumData.getQf_j3()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    cz_sumData.setFx_j1(cz_sumData.getQf_j1());
                    cz_sumData.setFx_j2(cz_sumData.getQf_j2());
                    cz_sumData.setFx_j3(cz_sumData.getQf_j3());
                    cz_sumData.setFx_z3(cz_sumData.getFx_z1()+cz_sumData.getFx_z2());
                    cz_sumData.setFx_b1("0.00");
                    if (cz_sumData.getFx_j1()>0){
                        cz_sumData.setFx_b1(new BigDecimal(cz_sumData.getFx_z1()).divide(new BigDecimal(cz_sumData.getFx_j1()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    cz_sumData.setFx_b2("0.00");
                    if (cz_sumData.getFx_j2()>0){
                        cz_sumData.setFx_b2(new BigDecimal(cz_sumData.getFx_z2()).divide(new BigDecimal(cz_sumData.getFx_j2()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    cz_sumData.setFx_b3("0.00");
                    if (cz_sumData.getFx_j3()>0){
                        cz_sumData.setFx_b3(new BigDecimal(cz_sumData.getFx_z3()).divide(new BigDecimal(cz_sumData.getFx_j3()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    cz_sumData.setJq1(new BigDecimal(cz_sumData.getQf_b1()).multiply(new BigDecimal("0.3"))
                            .add(new BigDecimal(cz_sumData.getFx_b1()).multiply(new BigDecimal("0.7")))
                            .setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    cz_sumData.setJq2(new BigDecimal(cz_sumData.getQf_b2()).multiply(new BigDecimal("0.3"))
                            .add(new BigDecimal(cz_sumData.getFx_b2()).multiply(new BigDecimal("0.7")))
                            .setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    cz_sumData.setJq3(new BigDecimal(cz_sumData.getQf_b3()).multiply(new BigDecimal("0.3"))
                            .add(new BigDecimal(cz_sumData.getFx_b3()).multiply(new BigDecimal("0.7")))
                            .setScale(2, BigDecimal.ROUND_HALF_UP).toString());

                    int aa=runQualityReportService.updateByZclFxlJqMonthQn(cz_sumData);
                    if (aa==0){
                        aa=runQualityReportService.insertZclFxlJqMonthQn(cz_sumData);
                    }
                }

                if (rsGH>0){
                    ca_sumData.setDate(ca_sumData.getAgent());
                    ca_sumData.setAgent("GHSUM");
                    ca_sumData.setQf_j3(ca_sumData.getQf_j1()+ca_sumData.getQf_j2());
                    ca_sumData.setQf_z3(ca_sumData.getQf_z1()+ca_sumData.getQf_z2());
                    ca_sumData.setQf_b1("0.00");
                    if (ca_sumData.getQf_j1()>0){
                        ca_sumData.setQf_b1(new BigDecimal(ca_sumData.getQf_z1()).divide(new BigDecimal(ca_sumData.getQf_j1()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    ca_sumData.setQf_b2("0.00");
                    if (ca_sumData.getQf_j2()>0){
                        ca_sumData.setQf_b2(new BigDecimal(ca_sumData.getQf_z2()).divide(new BigDecimal(ca_sumData.getQf_j2()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    ca_sumData.setQf_b3("0.00");
                    if (ca_sumData.getQf_j3()>0){
                        ca_sumData.setQf_b3(new BigDecimal(ca_sumData.getQf_z3()).divide(new BigDecimal(ca_sumData.getQf_j3()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    ca_sumData.setFx_j1(ca_sumData.getQf_j1());
                    ca_sumData.setFx_j2(ca_sumData.getQf_j2());
                    ca_sumData.setFx_j3(ca_sumData.getQf_j3());
                    ca_sumData.setFx_z3(ca_sumData.getFx_z1()+ca_sumData.getFx_z2());
                    ca_sumData.setFx_b1("0.00");
                    if (ca_sumData.getFx_j1()>0){
                        ca_sumData.setFx_b1(new BigDecimal(ca_sumData.getFx_z1()).divide(new BigDecimal(ca_sumData.getFx_j1()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    ca_sumData.setFx_b2("0.00");
                    if (ca_sumData.getFx_j2()>0){
                        ca_sumData.setFx_b2(new BigDecimal(ca_sumData.getFx_z2()).divide(new BigDecimal(ca_sumData.getFx_j2()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    ca_sumData.setFx_b3("0.00");
                    if (ca_sumData.getFx_j3()>0){
                        ca_sumData.setFx_b3(new BigDecimal(ca_sumData.getFx_z3()).divide(new BigDecimal(ca_sumData.getFx_j3()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    ca_sumData.setJq1(new BigDecimal(ca_sumData.getQf_b1()).multiply(new BigDecimal("0.3"))
                            .add(new BigDecimal(ca_sumData.getFx_b1()).multiply(new BigDecimal("0.7")))
                            .setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    ca_sumData.setJq2(new BigDecimal(ca_sumData.getQf_b2()).multiply(new BigDecimal("0.3"))
                            .add(new BigDecimal(ca_sumData.getFx_b2()).multiply(new BigDecimal("0.7")))
                            .setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    ca_sumData.setJq3(new BigDecimal(ca_sumData.getQf_b3()).multiply(new BigDecimal("0.3"))
                            .add(new BigDecimal(ca_sumData.getFx_b3()).multiply(new BigDecimal("0.7")))
                            .setScale(2, BigDecimal.ROUND_HALF_UP).toString());

                    int aa=runQualityReportService.updateByZclFxlJqMonthQn(ca_sumData);
                    if (aa==0){
                        aa=runQualityReportService.insertZclFxlJqMonthQn(ca_sumData);
                    }
                }

                if (rsDF>0){
                    df_sumData.setDate(df_sumData.getAgent());
                    df_sumData.setAgent("DFSUM");
                    df_sumData.setQf_j3(df_sumData.getQf_j1()-df_sumData.getQf_j2());
                    df_sumData.setQf_z3(df_sumData.getQf_z1()-df_sumData.getQf_z2());
                    df_sumData.setQf_b1("0.00");
                    if (df_sumData.getQf_j1()>0){
                        df_sumData.setQf_b1(new BigDecimal(df_sumData.getQf_z1()).divide(new BigDecimal(df_sumData.getQf_j1()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    df_sumData.setQf_b2("0.00");
                    if (df_sumData.getQf_j2()>0){
                        df_sumData.setQf_b2(new BigDecimal(df_sumData.getQf_z2()).divide(new BigDecimal(df_sumData.getQf_j2()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    df_sumData.setQf_b3("0.00");
                    if (df_sumData.getQf_j3()>0){
                        df_sumData.setQf_b3(new BigDecimal(df_sumData.getQf_z3()).divide(new BigDecimal(df_sumData.getQf_j3()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    df_sumData.setFx_j1(df_sumData.getQf_j1());
                    df_sumData.setFx_j2(df_sumData.getQf_j2());
                    df_sumData.setFx_j3(df_sumData.getQf_j3());
                    df_sumData.setFx_z3(df_sumData.getFx_z1()-df_sumData.getFx_z2());
                    df_sumData.setFx_b1("0.00");
                    if (df_sumData.getFx_j1()>0){
                        df_sumData.setFx_b1(new BigDecimal(df_sumData.getFx_z1()).divide(new BigDecimal(df_sumData.getFx_j1()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    df_sumData.setFx_b2("0.00");
                    if (df_sumData.getFx_j2()>0){
                        df_sumData.setFx_b2(new BigDecimal(df_sumData.getFx_z2()).divide(new BigDecimal(df_sumData.getFx_j2()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    df_sumData.setFx_b3("0.00");
                    if (df_sumData.getFx_j3()>0){
                        df_sumData.setFx_b3(new BigDecimal(df_sumData.getFx_z3()).divide(new BigDecimal(df_sumData.getFx_j3()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString());
                    }
                    df_sumData.setJq1(new BigDecimal(df_sumData.getQf_b1()).multiply(new BigDecimal("0.3"))
                            .add(new BigDecimal(df_sumData.getFx_b1()).multiply(new BigDecimal("0.7")))
                            .setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    df_sumData.setJq2(new BigDecimal(df_sumData.getQf_b2()).multiply(new BigDecimal("0.3"))
                            .add(new BigDecimal(df_sumData.getFx_b2()).multiply(new BigDecimal("0.7")))
                            .setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    df_sumData.setJq3(new BigDecimal(df_sumData.getQf_b3()).multiply(new BigDecimal("0.3"))
                            .add(new BigDecimal(df_sumData.getFx_b3()).multiply(new BigDecimal("0.7")))
                            .setScale(2, BigDecimal.ROUND_HALF_UP).toString());

                    int aa=runQualityReportService.updateByZclFxlJqMonthQn(df_sumData);
                    if (aa==0){
                        aa=runQualityReportService.insertZclFxlJqMonthQn(df_sumData);
                    }
                }
            }
        }catch (Exception e){
            log.info("updZclFxlJqMonthQn:"+e);
        }

        return ServerResponse.createBySuccess(rs);
    }
}
