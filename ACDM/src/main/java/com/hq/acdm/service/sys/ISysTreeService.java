package com.hq.acdm.service.sys;

import com.hq.acdm.dto.sys.AclModuleLevelDto;
import com.hq.acdm.dto.sys.RoleDto;
import com.hq.acdm.vo.sys.AclListVo;
import com.hq.acdm.vo.sys.MenuListVo;
import com.hq.acdm.vo.sys.RoleListVo;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
public interface ISysTreeService {

    List<AclModuleLevelDto> userAclTree(int userId);

    List<RoleListVo> roleTree();

    List<MenuListVo> aclModuleTree();

    List<AclListVo> aclTree();

    List<AclModuleLevelDto> userAclModuleTree();

//    List<RoleDto> roleListTree();
}
