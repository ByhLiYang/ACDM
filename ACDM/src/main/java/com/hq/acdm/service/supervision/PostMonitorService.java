package com.hq.acdm.service.supervision;

import com.hq.acdm.vo.supervision.postMonitor.PostMonitor;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/11/07 16:24
 * @Description
 */
public interface PostMonitorService {
    List<PostMonitor> findTheDelay();
    int findTheDelayCount();
    List<PostMonitor> findForthe();
    int findFortheCount();
    List<PostMonitor> findStartBoarding();
    int findStartBoardingCount();
    List<PostMonitor> findRollIn();
    int findRollInCount();
    List<PostMonitor> findRollOut();
    int findRollOutCount();
}
