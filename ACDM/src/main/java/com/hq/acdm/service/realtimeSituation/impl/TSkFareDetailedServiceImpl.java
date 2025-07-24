package com.hq.acdm.service.realtimeSituation.impl;

import com.hq.acdm.dao.realtimeSituation.TIgoHotelStandardFeeMapper;
import com.hq.acdm.dao.realtimeSituation.TSkFareDetailedMapper;
import com.hq.acdm.model.realtimeSituation.TIgoHotelStandardFee;
import com.hq.acdm.model.realtimeSituation.TSkFareDetailed;
import com.hq.acdm.service.realtimeSituation.TIgoHotelStandardFeeService;
import com.hq.acdm.service.realtimeSituation.TSkFareDetailedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class TSkFareDetailedServiceImpl implements TSkFareDetailedService {

    @Resource
    private TSkFareDetailedMapper tSkFareDetailedMapper;


    @Override
    public int insert(TSkFareDetailed record){
        return tSkFareDetailedMapper.insert(record);
    }
    @Override
    public int updateByPrimaryKey(TSkFareDetailed record){
        return tSkFareDetailedMapper.updateByPrimaryKey(record);
    }
    @Override
    public int deleteByPrimaryKey(String id){
        return tSkFareDetailedMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List<TSkFareDetailed> findAllTSpecialInfo(Map params){
        return tSkFareDetailedMapper.findAllTSpecialInfo(params);
    }


}
