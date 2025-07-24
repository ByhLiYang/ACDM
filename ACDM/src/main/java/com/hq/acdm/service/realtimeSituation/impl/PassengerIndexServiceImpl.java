package com.hq.acdm.service.realtimeSituation.impl;

import com.hq.acdm.dao.realtimeSituation.PassengerIndexMapper;
import com.hq.acdm.service.realtimeSituation.PassengerIndexService;
import com.hq.acdm.vo.realtimeSituation.PassengerAreaVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/31 23:30
 * @Description
 */
@Service
public class PassengerIndexServiceImpl implements PassengerIndexService {
    @Resource
    private PassengerIndexMapper passengerIndexMapper;
    @Override
    public PassengerAreaVo findPassengerArea(@Param("params") Map params) {
        return passengerIndexMapper.getPassengerArea(params);
    }
}
