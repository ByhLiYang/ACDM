package com.hq.acdm.vo.rscMonitors;

import lombok.Data;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2019/04/29 00:30
 * @Description
 */
@Data
public class StandStatusVo {
    private List<String> flightIdAList;
    private List<String> flightIdDList;
    private String flnoA;
    private String flnoD;
    private String stand;
    private String status;
    private List<String> fltNoAList;
    private List<String> fltNoDList;
    private List<String> startTimeList;
    private List<String> endTimeList;
}
