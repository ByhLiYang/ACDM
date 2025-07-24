package com.hq.acdm.service.sys;

import com.hq.acdm.model.sys.Users;

/**
 * @author LiFaQiang
 * @date 2019/05/29 15:54
 * @Description
 */
public interface UsersService {
    Users findByUsername(String username);
    String findDepartment(String userId);
    int updateUserPassword(Users record);
}
