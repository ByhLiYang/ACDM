package com.hq.acdm.service.index.impl;

import com.hq.acdm.dao.index.SceneMoniterMapper;
import com.hq.acdm.dao.index.VPaxSumMapper;
import com.hq.acdm.service.index.SceneMoniterService;
import com.hq.acdm.vo.index.FlightFulInfoVo;
import com.hq.acdm.vo.index.SceneMoniterVo;
import com.hq.acdm.vo.index.StandStatusVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/11/18 16:21
 * @Description
 */
@Service
public class SceneMoniterServiceImpl implements SceneMoniterService {
    @Resource
    private SceneMoniterMapper sceneMoniterMapper;
    @Resource
    private VPaxSumMapper vPaxSumMapper;
    @Override
    public SceneMoniterVo getSceneMoniter() {
        SceneMoniterVo sceneMoniterVo = new SceneMoniterVo();
//        总架次
        sceneMoniterVo.setFlightSum(String.valueOf(sceneMoniterMapper.findFlightSum()));
//        进港
        sceneMoniterVo.setArrival(sceneMoniterMapper.findArrivalNumerator()+"/"+sceneMoniterMapper.findArrivalDenominator());
//        离港
        sceneMoniterVo.setDeparture(sceneMoniterMapper.findDepartureNumerator()+"/"+sceneMoniterMapper.findArrivalDenominator());
//        国内
        sceneMoniterVo.setInland(String.valueOf(vPaxSumMapper.getDomesticNum()));
//        国际
        sceneMoniterVo.setInternational(String.valueOf(vPaxSumMapper.getInternationalNum()));
//        进港准点率
        BigDecimal numeratorA = sceneMoniterMapper.findNormalRateNumeratorA();
        BigDecimal denominatorA = sceneMoniterMapper.findnormalRateDenominatorA();
        if (denominatorA.intValue() == 0) {
            sceneMoniterVo.setNormalRateA("0");
        } else {
            BigDecimal divide = numeratorA.multiply(new BigDecimal(100)).divide(denominatorA,2,BigDecimal.ROUND_HALF_DOWN);
            sceneMoniterVo.setNormalRateA(new DecimalFormat(".00").format((100-Float.parseFloat(String.valueOf(divide)))));
        }
//        离港准点率
        BigDecimal numeratorD = sceneMoniterMapper.findNormalRateNumeratorD();
        BigDecimal denominatorD = sceneMoniterMapper.findnormalRateDenominatorD();
        if (denominatorD.intValue() == 0) {
            sceneMoniterVo.setNormalRateD("0");
        } else {
            BigDecimal divide = numeratorD.multiply(new BigDecimal(100)).divide(denominatorD,2,BigDecimal.ROUND_HALF_DOWN);
            sceneMoniterVo.setNormalRateD(new DecimalFormat(".00").format((100-Float.parseFloat(String.valueOf(divide)))));
        }
//        T1空闲机位
        sceneMoniterVo.setFreeStandT1(String.valueOf(sceneMoniterMapper.findFreeStandT1()));
//        T2空闲机位
        sceneMoniterVo.setFreeStandT2(String.valueOf(sceneMoniterMapper.findFreeStandT2()));
//        备降
        sceneMoniterVo.setReversal(String.valueOf(vPaxSumMapper.getPreparationForDrop()));
        return sceneMoniterVo;
    }

    @Override
    public FlightFulInfoVo findFlightFullInfo(String flight_no_iata, String a_or_d) {
        if ("A".equals(a_or_d)){
            return sceneMoniterMapper.findFlightFullInfoA(flight_no_iata);
        }else{
            return sceneMoniterMapper.findFlightFullInfoD(flight_no_iata);
        }

    }
    @Override
    public List<StandStatusVo> findOccupyStand() {
        List<StandStatusVo> occupyList=sceneMoniterMapper.findOccupyStand();
        for (StandStatusVo occupy : occupyList) {
            occupy.setStandStatus("1");
            occupy.setOccupySum(occupyList.size());
        }
        List<StandStatusVo> confictList=sceneMoniterMapper.findConfictStand();
        for (StandStatusVo confict : confictList) {
            confict.setStandStatus("2");
            confict.setConfictSum(confictList.size());
        }
        occupyList.addAll(confictList);
        return occupyList;
    }

}
