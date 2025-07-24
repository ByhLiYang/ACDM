package com.hq.acdm.model.parameter;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author LiFaQiang
 * @date 2018/10/16 15:43
 * @Description
 */
@Getter
@Setter
public class VMinimumConnectionTime {
    private String name;
    private String airline;
    private String aircrafttype;
    private int duration;
    private Date updatetime;
}
