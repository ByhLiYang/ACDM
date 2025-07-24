package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.THotelInfo;
import com.hq.acdm.model.realtimeSituation.THotelInfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface THotelInfoMapper {
    int countByExample(THotelInfoExample example);

    int deleteByExample(THotelInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(THotelInfo record);

    int insertSelective(THotelInfo record);

    List<THotelInfo> selectByExample(THotelInfoExample example);

    THotelInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") THotelInfo record, @Param("example") THotelInfoExample example);

    int updateByExample(@Param("record") THotelInfo record, @Param("example") THotelInfoExample example);

    int updateByPrimaryKeySelective(THotelInfo record);

    int updateByPrimaryKey(THotelInfo record);

    List<THotelInfo> selectAllTHotelInfo(@Param("params") Map params);
}