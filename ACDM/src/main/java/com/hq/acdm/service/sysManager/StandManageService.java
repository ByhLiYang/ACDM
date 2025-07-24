package com.hq.acdm.service.sysManager;

import com.hq.acdm.model.sys.TAreaStandToAtc;
import com.hq.acdm.vo.sysManager.AltStandVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2021/10/20 11:43
 * @Description
 */
public interface StandManageService {

    List<TAreaStandToAtc> findStandBaseInfo(@Param("params") Map params);

    int updStandBaseInfo(TAreaStandToAtc record);

    int insStandBaseInfo(TAreaStandToAtc record);

    int updRTNStand(AltStandVo record);

    AltStandVo selectRTNStand();
}
