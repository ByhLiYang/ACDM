package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TDelayCoordination implements Serializable {
    private String id;

    private Long flightId;

    private String flno;

    private Date sobt;

    private Date sibt;

    private String ades;

    private Date ywlj;

    private Date fxlj;

    private Date cobt;

    private Date tobt;

    private Date ctot;

    private Date ttot;

    private Date atdc;

    private Date aobt;

    private Date atot;

    private String state;

    private String priority;

    private String rmk;

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

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getFlno() {
        return flno;
    }

    public void setFlno(String flno) {
        this.flno = flno == null ? null : flno.trim();
    }

    public Date getSobt() {
        return sobt;
    }

    public void setSobt(Date sobt) {
        this.sobt = sobt;
    }

    public Date getSibt() {
        return sibt;
    }

    public void setSibt(Date sibt) {
        this.sibt = sibt;
    }

    public String getAdes() {
        return ades;
    }

    public void setAdes(String ades) {
        this.ades = ades == null ? null : ades.trim();
    }

    public Date getYwlj() {
        return ywlj;
    }

    public void setYwlj(Date ywlj) {
        this.ywlj = ywlj;
    }

    public Date getFxlj() {
        return fxlj;
    }

    public void setFxlj(Date fxlj) {
        this.fxlj = fxlj;
    }

    public Date getCobt() {
        return cobt;
    }

    public void setCobt(Date cobt) {
        this.cobt = cobt;
    }

    public Date getTobt() {
        return tobt;
    }

    public void setTobt(Date tobt) {
        this.tobt = tobt;
    }

    public Date getCtot() {
        return ctot;
    }

    public void setCtot(Date ctot) {
        this.ctot = ctot;
    }

    public Date getTtot() {
        return ttot;
    }

    public void setTtot(Date ttot) {
        this.ttot = ttot;
    }

    public Date getAtdc() {
        return atdc;
    }

    public void setAtdc(Date atdc) {
        this.atdc = atdc;
    }

    public Date getAobt() {
        return aobt;
    }

    public void setAobt(Date aobt) {
        this.aobt = aobt;
    }

    public Date getAtot() {
        return atot;
    }

    public void setAtot(Date atot) {
        this.atot = atot;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
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
        TDelayCoordination other = (TDelayCoordination) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFlightId() == null ? other.getFlightId() == null : this.getFlightId().equals(other.getFlightId()))
            && (this.getFlno() == null ? other.getFlno() == null : this.getFlno().equals(other.getFlno()))
            && (this.getSobt() == null ? other.getSobt() == null : this.getSobt().equals(other.getSobt()))
            && (this.getSibt() == null ? other.getSibt() == null : this.getSibt().equals(other.getSibt()))
            && (this.getAdes() == null ? other.getAdes() == null : this.getAdes().equals(other.getAdes()))
            && (this.getYwlj() == null ? other.getYwlj() == null : this.getYwlj().equals(other.getYwlj()))
            && (this.getFxlj() == null ? other.getFxlj() == null : this.getFxlj().equals(other.getFxlj()))
            && (this.getCobt() == null ? other.getCobt() == null : this.getCobt().equals(other.getCobt()))
            && (this.getTobt() == null ? other.getTobt() == null : this.getTobt().equals(other.getTobt()))
            && (this.getCtot() == null ? other.getCtot() == null : this.getCtot().equals(other.getCtot()))
            && (this.getTtot() == null ? other.getTtot() == null : this.getTtot().equals(other.getTtot()))
            && (this.getAtdc() == null ? other.getAtdc() == null : this.getAtdc().equals(other.getAtdc()))
            && (this.getAobt() == null ? other.getAobt() == null : this.getAobt().equals(other.getAobt()))
            && (this.getAtot() == null ? other.getAtot() == null : this.getAtot().equals(other.getAtot()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
            && (this.getRmk() == null ? other.getRmk() == null : this.getRmk().equals(other.getRmk()))
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
        result = prime * result + ((getFlno() == null) ? 0 : getFlno().hashCode());
        result = prime * result + ((getSobt() == null) ? 0 : getSobt().hashCode());
        result = prime * result + ((getSibt() == null) ? 0 : getSibt().hashCode());
        result = prime * result + ((getAdes() == null) ? 0 : getAdes().hashCode());
        result = prime * result + ((getYwlj() == null) ? 0 : getYwlj().hashCode());
        result = prime * result + ((getFxlj() == null) ? 0 : getFxlj().hashCode());
        result = prime * result + ((getCobt() == null) ? 0 : getCobt().hashCode());
        result = prime * result + ((getTobt() == null) ? 0 : getTobt().hashCode());
        result = prime * result + ((getCtot() == null) ? 0 : getCtot().hashCode());
        result = prime * result + ((getTtot() == null) ? 0 : getTtot().hashCode());
        result = prime * result + ((getAtdc() == null) ? 0 : getAtdc().hashCode());
        result = prime * result + ((getAobt() == null) ? 0 : getAobt().hashCode());
        result = prime * result + ((getAtot() == null) ? 0 : getAtot().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        result = prime * result + ((getRmk() == null) ? 0 : getRmk().hashCode());
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
        sb.append(", flno=").append(flno);
        sb.append(", sobt=").append(sobt);
        sb.append(", sibt=").append(sibt);
        sb.append(", ades=").append(ades);
        sb.append(", ywlj=").append(ywlj);
        sb.append(", fxlj=").append(fxlj);
        sb.append(", cobt=").append(cobt);
        sb.append(", tobt=").append(tobt);
        sb.append(", ctot=").append(ctot);
        sb.append(", ttot=").append(ttot);
        sb.append(", atdc=").append(atdc);
        sb.append(", aobt=").append(aobt);
        sb.append(", atot=").append(atot);
        sb.append(", state=").append(state);
        sb.append(", priority=").append(priority);
        sb.append(", rmk=").append(rmk);
        sb.append(", createTm=").append(createTm);
        sb.append(", createEmp=").append(createEmp);
        sb.append(", updateTm=").append(updateTm);
        sb.append(", updateEmp=").append(updateEmp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}