package com.hq.acdm.model.monitoring.sameDayFlight;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class FlightInfoNode {

    //进出港标识
    private String LABEL;
    //SIBT
    private String INDEX;

    //ELDT
    private String STATE;

    //AIBT
    private String CHNAME;

    private String VALUE;

    public void setLABEL(String LABEL){
        this.LABEL=LABEL;
    }
    public void setINDEX(String INDEX){
        this.INDEX=INDEX;
    }
    public void setSTATE(String STATE){
        this.STATE=STATE;
    }
    public void setCHNAME(String CHNAME){
        this.CHNAME=CHNAME;
    }
    public void setVALUE(String VALUE){
        this.VALUE=VALUE;
    }
}