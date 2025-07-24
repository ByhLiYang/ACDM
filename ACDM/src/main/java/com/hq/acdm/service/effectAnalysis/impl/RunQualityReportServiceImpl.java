package com.hq.acdm.service.effectAnalysis.impl;


import com.hq.acdm.dao.effectAnalysis.RunQualityReportMapper;
import com.hq.acdm.service.effectAnalysis.RunQualityReportService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.effectAnalysis.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Slf4j
@Service
public class RunQualityReportServiceImpl implements RunQualityReportService {

    @Resource
    private RunQualityReportMapper runQualityReportMapper;

    //查询运输量
    @Override
    public List<RunQualityReportVo> findYunShuLiang(@Param("params") Map params){
        return runQualityReportMapper.findYunShuLiang(params);
    }

    //查询人数
    @Override
    public List<RunQualityReportVo> findRenShu(@Param("params") Map params){
        return runQualityReportMapper.findRenShu(params);
    }

    //查询航班正常性统计(正常率、放行率，始发放行率)-天
    @Override
    public List<RunQualityReportZCLVo> findZCLDay(@Param("params") Map params){
        return runQualityReportMapper.findZCLDay(params);
    }

    //查询航班正常性统计(正常率、放行率，始发放行率)-月
    @Override
    public List<RunQualityReportZCLVo> findZCLMonth(@Param("params") Map params){
        return runQualityReportMapper.findZCLMonth(params);
    }

    //查询航班正常性统计(正常率、放行率，始发放行率)-年
    @Override
    public List<RunQualityReportZCLVo> findZCLYear(@Param("params") Map params){
        return runQualityReportMapper.findZCLYear(params);
    }

    //查询航班正常性统计(正常率、放行率，始发放行率)-去年同天
    @Override
    public List<RunQualityReportZCLVo> findZCLDayQn(@Param("params") Map params){
        return runQualityReportMapper.findZCLDayQn(params);
    }


    //查询航班正常性统计(正常率、放行率，始发放行率)-去年同月
    @Override
    public List<RunQualityReportZCLVo> findZCLMonthQn(@Param("params") Map params){
        return runQualityReportMapper.findZCLMonthQn(params);
    }

    //查询航班正常性统计(正常率、放行率，始发放行率)-去年
    @Override
    public List<RunQualityReportZCLVo> findZCLYearQn(@Param("params") Map params){
        return runQualityReportMapper.findZCLYearQn(params);
    }

    //查询靠桥率
    public String findKQL(@Param("params") Map params){
        return runQualityReportMapper.findKQL(params);
    }

    //查询关门准点率及晚关门航班数
    public List<RunQualityReportVo> findGMZDL(@Param("params") Map params){
        return runQualityReportMapper.findGMZDL(params);
    }

    //查询放行正常率排名（国航）当天
    public String findFxlDayGH(@Param("params") Map params){
        return runQualityReportMapper.findFxlDayGH(params);
    }

    //查询放行正常率排名（国航）当月
    public String findFxlMonthGH(@Param("params") Map params){
        return runQualityReportMapper.findFxlMonthGH(params);
    }

    //查询放行正常率排名（南航）当天
    public String findFxlDayNH(@Param("params") Map params){
        return runQualityReportMapper.findFxlDayNH(params);
    }

    //查询放行正常率排名（南航）当月
    public String findFxlMonthNH(@Param("params") Map params){
        return runQualityReportMapper.findFxlMonthNH(params);
    }

    //查询放行正常率排名（东航）当天
    public String findFxlDayDH(@Param("params") Map params){
        return runQualityReportMapper.findFxlDayDH(params);
    }

    //查询放行正常率排名（东航）当月
    public String findFxlMonthDH(@Param("params") Map params){
        return runQualityReportMapper.findFxlMonthDH(params);
    }

    //查询放行正常率排名（地服）当天
    public String findFxlDayDF(@Param("params") Map params){
        return runQualityReportMapper.findFxlDayDF(params);
    }

    //查询放行正常率排名（地服）当月
    public String findFxlMonthDF(@Param("params") Map params){
        return runQualityReportMapper.findFxlMonthDF(params);
    }

    //查询放行正常率排名（货运）当天
    public String findFxlDayHY(@Param("params") Map params){
        return runQualityReportMapper.findFxlDayHY(params);
    }

    //查询放行正常率排名（货运）当月
    public String findFxlMonthHY(@Param("params") Map params){
        return runQualityReportMapper.findFxlMonthHY(params);
    }

    //查询实际小时起降架次最高
    public String findMaxAOrDHbs(@Param("params") Map params){
        return runQualityReportMapper.findMaxAOrDHbs(params);
    }

    //平均进港滑行时间（分钟）
    public String findAvgJghxsj(@Param("params") Map params){
        return runQualityReportMapper.findAvgJghxsj(params);
    }

    //平均出港滑行时间（分钟）
    public String findAvgCghxsj(@Param("params") Map params){
        return runQualityReportMapper.findAvgCghxsj(params);
    }

    //查询航班进港实际数
    public List<RunQualityReportAOrDShuVo> findAsjs(@Param("params") Map params){
        return runQualityReportMapper.findAsjs(params);
    }

    //查询航班出港计划数
    public List<RunQualityReportAOrDShuVo> findDjhs(@Param("params") Map params){
        return runQualityReportMapper.findDjhs(params);
    }

    //查询航班出港实际数
    public List<RunQualityReportAOrDShuVo> findDsjs(@Param("params") Map params){
        return runQualityReportMapper.findDsjs(params);
    }

