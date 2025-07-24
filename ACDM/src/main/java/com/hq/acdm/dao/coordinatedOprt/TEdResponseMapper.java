package com.hq.acdm.dao.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.TEdResponse;
import com.hq.acdm.vo.coordinatedOprt.TEdResponseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TEdResponseMapper {
    int countByExample(TEdResponseExample example);

    int deleteByExample(TEdResponseExample example);

    int deleteByPrimaryKey(String id);

    int insert(TEdResponse record);

    int insertSelective(TEdResponse record);

    List<TEdResponse> selectByExample(TEdResponseExample example);

    TEdResponse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TEdResponse record, @Param("example") TEdResponseExample example);

    int updateByExample(@Param("record") TEdResponse record, @Param("example") TEdResponseExample example);

    int updateByPrimaryKeySelective(TEdResponse record);

    int updateByPrimaryKey(TEdResponse record);
}