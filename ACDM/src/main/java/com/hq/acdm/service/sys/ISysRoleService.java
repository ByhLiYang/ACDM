package com.hq.acdm.service.sys;

import com.hq.acdm.model.sys.SysRole;
import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.param.sys.role.RoleParam;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/21 0021
 * @Description:
 */
public interface ISysRoleService {

    void save(RoleParam param);

    void update(RoleParam param);

    void delete(String roleIds);

    List<Integer> get(String id);

    List<SysRole> getAll();

    List<SysRole> getRoleListByUserId(int userId);

    List<SysRole> getRoleListByAclId(int aclId);

    List<SysUser> getUserListByRoleList(List<SysRole> roleList);
}
