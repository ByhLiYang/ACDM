package com.hq.acdm.service.sys.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hq.acdm.beans.PageQuery;
import com.hq.acdm.common.RequestHolder;
import com.hq.acdm.converter.SysConverter;
import com.hq.acdm.dao.sys.SysRoleUserMapper;
import com.hq.acdm.dao.sys.SysUserMapper;
import com.hq.acdm.exception.ParamException;
import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.param.sys.UserParam;
import com.hq.acdm.param.sys.user.ChangePwdParam;
import com.hq.acdm.service.sys.ISysUserService;
import com.hq.acdm.util.BeanValidator;
import com.hq.acdm.util.IpUtil;
import com.hq.acdm.util.MD5Util;
import com.hq.acdm.util.PropertiesUtil;
import com.hq.acdm.vo.sys.UserPageVo;
import org.apache.commons.lang3.StringUtils;
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
@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService {

    private static final String DEFAULT_PASSWORD = "123456";

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    public void save(UserParam param) {
        BeanValidator.check(param);
        if(checkUserNameExist(param.getNickName(), param.getId())) {
            throw new ParamException("登录名已被占用");
        }

        String encryptedPassword = MD5Util.encrypt(DEFAULT_PASSWORD);
        SysUser user = SysUser.builder().username(param.getNickName()).telephone(param.getPhone()).mail(param.getEmail())
                .password(encryptedPassword).status(param.getStatus()).remark(param.getRemarks()).build();
        user.setOperator(RequestHolder.getCurrentUser().getUsername());
        user.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        user.setOperateTime(new Date());

        sysUserMapper.insertSelective(user);
    }

    @Override
    public void update(UserParam param) {
        BeanValidator.check(param);
        if(checkUserNameExist(param.getNickName(), param.getId())) {
            throw new ParamException("登录名已被占用");
        }
        SysUser before = sysUserMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before, "待更新的用户不存在");
        SysUser user = SysUser.builder().id(param.getId()).username(param.getNickName()).telephone(param.getPhone()).mail(param.getEmail())
                .status(param.getStatus()).remark(param.getRemarks()).build();
        user.setOperator(RequestHolder.getCurrentUser().getUsername());
        user.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        user.setOperateTime(new Date());
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void updateStatus(String userId, String status) {

    }

    @Override
    public void updatePassword(String userName, String newPassword) {
        String encryptedPassword = MD5Util.encrypt(newPassword);
        sysUserMapper.updatePassword(userName, encryptedPassword);
    }

    @Override
    public void changePwd(ChangePwdParam param) {
        BeanValidator.check(param);
        if (!param.getNewPwd().equals(param.getNewPwd2())) {
            throw  new ParamException("新密码与确认密码不一致");
        }
        Integer id = RequestHolder.getCurrentUser().getId();
        SysUser user = sysUserMapper.selectByPrimaryKey(id);
        String password = user.getPassword();

        String encryptedPassword = MD5Util.encrypt(param.getOldPwd());

        if (!encryptedPassword.equals(password)) {
            throw  new ParamException("旧密码错误");
        }

        sysUserMapper.updatePassword(user.getUsername(), MD5Util.encrypt(param.getNewPwd()));

    }

    public boolean checkUserNameExist(String username, Integer userId) {
        return sysUserMapper.countByUserName(username, userId) > 0;
    }

    @Override
    public SysUser findByKeyword(String keyword) {
        return sysUserMapper.findByKeyword(keyword);
    }

    @Override
    public UserPageVo getByPageList(String key, PageQuery page) {
        //用户列表应过滤掉超级管理员，不在页面显示
        String superManager = PropertiesUtil.getProperty("super_manager");
        List<SysUser> listAll = sysUserMapper.getByPageList(key, superManager);
        BeanValidator.check(page);
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<SysUser> list = sysUserMapper.getByPageList(key, superManager);

        PageInfo pageInfo = new PageInfo(SysConverter.SysUser2UserParam(list));
        List<UserParam> paramList = pageInfo.getList();
        UserPageVo vo = new UserPageVo();
        vo.setRecords(paramList);
        vo.setTotal(listAll.size());
        return vo;
    }

    @Override
    public List<SysUser> getAll() {
        return sysUserMapper.getAll();
    }


    @Override
    public UserParam findByUserId(Integer userId) {
        SysUser user = sysUserMapper.selectByPrimaryKey(userId);
        return SysConverter.SysUser2UserParam(user);
    }

    @Transactional
    @Override
    public void delete(int userId) {
        sysUserMapper.deleteByPrimaryKey(userId);
        sysRoleUserMapper.deleteByUserId(userId);
    }

    @Override
    public List<Integer> get(int id) {
        List<Integer> list = sysRoleUserMapper.getRoleIdListByUserId(id);
        return list;
    }
}
