package com.hq.acdm.dao.sys;

import com.hq.acdm.vo.sys.TUserActionLogs;
import com.hq.acdm.vo.sys.TUserActionLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserActionLogsMapper {
    int countByExample(TUserActionLogsExample example);

    int deleteByExample(TUserActionLogsExample example);

    int deleteByPrimaryKey(String id);

    int insert(TUserActionLogs record);

    int insertSelective(TUserActionLogs record);

    List<TUserActionLogs> selectByExample(TUserActionLogsExample example);

    TUserActionLogs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TUserActionLogs record, @Param("example") TUserActionLogsExample example);

    int updateByExample(@Param("record") TUserActionLogs record, @Param("example") TUserActionLogsExample example);

    int updateByPrimaryKeySelective(TUserActionLogs record);

    int updateByPrimaryKey(TUserActionLogs record);
}