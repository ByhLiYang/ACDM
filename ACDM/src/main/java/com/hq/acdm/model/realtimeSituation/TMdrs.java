package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TMdrs implements Serializable {
    private String id;

    private String identification;

    private String area;

    private String level;

    private Date publishtime;

    private String expectinfluence;

    private String reason;

    private String timescope;

    private Date timescopeStart;

    private Date timescopeEnd;

    private Integer isdel;

    private String statuss;

    private Date createTm;

    private Date updateTm;

    private String updateUsr;

    private String createUsr;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getExpectinfluence() {
        return expectinfluence;
    }

    public void setExpectinfluence(String expectinfluence) {
        this.expectinfluence = expectinfluence == null ? null : expectinfluence.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getTimescope() {
        return timescope;
    }

    public void setTimescope(String timescope) {
        this.timescope = timescope == null ? null : timescope.trim();
    }

    public Date getTimescopeStart() {
        return timescopeStart;
    }

    public void setTimescopeStart(Date timescopeStart) {
        this.timescopeStart = timescopeStart;
    }

    public Date getTimescopeEnd() {
        return timescopeEnd;
    }

    public void setTimescopeEnd(Date timescopeEnd) {
        this.timescopeEnd = timescopeEnd;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss == null ? null : statuss.trim();
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

    public String getUpdateUsr() {
        return updateUsr;
    }

    public void setUpdateUsr(String updateUsr) {
        this.updateUsr = updateUsr == null ? null : updateUsr.trim();
    }

    public String getCreateUsr() {
        return createUsr;
    }

    public void setCreateUsr(String createUsr) {
        this.createUsr = createUsr == null ? null : createUsr.trim();
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
        TMdrs other = (TMdrs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdentification() == null ? other.getIdentification() == null : this.getIdentification().equals(other.getIdentification()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getPublishtime() == null ? other.getPublishtime() == null : this.getPublishtime().equals(other.getPublishtime()))
            && (this.getExpectinfluence() == null ? other.getExpectinfluence() == null : this.getExpectinfluence().equals(other.getExpectinfluence()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getTimescope() == null ? other.getTimescope() == null : this.getTimescope().equals(other.getTimescope()))
            && (this.getTimescopeStart() == null ? other.getTimescopeStart() == null : this.getTimescopeStart().equals(other.getTimescopeStart()))
            && (this.getTimescopeEnd() == null ? other.getTimescopeEnd() == null : this.getTimescopeEnd().equals(other.getTimescopeEnd()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()))
            && (this.getStatuss() == null ? other.getStatuss() == null : this.getStatuss().equals(other.getStatuss()))
            && (this.getCreateTm() == null ? other.getCreateTm() == null : this.getCreateTm().equals(other.getCreateTm()))
            && (this.getUpdateTm() == null ? other.getUpdateTm() == null : this.getUpdateTm().equals(other.getUpdateTm()))
            && (this.getUpdateUsr() == null ? other.getUpdateUsr() == null : this.getUpdateUsr().equals(other.getUpdateUsr()))
            && (this.getCreateUsr() == null ? other.getCreateUsr() == null : this.getCreateUsr().equals(other.getCreateUsr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdentification() == null) ? 0 : getIdentification().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getPublishtime() == null) ? 0 : getPublishtime().hashCode());
        result = prime * result + ((getExpectinfluence() == null) ? 0 : getExpectinfluence().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getTimescope() == null) ? 0 : getTimescope().hashCode());
        result = prime * result + ((getTimescopeStart() == null) ? 0 : getTimescopeStart().hashCode());
        result = prime * result + ((getTimescopeEnd() == null) ? 0 : getTimescopeEnd().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getStatuss() == null) ? 0 : getStatuss().hashCode());
        result = prime * result + ((getCreateTm() == null) ? 0 : getCreateTm().hashCode());
        result = prime * result + ((getUpdateTm() == null) ? 0 : getUpdateTm().hashCode());
        result = prime * result + ((getUpdateUsr() == null) ? 0 : getUpdateUsr().hashCode());
        result = prime * result + ((getCreateUsr() == null) ? 0 : getCreateUsr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", identification=").append(identification);
        sb.append(", area=").append(area);
        sb.append(", level=").append(level);
        sb.append(", publishtime=").append(publishtime);
        sb.append(", expectinfluence=").append(expectinfluence);
        sb.append(", reason=").append(reason);
        sb.append(", timescope=").append(timescope);
        sb.append(", timescopeStart=").append(timescopeStart);
        sb.append(", timescopeEnd=").append(timescopeEnd);
        sb.append(", isdel=").append(isdel);
        sb.append(", statuss=").append(statuss);
        sb.append(", createTm=").append(createTm);
        sb.append(", updateTm=").append(updateTm);
        sb.append(", updateUsr=").append(updateUsr);
        sb.append(", createUsr=").append(createUsr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}