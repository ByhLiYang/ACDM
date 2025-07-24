package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.vo.realtimeSituation.PassengerAreaVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/31 23:23
 * @Description
 */
public interface PassengerIndexMapper {
    PassengerAreaVo getPassengerArea(@Param("params") Map params);
}
