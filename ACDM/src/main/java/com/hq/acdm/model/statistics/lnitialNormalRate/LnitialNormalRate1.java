package com.hq.acdm.model.statistics.lnitialNormalRate;

import lombok.Data;

@Data
public class LnitialNormalRate1 {
    private String AIRLINE_CODE_IATA;

    private String ATOT;
    //始发架次
    private String SFS;
    //延误架次
    private String SFYWS;
    //始发正常率
    private String ZCS;
}
