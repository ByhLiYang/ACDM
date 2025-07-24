package com.hq.acdm.service.sys.impl;

//import ch.qos.logback.core.net.SyslogOutputStream;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.hq.acdm.common.RequestHolder;
import com.hq.acdm.common.SysManager;
import com.hq.acdm.dao.sys.*;
import com.hq.acdm.dto.sys.AclDto;
import com.hq.acdm.dto.sys.AclModuleLevelDto;
import com.hq.acdm.dto.sys.RoleDto;
import com.hq.acdm.model.sys.SysAcl;
import com.hq.acdm.model.sys.SysAclModule;
import com.hq.acdm.model.sys.SysRole;
import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.service.sys.ISysTreeService;
import com.hq.acdm.util.LevelUtil;
import com.hq.acdm.vo.sys.AclListVo;
import com.hq.acdm.vo.sys.MenuListVo;
import com.hq.acdm.vo.sys.RoleListVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Service("sysTreeService")
public class SysTreeServiceImpl implements ISysTreeService {

    @Resource
    private SysAclModuleMapper sysAclModuleMapper;
    @Resource
    private SysCoreServiceImpl sysCoreService;
    @Resource
    private SysAclMapper sysAclMapper;
    @Resource
    private SysRoleUserMapper sysRoleUserMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysRoleAclMapper sysRoleAclMapper;

    private static final String MANAGER_STATUS = "1";

    @Override
    public List<AclModuleLevelDto> userAclTree(int userId) {
        List<SysAcl> userAclList = sysCoreService.getUserAclList(userId);
        List<AclDto> aclDtoList = Lists.newArrayList();
        for (SysAcl acl : userAclList) {
            AclDto dto = AclDto.adapt(acl);
            dto.setHasAcl(true);
            dto.setChecked(true);
            aclDtoList.add(dto);
        }
 //       return aclListToTree(aclDtoList);
        return null;
    }

    @Override
    public List<RoleListVo> roleTree() {
        //如果是超级管理员，查询全部角色，否则查询用户拥有
        if (SysManager.isSuperAdmin()) {
            List<SysRole> roleList = sysRoleMapper.getAll();

            List<RoleListVo> voList = Lists.newArrayList();
            for (SysRole role : roleList) {
                voList.add(RoleListVo.adapt(role));
            }
            return roleListToTree(voList);
        } else {
            SysUser sysUser = RequestHolder.getCurrentUser();

            Integer userId = sysUser.getId();
            //查询当前用户的角色
/*            List<Integer> userRoleIdList = sysRoleUserMapper.getRoleIdListByUserId(userId);
            List<SysRole> roleList = sysRoleMapper.getByIdList(userRoleIdList);
            List<RoleListVo> voList = Lists.newArrayList();
            for (SysRole role : roleList) {
                voList.add(RoleListVo.adapt(role));
            }
            return roleListToTree(voList);*/
//-----------------

            //得到全部角色，放入map，key为角色ID，值为角色
            List<Integer> userRoleIdList = sysRoleUserMapper.getRoleIdListByUserId(userId);
            List<SysRole> roleList = sysRoleMapper.getByIdList(userRoleIdList);
            Map<Integer, SysRole> roleMap = new HashMap<>();
            for (SysRole role : roleList) {
                roleMap.put(role.getId(), role);
            }
            //遍历map，得到每一个角色，每一个角色再根据层级递归
            Iterator it = roleMap.keySet().iterator();
            while (it.hasNext()) {
                Integer key = (Integer)it.next();
                SysRole sysRole = roleMap.get(key);
                //递归得到子集，看看map里面有没有，有就把map里面的剔除
                transformRole(sysRole, roleMap);
            }
            //最后遍历map完成，map里面只存在父级
            //再遍历map，得到每一个父级角色，递归父级角色得到下面的所有子角色
            List<RoleListVo> rootList = Lists.newArrayList();
            Iterator it2 = roleMap.keySet().iterator();
            while (it2.hasNext()) {
                Integer key = (Integer)it2.next();
                SysRole sysRole = roleMap.get(key);
                rootList.add(RoleListVo.adapt(sysRole));
            }
            Collections.sort(rootList, roleSeqComparator);

            for (RoleListVo vo : rootList) {
                transformRole2(vo);
            }
//------------------------------------------------------

//------------------------
            return rootList;
        }
    }

