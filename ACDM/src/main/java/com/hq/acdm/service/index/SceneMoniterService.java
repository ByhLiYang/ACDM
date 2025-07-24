package com.hq.acdm.service.index;

import com.hq.acdm.vo.index.FlightFulInfoVo;
import com.hq.acdm.vo.index.SceneMoniterVo;
import com.hq.acdm.vo.index.StandStatusVo;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/11/18 16:16
 * @Description
 */
public interface SceneMoniterService {
    SceneMoniterVo getSceneMoniter();
    FlightFulInfoVo findFlightFullInfo(String flight_no_iata, String a_or_d);
    List<StandStatusVo> findOccupyStand();
}
