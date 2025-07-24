package com.hq.acdm.service.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TFlightEvent;
import com.hq.acdm.model.realtimeSituation.TFlightEventExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface TFlightEventService {

    int findCountByExample(TFlightEventExample example);

    int deleteByExample(TFlightEventExample example);

    int deleteByPrimaryKey(String id);

    int insert(TFlightEvent record);

    int insertSelective(TFlightEvent record);

    List<TFlightEvent> selectByExample(TFlightEventExample example);

    TFlightEvent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TFlightEvent record, @Param("example") TFlightEventExample example);

    int updateByExample(@Param("record") TFlightEvent record, @Param("example") TFlightEventExample example);

    int updateByPrimaryKeySelective(TFlightEvent record);

    int updateByPrimaryKey(TFlightEvent record);
}
