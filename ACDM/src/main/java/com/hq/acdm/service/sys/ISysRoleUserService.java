package com.hq.acdm.service.sys;

import com.hq.acdm.model.sys.SysUser;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
public interface ISysRoleUserService {

    List<SysUser> getListByRoleId(int roleId);

    void changeRoleUsers(int userId, String roleIds);
}
