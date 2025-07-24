package com.hq.acdm.dao.dynamicFlight;

import com.hq.acdm.vo.dynamicFlight.FlightInfoVo;
import com.hq.acdm.vo.dynamicFlight.FlightInquiryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:38
 * @Description
 */
public interface FltSearchMapper {
    //查询所有航班列表
    List<FlightInfoVo> findAllFltInfo(@Param("params") Map params);
    //首页传参查询航班列表
    List<FlightInfoVo> findIndexFltDetailInfo(@Param("params") Map params);
    String findCOBTByID(@Param("flightId")String flightId);
    String findFLNOByID(@Param("flightId")String flightId);
    //航班查询
    public List<FlightInquiryVo> selectAllFlightInfo(@Param("params") Map params);
}
