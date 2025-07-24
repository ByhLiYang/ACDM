package com.hq.acdm.service.dynamicFlight;

import com.hq.acdm.vo.dynamicFlight.FlightInfoVo;
import com.hq.acdm.vo.dynamicFlight.FlightInquiryVo;
import com.hq.acdm.vo.dynamicFlight.PresetFieldCXVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface FltSearchService {

    //获取所有航班列表
    public List<FlightInfoVo> findAllFltInfo(@Param("params") Map params);
    //首页传参查询航班列表
    public List<FlightInfoVo> findIndexFltDetailInfo(@Param("params") Map params);
    //航班查询预设字段查询
    List<PresetFieldCXVo> findPresetFieldCX(@Param("params") Map params);
    //航班查询预设字段存储
    int insertPresetFieldCX(@Param("params") Map params);
    //以航班ID查询单个航班
    String findCOBTByID(String flightId);
    //以航班ID查询单个航班
    String findFLNOByID(String flightId);
    //航班查询
    public List<FlightInquiryVo> selectAllFlightInfo(@Param("params") Map params);

}
