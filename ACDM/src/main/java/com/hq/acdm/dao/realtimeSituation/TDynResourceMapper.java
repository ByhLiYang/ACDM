package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TDynResource;
import com.hq.acdm.model.realtimeSituation.TDynResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDynResourceMapper {
    int countByExample(TDynResourceExample example);

    int deleteByExample(TDynResourceExample example);

    int deleteByPrimaryKey(String id);

    int insert(TDynResource record);

    int insertSelective(TDynResource record);

    List<TDynResource> selectByExample(TDynResourceExample example);

    TDynResource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TDynResource record, @Param("example") TDynResourceExample example);

    int updateByExample(@Param("record") TDynResource record, @Param("example") TDynResourceExample example);

    int updateByPrimaryKeySelective(TDynResource record);

    int updateByPrimaryKey(TDynResource record);
}