package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TMdrs;
import com.hq.acdm.model.realtimeSituation.TMdrsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TMdrsMapper {
    int countByExample(TMdrsExample example);

    int deleteByExample(TMdrsExample example);

    int deleteByPrimaryKey(String id);

    int insert(TMdrs record);

    int insertSelective(TMdrs record);

    List<TMdrs> selectByExample(TMdrsExample example);

    TMdrs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TMdrs record, @Param("example") TMdrsExample example);

    int updateByExample(@Param("record") TMdrs record, @Param("example") TMdrsExample example);

    int updateByPrimaryKeySelective(TMdrs record);

    int updateByPrimaryKey(TMdrs record);

    //查询流控信息（T_MDRS表信息）
    List<String> findTMdrsInfo(@Param("params") Map params);
}