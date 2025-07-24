package com.hq.acdm.dao.ADSB;

import com.hq.acdm.model.ADSB.ADSBModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 18:33
 */
public interface ADSBMapper {
    List<ADSBModel> queryADSB();
    int insertADSBSHA(ADSBModel adsbModel);
    int insertADSBOTHERS(ADSBModel adsbModel);
    int deleteADSBDATA(ADSBModel adsbModel);
    int insertADSBDATA(ADSBModel adsbModel);
    int deleteADSBOTHERS(ADSBModel adsbModel);
    int deleteADSBSHA(ADSBModel adsbModel);
    List<ADSBModel> queryADSBOTHERSisExist(ADSBModel adsbModel);
    List<ADSBModel> queryADSBSHAisExist(ADSBModel adsbModel);
    List<ADSBModel> queryADSBSHA();
    List<ADSBModel> queryADSBOTHERS();
    List<ADSBModel> queryADSBDATAisExist(ADSBModel adsbModel);
    List<ADSBModel> query5minutesData();
    List<ADSBModel> queryOneAdsb(@Param("params") Map<String,Object> map);
}
