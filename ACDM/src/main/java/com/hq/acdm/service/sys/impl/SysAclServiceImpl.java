package com.hq.acdm.service.sys.impl;

import com.google.common.base.Preconditions;
import com.hq.acdm.common.RequestHolder;
import com.hq.acdm.dao.sys.SysAclMapper;
import com.hq.acdm.exception.ParamException;
import com.hq.acdm.model.sys.SysAcl;
import com.hq.acdm.param.sys.AclParam;
import com.hq.acdm.service.sys.ISysAclService;
import com.hq.acdm.util.BeanValidator;
import com.hq.acdm.util.IpUtil;
import com.hq.acdm.util.LevelUtil;
import com.hq.acdm.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Service("sysAclService")
public class SysAclServiceImpl implements ISysAclService {

    @Resource
    private SysAclMapper sysAclMapper;

    @Override
    public void save(AclParam param) {
        param.setParentId(null == param.getParentId() ? 0 : param.getParentId());
        BeanValidator.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("当前权限模块下面存在相同名称的权限点");
        }
        SysAcl acl = SysAcl.builder().name(param.getName()).aclModuleId(param.getParentId()).url(param.getCode())
                .type(param.getType()).status(param.getUsable()).seq(param.getSort()).remark(param.getRemarks()).build();
        //code字段用作权限层级
        acl.setCode(LevelUtil.calculateLevel(getLevel(param.getParentId()), param.getParentId()));
        acl.setOperator(RequestHolder.getCurrentUser().getUsername());
        acl.setOperateTime(new Date());
        acl.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));

        sysAclMapper.insertSelective(acl);

    }

    @Override
    public void update(AclParam param) {
        param.setParentId(null == param.getParentId() ? 0 : param.getParentId());
        BeanValidator.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("当前权限模块下面存在相同名称的权限点");
        }
        SysAcl before = sysAclMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before, "待更新的权限点不存在");

        SysAcl after = SysAcl.builder().name(param.getName()).aclModuleId(param.getParentId()).url(param.getCode())
                .type(param.getType()).status(param.getUsable()).seq(param.getSort()).remark(param.getRemarks()).id(param.getId()).build();
        after.setCode(LevelUtil.calculateLevel(getLevel(param.getParentId()), param.getParentId()));
        after.setOperator(RequestHolder.getCurrentUser().getUsername());
        after.setOperateTime(new Date());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));

        sysAclMapper.updateByPrimaryKeySelective(after);
    }

    @Override
    public void delete(String resourceIds) {
        List<Integer> idList = StringUtil.splitToListInt(resourceIds);
        for (Integer id : idList) {
            sysAclMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<SysAcl> getByAclModuleId(int aclModuleId) {
        return sysAclMapper.getByAclModuleId(aclModuleId);
    }

    public boolean checkExist(int aclModuleId, String name, Integer id) {
        return sysAclMapper.countByNameAndAclModuleId(aclModuleId, name, id) > 0;
    }

    public String generateCode() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(new Date()) + "_" + (int)(Math.random() * 100);
    }

    private String getLevel(Integer aclId) {
        SysAcl acl = sysAclMapper.selectByPrimaryKey(aclId);
        if (acl == null) {
            return null;
        }
        return acl.getCode();
    }
}
