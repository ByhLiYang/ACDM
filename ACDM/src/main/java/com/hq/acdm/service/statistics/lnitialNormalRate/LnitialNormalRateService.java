package com.hq.acdm.service.statistics.lnitialNormalRate;

import com.hq.acdm.model.statistics.lnitialNormalRate.LnitialNormalRate;
import com.hq.acdm.model.statistics.lnitialNormalRate.LnitialNormalRate1;
import com.hq.acdm.model.statistics.lnitialNormalRate.LnitialNormalRate2;

import java.util.List;

public interface LnitialNormalRateService {
        //6-10点始发正常率
        List<LnitialNormalRate> queryLnitialNormalRate(String startDate, String endDate);

        //6-10每小时始发正常率
        List<LnitialNormalRate1> queryLnitialNormalRate1(String startDate, String endDate);

        //始发不正常前15航班
        List<LnitialNormalRate2> queryLnitialNormalRate2(String startDate, String endDate);
}
