package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TOndutyInfo;
import com.hq.acdm.model.realtimeSituation.TOndutyInfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TOndutyInfoMapper {
    int countByExample(TOndutyInfoExample example);

    int deleteByExample(TOndutyInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TOndutyInfo record);

    int insertSelective(TOndutyInfo record);

    List<TOndutyInfo> selectByExample(TOndutyInfoExample example);

    TOndutyInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TOndutyInfo record, @Param("example") TOndutyInfoExample example);

    int updateByExample(@Param("record") TOndutyInfo record, @Param("example") TOndutyInfoExample example);

    int updateByPrimaryKeySelective(TOndutyInfo record);

    int updateByPrimaryKey(TOndutyInfo record);

    TOndutyInfo findTOndutyInfo(@Param("params") Map params);

    int updateByOrgIdAndOndutyDate(@Param("params") Map params);
}