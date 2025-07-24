package com.hq.acdm.dao.index;

import com.hq.acdm.model.index.VPaxSum;

import java.math.BigDecimal;
import java.util.List;

public interface VPaxSumMapper {
    int insert(VPaxSum record);

    int insertSelective(VPaxSum record);

    List<VPaxSum> getRecord();
    List<VPaxSum> getRecordCA();
    List<VPaxSum> getRecordCZ();
    List<VPaxSum> getRecordHAS();
    List<VPaxSum> getRecordHO();
    List<VPaxSum> getRecordMU();


    /**
     * 昨日计划进出港航班数量
     * @return
     */
    int getYesterdayPlanFlightNum();
    int getYesterdayPlanFlightNumCA();
    int getYesterdayPlanFlightNumCZ();
    int getYesterdayPlanFlightNumHAS();
    int getYesterdayPlanFlightNumHO();
    int getYesterdayPlanFlightNumMU();

    /**
     * 昨日实际进出港航班数量
     * @return
     */
    int getYesterdayActualFlightNum();
    int getYesterdayActualFlightNumCA();
    int getYesterdayActualFlightNumCZ();
    int getYesterdayActualFlightNumHAS();
    int getYesterdayActualFlightNumHO();
    int getYesterdayActualFlightNumMU();

    /**
     * 备降航班数量
     * @return
     */
    int getPreparationForDrop();
    int getPreparationForDropCA();
    int getPreparationForDropCZ();
    int getPreparationForDropHAS();
    int getPreparationForDropHO();
    int getPreparationForDropMU();

    /**
     * 国际航班数量
     * @return
     */
    int getInternationalNum();
    int getInternationalNumCA();
    int getInternationalNumCZ();
    int getInternationalNumHAS();
    int getInternationalNumHO();
    int getInternationalNumMU();


    /**
     * 国内航班数量
     * @return
     */
    int getDomesticNum();
    int getDomesticNumCA();
    int getDomesticNumCZ();
    int getDomesticNumHAS();
    int getDomesticNumHO();
    int getDomesticNumMU();


    /**
     * 昨日航班放行率的分子
     * @return
     */
    BigDecimal getYesterdayFlightReleaseRateNumerator();
    BigDecimal getYesterdayFlightReleaseRateNumeratorCA();
    BigDecimal getYesterdayFlightReleaseRateNumeratorCZ();
    BigDecimal getYesterdayFlightReleaseRateNumeratorHAS();
    BigDecimal getYesterdayFlightReleaseRateNumeratorHO();
    BigDecimal getYesterdayFlightReleaseRateNumeratorMU();

    /**
     * 昨日航班放行率的分母
     * @return
     */
    BigDecimal getYesterdayFlightReleaseRateDenominator();
    BigDecimal getYesterdayFlightReleaseRateDenominatorCA();
    BigDecimal getYesterdayFlightReleaseRateDenominatorCZ();
    BigDecimal getYesterdayFlightReleaseRateDenominatorHAS();
    BigDecimal getYesterdayFlightReleaseRateDenominatorHO();
    BigDecimal getYesterdayFlightReleaseRateDenominatorMU();

    /**
     * 昨日航班正常率的分子
     * @return
     */
    BigDecimal getYesterdayFlightNormalRateNumerator();
    BigDecimal getYesterdayFlightNormalRateNumeratorCA();
    BigDecimal getYesterdayFlightNormalRateNumeratorCZ();
    BigDecimal getYesterdayFlightNormalRateNumeratorHAS();
    BigDecimal getYesterdayFlightNormalRateNumeratorHO();
    BigDecimal getYesterdayFlightNormalRateNumeratorMU();

    /**
     * 昨日航班正常率的分母
     * @return
     */
    BigDecimal getYesterdayFlightNormalRateDenominator();
    BigDecimal getYesterdayFlightNormalRateDenominatorCA();
    BigDecimal getYesterdayFlightNormalRateDenominatorCZ();
    BigDecimal getYesterdayFlightNormalRateDenominatorHAS();
    BigDecimal getYesterdayFlightNormalRateDenominatorHO();
    BigDecimal getYesterdayFlightNormalRateDenominatorMU();

}