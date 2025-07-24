package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TSchedulingNoticeInfo;
import com.hq.acdm.model.realtimeSituation.TSchedulingNoticeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSchedulingNoticeInfoMapper {
    int countByExample(TSchedulingNoticeInfoExample example);

    int deleteByExample(TSchedulingNoticeInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TSchedulingNoticeInfo record);

    int insertSelective(TSchedulingNoticeInfo record);

    List<TSchedulingNoticeInfo> selectByExample(TSchedulingNoticeInfoExample example);

    TSchedulingNoticeInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TSchedulingNoticeInfo record, @Param("example") TSchedulingNoticeInfoExample example);

    int updateByExample(@Param("record") TSchedulingNoticeInfo record, @Param("example") TSchedulingNoticeInfoExample example);

    int updateByPrimaryKeySelective(TSchedulingNoticeInfo record);

    int updateByPrimaryKey(TSchedulingNoticeInfo record);
}