package com.hq.acdm.service.ADSB;

import com.hq.acdm.model.ADSB.ADSBModel;
import com.sun.org.apache.xerces.internal.impl.xs.opti.SchemaParsingConfig;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 18:34
 */
public interface ADSBService {
    List<ADSBModel> queryADSB();
    int insertADSBSHA(ADSBModel adsbModel);
    int insertADSBOTHERS(ADSBModel adsbModel);
    int deleteADSBDATA(ADSBModel adsbModel);
    List<ADSBModel> queryADSBOTHERSisExist(ADSBModel adsbModel);
    List<ADSBModel> queryADSBSHAisExist(ADSBModel adsbModel);
    int insertADSBDATA(ADSBModel adsbModel);
    int deleteADSBOTHERS(ADSBModel adsbModel);
    int deleteADSBSHA(ADSBModel adsbModel);
    List<ADSBModel> queryADSBSHA();
    List<ADSBModel> queryADSBOTHERS();
    List<ADSBModel> queryADSBDATAisExist(ADSBModel adsbModel);
    List<ADSBModel> query5minutesData();
    List<ADSBModel> queryOneAdsb(Map<String,Object> map);
}
