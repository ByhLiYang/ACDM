package com.hq.acdm.vo.dynamicFlight;

import java.io.Serializable;
import java.util.Date;

public class TCoordinatedDisposal implements Serializable {
    private String id;

    private String eventType;

    private Long flightId;

    private Long afid;

    private String flno;

    private Date execDate;

    private String dOrA;

    private String adep;

    private String ades;

    private Date sibt;

    private Date sobt;

    private Date asbt;

    private Date aebt;

    private Date atdc;

    private Date ywlj;

    private Date fxlj;

    private Date cdm;

    private Date atot;

    private Date aldt;

    private Date aibt;

    private Date aobt;

    private String rmk;

    private Date createTm;

    private Date updateTm;

    private String createUsr;

    private String updateUsr;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType == null ? null : eventType.trim();
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getAfid() {
        return afid;
    }

    public void setAfid(Long afid) {
        this.afid = afid;
    }

    public String getFlno() {
        return flno;
    }

    public void setFlno(String flno) {
        this.flno = flno == null ? null : flno.trim();
    }

    public Date getExecDate() {
        return execDate;
    }

    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }

    public String getdOrA() {
        return dOrA;
    }

    public void setdOrA(String dOrA) {
        this.dOrA = dOrA == null ? null : dOrA.trim();
    }

    public String getAdep() {
        return adep;
    }

    public void setAdep(String adep) {
        this.adep = adep == null ? null : adep.trim();
    }

    public String getAdes() {
        return ades;
    }

    public void setAdes(String ades) {
        this.ades = ades == null ? null : ades.trim();
    }

    public Date getSibt() {
        return sibt;
    }

    public void setSibt(Date sibt) {
        this.sibt = sibt;
    }

    public Date getSobt() {
        return sobt;
    }

    public void setSobt(Date sobt) {
        this.sobt = sobt;
    }

    public Date getAsbt() {
        return asbt;
    }

    public void setAsbt(Date asbt) {
        this.asbt = asbt;
    }

    public Date getAebt() {
        return aebt;
    }

    public void setAebt(Date aebt) {
        this.aebt = aebt;
    }

    public Date getAtdc() {
        return atdc;
    }

    public void setAtdc(Date atdc) {
        this.atdc = atdc;
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

    public Date getCdm() {
        return cdm;
    }

    public void setCdm(Date cdm) {
        this.cdm = cdm;
    }

    public Date getAtot() {
        return atot;
    }

    public void setAtot(Date atot) {
        this.atot = atot;
    }

    public Date getAldt() {
        return aldt;
    }

    public void setAldt(Date aldt) {
        this.aldt = aldt;
    }

    public Date getAibt() {
        return aibt;
    }

    public void setAibt(Date aibt) {
        this.aibt = aibt;
    }

    public Date getAobt() {
        return aobt;
    }

    public void setAobt(Date aobt) {
        this.aobt = aobt;
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

    public String getCreateUsr() {
        return createUsr;
    }

    public void setCreateUsr(String createUsr) {
        this.createUsr = createUsr == null ? null : createUsr.trim();
    }

    public String getUpdateUsr() {
        return updateUsr;
    }

    public void setUpdateUsr(String updateUsr) {
        this.updateUsr = updateUsr == null ? null : updateUsr.trim();
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
        TCoordinatedDisposal other = (TCoordinatedDisposal) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEventType() == null ? other.getEventType() == null : this.getEventType().equals(other.getEventType()))
            && (this.getFlightId() == null ? other.getFlightId() == null : this.getFlightId().equals(other.getFlightId()))
            && (this.getAfid() == null ? other.getAfid() == null : this.getAfid().equals(other.getAfid()))
            && (this.getFlno() == null ? other.getFlno() == null : this.getFlno().equals(other.getFlno()))
            && (this.getExecDate() == null ? other.getExecDate() == null : this.getExecDate().equals(other.getExecDate()))
            && (this.getdOrA() == null ? other.getdOrA() == null : this.getdOrA().equals(other.getdOrA()))
            && (this.getAdep() == null ? other.getAdep() == null : this.getAdep().equals(other.getAdep()))
            && (this.getAdes() == null ? other.getAdes() == null : this.getAdes().equals(other.getAdes()))
            && (this.getSibt() == null ? other.getSibt() == null : this.getSibt().equals(other.getSibt()))
            && (this.getSobt() == null ? other.getSobt() == null : this.getSobt().equals(other.getSobt()))
            && (this.getAsbt() == null ? other.getAsbt() == null : this.getAsbt().equals(other.getAsbt()))
            && (this.getAebt() == null ? other.getAebt() == null : this.getAebt().equals(other.getAebt()))
            && (this.getAtdc() == null ? other.getAtdc() == null : this.getAtdc().equals(other.getAtdc()))
            && (this.getYwlj() == null ? other.getYwlj() == null : this.getYwlj().equals(other.getYwlj()))
            && (this.getFxlj() == null ? other.getFxlj() == null : this.getFxlj().equals(other.getFxlj()))
            && (this.getCdm() == null ? other.getCdm() == null : this.getCdm().equals(other.getCdm()))
            && (this.getAtot() == null ? other.getAtot() == null : this.getAtot().equals(other.getAtot()))
            && (this.getAldt() == null ? other.getAldt() == null : this.getAldt().equals(other.getAldt()))
            && (this.getAibt() == null ? other.getAibt() == null : this.getAibt().equals(other.getAibt()))
            && (this.getAobt() == null ? other.getAobt() == null : this.getAobt().equals(other.getAobt()))
            && (this.getRmk() == null ? other.getRmk() == null : this.getRmk().equals(other.getRmk()))
            && (this.getCreateTm() == null ? other.getCreateTm() == null : this.getCreateTm().equals(other.getCreateTm()))
            && (this.getUpdateTm() == null ? other.getUpdateTm() == null : this.getUpdateTm().equals(other.getUpdateTm()))
            && (this.getCreateUsr() == null ? other.getCreateUsr() == null : this.getCreateUsr().equals(other.getCreateUsr()))
            && (this.getUpdateUsr() == null ? other.getUpdateUsr() == null : this.getUpdateUsr().equals(other.getUpdateUsr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEventType() == null) ? 0 : getEventType().hashCode());
        result = prime * result + ((getFlightId() == null) ? 0 : getFlightId().hashCode());
        result = prime * result + ((getAfid() == null) ? 0 : getAfid().hashCode());
        result = prime * result + ((getFlno() == null) ? 0 : getFlno().hashCode());
        result = prime * result + ((getExecDate() == null) ? 0 : getExecDate().hashCode());
        result = prime * result + ((getdOrA() == null) ? 0 : getdOrA().hashCode());
        result = prime * result + ((getAdep() == null) ? 0 : getAdep().hashCode());
        result = prime * result + ((getAdes() == null) ? 0 : getAdes().hashCode());
        result = prime * result + ((getSibt() == null) ? 0 : getSibt().hashCode());
        result = prime * result + ((getSobt() == null) ? 0 : getSobt().hashCode());
        result = prime * result + ((getAsbt() == null) ? 0 : getAsbt().hashCode());
        result = prime * result + ((getAebt() == null) ? 0 : getAebt().hashCode());
        result = prime * result + ((getAtdc() == null) ? 0 : getAtdc().hashCode());
        result = prime * result + ((getYwlj() == null) ? 0 : getYwlj().hashCode());
        result = prime * result + ((getFxlj() == null) ? 0 : getFxlj().hashCode());
        result = prime * result + ((getCdm() == null) ? 0 : getCdm().hashCode());
        result = prime * result + ((getAtot() == null) ? 0 : getAtot().hashCode());
        result = prime * result + ((getAldt() == null) ? 0 : getAldt().hashCode());
        result = prime * result + ((getAibt() == null) ? 0 : getAibt().hashCode());
        result = prime * result + ((getAobt() == null) ? 0 : getAobt().hashCode());
        result = prime * result + ((getRmk() == null) ? 0 : getRmk().hashCode());
        result = prime * result + ((getCreateTm() == null) ? 0 : getCreateTm().hashCode());
        result = prime * result + ((getUpdateTm() == null) ? 0 : getUpdateTm().hashCode());
        result = prime * result + ((getCreateUsr() == null) ? 0 : getCreateUsr().hashCode());
        result = prime * result + ((getUpdateUsr() == null) ? 0 : getUpdateUsr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", eventType=").append(eventType);
        sb.append(", flightId=").append(flightId);
        sb.append(", afid=").append(afid);
        sb.append(", flno=").append(flno);
        sb.append(", execDate=").append(execDate);
        sb.append(", dOrA=").append(dOrA);
        sb.append(", adep=").append(adep);
        sb.append(", ades=").append(ades);
        sb.append(", sibt=").append(sibt);
        sb.append(", sobt=").append(sobt);
        sb.append(", asbt=").append(asbt);
        sb.append(", aebt=").append(aebt);
        sb.append(", atdc=").append(atdc);
        sb.append(", ywlj=").append(ywlj);
        sb.append(", fxlj=").append(fxlj);
        sb.append(", cdm=").append(cdm);
        sb.append(", atot=").append(atot);
        sb.append(", aldt=").append(aldt);
        sb.append(", aibt=").append(aibt);
        sb.append(", aobt=").append(aobt);
        sb.append(", rmk=").append(rmk);
        sb.append(", createTm=").append(createTm);
        sb.append(", updateTm=").append(updateTm);
        sb.append(", createUsr=").append(createUsr);
        sb.append(", updateUsr=").append(updateUsr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}