package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TFlightEvent;
import com.hq.acdm.model.realtimeSituation.TFlightEventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFlightEventMapper {
    int countByExample(TFlightEventExample example);

    int deleteByExample(TFlightEventExample example);

    int deleteByPrimaryKey(String id);

    int insert(TFlightEvent record);

    int insertSelective(TFlightEvent record);

    List<TFlightEvent> selectByExample(TFlightEventExample example);

    TFlightEvent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TFlightEvent record, @Param("example") TFlightEventExample example);

    int updateByExample(@Param("record") TFlightEvent record, @Param("example") TFlightEventExample example);

    int updateByPrimaryKeySelective(TFlightEvent record);

    int updateByPrimaryKey(TFlightEvent record);
}