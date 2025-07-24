package com.hq.acdm.service.realtimeSituation.impl;

import com.hq.acdm.dao.realtimeSituation.SpecialSafeguardMapper;
import com.hq.acdm.dao.realtimeSituation.TMdrsMapper;
import com.hq.acdm.service.realtimeSituation.SpecialSafeguardService;
import com.hq.acdm.vo.realtimeSituation.SpecialSafeguardVo;
import org.apache.ibatis.annotations.Param;
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
public class SpecialSafeguardServiceImpl implements SpecialSafeguardService {

    @Resource
    private SpecialSafeguardMapper specialSafeguardMapper;
    @Resource
    private TMdrsMapper tMdrsMapper;

    //获取特殊航班信息
    @Override
    public List<SpecialSafeguardVo> findSpecialFltInfo(Map params){
        return specialSafeguardMapper.findSpecialFltInfo(params);
    }

    //查询流控信息（T_MDRS表信息）
    public List<String> findTMdrsInfo(@Param("params") Map params){
       return tMdrsMapper.findTMdrsInfo(params);
    }

    @Override
    public List<String> findFlightCaveatInfo(Map params) {
        return specialSafeguardMapper.findFlightCaveatInfo(params);
    }
}
