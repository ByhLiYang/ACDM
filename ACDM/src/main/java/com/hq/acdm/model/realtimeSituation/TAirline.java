package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TAirline implements Serializable {
    private String id;

    private String twoCharCd;

    private String threeCharCd;

    private String attribute;

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

    public String getTwoCharCd() {
        return twoCharCd;
    }

    public void setTwoCharCd(String twoCharCd) {
        this.twoCharCd = twoCharCd == null ? null : twoCharCd.trim();
    }

    public String getThreeCharCd() {
        return threeCharCd;
    }

    public void setThreeCharCd(String threeCharCd) {
        this.threeCharCd = threeCharCd == null ? null : threeCharCd.trim();
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
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
        TAirline other = (TAirline) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTwoCharCd() == null ? other.getTwoCharCd() == null : this.getTwoCharCd().equals(other.getTwoCharCd()))
            && (this.getThreeCharCd() == null ? other.getThreeCharCd() == null : this.getThreeCharCd().equals(other.getThreeCharCd()))
            && (this.getAttribute() == null ? other.getAttribute() == null : this.getAttribute().equals(other.getAttribute()))
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
        result = prime * result + ((getTwoCharCd() == null) ? 0 : getTwoCharCd().hashCode());
        result = prime * result + ((getThreeCharCd() == null) ? 0 : getThreeCharCd().hashCode());
        result = prime * result + ((getAttribute() == null) ? 0 : getAttribute().hashCode());
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
        sb.append(", twoCharCd=").append(twoCharCd);
        sb.append(", threeCharCd=").append(threeCharCd);
        sb.append(", attribute=").append(attribute);
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