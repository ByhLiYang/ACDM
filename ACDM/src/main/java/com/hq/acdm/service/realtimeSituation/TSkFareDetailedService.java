package com.hq.acdm.service.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TIgoHotelStandardFee;
import com.hq.acdm.model.realtimeSituation.TSkFareDetailed;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface TSkFareDetailedService {



    public int insert(TSkFareDetailed record);

    public int updateByPrimaryKey(TSkFareDetailed record);

    public int deleteByPrimaryKey(String id);

    public List<TSkFareDetailed> findAllTSpecialInfo(Map params);


}
