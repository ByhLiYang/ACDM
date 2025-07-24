package com.hq.acdm.vo.rscMonitors;

import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2019/05/10 18:58
 * @Description
 */
@Getter
public class StandVo2 {
    private String fltIdA;
    private String fltIdD;
    private String fltNoA;
    private String fltNoD;
    private String stand;
    private String eit;
    private String eot;
    private String ait;
    private String aot;

    public void setFltIdA(String fltIdA) {
        this.fltIdA = fltIdA;
    }

    public void setFltIdD(String fltIdD) {
        this.fltIdD = fltIdD;
    }

    public void setFltNoA(String fltNoA) {
        this.fltNoA = fltNoA;
    }

    public void setFltNoD(String fltNoD) {
        this.fltNoD = fltNoD;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public void setEit(String eit) {
        this.eit = eit.replace(".0","");
    }

    public void setEot(String eot) {
        this.eot = eot.replace(".0","");
    }

    public void setAit(String ait) {
        this.ait = ait.replace(".0","");
    }

    public void setAot(String aot) {
        this.aot = aot.replace(".0","");
    }
}
