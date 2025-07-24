package com.hq.acdm.service.realtimeSituation;

import com.hq.acdm.vo.realtimeSituation.PassengerAreaVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/31 23:28
 * @Description
 */
public interface PassengerIndexService {
    PassengerAreaVo findPassengerArea(@Param("params") Map params);
}
