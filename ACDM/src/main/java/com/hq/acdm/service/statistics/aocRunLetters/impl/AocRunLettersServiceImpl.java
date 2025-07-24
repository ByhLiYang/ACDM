package com.hq.acdm.service.statistics.aocRunLetters.impl;

import com.hq.acdm.dao.statistics.AocRunLettersMapper;
import com.hq.acdm.model.statistics.aocRunLetters.BridgeRate;
import com.hq.acdm.model.statistics.aocRunLetters.RealInterfaceYD;
import com.hq.acdm.service.statistics.aocRunLetters.AocRunLettersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * AOC运行快报实现类
 */
@Service
public class AocRunLettersServiceImpl implements AocRunLettersService {
    @Resource
    private AocRunLettersMapper aocRunLettersMapper;

    @Override
    public List<RealInterfaceYD> queryAllRealInterfaceYD() {
        return aocRunLettersMapper.queryAllRealInterfaceYD();
    }

    @Override
    public int queryCorporateAircraftCount() {
        return aocRunLettersMapper.queryCorporateAircraftCount();
    }

    @Override
    public int queryNumberOfPassengers() {
        return aocRunLettersMapper.queryNumberOfPassengers();
    }

    @Override
    public Map queryStartRate() {
        return aocRunLettersMapper.queryStartRate();
    }

    @Override
    public String queryOnTheBridgeRate() {
        return aocRunLettersMapper.queryOnTheBridgeRate();
    }

    @Override
    public int queryPEKtoSHAdeparture() {
        return aocRunLettersMapper.queryPEKtoSHAdeparture();
    }

    @Override
    public int queryPEKtoSHAreleaseNormal() {
        return aocRunLettersMapper.queryPEKtoSHAreleaseNormal();
    }

    @Override
    public List<BridgeRate> queryOnTheBridgeRateTwo() {
        return aocRunLettersMapper.queryOnTheBridgeRateTwo();
    }



    //getFun请求
    @Override
    public Map queryStartRateOfGetFun() {
        return aocRunLettersMapper.queryStartRateOfGetFun();
    }



    @Override
    public List<Map> queryBJtoSHflight() {
        return aocRunLettersMapper.queryBJtoSHflight();
    }

    @Override
    public int queryCodeUnreasonable() {
        return aocRunLettersMapper.queryCodeUnreasonable();
    }

    @Override
    public List<Map>  queryPlaneLate() {
        return aocRunLettersMapper.queryPlaneLate();
    }

    @Override
    public int cobtWithSobtLeavePort() {
        return aocRunLettersMapper.cobtWithSobtLeavePort();
    }

    @Override
    public List<Map> querySmallDelay() {
        return aocRunLettersMapper.querySmallDelay();
    }

    @Override
    public int queryLeavePortCount() {
        return aocRunLettersMapper.queryLeavePortCount();
    }

    @Override
    public Map querycobtSaltusStep() {
        return aocRunLettersMapper.querycobtSaltusStep();
    }

    @Override
    public List<Map> querycobtDailyBest() {
        return aocRunLettersMapper.querycobtDailyBest();
    }


}