    public void transformRole2(RoleListVo dto) {
            String nextLevel = LevelUtil.calculateLevel(dto.getRoleLevel(), dto.getId());
            List<SysRole> tempList = sysRoleMapper.getByLevel(nextLevel);
            if (CollectionUtils.isNotEmpty(tempList)) {
                List<RoleListVo> vo = Lists.newArrayList();
                for (SysRole role : tempList){
                    vo.add(RoleListVo.adapt(role));
                }
                Collections.sort(vo, roleSeqComparator);
                dto.setChildren(vo);
                for (RoleListVo v : vo) {
                    transformRole2(v);
                }
        }
    }

    public void transformRole(SysRole role, Map<Integer, SysRole> roleMap) {
            String nextLevel = LevelUtil.calculateLevel(role.getRoleLevel(), role.getId());
            List<SysRole> byLevels = sysRoleMapper.getByLevel(nextLevel);
            if (CollectionUtils.isNotEmpty(byLevels)) {
                    for (SysRole r : byLevels) {
                        roleMap.remove(r.getId());
                        transformRole(r, roleMap);
                    }
                }
    }

    public List<RoleListVo> roleListToTree(List<RoleListVo> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return Lists.newArrayList();
        }
        // level -> [aclmodule1, aclmodule2, ...] Map<String, List<Object>>
        Multimap<String, RoleListVo> levelAclModuleMap = ArrayListMultimap.create();
        List<RoleListVo> rootList = Lists.newArrayList();

        for (RoleListVo vo : voList) {
            levelAclModuleMap.put(vo.getRoleLevel(), vo);
            if (LevelUtil.ROOT.equals(vo.getRoleLevel())) {
                rootList.add(vo);
            }
        }
        Collections.sort(rootList, roleSeqComparator);
        transformRoleTree(rootList, LevelUtil.ROOT, levelAclModuleMap);
        return rootList;
    }

    public void transformRoleTree(List<RoleListVo> voList, String level, Multimap<String, RoleListVo> levelAclModuleMap) {
        for (int i = 0; i < voList.size(); i++) {
            RoleListVo dto = voList.get(i);
            String nextLevel = LevelUtil.calculateLevel(level, dto.getId());
            List<RoleListVo> tempList = (List<RoleListVo>) levelAclModuleMap.get(nextLevel);
            if (CollectionUtils.isNotEmpty(tempList)) {
                Collections.sort(tempList, roleSeqComparator);
                dto.setChildren(tempList);

                transformRoleTree(tempList, nextLevel, levelAclModuleMap);
            }
        }
    }


    public void bindAclsWithOrder(List<AclModuleLevelDto> aclModuleLevelList, Multimap<Integer, AclDto> moduleIdAclMap) {
        if (CollectionUtils.isEmpty(aclModuleLevelList)) {
            return;
        }
        for (AclModuleLevelDto dto : aclModuleLevelList) {
            List<AclDto> aclDtoList = (List<AclDto>)moduleIdAclMap.get(dto.getId());
            if (CollectionUtils.isNotEmpty(aclDtoList)) {
                Collections.sort(aclDtoList, aclSeqComparator);
                dto.setAclDtoList(aclDtoList);
            }
            bindAclsWithOrder(dto.getAclModuleList(), moduleIdAclMap);
        }
    }

    @Override
    public List<MenuListVo> aclModuleTree() {
        //如果是超级管理员，查询全部权限，否则查询用户拥有
        if (SysManager.isSuperAdmin()) {
            List<SysAclModule> aclModuleList = sysAclModuleMapper.getAllAclModule();

            List<MenuListVo> voList = Lists.newArrayList();
            for (SysAclModule aclModule : aclModuleList) {
                voList.add(MenuListVo.adapt(aclModule));
            }
            return aclModuleListToTree(voList);
        } else {
            //先根据用户-角色-权限关系，在权限表查询出用户的所有菜单，再根据权限表里面的菜单，匹配上菜单表里面的菜单
            SysUser sysUser = RequestHolder.getCurrentUser();

            Integer userId = sysUser.getId();
            //查询当前用户的角色
            List<Integer> userRoleIdList = sysRoleUserMapper.getRoleIdListByUserId(userId);
            //根据角色查询权限
            List<Integer> userAclIdList = sysRoleAclMapper.getAclIdListByRoleIdList(userRoleIdList);
            //根据权限ID查询权限

            List<SysAcl> aclListById = sysAclMapper.getByIdList(userAclIdList);

            //用递归的思想，得到权限点的所有父级权限
            List<SysAcl> list = Lists.newArrayList();
            for (SysAcl acl : aclListById) {
                if (!acl.getCode().equals("0")) {
                    getParent(list, acl.getCode());
                }
                list.add(acl);
            }

            //去重+筛选类型为1（菜单）的
            Map<String, SysAcl> map = new HashMap<>();
            for (SysAcl acl : list) {
                if (acl.getType().equals(1)) {
                    map.put(acl.getId()+"", acl);
                }
            }
            //当前用户拥有的菜单权限，包括全部父级
            List<SysAcl> sysAclList = Lists.newArrayList();

            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String key = it.next().toString();
                sysAclList.add(map.get(key));
            }

            //根据权限表的菜单，查询菜单表里面的菜单
            List<SysAclModule> moduleList = Lists.newArrayList();
            for (SysAcl acl : sysAclList) {
                moduleList.add(sysAclModuleMapper.getByHref(acl.getUrl()).get(0));
            }

            List<MenuListVo> voList = Lists.newArrayList();
            for (SysAclModule aclModule : moduleList) {
                voList.add(MenuListVo.adapt(aclModule));
            }
            return aclModuleListToTree(voList);
        }
    }

    @Override
    public List<AclModuleLevelDto> userAclModuleTree() {
/*        List<SysAclModule> aclModuleList = sysAclModuleMapper.getAllAclModule();
        List<AclModuleLevelDto> dtoList = Lists.newArrayList();
        for (SysAclModule aclModule : aclModuleList) {
            dtoList.add(AclModuleLevelDto.adapt(aclModule));
        }
        SysUser sysUser = RequestHolder.getCurrentUser();
        if (sysUser.getUsername().equals("Admin")) {
            return aclModuleListToTree(dtoList);
        } else {
            Integer userId = sysUser.getId();
            //查询当前用户的角色
            List<Integer> userRoleIdList = sysRoleUserMapper.getRoleIdListByUserId(userId);
            //根据角色查询权限
            List<Integer> userAclIdList = sysRoleAclMapper.getAclIdListByRoleIdList(userRoleIdList);
            if (CollectionUtils.isEmpty(userAclIdList)) {
                return Lists.newArrayList();
            }

            List<SysRole> roleList = sysRoleMapper.getByIdList(userRoleIdList);
            //判断有没有是管理员的角色
            for (SysRole role : roleList) {
                if (role.getStatus().equals(MANAGER_STATUS)) {
                    return aclModuleListToTree(dtoList);
                }
            }

            List<SysAcl> aclList = sysAclMapper.getByIdList(userAclIdList);
            return aclModuleListToTree2(dtoList, aclList);
        }*/
        return null;
    }

