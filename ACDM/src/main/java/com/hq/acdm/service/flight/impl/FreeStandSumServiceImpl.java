package com.hq.acdm.service.flight.impl;

import com.hq.acdm.dao.flight.FreeStandSumMapper;
import com.hq.acdm.model.flight.FreeStandSum;
//import com.hq.acdm.model.flight.VCCTV;
import com.hq.acdm.service.flight.FreeStandSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service("freeStandSumService")
public class FreeStandSumServiceImpl implements FreeStandSumService {
    @Autowired
    FreeStandSumMapper freeStandSumMapper;

    public static final String BEGIN_DATE = "beginDate";
    public static final String END_DATE = "endDate";
    public static final String IS_REMOTE = "isRemote"; //机位类型 : 近机位--N；远机位--Y
    public static final String AIRPORTTYPE = "airporttype"; //机型
    public static final String TERMINAL = "terminal";//航站楼

    @Override
    public List<FreeStandSum> query(Map params) {
        //Example example = new Example(FreeStandSum.class);
        //return freeStandSumMapper.selecFreeStandSum(beginDate,endDate);

        return freeStandSumMapper.selecFreeStandSum(params);
    }
}
