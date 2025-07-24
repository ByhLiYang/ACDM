package com.hq.acdm.dao.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.TEdWarning;
import com.hq.acdm.vo.coordinatedOprt.TEdWarningExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TEdWarningMapper {
    int countByExample(TEdWarningExample example);

    int deleteByExample(TEdWarningExample example);

    int deleteByPrimaryKey(String id);

    int insert(TEdWarning record);

    int insertSelective(TEdWarning record);

    List<TEdWarning> selectByExample(TEdWarningExample example);

    TEdWarning selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TEdWarning record, @Param("example") TEdWarningExample example);

    int updateByExample(@Param("record") TEdWarning record, @Param("example") TEdWarningExample example);

    int updateByPrimaryKeySelective(TEdWarning record);

    int updateByPrimaryKey(TEdWarning record);
}