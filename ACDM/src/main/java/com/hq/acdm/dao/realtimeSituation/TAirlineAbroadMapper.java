package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TAirlineAbroad;
import com.hq.acdm.model.realtimeSituation.TAirlineAbroadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAirlineAbroadMapper {
    int countByExample(TAirlineAbroadExample example);

    int deleteByExample(TAirlineAbroadExample example);

    int deleteByPrimaryKey(String id);

    int insert(TAirlineAbroad record);

    int insertSelective(TAirlineAbroad record);

    List<TAirlineAbroad> selectByExample(TAirlineAbroadExample example);

    TAirlineAbroad selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TAirlineAbroad record, @Param("example") TAirlineAbroadExample example);

    int updateByExample(@Param("record") TAirlineAbroad record, @Param("example") TAirlineAbroadExample example);

    int updateByPrimaryKeySelective(TAirlineAbroad record);

    int updateByPrimaryKey(TAirlineAbroad record);
}