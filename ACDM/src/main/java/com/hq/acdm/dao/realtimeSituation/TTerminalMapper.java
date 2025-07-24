package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TTerminal;
import com.hq.acdm.model.realtimeSituation.TTerminalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTerminalMapper {
    int countByExample(TTerminalExample example);

    int deleteByExample(TTerminalExample example);

    int deleteByPrimaryKey(String id);

    int insert(TTerminal record);

    int insertSelective(TTerminal record);

    List<TTerminal> selectByExample(TTerminalExample example);

    TTerminal selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TTerminal record, @Param("example") TTerminalExample example);

    int updateByExample(@Param("record") TTerminal record, @Param("example") TTerminalExample example);

    int updateByPrimaryKeySelective(TTerminal record);

    int updateByPrimaryKey(TTerminal record);
}