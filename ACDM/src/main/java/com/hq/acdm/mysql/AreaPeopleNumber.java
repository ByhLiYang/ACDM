package com.hq.acdm.mysql;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/11/13 0013 10:21
 */
@Getter
@Setter
public class AreaPeopleNumber {
    private String TERMINAL;
    private String AREA;
    private int PEOPLECOUNT;
    private String UPDATETIME;
}
