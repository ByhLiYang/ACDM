package com.hq.acdm.service.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TIgoHotelStandardFee;

import com.hq.acdm.vo.realtimeSituation.TIgoHotelStandardFeeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface TIgoHotelStandardFeeService {



    public int insert(TIgoHotelStandardFee record);

    public int updateByPrimaryKey(TIgoHotelStandardFee record);

    public int deleteByPrimaryKey(String id);

    public List<TIgoHotelStandardFeeVO> findAllTSpecialInfo(Map params);


}
