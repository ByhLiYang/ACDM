package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TDynTask;
import com.hq.acdm.model.realtimeSituation.TDynTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDynTaskMapper {
    int countByExample(TDynTaskExample example);

    int deleteByExample(TDynTaskExample example);

    int deleteByPrimaryKey(String id);

    int insert(TDynTask record);

    int insertSelective(TDynTask record);

    List<TDynTask> selectByExample(TDynTaskExample example);

    TDynTask selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TDynTask record, @Param("example") TDynTaskExample example);

    int updateByExample(@Param("record") TDynTask record, @Param("example") TDynTaskExample example);

    int updateByPrimaryKeySelective(TDynTask record);

    int updateByPrimaryKey(TDynTask record);
}