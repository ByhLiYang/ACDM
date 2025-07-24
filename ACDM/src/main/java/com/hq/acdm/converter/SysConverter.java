package com.hq.acdm.converter;

import com.google.common.collect.Lists;
import com.hq.acdm.model.sys.SysAclModule;
import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.param.sys.AclModuleParam;
import com.hq.acdm.param.sys.UserParam;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/28 0028
 * @Description:
 */
public class SysConverter {

    public static SysAclModule AclModuleParam2SysAclModule(AclModuleParam param) {
        SysAclModule module = new SysAclModule();

        BeanUtils.copyProperties(param, module);

        if (param.getParentId() == null) {
            module.setParentId(0);
        }
        module.setSeq(param.getSort());
        module.setStatus(param.getIsShow());
        module.setRemark(param.getDesc());
        return  module;
    }

    public static List<UserParam> SysUser2UserParam(List<SysUser> userList) {
        List<UserParam> paramList = Lists.newArrayList();

        for (SysUser param : userList) {
            UserParam user = new UserParam();
            BeanUtils.copyProperties(param, user);

            user.setNickName(param.getUsername());
            user.setPhone(param.getTelephone());
            user.setEmail(param.getMail());
            user.setRemarks(param.getRemark());

            paramList.add(user);
        }
        return  paramList;
    }

    public static UserParam SysUser2UserParam(SysUser param) {
            UserParam user = new UserParam();
            BeanUtils.copyProperties(param, user);

            user.setNickName(param.getUsername());
            user.setPhone(param.getTelephone());
            user.setEmail(param.getMail());
            user.setRemarks(param.getRemark());

        return  user;
    }
}
