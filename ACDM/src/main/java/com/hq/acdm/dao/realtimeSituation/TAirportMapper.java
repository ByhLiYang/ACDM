package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TAirport;
import com.hq.acdm.model.realtimeSituation.TAirportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAirportMapper {
    int countByExample(TAirportExample example);

    int deleteByExample(TAirportExample example);

    int deleteByPrimaryKey(String id);

    int insert(TAirport record);

    int insertSelective(TAirport record);

    List<TAirport> selectByExample(TAirportExample example);

    TAirport selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TAirport record, @Param("example") TAirportExample example);

    int updateByExample(@Param("record") TAirport record, @Param("example") TAirportExample example);

    int updateByPrimaryKeySelective(TAirport record);

    int updateByPrimaryKey(TAirport record);
}