    //查询小时架次统计图
    public List<RunQualityReportEChartVo> findEChartsInfo(@Param("params") Map params){
        List<RunQualityReportEChartVo> list = new ArrayList<RunQualityReportEChartVo>();
        RunQualityReportEChartVo vo = new RunQualityReportEChartVo();
        int []asjs = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int []djhs = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int []dsjs = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String execDate = params.get("execDate2").toString();
        String agent = params.get("agent").toString();
        if (StringUtil.isEmpty(agent))agent="ALL";
        RunQualityPDFVo pdfVo=this.selectByPDFPrimaryKey(execDate,agent);
        //先查简报保存表，没有再从航班主表捞数据
        if (pdfVo!=null&&StringUtil.isNotEmpty(pdfVo.getExecdate())){
            try {
                djhs[0]= Integer.parseInt(pdfVo.getEchartDjhs0());
                djhs[1]= Integer.parseInt(pdfVo.getEchartDjhs1());
                djhs[2]= Integer.parseInt(pdfVo.getEchartDjhs2());
                djhs[3]= Integer.parseInt(pdfVo.getEchartDjhs3());
                djhs[4]= Integer.parseInt(pdfVo.getEchartDjhs4());
                djhs[5]= Integer.parseInt(pdfVo.getEchartDjhs5());
                djhs[6]= Integer.parseInt(pdfVo.getEchartDjhs6());
                djhs[7]= Integer.parseInt(pdfVo.getEchartDjhs7());
                djhs[8]= Integer.parseInt(pdfVo.getEchartDjhs8());
                djhs[9]= Integer.parseInt(pdfVo.getEchartDjhs9());
                djhs[10]= Integer.parseInt(pdfVo.getEchartDjhs10());
                djhs[11]= Integer.parseInt(pdfVo.getEchartDjhs11());
                djhs[12]= Integer.parseInt(pdfVo.getEchartDjhs12());
                djhs[13]= Integer.parseInt(pdfVo.getEchartDjhs13());
                djhs[14]= Integer.parseInt(pdfVo.getEchartDjhs14());
                djhs[15]= Integer.parseInt(pdfVo.getEchartDjhs15());
                djhs[16]= Integer.parseInt(pdfVo.getEchartDjhs16());

                dsjs[0]= Integer.parseInt(pdfVo.getEchartDsjs0());
                dsjs[1]= Integer.parseInt(pdfVo.getEchartDsjs1());
                dsjs[2]= Integer.parseInt(pdfVo.getEchartDsjs2());
                dsjs[3]= Integer.parseInt(pdfVo.getEchartDsjs3());
                dsjs[4]= Integer.parseInt(pdfVo.getEchartDsjs4());
                dsjs[5]= Integer.parseInt(pdfVo.getEchartDsjs5());
                dsjs[6]= Integer.parseInt(pdfVo.getEchartDsjs6());
                dsjs[7]= Integer.parseInt(pdfVo.getEchartDsjs7());
                dsjs[8]= Integer.parseInt(pdfVo.getEchartDsjs8());
                dsjs[9]= Integer.parseInt(pdfVo.getEchartDsjs9());
                dsjs[10]= Integer.parseInt(pdfVo.getEchartDsjs10());
                dsjs[11]= Integer.parseInt(pdfVo.getEchartDsjs11());
                dsjs[12]= Integer.parseInt(pdfVo.getEchartDsjs12());
                dsjs[13]= Integer.parseInt(pdfVo.getEchartDsjs13());
                dsjs[14]= Integer.parseInt(pdfVo.getEchartDsjs14());
                dsjs[15]= Integer.parseInt(pdfVo.getEchartDsjs15());
                dsjs[16]= Integer.parseInt(pdfVo.getEchartDsjs16());
            }catch (Exception e){

            }



        }else {
            //List<RunQualityReportAOrDShuVo> listAsjs = this.findAsjs(params);
            List<RunQualityReportAOrDShuVo> listDjhs = this.findDjhs(params);
            List<RunQualityReportAOrDShuVo> listDsjs = this.findDsjs(params);
        /*for(int i=0;i<listAsjs.size();i++){
            if("07".equals(listAsjs.get(i).getTimeH())){
                asjs[0] = listAsjs.get(i).getHbs();
            }
            if("08".equals(listAsjs.get(i).getTimeH())){
                asjs[1] = listAsjs.get(i).getHbs();
            }
            if("09".equals(listAsjs.get(i).getTimeH())){
                asjs[2] = listAsjs.get(i).getHbs();
            }
            if("10".equals(listAsjs.get(i).getTimeH())){
                asjs[3] = listAsjs.get(i).getHbs();
            }
            if("11".equals(listAsjs.get(i).getTimeH())){
                asjs[4] = listAsjs.get(i).getHbs();
            }
            if("12".equals(listAsjs.get(i).getTimeH())){
                asjs[5] = listAsjs.get(i).getHbs();
            }
            if("13".equals(listAsjs.get(i).getTimeH())){
                asjs[6] = listAsjs.get(i).getHbs();
            }
            if("14".equals(listAsjs.get(i).getTimeH())){
                asjs[7] = listAsjs.get(i).getHbs();
            }
            if("15".equals(listAsjs.get(i).getTimeH())){
                asjs[8] = listAsjs.get(i).getHbs();
            }
            if("16".equals(listAsjs.get(i).getTimeH())){
                asjs[9] = listAsjs.get(i).getHbs();
            }
            if("17".equals(listAsjs.get(i).getTimeH())){
                asjs[10] = listAsjs.get(i).getHbs();
            }
            if("18".equals(listAsjs.get(i).getTimeH())){
                asjs[11] = listAsjs.get(i).getHbs();
            }
            if("19".equals(listAsjs.get(i).getTimeH())){
                asjs[12] = listAsjs.get(i).getHbs();
            }
            if("20".equals(listAsjs.get(i).getTimeH())){
                asjs[13] = listAsjs.get(i).getHbs();
            }
            if("21".equals(listAsjs.get(i).getTimeH())){
                asjs[14] = listAsjs.get(i).getHbs();
            }
            if("22".equals(listAsjs.get(i).getTimeH())){
                asjs[15] = listAsjs.get(i).getHbs();
            }
            if("23".equals(listAsjs.get(i).getTimeH())){
                asjs[16] = listAsjs.get(i).getHbs();
            }
        }*/

            for(int i=0;i<listDjhs.size();i++){
                if("07".equals(listDjhs.get(i).getTimeH())){
                    djhs[0] = listDjhs.get(i).getHbs();
                }
                if("08".equals(listDjhs.get(i).getTimeH())){
                    djhs[1] = listDjhs.get(i).getHbs();
                }
                if("09".equals(listDjhs.get(i).getTimeH())){
                    djhs[2] = listDjhs.get(i).getHbs();
                }
                if("10".equals(listDjhs.get(i).getTimeH())){
                    djhs[3] = listDjhs.get(i).getHbs();
                }
                if("11".equals(listDjhs.get(i).getTimeH())){
                    djhs[4] = listDjhs.get(i).getHbs();
                }
                if("12".equals(listDjhs.get(i).getTimeH())){
                    djhs[5] = listDjhs.get(i).getHbs();
                }
                if("13".equals(listDjhs.get(i).getTimeH())){
                    djhs[6] = listDjhs.get(i).getHbs();
                }
                if("14".equals(listDjhs.get(i).getTimeH())){
                    djhs[7] = listDjhs.get(i).getHbs();
                }
                if("15".equals(listDjhs.get(i).getTimeH())){
                    djhs[8] = listDjhs.get(i).getHbs();
                }
                if("16".equals(listDjhs.get(i).getTimeH())){
                    djhs[9] = listDjhs.get(i).getHbs();
                }
                if("17".equals(listDjhs.get(i).getTimeH())){
                    djhs[10] = listDjhs.get(i).getHbs();
                }
                if("18".equals(listDjhs.get(i).getTimeH())){
                    djhs[11] = listDjhs.get(i).getHbs();
                }
                if("19".equals(listDjhs.get(i).getTimeH())){
                    djhs[12] = listDjhs.get(i).getHbs();
                }
                if("20".equals(listDjhs.get(i).getTimeH())){
                    djhs[13] = listDjhs.get(i).getHbs();
                }
                if("21".equals(listDjhs.get(i).getTimeH())){
                    djhs[14] = listDjhs.get(i).getHbs();
                }
                if("22".equals(listDjhs.get(i).getTimeH())){
                    djhs[15] = listDjhs.get(i).getHbs();
                }
                if("23".equals(listDjhs.get(i).getTimeH())){
                    djhs[16] = listDjhs.get(i).getHbs();
                }
            }

            for(int i=0;i<listDsjs.size();i++){
                if("07".equals(listDsjs.get(i).getTimeH())){
                    dsjs[0] = listDsjs.get(i).getHbs();
                }
                if("08".equals(listDsjs.get(i).getTimeH())){
                    dsjs[1] = listDsjs.get(i).getHbs();
                }
                if("09".equals(listDsjs.get(i).getTimeH())){
                    dsjs[2] = listDsjs.get(i).getHbs();
                }
                if("10".equals(listDsjs.get(i).getTimeH())){
                    dsjs[3] = listDsjs.get(i).getHbs();
                }
                if("11".equals(listDsjs.get(i).getTimeH())){
                    dsjs[4] = listDsjs.get(i).getHbs();
                }
                if("12".equals(listDsjs.get(i).getTimeH())){
                    dsjs[5] = listDsjs.get(i).getHbs();
                }
                if("13".equals(listDsjs.get(i).getTimeH())){
                    dsjs[6] = listDsjs.get(i).getHbs();
                }
                if("14".equals(listDsjs.get(i).getTimeH())){
                    dsjs[7] = listDsjs.get(i).getHbs();
                }
                if("15".equals(listDsjs.get(i).getTimeH())){
                    dsjs[8] = listDsjs.get(i).getHbs();
                }
                if("16".equals(listDsjs.get(i).getTimeH())){
                    dsjs[9] = listDsjs.get(i).getHbs();
                }
                if("17".equals(listDsjs.get(i).getTimeH())){
                    dsjs[10] = listDsjs.get(i).getHbs();
                }
                if("18".equals(listDsjs.get(i).getTimeH())){
                    dsjs[11] = listDsjs.get(i).getHbs();
                }
                if("19".equals(listDsjs.get(i).getTimeH())){
                    dsjs[12] = listDsjs.get(i).getHbs();
                }
                if("20".equals(listDsjs.get(i).getTimeH())){
                    dsjs[13] = listDsjs.get(i).getHbs();
                }
                if("21".equals(listDsjs.get(i).getTimeH())){
                    dsjs[14] = listDsjs.get(i).getHbs();
                }
                if("22".equals(listDsjs.get(i).getTimeH())){
                    dsjs[15] = listDsjs.get(i).getHbs();
                }
                if("23".equals(listDsjs.get(i).getTimeH())){
                    dsjs[16] = listDsjs.get(i).getHbs();
                }
            }
        }



        vo.setAsjs(asjs);
        vo.setDjhs(djhs);
        vo.setDsjs(dsjs);
        list.add(vo);
        return list;
    }

