package com.hq.acdm.vo.rscMonitors;

/**
 * @author LiFaQiang
 * @date 2019/06/24 12:29
 * @Description
 */

public class DeicingCarVo {

    private String id;
    private String deicingCarCode;
    private String deicingCarStatus;
    private String deicingFluid;
    private String hs;
    private String deicingCarGrade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeicingCarCode() {
        return deicingCarCode;
    }

    public void setDeicingCarCode(String deicingCarCode) {
        this.deicingCarCode = deicingCarCode;
    }

    public String getDeicingCarStatus() {
        return deicingCarStatus;
    }

    public void setDeicingCarStatus(String deicingCarStatus) {
        this.deicingCarStatus = deicingCarStatus;
    }

    public String getDeicingFluid() {
        return deicingFluid;
    }

    public void setDeicingFluid(String deicingFluid) {
        this.deicingFluid = deicingFluid;
    }

    public String getDeicingCarGrade() {
        return deicingCarGrade;
    }

    public void setDeicingCarGrade(String deicingCarGrade) {
        this.deicingCarGrade = deicingCarGrade;
    }

    public void setHs(String hs) {
        this.hs = hs;
    }

    public String getHs() {
        return hs;
    }
}
