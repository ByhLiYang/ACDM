package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TCounterType;
import com.hq.acdm.model.realtimeSituation.TCounterTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCounterTypeMapper {
    int countByExample(TCounterTypeExample example);

    int deleteByExample(TCounterTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(TCounterType record);

    int insertSelective(TCounterType record);

    List<TCounterType> selectByExample(TCounterTypeExample example);

    TCounterType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TCounterType record, @Param("example") TCounterTypeExample example);

    int updateByExample(@Param("record") TCounterType record, @Param("example") TCounterTypeExample example);

    int updateByPrimaryKeySelective(TCounterType record);

    int updateByPrimaryKey(TCounterType record);
}