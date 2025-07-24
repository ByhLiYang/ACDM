package com.hq.acdm.dao.dynamicFlight;

import com.hq.acdm.vo.dynamicFlight.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:38
 * @Description
 */
public interface AirFoodMapper {
    //tony add 查询所有航班列表
    List<AirFoodFlightInfoVo> getAirFoodFltInfo(@Param("params") Map params);

    int updateByPrimaryKeySelective(AirPlanFoodVo record);

    int insert(AirPlanFoodVo record);

    int deleteByPrimaryKey(@Param("quarter") String quarter,@Param("username") String username);
    int addTaxiTimeVarBatch(@Param("emps") List<AirPlanFoodVo> emps);
}
