package com.hq.acdm.dao.effectAnalysis;

import com.hq.acdm.vo.effectAnalysis.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:38
 * @Description
 */
public interface RunQualityReportMapper {

    //查询运行品质简报
    List<RunQualityReportVo> findRunQualityReportByDate(@Param("params") Map params);

    //查询运输量
    List<RunQualityReportVo> findYunShuLiang(@Param("params") Map params);

    //查询人数
    List<RunQualityReportVo> findRenShu(@Param("params") Map params);

    //查询航班正常性统计(正常率、放行率，始发放行率)-天
    List<RunQualityReportZCLVo> findZCLDay(@Param("params") Map params);

    //查询航班正常性统计(正常率、放行率，始发放行率)-月
    List<RunQualityReportZCLVo> findZCLMonth(@Param("params") Map params);

    //查询航班正常性统计(正常率、放行率，始发放行率)-年
    List<RunQualityReportZCLVo> findZCLYear(@Param("params") Map params);

    //查询航班正常性统计(正常率、放行率，始发放行率)-去年同天
    List<RunQualityReportZCLVo> findZCLDayQn(@Param("params") Map params);

    //查询航班正常性统计(正常率、放行率，始发放行率)-去年同月
    List<RunQualityReportZCLVo> findZCLMonthQn(@Param("params") Map params);

    //查询航班正常性统计(正常率、放行率，始发放行率)-去年
    List<RunQualityReportZCLVo> findZCLYearQn(@Param("params") Map params);

    //查询靠桥率
    String findKQL(@Param("params") Map params);

    //查询关门准点率及晚关门航班数
    List<RunQualityReportVo> findGMZDL(@Param("params") Map params);

    //查询放行正常率排名（国航）当天
    String findFxlDayGH(@Param("params") Map params);

    //查询放行正常率排名（国航）当月
    String findFxlMonthGH(@Param("params") Map params);

    //查询放行正常率排名（南航）当天
    String findFxlDayNH(@Param("params") Map params);

    //查询放行正常率排名（南航）当月
    String findFxlMonthNH(@Param("params") Map params);

    //查询放行正常率排名（东航）当天
    String findFxlDayDH(@Param("params") Map params);

    //查询放行正常率排名（东航）当月
    String findFxlMonthDH(@Param("params") Map params);

    //查询放行正常率排名（地服）当天
    String findFxlDayDF(@Param("params") Map params);

    //查询放行正常率排名（地服）当月
    String findFxlMonthDF(@Param("params") Map params);

    //查询放行正常率排名（货运）当天
    String findFxlDayHY(@Param("params") Map params);

    //查询放行正常率排名（货运）当月
    String findFxlMonthHY(@Param("params") Map params);

    //查询航班进港实际数
    List<RunQualityReportAOrDShuVo> findAsjs(@Param("params") Map params);

    //查询航班出港计划数
    List<RunQualityReportAOrDShuVo> findDjhs(@Param("params") Map params);

    //查询航班出港实际数
    List<RunQualityReportAOrDShuVo> findDsjs(@Param("params") Map params);

    //查询实际小时起降架次最高
    String findMaxAOrDHbs(@Param("params") Map params);

    //平均进港滑行时间（分钟）
    String findAvgJghxsj(@Param("params") Map params);

    //平均出港滑行时间（分钟）
    String findAvgCghxsj(@Param("params") Map params);

    //延误原因统计
    List<RunQualityReportVo> findYWYYTJInfo(@Param("params") Map params);

    //运行品质简报航班进程质量管控
    List<RunQualityReportJCZLJGVo> findHBJCZLJGInfo(@Param("params") Map params);


    //------------------------航班正常性统计（新方法）-----------------------------------
    /**
     * 正常率
     */
    //查询航班正常性统计(正常率)-天
    String selectZCLDay(@Param("params") Map params);

    //查询航班正常性统计(正常率)-月
    String selectZCLMonth(@Param("params") Map params);

    //查询航班正常性统计(正常率)-年
    String selectZCLYear(@Param("params") Map params);

    //查询航班正常性统计(正常率)-去年同天
    String selectZCLDayQn(@Param("params") Map params);

    //查询航班正常性统计(正常率)-去年同月
    String selectZCLMonthQn(@Param("params") Map params);

    //查询航班正常性统计(正常率)-去年
    String selectZCLYearQn(@Param("params") Map params);


    /**
     * 始发正常率
     */
    //查询航班正常性统计(始发放行率)-天
    String selectSFZCLDay(@Param("params") Map params);

    //查询航班正常性统计(始发放行率)-月
    String selectSFZCLMonth(@Param("params") Map params);

    //查询航班正常性统计(始发放行率)-年
    String selectSFZCLYear(@Param("params") Map params);

    //查询航班正常性统计(始发放行率)-去年同天
    String selectSFZCLDayQn(@Param("params") Map params);

    //查询航班正常性统计(始发放行率)-去年同月
    String selectSFZCLMonthQn(@Param("params") Map params);

    //查询航班正常性统计(始发放行率)-去年
    String selectSFZCLYearQn(@Param("params") Map params);


    /**
     * 放行率
     */
    //查询航班正常性统计(放行率)-天
    String selectFXLDay(@Param("params") Map params);

    //查询航班正常性统计(放行率)-月
    String selectFXLMonth(@Param("params") Map params);

    //查询航班正常性统计(放行率)-年
    String selectFXLYear(@Param("params") Map params);

    //查询航班正常性统计(放行率)-去年同天
    String selectFXLDayQn(@Param("params") Map params);

    //查询航班正常性统计(放行率)-去年同月
    String selectFXLMonthQn(@Param("params") Map params);

    //查询航班正常性统计(放行率)-去年
    String selectFXLYearQn(@Param("params") Map params);

    //查询PDF保存数据
    RunQualityPDFVo selectByPDFPrimaryKey(@Param("execdate") String execdate, @Param("agent") String agent);

    //查询PDF保存数据
    RunQualityPDFVo selectByPDFLately(@Param("params") Map params);

    //新增PDF数据
    int insertPDF(RunQualityPDFVo record);

    //PDF保存数据
    int updateByPDFPrimaryKey(RunQualityPDFVo record);

    //查询某月航班正常率放行率加权排名
    List<PaiMingDYGVo> selectZclFxlMonthQn(@Param("params") Map params);

    //新增某月航班正常率放行率加权排名
    int insertZclFxlJqMonthQn(PaiMingQTVo record);

    //P保存某月航班正常率放行率加权排名
    int updateByZclFxlJqMonthQn(PaiMingQTVo record);

    //查询某表加权排名
    List<PaiMingQTVo> selectZclFxlRANKING(@Param("params") Map params);

    //品质简报查询某表加权排名
    List<PaiMingQTVo> selectZclFxlRANKINGByDay(@Param("params") Map params);
}
