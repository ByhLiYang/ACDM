package com.hq.acdm.vo.index;

import com.hq.acdm.model.index.CompanyDuty;
import com.hq.acdm.model.index.Weather;
import com.hq.acdm.vo.supervision.managermonitor.DateName;
import com.hq.acdm.vo.supervision.managermonitor.FourD;
import lombok.Data;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/9/4 0004
 * @Description:
 */
@Data
public class WeatherAndDutyVo {

    private List<Weather> weather;

    private List<CompanyDuty> companyDuty;

    /**
     * 当日跑道方向
     */
    private List<DateName> tableData1;

    /**
     * 机场空闲停机位
     */
    private List<FourD> tableData2;
}
