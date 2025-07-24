package com.hq.acdm.dao.sys;

import com.hq.acdm.model.sys.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> getAll();

    int countByName(@Param("parentId") Integer parentId, @Param("name") String name, @Param("id") Integer id);

    List<SysRole> getByIdList(@Param("idList") List<Integer> idList);

    List<SysRole> getByLevel(@Param("level") String level);
}