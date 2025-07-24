package com.hq.acdm.service.dynamicFlight;

import com.hq.acdm.model.realtimeSituation.TMultiDatasourceRecord;
import com.hq.acdm.model.realtimeSituation.TMultiDatasourceRecordExample;
import com.hq.acdm.vo.dynamicFlight.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface FltMonitorService {
    /**
     * 获取所有航班公司
     * @return
     */
    public List<String> findAllCompany();
    //获取所有航班列表
    public List<TLocalFlightInfoVo> findFltInfo(@Param("params")Map params);
    //获取延误航班列表
    public List<TLocalFlightInfoVo> findDelayFltInfo(@Param("params")Map params);
    //根据航班唯一标识查询所有对应的流控信息
    public List<TControlInfoVo> findAllControlInfo(@Param("params") Map params);
    //航班详细信息
    public List<FlightDetailsInfoVo> findFlightDetails(@Param("params") Map params);
    //航班详细信息
    public List<FlightDetailsGuestInfoVo> findFlightPassenger(@Param("params") Map params);
    //航班鱼骨图详细信息
    Map<String,Object> findFishboneDiagramInfo(@Param("params") Map params);
    //鱼骨图节点对应字段信息
    List<FishboneDiagramVo> findNodeConfigColumnInfo();
    //航班事件查询
    FlightEventReturnVo findFlightEvent(@Param("params") Map params);
    //航班监控预设字段查询
    List<PresetFieldJKVo> findPresetFieldJK(@Param("params") Map params);
    //保存预设字段
    int insertPresetFieldJK(@Param("params") Map params);
    //查询鱼骨图过站保障数据
    List<Map<String,Object>> findFishboneDiagramData(@Param("list") List<String> list,@Param("params") Map params);
    //查询鱼骨图信息返回前台数据
    List<FishboneDiagramVo> findFishboneDiagramInfoByFlightId(@Param("params") Map params);
    //查询流控信息
    List<FlowControlVo> findTControlInfoByFlightId(@Param("params") Map params);
    //修改TOBT
    public int updateTobt(@Param("params") Map params);
    //修改TOBT同时更新T_MULTI_DATASOURCE_RECORD表（优先级历史数据表）
    public int updateTMultiDatasourceRecord(TMultiDatasourceRecord record);
    //修改鱼骨图节点数据
    int updateFishboneDiagramNodeInfo(@Param("params") Map params);
    //新增记录
    int insertTlocalForprivate(@Param("params") Map params);
    //根据流控信息查询受影响航班信息
    List<FlightFlowControlVo> findFlightByFlowControlId(@Param("params") Map params);

    //根据航班号，日期查询行李
    XlVo findXl(@Param("params") Map params);

    //根据航班id查询旅客流程
    LKVo selectTotalBoardingPaxCount(@Param("paxflightno")String paxflightno);
}
