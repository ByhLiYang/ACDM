package com.hq.acdm.dao.dynamicFlight;

import com.hq.acdm.vo.dynamicFlight.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:38
 * @Description
 */
public interface FltMonitorMapper {
    //tony add 查询所有航班列表
    List<TLocalFlightInfoVo> getFltInfo(@Param("params") Map params);
    //获取延误航班列表
    List<TLocalFlightInfoVo> findDelayFltInfo(@Param("params")Map params);
    //查询航空公司列表
    List<String> findAllCompany();
    //根据航班唯一标识查询所有对应的流控信息
    List<TControlInfoVo> findAllControlInfo(@Param("params") Map params);
    //航班详细信息
    List<FlightDetailsInfoVo> findFlightDetails(@Param("params") Map params);
    //航班旅客信息
    List<FlightDetailsGuestInfoVo> findFlightPassenger(@Param("params") Map params);
    //航班鱼骨图详细信息
    Map<String,Object> findFishboneDiagramInfo(@Param("params") Map params);
    //鱼骨图节点对应字段信息
    List<FishboneDiagramVo> findNodeConfigColumnInfo();
    //航班事件查询
    List<FlightEventVo> findFlightEvent(@Param("params") Map params);
    //查询鱼骨图过站保障数据
    List<Map<String,Object>> findFishboneDiagramData(@Param("list") List<String> list,@Param("params") Map params);
    //查询流控信息
    List<FlowControlVo> findTControlInfoByFlightId(@Param("params") Map params);
    //根据航班ID号修改TOBT
    public int updateTobt(@Param("params") Map params);
    //修改鱼骨图节点数据
    int updateFishboneDiagramNodeInfo(@Param("params") Map params);
    //新增记录
    int insertTlocalForprivate(@Param("params") Map params);
    //根据流控信息查询受影响航班信息
    List<FlightFlowControlVo> findFlightByFlowControlId(@Param("params") Map params);

    //根据航班号，日期查询行李
    XlVo findXl(@Param("params") Map params);

    //根据航班id查询旅客流程
    @Select("SELECT  sum(case when (dpsrCheckinTime is not null )" +
            "       then 1 else 0 end) zjLK,MIN(dpsrCheckinTime) zjLKS,MAX(dpsrCheckinTime) zjLKEND," +
            "    sum(case when (stsPscTime is not null ) " +
            "       then 1 else 0 end) ajLK,MIN(stsPscTime)  ajLKS,MAX(stsPscTime)  ajLKEND," +
            "    sum(case when (stsPscTime is not null and stsBoardTime is null) " +
            "       then 1 else 0 end) hj,MIN(stsPscTime) hjS,MAX(stsBoardTime) hjEND," +
            "    sum(case when ( stsBoardTime is not null) " +
            "     then 1 else 0 end) dj,MIN(stsBoardTime) djS,MAX(stsBoardTime) djEND" +
            "   FROM T_PASSENGER_INFO WHERE  flightId = #{paxflightno}")
    LKVo selectTotalBoardingPaxCount(@Param("paxflightno")String paxflightno);
}
