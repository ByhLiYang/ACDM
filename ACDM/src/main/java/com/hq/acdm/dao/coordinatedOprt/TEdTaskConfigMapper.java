package com.hq.acdm.dao.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.TEdTaskConfig;
import com.hq.acdm.vo.coordinatedOprt.TEdTaskConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TEdTaskConfigMapper {
    int countByExample(TEdTaskConfigExample example);

    int deleteByExample(TEdTaskConfigExample example);

    int deleteByPrimaryKey(String id);

    int insert(TEdTaskConfig record);

    int insertSelective(TEdTaskConfig record);

    List<TEdTaskConfig> selectByExample(TEdTaskConfigExample example);

    TEdTaskConfig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TEdTaskConfig record, @Param("example") TEdTaskConfigExample example);

    int updateByExample(@Param("record") TEdTaskConfig record, @Param("example") TEdTaskConfigExample example);

    int updateByPrimaryKeySelective(TEdTaskConfig record);

    int updateByPrimaryKey(TEdTaskConfig record);
}