package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TCraftSite;
import com.hq.acdm.model.realtimeSituation.TCraftSiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCraftSiteMapper {
    int countByExample(TCraftSiteExample example);

    int deleteByExample(TCraftSiteExample example);

    int deleteByPrimaryKey(String id);

    int insert(TCraftSite record);

    int insertSelective(TCraftSite record);

    List<TCraftSite> selectByExample(TCraftSiteExample example);

    TCraftSite selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TCraftSite record, @Param("example") TCraftSiteExample example);

    int updateByExample(@Param("record") TCraftSite record, @Param("example") TCraftSiteExample example);

    int updateByPrimaryKeySelective(TCraftSite record);

    int updateByPrimaryKey(TCraftSite record);
}