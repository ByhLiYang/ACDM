package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TDynTask implements Serializable {
    private String id;

    private Integer flightId;

    private String taskCode;

    private String taskName;

    private Integer taskStatus;

    private Date taskEstm;

    private Date taskAstm;

    private Date taskEetm;

    private Date taskAetm;

    private String rmk;

    private Date createTm;

    private Date updateTm;

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

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode == null ? null : taskCode.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getTaskEstm() {
        return taskEstm;
    }

    public void setTaskEstm(Date taskEstm) {
        this.taskEstm = taskEstm;
    }

    public Date getTaskAstm() {
        return taskAstm;
    }

    public void setTaskAstm(Date taskAstm) {
        this.taskAstm = taskAstm;
    }

    public Date getTaskEetm() {
        return taskEetm;
    }

    public void setTaskEetm(Date taskEetm) {
        this.taskEetm = taskEetm;
    }

    public Date getTaskAetm() {
        return taskAetm;
    }

    public void setTaskAetm(Date taskAetm) {
        this.taskAetm = taskAetm;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public Date getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(Date updateTm) {
        this.updateTm = updateTm;
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
        TDynTask other = (TDynTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFlightId() == null ? other.getFlightId() == null : this.getFlightId().equals(other.getFlightId()))
            && (this.getTaskCode() == null ? other.getTaskCode() == null : this.getTaskCode().equals(other.getTaskCode()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.getTaskStatus() == null ? other.getTaskStatus() == null : this.getTaskStatus().equals(other.getTaskStatus()))
            && (this.getTaskEstm() == null ? other.getTaskEstm() == null : this.getTaskEstm().equals(other.getTaskEstm()))
            && (this.getTaskAstm() == null ? other.getTaskAstm() == null : this.getTaskAstm().equals(other.getTaskAstm()))
            && (this.getTaskEetm() == null ? other.getTaskEetm() == null : this.getTaskEetm().equals(other.getTaskEetm()))
            && (this.getTaskAetm() == null ? other.getTaskAetm() == null : this.getTaskAetm().equals(other.getTaskAetm()))
            && (this.getRmk() == null ? other.getRmk() == null : this.getRmk().equals(other.getRmk()))
            && (this.getCreateTm() == null ? other.getCreateTm() == null : this.getCreateTm().equals(other.getCreateTm()))
            && (this.getUpdateTm() == null ? other.getUpdateTm() == null : this.getUpdateTm().equals(other.getUpdateTm()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFlightId() == null) ? 0 : getFlightId().hashCode());
        result = prime * result + ((getTaskCode() == null) ? 0 : getTaskCode().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((getTaskStatus() == null) ? 0 : getTaskStatus().hashCode());
        result = prime * result + ((getTaskEstm() == null) ? 0 : getTaskEstm().hashCode());
        result = prime * result + ((getTaskAstm() == null) ? 0 : getTaskAstm().hashCode());
        result = prime * result + ((getTaskEetm() == null) ? 0 : getTaskEetm().hashCode());
        result = prime * result + ((getTaskAetm() == null) ? 0 : getTaskAetm().hashCode());
        result = prime * result + ((getRmk() == null) ? 0 : getRmk().hashCode());
        result = prime * result + ((getCreateTm() == null) ? 0 : getCreateTm().hashCode());
        result = prime * result + ((getUpdateTm() == null) ? 0 : getUpdateTm().hashCode());
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
        sb.append(", taskCode=").append(taskCode);
        sb.append(", taskName=").append(taskName);
        sb.append(", taskStatus=").append(taskStatus);
        sb.append(", taskEstm=").append(taskEstm);
        sb.append(", taskAstm=").append(taskAstm);
        sb.append(", taskEetm=").append(taskEetm);
        sb.append(", taskAetm=").append(taskAetm);
        sb.append(", rmk=").append(rmk);
        sb.append(", createTm=").append(createTm);
        sb.append(", updateTm=").append(updateTm);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}