/*    public List<AclModuleLevelDto> aclModuleListToTree2(List<AclModuleLevelDto> dtoList, List<SysAcl> aclList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Lists.newArrayList();
        }
        // level -> [aclmodule1, aclmodule2, ...] Map<String, List<Object>>
        Multimap<String, AclModuleLevelDto> levelAclModuleMap = ArrayListMultimap.create();
        List<AclModuleLevelDto> rootList = Lists.newArrayList();

        for (AclModuleLevelDto dto : dtoList) {
            levelAclModuleMap.put(dto.getModuleLevel(), dto);
            if (LevelUtil.ROOT.equals(dto.getModuleLevel())) {
                rootList.add(dto);
            }
        }
        List<SysAclModule> aclModuleList = new ArrayList<>();
        for (SysAcl acl : aclList) {
            SysAclModule sysAclModule = sysAclModuleMapper.selectByPrimaryKey(acl.getAclModuleId());
            aclModuleList.add(sysAclModule);

        }

        Collections.sort(rootList, aclModuleSeqComparator);
        transformAclModuleTree2(aclModuleList, rootList, LevelUtil.ROOT, levelAclModuleMap);
        //rootList去掉一级菜单为空的
        List<AclModuleLevelDto> rootListNew = Lists.newArrayList();
        for (AclModuleLevelDto dto : rootList) {
            if (dto.getAclModuleList().size() > 0) {
                rootListNew.add(dto);
            }
        }
        return rootListNew;
    }*/

