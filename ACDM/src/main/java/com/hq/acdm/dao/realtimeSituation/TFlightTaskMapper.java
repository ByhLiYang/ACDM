package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TFlightTask;
import com.hq.acdm.model.realtimeSituation.TFlightTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFlightTaskMapper {
    int countByExample(TFlightTaskExample example);

    int deleteByExample(TFlightTaskExample example);

    int deleteByPrimaryKey(String id);

    int insert(TFlightTask record);

    int insertSelective(TFlightTask record);

    List<TFlightTask> selectByExample(TFlightTaskExample example);

    TFlightTask selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TFlightTask record, @Param("example") TFlightTaskExample example);

    int updateByExample(@Param("record") TFlightTask record, @Param("example") TFlightTaskExample example);

    int updateByPrimaryKeySelective(TFlightTask record);

    int updateByPrimaryKey(TFlightTask record);
}