package com.hq.acdm.dao.sys;

import com.hq.acdm.model.sys.Users;
import com.hq.acdm.model.sys.UsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface  UsersMapper {
    int countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(String userId);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(String userId);

    Users selectByUsername(String username);

    String findDepartment(String userId);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    int updateUserPassword(Users record);
}