package com.hq.acdm.controller.req;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class AircraftSaveReq {
    private String hex;
    private String flight;
    private BigDecimal lat;
    private BigDecimal lon;
    private Integer altitude;
    private Integer track;
    private Integer speed;
}
