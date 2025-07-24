package com.hq.acdm.common;

import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.util.PropertiesUtil;

/**
 * @Author lizhifeng
 * @Date 2018/8/29 0029
 * @Description:
 */
public class SysManager {
    public static boolean isSuperAdmin() {
        // 自定义超级管理员规则，实际中要根据项目进行修改
        // 可以是配置文件获取，可以指定某个用户，也可以指定某个角色
        SysUser sysUser = RequestHolder.getCurrentUser();
        if (null!=sysUser&&PropertiesUtil.getProperty("super_manager").equals(sysUser.getUsername())) {
            return true;
        }
        return false;
    }
}
