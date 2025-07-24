package com.hq.acdm.vo.dynamicFlight;

import lombok.Data;

import java.util.List;

@Data
public class FlightEventReturnVo {

    private String date;
    private List<FlightEventVo> info;



}
