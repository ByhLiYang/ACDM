package com.hq.acdm.service.sys.impl;

import com.hq.acdm.dao.sys.UsersMapper;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.sys.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LiFaQiang
 * @date 2019/05/29 16:50
 * @Description
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;
    @Override
    public Users findByUsername(String username) {
        return usersMapper.selectByUsername(username);
    }

    @Override
    public String findDepartment(String userId) {
        return usersMapper.findDepartment(userId);
    }

    @Override
    public int updateUserPassword(Users record) {
        return usersMapper.updateUserPassword(record);
    }
}
