package com.hq.acdm.dao.rscMonitors;

import com.hq.acdm.vo.rscMonitors.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/04/29 00:46
 * @Description
 */
public interface DeicingSupervisionMapper {
    List<DeicingWaitVo> findDeicingWait();

    List<DeicingNowVo> findDeicingNow();

    List<DeicingOverVo> findDeicingOver();

    List<DeicingInfoVo> findDeicingInfo();

    int updDeicingFlt(@Param("flag")String flag, @Param("flightId")String flightId);

    int updateDeicingBit(@Param("number")String number);

    int updateDeicingCar(@Param("number")String number);

    List<DeicingEChartVo> findDeicingEChartInfo();

    DeicingResourcesVo findDeicingResourcesData();

    int updateDeicingResourcesData(@Param("params") Map params);

    int findDeicingUseCar();
    //修改预计除冰时间
    int updateECDTEEDT(@Param("params") Map params);

    DeicingRunwayVo findDeicingRunwayData(@Param("params") Map params);

    int updateDeicingRunwayData(@Param("params") Map params);

    int insertDeicingRunwayData(@Param("params") Map params);

    int updateDeicingFluidByFlightId(@Param("params") Map params);

    int insertDeicingFluidByFlightId(@Param("params") Map params);

    DeicingFluidVo selectDeicingFluidByFlightId(@Param("params") Map params);

    List<DeicingCarVo> selectDeicingCarInfo();

    //查询车辆轨迹
    List<TVehicleTracksVo> selectTVehicleTracksInfo(@Param("params") Map params);

    //查询最近车辆号
    List<TVehicleTracksVo> findLatelyVehicleTracks(@Param("params") Map params);

    //查询最近3天每辆除冰车的最后一条定位数据
    List<TVehicleTracksVo> selectTVehicleTracksInfoGroupBy3(@Param("params") Map params);
}
