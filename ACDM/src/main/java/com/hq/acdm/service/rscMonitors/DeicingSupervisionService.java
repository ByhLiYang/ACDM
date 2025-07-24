package com.hq.acdm.service.rscMonitors;

import com.hq.acdm.vo.rscMonitors.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/04/28 16:22
 * @Description
 */
public interface DeicingSupervisionService {

    List<DeicingWaitVo> findDeicingWait();

    List<DeicingNowVo> findDeicingNow();

    List<DeicingOverVo> findDeicingOver();

    List<DeicingInfoVo> findDeicingInfo();

    int updateDeicingFlt(String userId,String flag, String flightId);

    int updateDeicingBit(@Param("number")String number);

    int updateDeicingCar(@Param("number")String number);

    List<DeicingEChartVo> findDeicingEChartInfo();

    String[] findDeicingEChartData();

    DeicingResourcesVo findDeicingResourcesData();

    int updateDeicingResourcesData(@Param("params") Map params);

    int findDeicingUseCar();

    DeicingRunwayVo findDeicingRunwayData(@Param("params") Map params);

    int updateDeicingRunwayData(@Param("params") Map params);

    int insertDeicingRunwayData(@Param("params") Map params);

    int updateDeicingFluidByFlightId(@Param("params") Map params);

    int insertDeicingFluidByFlightId(@Param("params") Map params);

    DeicingFluidVo selectDeicingFluidByFlightId(@Param("params") Map params);

    List<DeicingCarVo> selectDeicingCarInfo();

    List<TVehicleTracksVo> selectTVehicleTracksInfo(@Param("params") Map params);

    //查询最近车辆号
    List<TVehicleTracksVo> findLatelyVehicleTracks(@Param("params") Map params);
    //查询最近3天每辆除冰车的最后一条定位数据
    List<TVehicleTracksVo> selectTVehicleTracksInfoGroupBy3(@Param("params") Map params);
}
