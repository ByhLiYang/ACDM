package com.hq.acdm.vo.realtimeSituation;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2019/03/31 23:45
 * @Description
 */
@Data
public class FlightIndexRunwayVo {

    private String id;
    private String mode;
    private String status;
    private String state;
    private String dep;
    private String arr;
    private String capacity;

}
