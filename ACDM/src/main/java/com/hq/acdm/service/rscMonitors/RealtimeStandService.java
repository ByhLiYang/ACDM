package com.hq.acdm.service.rscMonitors;

import com.hq.acdm.vo.rscMonitors.BaseStand;
import com.hq.acdm.vo.rscMonitors.StandStatusVo;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2019/04/28 16:22
 * @Description
 */
public interface RealtimeStandService {
    List<StandStatusVo> findStandInfo();
    int findJWZS();
    int findBKYS();
    int findJRTC();
    int findGYHB();
    List<BaseStand> findBaseStand();
    int findJJWZS();
    int findYJWZS();
}
