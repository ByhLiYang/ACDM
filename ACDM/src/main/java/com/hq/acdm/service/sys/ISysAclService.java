package com.hq.acdm.service.sys;

import com.hq.acdm.model.sys.SysAcl;
import com.hq.acdm.param.sys.AclParam;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/21 0021
 * @Description:
 */
public interface ISysAclService {

    /**
     * 新增权限
     * @param param
     */
    void save(AclParam param);

    /**
     * 修改权限
     * @param param
     */
    void update(AclParam param);

    /**
     * 删除权限
     * @param resourceIds
     */
    void delete(String resourceIds);

    /**
     * 根据模块ID获取权限列表
     * @param aclModuleId
     * @return
     */
    List<SysAcl> getByAclModuleId(int aclModuleId);
}
