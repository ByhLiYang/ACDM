package com.hq.acdm.service.sys;

import com.hq.acdm.beans.PageQuery;
import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.param.sys.UserParam;
import com.hq.acdm.param.sys.user.ChangePwdParam;
import com.hq.acdm.vo.sys.UserPageVo;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
public interface ISysUserService {

    void save(UserParam param);

    void update(UserParam param);

    void updateStatus(String userId, String status);

    void updatePassword(String userName, String newPassword);

    void changePwd(ChangePwdParam param);

    SysUser findByKeyword(String keyword);

    UserPageVo getByPageList(String key, PageQuery page);

    List<SysUser> getAll();

    UserParam findByUserId(Integer userId);

    void delete(int userId);

    List<Integer> get(int id);

}
