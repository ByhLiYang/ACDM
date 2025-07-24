package com.hq.acdm.service.ADSB.impl;

import com.hq.acdm.dao.ADSB.ADSBMapper;
import com.hq.acdm.model.ADSB.ADSBModel;
import com.hq.acdm.service.ADSB.ADSBService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 18:35
 */
@Service("ADSBService")
public class ADSBServiceImpl implements ADSBService{
    @Resource
    private ADSBMapper adsbMapper;
    @Override
    public List<ADSBModel> queryADSB() {
        return adsbMapper.queryADSB();
    }

    @Override
    public int insertADSBSHA(ADSBModel adsbModel) {
        return adsbMapper.insertADSBSHA(adsbModel);
    }

    @Override
    public int insertADSBOTHERS(ADSBModel adsbModel) {
        return adsbMapper.insertADSBOTHERS(adsbModel);
    }

    @Override
    public int deleteADSBDATA(ADSBModel adsbModel) {
        return adsbMapper.deleteADSBDATA(adsbModel);
    }

    @Override
    public List<ADSBModel> queryADSBOTHERSisExist(ADSBModel adsbModel) {
        return adsbMapper.queryADSBOTHERSisExist(adsbModel);
    }

    @Override
    public List<ADSBModel> queryADSBSHAisExist(ADSBModel adsbModel) {
        return adsbMapper.queryADSBSHAisExist(adsbModel);
    }

    @Override
    public int insertADSBDATA(ADSBModel adsbModel) {
        return adsbMapper.insertADSBDATA(adsbModel);
    }

    @Override
    public int deleteADSBOTHERS(ADSBModel adsbModel) {
        return adsbMapper.deleteADSBOTHERS(adsbModel);
    }

    @Override
    public int deleteADSBSHA(ADSBModel adsbModel) {
        return adsbMapper.deleteADSBSHA(adsbModel);
    }

    @Override
    public List<ADSBModel> queryADSBSHA() {
        return adsbMapper.queryADSBSHA();
    }

    @Override
    public List<ADSBModel> queryADSBOTHERS() {
        return adsbMapper.queryADSBOTHERS();
    }

    @Override
    public List<ADSBModel> queryADSBDATAisExist(ADSBModel adsbModel) {
        return adsbMapper.queryADSBDATAisExist(adsbModel);
    }

    @Override
    public List<ADSBModel> query5minutesData() {
        return adsbMapper.query5minutesData();
    }

    @Override
    public List<ADSBModel> queryOneAdsb(Map<String,Object> map) {
        return adsbMapper.queryOneAdsb(map);
    }
}
