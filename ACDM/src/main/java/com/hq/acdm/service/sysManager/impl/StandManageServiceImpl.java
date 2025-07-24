package com.hq.acdm.service.sysManager.impl;

import com.hq.acdm.dao.sysManager.TAreaStandToAtcMapper;
import com.hq.acdm.model.sys.TAreaStandToAtc;
import com.hq.acdm.service.sysManager.StandManageService;
import com.hq.acdm.vo.sysManager.AltStandVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2021/10/20 11:44
 * @Description
 */
@Service
public class StandManageServiceImpl implements StandManageService {

    @Resource
    private TAreaStandToAtcMapper tAreaStandToAtcMapper;

    @Override
    public List<TAreaStandToAtc> findStandBaseInfo(Map params) {
        return tAreaStandToAtcMapper.findStandBaseInfo(params);
    }

    @Override
    public int updStandBaseInfo(TAreaStandToAtc record) {
        return tAreaStandToAtcMapper.updStandBaseInfo(record);
    }

    @Override
    public int insStandBaseInfo(TAreaStandToAtc record) {
        return tAreaStandToAtcMapper.insStandBaseInfo(record);
    }

    @Override
    public int updRTNStand(AltStandVo record) {
        return tAreaStandToAtcMapper.updRTNStand(record);
    }

    @Override
    public AltStandVo selectRTNStand() {
        return tAreaStandToAtcMapper.selectRTNStand();
    }
}
