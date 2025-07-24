package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TDelayCoordination;
import com.hq.acdm.model.realtimeSituation.TDelayCoordinationExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TDelayCoordinationMapper {
    int countByExample(TDelayCoordinationExample example);

    int deleteByExample(TDelayCoordinationExample example);

    int deleteByPrimaryKey(String id);

    int insert(TDelayCoordination record);

    int insertSelective(TDelayCoordination record);

    List<TDelayCoordination> selectByExample(TDelayCoordinationExample example);

    TDelayCoordination selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TDelayCoordination record, @Param("example") TDelayCoordinationExample example);

    int updateByExample(@Param("record") TDelayCoordination record, @Param("example") TDelayCoordinationExample example);

    int updateByPrimaryKeySelective(TDelayCoordination record);

    int updateByPrimaryKey(TDelayCoordination record);

    List<TDelayCoordination> selectByFlightId(String flightId);

    String getIsCoordination(String flightId);
    String getFlightTm(String flightId);
    //航班取消协调
    int updateTDelayCoordinationState(@Param("params") Map params);
}