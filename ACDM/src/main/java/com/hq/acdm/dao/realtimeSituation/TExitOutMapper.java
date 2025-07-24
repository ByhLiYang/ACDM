package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TExitOut;
import com.hq.acdm.model.realtimeSituation.TExitOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TExitOutMapper {
    int countByExample(TExitOutExample example);

    int deleteByExample(TExitOutExample example);

    int deleteByPrimaryKey(String id);

    int insert(TExitOut record);

    int insertSelective(TExitOut record);

    List<TExitOut> selectByExample(TExitOutExample example);

    TExitOut selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TExitOut record, @Param("example") TExitOutExample example);

    int updateByExample(@Param("record") TExitOut record, @Param("example") TExitOutExample example);

    int updateByPrimaryKeySelective(TExitOut record);

    int updateByPrimaryKey(TExitOut record);
}