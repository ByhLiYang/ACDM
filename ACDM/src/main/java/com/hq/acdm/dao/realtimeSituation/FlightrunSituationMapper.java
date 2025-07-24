package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TRunwayMode;
import com.hq.acdm.vo.realtimeSituation.FlightIndexRunwayVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface FlightrunSituationMapper {
    /**查询飞行区运行情况跑道运行模式信息
     * @param params
     * @return
     */
    List<TRunwayMode> findRunwayModeInfo(@Param("params") Map params);
    //修改跑道信息
    int updateRunway(TRunwayMode recod);
    //修改航班跑道信息
    int updateRunwayD(TRunwayMode recod);
    //修改航班跑道信息
    int updateRunwayA(TRunwayMode recod);

    FlightIndexRunwayVo findRunwayAllInfo();

    int updateRunwayAllInfo(@Param("params") Map params);
}
