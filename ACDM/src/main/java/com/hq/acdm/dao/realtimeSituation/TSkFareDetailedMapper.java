package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TIgoHotelStandardFee;
import com.hq.acdm.model.realtimeSituation.TSkFareDetailed;
import com.hq.acdm.model.realtimeSituation.TSkFareDetailedExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TSkFareDetailedMapper {
    int countByExample(TSkFareDetailedExample example);

    int deleteByExample(TSkFareDetailedExample example);

    int deleteByPrimaryKey(String id);

    int insert(TSkFareDetailed record);

    int insertSelective(TSkFareDetailed record);

    List<TSkFareDetailed> selectByExample(TSkFareDetailedExample example);

    TSkFareDetailed selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TSkFareDetailed record, @Param("example") TSkFareDetailedExample example);

    int updateByExample(@Param("record") TSkFareDetailed record, @Param("example") TSkFareDetailedExample example);

    int updateByPrimaryKeySelective(TSkFareDetailed record);

    int updateByPrimaryKey(TSkFareDetailed record);

    List<TSkFareDetailed> findAllTSpecialInfo(@Param("params") Map params);
}