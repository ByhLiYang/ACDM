package com.hq.acdm.model.statistics.flightQuery;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/10/18 0018 13:44
 */
@Setter
@Getter
public class Location {
    //机场三字码
    private String iata_code;
    //机场名字
    private String name;
    //
    private String icao_code;

    private boolean flag;
}
