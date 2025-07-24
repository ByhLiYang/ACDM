package com.hq.acdm.model.timer.MilestoneHistoricalLog;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author wangshuhao
 * @date 2018/11/12 0012 15:13
 */
@Getter
@Setter
public class MilestoneHistoricalLog {
    private String FLIGHT_NO_IATA;
    private String FLIGHT_REPEAT_COUNT;
    private String A_OR_D;
    private Date OPERATIONAL_DATE;
    private String MILESTONE_ID;
    private String MILESTONE_DESC;
    private Date MILESTONE_DATETIME;
    private String DS_ID;
    private int PRIORITY;
    private Date LASTUPDATETIME;
    private Date MESSAGETIME;
    private int IS_PRIORITY_HIGHEST;
    private int countNumber;

}
