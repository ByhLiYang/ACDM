package com.hq.acdm.vo.coordinatedOprt;

import com.hq.acdm.util.DateTimeUtil;
import lombok.Data;
import lombok.Getter;

/**
 * @author LiFaQiang
 * @date 2019/07/05 16:04
 * @Description
 */
@Getter
public class GDPPostponeCKVo {
    private String NUMBER;
    private String FLIGHT_ID_A;
    private String FLIGHT_ID_D;
    private String FLNO_A;
    private String FLNO_D;
    private String EXEC_DATE_D;
    private String ETOT_A;
    private String DELAY_TIME_A;
    private String FL_STATUS_A;
    private String POSTPONE_STM;
    private String POSTPONE_ETM;

    public void setNUMBER(String NUMBER) {
        this.NUMBER = NUMBER;
    }

    public void setFLIGHT_ID_A(String FLIGHT_ID_A) {
        this.FLIGHT_ID_A = FLIGHT_ID_A;
    }

    public void setFLIGHT_ID_D(String FLIGHT_ID_D) {
        this.FLIGHT_ID_D = FLIGHT_ID_D;
    }

    public void setFLNO_A(String FLNO_A) {
        this.FLNO_A = FLNO_A;
    }

    public void setFLNO_D(String FLNO_D) {
        this.FLNO_D = FLNO_D;
    }

    public void setEXEC_DATE_D(String EXEC_DATE_D) {
        this.EXEC_DATE_D = EXEC_DATE_D;
    }

    public void setETOT_A(String ETOT_A) {
        this.ETOT_A = DateTimeUtil.timeDayFormatByStr(ETOT_A);
    }

    public void setDELAY_TIME_A(String DELAY_TIME_A) {
        this.DELAY_TIME_A = DELAY_TIME_A;
    }

    public void setFL_STATUS_A(String FL_STATUS_A) {
        this.FL_STATUS_A = FL_STATUS_A;
    }

    public void setPOSTPONE_STM(String POSTPONE_STM) {
        this.POSTPONE_STM = DateTimeUtil.timeDayFormatByStr(POSTPONE_STM);
    }

    public void setPOSTPONE_ETM(String POSTPONE_ETM) {
        this.POSTPONE_ETM = DateTimeUtil.timeDayFormatByStr(POSTPONE_ETM);
    }
}
