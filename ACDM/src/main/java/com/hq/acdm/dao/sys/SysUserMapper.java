package com.hq.acdm.dao.sys;

import com.hq.acdm.beans.PageQuery;
import com.hq.acdm.model.sys.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    int updatePassword(@Param("username") String username, @Param("newPassword") String newPassword);

    int updateStatus(@Param("userId") String userId, @Param("status") String status);

    SysUser findByKeyword(@Param("keyword") String keyword);

    int countByUserName(@Param("username") String username, @Param("id") Integer id);

    int countByDeptId(@Param("deptId") int deptId);

    List<SysUser> getByPageList(@Param("key") String key, @Param("superManager") String superManager);

    List<SysUser> getByIdList(@Param("idList") List<Integer> idList);

    List<SysUser> getAll();
}