    //航班运行品质简报
    @Override
    public List<RunQualityReportVo> findRunQualityReportByDate(@Param("params") Map params) {
        List<RunQualityReportVo> listRunQualityReportVo = new ArrayList<RunQualityReportVo>();
        List<RunQualityReportVo>  listYunShuLiang  = this.findYunShuLiang(params);
        List<RunQualityReportVo>  listRenShu  = this.findRenShu(params);
        List<RunQualityReportZCLVo> listZclDay = this.findZCLDay(params);
        List<RunQualityReportZCLVo> listZclDayQn = this.findZCLDayQn(params);
        List<RunQualityReportZCLVo> listZclMonth = this.findZCLMonth(params);
        List<RunQualityReportZCLVo> listZclMonthQn = this.findZCLMonthQn(params);
        List<RunQualityReportZCLVo> listZclYear = this.findZCLYear(params);
        List<RunQualityReportZCLVo> listZclYearQn = this.findZCLYearQn(params);
        List<RunQualityReportVo>  listGMZDL  = this.findGMZDL(params);

        RunQualityReportVo vo = new RunQualityReportVo();
        vo.setExecDate(DateTimeUtil.dateToStr((Date)params.get("execDate"),"yyyy-MM-dd"));
        //运输量
        vo.setFlDay(listYunShuLiang.get(0).getFlDay());
        vo.setFlDayTb(listYunShuLiang.get(0).getFlDayTb().equals("-") == true ? "-" : new BigDecimal(listYunShuLiang.get(0).getFlDayTb()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        vo.setFlMonth(listYunShuLiang.get(0).getFlMonth());
        vo.setFlMonthTb(listYunShuLiang.get(0).getFlMonthTb().equals("-") == true ? "-" : new BigDecimal(listYunShuLiang.get(0).getFlMonthTb()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        vo.setFlYear(listYunShuLiang.get(0).getFlYear());
        vo.setFlYearTb(listYunShuLiang.get(0).getFlYearTb().equals("-") == true ? "-" : new BigDecimal(listYunShuLiang.get(0).getFlYearTb()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        //人数
        if(listRenShu != null && listRenShu.size()>0&&listRenShu.get(0)!=null){
            vo.setPenDay(listRenShu.get(0).getPenDay());
            vo.setPenDayTb(listRenShu.get(0).getPenDayTb().equals("-") == true ? "-" : new BigDecimal(listRenShu.get(0).getPenDayTb()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            vo.setPenMonth(listRenShu.get(0).getPenMonth());
            vo.setPenMonthTb(listRenShu.get(0).getPenMonthTb().equals("-") == true ? "-" : new BigDecimal(listRenShu.get(0).getPenMonthTb()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            vo.setPenYear(listRenShu.get(0).getPenYear());
            vo.setPenYearTb(listRenShu.get(0).getPenYearTb().equals("-") == true ? "-" : new BigDecimal(listRenShu.get(0).getPenYearTb()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        }else{
            vo.setPenDay("0");
            vo.setPenDayTb("0");
            vo.setPenMonth("0");
            vo.setPenMonthTb("0");
            vo.setPenYear("0");
            vo.setPenYearTb("0");
        }
        //航班正常率、始发正常率、放行正常率
        RunQualityReportZCLVo zclDay = listZclDay.get(0);
        RunQualityReportZCLVo zclDayQn = listZclDayQn.get(0);
        RunQualityReportZCLVo zclMonth = listZclMonth.get(0);
        RunQualityReportZCLVo zclMonthQn = listZclMonthQn.get(0);
        RunQualityReportZCLVo zclYear = listZclYear.get(0);
        RunQualityReportZCLVo zclYearQn = listZclYearQn.get(0);
        if(zclDayQn == null){
            zclDayQn = new RunQualityReportZCLVo();
            zclDayQn.setFxl("0");
            zclDayQn.setSfzcl("0");
            zclDayQn.setZcl("0");
        }
        if(zclMonthQn == null){
            zclMonthQn = new RunQualityReportZCLVo();
            zclMonthQn.setFxl("0");
            zclMonthQn.setSfzcl("0");
            zclMonthQn.setZcl("0");
        }
        if(zclYearQn == null){
            zclYearQn = new RunQualityReportZCLVo();
            zclYearQn.setFxl("0");
            zclYearQn.setSfzcl("0");
            zclYearQn.setZcl("0");
        }
        //航班正常率
        vo.setZclDay(new BigDecimal(zclDay.getZcl()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        vo.setZclDayTb(((new BigDecimal(zclDay.getZcl()).subtract(new BigDecimal(zclDayQn.getZcl()))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
        vo.setZclMonth(new BigDecimal(zclMonth.getZcl()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        vo.setZclMonthTb(((new BigDecimal(zclMonth.getZcl()).subtract(new BigDecimal(zclMonthQn.getZcl()))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
        vo.setZclYear(new BigDecimal(zclYear.getZcl()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        vo.setZclYearTb(((new BigDecimal(zclYear.getZcl()).subtract(new BigDecimal(zclYearQn.getZcl()))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
        //始发正常率
        vo.setSfzclDay(new BigDecimal(zclDay.getSfzcl()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        vo.setSfzclDayTb(((new BigDecimal(zclDay.getSfzcl()).subtract(new BigDecimal(zclDayQn.getSfzcl()))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
        vo.setSfzclMonth(new BigDecimal(zclMonth.getSfzcl()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        vo.setSfzclMonthTb(((new BigDecimal(zclMonth.getSfzcl()).subtract(new BigDecimal(zclMonthQn.getSfzcl()))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
        vo.setSfzclYear(new BigDecimal(zclYear.getSfzcl()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        vo.setSfzclYearTb(((new BigDecimal(zclYear.getSfzcl()).subtract(new BigDecimal(zclYearQn.getSfzcl()))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
        //放行正常率
        vo.setFxlDay(new BigDecimal(zclDay.getFxl()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        vo.setFxlDayTb(((new BigDecimal(zclDay.getFxl()).subtract(new BigDecimal(zclDayQn.getFxl()))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
        vo.setFxlMonth(new BigDecimal(zclMonth.getFxl()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        vo.setFxlMonthTb(((new BigDecimal(zclMonth.getFxl()).subtract(new BigDecimal(zclMonthQn.getFxl()))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
        vo.setFxlYear(new BigDecimal(zclYear.getFxl()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        vo.setFxlYearTb(((new BigDecimal(zclYear.getFxl()).subtract(new BigDecimal(zclYearQn.getFxl()))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
        //延误原因统计
        vo.setDelayTq(vo.getDelayTq());
        vo.setDelayGs(vo.getDelayGs());
        vo.setDelayLl(vo.getDelayLl());
        vo.setDelayHbsk(vo.getDelayHbsk());
        vo.setDelayZshd(vo.getDelayZshd());
        vo.setDelayKg(vo.getDelayKg());
        vo.setDelayJc(vo.getDelayJc());
        vo.setDelayLj(vo.getDelayLj());
        vo.setDelayYl(vo.getDelayYl());
        vo.setDelayLgxt(vo.getDelayLgxt());
        vo.setDelayLk(vo.getDelayLk());
        vo.setDelayGgaq(vo.getDelayGgaq());
        vo.setDelayCount(vo.getDelayCount());//延误航班总数
        //靠桥率
        vo.setKql(new BigDecimal(this.findKQL(params)).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        //关门准点率
        vo.setGmzdl(new BigDecimal(listGMZDL.get(0).getGmzdl()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        //晚关门航班数
        vo.setWgmhbs(listGMZDL.get(0).getWgmhbs());
        //延误内容
        vo.setDelayContent("");
        //实际小时起降架次最高
        vo.setSjxsqjjc(this.findMaxAOrDHbs(params));
        //平均进港滑行时间
        String setPjjghxsj=this.findAvgJghxsj(params);
        vo.setPjjghxsj(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        //平均进港滑行时间
        setPjjghxsj=this.findAvgCghxsj(params);
        vo.setPjcghxsj(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        //放行正常率排名
        setPjjghxsj=this.findFxlDayGH(params);
        vo.setFxlGhDay(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        setPjjghxsj=this.findFxlMonthGH(params);
        vo.setFxlGhMonth(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        setPjjghxsj=this.findFxlDayNH(params);
        vo.setFxlNhDay(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        setPjjghxsj=this.findFxlMonthNH(params);
        vo.setFxlNhMonth(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        setPjjghxsj=this.findFxlDayDH(params);
        vo.setFxlDhDay(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        setPjjghxsj=this.findFxlMonthDH(params);
        vo.setFxlDhMonth(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        setPjjghxsj=this.findFxlDayDF(params);
        vo.setFxlDfDay(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        setPjjghxsj=this.findFxlMonthDF(params);
        vo.setFxlDfMonth(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        setPjjghxsj=this.findFxlDayHY(params);
        vo.setFxlHyDay(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        setPjjghxsj=this.findFxlMonthHY(params);
        vo.setFxlHyMonth(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        //航班正常管理提示
        vo.setFlTips("");
        listRunQualityReportVo.add(vo);
        return listRunQualityReportVo;
    }


    //机场运量统计
    public List<RunQualityReportYLTJVo> findYunLiangTJInfo(@Param("params") Map params){
        String dateStr = DateTimeUtil.dateToStr((Date)params.get("execDate"),"yyyy-MM-dd");
        String MM = dateStr.substring(5,7);
        String dd = dateStr.substring(8,10);
        if(MM.substring(0,1).equals("0")){
            MM = MM.substring(1,2);
        }
        if(dd.substring(0,1).equals("0")){
            dd = dd.substring(1,2);
        }
        String execDate = MM+"月"+dd+"日";
        List<RunQualityReportYLTJVo> listYLTJ = new ArrayList<RunQualityReportYLTJVo>();
        RunQualityReportYLTJVo yltjVo = new RunQualityReportYLTJVo();
        RunQualityReportYLTJVo rytjVo = new RunQualityReportYLTJVo();

        String execDate2 = params.get("execDate2").toString();
        String agent = params.get("agent").toString();
        if (StringUtil.isEmpty(agent))agent="ALL";
        RunQualityPDFVo pdfVo=this.selectByPDFPrimaryKey(execDate2,agent);
        //先查简报保存表，没有再从航班主表捞数据
        if (pdfVo!=null&&StringUtil.isNotEmpty(pdfVo.getExecdate())){
            yltjVo.setTitle(new String[]{"运输量(架次)"});
            yltjVo.setDayHbs(new String[]{pdfVo.getYltj1()});
            yltjVo.setDayTb(new String[]{pdfVo.getYltj2()});
            yltjVo.setMonthHbs(new String[]{pdfVo.getYltj3()});
            yltjVo.setMonthTb(new String[]{pdfVo.getYltj4()});
            yltjVo.setYearHbs(new String[]{pdfVo.getYltj5()});
            yltjVo.setYearTb(new String[]{pdfVo.getYltj6()});
            yltjVo.setExecDate(execDate);


            rytjVo.setTitle(new String[]{"人数(万)"});
            rytjVo.setDayHbs(new String[]{pdfVo.getYltj7()});
            rytjVo.setDayTb(new String[]{pdfVo.getYltj8()});
            rytjVo.setMonthHbs(new String[]{pdfVo.getYltj9()});
            rytjVo.setMonthTb(new String[]{pdfVo.getYltj10()});
            rytjVo.setYearHbs(new String[]{pdfVo.getYltj11()});
            rytjVo.setYearTb(new String[]{pdfVo.getYltj12()});
            rytjVo.setExecDate(execDate);
        }else {
            // RunQualityReportVo rqrVo = this.findRunQualityReportByDate(params).get(0);
            //机场不要首次查询，改为取排名页面保存值
            /*List<RunQualityReportVo>  listYunShuLiang  = this.findYunShuLiang(params);
            List<RunQualityReportVo>  listRenShu  = this.findRenShu(params);
            RunQualityReportVo rqrVo = new RunQualityReportVo();
            rqrVo.setExecDate(DateTimeUtil.dateToStr((Date)params.get("execDate"),"yyyy-MM-dd"));
            //运输量
            rqrVo.setFlDay(listYunShuLiang.get(0).getFlDay());
            rqrVo.setFlDayTb(listYunShuLiang.get(0).getFlDayTb().equals("-") == true ? "-" : new BigDecimal(listYunShuLiang.get(0).getFlDayTb()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            rqrVo.setFlMonth(listYunShuLiang.get(0).getFlMonth());
            rqrVo.setFlMonthTb(listYunShuLiang.get(0).getFlMonthTb().equals("-") == true ? "-" : new BigDecimal(listYunShuLiang.get(0).getFlMonthTb()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            rqrVo.setFlYear(listYunShuLiang.get(0).getFlYear());
            rqrVo.setFlYearTb(listYunShuLiang.get(0).getFlYearTb().equals("-") == true ? "-" : new BigDecimal(listYunShuLiang.get(0).getFlYearTb()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            //人数
            if(listRenShu != null && listRenShu.size()>0&&listRenShu.get(0)!=null){
                rqrVo.setPenDay(listRenShu.get(0).getPenDay());
                rqrVo.setPenDayTb(listRenShu.get(0).getPenDayTb().equals("-") == true ? "-" : new BigDecimal(listRenShu.get(0).getPenDayTb()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                rqrVo.setPenMonth(listRenShu.get(0).getPenMonth());
                rqrVo.setPenMonthTb(listRenShu.get(0).getPenMonthTb().equals("-") == true ? "-" : new BigDecimal(listRenShu.get(0).getPenMonthTb()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                rqrVo.setPenYear(listRenShu.get(0).getPenYear());
                rqrVo.setPenYearTb(listRenShu.get(0).getPenYearTb().equals("-") == true ? "-" : new BigDecimal(listRenShu.get(0).getPenYearTb()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            }else{
                rqrVo.setPenDay("0");
                rqrVo.setPenDayTb("0");
                rqrVo.setPenMonth("0");
                rqrVo.setPenMonthTb("0");
                rqrVo.setPenYear("0");
                rqrVo.setPenYearTb("0");
            }

            yltjVo.setTitle(new String[]{"运输量(架次)"});
            yltjVo.setDayHbs(new String[]{rqrVo.getFlDay()});
            yltjVo.setDayTb(new String[]{rqrVo.getFlDayTb().equals("-") == true ? rqrVo.getFlDayTb() : rqrVo.getFlDayTb()});
            yltjVo.setMonthHbs(new String[]{rqrVo.getFlMonth()});
            yltjVo.setMonthTb(new String[]{rqrVo.getFlMonthTb().equals("-") == true ? rqrVo.getFlMonthTb() : rqrVo.getFlMonthTb()});
            yltjVo.setYearHbs(new String[]{rqrVo.getFlYear()});
            yltjVo.setYearTb(new String[]{rqrVo.getFlYearTb().equals("-") == true ? rqrVo.getFlYearTb() : rqrVo.getFlYearTb()});
            yltjVo.setExecDate(execDate);

            rytjVo.setTitle(new String[]{"人数(万)"});
            rytjVo.setDayHbs(new String[]{rqrVo.getPenDay()});
            rytjVo.setDayTb(new String[]{rqrVo.getPenDayTb().equals("-") == true ? rqrVo.getPenDayTb() : rqrVo.getPenDayTb()});
            rytjVo.setMonthHbs(new String[]{rqrVo.getPenMonth()});
            rytjVo.setMonthTb(new String[]{rqrVo.getPenMonthTb().equals("-") == true ? rqrVo.getPenMonthTb() : rqrVo.getPenMonthTb()});
            rytjVo.setYearHbs(new String[]{rqrVo.getPenYear()});
            rytjVo.setYearTb(new String[]{rqrVo.getPenYearTb().equals("-") == true ? rqrVo.getPenYearTb() : rqrVo.getPenYearTb()});
            rytjVo.setExecDate(execDate);*/

            yltjVo.setTitle(new String[]{"运输量(架次)"});
            yltjVo.setDayHbs(new String[]{"-"});
            yltjVo.setDayTb(new String[]{"-"});
            yltjVo.setMonthHbs(new String[]{"-"});
            yltjVo.setMonthTb(new String[]{"-"});
            yltjVo.setYearHbs(new String[]{"-"});
            yltjVo.setYearTb(new String[]{"-"});
            yltjVo.setExecDate(execDate);

            rytjVo.setTitle(new String[]{"人数(万)"});
            rytjVo.setDayHbs(new String[]{"-"});
            rytjVo.setDayTb(new String[]{"-"});
            rytjVo.setMonthHbs(new String[]{"-"});
            rytjVo.setMonthTb(new String[]{"-"});
            rytjVo.setYearHbs(new String[]{"-"});
            rytjVo.setYearTb(new String[]{"-"});
            rytjVo.setExecDate(execDate);
            List<PaiMingQTVo>  listRANKING = runQualityReportMapper.selectZclFxlRANKINGByDay(params);
            if (listRANKING!=null&&listRANKING.size()>0&&!"HY".equals(agent)){

                try {
                 String e2 [] =  execDate2.split("-");
                    String lastday=(Integer.parseInt(e2[0])-1)+"-"+e2[1]+"-"+e2[2];
                    String lastmonth=(Integer.parseInt(e2[0])-1)+"-"+e2[1]+"-"+"01";
                    String curmonth=e2[0]+"-"+e2[1]+"-"+"01";
                    log.info("lastday:"+lastday+" lastmonth:"+lastmonth+" curmonth:"+curmonth);
                    int dayhbs=0;
                    int curdayhbs=0;
                    int monhbs=0;
                    int curmonhbs=0;
                    for (int i = 0; i <listRANKING.size() ; i++) {
                        PaiMingQTVo vo=listRANKING.get(i);

                        if (execDate2.equals(vo.getDate())&&agent.equals(vo.getAgent())){
                            yltjVo.setDayHbs(new String[]{vo.getQf_j3()+""});
                            curdayhbs=vo.getQf_j3();
                        }else if (lastday.equals(vo.getDate())&&agent.equals(vo.getAgent())){
                            dayhbs=vo.getQf_j3();
                        }else if (curmonth.equals(vo.getDate())&&(agent+"SUM").equals(vo.getAgent())){
                            yltjVo.setMonthHbs(new String[]{vo.getQf_j3()+""});
                            curmonhbs=vo.getQf_j3();
                        }else if (lastmonth.equals(vo.getDate())&&(agent+"SUM").equals(vo.getAgent())){
                            monhbs=vo.getQf_j3();
                        }else if (execDate2.equals(vo.getDate())&&"ALL".equals(agent)&&"DF".equals(vo.getAgent())){
                            yltjVo.setDayHbs(new String[]{vo.getQf_j1()+""});
                            curdayhbs=vo.getQf_j1();
                        }else if (lastday.equals(vo.getDate())&&"ALL".equals(agent)&&"DF".equals(vo.getAgent())){
                            dayhbs=vo.getQf_j1();
                        }else if (curmonth.equals(vo.getDate())&&"ALL".equals(agent)&&"DFSUM".equals(vo.getAgent())){
                            yltjVo.setMonthHbs(new String[]{vo.getQf_j1()+""});
                            curmonhbs=vo.getQf_j1();
                        }else if (lastmonth.equals(vo.getDate())&&"ALL".equals(agent)&&"DFSUM".equals(vo.getAgent())){
                            monhbs=vo.getQf_j1();
                        }
                    }
                    if (dayhbs>0&&curdayhbs>0){
                        int chad=Math.abs(dayhbs-curdayhbs);
                        String tb=new BigDecimal(chad).divide(new BigDecimal(dayhbs),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString();
                        yltjVo.setDayTb(new String[]{tb});
                        if (curdayhbs<dayhbs)yltjVo.setDayTb(new String[]{"-"+tb});
                    }
                    if (monhbs>0&&curmonhbs>0){
                        int chad=Math.abs(monhbs-curmonhbs);
                        String tb=new BigDecimal(chad).divide(new BigDecimal(monhbs),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString();
                        yltjVo.setMonthTb(new String[]{tb});
                        if (curmonhbs<monhbs)yltjVo.setMonthTb(new String[]{"-"+tb});
                    }
                }catch (Exception e){

                }

            }

        }



        listYLTJ.add(yltjVo);
        listYLTJ.add(rytjVo);
        return listYLTJ;
    }


    //航班正常性统计
    public List<RunQualityReportYLTJVo> findHBZCXTJInfo(@Param("params") Map params){
        String dateStr = DateTimeUtil.dateToStr((Date)params.get("execDate"),"yyyy-MM-dd");
        String MM = dateStr.substring(5,7);
        String dd = dateStr.substring(8,10);
        if(MM.substring(0,1).equals("0")){
            MM = MM.substring(1,2);
        }
        if(dd.substring(0,1).equals("0")){
            dd = dd.substring(1,2);
        }
        String execDate = MM+"月"+dd+"日";
        List<RunQualityReportYLTJVo> listZCLTJ = new ArrayList<RunQualityReportYLTJVo>();
        RunQualityReportYLTJVo fxlVo = new RunQualityReportYLTJVo();
        RunQualityReportYLTJVo sfzclVo = new RunQualityReportYLTJVo();
        RunQualityReportYLTJVo zclVo = new RunQualityReportYLTJVo();

        String execDate2 = params.get("execDate2").toString();
        String agent = params.get("agent").toString();
        if (StringUtil.isEmpty(agent))agent="ALL";
        RunQualityPDFVo pdfVo=this.selectByPDFPrimaryKey(execDate2,agent);
        //先查简报保存表，没有再从航班主表捞数据
        if (pdfVo!=null&&StringUtil.isNotEmpty(pdfVo.getExecdate())){
            fxlVo.setTitle(new String[]{"加权平均值"});
            fxlVo.setDayHbs(new String[]{pdfVo.getHbzcxtj1()});
            fxlVo.setDayTb(new String[]{pdfVo.getHbzcxtj2()});
            fxlVo.setMonthHbs(new String[]{pdfVo.getHbzcxtj3()});
            fxlVo.setMonthTb(new String[]{pdfVo.getHbzcxtj4()});
            fxlVo.setYearHbs(new String[]{pdfVo.getHbzcxtj5()});
            fxlVo.setYearTb(new String[]{pdfVo.getHbzcxtj6()});
            fxlVo.setExecDate(execDate);


            sfzclVo.setTitle(new String[]{"始发正常率"});
            sfzclVo.setDayHbs(new String[]{pdfVo.getHbzcxtj7()});
            sfzclVo.setDayTb(new String[]{pdfVo.getHbzcxtj8()});
            sfzclVo.setMonthHbs(new String[]{pdfVo.getHbzcxtj9()});
            sfzclVo.setMonthTb(new String[]{pdfVo.getHbzcxtj10()});
            sfzclVo.setYearHbs(new String[]{pdfVo.getHbzcxtj11()});
            sfzclVo.setYearTb(new String[]{pdfVo.getHbzcxtj12()});
            sfzclVo.setExecDate(execDate);


            zclVo.setTitle(new String[]{"航班正常率"});
            zclVo.setDayHbs(new String[]{pdfVo.getHbzcxtj13()});
            zclVo.setDayTb(new String[]{pdfVo.getHbzcxtj14()});
            zclVo.setMonthHbs(new String[]{pdfVo.getHbzcxtj15()});
            zclVo.setMonthTb(new String[]{pdfVo.getHbzcxtj16()});
            zclVo.setYearHbs(new String[]{pdfVo.getHbzcxtj17()});
            zclVo.setYearTb(new String[]{pdfVo.getHbzcxtj18()});
            zclVo.setExecDate(execDate);
        }else {
            /*
            RunQualityReportVo rqrVo = this.findRunQualityReportByDate(params).get(0);
            RunQualityReportYLTJVo fxlVo = new RunQualityReportYLTJVo();
            fxlVo.setTitle(new String[]{"放行正常率"});
            fxlVo.setDayHbs(new String[]{rqrVo.getFxlDay()+"%"});
            fxlVo.setDayTb(new String[]{rqrVo.getFxlDayTb()+"%"});
            fxlVo.setMonthHbs(new String[]{rqrVo.getFxlMonth()+"%"});
            fxlVo.setMonthTb(new String[]{rqrVo.getFxlMonthTb()+"%"});
            fxlVo.setYearHbs(new String[]{rqrVo.getFxlYear()+"%"});
            fxlVo.setYearTb(new String[]{rqrVo.getFxlYearTb()+"%"});
            fxlVo.setExecDate(execDate);

            RunQualityReportYLTJVo sfzclVo = new RunQualityReportYLTJVo();
            sfzclVo.setTitle(new String[]{"始发正常率"});
            sfzclVo.setDayHbs(new String[]{rqrVo.getSfzclDay()+"%"});
            sfzclVo.setDayTb(new String[]{rqrVo.getSfzclDayTb()+"%"});
            sfzclVo.setMonthHbs(new String[]{rqrVo.getSfzclMonth()+"%"});
            sfzclVo.setMonthTb(new String[]{rqrVo.getSfzclMonthTb()+"%"});
            sfzclVo.setYearHbs(new String[]{rqrVo.getSfzclYear()+"%"});
            sfzclVo.setYearTb(new String[]{rqrVo.getSfzclYearTb()+"%"});
            sfzclVo.setExecDate(execDate);

            RunQualityReportYLTJVo zclVo = new RunQualityReportYLTJVo();
            zclVo.setTitle(new String[]{"航班正常率"});
            zclVo.setDayHbs(new String[]{rqrVo.getZclDay()+"%"});
            zclVo.setDayTb(new String[]{rqrVo.getZclDayTb()+"%"});
            zclVo.setMonthHbs(new String[]{rqrVo.getZclMonth()+"%"});
            zclVo.setMonthTb(new String[]{rqrVo.getZclMonthTb()+"%"});
            zclVo.setYearHbs(new String[]{rqrVo.getZclYear()+"%"});
            zclVo.setYearTb(new String[]{rqrVo.getZclYearTb()+"%"});
            zclVo.setExecDate(execDate);
            */

            //机场不要首次查询，改为取排名页面保存值
            //放行率
            /*String fxlDay = this.selectFXLDay(params);
            String fxlMonth = this.selectFXLMonth(params);
            String fxlYear = this.selectFXLYear(params);
            String val="0";
            val=this.selectFXLDayQn(params);
            String fxlDayQn = val.equals("1.0000") ? "0" : val;
            val=this.selectFXLMonthQn(params);
            String fxlMonthQn = val.equals("1.0000") ? "0" : val;
            val=this.selectFXLYearQn(params);
            String fxlYearQn = val.equals("1.0000") ? "0" : val;
            //始发正常率
            String sfZclDay = this.selectSFZCLDay(params);
            String sfZclMonth = this.selectSFZCLMonth(params);
            String sfZclYear = this.selectSFZCLYear(params);
            val=this.selectSFZCLDayQn(params);
            String sfZclDayQn = val.equals("1.0000") ? "0" : val;
            val=this.selectSFZCLMonthQn(params);
            String sfZclMonthQn = val.equals("1.0000") ? "0" : val;
            val=this.selectSFZCLYearQn(params);
            String sfZclYearQn = val.equals("1.0000") ? "0" : val;
            //正常率
            String zclDay = this.selectZCLDay(params);
            String zclMonth = this.selectZCLMonth(params);
            String zclYear = this.selectZCLYear(params);
            val=this.selectZCLDayQn(params);
            String zclDayQn = val.equals("1.0000") ? "0" : val;
            val=this.selectZCLMonthQn(params);
            String zclMonthQn = val.equals("1.0000") ? "0" : val;
            val=this.selectZCLYearQn(params);
            String zclYearQn = val.equals("1.0000") ? "0" : val;



            fxlVo.setTitle(new String[]{"加权平均值"});
            fxlVo.setDayHbs(new String[]{new BigDecimal(fxlDay).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            fxlVo.setDayTb(new String[]{(new BigDecimal(fxlDay).subtract(new BigDecimal(fxlDayQn))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            fxlVo.setMonthHbs(new String[]{new BigDecimal(fxlMonth).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            fxlVo.setMonthTb(new String[]{(new BigDecimal(fxlMonth).subtract(new BigDecimal(fxlMonthQn))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            fxlVo.setYearHbs(new String[]{new BigDecimal(fxlYear).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            fxlVo.setYearTb(new String[]{(new BigDecimal(fxlYear).subtract(new BigDecimal(fxlYearQn))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            fxlVo.setExecDate(execDate);


            sfzclVo.setTitle(new String[]{"始发正常率"});
            sfzclVo.setDayHbs(new String[]{new BigDecimal(sfZclDay).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            sfzclVo.setDayTb(new String[]{(new BigDecimal(sfZclDay).subtract(new BigDecimal(sfZclDayQn))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            sfzclVo.setMonthHbs(new String[]{new BigDecimal(sfZclMonth).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            sfzclVo.setMonthTb(new String[]{(new BigDecimal(sfZclMonth).subtract(new BigDecimal(sfZclMonthQn))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            sfzclVo.setYearHbs(new String[]{new BigDecimal(sfZclYear).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            sfzclVo.setYearTb(new String[]{(new BigDecimal(sfZclYear).subtract(new BigDecimal(sfZclYearQn))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            sfzclVo.setExecDate(execDate);


            zclVo.setTitle(new String[]{"航班正常率"});
            zclVo.setDayHbs(new String[]{new BigDecimal(zclDay).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            zclVo.setDayTb(new String[]{(new BigDecimal(zclDay).subtract(new BigDecimal(zclDayQn))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            zclVo.setMonthHbs(new String[]{new BigDecimal(zclMonth).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            zclVo.setMonthTb(new String[]{(new BigDecimal(zclMonth).subtract(new BigDecimal(zclMonthQn))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            zclVo.setYearHbs(new String[]{new BigDecimal(zclYear).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            zclVo.setYearTb(new String[]{(new BigDecimal(zclYear).subtract(new BigDecimal(zclYearQn))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)+""});
            zclVo.setExecDate(execDate);*/


            fxlVo.setTitle(new String[]{"加权平均值"});
            fxlVo.setDayHbs(new String[]{"-"});
            fxlVo.setDayTb(new String[]{"-"});
            fxlVo.setMonthHbs(new String[]{"-"});
            fxlVo.setMonthTb(new String[]{"-"});
            fxlVo.setYearHbs(new String[]{"-"});
            fxlVo.setYearTb(new String[]{"-"});
            fxlVo.setExecDate(execDate);


            sfzclVo.setTitle(new String[]{"始发正常率"});
            sfzclVo.setDayHbs(new String[]{"-"});
            sfzclVo.setDayTb(new String[]{"-"});
            sfzclVo.setMonthHbs(new String[]{"-"});
            sfzclVo.setMonthTb(new String[]{"-"});
            sfzclVo.setYearHbs(new String[]{"-"});
            sfzclVo.setYearTb(new String[]{"-"});
            sfzclVo.setExecDate(execDate);


            zclVo.setTitle(new String[]{"航班正常率"});
            zclVo.setDayHbs(new String[]{"-"});
            zclVo.setDayTb(new String[]{"-"});
            zclVo.setMonthHbs(new String[]{"-"});
            zclVo.setMonthTb(new String[]{"-"});
            zclVo.setYearHbs(new String[]{"-"});
            zclVo.setYearTb(new String[]{"-"});
            zclVo.setExecDate(execDate);

            List<PaiMingQTVo>  listRANKING = runQualityReportMapper.selectZclFxlRANKINGByDay(params);
            if (listRANKING!=null&&listRANKING.size()>0&&!"HY".equals(agent)){

                try {
                    String e2 [] =  execDate2.split("-");
                    String lastday=(Integer.parseInt(e2[0])-1)+"-"+e2[1]+"-"+e2[2];
                    String lastmonth=(Integer.parseInt(e2[0])-1)+"-"+e2[1]+"-"+"01";
                    String curmonth=e2[0]+"-"+e2[1]+"-"+"01";
                    log.info("lastday:"+lastday+" lastmonth:"+lastmonth+" curmonth:"+curmonth);
                    String sfzclDayhbs=null;
                    String sfzclCurdayhbs=null;
                    String sfzclMonhbs=null;
                    String sfzclCurmonhbs=null;

                    String zclDayhbs=null;
                    String zclCurdayhbs=null;
                    String zclMonhbs=null;
                    String zclCurmonhbs=null;

                    String fxlDayhbs=null;
                    String fxlCurdayhbs=null;
                    String fxlMonhbs=null;
                    String fxlCurmonhbs=null;
                    for (int i = 0; i <listRANKING.size() ; i++) {
                        PaiMingQTVo vo=listRANKING.get(i);


                        if (execDate2.equals(vo.getDate())&&agent.equals(vo.getAgent())){
                            sfzclVo.setDayHbs(new String[]{vo.getQf_b3()+""});
                            sfzclCurdayhbs=vo.getQf_b3();
                            zclVo.setDayHbs(new String[]{vo.getFx_b3()+""});
                            zclCurdayhbs=vo.getFx_b3();
                            fxlVo.setDayHbs(new String[]{vo.getJq3()+""});
                            fxlCurdayhbs=vo.getJq3();
                        }else if (lastday.equals(vo.getDate())&&agent.equals(vo.getAgent())){
                            sfzclDayhbs=vo.getQf_b3();
                            zclDayhbs=vo.getFx_b3();
                            fxlDayhbs=vo.getJq3();
                        }else if (curmonth.equals(vo.getDate())&&(agent+"SUM").equals(vo.getAgent())){
                            sfzclVo.setMonthHbs(new String[]{vo.getQf_b3()+""});
                            sfzclCurmonhbs=vo.getQf_b3();
                            zclVo.setMonthHbs(new String[]{vo.getFx_b3()+""});
                            zclCurmonhbs=vo.getFx_b3();
                            fxlVo.setMonthHbs(new String[]{vo.getJq3()+""});
                            fxlCurmonhbs=vo.getJq3();
                        }else if (lastmonth.equals(vo.getDate())&&(agent+"SUM").equals(vo.getAgent())){
                            sfzclMonhbs=vo.getQf_b3();
                            zclMonhbs=vo.getFx_b3();
                            fxlMonhbs=vo.getJq3();
                        }else if (execDate2.equals(vo.getDate())&&"ALL".equals(agent)&&"DF".equals(vo.getAgent())){
                            sfzclVo.setDayHbs(new String[]{vo.getQf_b1()+""});
                            sfzclCurdayhbs=vo.getQf_b1();
                            zclVo.setDayHbs(new String[]{vo.getFx_b1()+""});
                            zclCurdayhbs=vo.getFx_b1();
                            fxlVo.setDayHbs(new String[]{vo.getJq1()+""});
                            fxlCurdayhbs=vo.getJq1();
                        }else if (lastday.equals(vo.getDate())&&"ALL".equals(agent)&&"DF".equals(vo.getAgent())){
                            sfzclDayhbs=vo.getQf_b1();
                            zclDayhbs=vo.getFx_b1();
                            fxlDayhbs=vo.getJq1();
                        }else if (curmonth.equals(vo.getDate())&&"ALL".equals(agent)&&"DFSUM".equals(vo.getAgent())){
                            sfzclVo.setMonthHbs(new String[]{vo.getQf_b1()+""});
                            sfzclCurmonhbs=vo.getQf_b1();
                            zclVo.setMonthHbs(new String[]{vo.getFx_b1()+""});
                            zclCurmonhbs=vo.getFx_b1();
                            fxlVo.setMonthHbs(new String[]{vo.getJq1()+""});
                            fxlCurmonhbs=vo.getJq1();
                        }else if (lastmonth.equals(vo.getDate())&&"ALL".equals(agent)&&"DFSUM".equals(vo.getAgent())){
                            sfzclMonhbs=vo.getQf_b1();
                            zclMonhbs=vo.getFx_b1();
                            fxlMonhbs=vo.getJq1();
                        }
                    }
                    if (sfzclCurdayhbs!=null&&sfzclDayhbs!=null){
                        BigDecimal a=(new BigDecimal(sfzclCurdayhbs).subtract(new BigDecimal(sfzclDayhbs)));
                        sfzclVo.setDayTb(new String[]{a.toString()});
                    }
                    if (sfzclCurmonhbs!=null&&sfzclMonhbs!=null){
                        BigDecimal a=(new BigDecimal(sfzclCurmonhbs).subtract(new BigDecimal(sfzclMonhbs)));
                        sfzclVo.setMonthTb(new String[]{a.toString()});
                    }

                    if (zclCurdayhbs!=null&&zclDayhbs!=null){
                        BigDecimal a=(new BigDecimal(zclCurdayhbs).subtract(new BigDecimal(zclDayhbs)));
                        zclVo.setDayTb(new String[]{a.toString()});
                    }
                    if (zclCurmonhbs!=null&&zclMonhbs!=null){
                        BigDecimal a=(new BigDecimal(zclCurmonhbs).subtract(new BigDecimal(zclMonhbs)));
                        zclVo.setMonthTb(new String[]{a.toString()});
                    }

                    if (fxlCurdayhbs!=null&&fxlDayhbs!=null){
                        BigDecimal a=(new BigDecimal(fxlCurdayhbs).subtract(new BigDecimal(fxlDayhbs)));
                        fxlVo.setDayTb(new String[]{a.toString()});
                    }
                    if (fxlCurmonhbs!=null&&fxlMonhbs!=null){
                        BigDecimal a=(new BigDecimal(fxlCurmonhbs).subtract(new BigDecimal(fxlMonhbs)));
                        fxlVo.setMonthTb(new String[]{a.toString()});
                    }
                }catch (Exception e){
                    log.info("tj:"+e);
                }

            }
        }



        listZCLTJ.add(fxlVo);
        listZCLTJ.add(sfzclVo);
        listZCLTJ.add(zclVo);
        return listZCLTJ;
    }

    //延误原因统计
    public List<RunQualityReportYWYYVo> findYWYYTJInfo(@Param("params") Map params){
        List<RunQualityReportYWYYVo> list = new ArrayList<RunQualityReportYWYYVo>();
        RunQualityReportYWYYVo vo = new RunQualityReportYWYYVo();

        String execDate = params.get("execDate2").toString();
        String agent = params.get("agent").toString();
        if (StringUtil.isEmpty(agent))agent="ALL";
        RunQualityPDFVo pdfVo=this.selectByPDFPrimaryKey(execDate,agent);
        //先查简报保存表，没有再从航班主表捞数据
        if (pdfVo!=null&&StringUtil.isNotEmpty(pdfVo.getExecdate())){

            try {
                vo.setDelayTq(new int[]{Integer.parseInt(pdfVo.getYwyy0())});
                vo.setDelayGs(new int[]{Integer.parseInt(pdfVo.getYwyy1())});
                vo.setDelayLl(new int[]{Integer.parseInt(pdfVo.getYwyy2())});
                vo.setDelayHbsk(new int[]{Integer.parseInt(pdfVo.getYwyy3())});
                vo.setDelayZshd(new int[]{Integer.parseInt(pdfVo.getYwyy4())});
                vo.setDelayKg(new int[]{Integer.parseInt(pdfVo.getYwyy5())});
                vo.setDelayJc(new int[]{Integer.parseInt(pdfVo.getYwyy6())});
                vo.setDelayLj(new int[]{Integer.parseInt(pdfVo.getYwyy7())});
                vo.setDelayYl(new int[]{Integer.parseInt(pdfVo.getYwyy8())});
                vo.setDelayLgxt(new int[]{Integer.parseInt(pdfVo.getYwyy9())});
                vo.setDelayLk(new int[]{Integer.parseInt(pdfVo.getYwyy10())});
                vo.setDelayGgaq(new int[]{Integer.parseInt(pdfVo.getYwyy11())});
                vo.setDelayCount(Integer.parseInt(pdfVo.getYwyy12()));
            }catch (Exception e){

            }

        }else {
            List<RunQualityReportVo> rqrVoList = runQualityReportMapper.findYWYYTJInfo(params);

            vo.setDelayTq(new int[]{new BigDecimal(rqrVoList.get(0).getDelayTq()).intValue()});
            vo.setDelayGs(new int[]{new BigDecimal(rqrVoList.get(0).getDelayGs()).intValue()});
            vo.setDelayLl(new int[]{new BigDecimal(rqrVoList.get(0).getDelayLl()).intValue()});
            vo.setDelayHbsk(new int[]{new BigDecimal(rqrVoList.get(0).getDelayHbsk()).intValue()});
            vo.setDelayZshd(new int[]{new BigDecimal(rqrVoList.get(0).getDelayZshd()).intValue()});
            vo.setDelayKg(new int[]{new BigDecimal(rqrVoList.get(0).getDelayKg()).intValue()});
            vo.setDelayJc(new int[]{new BigDecimal(rqrVoList.get(0).getDelayJc()).intValue()});
            vo.setDelayLj(new int[]{new BigDecimal(rqrVoList.get(0).getDelayLj()).intValue()});
            vo.setDelayYl(new int[]{new BigDecimal(rqrVoList.get(0).getDelayYl()).intValue()});
            vo.setDelayLgxt(new int[]{new BigDecimal(rqrVoList.get(0).getDelayLgxt()).intValue()});
            vo.setDelayLk(new int[]{new BigDecimal(rqrVoList.get(0).getDelayLk()).intValue()});
            vo.setDelayGgaq(new int[]{new BigDecimal(rqrVoList.get(0).getDelayGgaq()).intValue()});
            vo.setDelayCount(new BigDecimal(rqrVoList.get(0).getDelayTq()).add(new BigDecimal(rqrVoList.get(0).getDelayGs()))
                    .add(new BigDecimal(rqrVoList.get(0).getDelayLl())).add(new BigDecimal(rqrVoList.get(0).getDelayHbsk()))
                    .add(new BigDecimal(rqrVoList.get(0).getDelayZshd())).add(new BigDecimal(rqrVoList.get(0).getDelayKg()))
                    .add(new BigDecimal(rqrVoList.get(0).getDelayJc())).add(new BigDecimal(rqrVoList.get(0).getDelayLj()))
                    .add(new BigDecimal(rqrVoList.get(0).getDelayYl())).add(new BigDecimal(rqrVoList.get(0).getDelayLgxt()))
                    .add(new BigDecimal(rqrVoList.get(0).getDelayLk())).add(new BigDecimal(rqrVoList.get(0).getDelayGgaq())).intValue());
        }

        list.add(vo);
        return list;
    }

    //运行品质简报航班进程质量管控
    public List<RunQualityReportJCZLJGVo> findHBJCZLJGInfo(@Param("params") Map params){
        String dateStr = DateTimeUtil.dateToStr((Date)params.get("execDate"),"yyyy-MM-dd");
        String MM = dateStr.substring(5,7);
        String dd = dateStr.substring(8,10);
        if(MM.substring(0,1).equals("0")){
            MM = MM.substring(1,2);
        }
        if(dd.substring(0,1).equals("0")){
            dd = dd.substring(1,2);
        }
        String execDate = MM+"月"+dd+"日";
        List<RunQualityReportJCZLJGVo> list = new ArrayList<RunQualityReportJCZLJGVo>();

        String execDate2 = params.get("execDate2").toString();
        String agent = params.get("agent").toString();
        if (StringUtil.isEmpty(agent))agent="ALL";
        RunQualityPDFVo pdfVo=this.selectByPDFPrimaryKey(execDate2,agent);
        //先查简报保存表，没有再从航班主表捞数据
        if (pdfVo!=null&&StringUtil.isNotEmpty(pdfVo.getExecdate())){
            RunQualityReportJCZLJGVo jgKqlVo = new RunQualityReportJCZLJGVo();
            jgKqlVo.setTitle(new String[]{"航班靠桥率"});
            jgKqlVo.setInfo(new String[]{pdfVo.getJczljg1()});
            jgKqlVo.setExecDate(execDate);
            list.add(jgKqlVo);
            RunQualityReportJCZLJGVo jgGmzdlVo = new RunQualityReportJCZLJGVo();
            jgGmzdlVo.setTitle(new String[]{"关门准点率"});
            jgGmzdlVo.setInfo(new String[]{pdfVo.getJczljg2()});
            jgGmzdlVo.setExecDate(execDate);
            list.add(jgGmzdlVo);
            RunQualityReportJCZLJGVo jgWgmhbVo = new RunQualityReportJCZLJGVo();
            jgWgmhbVo.setTitle(new String[]{"晚关舱门航班"});
            jgWgmhbVo.setInfo(new String[]{pdfVo.getJczljg3()});
            jgWgmhbVo.setExecDate(execDate);
            list.add(jgWgmhbVo);
            RunQualityReportJCZLJGVo jgYwyyVo = new RunQualityReportJCZLJGVo();
            jgYwyyVo.setTitle(new String[]{pdfVo.getJczljg4()});
            jgYwyyVo.setInfo(new String[]{pdfVo.getJczljg4()});
            jgYwyyVo.setExecDate(execDate);
            list.add(jgYwyyVo);
            RunQualityReportJCZLJGVo jgSjxsqjjcVo = new RunQualityReportJCZLJGVo();
            jgSjxsqjjcVo.setTitle(new String[]{"实际小时起降架次"});
            jgSjxsqjjcVo.setInfo(new String[]{pdfVo.getJczljg5()});
            jgSjxsqjjcVo.setExecDate(execDate);
            list.add(jgSjxsqjjcVo);
            RunQualityReportJCZLJGVo jgPjjghxsjVo = new RunQualityReportJCZLJGVo();
            jgPjjghxsjVo.setTitle(new String[]{"平均进港滑行时间"});
            jgPjjghxsjVo.setInfo(new String[]{pdfVo.getJczljg6()});
            list.add(jgPjjghxsjVo);
            RunQualityReportJCZLJGVo jgPjcghxsjVo = new RunQualityReportJCZLJGVo();
            jgPjcghxsjVo.setTitle(new String[]{"平均出港滑行时间"});
            jgPjcghxsjVo.setInfo(new String[]{pdfVo.getJczljg7()});
            jgPjcghxsjVo.setExecDate(execDate);
            list.add(jgPjcghxsjVo);
        }else {
            //RunQualityReportVo rqrVo = this.findRunQualityReportByDate(params).get(0);

            List<RunQualityReportVo>  listGMZDL  = this.findGMZDL(params);
            RunQualityReportVo rqrVo = new RunQualityReportVo();
            rqrVo.setExecDate(DateTimeUtil.dateToStr((Date)params.get("execDate"),"yyyy-MM-dd"));
            //靠桥率
            rqrVo.setKql(new BigDecimal(this.findKQL(params)).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            //关门准点率
            rqrVo.setGmzdl(new BigDecimal(listGMZDL.get(0).getGmzdl()).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            //晚关门航班数
            rqrVo.setWgmhbs(listGMZDL.get(0).getWgmhbs());
            //延误内容
            rqrVo.setDelayContent("");
            //实际小时起降架次最高
            rqrVo.setSjxsqjjc(this.findMaxAOrDHbs(params));
            //平均进港滑行时间
            String setPjjghxsj=this.findAvgJghxsj(params);
            rqrVo.setPjjghxsj(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            //平均进港滑行时间
            setPjjghxsj=this.findAvgCghxsj(params);
            rqrVo.setPjcghxsj(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").setScale(2, BigDecimal.ROUND_HALF_UP).toString());

            RunQualityReportJCZLJGVo jgKqlVo = new RunQualityReportJCZLJGVo();
            jgKqlVo.setTitle(new String[]{"航班靠桥率"});
            jgKqlVo.setInfo(new String[]{rqrVo.getKql()+"%"});
            jgKqlVo.setExecDate(execDate);
            list.add(jgKqlVo);
            RunQualityReportJCZLJGVo jgGmzdlVo = new RunQualityReportJCZLJGVo();
            jgGmzdlVo.setTitle(new String[]{"关门准点率"});
            jgGmzdlVo.setInfo(new String[]{rqrVo.getGmzdl()+"%"});
            jgGmzdlVo.setExecDate(execDate);
            list.add(jgGmzdlVo);
            RunQualityReportJCZLJGVo jgWgmhbVo = new RunQualityReportJCZLJGVo();
            jgWgmhbVo.setTitle(new String[]{"晚关舱门航班"});
            jgWgmhbVo.setInfo(new String[]{rqrVo.getWgmhbs()+"班"});
            jgWgmhbVo.setExecDate(execDate);
            list.add(jgWgmhbVo);
            RunQualityReportJCZLJGVo jgYwyyVo = new RunQualityReportJCZLJGVo();
            jgYwyyVo.setTitle(new String[]{rqrVo.getDelayContent()});
            jgYwyyVo.setInfo(new String[]{""});
            jgYwyyVo.setExecDate(execDate);
            list.add(jgYwyyVo);
            RunQualityReportJCZLJGVo jgSjxsqjjcVo = new RunQualityReportJCZLJGVo();
            jgSjxsqjjcVo.setTitle(new String[]{"实际小时起降架次"});
            jgSjxsqjjcVo.setInfo(new String[]{rqrVo.getSjxsqjjc()+"(最高)"});
            jgSjxsqjjcVo.setExecDate(execDate);
            list.add(jgSjxsqjjcVo);
            RunQualityReportJCZLJGVo jgPjjghxsjVo = new RunQualityReportJCZLJGVo();
            jgPjjghxsjVo.setTitle(new String[]{"平均进港滑行时间"});
            jgPjjghxsjVo.setInfo(new String[]{rqrVo.getPjjghxsj()+"分钟"});
            list.add(jgPjjghxsjVo);
            RunQualityReportJCZLJGVo jgPjcghxsjVo = new RunQualityReportJCZLJGVo();
            jgPjcghxsjVo.setTitle(new String[]{"平均出港滑行时间"});
            jgPjcghxsjVo.setInfo(new String[]{rqrVo.getPjcghxsj()+"分钟"});
            jgPjcghxsjVo.setExecDate(execDate);
            list.add(jgPjcghxsjVo);
        }


        return list;
    }

    //放行正常率排名
    public List<RunQualityReportFXZCLPMVo> findFXZCLPMInfo(@Param("params") Map params){
        String dateStr = DateTimeUtil.dateToStr((Date)params.get("execDate"),"yyyy-MM-dd");
        String MM = dateStr.substring(5,7);
        String dd = dateStr.substring(8,10);
        if(MM.substring(0,1).equals("0")){
            MM = MM.substring(1,2);
        }
        if(dd.substring(0,1).equals("0")){
            dd = dd.substring(1,2);
        }
        String execDate = MM+"月"+dd+"日";
        List<RunQualityReportFXZCLPMVo> list = new ArrayList<RunQualityReportFXZCLPMVo>();

        String execDate2 = params.get("execDate2").toString();
        String agent = params.get("agent").toString();
        if (StringUtil.isEmpty(agent))agent="ALL";
        RunQualityPDFVo pdfVo=this.selectByPDFPrimaryKey(execDate2,agent);
        //先查简报保存表，没有再从航班主表捞数据
        if (pdfVo!=null&&StringUtil.isNotEmpty(pdfVo.getExecdate())){
            RunQualityReportFXZCLPMVo dayFxlVo = new RunQualityReportFXZCLPMVo();
            dayFxlVo.setExceDate(new String[]{execDate});
            dayFxlVo.setFxlGH(new String[]{pdfVo.getFxzclpm1()});
            dayFxlVo.setFxlNH(new String[]{pdfVo.getFxzclpm2()});
            dayFxlVo.setFxlDH(new String[]{pdfVo.getFxzclpm3()});
            dayFxlVo.setFxlDF(new String[]{pdfVo.getFxzclpm4()});
            dayFxlVo.setFxlHY(new String[]{pdfVo.getFxzclpm5()});
            list.add(dayFxlVo);

            RunQualityReportFXZCLPMVo monthFxlVo = new RunQualityReportFXZCLPMVo();
            monthFxlVo.setExceDate(new String[]{"月度累计"});
            monthFxlVo.setFxlGH(new String[]{pdfVo.getFxzclpm7()});
            monthFxlVo.setFxlNH(new String[]{pdfVo.getFxzclpm8()});
            monthFxlVo.setFxlDH(new String[]{pdfVo.getFxzclpm9()});
            monthFxlVo.setFxlDF(new String[]{pdfVo.getFxzclpm10()});
            monthFxlVo.setFxlHY(new String[]{pdfVo.getFxzclpm11()});
            list.add(monthFxlVo);
        }else {
            //RunQualityReportVo rqrVo = this.findRunQualityReportByDate(params).get(0);
            RunQualityReportVo rqrVo = new RunQualityReportVo();
            rqrVo.setExecDate(DateTimeUtil.dateToStr((Date)params.get("execDate"),"yyyy-MM-dd"));
            //String setPjjghxsj=this.findAvgJghxsj(params);
            //rqrVo.setPjjghxsj(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            //平均进港滑行时间
            //setPjjghxsj=this.findAvgCghxsj(params);
            //rqrVo.setPjcghxsj(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            //放行正常率排名
            /*String setPjjghxsj=this.findFxlDayGH(params);
            rqrVo.setFxlGhDay(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            setPjjghxsj=this.findFxlMonthGH(params);
            rqrVo.setFxlGhMonth(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            setPjjghxsj=this.findFxlDayNH(params);
            rqrVo.setFxlNhDay(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            setPjjghxsj=this.findFxlMonthNH(params);
            rqrVo.setFxlNhMonth(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            setPjjghxsj=this.findFxlDayDH(params);
            rqrVo.setFxlDhDay(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            setPjjghxsj=this.findFxlMonthDH(params);
            rqrVo.setFxlDhMonth(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            setPjjghxsj=this.findFxlDayDF(params);
            rqrVo.setFxlDfDay(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            setPjjghxsj=this.findFxlMonthDF(params);
            rqrVo.setFxlDfMonth(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            setPjjghxsj=this.findFxlDayHY(params);
            rqrVo.setFxlHyDay(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            setPjjghxsj=this.findFxlMonthHY(params);
            rqrVo.setFxlHyMonth(new BigDecimal(setPjjghxsj!=null?setPjjghxsj:"0").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());

            RunQualityReportFXZCLPMVo dayFxlVo = new RunQualityReportFXZCLPMVo();
            dayFxlVo.setExceDate(new String[]{execDate});
            dayFxlVo.setFxlGH(new String[]{rqrVo.getFxlGhDay()+"%"});
            dayFxlVo.setFxlNH(new String[]{rqrVo.getFxlNhDay()+"%"});
            dayFxlVo.setFxlDH(new String[]{rqrVo.getFxlDhDay()+"%"});
            dayFxlVo.setFxlDF(new String[]{rqrVo.getFxlDfDay()+"%"});
            dayFxlVo.setFxlHY(new String[]{rqrVo.getFxlHyDay()+"%"});
            //list.add(dayFxlVo);

            RunQualityReportFXZCLPMVo monthFxlVo = new RunQualityReportFXZCLPMVo();
            monthFxlVo.setExceDate(new String[]{"月度累计"});
            monthFxlVo.setFxlGH(new String[]{rqrVo.getFxlGhMonth()+"%"});
            monthFxlVo.setFxlNH(new String[]{rqrVo.getFxlNhMonth()+"%"});
            monthFxlVo.setFxlDH(new String[]{rqrVo.getFxlDhMonth()+"%"});
            monthFxlVo.setFxlDF(new String[]{rqrVo.getFxlDfMonth()+"%"});
            monthFxlVo.setFxlHY(new String[]{rqrVo.getFxlHyMonth()+"%"});*/


            RunQualityReportFXZCLPMVo dayFxlVo = new RunQualityReportFXZCLPMVo();
            dayFxlVo.setExceDate(new String[]{execDate});

            dayFxlVo.setFxlGH(new String[]{"-"});
            dayFxlVo.setFxlNH(new String[]{"-"});
            dayFxlVo.setFxlDH(new String[]{"-"});
            dayFxlVo.setFxlDF(new String[]{"-"});
            dayFxlVo.setFxlHY(new String[]{"-"});

            RunQualityReportFXZCLPMVo monthFxlVo = new RunQualityReportFXZCLPMVo();
            monthFxlVo.setExceDate(new String[]{"月度累计"});
            monthFxlVo.setFxlGH(new String[]{"-"});
            monthFxlVo.setFxlNH(new String[]{"-"});
            monthFxlVo.setFxlDH(new String[]{"-"});
            monthFxlVo.setFxlDF(new String[]{"-"});
            monthFxlVo.setFxlHY(new String[]{"-"});

            List<PaiMingQTVo>  listRANKING = runQualityReportMapper.selectZclFxlRANKINGByDay(params);
            if (listRANKING!=null&&listRANKING.size()>0){

                try {
                    String e2 [] =  execDate2.split("-");

                    String curmonth=e2[0]+"-"+e2[1]+"-"+"01";
                    log.info("execDate2:"+execDate2+" curmonth:"+curmonth);

                    String fxlDayhbs=null;

                    String fxlMonhbs=null;

                    for (int i = 0; i <listRANKING.size() ; i++) {
                        PaiMingQTVo vo=listRANKING.get(i);


                        if (vo!=null&&execDate2.equals(vo.getDate())&&!vo.getAgent().contains("SUM")){
                            if ("GH".equals(vo.getAgent())){
                                dayFxlVo.setFxlGH(new String[]{vo.getJq3()+"%"});
                            }
                            if ("NH".equals(vo.getAgent())){
                                dayFxlVo.setFxlNH(new String[]{vo.getJq3()+"%"});
                            }
                            if ("DH".equals(vo.getAgent())){
                                dayFxlVo.setFxlDH(new String[]{vo.getJq3()+"%"});
                            }
                            if ("DF".equals(vo.getAgent())){
                                dayFxlVo.setFxlDF(new String[]{vo.getJq3()+"%"});
                            }
                        }else if (vo!=null&&curmonth.equals(vo.getDate())&&vo.getAgent().contains("SUM")){
                            if ("GHSUM".equals(vo.getAgent())){
                                monthFxlVo.setFxlGH(new String[]{vo.getJq3()+"%"});
                            }
                            if ("NHSUM".equals(vo.getAgent())){
                                monthFxlVo.setFxlNH(new String[]{vo.getJq3()+"%"});
                            }
                            if ("DHSUM".equals(vo.getAgent())){
                                monthFxlVo.setFxlDH(new String[]{vo.getJq3()+"%"});
                            }
                            if ("DFSUM".equals(vo.getAgent())){
                                monthFxlVo.setFxlDF(new String[]{vo.getJq3()+"%"});
                            }
                        }
                    }


                }catch (Exception e){
                    log.info("tj:"+e);
                }

            }

            list.add(dayFxlVo);
            list.add(monthFxlVo);
        }



        return list;
    }


    //航班正常管理提示
    public List<RunQualityReportTipsVo> findFltManageTipsInfo(@Param("params") Map params){
        List<RunQualityReportTipsVo> list = new ArrayList<RunQualityReportTipsVo>();
        //RunQualityReportVo rqrVo = this.findRunQualityReportByDate(params).get(0);
        RunQualityReportTipsVo vo = new RunQualityReportTipsVo();
      //  vo.setFlTips(rqrVo.getFlTips());
        vo.setFlTips("");
        String execDate = params.get("execDate2").toString();
        String agent = params.get("agent").toString();
        if (StringUtil.isEmpty(agent))agent="ALL";
        RunQualityPDFVo pdfVo=this.selectByPDFPrimaryKey(execDate,agent);
        RunQualityPDFVo pdfVoLately=runQualityReportMapper.selectByPDFLately(null);
        //先查简报保存表，没有再从航班主表捞数据
        if (pdfVo!=null&&StringUtil.isNotEmpty(pdfVo.getExecdate())){
            vo.setFlTips(pdfVo.getFlTips());
        }
        if (pdfVoLately!=null&&StringUtil.isNotEmpty(pdfVoLately.getExecdate())){
            vo.setFlTipsLately(pdfVoLately.getFlTips());
        }
        list.add(vo);
        return list;
    }



    //------------------------航班正常性统计（新方法）-----------------------------------
    /**
     * 正常率
     */
    //查询航班正常性统计(正常率)-天
    public String selectZCLDay(@Param("params") Map params){
        return runQualityReportMapper.selectZCLDay(params);
    }

    //查询航班正常性统计(正常率)-月
    public String selectZCLMonth(@Param("params") Map params){
        return runQualityReportMapper.selectZCLMonth(params);
    }

    //查询航班正常性统计(正常率)-年
    public String selectZCLYear(@Param("params") Map params){
        return runQualityReportMapper.selectZCLYear(params);
    }

    //查询航班正常性统计(正常率)-去年同天
    public String selectZCLDayQn(@Param("params") Map params){
        return runQualityReportMapper.selectZCLDayQn(params);
    }

    //查询航班正常性统计(正常率)-去年同月
    public String selectZCLMonthQn(@Param("params") Map params){
        return runQualityReportMapper.selectZCLMonthQn(params);
    }

    //查询航班正常性统计(正常率)-去年
    public String selectZCLYearQn(@Param("params") Map params){
        return runQualityReportMapper.selectZCLYearQn(params);
    }


    /**
     * 始发正常率
     */
    //查询航班正常性统计(始发放行率)-天
    public String selectSFZCLDay(@Param("params") Map params){
        return runQualityReportMapper.selectSFZCLDay(params);
    }

    //查询航班正常性统计(始发放行率)-月
    public String selectSFZCLMonth(@Param("params") Map params){
        return runQualityReportMapper.selectSFZCLMonth(params);
    }

    //查询航班正常性统计(始发放行率)-年
    public String selectSFZCLYear(@Param("params") Map params){
        return runQualityReportMapper.selectSFZCLYear(params);
    }

    //查询航班正常性统计(始发放行率)-去年同天
    public String selectSFZCLDayQn(@Param("params") Map params){
        return runQualityReportMapper.selectSFZCLDayQn(params);
    }

    //查询航班正常性统计(始发放行率)-去年同月
    public String selectSFZCLMonthQn(@Param("params") Map params){
        return runQualityReportMapper.selectSFZCLMonthQn(params);
    }

    //查询航班正常性统计(始发放行率)-去年
    public String selectSFZCLYearQn(@Param("params") Map params){
        return runQualityReportMapper.selectSFZCLYearQn(params);
    }


    /**
     * 放行率
     */
    //查询航班正常性统计(放行率)-天
    public String selectFXLDay(@Param("params") Map params){
        return runQualityReportMapper.selectFXLDay(params);
    }

    //查询航班正常性统计(放行率)-月
    public String selectFXLMonth(@Param("params") Map params){
        return runQualityReportMapper.selectFXLMonth(params);
    }

    //查询航班正常性统计(放行率)-年
    public String selectFXLYear(@Param("params") Map params){
        return runQualityReportMapper.selectFXLYear(params);
    }

    //查询航班正常性统计(放行率)-去年同天
    public String selectFXLDayQn(@Param("params") Map params){
        return runQualityReportMapper.selectFXLDayQn(params);
    }

    //查询航班正常性统计(放行率)-去年同月
    public String selectFXLMonthQn(@Param("params") Map params){
        return runQualityReportMapper.selectFXLMonthQn(params);
    }

    //查询航班正常性统计(放行率)-去年
    public String selectFXLYearQn(@Param("params") Map params){
        return runQualityReportMapper.selectFXLYearQn(params);
    }

    @Override
    public RunQualityPDFVo selectByPDFPrimaryKey(String execdate, String agent) {
        return runQualityReportMapper.selectByPDFPrimaryKey(execdate,agent);
    }

    @Override
    public int insertPDF(RunQualityPDFVo record) {
        return runQualityReportMapper.insertPDF(record);
    }

    @Override
    public int updateByPDFPrimaryKey(RunQualityPDFVo record) {
        return runQualityReportMapper.updateByPDFPrimaryKey(record);
    }

    @Override
    public List<PaiMingDYGVo> selectZclFxlMonthQn(Map params) {
        String execDate = params.get("execDate").toString();
        String e2 [] =  execDate.split("-");
        String curmonth=e2[0]+"-"+e2[1];
        String months=DateTimeUtil.dateToStr2(new Date());
        log.info("selectZclFxlMonthQncurmonth:"+curmonth+" "+months);
        List<PaiMingDYGVo> re=new ArrayList<PaiMingDYGVo>();
        int days = 0;
        if (months.substring(0,7).compareTo(curmonth)<0){
            return re;
        }else if (months.substring(0,7).equals(curmonth)){
            days=Integer.parseInt(months.substring(months.lastIndexOf("-")+1));
        }else {

            int year=Integer.parseInt(e2[0]);
            int month=Integer.parseInt(e2[1]);
            if (month==1||month==3||month==5||month==7||month==8||month==10||month==12){
                days = 31;
            }else if (month==4||month==6||month==9||month==11){
                days = 30;
            }else if (month==2){
                if( year%4==0&&year%100!=0||year%400==0){
                    days = 29;
                }else {
                    days = 28;
                }
            }else {
                log.info("请输入正确的月份");
                return re;
            }
        }
        for (int i = 1; i <=days ; i++) {
               String dayi=i+"";
               if (i<10)dayi="0"+dayi;
            log.info("天"+dayi);
            PaiMingDYGVo vo=new PaiMingDYGVo();
            vo.setExecdate(curmonth+"-"+dayi);
            re.add(vo);
        }
        return re;
        //return runQualityReportMapper.selectZclFxlMonthQn(params);
    }

    @Override
    public int insertZclFxlJqMonthQn(PaiMingQTVo record) {
        return runQualityReportMapper.insertZclFxlJqMonthQn(record);
    }

    @Override
    public int updateByZclFxlJqMonthQn(PaiMingQTVo record) {
        return runQualityReportMapper.updateByZclFxlJqMonthQn(record);
    }

    @Override
    public List<PaiMingQTVo> selectZclFxlRANKING(Map params) {
        return runQualityReportMapper.selectZclFxlRANKING(params);
    }
}
