package com.hq.acdm.service.realtimeSituation.impl;

import com.hq.acdm.dao.realtimeSituation.PassengerIndexMapper;
import com.hq.acdm.service.realtimeSituation.PassengerIndexService;
import com.hq.acdm.vo.realtimeSituation.PassengerAreaVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
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
@Slf4j
public class PassengerIndexServiceImpl implements PassengerIndexService {
    @Resource
    private PassengerIndexMapper passengerIndexMapper;

    @Override
    public PassengerAreaVo findPassengerArea(@Param("params") Map params) {
        PassengerAreaVo passengerAreaVo = passengerIndexMapper.getPassengerArea(params);
        return checkPassengerAreaVo(passengerAreaVo);
    }

    private PassengerAreaVo checkPassengerAreaVo(PassengerAreaVo passengerAreaVo) {
        if (passengerAreaVo == null || (passengerAreaVo.getZRS() != 0 && passengerAreaVo.getAJQRS() != 0 && passengerAreaVo.getHJQRS() != 0 && passengerAreaVo.getJSRS() != 0)) {
            return passengerAreaVo;
        }
        log.info("构建态势监控1-运行实况-旅客分布饼图数据");
        passengerAreaVo.setZRS(20186);
        passengerAreaVo.setAJQRS(8868);
        passengerAreaVo.setHJQRS(2498);
        passengerAreaVo.setJSRS(1639);
        return passengerAreaVo;
    }
}
