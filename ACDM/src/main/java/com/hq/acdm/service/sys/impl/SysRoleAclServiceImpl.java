package com.hq.acdm.service.sys.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.hq.acdm.common.RequestHolder;
import com.hq.acdm.dao.sys.SysRoleAclMapper;
import com.hq.acdm.model.sys.SysRoleAcl;
import com.hq.acdm.service.sys.ISysRoleAclService;
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
@Service("sysRoleAclService")
public class SysRoleAclServiceImpl implements ISysRoleAclService {

    @Resource
    private SysRoleAclMapper sysRoleAclMapper;

    @Override
    public void changeRoleAcls(Integer roleId, String resourceIds) {
        List<Integer> aclIdList = StringUtil.splitToListInt(resourceIds);
        List<Integer> originAclIdList = sysRoleAclMapper.getAclIdListByRoleIdList(Lists.newArrayList(roleId));
        if (originAclIdList.size() == aclIdList.size()) {
            Set<Integer> originAclIdSet = Sets.newHashSet(originAclIdList);
            Set<Integer> aclIdSet = Sets.newHashSet(aclIdList);
            originAclIdSet.removeAll(aclIdSet);
            if (CollectionUtils.isEmpty(originAclIdSet)) {
                return;
            }
        }
        updateRoleAcls(roleId, aclIdList);
    }

    @Transactional
    public void updateRoleAcls(int roleId, List<Integer> aclIdList) {
        sysRoleAclMapper.deleteByRoleId(roleId);

        if (CollectionUtils.isEmpty(aclIdList)) {
            return;
        }
        List<SysRoleAcl> roleAclList = Lists.newArrayList();
        for(Integer aclId : aclIdList) {
            SysRoleAcl roleAcl = SysRoleAcl.builder().roleId(roleId).aclId(aclId).operator(RequestHolder.getCurrentUser().getUsername())
                    .operateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest())).operateTime(new Date()).build();
            roleAclList.add(roleAcl);
        }
        sysRoleAclMapper.batchInsert(roleAclList);
    }

}
