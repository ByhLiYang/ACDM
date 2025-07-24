package com.hq.acdm.service.index.impl;

import com.google.common.collect.Lists;
import com.hq.acdm.dao.index.*;
import com.hq.acdm.dao.supervision.VFreestandSumMapper;
import com.hq.acdm.model.index.*;
import com.hq.acdm.model.supervision.managermonitor.VFreestandSum;
import com.hq.acdm.service.index.IIndexService;
import com.hq.acdm.vo.index.BaseSituationVo;
import com.hq.acdm.vo.index.DelayFlightVo;
import com.hq.acdm.vo.index.FlightNumVo;
import com.hq.acdm.vo.index.WeatherAndDutyVo;
import com.hq.acdm.vo.realtimeSituation.HBSPerHour;
import com.hq.acdm.vo.supervision.managermonitor.DateName;
import com.hq.acdm.vo.supervision.managermonitor.FourD;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/9/3 0003
 * @Description:
 */
@Service("indexService")
public class IndexServiceImpl implements IIndexService {

    private static final String TYPE_FLIGHT_PERSON = "机上人数";

    private static final String TYPE_SECURITY_PERSON = "安检区人数";

    private static final String TYPE_WAIT_FLIGHT_PERSON = "候机区人数";

    @Resource
    private VSequenceArrivalFetchrowsMapper vSequenceArrivalFetchrowsMapper;
    @Resource
    private VSequenceDepartureFetchrowsMapper vSequenceDepartureFetchrowsMapper;
    @Resource
    private WeatherMapper weatherMapper;
    @Resource
    private VDelayFlightSumMapper vDelayFlightSumMapper;
    @Resource
    private VForecastMapper vForecastMapper;
    @Resource
    private VRealInterfaceMapper vRealInterfaceMapper;
    @Resource
    private VPaxSumMapper vPaxSumMapper;
    @Resource
    private CompanyDutyMapper companyDutyMapper;
    @Resource
    private VFreestandSumMapper vFreestandSumMapper;

    @Override
    public List<VSequenceArrivalFetchrows> geVSequenceArrivalFetchrows() {
        return vSequenceArrivalFetchrowsMapper.getRecord();
    }

    @Override
    public List<VSequenceDepartureFetchrows> getVSequenceDepartureFetchrows() {
        return vSequenceDepartureFetchrowsMapper.getRecord();
    }

    @Override
    public WeatherAndDutyVo selectByWeatherDate() {
        WeatherAndDutyVo vo = new WeatherAndDutyVo();
        List<Weather> weather = Lists.newArrayList();
        weather.add(weatherMapper.selectByWeatherDateByTable());
        vo.setWeather(weather);

        /*sww
        List<CompanyDuty> companyDuty = Lists.newArrayList();
        if (null != companyDutyMapper.getTodayRecord() && companyDutyMapper.getTodayRecord().size()>0) {
            companyDuty.add(companyDutyMapper.getTodayRecord().get(0));
        }

        vo.setCompanyDuty(companyDuty);

        //当日跑道方向
        FourD date = vDelayFlightSumMapper.getDateName();
        if (null != date) {
            List<DateName> tableData2 = Lists.newArrayList();

            DateName dateNameOne = new DateName();
            dateNameOne.setDate("当日起飞跑道");
            dateNameOne.setName(date.getD1());

            DateName dateNameTwo = new DateName();
            dateNameTwo.setDate("当日降落跑道");
            dateNameTwo.setName(date.getD0());

            tableData2.add(dateNameOne);
            tableData2.add(dateNameTwo);

            vo.setTableData1(tableData2);
        }

        //机场空闲停机位
        String[] list = {"B","C","D","E"};
        List<String> bcdeList = Arrays.asList(list);

        List<VFreestandSum> freeList = vFreestandSumMapper.getAll();

        List<FourD> fourDList = Lists.newArrayList();
        FourD fourDFirst = new FourD();
        fourDFirst.setD0("");
        fourDFirst.setD1("T1航站楼");
        fourDFirst.setD2("T2航站楼");
        fourDFirst.setD3("合计");
//        fourDList.add(fourDFirst);

        for (String str : bcdeList) {
            FourD fourD = new FourD();
            for (VFreestandSum free : freeList) {
                if (str.equals(free.getDescription())) {
                    fourD.setD0(str);
                    if (free.getTerminal().equals("1")) {
                        fourD.setD1(String.valueOf(free.getStands()));
                    }
                    if (free.getTerminal().equals("2")) {
                        fourD.setD2(String.valueOf(free.getStands()));
                    }
                }
                fourD.setD3(fourD.getMyD3());
            }
            fourDList.add(fourD);
        }
        vo.setTableData2(fourDList);
        */

        return vo;
    }

