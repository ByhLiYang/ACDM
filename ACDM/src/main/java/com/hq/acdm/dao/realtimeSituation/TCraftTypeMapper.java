package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TCraftType;
import com.hq.acdm.model.realtimeSituation.TCraftTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCraftTypeMapper {
    int countByExample(TCraftTypeExample example);

    int deleteByExample(TCraftTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(TCraftType record);

    int insertSelective(TCraftType record);

    List<TCraftType> selectByExample(TCraftTypeExample example);

    TCraftType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TCraftType record, @Param("example") TCraftTypeExample example);

    int updateByExample(@Param("record") TCraftType record, @Param("example") TCraftTypeExample example);

    int updateByPrimaryKeySelective(TCraftType record);

    int updateByPrimaryKey(TCraftType record);
}