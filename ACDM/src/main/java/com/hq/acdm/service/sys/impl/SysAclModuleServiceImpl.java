package com.hq.acdm.service.sys.impl;

import com.google.common.base.Preconditions;
import com.hq.acdm.common.RequestHolder;
import com.hq.acdm.converter.SysConverter;
import com.hq.acdm.dao.sys.SysAclMapper;
import com.hq.acdm.dao.sys.SysAclModuleMapper;
import com.hq.acdm.exception.ParamException;
import com.hq.acdm.model.sys.SysAclModule;
import com.hq.acdm.param.sys.AclModuleParam;
import com.hq.acdm.service.sys.ISysAclModuleService;
import com.hq.acdm.util.BeanValidator;
import com.hq.acdm.util.IpUtil;
import com.hq.acdm.util.LevelUtil;
import com.hq.acdm.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Service("sysAclModuleService")
public class SysAclModuleServiceImpl implements ISysAclModuleService {

    @Resource
    private SysAclModuleMapper sysAclModuleMapper;
    @Resource
    private SysAclMapper sysAclMapper;

    @Override
    public void save(AclModuleParam param) {
        BeanValidator.check(param);
        if(checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一层级下存在相同名称的菜单模块");
        }
        SysAclModule aclModule = SysConverter.AclModuleParam2SysAclModule(param);
        aclModule.setModuleLevel(LevelUtil.calculateLevel(getLevel(aclModule.getParentId()), aclModule.getParentId()));
        aclModule.setOperator(RequestHolder.getCurrentUser().getUsername());
        aclModule.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        aclModule.setOperateTime(new Date());
        sysAclModuleMapper.insertSelective(aclModule);
    }

    @Override
    public void update(AclModuleParam param) {
        BeanValidator.check(param);
        if(checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一层级下存在相同名称的菜单模块");
        }
        SysAclModule before = sysAclModuleMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before, "待更新的菜单模块不存在");

        SysAclModule after = SysConverter.AclModuleParam2SysAclModule(param);
        after.setModuleLevel(LevelUtil.calculateLevel(getLevel(after.getParentId()), after.getParentId()));
        after.setOperator(RequestHolder.getCurrentUser().getUsername());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setOperateTime(new Date());

        updateWithChild(before, after);
    }

    @Override
    public void delete(String menuIds) {
        List<Integer> idList = StringUtil.splitToListInt(menuIds);
        for (Integer id : idList) {
            sysAclModuleMapper.deleteByPrimaryKey(id);
        }
    }

    @Transactional
    private void updateWithChild(SysAclModule before, SysAclModule after) {
        String newLevelPrefix = after.getModuleLevel();
        String oldLevelPrefix = before.getModuleLevel();
        if (!after.getModuleLevel().equals(before.getModuleLevel())) {
            List<SysAclModule> aclModuleList = sysAclModuleMapper.getChildAclModuleListByLevel(before.getModuleLevel());
            if (CollectionUtils.isNotEmpty(aclModuleList)) {
                for (SysAclModule aclModule : aclModuleList) {
                    String level = aclModule.getModuleLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        aclModule.setModuleLevel(level);
                    }
                }
                sysAclModuleMapper.batchUpdateLevel(aclModuleList);
            }
        }
        sysAclModuleMapper.updateByPrimaryKeySelective(after);
    }

    private boolean checkExist(Integer parentId, String aclModuleName, Integer deptId) {
        return sysAclModuleMapper.countByNameAndParentId(parentId, aclModuleName, deptId) > 0;
    }

    private String getLevel(Integer aclModuleId) {
        SysAclModule aclModule = sysAclModuleMapper.selectByPrimaryKey(aclModuleId);
        if (aclModule == null) {
            return null;
        }
        return aclModule.getModuleLevel();
    }

}
