package com.hq.acdm.service.parameter;

import com.hq.acdm.model.parameter.VMinimumConnectionTime;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/10/18 14:50
 * @Description
 */
public interface MinimumConnectionTimeService {
    List<VMinimumConnectionTime> findMinimumConnectionTime();
    int updateMinimumConnectionTime(VMinimumConnectionTime vMinimumConnectionTime);
    int updateForDelete(VMinimumConnectionTime vMinimumConnectionTime);
    int insertMinimumConnectionTime(VMinimumConnectionTime vMinimumConnectionTime);
}
