package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TAirBirdge;
import com.hq.acdm.model.realtimeSituation.TAirBirdgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAirBirdgeMapper {
    int countByExample(TAirBirdgeExample example);

    int deleteByExample(TAirBirdgeExample example);

    int deleteByPrimaryKey(String id);

    int insert(TAirBirdge record);

    int insertSelective(TAirBirdge record);

    List<TAirBirdge> selectByExample(TAirBirdgeExample example);

    TAirBirdge selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TAirBirdge record, @Param("example") TAirBirdgeExample example);

    int updateByExample(@Param("record") TAirBirdge record, @Param("example") TAirBirdgeExample example);

    int updateByPrimaryKeySelective(TAirBirdge record);

    int updateByPrimaryKey(TAirBirdge record);
}