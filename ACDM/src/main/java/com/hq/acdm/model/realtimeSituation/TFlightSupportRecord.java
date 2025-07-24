package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TFlightSupportRecord implements Serializable {
    private String id;

    private Integer flightId;

    private String clean;

    private String boarding;

    private String closeDoor;

    private String rollOut;

    private String delayReason;

    private String remarks;

    private String createEmp;

    private Date createTime;

    private String updateEmp;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getClean() {
        return clean;
    }

    public void setClean(String clean) {
        this.clean = clean == null ? null : clean.trim();
    }

    public String getBoarding() {
        return boarding;
    }

    public void setBoarding(String boarding) {
        this.boarding = boarding == null ? null : boarding.trim();
    }

    public String getCloseDoor() {
        return closeDoor;
    }

    public void setCloseDoor(String closeDoor) {
        this.closeDoor = closeDoor == null ? null : closeDoor.trim();
    }

    public String getRollOut() {
        return rollOut;
    }

    public void setRollOut(String rollOut) {
        this.rollOut = rollOut == null ? null : rollOut.trim();
    }

    public String getDelayReason() {
        return delayReason;
    }

    public void setDelayReason(String delayReason) {
        this.delayReason = delayReason == null ? null : delayReason.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getCreateEmp() {
        return createEmp;
    }

    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp == null ? null : createEmp.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateEmp() {
        return updateEmp;
    }

    public void setUpdateEmp(String updateEmp) {
        this.updateEmp = updateEmp == null ? null : updateEmp.trim();
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
        TFlightSupportRecord other = (TFlightSupportRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFlightId() == null ? other.getFlightId() == null : this.getFlightId().equals(other.getFlightId()))
            && (this.getClean() == null ? other.getClean() == null : this.getClean().equals(other.getClean()))
            && (this.getBoarding() == null ? other.getBoarding() == null : this.getBoarding().equals(other.getBoarding()))
            && (this.getCloseDoor() == null ? other.getCloseDoor() == null : this.getCloseDoor().equals(other.getCloseDoor()))
            && (this.getRollOut() == null ? other.getRollOut() == null : this.getRollOut().equals(other.getRollOut()))
            && (this.getDelayReason() == null ? other.getDelayReason() == null : this.getDelayReason().equals(other.getDelayReason()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getCreateEmp() == null ? other.getCreateEmp() == null : this.getCreateEmp().equals(other.getCreateEmp()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateEmp() == null ? other.getUpdateEmp() == null : this.getUpdateEmp().equals(other.getUpdateEmp()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFlightId() == null) ? 0 : getFlightId().hashCode());
        result = prime * result + ((getClean() == null) ? 0 : getClean().hashCode());
        result = prime * result + ((getBoarding() == null) ? 0 : getBoarding().hashCode());
        result = prime * result + ((getCloseDoor() == null) ? 0 : getCloseDoor().hashCode());
        result = prime * result + ((getRollOut() == null) ? 0 : getRollOut().hashCode());
        result = prime * result + ((getDelayReason() == null) ? 0 : getDelayReason().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getCreateEmp() == null) ? 0 : getCreateEmp().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateEmp() == null) ? 0 : getUpdateEmp().hashCode());
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
        sb.append(", clean=").append(clean);
        sb.append(", boarding=").append(boarding);
        sb.append(", closeDoor=").append(closeDoor);
        sb.append(", rollOut=").append(rollOut);
        sb.append(", delayReason=").append(delayReason);
        sb.append(", remarks=").append(remarks);
        sb.append(", createEmp=").append(createEmp);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateEmp=").append(updateEmp);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}