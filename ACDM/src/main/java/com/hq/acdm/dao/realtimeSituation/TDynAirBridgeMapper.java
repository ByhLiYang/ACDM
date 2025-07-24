package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TDynAirBridge;
import com.hq.acdm.model.realtimeSituation.TDynAirBridgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDynAirBridgeMapper {
    int countByExample(TDynAirBridgeExample example);

    int deleteByExample(TDynAirBridgeExample example);

    int deleteByPrimaryKey(String id);

    int insert(TDynAirBridge record);

    int insertSelective(TDynAirBridge record);

    List<TDynAirBridge> selectByExample(TDynAirBridgeExample example);

    TDynAirBridge selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TDynAirBridge record, @Param("example") TDynAirBridgeExample example);

    int updateByExample(@Param("record") TDynAirBridge record, @Param("example") TDynAirBridgeExample example);

    int updateByPrimaryKeySelective(TDynAirBridge record);

    int updateByPrimaryKey(TDynAirBridge record);
}