package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TIgoHotelStandardFee;
import com.hq.acdm.model.realtimeSituation.TIgoHotelStandardFeeExample;
import java.util.List;
import java.util.Map;

import com.hq.acdm.vo.realtimeSituation.TIgoHotelStandardFeeVO;
import org.apache.ibatis.annotations.Param;

public interface TIgoHotelStandardFeeMapper {
    int countByExample(TIgoHotelStandardFeeExample example);

    int deleteByExample(TIgoHotelStandardFeeExample example);

    int deleteByPrimaryKey(String id);

    int insert(TIgoHotelStandardFee record);

    int insertSelective(TIgoHotelStandardFee record);

    List<TIgoHotelStandardFee> selectByExample(TIgoHotelStandardFeeExample example);

    TIgoHotelStandardFee selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TIgoHotelStandardFee record, @Param("example") TIgoHotelStandardFeeExample example);

    int updateByExample(@Param("record") TIgoHotelStandardFee record, @Param("example") TIgoHotelStandardFeeExample example);

    int updateByPrimaryKeySelective(TIgoHotelStandardFee record);

    int updateByPrimaryKey(TIgoHotelStandardFee record);

    List<TIgoHotelStandardFeeVO> findAllTSpecialInfo(@Param("params") Map params);
}