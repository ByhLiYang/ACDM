package com.hq.acdm.service.sys.impl;

import com.google.common.collect.Lists;
import com.hq.acdm.beans.CacheKeyConstants;
import com.hq.acdm.common.Const;
import com.hq.acdm.common.RequestHolder;
import com.hq.acdm.dao.sys.SysAclMapper;
import com.hq.acdm.dao.sys.SysRoleAclMapper;
import com.hq.acdm.dao.sys.SysRoleUserMapper;
import com.hq.acdm.enums.sys.RoleEnum;
import com.hq.acdm.model.sys.SysAcl;
import com.hq.acdm.model.sys.SysRole;
import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.service.sys.ISysCoreService;
import com.hq.acdm.service.sys.ISysRoleService;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.util.PropertiesUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Service("sysCoreService")
public class SysCoreServiceImpl implements ISysCoreService {

    @Resource
    private SysAclMapper sysAclMapper;
    @Resource
    private SysRoleUserMapper sysRoleUserMapper;
    @Resource
    private SysRoleAclMapper sysRoleAclMapper;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private ISysRoleService sysRoleService;

    @Override
    public List<SysAcl> getCurrentUserAclList() {
        int userId = RequestHolder.getCurrentUser().getId();
        return getUserAclList(userId);
    }

    @Override
    public List<SysAcl> getRoleAclList(int roleId) {
        List<Integer> aclIdList = sysRoleAclMapper.getAclIdListByRoleIdList(Lists.<Integer>newArrayList(roleId));
        if (CollectionUtils.isEmpty(aclIdList)) {
            return Lists.newArrayList();
        }
        return sysAclMapper.getByIdList(aclIdList);
    }

    @Override
    public List<SysAcl> getUserAclList(int userId) {
        if (isSuperAdmin()) {
            return sysAclMapper.getAll();
        }
        List<Integer> userRoleIdList = sysRoleUserMapper.getRoleIdListByUserId(userId);
        if (CollectionUtils.isEmpty(userRoleIdList)) {
            return Lists.newArrayList();
        }
        List<Integer> userAclIdList = sysRoleAclMapper.getAclIdListByRoleIdList(userRoleIdList);
        if (CollectionUtils.isEmpty(userAclIdList)) {
            return Lists.newArrayList();
        }
        return sysAclMapper.getByIdList(userAclIdList);
    }

    public boolean isSuperAdmin() {
        // 自定义超级管理员规则，实际中要根据项目进行修改
        // 可以是配置文件获取，可以指定某个用户，也可以指定某个角色
        SysUser sysUser = RequestHolder.getCurrentUser();
        if (PropertiesUtil.getProperty("super_manager").equals(sysUser.getUsername())) {
            return true;
        }
/*        //普通管理员也返回true
        List<SysRole> roleList = sysRoleService.getRoleListByUserId(sysUser.getId());
        for (SysRole role : roleList) {
            if (RoleEnum.MANAGER.getCode().equals(role.getType())) {
                return true;
            }
        }*/

        return false;
    }

    @Override
    public boolean hasUrlAcl(String url) {
        if (isSuperAdmin()) {
            return true;
        }
        List<SysAcl> aclList = sysAclMapper.getByUrl(url);
        if (CollectionUtils.isEmpty(aclList)) {
            return true;
        }

        List<SysAcl> userAclList = getCurrentUserAclListFromCache();
        Set<Integer> userAclIdSet = new HashSet<>();
        for (SysAcl sysAcl : userAclList) {
            userAclIdSet.add(sysAcl.getId());
        }
        boolean hasValidAcl = false;
        // 规则：只要有一个权限点有权限，那么我们就认为有访问权限
        for (SysAcl acl : aclList) {
            // 判断一个用户是否具有某个权限点的访问权限
            // 权限点无效
            if (acl == null || acl.getStatus() != 1) {
                continue;
            }
            hasValidAcl = true;
            if (userAclIdSet.contains(acl.getId())) {
                return true;
            }
        }
        if (!hasValidAcl) {
            return true;
        }
        return false;
    }

    public List<SysAcl> getCurrentUserAclListFromCache() {
        int userId = RequestHolder.getCurrentUser().getId();
        String cacheValue = sysCacheService.getFromCache(CacheKeyConstants.USER_ACLS+"_"+String.valueOf(userId));
        if (StringUtils.isBlank(cacheValue)) {
            List<SysAcl> aclList = getCurrentUserAclList();
            if (CollectionUtils.isNotEmpty(aclList)) {
                sysCacheService.saveCache(JsonMapper.obj2String(aclList), Const.RedisCacheExtime.REDIS_ACLS_EXTIME, CacheKeyConstants.USER_ACLS+"_"+String.valueOf(userId));
            }
            return aclList;
        }
        return JsonMapper.string2Obj(cacheValue, new TypeReference<List<SysAcl>>() {
        });
    }
}
