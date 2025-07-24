package com.hq.acdm.service.realtimeSituation.impl;

import com.hq.acdm.dao.realtimeSituation.TSpecialInfoMapper;
import com.hq.acdm.model.realtimeSituation.TSpecialInfo;
import com.hq.acdm.vo.realtimeSituation.SpecialSituationVo;
import com.hq.acdm.service.realtimeSituation.SpecialSituationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class SpecialSituationServiceImpl implements SpecialSituationService {

    @Resource
    private TSpecialInfoMapper tSpecialInfoMapper;

    @Override
    public List<SpecialSituationVo> findByTSpecialInfo(Map params){
        return tSpecialInfoMapper.findByTSpecialInfo(params);
    }
    @Override
    public int insert(TSpecialInfo record){
        return tSpecialInfoMapper.insert(record);
    }
    @Override
    public int updateByPrimaryKey(TSpecialInfo record){
        return tSpecialInfoMapper.updateByPrimaryKey(record);
    }
    @Override
    public int deleteByPrimaryKey(String id){
        return tSpecialInfoMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List<TSpecialInfo> findAllTSpecialInfo(Map params){
        return tSpecialInfoMapper.findAllTSpecialInfo(params);
    }

    @Override
    public List<SpecialSituationVo> findByTNoticeOfConstructionInfo(Map params) {
        return tSpecialInfoMapper.findByTNoticeOfConstructionInfo(params);
    }

    @Override
    public List<SpecialSituationVo> findByTNoticeOfGroundingInfo(Map params) {
        return tSpecialInfoMapper.findByTNoticeOfGroundingInfo(params);
    }

    @Override
    public List<SpecialSituationVo> findByTMdrsInfo(Map params) {
        return tSpecialInfoMapper.findByTMdrsInfo(params);
    }

    @Override
    public List<SpecialSituationVo> findByTControlInfoInfo(Map params) {
        return tSpecialInfoMapper.findByTControlInfoInfo(params);
    }
}
