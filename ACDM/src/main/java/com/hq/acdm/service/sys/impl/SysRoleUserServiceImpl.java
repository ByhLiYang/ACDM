package com.hq.acdm.service.sys.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.hq.acdm.common.RequestHolder;
import com.hq.acdm.dao.sys.SysRoleUserMapper;
import com.hq.acdm.dao.sys.SysUserMapper;
import com.hq.acdm.model.sys.SysRoleUser;
import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.service.sys.ISysRoleUserService;
import com.hq.acdm.util.IpUtil;
import com.hq.acdm.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Service("sysRoleUserService")
public class SysRoleUserServiceImpl implements ISysRoleUserService {

    @Resource
    private SysRoleUserMapper sysRoleUserMapper;
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getListByRoleId(int roleId) {
        List<Integer> userIdList = sysRoleUserMapper.getUserIdListByRoleId(roleId);
        if (CollectionUtils.isEmpty(userIdList)) {
            return Lists.newArrayList();
        }
        return sysUserMapper.getByIdList(userIdList);
    }

    @Override
    public void changeRoleUsers(int userId, String roleIds) {
        List<Integer> roleIdList = StringUtil.splitToListInt(roleIds);
        List<Integer> originRoleIdList = sysRoleUserMapper.getRoleIdListByUserId(userId);
        if (originRoleIdList.size() == roleIdList.size()) {
            Set<Integer> originUserIdSet = Sets.newHashSet(originRoleIdList);
            Set<Integer> userIdSet = Sets.newHashSet(roleIdList);
            originUserIdSet.removeAll(userIdSet);
            if (CollectionUtils.isEmpty(originUserIdSet)) {
                return;
            }
        }
        updateRoleUsers(userId, roleIdList);
    }

    @Transactional
    private void updateRoleUsers(int userId, List<Integer> roleIdList) {
        sysRoleUserMapper.deleteByRoleId(userId);

        if (CollectionUtils.isEmpty(roleIdList)) {
            return;
        }
        List<SysRoleUser> roleUserList = Lists.newArrayList();
        for (Integer roleId : roleIdList) {
            SysRoleUser roleUser = SysRoleUser.builder().roleId(roleId).userId(userId).operator(RequestHolder.getCurrentUser().getUsername())
                    .operateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest())).operateTime(new Date()).build();
            roleUserList.add(roleUser);
        }
        sysRoleUserMapper.batchInsert(roleUserList);
    }

}
