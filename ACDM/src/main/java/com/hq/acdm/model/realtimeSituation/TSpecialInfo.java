package com.hq.acdm.model.realtimeSituation;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class TSpecialInfo implements Serializable {
    private String id;

    private String infoType;

    private String infoContent;

    private Date infoStarttm;

    private Date infoEndtm;

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

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType == null ? null : infoType.trim();
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent == null ? null : infoContent.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getInfoStarttm() {
        return infoStarttm;
    }

    public void setInfoStarttm(Date infoStarttm) {
        this.infoStarttm = infoStarttm;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getInfoEndtm() {
        return infoEndtm;
    }

    public void setInfoEndtm(Date infoEndtm) {
        this.infoEndtm = infoEndtm;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
        TSpecialInfo other = (TSpecialInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInfoType() == null ? other.getInfoType() == null : this.getInfoType().equals(other.getInfoType()))
            && (this.getInfoContent() == null ? other.getInfoContent() == null : this.getInfoContent().equals(other.getInfoContent()))
            && (this.getInfoStarttm() == null ? other.getInfoStarttm() == null : this.getInfoStarttm().equals(other.getInfoStarttm()))
            && (this.getInfoEndtm() == null ? other.getInfoEndtm() == null : this.getInfoEndtm().equals(other.getInfoEndtm()))
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
        result = prime * result + ((getInfoType() == null) ? 0 : getInfoType().hashCode());
        result = prime * result + ((getInfoContent() == null) ? 0 : getInfoContent().hashCode());
        result = prime * result + ((getInfoStarttm() == null) ? 0 : getInfoStarttm().hashCode());
        result = prime * result + ((getInfoEndtm() == null) ? 0 : getInfoEndtm().hashCode());
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
        sb.append(", infoType=").append(infoType);
        sb.append(", infoContent=").append(infoContent);
        sb.append(", infoStarttm=").append(infoStarttm);
        sb.append(", infoEndtm=").append(infoEndtm);
        sb.append(", createTm=").append(createTm);
        sb.append(", updateTm=").append(updateTm);
        sb.append(", createUsr=").append(createUsr);
        sb.append(", updateUsr=").append(updateUsr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}