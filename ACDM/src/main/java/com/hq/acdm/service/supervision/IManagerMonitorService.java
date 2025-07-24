package com.hq.acdm.service.supervision;

import com.hq.acdm.vo.supervision.managermonitor.OutBoundDelayVo;
import com.hq.acdm.vo.supervision.managermonitor.ParkingSpaceVo;

/**
 * @Author lizhifeng
 * @Date 2018/9/17 0017
 * @Description:
 */
public interface IManagerMonitorService {

    /**
     * 当日跑道方向 出港延误
     * @return
     */
    OutBoundDelayVo getOne();

    /**
     * 起降航班数量 机场空闲停机位
     * @return
     */
    ParkingSpaceVo getTwo();

}