    @Override
/*    public DelayFlightVo getDelayFlight() {
        List<> executedList = vDelayFlightSumMapper.getRecord();
        DelayFlightVo vo = new DelayFlightVo();
        //已经执行
        List<BigDecimal> executedListArrays = Lists.newArrayList();
        List<BigDecimal> nonExecutedListArrays = Lists.newArrayList();

        //未执行=flightNum-delayFlightNum（已经执行）
        for (VDelayFlightSum executedFlight : executedList) {
            executedListArrays.add(executedFlight.getDelayFlightNum());

            nonExecutedListArrays.add(executedFlight.getFlightNum().subtract(executedFlight.getDelayFlightNum()));
        }
        vo.setExecutedList(executedListArrays);
        vo.setNonExecutionList(nonExecutedListArrays);
        return vo;
    }*/
public List<VDelayFlightSum> getDelayFlight() {

        return vDelayFlightSumMapper.getRecord();
    }


    @Override
    public FlightNumVo getInOutBoundFlight(String flag) {
/*        String [] hours={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
        List<HBSPerHour> aJHSList1 = vForecastMapper.getplanFlightNum(flag);
        List<HBSPerHour> aJHSList2 = vForecastMapper.getactualFlightNum(flag);
        List<HBSPerHour> aJHSList3 = vForecastMapper.getquarantineNum(flag);*/
        FlightNumVo vo = new FlightNumVo();
/*        List<Integer> planFlightNum= Lists.newArrayList();
        List<Integer> actualFlightNum= Lists.newArrayList();
        List<Integer> quarantineNum= Lists.newArrayList();
        int [] countEOne=new int[hours.length];
        int [] countETwo=new int[hours.length];
        int [] countWOne=new int[hours.length];
        for (int i = 0; i <hours.length ; i++) {
            countEOne[i]=0;
            countETwo[i]=0;
            countWOne[i]=0;
        }

        for (int i = 0; i <hours.length ; i++) {
            for (int j = 0; j <aJHSList1.size() ; j++) {

                if (hours[i].equals(aJHSList1.get(j).getTime_H())){
                    countEOne[i]=aJHSList1.get(j).getHBS();


                    break;
                }
            }

            for (int j = 0; j <aJHSList2.size() ; j++) {

                if (hours[i].equals(aJHSList2.get(j).getTime_H())){
                    countETwo[i]=aJHSList2.get(j).getHBS();

                    break;
                }
            }

            for (int j = 0; j <aJHSList3.size() ; j++) {

                if (hours[i].equals(aJHSList3.get(j).getTime_H())){
                    countWOne[i]=aJHSList3.get(j).getHBS();

                    break;
                }
            }



        }
        for (int i = 0; i <hours.length ; i++) {
            planFlightNum.add(countEOne[i]);
            actualFlightNum.add(countETwo[i]);
            quarantineNum.add(countWOne[i]);

        }
        vo.setPlanFlightNum(planFlightNum);
        vo.setActualFlightNum(actualFlightNum);
        vo.setQuarantineNum(quarantineNum);*/
        return vo;
    }

