package com.hq.acdm.vo.coordinatedOprt;

import com.hq.acdm.util.DateTimeUtil;
import lombok.Data;
import lombok.Getter;

/**
 * @author LiFaQiang
 * @date 2019/06/12 13:25
 * @Description
 */
@Getter
public class FlightCutsVo {
    private String FLIGHT_ID;
    private String EXEC_DATE;
    private String AIRLINES;
    private String FLNO;
    private String ADES;
    private String SOBT;
    private String N_SOBT;
    private String ATOT;
    private String ISCONTROL;
    private String YYJ;
    private String JHXJ;

    public void setFLIGHT_ID(String FLIGHT_ID) {
        this.FLIGHT_ID = FLIGHT_ID;
    }

    public void setEXEC_DATE(String EXEC_DATE) {
        this.EXEC_DATE = EXEC_DATE;
    }

    public void setAIRLINES(String AIRLINES) {
        this.AIRLINES = AIRLINES;
    }

    public void setFLNO(String FLNO) {
        this.FLNO = FLNO;
    }

    public void setADES(String ADES) {
        this.ADES = ADES;
    }

    public void setSOBT(String SOBT) {
        this.SOBT = SOBT.replace(".0","");
    }

    public void setATOT(String ATOT) {
        this.ATOT = DateTimeUtil.timeDayFormatByStr(ATOT);
    }

    public void setISCONTROL(String ISCONTROL) {
        this.ISCONTROL = ISCONTROL;
    }

    public void setYYJ(String YYJ) {
        this.YYJ = YYJ;
    }

    public String getN_SOBT() {
        return N_SOBT;
    }

    public void setN_SOBT(String n_SOBT) {
        N_SOBT = n_SOBT;
    }

    public void setJHXJ(String JHXJ) {
        this.JHXJ = JHXJ;
    }

}
