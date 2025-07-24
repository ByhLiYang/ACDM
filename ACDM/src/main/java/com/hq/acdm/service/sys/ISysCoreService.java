package com.hq.acdm.service.sys;

import com.hq.acdm.model.sys.SysAcl;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
public interface ISysCoreService {

    List<SysAcl> getCurrentUserAclList();

    List<SysAcl> getRoleAclList(int roleId);

    List<SysAcl> getUserAclList(int userId);

    boolean hasUrlAcl(String url);
}
