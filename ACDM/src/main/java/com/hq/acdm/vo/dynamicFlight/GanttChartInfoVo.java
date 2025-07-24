package com.hq.acdm.vo.dynamicFlight;

import lombok.Data;

import java.util.List;

@Data
public class GanttChartInfoVo {

    private List<String> startTimeList;
    private List<String> endTimeList;
    private List<String> startTimeExpectedList;
    private List<String> endTimeExpectedList;
    private List<String> lineState;
    private List<String> nodeName;



}
