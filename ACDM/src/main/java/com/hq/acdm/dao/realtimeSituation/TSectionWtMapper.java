package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TSectionWt;
import com.hq.acdm.model.realtimeSituation.TSectionWtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSectionWtMapper {
    int countByExample(TSectionWtExample example);

    int deleteByExample(TSectionWtExample example);

    int deleteByPrimaryKey(String id);

    int insert(TSectionWt record);

    int insertSelective(TSectionWt record);

    List<TSectionWt> selectByExample(TSectionWtExample example);

    TSectionWt selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TSectionWt record, @Param("example") TSectionWtExample example);

    int updateByExample(@Param("record") TSectionWt record, @Param("example") TSectionWtExample example);

    int updateByPrimaryKeySelective(TSectionWt record);

    int updateByPrimaryKey(TSectionWt record);

    List<TSectionWt> selectAllTSectionWt();
}