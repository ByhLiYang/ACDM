package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TCheckCounter;
import com.hq.acdm.model.realtimeSituation.TCheckCounterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCheckCounterMapper {
    int countByExample(TCheckCounterExample example);

    int deleteByExample(TCheckCounterExample example);

    int deleteByPrimaryKey(String id);

    int insert(TCheckCounter record);

    int insertSelective(TCheckCounter record);

    List<TCheckCounter> selectByExample(TCheckCounterExample example);

    TCheckCounter selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TCheckCounter record, @Param("example") TCheckCounterExample example);

    int updateByExample(@Param("record") TCheckCounter record, @Param("example") TCheckCounterExample example);

    int updateByPrimaryKeySelective(TCheckCounter record);

    int updateByPrimaryKey(TCheckCounter record);
}