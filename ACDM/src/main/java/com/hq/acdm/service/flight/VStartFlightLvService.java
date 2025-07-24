package com.hq.acdm.service.flight;

import com.hq.acdm.vo.flight.VStartFlightLvVo;

import java.util.List;
import java.util.Map;

/**
 * @Auther: pengzhanghua
 * @Date: 2018/9/18 10:51
 * @Description:
 */
public interface VStartFlightLvService {
    /**
     * 查看自身始发航班正常率
     * @return
     */
    List<VStartFlightLvVo> checkFightRegularity(Map record);
}
