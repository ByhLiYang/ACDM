package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TDynAirBridge implements Serializable {
    private String id;

    private Long flightId;

    private String airBridgeCd1;

    private Date airBridgeStartTime1;

    private Date airBridgeEndTime1;

    private Integer airBridgeDuration1;

    private Date powerSupplyStartTime1;

    private Date powerSupplyEndTimr1;

    private Integer powerSupplyDuration1;

    private Date airConditioningStartTime1;

    private Date airConditioningEndTime1;

    private Integer airConditioningDuration1;

    private String airBridgeCd2;

    private Date airBridgeStartTime2;

    private Date airBridgeEndTime2;

    private Integer airBridgeDuration2;

    private Date powerSupplyStartTime2;

    private Date powerSupplyEndTimr2;

    private Integer powerSupplyDuration2;

    private Date airConditioningStartTime2;

    private Date airConditioningEndTime2;

    private Integer airConditioningDuration2;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getAirBridgeCd1() {
        return airBridgeCd1;
    }

    public void setAirBridgeCd1(String airBridgeCd1) {
        this.airBridgeCd1 = airBridgeCd1 == null ? null : airBridgeCd1.trim();
    }

    public Date getAirBridgeStartTime1() {
        return airBridgeStartTime1;
    }

    public void setAirBridgeStartTime1(Date airBridgeStartTime1) {
        this.airBridgeStartTime1 = airBridgeStartTime1;
    }

    public Date getAirBridgeEndTime1() {
        return airBridgeEndTime1;
    }

    public void setAirBridgeEndTime1(Date airBridgeEndTime1) {
        this.airBridgeEndTime1 = airBridgeEndTime1;
    }

    public Integer getAirBridgeDuration1() {
        return airBridgeDuration1;
    }

    public void setAirBridgeDuration1(Integer airBridgeDuration1) {
        this.airBridgeDuration1 = airBridgeDuration1;
    }

    public Date getPowerSupplyStartTime1() {
        return powerSupplyStartTime1;
    }

    public void setPowerSupplyStartTime1(Date powerSupplyStartTime1) {
        this.powerSupplyStartTime1 = powerSupplyStartTime1;
    }

    public Date getPowerSupplyEndTimr1() {
        return powerSupplyEndTimr1;
    }

    public void setPowerSupplyEndTimr1(Date powerSupplyEndTimr1) {
        this.powerSupplyEndTimr1 = powerSupplyEndTimr1;
    }

    public Integer getPowerSupplyDuration1() {
        return powerSupplyDuration1;
    }

    public void setPowerSupplyDuration1(Integer powerSupplyDuration1) {
        this.powerSupplyDuration1 = powerSupplyDuration1;
    }

    public Date getAirConditioningStartTime1() {
        return airConditioningStartTime1;
    }

    public void setAirConditioningStartTime1(Date airConditioningStartTime1) {
        this.airConditioningStartTime1 = airConditioningStartTime1;
    }

    public Date getAirConditioningEndTime1() {
        return airConditioningEndTime1;
    }

    public void setAirConditioningEndTime1(Date airConditioningEndTime1) {
        this.airConditioningEndTime1 = airConditioningEndTime1;
    }

    public Integer getAirConditioningDuration1() {
        return airConditioningDuration1;
    }

    public void setAirConditioningDuration1(Integer airConditioningDuration1) {
        this.airConditioningDuration1 = airConditioningDuration1;
    }

    public String getAirBridgeCd2() {
        return airBridgeCd2;
    }

    public void setAirBridgeCd2(String airBridgeCd2) {
        this.airBridgeCd2 = airBridgeCd2 == null ? null : airBridgeCd2.trim();
    }

    public Date getAirBridgeStartTime2() {
        return airBridgeStartTime2;
    }

    public void setAirBridgeStartTime2(Date airBridgeStartTime2) {
        this.airBridgeStartTime2 = airBridgeStartTime2;
    }

    public Date getAirBridgeEndTime2() {
        return airBridgeEndTime2;
    }

    public void setAirBridgeEndTime2(Date airBridgeEndTime2) {
        this.airBridgeEndTime2 = airBridgeEndTime2;
    }

    public Integer getAirBridgeDuration2() {
        return airBridgeDuration2;
    }

    public void setAirBridgeDuration2(Integer airBridgeDuration2) {
        this.airBridgeDuration2 = airBridgeDuration2;
    }

    public Date getPowerSupplyStartTime2() {
        return powerSupplyStartTime2;
    }

    public void setPowerSupplyStartTime2(Date powerSupplyStartTime2) {
        this.powerSupplyStartTime2 = powerSupplyStartTime2;
    }

    public Date getPowerSupplyEndTimr2() {
        return powerSupplyEndTimr2;
    }

    public void setPowerSupplyEndTimr2(Date powerSupplyEndTimr2) {
        this.powerSupplyEndTimr2 = powerSupplyEndTimr2;
    }

    public Integer getPowerSupplyDuration2() {
        return powerSupplyDuration2;
    }

    public void setPowerSupplyDuration2(Integer powerSupplyDuration2) {
        this.powerSupplyDuration2 = powerSupplyDuration2;
    }

    public Date getAirConditioningStartTime2() {
        return airConditioningStartTime2;
    }

    public void setAirConditioningStartTime2(Date airConditioningStartTime2) {
        this.airConditioningStartTime2 = airConditioningStartTime2;
    }

    public Date getAirConditioningEndTime2() {
        return airConditioningEndTime2;
    }

    public void setAirConditioningEndTime2(Date airConditioningEndTime2) {
        this.airConditioningEndTime2 = airConditioningEndTime2;
    }

    public Integer getAirConditioningDuration2() {
        return airConditioningDuration2;
    }

    public void setAirConditioningDuration2(Integer airConditioningDuration2) {
        this.airConditioningDuration2 = airConditioningDuration2;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TDynAirBridge other = (TDynAirBridge) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFlightId() == null ? other.getFlightId() == null : this.getFlightId().equals(other.getFlightId()))
            && (this.getAirBridgeCd1() == null ? other.getAirBridgeCd1() == null : this.getAirBridgeCd1().equals(other.getAirBridgeCd1()))
            && (this.getAirBridgeStartTime1() == null ? other.getAirBridgeStartTime1() == null : this.getAirBridgeStartTime1().equals(other.getAirBridgeStartTime1()))
            && (this.getAirBridgeEndTime1() == null ? other.getAirBridgeEndTime1() == null : this.getAirBridgeEndTime1().equals(other.getAirBridgeEndTime1()))
            && (this.getAirBridgeDuration1() == null ? other.getAirBridgeDuration1() == null : this.getAirBridgeDuration1().equals(other.getAirBridgeDuration1()))
            && (this.getPowerSupplyStartTime1() == null ? other.getPowerSupplyStartTime1() == null : this.getPowerSupplyStartTime1().equals(other.getPowerSupplyStartTime1()))
            && (this.getPowerSupplyEndTimr1() == null ? other.getPowerSupplyEndTimr1() == null : this.getPowerSupplyEndTimr1().equals(other.getPowerSupplyEndTimr1()))
            && (this.getPowerSupplyDuration1() == null ? other.getPowerSupplyDuration1() == null : this.getPowerSupplyDuration1().equals(other.getPowerSupplyDuration1()))
            && (this.getAirConditioningStartTime1() == null ? other.getAirConditioningStartTime1() == null : this.getAirConditioningStartTime1().equals(other.getAirConditioningStartTime1()))
            && (this.getAirConditioningEndTime1() == null ? other.getAirConditioningEndTime1() == null : this.getAirConditioningEndTime1().equals(other.getAirConditioningEndTime1()))
            && (this.getAirConditioningDuration1() == null ? other.getAirConditioningDuration1() == null : this.getAirConditioningDuration1().equals(other.getAirConditioningDuration1()))
            && (this.getAirBridgeCd2() == null ? other.getAirBridgeCd2() == null : this.getAirBridgeCd2().equals(other.getAirBridgeCd2()))
            && (this.getAirBridgeStartTime2() == null ? other.getAirBridgeStartTime2() == null : this.getAirBridgeStartTime2().equals(other.getAirBridgeStartTime2()))
            && (this.getAirBridgeEndTime2() == null ? other.getAirBridgeEndTime2() == null : this.getAirBridgeEndTime2().equals(other.getAirBridgeEndTime2()))
            && (this.getAirBridgeDuration2() == null ? other.getAirBridgeDuration2() == null : this.getAirBridgeDuration2().equals(other.getAirBridgeDuration2()))
            && (this.getPowerSupplyStartTime2() == null ? other.getPowerSupplyStartTime2() == null : this.getPowerSupplyStartTime2().equals(other.getPowerSupplyStartTime2()))
            && (this.getPowerSupplyEndTimr2() == null ? other.getPowerSupplyEndTimr2() == null : this.getPowerSupplyEndTimr2().equals(other.getPowerSupplyEndTimr2()))
            && (this.getPowerSupplyDuration2() == null ? other.getPowerSupplyDuration2() == null : this.getPowerSupplyDuration2().equals(other.getPowerSupplyDuration2()))
            && (this.getAirConditioningStartTime2() == null ? other.getAirConditioningStartTime2() == null : this.getAirConditioningStartTime2().equals(other.getAirConditioningStartTime2()))
            && (this.getAirConditioningEndTime2() == null ? other.getAirConditioningEndTime2() == null : this.getAirConditioningEndTime2().equals(other.getAirConditioningEndTime2()))
            && (this.getAirConditioningDuration2() == null ? other.getAirConditioningDuration2() == null : this.getAirConditioningDuration2().equals(other.getAirConditioningDuration2()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFlightId() == null) ? 0 : getFlightId().hashCode());
        result = prime * result + ((getAirBridgeCd1() == null) ? 0 : getAirBridgeCd1().hashCode());
        result = prime * result + ((getAirBridgeStartTime1() == null) ? 0 : getAirBridgeStartTime1().hashCode());
        result = prime * result + ((getAirBridgeEndTime1() == null) ? 0 : getAirBridgeEndTime1().hashCode());
        result = prime * result + ((getAirBridgeDuration1() == null) ? 0 : getAirBridgeDuration1().hashCode());
        result = prime * result + ((getPowerSupplyStartTime1() == null) ? 0 : getPowerSupplyStartTime1().hashCode());
        result = prime * result + ((getPowerSupplyEndTimr1() == null) ? 0 : getPowerSupplyEndTimr1().hashCode());
        result = prime * result + ((getPowerSupplyDuration1() == null) ? 0 : getPowerSupplyDuration1().hashCode());
        result = prime * result + ((getAirConditioningStartTime1() == null) ? 0 : getAirConditioningStartTime1().hashCode());
        result = prime * result + ((getAirConditioningEndTime1() == null) ? 0 : getAirConditioningEndTime1().hashCode());
        result = prime * result + ((getAirConditioningDuration1() == null) ? 0 : getAirConditioningDuration1().hashCode());
        result = prime * result + ((getAirBridgeCd2() == null) ? 0 : getAirBridgeCd2().hashCode());
        result = prime * result + ((getAirBridgeStartTime2() == null) ? 0 : getAirBridgeStartTime2().hashCode());
        result = prime * result + ((getAirBridgeEndTime2() == null) ? 0 : getAirBridgeEndTime2().hashCode());
        result = prime * result + ((getAirBridgeDuration2() == null) ? 0 : getAirBridgeDuration2().hashCode());
        result = prime * result + ((getPowerSupplyStartTime2() == null) ? 0 : getPowerSupplyStartTime2().hashCode());
        result = prime * result + ((getPowerSupplyEndTimr2() == null) ? 0 : getPowerSupplyEndTimr2().hashCode());
        result = prime * result + ((getPowerSupplyDuration2() == null) ? 0 : getPowerSupplyDuration2().hashCode());
        result = prime * result + ((getAirConditioningStartTime2() == null) ? 0 : getAirConditioningStartTime2().hashCode());
        result = prime * result + ((getAirConditioningEndTime2() == null) ? 0 : getAirConditioningEndTime2().hashCode());
        result = prime * result + ((getAirConditioningDuration2() == null) ? 0 : getAirConditioningDuration2().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", flightId=").append(flightId);
        sb.append(", airBridgeCd1=").append(airBridgeCd1);
        sb.append(", airBridgeStartTime1=").append(airBridgeStartTime1);
        sb.append(", airBridgeEndTime1=").append(airBridgeEndTime1);
        sb.append(", airBridgeDuration1=").append(airBridgeDuration1);
        sb.append(", powerSupplyStartTime1=").append(powerSupplyStartTime1);
        sb.append(", powerSupplyEndTimr1=").append(powerSupplyEndTimr1);
        sb.append(", powerSupplyDuration1=").append(powerSupplyDuration1);
        sb.append(", airConditioningStartTime1=").append(airConditioningStartTime1);
        sb.append(", airConditioningEndTime1=").append(airConditioningEndTime1);
        sb.append(", airConditioningDuration1=").append(airConditioningDuration1);
        sb.append(", airBridgeCd2=").append(airBridgeCd2);
        sb.append(", airBridgeStartTime2=").append(airBridgeStartTime2);
        sb.append(", airBridgeEndTime2=").append(airBridgeEndTime2);
        sb.append(", airBridgeDuration2=").append(airBridgeDuration2);
        sb.append(", powerSupplyStartTime2=").append(powerSupplyStartTime2);
        sb.append(", powerSupplyEndTimr2=").append(powerSupplyEndTimr2);
        sb.append(", powerSupplyDuration2=").append(powerSupplyDuration2);
        sb.append(", airConditioningStartTime2=").append(airConditioningStartTime2);
        sb.append(", airConditioningEndTime2=").append(airConditioningEndTime2);
        sb.append(", airConditioningDuration2=").append(airConditioningDuration2);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}