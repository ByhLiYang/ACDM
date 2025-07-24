package com.hq.acdm.service.realtimeSituation.impl;

import com.hq.acdm.dao.realtimeSituation.TIgoHotelStandardFeeMapper;
import com.hq.acdm.model.realtimeSituation.TIgoHotelStandardFee;
import com.hq.acdm.service.realtimeSituation.TIgoHotelStandardFeeService;

import com.hq.acdm.vo.realtimeSituation.TIgoHotelStandardFeeVO;
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
public class TIgoHotelStandardFeeServiceImpl implements TIgoHotelStandardFeeService {

    @Resource
    private TIgoHotelStandardFeeMapper tIgoHotelStandardFeeMapper;


    @Override
    public int insert(TIgoHotelStandardFee record){
        return tIgoHotelStandardFeeMapper.insert(record);
    }
    @Override
    public int updateByPrimaryKey(TIgoHotelStandardFee record){
        return tIgoHotelStandardFeeMapper.updateByPrimaryKey(record);
    }
    @Override
    public int deleteByPrimaryKey(String id){
        return tIgoHotelStandardFeeMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List<TIgoHotelStandardFeeVO> findAllTSpecialInfo(Map params){
        return tIgoHotelStandardFeeMapper.findAllTSpecialInfo(params);
    }


}
