package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TAirCraft;
import com.hq.acdm.model.realtimeSituation.TAirCraftExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAirCraftMapper {
    int countByExample(TAirCraftExample example);

    int deleteByExample(TAirCraftExample example);

    int deleteByPrimaryKey(String id);

    int insert(TAirCraft record);

    int insertSelective(TAirCraft record);

    List<TAirCraft> selectByExample(TAirCraftExample example);

    TAirCraft selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TAirCraft record, @Param("example") TAirCraftExample example);

    int updateByExample(@Param("record") TAirCraft record, @Param("example") TAirCraftExample example);

    int updateByPrimaryKeySelective(TAirCraft record);

    int updateByPrimaryKey(TAirCraft record);
}