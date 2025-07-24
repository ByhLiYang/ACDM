package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TCraftType implements Serializable {
    private String id;

    private String icaoCd;

    private String iataCd;

    private String classification;

    private String chineseName;

    private String englishName;

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

    public String getIcaoCd() {
        return icaoCd;
    }

    public void setIcaoCd(String icaoCd) {
        this.icaoCd = icaoCd == null ? null : icaoCd.trim();
    }

    public String getIataCd() {
        return iataCd;
    }

    public void setIataCd(String iataCd) {
        this.iataCd = iataCd == null ? null : iataCd.trim();
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification == null ? null : classification.trim();
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
        TCraftType other = (TCraftType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIcaoCd() == null ? other.getIcaoCd() == null : this.getIcaoCd().equals(other.getIcaoCd()))
            && (this.getIataCd() == null ? other.getIataCd() == null : this.getIataCd().equals(other.getIataCd()))
            && (this.getClassification() == null ? other.getClassification() == null : this.getClassification().equals(other.getClassification()))
            && (this.getChineseName() == null ? other.getChineseName() == null : this.getChineseName().equals(other.getChineseName()))
            && (this.getEnglishName() == null ? other.getEnglishName() == null : this.getEnglishName().equals(other.getEnglishName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIcaoCd() == null) ? 0 : getIcaoCd().hashCode());
        result = prime * result + ((getIataCd() == null) ? 0 : getIataCd().hashCode());
        result = prime * result + ((getClassification() == null) ? 0 : getClassification().hashCode());
        result = prime * result + ((getChineseName() == null) ? 0 : getChineseName().hashCode());
        result = prime * result + ((getEnglishName() == null) ? 0 : getEnglishName().hashCode());
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
        sb.append(", icaoCd=").append(icaoCd);
        sb.append(", iataCd=").append(iataCd);
        sb.append(", classification=").append(classification);
        sb.append(", chineseName=").append(chineseName);
        sb.append(", englishName=").append(englishName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}