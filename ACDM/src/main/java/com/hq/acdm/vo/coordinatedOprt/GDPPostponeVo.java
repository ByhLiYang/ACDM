package com.hq.acdm.vo.coordinatedOprt;

import com.hq.acdm.util.DateTimeUtil;
import lombok.Data;
import lombok.Getter;

/**
 * @author LiFaQiang
 * @date 2019/07/05 14:34
 * @Description
 */
@Getter
public class GDPPostponeVo {
    private String FLIGHT_ID_A;
    private String FLIGHT_ID_D;
    private String NUMBER;
    private String FLNO_A;
    private String FLNO_D;
    private String ADEP_A;
    private String ADES_D;
    private String SOBT_A;
    private String SIBT;
    private String DURATION_A;
    private String ATOT_A;
    private String ELDT;

    public void setFLIGHT_ID_A(String FLIGHT_ID_A) {
        this.FLIGHT_ID_A = FLIGHT_ID_A;
    }

    public void setFLIGHT_ID_D(String FLIGHT_ID_D) {
        this.FLIGHT_ID_D = FLIGHT_ID_D;
    }

    public void setNUMBER(String NUMBER) {
        this.NUMBER = NUMBER;
    }

    public void setFLNO_A(String FLNO_A) {
        this.FLNO_A = FLNO_A;
    }

    public void setFLNO_D(String FLNO_D) {
        this.FLNO_D = FLNO_D;
    }

    public void setADEP_A(String ADEP_A) {
        this.ADEP_A = ADEP_A;
    }

    public void setADES_D(String ADES_D) {
        this.ADES_D = ADES_D;
    }

    public void setSOBT_A(String SOBT_A) {
        this.SOBT_A = DateTimeUtil.timeDayFormatByStr(SOBT_A);
    }

    public void setSIBT(String SIBT) {
        this.SIBT = DateTimeUtil.timeDayFormatByStr(SIBT);
    }

    public void setDURATION_A(String DURATION_A) {
        this.DURATION_A = DURATION_A;
    }

    public void setATOT_A(String ATOT_A) {
        this.ATOT_A = DateTimeUtil.timeDayFormatByStr(ATOT_A);
    }

    public void setELDT(String ELDT) {
        this.ELDT = DateTimeUtil.timeDayFormatByStr(ELDT);
    }
}
