package com.hq.acdm.vo.rscMonitors;

import com.hq.acdm.util.DateTimeUtil;

/**
 * @author LiFaQiang
 * @date 2019/06/24 12:29
 * @Description
 */

public class DeicingFluidVo {

    private String id;
    private String flightId;
    private String deicingFluid;
    private String deicingCar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getDeicingFluid() {
        return deicingFluid;
    }

    public void setDeicingFluid(String deicingFluid) {
        this.deicingFluid = deicingFluid;
    }

    public String getDeicingCar() {
        return deicingCar;
    }

    public void setDeicingCar(String deicingCar) {
        this.deicingCar = deicingCar;
    }
}
