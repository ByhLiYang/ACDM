package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TFlightStatus;
import com.hq.acdm.model.realtimeSituation.TFlightStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFlightStatusMapper {
    int countByExample(TFlightStatusExample example);

    int deleteByExample(TFlightStatusExample example);

    int deleteByPrimaryKey(String id);

    int insert(TFlightStatus record);

    int insertSelective(TFlightStatus record);

    List<TFlightStatus> selectByExample(TFlightStatusExample example);

    TFlightStatus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TFlightStatus record, @Param("example") TFlightStatusExample example);

    int updateByExample(@Param("record") TFlightStatus record, @Param("example") TFlightStatusExample example);

    int updateByPrimaryKeySelective(TFlightStatus record);

    int updateByPrimaryKey(TFlightStatus record);
}