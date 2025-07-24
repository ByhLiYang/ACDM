package com.hq.acdm.model.timer.GetTimeAVGByDay;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 9:27
 */
@Getter
@Setter
public class GetTimeAVGByDay {
    private String AIRCRAFT_TYPE;
    private String STAND;
    private String A_OR_D;
    private String HOURTIME;
    private String RWY;
    private Date OPERATIONAL_DATE;
    private int SLIDE_TIME;
}
