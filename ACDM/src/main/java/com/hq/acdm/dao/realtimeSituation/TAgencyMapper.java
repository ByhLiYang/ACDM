package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TAgency;
import com.hq.acdm.model.realtimeSituation.TAgencyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAgencyMapper {
    int countByExample(TAgencyExample example);

    int deleteByExample(TAgencyExample example);

    int deleteByPrimaryKey(String id);

    int insert(TAgency record);

    int insertSelective(TAgency record);

    List<TAgency> selectByExample(TAgencyExample example);

    TAgency selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TAgency record, @Param("example") TAgencyExample example);

    int updateByExample(@Param("record") TAgency record, @Param("example") TAgencyExample example);

    int updateByPrimaryKeySelective(TAgency record);

    int updateByPrimaryKey(TAgency record);
}