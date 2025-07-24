package com.hq.acdm.service.sys.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.hq.acdm.common.RequestHolder;
import com.hq.acdm.dao.sys.SysRoleAclMapper;
import com.hq.acdm.dao.sys.SysRoleMapper;
import com.hq.acdm.dao.sys.SysRoleUserMapper;
import com.hq.acdm.dao.sys.SysUserMapper;
import com.hq.acdm.exception.ParamException;
import com.hq.acdm.model.sys.SysRole;
import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.param.sys.role.RoleParam;
import com.hq.acdm.service.sys.ISysRoleService;
import com.hq.acdm.util.BeanValidator;
import com.hq.acdm.util.IpUtil;
import com.hq.acdm.util.LevelUtil;
import com.hq.acdm.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements ISysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysRoleUserMapper sysRoleUserMapper;
    @Resource
    private SysRoleAclMapper sysRoleAclMapper;
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public void save(RoleParam param) {
        param.setParentId(null == param.getParentId() ? 0 : param.getParentId());

        BeanValidator.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("角色名称已经存在");
        }
        SysRole role = SysRole.builder().name(param.getName()).usable(param.getUsable()).enName(param.getEnName()).parentId(param.getParentId())
                .remarks(param.getRemarks()).sort(param.getSort()).build();
        role.setRoleLevel(LevelUtil.calculateLevel(getLevel(role.getParentId()), role.getParentId()));
        role.setOperator(RequestHolder.getCurrentUser().getUsername());
        role.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        role.setOperateTime(new Date());
        sysRoleMapper.insertSelective(role);
    }

    @Override
    public void update(RoleParam param) {
        param.setParentId(null == param.getParentId() ? 0 : param.getParentId());
        BeanValidator.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("角色名称已经存在");
        }
        SysRole before = sysRoleMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before, "待更新的角色不存在");

        SysRole after = SysRole.builder().name(param.getName()).usable(param.getUsable()).enName(param.getEnName()).parentId(param.getParentId())
                .remarks(param.getRemarks()).sort(param.getSort()).id(param.getId()).build();
        after.setRoleLevel(LevelUtil.calculateLevel(getLevel(after.getParentId()), after.getParentId()));
        after.setOperator(RequestHolder.getCurrentUser().getUsername());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setOperateTime(new Date());
        sysRoleMapper.updateByPrimaryKeySelective(after);
    }

    @Override
    public List<SysRole> getAll() {
        return sysRoleMapper.getAll();
    }

    private boolean checkExist(Integer parentId, String name, Integer id) {
        return sysRoleMapper.countByName(parentId, name, id) > 0;
    }

    @Override
    public List<SysRole> getRoleListByUserId(int userId) {
        List<Integer> roleIdList = sysRoleUserMapper.getRoleIdListByUserId(userId);
        if (CollectionUtils.isEmpty(roleIdList)) {
            return Lists.newArrayList();
        }
        return sysRoleMapper.getByIdList(roleIdList);
    }

    @Override
    public List<SysRole> getRoleListByAclId(int aclId) {
        List<Integer> roleIdList = sysRoleAclMapper.getRoleIdListByAclId(aclId);
        if (CollectionUtils.isEmpty(roleIdList)) {
            return Lists.newArrayList();
        }
        return sysRoleMapper.getByIdList(roleIdList);
    }

    @Override
    public List<SysUser> getUserListByRoleList(List<SysRole> roleList) {
        if (CollectionUtils.isEmpty(roleList)) {
            return Lists.newArrayList();
        }
        List<Integer> roleIdList = new ArrayList<>();
        for (SysRole sysAcl : roleList) {
            roleIdList.add(sysAcl.getId());
        }
        List<Integer> userIdList = sysRoleUserMapper.getUserIdListByRoleIdList(roleIdList);
        if (CollectionUtils.isEmpty(userIdList)) {
            return Lists.newArrayList();
        }
        return sysUserMapper.getByIdList(userIdList);
    }

    @Transactional
    @Override
    public void delete(String roleIds) {
        List<Integer> idList = StringUtil.splitToListInt(roleIds);
        for (Integer id : idList) {
            sysRoleMapper.deleteByPrimaryKey(id);

            sysRoleUserMapper.deleteByRoleId(id);

            sysRoleAclMapper.deleteByRoleId(id);
        }

    }

    @Override
    public List<Integer> get(String id) {
        List<Integer> list =  Lists.newArrayList();
        list.add(Integer.parseInt(id));
        return sysRoleAclMapper.getAclIdListByRoleIdList(list);
    }

    private String getLevel(Integer roleId) {
        SysRole role = sysRoleMapper.selectByPrimaryKey(roleId);
        if (role == null) {
            return null;
        }
        return role.getRoleLevel();
    }
}
