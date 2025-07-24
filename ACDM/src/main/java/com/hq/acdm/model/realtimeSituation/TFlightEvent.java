package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TFlightEvent implements Serializable {
    private String id;

    private Integer flightId;

    private String name;

    private String type;

    private Date time;

    private String description;

    private Date createTm;

    private String createEmp;

    private Date updateTm;

    private String updateEmp;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public String getCreateEmp() {
        return createEmp;
    }

    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp == null ? null : createEmp.trim();
    }

    public Date getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(Date updateTm) {
        this.updateTm = updateTm;
    }

    public String getUpdateEmp() {
        return updateEmp;
    }

    public void setUpdateEmp(String updateEmp) {
        this.updateEmp = updateEmp == null ? null : updateEmp.trim();
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
        TFlightEvent other = (TFlightEvent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFlightId() == null ? other.getFlightId() == null : this.getFlightId().equals(other.getFlightId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateTm() == null ? other.getCreateTm() == null : this.getCreateTm().equals(other.getCreateTm()))
            && (this.getCreateEmp() == null ? other.getCreateEmp() == null : this.getCreateEmp().equals(other.getCreateEmp()))
            && (this.getUpdateTm() == null ? other.getUpdateTm() == null : this.getUpdateTm().equals(other.getUpdateTm()))
            && (this.getUpdateEmp() == null ? other.getUpdateEmp() == null : this.getUpdateEmp().equals(other.getUpdateEmp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFlightId() == null) ? 0 : getFlightId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateTm() == null) ? 0 : getCreateTm().hashCode());
        result = prime * result + ((getCreateEmp() == null) ? 0 : getCreateEmp().hashCode());
        result = prime * result + ((getUpdateTm() == null) ? 0 : getUpdateTm().hashCode());
        result = prime * result + ((getUpdateEmp() == null) ? 0 : getUpdateEmp().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", time=").append(time);
        sb.append(", description=").append(description);
        sb.append(", createTm=").append(createTm);
        sb.append(", createEmp=").append(createEmp);
        sb.append(", updateTm=").append(updateTm);
        sb.append(", updateEmp=").append(updateEmp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}