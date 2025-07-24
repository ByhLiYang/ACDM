package com.hq.acdm.service.coordinatedOprt.impl;


import com.hq.acdm.dao.coordinatedOprt.FlightWightInfoUpdMapper;
import com.hq.acdm.service.coordinatedOprt.FlightWightInfoUpdService;
import com.hq.acdm.vo.coordinatedOprt.AirLineVo;
import com.hq.acdm.vo.coordinatedOprt.DateManagerVo;
import com.hq.acdm.vo.coordinatedOprt.FlightWightInfoUpdVo;
import com.hq.acdm.vo.coordinatedOprt.InterFaceVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


@Service
public class FlightWightInfoUpdServiceImpl implements FlightWightInfoUpdService {

    @Resource
    private FlightWightInfoUpdMapper flightWightInfoUpdMapper;

    @Override
    public List<FlightWightInfoUpdVo> findFligthInfo(Map params) {
        return flightWightInfoUpdMapper.findFligthInfo(params);
    }

    @Override
    public int updateFltGoodsMailBagBookingWight(Map params) {
        return flightWightInfoUpdMapper.updateFltGoodsMailBagBookingWight(params);
    }

    @Override
    public int updateFltHisGoodsMailBagBookingWight(Map params) {
        return flightWightInfoUpdMapper.updateFltHisGoodsMailBagBookingWight(params);
    }

    @Override
    public List<InterFaceVo> findInterfaceInfo(Map params) {
        return flightWightInfoUpdMapper.findInterfaceInfo(params);
    }

    @Override
    public List<DateManagerVo> findDateManagerInfo(Map params) {
        return flightWightInfoUpdMapper.findDateManagerInfo(params);
    }

    @Override
    public int updDateManagerInfo(DateManagerVo record) {
        return flightWightInfoUpdMapper.updDateManagerInfo(record);
    }

    @Override
    public int delDateManagerInfo(Map params) {
        return flightWightInfoUpdMapper.delDateManagerInfo(params);
    }

    @Override
    public int insDateManagerInfo(DateManagerVo record) {
        return flightWightInfoUpdMapper.insDateManagerInfo(record);
    }

    @Override
    public List<AirLineVo> findAirLineInfo(Map params) {
        return flightWightInfoUpdMapper.findAirLineInfo(params);
    }

    @Override
    public int updAirLineInfo(AirLineVo record) {
        return flightWightInfoUpdMapper.updAirLineInfo(record);
    }

    @Override
    public int insAirLineInfo(AirLineVo record) {
        return flightWightInfoUpdMapper.insAirLineInfo(record);
    }
}
