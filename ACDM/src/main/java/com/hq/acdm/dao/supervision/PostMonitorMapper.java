package com.hq.acdm.dao.supervision;

import com.hq.acdm.vo.supervision.postMonitor.PostMonitor;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/11/07 11:49
 * @Description
 */
public interface PostMonitorMapper {
    @Select({"SELECT * FROM V_WARNING_THEDELAY"})
    List<PostMonitor> findTheDelay();
    @Select({ "SELECT * FROM V_WARNING_THEDELAY_COUNT"})
    int findTheDelayCount();
    @Select({"SELECT * FROM V_WARNING_FORTHE"})
    List<PostMonitor> findForthe();
    @Select({"SELECT * FROM V_WARNING_FORTHE_COUNT"})
    int findFortheCount();
    @Select({"SELECT FLIGHT_NO_IATA,STAND,YUJIN_TIME YUJING FROM V_STARTBOARDING_MORE"})
    List<PostMonitor> findStartBoarding();
    @Select({"SELECT COUNT(*) FROM V_STARTBOARDING_MORE"})
    int findStartBoardingCount();
    @Select({"SELECT FLIGHT_NO_IATA,STAND,YUJIN_TIME YUJING FROM V_ROLLIN_MORE"})
    List<PostMonitor> findRollIn();
    @Select({"SELECT COUNT(*) FROM V_ROLLIN_MORE"})
    int findRollInCount();
    @Select({"SELECT FLIGHT_NO_IATA,STAND,YUJIN_TIME YUJING FROM V_ROLLOUT_MORE"})
    List<PostMonitor> findRollOut();
    @Select({"SELECT COUNT(*) FROM V_ROLLOUT_MORE"})
    int findRollOutCount();
}