    @Override
    public BaseSituationVo getBaseSituation(String company) {
        BaseSituationVo baseVo = new BaseSituationVo();

        VRealInterface realInterfaceRecord = null;
        List<VPaxSum> paxList = null;
        BigDecimal yesNorMalFenZi = null;
        BigDecimal yesNormalFenMu =null;
        BigDecimal yesPassFenZi =null;
        BigDecimal yesPassFenMu =null;
        if(null==company){
            company="";
        }
        switch (company){
            case "MF" :
                realInterfaceRecord = vRealInterfaceMapper.getRecordHAS();
                baseVo.setInternational(vPaxSumMapper.getInternationalNumHAS());
                baseVo.setDomestic(vPaxSumMapper.getDomesticNumHAS());
                paxList = vPaxSumMapper.getRecordHAS();
                baseVo.setYesterdayPlan(vPaxSumMapper.getYesterdayPlanFlightNumHAS());
                baseVo.setYesterdayActual(vPaxSumMapper.getYesterdayActualFlightNumHAS());
                baseVo.setPreparationForDrop(vPaxSumMapper.getPreparationForDropHAS());
                yesNorMalFenZi = vPaxSumMapper.getYesterdayFlightNormalRateNumeratorHAS();
                yesNormalFenMu = vPaxSumMapper.getYesterdayFlightNormalRateDenominatorHAS();
                //昨日放行率：
                yesPassFenZi = vPaxSumMapper.getYesterdayFlightReleaseRateNumeratorHAS();
                yesPassFenMu = vPaxSumMapper.getYesterdayFlightReleaseRateDenominatorHAS();
                break;
            case "CA" :
                realInterfaceRecord = vRealInterfaceMapper.getRecordCA();
                baseVo.setInternational(vPaxSumMapper.getInternationalNumCA());
                baseVo.setDomestic(vPaxSumMapper.getDomesticNumCA());
                paxList = vPaxSumMapper.getRecordCA();
                baseVo.setYesterdayPlan(vPaxSumMapper.getYesterdayPlanFlightNumCA());
                baseVo.setYesterdayActual(vPaxSumMapper.getYesterdayActualFlightNumCA());
                baseVo.setPreparationForDrop(vPaxSumMapper.getPreparationForDropCA());
                yesNorMalFenZi = vPaxSumMapper.getYesterdayFlightNormalRateNumeratorCA();
                yesNormalFenMu = vPaxSumMapper.getYesterdayFlightNormalRateDenominatorCA();
                //昨日放行率：
                yesPassFenZi = vPaxSumMapper.getYesterdayFlightReleaseRateNumeratorCA();
                yesPassFenMu = vPaxSumMapper.getYesterdayFlightReleaseRateDenominatorCA();
                break;
            case "FM" :
                realInterfaceRecord = vRealInterfaceMapper.getRecordMU();
                baseVo.setInternational(vPaxSumMapper.getInternationalNumMU());
                baseVo.setDomestic(vPaxSumMapper.getDomesticNumMU());
                paxList = vPaxSumMapper.getRecordMU();
                baseVo.setYesterdayPlan(vPaxSumMapper.getYesterdayPlanFlightNumMU());
                baseVo.setYesterdayActual(vPaxSumMapper.getYesterdayActualFlightNumMU());
                baseVo.setPreparationForDrop(vPaxSumMapper.getPreparationForDropMU());
                yesNorMalFenZi = vPaxSumMapper.getYesterdayFlightNormalRateNumeratorMU();
                yesNormalFenMu = vPaxSumMapper.getYesterdayFlightNormalRateDenominatorMU();
                //昨日放行率：
                yesPassFenZi = vPaxSumMapper.getYesterdayFlightReleaseRateNumeratorMU();
                yesPassFenMu = vPaxSumMapper.getYesterdayFlightReleaseRateDenominatorMU();
                break;
            case "HO" :
                realInterfaceRecord = vRealInterfaceMapper.getRecordHO();
                baseVo.setInternational(vPaxSumMapper.getInternationalNumHO());
                baseVo.setDomestic(vPaxSumMapper.getDomesticNumHO());
                paxList = vPaxSumMapper.getRecordHO();
                baseVo.setYesterdayPlan(vPaxSumMapper.getYesterdayPlanFlightNumHO());
                baseVo.setYesterdayActual(vPaxSumMapper.getYesterdayActualFlightNumHO());
                baseVo.setPreparationForDrop(vPaxSumMapper.getPreparationForDropHO());
                yesNorMalFenZi = vPaxSumMapper.getYesterdayFlightNormalRateNumeratorHO();
                yesNormalFenMu = vPaxSumMapper.getYesterdayFlightNormalRateDenominatorHO();
                //昨日放行率：
                yesPassFenZi = vPaxSumMapper.getYesterdayFlightReleaseRateNumeratorHO();
                yesPassFenMu = vPaxSumMapper.getYesterdayFlightReleaseRateDenominatorHO();
                break;
            case "CZ" :
                realInterfaceRecord = vRealInterfaceMapper.getRecordCZ();
                baseVo.setInternational(vPaxSumMapper.getInternationalNumCZ());
                baseVo.setDomestic(vPaxSumMapper.getDomesticNumCZ());
                paxList = vPaxSumMapper.getRecordCZ();
                baseVo.setYesterdayPlan(vPaxSumMapper.getYesterdayPlanFlightNumCZ());
                baseVo.setYesterdayActual(vPaxSumMapper.getYesterdayActualFlightNumCZ());
                baseVo.setPreparationForDrop(vPaxSumMapper.getPreparationForDropCZ());
                yesNorMalFenZi = vPaxSumMapper.getYesterdayFlightNormalRateNumeratorCZ();
                yesNormalFenMu = vPaxSumMapper.getYesterdayFlightNormalRateDenominatorCZ();
                //昨日放行率：
                yesPassFenZi = vPaxSumMapper.getYesterdayFlightReleaseRateNumeratorCZ();
                yesPassFenMu = vPaxSumMapper.getYesterdayFlightReleaseRateDenominatorCZ();
                break;
            default:
                realInterfaceRecord = vRealInterfaceMapper.getRecord();
                //国际:
                baseVo.setInternational(vPaxSumMapper.getInternationalNum());
                //国内：
                baseVo.setDomestic(vPaxSumMapper.getDomesticNum());
                paxList = vPaxSumMapper.getRecord();
                //昨日计划
                baseVo.setYesterdayPlan(vPaxSumMapper.getYesterdayPlanFlightNum());
                //昨日实际：
                baseVo.setYesterdayActual(vPaxSumMapper.getYesterdayActualFlightNum());
                //备降：
                baseVo.setPreparationForDrop(vPaxSumMapper.getPreparationForDrop());
                //昨日正常率：
                yesNorMalFenZi = vPaxSumMapper.getYesterdayFlightNormalRateNumerator();
                yesNormalFenMu = vPaxSumMapper.getYesterdayFlightNormalRateDenominator();
                //昨日放行率：
                yesPassFenZi = vPaxSumMapper.getYesterdayFlightReleaseRateNumerator();
                yesPassFenMu = vPaxSumMapper.getYesterdayFlightReleaseRateDenominator();
                break;
        }
        //总航班数:
        baseVo.setFlightNum(realInterfaceRecord.getFlightNum().intValue());
        //已执行:
        baseVo.setExecuted(realInterfaceRecord.getAlreadyNum().intValue());
        //未执行:
        baseVo.setNonExecution(realInterfaceRecord.getReadyNum().intValue());
        //正常率：
        BigDecimal norMalFenZi = realInterfaceRecord.getFlightNormalRateNumerator();
        BigDecimal normalFenMu = realInterfaceRecord.getFlightNormalRateDenominator();
        if (normalFenMu.intValue() == 0) {
            baseVo.setNormalRate("0");
        } else {
            BigDecimal divide = norMalFenZi.multiply(new BigDecimal(100)).divide(normalFenMu,1,BigDecimal.ROUND_HALF_DOWN);

            String str = String.valueOf(divide);

            baseVo.setNormalRate(new DecimalFormat(".0").format((100-Float.parseFloat(str))));
        }

        //放行率：
        BigDecimal passFenZi = realInterfaceRecord.getFlightReleaseRateNumerator();
        BigDecimal passFenMu = realInterfaceRecord.getfReleaseRateDenominator();
        if (passFenMu.intValue() == 0) {
            baseVo.setPassRate("0");
        } else {
//            BigDecimal divide = passFenZi.multiply(new BigDecimal(100)).divide(passFenMu,1,BigDecimal.ROUND_HALF_DOWN);
//   放行率使用正常率分母
            BigDecimal divide = passFenZi.multiply(new BigDecimal(100)).divide(normalFenMu,1,BigDecimal.ROUND_HALF_DOWN);
            String str = String.valueOf(divide);
            baseVo.setPassRate(new DecimalFormat(".0").format(100-Float.parseFloat(str)));
        }

        int totalPersonNum = 0;
        for (VPaxSum pax : paxList) {
            //机上人数：
            if (pax.getType().equals(TYPE_FLIGHT_PERSON)) {
                baseVo.setFlightPersonNum(pax.getPaxNum().intValue());
            }
            //候机区人数：
            if (pax.getType().equals(TYPE_WAIT_FLIGHT_PERSON)) {
                baseVo.setWaitFlightPersonNum(pax.getPaxNum().intValue());
            }
            //安检区人数：
            if (pax.getType().equals(TYPE_SECURITY_PERSON)) {
                baseVo.setSecurityPersonNum(pax.getPaxNum().intValue());
            }
            //总人数：
            totalPersonNum += pax.getPaxNum().intValue();
        }
        baseVo.setTotalPersonNum(String.valueOf(totalPersonNum));

        if (yesNormalFenMu.intValue() == 0) {
            baseVo.setNormalRate("0");
        } else {
            BigDecimal divide = yesNorMalFenZi.multiply(new BigDecimal(100)).divide(yesNormalFenMu,1,BigDecimal.ROUND_HALF_DOWN);

            String str = String.valueOf(divide);
            baseVo.setYesterdayNormalRate(new DecimalFormat(".0").format((100-Float.parseFloat(str))));
        }

        if (yesPassFenMu.intValue() == 0) {
            baseVo.setPassRate("0");
        } else {
            BigDecimal divide = yesPassFenZi.multiply(new BigDecimal(100)).divide(yesPassFenMu,1,BigDecimal.ROUND_HALF_DOWN);

            StringBuilder str = new StringBuilder(String.valueOf(divide));
            baseVo.setYesterdayPassRate(str.toString());
        }
        //延误：
        baseVo.setDelay(realInterfaceRecord.getFlightNormalRateNumerator().intValue());
        //取消：
        baseVo.setCancel(realInterfaceRecord.getCancelNum().intValue());
        return baseVo;
    }
}
