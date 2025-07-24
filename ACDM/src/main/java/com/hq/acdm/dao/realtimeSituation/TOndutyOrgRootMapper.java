package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TOndutyOrgRoot;
import com.hq.acdm.model.realtimeSituation.TOndutyOrgRootExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOndutyOrgRootMapper {
    int countByExample(TOndutyOrgRootExample example);

    int deleteByExample(TOndutyOrgRootExample example);

    int deleteByPrimaryKey(String id);

    int insert(TOndutyOrgRoot record);

    int insertSelective(TOndutyOrgRoot record);

    List<TOndutyOrgRoot> selectByExample(TOndutyOrgRootExample example);

    TOndutyOrgRoot selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TOndutyOrgRoot record, @Param("example") TOndutyOrgRootExample example);

    int updateByExample(@Param("record") TOndutyOrgRoot record, @Param("example") TOndutyOrgRootExample example);

    int updateByPrimaryKeySelective(TOndutyOrgRoot record);

    int updateByPrimaryKey(TOndutyOrgRoot record);
}