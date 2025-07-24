package com.hq.acdm.service.sys;

import com.hq.acdm.param.sys.AclModuleParam;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
public interface ISysAclModuleService {
    /**
     * 新增权限模块
     * @param param
     */
    void save(AclModuleParam param);

    /**
     * 更新权限模块
     * @param param
     */
    void update(AclModuleParam param);

    /**
     * 删除权限模块
     * @param menuIds
     */
    void delete(String menuIds);
}
