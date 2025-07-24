package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.lnitialNormalRate.LnitialNormalRate;
import com.hq.acdm.model.statistics.lnitialNormalRate.LnitialNormalRate1;
import com.hq.acdm.model.statistics.lnitialNormalRate.LnitialNormalRate2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LnitialNormalRateMapper {

    List<LnitialNormalRate> queryLnitialNormalRate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    List<LnitialNormalRate1> queryLnitialNormalRate1(@Param("startDate") String startDate, @Param("endDate") String endDate);

    List<LnitialNormalRate2> queryLnitialNormalRate2(@Param("startDate") String startDate, @Param("endDate") String endDate);


}
