package com.hq.acdm.dao.parameter;

import com.hq.acdm.model.parameter.VMinimumConnectionTime;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/10/16 15:16
 * @Description 最小过站时间管理
 */
public interface MinimumConnectionTimeMapper {
    /**
     *  查询最小过站时间
     * @return
     */
    List<VMinimumConnectionTime> findMinimumConnectionTime();

    /**
     *  修改最小过站时间
     * @return
     */
    int updateMinimumConnectionTime(VMinimumConnectionTime vMinimumConnectionTime);

    /**
     *  删除时将状态改为‘0’
     * @return
     */
    int updateForDelete(VMinimumConnectionTime vMinimumConnectionTime);

    /**
     *  恢复时将状态改为‘1’
     * @return
     */
    int updateForRecover(VMinimumConnectionTime vMinimumConnectionTime);

    /**
     *  新增最小过站时间
     * @return
     */
    int insertMinimumConnectionTime(VMinimumConnectionTime vMinimumConnectionTime);
}
