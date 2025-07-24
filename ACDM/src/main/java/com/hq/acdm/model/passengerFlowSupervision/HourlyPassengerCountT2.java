package com.hq.acdm.model.passengerFlowSupervision;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author wangshuhao
 * @date 2018/11/12 0012 18:37
 */
@Getter
@Setter
public class HourlyPassengerCountT2 {
    private int pax_count_hour24h;
    private int count_checked_in;
    private String pax_count_date;
    private int count_insecurityzone;
    private int count_onflights;
    private int terminal;
    private int paramvalue;
}