/*    public void transformAclModuleTree2( List<SysAclModule> aclModuleList, List<AclModuleLevelDto> dtoList, String level, Multimap<String, AclModuleLevelDto> levelAclModuleMap) {
        for (int i = 0; i < dtoList.size(); i++) {
            AclModuleLevelDto dto = dtoList.get(i);
            String nextLevel = LevelUtil.calculateLevel(level, dto.getId());
            List<AclModuleLevelDto> tempList = (List<AclModuleLevelDto>) levelAclModuleMap.get(nextLevel);
            if (CollectionUtils.isNotEmpty(tempList)) {
                Collections.sort(tempList, aclModuleSeqComparator);
                for (AclModuleLevelDto levelDto : tempList) {
                    for (SysAclModule module : aclModuleList) {
                        if (levelDto.getId().equals(module.getId())) {
                            dto.setAclModuleList(tempList);
                        }
                    }
                }
                transformAclModuleTree2(aclModuleList, tempList, nextLevel, levelAclModuleMap);
            }
        }
    }*/

    public List<MenuListVo> aclModuleListToTree(List<MenuListVo> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return Lists.newArrayList();
        }
        // level -> [aclmodule1, aclmodule2, ...] Map<String, List<Object>>
        Multimap<String, MenuListVo> levelAclModuleMap = ArrayListMultimap.create();
        List<MenuListVo> rootList = Lists.newArrayList();

        for (MenuListVo vo : voList) {
            levelAclModuleMap.put(vo.getModuleLevel(), vo);
            if (LevelUtil.ROOT.equals(vo.getModuleLevel())) {
                rootList.add(vo);
            }
        }
        Collections.sort(rootList, aclModuleSeqComparator);
        transformAclModuleTree(rootList, LevelUtil.ROOT, levelAclModuleMap);
        return rootList;
    }

    public void transformAclModuleTree(List<MenuListVo> voList, String level, Multimap<String, MenuListVo> levelAclModuleMap) {
        for (int i = 0; i < voList.size(); i++) {
            MenuListVo dto = voList.get(i);
            String nextLevel = LevelUtil.calculateLevel(level, dto.getId());
            List<MenuListVo> tempList = (List<MenuListVo>) levelAclModuleMap.get(nextLevel);
            if (CollectionUtils.isNotEmpty(tempList)) {
                Collections.sort(tempList, aclModuleSeqComparator);
                dto.setChildren(tempList);
/*
                //根据菜单ID查询权限列表
                dto.setAclList(sysAclMapper.getByModuleId(dto.getId()));*/

                transformAclModuleTree(tempList, nextLevel, levelAclModuleMap);
            }
        }
    }

/*    @Override
    public List<RoleDto> roleListTree() {
        //如果是超级管理员，返回全部角色，否则返回自己拥有的角色
        List<SysRole> roleList = sysRoleMapper.getAll();
        List<RoleDto> dtoList = Lists.newArrayList();
        for (SysRole role : roleList) {
            dtoList.add(RoleDto.adapt(role));
        }
        return roleListToTree(dtoList);
    }*/

