package com.hq.acdm.controller.statistics.operationQualityWeekly;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.operationQualityWeekly.*;
import com.hq.acdm.service.statistics.operationQualityWeekly.OperationQualityWeeklyService;
import com.hq.acdm.vo.statistics.operationQualityWeekly.DomesticVo;
import com.hq.acdm.vo.statistics.operationQualityWeekly.InternationalVo;
import com.hq.acdm.vo.statistics.operationQualityWeekly.OperationQualityWeeklyVo;
import com.hq.acdm.vo.statistics.operationQualityWeekly.TotalVo;
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

@Api(description = "运行品质周报")
@RestController
@RequestMapping("/statisticalReport/operatingQualityWeekly")
@Slf4j
public class OperationQualityWeeklyController {

    @Resource
    private OperationQualityWeeklyService operationQualityWeeklyService;

    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.GET)
    public ServerResponse query(@ApiParam("开始时间") @RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate") String endDate,
                                HttpServletRequest request, HttpServletResponse response) {

        //计算"本周" 对应的"上周"
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date StartDate= null;
        Date SndDate=null;
        try {
            StartDate = sdf.parse(startDate);
            SndDate =sdf.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //开始结束日期之间跨的天数
        int days=(int)((StartDate.getTime()-SndDate.getTime())/(1000*3600*24));
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(StartDate);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        //上周结束日期
        Date lastEndDate=calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        //上周开始日期
        Date lastStartDate=calendar.getTime();

        String lastEndDateStr=sdf.format(lastEndDate).replace("-","");
        String lastStartDateStr=sdf.format(lastStartDate).replace("-","");
        startDate=startDate.replace("-","");
        endDate=endDate.replace("-","");
        //本周总放行率
        List<TotalReleaseRate> bz_totalReleaseRateList = operationQualityWeeklyService.queryTotalReleaseRate(startDate, endDate);
        //上周总放行率
        List<TotalReleaseRate> sz_totalReleaseRateList = operationQualityWeeklyService.queryTotalReleaseRate(lastStartDateStr, lastEndDateStr);
        //本周总延误
        List<TotalDelay> bz_totalDelayList = operationQualityWeeklyService.queryTotalDelay(startDate, endDate);
        //上周总延误
        List<TotalDelay> sz_totalDelayList = operationQualityWeeklyService.queryTotalDelay(lastStartDateStr, lastEndDateStr);
        //本周国内放行率
        List<DomesticReleaseRate> bz_domesticReleaseRateList = operationQualityWeeklyService.queryDomesticReleaseRate(startDate, endDate);
        //上周国内放行率
        List<DomesticReleaseRate> sz_domesticReleaseRateList = operationQualityWeeklyService.queryDomesticReleaseRate(lastStartDateStr, lastEndDateStr);
        //本周国内延误
        List<DomesticDelay> bz_domesticDelayList = operationQualityWeeklyService.queryDomesticDelay(startDate, endDate);
        //上周国内延误
        List<DomesticDelay> sz_domesticDelayList = operationQualityWeeklyService.queryDomesticDelay(lastStartDateStr, lastEndDateStr);
        //本周国际放行
        List<InternationalReaseRate> bz_internationalReaseRateList = operationQualityWeeklyService.queryInternationalReaseRate(startDate, endDate);
        //上周国际放行
        List<InternationalReaseRate> sz_internationalReaseRateList = operationQualityWeeklyService.queryInternationalReaseRate(lastStartDateStr, lastEndDateStr);
        //本周国际延误
        List<InternationalDelay> bz_internationalDelayList = operationQualityWeeklyService.queryInternationalDelay(startDate, endDate);
        //上周国际延误
        List<InternationalDelay> sz_internationalDelayList = operationQualityWeeklyService.queryInternationalDelay(lastStartDateStr, lastEndDateStr);

        Map<String,String> dataMap=new HashMap<String,String>();

        //本周方向率查询0
        for(TotalReleaseRate totalReleaseRate:bz_totalReleaseRateList) {
            dataMap.put("Z_FXL_BZ_KG", totalReleaseRate.getCTOTFXL());
            dataMap.put("Z_FXL_BZ_JC", totalReleaseRate.getATOTFXL());
            dataMap.put("Z_FXL_BZ_SF", totalReleaseRate.getSFFXL());
        }
        //上周总放行率查询
        for(TotalReleaseRate totalReleaseRate:sz_totalReleaseRateList) {
            dataMap.put("Z_FXL_SZ_KG", totalReleaseRate.getCTOTFXL());
            dataMap.put("Z_FXL_SZ_JC", totalReleaseRate.getATOTFXL());
            dataMap.put("Z_FXL_SZ_SF", totalReleaseRate.getSFFXL());
        }

        //本周总延误查询
        for (TotalDelay totalDelay:bz_totalDelayList){
            dataMap.put("Z_YW_BZ_DYW", totalDelay.getYW5MIN());
            dataMap.put("Z_YW_BZ_DYWZB", totalDelay.getYW5ZB());
            dataMap.put("Z_YW_BZ_CYW", totalDelay.getYW4H());
            dataMap.put("Z_YW_BZ_CYWZB", totalDelay.getYW4HZB());
            dataMap.put("Z_YW_BZ_PJYW", totalDelay.getDALAYAVG());
        }
        //上周总延误查询
        for (TotalDelay totalDelay:sz_totalDelayList){
            dataMap.put("Z_YW_SZ_DYW", totalDelay.getYW5MIN());
            dataMap.put("Z_YW_SZ_DYWZB", totalDelay.getYW5ZB());
            dataMap.put("Z_YW_SZ_CYW", totalDelay.getYW4H());
            dataMap.put("Z_YW_SZ_CYWZB", totalDelay.getYW4HZB());
            dataMap.put("Z_YW_SZ_PJYW", totalDelay.getDALAYAVG());
        }


        //本周国内放行率查询
        for (DomesticReleaseRate domesticReleaseRate:bz_domesticReleaseRateList){
            dataMap.put("GN_FXL_BZ_KG", domesticReleaseRate.getCTOTFXL());
            dataMap.put("GN_FXL_BZ_JC", domesticReleaseRate.getATOTFXL());
            dataMap.put("GN_FXL_BZ_SF", domesticReleaseRate.getSFFXL());
        }
        //上周国内放行率查询
        for (DomesticReleaseRate domesticReleaseRate:sz_domesticReleaseRateList){
            dataMap.put("GN_FXL_SZ_KG", domesticReleaseRate.getCTOTFXL());
            dataMap.put("GN_FXL_SZ_JC", domesticReleaseRate.getATOTFXL());
            dataMap.put("GN_FXL_SZ_SF", domesticReleaseRate.getSFFXL());
        }

        //本周国内延误查询
        for (DomesticDelay domesticDelay:bz_domesticDelayList){
            dataMap.put("GN_YW_BZ_DYW", domesticDelay.getYW5MIN());
            dataMap.put("GN_YW_BZ_DYWZB", domesticDelay.getYW5ZB());
            dataMap.put("GN_YW_BZ_CYW", domesticDelay.getYW4H());
            dataMap.put("GN_YW_BZ_CYWZB", domesticDelay.getYW4HZB());
            dataMap.put("GN_YW_BZ_PJYW", domesticDelay.getDALAYAVG());
        }
        //上周国内延误查询
        for (DomesticDelay domesticDelay:sz_domesticDelayList){
            dataMap.put("GN_YW_SZ_DYW", domesticDelay.getYW5MIN());
            dataMap.put("GN_YW_SZ_DYWZB", domesticDelay.getYW5ZB());
            dataMap.put("GN_YW_SZ_CYW", domesticDelay.getYW4H());
            dataMap.put("GN_YW_SZ_CYWZB", domesticDelay.getYW4HZB());
            dataMap.put("GN_YW_SZ_PJYW", domesticDelay.getDALAYAVG());
        }


        //本周国际放行率查询
        for (InternationalReaseRate internationalReaseRate:bz_internationalReaseRateList){
            dataMap.put("GJ_FXL_BZ_KG", internationalReaseRate.getCTOTFXL());
            dataMap.put("GJ_FXL_BZ_JC", internationalReaseRate.getATOTFXL());
            dataMap.put("GJ_FXL_BZ_SF", internationalReaseRate.getSFFXL());
        }
        //上周国际放行率查询
        for (InternationalReaseRate internationalReaseRate:sz_internationalReaseRateList){
            dataMap.put("GJ_FXL_SZ_KG", internationalReaseRate.getCTOTFXL());
            dataMap.put("GJ_FXL_SZ_JC", internationalReaseRate.getATOTFXL());
            dataMap.put("GJ_FXL_SZ_SF", internationalReaseRate.getSFFXL());
        }

        //本周国际延误查询
        for (InternationalDelay internationalDelay:bz_internationalDelayList){
            dataMap.put("GJ_YW_BZ_DYW", internationalDelay.getYW5MIN());
            dataMap.put("GJ_YW_BZ_DYWZB", internationalDelay.getYW5ZB());
            dataMap.put("GJ_YW_BZ_CYW", internationalDelay.getYW4H());
            dataMap.put("GJ_YW_BZ_CYWZB", internationalDelay.getYW4HZB());
            dataMap.put("GJ_YW_BZ_PJYW", internationalDelay.getDALAYAVG());
        }
        //上周国际延误查询
        for (InternationalDelay internationalDelay:sz_internationalDelayList) {
            dataMap.put("GJ_YW_SZ_DYW", internationalDelay.getYW5MIN());
            dataMap.put("GJ_YW_SZ_DYWZB", internationalDelay.getYW5ZB());
            dataMap.put("GJ_YW_SZ_CYW", internationalDelay.getYW4H());
            dataMap.put("GJ_YW_SZ_CYWZB", internationalDelay.getYW4HZB());
            dataMap.put("GJ_YW_SZ_PJYW", internationalDelay.getDALAYAVG());
        }

        OperationQualityWeeklyVo operationQualityWeeklyVo=new OperationQualityWeeklyVo();

        TotalVo totalVo=new TotalVo();

        DomesticVo domesticVo=new DomesticVo();

        InternationalVo internationalVo=new InternationalVo();

        totalVo.setWEEK("本周");
        domesticVo.setWEEK("本周");
        internationalVo.setWEEK("本周");
        //总空管放行正常率_数值
        totalVo.setZ_KG_SZ(dataMap.get("Z_FXL_BZ_KG"));
        Double Z_FXL_BZ_KG_D=Double.parseDouble(dataMap.get("Z_FXL_BZ_KG").replaceAll("%", ""));
        Double Z_FXL_SZ_KG_D=Double.parseDouble(dataMap.get("Z_FXL_SZ_KG").replaceAll("%", ""));
        //空管放行正常率_环比
        totalVo.setZ_KG_HB(String.format("%.2f", Z_FXL_BZ_KG_D-Z_FXL_SZ_KG_D)+"%");


        //总机场放行正常率_数值
        totalVo.setZ_JC_SZ(dataMap.get("Z_FXL_BZ_JC"));
        Double Z_FXL_BZ_JC_D=Double.parseDouble(dataMap.get("Z_FXL_BZ_JC").replaceAll("%", ""));
        Double Z_FXL_SZ_JC_D=Double.parseDouble(dataMap.get("Z_FXL_SZ_JC").replaceAll("%", ""));
        //总机场放行正常率_环比
        totalVo.setZ_JC_HB(String.format("%.2f", Z_FXL_BZ_JC_D-Z_FXL_SZ_JC_D)+"%");

        Double Z_FLX_BZ_DM_D=0.0;
        Double Z_FLX_SZ_DM_D=0.0;
        if(Z_FXL_BZ_KG_D!=0){
            Z_FLX_BZ_DM_D=Z_FXL_BZ_JC_D/Z_FXL_BZ_KG_D*100;
        }
        if(Z_FXL_SZ_KG_D!=0){
            Z_FLX_SZ_DM_D=Z_FXL_SZ_JC_D/Z_FXL_SZ_KG_D*100;
        }

        //总地面放行正常率_数值
        totalVo.setZ_DM_SZ(String.format("%.2f", Z_FLX_BZ_DM_D)+"%");
        //总地面放行正常率_环比
        totalVo.setZ_DM_HB(String.format("%.2f",Z_FLX_BZ_DM_D-Z_FLX_SZ_DM_D)+"%");


        //总机场放行正常率_数值
        totalVo.setZ_SF_SZ(dataMap.get("Z_FXL_BZ_SF"));
        Double Z_FXL_BZ_SF_D=Double.parseDouble(dataMap.get("Z_FXL_BZ_SF").replaceAll("%", ""));
        Double Z_FXL_SZ_SF_D=Double.parseDouble(dataMap.get("Z_FXL_SZ_SF").replaceAll("%", ""));
        //总机场放行正常率_环比
        totalVo.setZ_SF_HB(String.format("%.2f", Z_FXL_BZ_SF_D-Z_FXL_SZ_SF_D)+"%");


        //总短延误_班数
        totalVo.setZ_DYW_BS(dataMap.get("Z_YW_BZ_DYW"));
        Double Z_YW_BZ_DYWZB_D=Double.parseDouble(dataMap.get("Z_YW_BZ_DYWZB"))*100;
        Double Z_YW_SZ_DYWZB_D=Double.parseDouble(dataMap.get("Z_YW_SZ_DYWZB"))*100;
        //总短延误_占比
        totalVo.setZ_DYW_ZB(String.format("%.2f", Z_YW_BZ_DYWZB_D)+"%");
        //总短延误_环比
        totalVo.setZ_DYW_HB(String.format("%.2f", Z_YW_BZ_DYWZB_D-Z_YW_SZ_DYWZB_D)+"%");


        //总长延误_班数
        totalVo.setZ_CYW_BS(dataMap.get("Z_YW_BZ_CYW"));
        Double Z_YW_BZ_CYWZB_D=Double.parseDouble(dataMap.get("Z_YW_BZ_CYWZB"))*100;
        Double Z_YW_SZ_CYWZB_D=Double.parseDouble(dataMap.get("Z_YW_SZ_CYWZB"))*100;
        //总长延误_占比
        totalVo.setZ_CYW_ZB(String.format("%.2f",Z_YW_BZ_CYWZB_D)+"%");
        //总长延误_环比
        totalVo.setZ_CYW_HB(String.format("%.2f", Z_YW_BZ_CYWZB_D-Z_YW_SZ_CYWZB_D)+"%");


        //总平均延误_分数
        totalVo.setZ_PJ_FZ(dataMap.get("Z_YW_BZ_PJYW"));
        Double Z_YW_BZ_PJYW_D=Double.parseDouble(dataMap.get("Z_YW_BZ_PJYW"));
        Double Z_YW_SZ_PJYW_D=Double.parseDouble(dataMap.get("Z_YW_SZ_PJYW"));
        //总平均延误_环比
        totalVo.setZ_PJ_HB(String.format("%.2f", Z_YW_BZ_PJYW_D-Z_YW_SZ_PJYW_D));



        //国内空管放行正常率_数值
        domesticVo.setGN_KG_SZ(dataMap.get("GN_FXL_BZ_KG"));
        Double GN_FXL_BZ_KG_D=Double.parseDouble(dataMap.get("GN_FXL_BZ_KG").replaceAll("%", ""));
        Double GN_FXL_SZ_KG_D=Double.parseDouble(dataMap.get("GN_FXL_SZ_KG").replaceAll("%", ""));
        //空管放行正常率_环比
        domesticVo.setGN_KG_HB(String.format("%.2f", GN_FXL_BZ_KG_D-GN_FXL_SZ_KG_D)+"%");


        //国内机场放行正常率_数值
        domesticVo.setGN_JC_SZ(dataMap.get("GN_FXL_BZ_JC"));
        Double GN_FXL_BZ_JC_D=Double.parseDouble(dataMap.get("GN_FXL_BZ_JC").replaceAll("%", ""));
        Double GN_FXL_SZ_JC_D=Double.parseDouble(dataMap.get("GN_FXL_SZ_JC").replaceAll("%", ""));
        //国内机场放行正常率_环比
        domesticVo.setGN_JC_HB(String.format("%.2f", GN_FXL_BZ_JC_D-GN_FXL_SZ_JC_D)+"%");


        Double GN_FLX_BZ_DM_D=0.0;
        Double GN_FLX_SZ_DM_D=0.0;
        if(GN_FXL_BZ_KG_D!=0){
            GN_FLX_BZ_DM_D=GN_FXL_BZ_JC_D/GN_FXL_BZ_KG_D*100;
        }
        if(GN_FXL_SZ_KG_D!=0){
            GN_FLX_SZ_DM_D=GN_FXL_SZ_JC_D/GN_FXL_SZ_KG_D*100;
        }



        //国内机场放行正常率_数值
        domesticVo.setGN_DM_SZ(String.format("%.2f", GN_FLX_BZ_DM_D)+"%");
        //国内机场放行正常率_环比
        domesticVo.setGN_DM_HB(String.format("%.2f",GN_FLX_BZ_DM_D-GN_FLX_SZ_DM_D)+"%");


        //国内机场放行正常率_数值
        domesticVo.setGN_SF_SZ(dataMap.get("GN_FXL_BZ_SF"));
        Double GN_FXL_BZ_SF_D=Double.parseDouble(dataMap.get("GN_FXL_BZ_SF").replaceAll("%", ""));
        Double GN_FXL_SZ_SF_D=Double.parseDouble(dataMap.get("GN_FXL_SZ_SF").replaceAll("%", ""));
        //国内机场放行正常率_环比
        domesticVo.setGN_SF_HB(String.format("%.2f", GN_FXL_BZ_SF_D-GN_FXL_SZ_SF_D)+"%");


        //国内短延误_班数
        domesticVo.setGN_DYW_BS(dataMap.get("GN_YW_BZ_DYW"));
        Double GN_YW_BZ_DYWZB_D=Double.parseDouble(dataMap.get("GN_YW_BZ_DYWZB"))*100;
        Double GN_YW_SZ_DYWZB_D=Double.parseDouble(dataMap.get("GN_YW_SZ_DYWZB"))*100;
        //国内短延误_占比
        domesticVo.setGN_DYW_ZB(String.format("%.2f",GN_YW_BZ_DYWZB_D)+"%");
        //国内短延误_环比
        domesticVo.setGN_DYW_HB(String.format("%.2f", GN_YW_BZ_DYWZB_D-GN_YW_SZ_DYWZB_D)+"%");


        //国内长延误_班数
        domesticVo.setGN_CYW_BS(dataMap.get("GN_YW_BZ_CYW"));
        Double GN_YW_BZ_CYWZB_D=Double.parseDouble(dataMap.get("GN_YW_BZ_CYWZB"))*100;
        Double GN_YW_SZ_CYWZB_D=Double.parseDouble(dataMap.get("GN_YW_SZ_CYWZB"))*100;
        //国内长延误_占比
        domesticVo.setGN_CYW_ZB(String.format("%.2f", GN_YW_BZ_CYWZB_D)+"%");
        //国内长延误_环比
        domesticVo.setGN_CYW_HB(String.format("%.2f", GN_YW_BZ_CYWZB_D-GN_YW_SZ_CYWZB_D)+"%");


        //国内平均延误_分数
        domesticVo.setGN_PJ_FZ(dataMap.get("GN_YW_BZ_PJYW"));
        Double GN_YW_BZ_PJYW_D=Double.parseDouble(dataMap.get("GN_YW_BZ_PJYW"));
        Double GN_YW_SZ_PJYW_D=Double.parseDouble(dataMap.get("GN_YW_SZ_PJYW"));
        //国内平均延误_环比
        domesticVo.setGN_PJ_HB(String.format("%.2f", GN_YW_BZ_PJYW_D-GN_YW_SZ_PJYW_D));



        //国际空管放行正常率_数值
        internationalVo.setGJ_KG_SZ(dataMap.get("GJ_FXL_BZ_KG"));
        Double GJ_FXL_BZ_KG_D=Double.parseDouble(dataMap.get("GJ_FXL_BZ_KG").replaceAll("%", ""));
        Double GJ_FXL_SZ_KG_D=Double.parseDouble(dataMap.get("GJ_FXL_SZ_KG").replaceAll("%", ""));
        //空管放行正常率_环比
        internationalVo.setGJ_KG_HB(String.format("%.2f", GJ_FXL_BZ_KG_D-GJ_FXL_SZ_KG_D)+"%");


        //国际机场放行正常率_数值
        internationalVo.setGJ_JC_SZ(dataMap.get("GJ_FXL_BZ_JC"));
        Double GJ_FXL_BZ_JC_D=Double.parseDouble(dataMap.get("GJ_FXL_BZ_JC").replaceAll("%", ""));
        Double GJ_FXL_SZ_JC_D=Double.parseDouble(dataMap.get("GJ_FXL_SZ_JC").replaceAll("%", ""));
        //国际机场放行正常率_环比
        internationalVo.setGJ_JC_HB(String.format("%.2f", GJ_FXL_BZ_JC_D-GJ_FXL_SZ_JC_D)+"%");


        Double GJ_FLX_BZ_DM_D=0.0;
        Double GJ_FLX_SZ_DM_D=0.0;
        if(GJ_FXL_BZ_KG_D!=0){
            GJ_FLX_BZ_DM_D=GJ_FXL_BZ_JC_D/GJ_FXL_BZ_KG_D*100;
        }
        if(GJ_FXL_SZ_KG_D!=0){
            GJ_FLX_SZ_DM_D=GJ_FXL_SZ_JC_D/GJ_FXL_SZ_KG_D*100;
        }



        //国际机场放行正常率_数值
        internationalVo.setGJ_DM_SZ(String.format("%.2f", GJ_FLX_BZ_DM_D)+"%");
        //国际机场放行正常率_环比
        internationalVo.setGJ_DM_HB(String.format("%.2f",GJ_FLX_BZ_DM_D-GJ_FLX_SZ_DM_D)+"%");


        //国际机场放行正常率_数值
        internationalVo.setGJ_SF_SZ(dataMap.get("GJ_FXL_BZ_SF"));
        Double GJ_FXL_BZ_SF_D=Double.parseDouble(dataMap.get("GJ_FXL_BZ_SF").replaceAll("%", ""));
        Double GJ_FXL_SZ_SF_D=Double.parseDouble(dataMap.get("GJ_FXL_SZ_SF").replaceAll("%", ""));
        //国际机场放行正常率_环比
        internationalVo.setGJ_SF_HB(String.format("%.2f", GJ_FXL_BZ_SF_D-GJ_FXL_SZ_SF_D)+"%");


        //国际短延误_班数
        internationalVo.setGJ_DYW_BS(dataMap.get("GJ_YW_BZ_DYW"));
        Double GJ_YW_BZ_DYWZB_D=Double.parseDouble(dataMap.get("GJ_YW_BZ_DYWZB"))*100;
        Double GJ_YW_SZ_DYWZB_D=Double.parseDouble(dataMap.get("GJ_YW_SZ_DYWZB"))*100;
        //国际短延误_占比
        internationalVo.setGJ_DYW_ZB(String.format("%.2f",GJ_YW_BZ_DYWZB_D)+"%");
        //国际短延误_环比
        internationalVo.setGJ_DYW_HB(String.format("%.2f", GJ_YW_BZ_DYWZB_D-GJ_YW_SZ_DYWZB_D)+"%");


        //国际长延误_班数
        internationalVo.setGJ_CYW_BS(dataMap.get("GJ_YW_BZ_CYW"));
        Double GJ_YW_BZ_CYWZB_D=Double.parseDouble(dataMap.get("GJ_YW_BZ_CYWZB"))*100;
        Double GJ_YW_SZ_CYWZB_D=Double.parseDouble(dataMap.get("GJ_YW_SZ_CYWZB"))*100;
        //国际长延误_占比
        internationalVo.setGJ_CYW_ZB(String.format("%.2f", GJ_YW_BZ_CYWZB_D)+"%");
        //国际长延误_环比
        internationalVo.setGJ_CYW_HB(String.format("%.2f", GJ_YW_BZ_CYWZB_D-GJ_YW_SZ_CYWZB_D)+"%");


        //国际平均延误_分数
        internationalVo.setGJ_PJ_FZ(dataMap.get("GJ_YW_BZ_PJYW"));
        Double GJ_YW_BZ_PJYW_D=Double.parseDouble(dataMap.get("GJ_YW_BZ_PJYW"));
        Double GJ_YW_SZ_PJYW_D=Double.parseDouble(dataMap.get("GJ_YW_SZ_PJYW"));
        //国际平均延误_环比
        internationalVo.setGJ_PJ_HB(String.format("%.2f", GJ_YW_BZ_PJYW_D-GJ_YW_SZ_PJYW_D));

        List<TotalVo> totalVoList=new ArrayList<>();
        List<DomesticVo> domesticVoList=new ArrayList<>();
        List<InternationalVo> internationalVoList=new ArrayList<>();
        totalVoList.add(totalVo);
        domesticVoList.add(domesticVo);
        internationalVoList.add(internationalVo);
        operationQualityWeeklyVo.setTotal(totalVoList);
        operationQualityWeeklyVo.setDomestic(domesticVoList);
        operationQualityWeeklyVo.setInternational(internationalVoList);
        return ServerResponse.createBySuccess(operationQualityWeeklyVo);
    }

}
