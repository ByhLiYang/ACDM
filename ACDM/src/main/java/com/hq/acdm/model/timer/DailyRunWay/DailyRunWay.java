package com.hq.acdm.model.timer.DailyRunWay;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 8:40
 */
@Getter
@Setter
public class DailyRunWay {
    private Date OPERATIONAL_DATE;
    private String A_OR_D;
    private String RWY;
    private int STARTTIME;
    private int ENDTIME;
    private String STATUS;
    private String FLG;
    private String EDITOR;
    private Date UPDATETIME;
    private Date DD;
}
