package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TOndutyOrg;
import com.hq.acdm.model.realtimeSituation.TOndutyOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOndutyOrgMapper {
    int countByExample(TOndutyOrgExample example);

    int deleteByExample(TOndutyOrgExample example);

    int deleteByPrimaryKey(String id);

    int insert(TOndutyOrg record);

    int insertSelective(TOndutyOrg record);

    List<TOndutyOrg> selectByExample(TOndutyOrgExample example);

    TOndutyOrg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TOndutyOrg record, @Param("example") TOndutyOrgExample example);

    int updateByExample(@Param("record") TOndutyOrg record, @Param("example") TOndutyOrgExample example);

    int updateByPrimaryKeySelective(TOndutyOrg record);

    int updateByPrimaryKey(TOndutyOrg record);
}