/*    public List<RoleDto> roleListToTree(List<RoleDto> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Lists.newArrayList();
        }
        // level -> [aclmodule1, aclmodule2, ...] Map<String, List<Object>>
        Multimap<String, RoleDto> levelRoleMap = ArrayListMultimap.create();
        List<RoleDto> rootList = Lists.newArrayList();

        for (RoleDto dto : dtoList) {
            levelRoleMap.put(dto.getRoleLevel(), dto);
            if (LevelUtil.ROOT.equals(dto.getRoleLevel())) {
                rootList.add(dto);
            }
        }
        transformRoleTree(rootList, LevelUtil.ROOT, levelRoleMap);
        return rootList;
    }

    public void transformRoleTree(List<RoleDto> dtoList, String level, Multimap<String, RoleDto> levelRoleMap) {
        for (int i = 0; i < dtoList.size(); i++) {
            RoleDto dto = dtoList.get(i);
            String nextLevel = LevelUtil.calculateLevel(level, dto.getId());
            List<RoleDto> tempList = (List<RoleDto>) levelRoleMap.get(nextLevel);
            if (CollectionUtils.isNotEmpty(tempList)) {
                dto.setRoleList(tempList);

                transformRoleTree(tempList, nextLevel, levelRoleMap);
            }
        }
    }*/

    @Override
    public List<AclListVo> aclTree() {
        //如果是超级管理员，查询全部权限，否则查询用户拥有
        if (SysManager.isSuperAdmin()) {
            List<SysAcl> aclList = sysAclMapper.getAll();;
            return aclListToTree(aclList);
        } else {
            SysUser sysUser = RequestHolder.getCurrentUser();

            Integer userId = sysUser.getId();
            //查询当前用户的角色
            List<Integer> userRoleIdList = sysRoleUserMapper.getRoleIdListByUserId(userId);
            //根据角色查询权限
            List<Integer> userAclIdList = sysRoleAclMapper.getAclIdListByRoleIdList(userRoleIdList);
            //根据权限ID查询权限

            List<SysAcl> aclListById = sysAclMapper.getByIdList(userAclIdList);

            //用递归的思想，得到权限点的所有父级权限
            List<SysAcl> list = Lists.newArrayList();
            for (SysAcl acl : aclListById) {
                if (!acl.getCode().equals("0")) {
                    getParent(list, acl.getCode());
                }
                list.add(acl);
            }

            //去重
            Map<String, SysAcl> map = new HashMap<>();
            for (SysAcl acl : list) {
                map.put(acl.getId()+"", acl);
            }
            //当前用户拥有的权限，包括全部父级
            List<SysAcl> sysAclList = Lists.newArrayList();

            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String key = it.next().toString();
                sysAclList.add(map.get(key));
            }

            return aclListToTree(sysAclList);
        }

    }

    public List<SysAcl> getParent(List<SysAcl> list, String code) {

        //0.2.6
        //返回6
        String end = StringUtils.substring(code, code.lastIndexOf(".") + 1, code.length());
        //返回0.2
        String start = StringUtils.substring(code, 0, code.lastIndexOf("."));
        list.add(sysAclMapper.selectByPrimaryKey(Integer.parseInt(end)));
        if (!start.equals("0")) {
            getParent(list, start);
        }
        return list;
    }

    public List<AclListVo> aclListToTree(List<SysAcl> aclList) {
        if (CollectionUtils.isEmpty(aclList)) {
            return Lists.newArrayList();
        }
        List<AclListVo> voList = Lists.newArrayList();
        for (SysAcl acl : aclList) {
            voList.add(AclListVo.adapt(acl));
        }


        List<AclListVo> rootList = Lists.newArrayList();

        // level -> [aclmodule1, aclmodule2, ...] Map<String, List<Object>>
        Multimap<String, AclListVo> levelAclMap = ArrayListMultimap.create();

        for (AclListVo vo : voList) {
            levelAclMap.put(vo.getCode(), vo);
            if (LevelUtil.ROOT.equals(vo.getCode())) {
                rootList.add(vo);
            }
        }
        Collections.sort(rootList, aclVoSeqComparator);
        transformAclTree(rootList, LevelUtil.ROOT, levelAclMap);
        return rootList;
    }

    public void transformAclTree(List<AclListVo> voList, String level, Multimap<String, AclListVo> levelAclModuleMap) {
        for (int i = 0; i < voList.size(); i++) {
            AclListVo dto = voList.get(i);
            String nextLevel = LevelUtil.calculateLevel(level, dto.getId());
            List<AclListVo> tempList = (List<AclListVo>) levelAclModuleMap.get(nextLevel);
            if (CollectionUtils.isNotEmpty(tempList)) {
                Collections.sort(tempList, aclVoSeqComparator);
                dto.setChildren(tempList);

                transformAclTree(tempList, nextLevel, levelAclModuleMap);
            }
        }
    }


    public Comparator<MenuListVo> aclModuleSeqComparator = new Comparator<MenuListVo>() {
        @Override
        public int compare(MenuListVo o1, MenuListVo o2) {
            return o1.getSeq() - o2.getSeq();
        }
    };

    public Comparator<RoleListVo> roleSeqComparator = new Comparator<RoleListVo>() {
        @Override
        public int compare(RoleListVo o1, RoleListVo o2) {
            return o1.getSort() - o2.getSort();
        }
    };

    public Comparator<AclListVo> aclVoSeqComparator = new Comparator<AclListVo>() {
        @Override
        public int compare(AclListVo o1, AclListVo o2) {
            return o1.getSeq() - o2.getSeq();
        }
    };


    public Comparator<AclDto> aclSeqComparator = new Comparator<AclDto>() {
        public int compare(AclDto o1, AclDto o2) {
            return o1.getSeq() - o2.getSeq();
        }
    };
}
