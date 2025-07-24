package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TSchedulingNoticeInfo implements Serializable {
    private String id;

    private Integer flightId;

    private String flno;

    private String taskType;

    private String deviceNo;

    private String dispatcher;

    private String execEmp;

    private String msg;

    private String status;

    private Date msgTime;

    private String createEmp;

    private Date createTm;

    private String updateEmp;

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

    public String getFlno() {
        return flno;
    }

    public void setFlno(String flno) {
        this.flno = flno == null ? null : flno.trim();
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo == null ? null : deviceNo.trim();
    }

    public String getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher == null ? null : dispatcher.trim();
    }

    public String getExecEmp() {
        return execEmp;
    }

    public void setExecEmp(String execEmp) {
        this.execEmp = execEmp == null ? null : execEmp.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
    }

    public String getCreateEmp() {
        return createEmp;
    }

    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp == null ? null : createEmp.trim();
    }

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public String getUpdateEmp() {
        return updateEmp;
    }

    public void setUpdateEmp(String updateEmp) {
        this.updateEmp = updateEmp == null ? null : updateEmp.trim();
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
        TSchedulingNoticeInfo other = (TSchedulingNoticeInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFlightId() == null ? other.getFlightId() == null : this.getFlightId().equals(other.getFlightId()))
            && (this.getFlno() == null ? other.getFlno() == null : this.getFlno().equals(other.getFlno()))
            && (this.getTaskType() == null ? other.getTaskType() == null : this.getTaskType().equals(other.getTaskType()))
            && (this.getDeviceNo() == null ? other.getDeviceNo() == null : this.getDeviceNo().equals(other.getDeviceNo()))
            && (this.getDispatcher() == null ? other.getDispatcher() == null : this.getDispatcher().equals(other.getDispatcher()))
            && (this.getExecEmp() == null ? other.getExecEmp() == null : this.getExecEmp().equals(other.getExecEmp()))
            && (this.getMsg() == null ? other.getMsg() == null : this.getMsg().equals(other.getMsg()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMsgTime() == null ? other.getMsgTime() == null : this.getMsgTime().equals(other.getMsgTime()))
            && (this.getCreateEmp() == null ? other.getCreateEmp() == null : this.getCreateEmp().equals(other.getCreateEmp()))
            && (this.getCreateTm() == null ? other.getCreateTm() == null : this.getCreateTm().equals(other.getCreateTm()))
            && (this.getUpdateEmp() == null ? other.getUpdateEmp() == null : this.getUpdateEmp().equals(other.getUpdateEmp()))
            && (this.getUpdateTm() == null ? other.getUpdateTm() == null : this.getUpdateTm().equals(other.getUpdateTm()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFlightId() == null) ? 0 : getFlightId().hashCode());
        result = prime * result + ((getFlno() == null) ? 0 : getFlno().hashCode());
        result = prime * result + ((getTaskType() == null) ? 0 : getTaskType().hashCode());
        result = prime * result + ((getDeviceNo() == null) ? 0 : getDeviceNo().hashCode());
        result = prime * result + ((getDispatcher() == null) ? 0 : getDispatcher().hashCode());
        result = prime * result + ((getExecEmp() == null) ? 0 : getExecEmp().hashCode());
        result = prime * result + ((getMsg() == null) ? 0 : getMsg().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMsgTime() == null) ? 0 : getMsgTime().hashCode());
        result = prime * result + ((getCreateEmp() == null) ? 0 : getCreateEmp().hashCode());
        result = prime * result + ((getCreateTm() == null) ? 0 : getCreateTm().hashCode());
        result = prime * result + ((getUpdateEmp() == null) ? 0 : getUpdateEmp().hashCode());
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
        sb.append(", flno=").append(flno);
        sb.append(", taskType=").append(taskType);
        sb.append(", deviceNo=").append(deviceNo);
        sb.append(", dispatcher=").append(dispatcher);
        sb.append(", execEmp=").append(execEmp);
        sb.append(", msg=").append(msg);
        sb.append(", status=").append(status);
        sb.append(", msgTime=").append(msgTime);
        sb.append(", createEmp=").append(createEmp);
        sb.append(", createTm=").append(createTm);
        sb.append(", updateEmp=").append(updateEmp);
        sb.append(", updateTm=").append(updateTm);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}