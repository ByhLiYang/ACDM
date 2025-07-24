package com.hq.acdm.vo.statistics.monthlyStatistics;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2018/12/25 14:28
 * @Description
 */
@Data
public class MonthlyStatisticsVo {
    private String FLIGHT_NO_IATA;
    private String DEST_AIRPORT_IATA;
    private String ZS;
    private String YW;
    private String BZC;
    private String AVGTIME;
    private String FXL;
    private String ZCL;
}
