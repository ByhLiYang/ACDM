package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TCheckCounter implements Serializable {
    private String id;

    private String code;

    private String chineseName;

    private String englishName;

    private String attribute;

    private String terminalCd;

    private String airportRegionCd;

    private String status;

    private String agency;

    private Date createTime;

    private Date updateTime;

    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
    }

    public String getTerminalCd() {
        return terminalCd;
    }

    public void setTerminalCd(String terminalCd) {
        this.terminalCd = terminalCd == null ? null : terminalCd.trim();
    }

    public String getAirportRegionCd() {
        return airportRegionCd;
    }

    public void setAirportRegionCd(String airportRegionCd) {
        this.airportRegionCd = airportRegionCd == null ? null : airportRegionCd.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency == null ? null : agency.trim();
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
        TCheckCounter other = (TCheckCounter) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getChineseName() == null ? other.getChineseName() == null : this.getChineseName().equals(other.getChineseName()))
            && (this.getEnglishName() == null ? other.getEnglishName() == null : this.getEnglishName().equals(other.getEnglishName()))
            && (this.getAttribute() == null ? other.getAttribute() == null : this.getAttribute().equals(other.getAttribute()))
            && (this.getTerminalCd() == null ? other.getTerminalCd() == null : this.getTerminalCd().equals(other.getTerminalCd()))
            && (this.getAirportRegionCd() == null ? other.getAirportRegionCd() == null : this.getAirportRegionCd().equals(other.getAirportRegionCd()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAgency() == null ? other.getAgency() == null : this.getAgency().equals(other.getAgency()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getChineseName() == null) ? 0 : getChineseName().hashCode());
        result = prime * result + ((getEnglishName() == null) ? 0 : getEnglishName().hashCode());
        result = prime * result + ((getAttribute() == null) ? 0 : getAttribute().hashCode());
        result = prime * result + ((getTerminalCd() == null) ? 0 : getTerminalCd().hashCode());
        result = prime * result + ((getAirportRegionCd() == null) ? 0 : getAirportRegionCd().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAgency() == null) ? 0 : getAgency().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", chineseName=").append(chineseName);
        sb.append(", englishName=").append(englishName);
        sb.append(", attribute=").append(attribute);
        sb.append(", terminalCd=").append(terminalCd);
        sb.append(", airportRegionCd=").append(airportRegionCd);
        sb.append(", status=").append(status);
        sb.append(", agency=").append(agency);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}