package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TBelt;
import com.hq.acdm.model.realtimeSituation.TBeltExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBeltMapper {
    int countByExample(TBeltExample example);

    int deleteByExample(TBeltExample example);

    int deleteByPrimaryKey(String id);

    int insert(TBelt record);

    int insertSelective(TBelt record);

    List<TBelt> selectByExample(TBeltExample example);

    TBelt selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TBelt record, @Param("example") TBeltExample example);

    int updateByExample(@Param("record") TBelt record, @Param("example") TBeltExample example);

    int updateByPrimaryKeySelective(TBelt record);

    int updateByPrimaryKey(TBelt record);
}