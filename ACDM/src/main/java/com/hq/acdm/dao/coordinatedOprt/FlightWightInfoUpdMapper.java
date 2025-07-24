package com.hq.acdm.dao.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface FlightWightInfoUpdMapper {

    List<FlightWightInfoUpdVo> findFligthInfo(@Param("params") Map params);

    int updateFltGoodsMailBagBookingWight(@Param("params") Map params);

    int updateFltHisGoodsMailBagBookingWight(@Param("params") Map params);

    List<InterFaceVo> findInterfaceInfo(@Param("params") Map params);

    List<DateManagerVo> findDateManagerInfo(@Param("params") Map params);

    int updDateManagerInfo(DateManagerVo record);

    int delDateManagerInfo(@Param("params") Map params);

    int insDateManagerInfo(DateManagerVo record);

    List<AirLineVo> findAirLineInfo(@Param("params") Map params);

    int updAirLineInfo(AirLineVo record);

    int insAirLineInfo(AirLineVo record);
}
