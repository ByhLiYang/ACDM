package com.hq.acdm.service.sys;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
public interface ISysRoleAclService {

    void changeRoleAcls(Integer roleId, String resourceIds);
}
