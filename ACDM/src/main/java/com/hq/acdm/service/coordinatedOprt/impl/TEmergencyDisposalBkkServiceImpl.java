package com.hq.acdm.service.coordinatedOprt.impl;


import com.hq.acdm.dao.coordinatedOprt.TEmergencyDisposalBkkMapper;
import com.hq.acdm.service.coordinatedOprt.TEmergencyDisposalBkkService;
import com.hq.acdm.vo.coordinatedOprt.TEmergencyDisposalBkkVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class TEmergencyDisposalBkkServiceImpl implements TEmergencyDisposalBkkService {

    @Resource
    private TEmergencyDisposalBkkMapper tEmergencyDisposalBkkMapper;


    @Override
    public List<TEmergencyDisposalBkkVo> findTEmergencyDisposalBkk(Map params) {
        return tEmergencyDisposalBkkMapper.findTEmergencyDisposalBkk(params);
    }


}
