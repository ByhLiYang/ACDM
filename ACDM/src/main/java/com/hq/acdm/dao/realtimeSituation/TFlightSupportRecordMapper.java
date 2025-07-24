package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TFlightSupportRecord;
import com.hq.acdm.model.realtimeSituation.TFlightSupportRecordExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TFlightSupportRecordMapper {
    int countByExample(TFlightSupportRecordExample example);

    int deleteByExample(TFlightSupportRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(TFlightSupportRecord record);

    int insertSelective(TFlightSupportRecord record);

    List<TFlightSupportRecord> selectByExample(TFlightSupportRecordExample example);

    TFlightSupportRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TFlightSupportRecord record, @Param("example") TFlightSupportRecordExample example);

    int updateByExample(@Param("record") TFlightSupportRecord record, @Param("example") TFlightSupportRecordExample example);

    int updateByPrimaryKeySelective(TFlightSupportRecord record);

    int updateByPrimaryKey(TFlightSupportRecord record);

    List<TFlightSupportRecord> selectByFlightId(@Param("params") Map params);
}