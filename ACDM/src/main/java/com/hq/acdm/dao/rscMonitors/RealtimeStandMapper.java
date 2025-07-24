package com.hq.acdm.dao.rscMonitors;

import com.hq.acdm.vo.rscMonitors.BaseStand;
import com.hq.acdm.vo.rscMonitors.StandVo;
import com.hq.acdm.vo.rscMonitors.StandVo2;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2019/04/29 00:46
 * @Description
 */
public interface RealtimeStandMapper {
    List<StandVo> getStandInfo();
    List<StandVo2> getStandInfo2();
    int getJWZS();
    int getBKYS();
    int getJRTC();
    int getGYHB();
    List<BaseStand> getBaseStand();
    int getJJWZS();
    int getYJWZS();
}
