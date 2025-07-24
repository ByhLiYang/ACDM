package com.hq.acdm.model.statistics.aosssysdic;

import lombok.Data;

import java.util.Date;

/**
 * 参数管理
 */

@Data
public class Aosssysdic {

    private String PARAMTYPECODE;
    private String PARAMTYPENAME;
    private String PARAMCODE;
    private String PARAMNAME;
    private String PARAMDESC;
    private String PARAMVALUE;
    private String STATUS;
    private Date STATUS_START;
    private Date STATUS_END;
}
