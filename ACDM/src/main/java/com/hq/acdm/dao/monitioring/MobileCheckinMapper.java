package com.hq.acdm.dao.monitioring;

import com.hq.acdm.model.monitoring.mobile.MobileCheckin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/12/11 0020 14:35
 */
public interface MobileCheckinMapper {
    //移动登录信息
    //查询移动登录信息
    List<MobileCheckin> queryList(@Param("params") Map params);

    //新增任务
    int insert(MobileCheckin task);
    //更新
    int updateStatus(MobileCheckin task);

    MobileCheckin selectByPrimaryKey(Integer id);
    int deleteByPrimaryKey(Integer id);
}
