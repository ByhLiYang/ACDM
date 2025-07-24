package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TAirline;
import com.hq.acdm.model.realtimeSituation.TAirlineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAirlineMapper {
    int countByExample(TAirlineExample example);

    int deleteByExample(TAirlineExample example);

    int deleteByPrimaryKey(String id);

    int insert(TAirline record);

    int insertSelective(TAirline record);

    List<TAirline> selectByExample(TAirlineExample example);

    TAirline selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TAirline record, @Param("example") TAirlineExample example);

    int updateByExample(@Param("record") TAirline record, @Param("example") TAirlineExample example);

    int updateByPrimaryKeySelective(TAirline record);

    int updateByPrimaryKey(TAirline record);
}