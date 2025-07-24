package com.hq.acdm.dao.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.TEdDynTask;
import com.hq.acdm.vo.coordinatedOprt.TEdDynTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TEdDynTaskMapper {
    int countByExample(TEdDynTaskExample example);

    int deleteByExample(TEdDynTaskExample example);

    int deleteByPrimaryKey(String id);

    int insert(TEdDynTask record);

    int insertSelective(TEdDynTask record);

    List<TEdDynTask> selectByExample(TEdDynTaskExample example);

    TEdDynTask selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TEdDynTask record, @Param("example") TEdDynTaskExample example);

    int updateByExample(@Param("record") TEdDynTask record, @Param("example") TEdDynTaskExample example);

    int updateByPrimaryKeySelective(TEdDynTask record);

    int updateByPrimaryKey(TEdDynTask record);
}