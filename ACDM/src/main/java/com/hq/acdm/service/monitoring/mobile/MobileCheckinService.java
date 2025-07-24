package com.hq.acdm.service.monitoring.mobile;

import com.hq.acdm.model.monitoring.mobile.MobileCheckin;

import java.util.List;
import java.util.Map;

/**
 * @Author lizhifeng
 * @Date 2018/8/21 0021
 * @Description:
 */
public interface MobileCheckinService {

    void save(MobileCheckin task);

    void update(MobileCheckin task);

    void delete(Integer taskid);

     List<MobileCheckin> queryList(Map params) ;

     List<MobileCheckin> queryFlightList(Map params) ;

}
