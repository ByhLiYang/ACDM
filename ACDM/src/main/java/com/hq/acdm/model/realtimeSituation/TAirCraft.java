package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TAirCraft implements Serializable {
    private String id;

    private String code;

    private String craftTypeIcaoCd;

    private String airlineTwoCharCd;

    private Integer seatMaxNumber;

    private Integer supportSeatNumber;

    private String airlineBranch;

    private String maxTakeoffWeight;

    private String maxLoadWeight;

    private String supportLoadWeight;

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

    public String getCraftTypeIcaoCd() {
        return craftTypeIcaoCd;
    }

    public void setCraftTypeIcaoCd(String craftTypeIcaoCd) {
        this.craftTypeIcaoCd = craftTypeIcaoCd == null ? null : craftTypeIcaoCd.trim();
    }

    public String getAirlineTwoCharCd() {
        return airlineTwoCharCd;
    }

    public void setAirlineTwoCharCd(String airlineTwoCharCd) {
        this.airlineTwoCharCd = airlineTwoCharCd == null ? null : airlineTwoCharCd.trim();
    }

    public Integer getSeatMaxNumber() {
        return seatMaxNumber;
    }

    public void setSeatMaxNumber(Integer seatMaxNumber) {
        this.seatMaxNumber = seatMaxNumber;
    }

    public Integer getSupportSeatNumber() {
        return supportSeatNumber;
    }

    public void setSupportSeatNumber(Integer supportSeatNumber) {
        this.supportSeatNumber = supportSeatNumber;
    }

    public String getAirlineBranch() {
        return airlineBranch;
    }

    public void setAirlineBranch(String airlineBranch) {
        this.airlineBranch = airlineBranch == null ? null : airlineBranch.trim();
    }

    public String getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public void setMaxTakeoffWeight(String maxTakeoffWeight) {
        this.maxTakeoffWeight = maxTakeoffWeight == null ? null : maxTakeoffWeight.trim();
    }

    public String getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public void setMaxLoadWeight(String maxLoadWeight) {
        this.maxLoadWeight = maxLoadWeight == null ? null : maxLoadWeight.trim();
    }

    public String getSupportLoadWeight() {
        return supportLoadWeight;
    }

    public void setSupportLoadWeight(String supportLoadWeight) {
        this.supportLoadWeight = supportLoadWeight == null ? null : supportLoadWeight.trim();
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
        TAirCraft other = (TAirCraft) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getCraftTypeIcaoCd() == null ? other.getCraftTypeIcaoCd() == null : this.getCraftTypeIcaoCd().equals(other.getCraftTypeIcaoCd()))
            && (this.getAirlineTwoCharCd() == null ? other.getAirlineTwoCharCd() == null : this.getAirlineTwoCharCd().equals(other.getAirlineTwoCharCd()))
            && (this.getSeatMaxNumber() == null ? other.getSeatMaxNumber() == null : this.getSeatMaxNumber().equals(other.getSeatMaxNumber()))
            && (this.getSupportSeatNumber() == null ? other.getSupportSeatNumber() == null : this.getSupportSeatNumber().equals(other.getSupportSeatNumber()))
            && (this.getAirlineBranch() == null ? other.getAirlineBranch() == null : this.getAirlineBranch().equals(other.getAirlineBranch()))
            && (this.getMaxTakeoffWeight() == null ? other.getMaxTakeoffWeight() == null : this.getMaxTakeoffWeight().equals(other.getMaxTakeoffWeight()))
            && (this.getMaxLoadWeight() == null ? other.getMaxLoadWeight() == null : this.getMaxLoadWeight().equals(other.getMaxLoadWeight()))
            && (this.getSupportLoadWeight() == null ? other.getSupportLoadWeight() == null : this.getSupportLoadWeight().equals(other.getSupportLoadWeight()))
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
        result = prime * result + ((getCraftTypeIcaoCd() == null) ? 0 : getCraftTypeIcaoCd().hashCode());
        result = prime * result + ((getAirlineTwoCharCd() == null) ? 0 : getAirlineTwoCharCd().hashCode());
        result = prime * result + ((getSeatMaxNumber() == null) ? 0 : getSeatMaxNumber().hashCode());
        result = prime * result + ((getSupportSeatNumber() == null) ? 0 : getSupportSeatNumber().hashCode());
        result = prime * result + ((getAirlineBranch() == null) ? 0 : getAirlineBranch().hashCode());
        result = prime * result + ((getMaxTakeoffWeight() == null) ? 0 : getMaxTakeoffWeight().hashCode());
        result = prime * result + ((getMaxLoadWeight() == null) ? 0 : getMaxLoadWeight().hashCode());
        result = prime * result + ((getSupportLoadWeight() == null) ? 0 : getSupportLoadWeight().hashCode());
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
        sb.append(", craftTypeIcaoCd=").append(craftTypeIcaoCd);
        sb.append(", airlineTwoCharCd=").append(airlineTwoCharCd);
        sb.append(", seatMaxNumber=").append(seatMaxNumber);
        sb.append(", supportSeatNumber=").append(supportSeatNumber);
        sb.append(", airlineBranch=").append(airlineBranch);
        sb.append(", maxTakeoffWeight=").append(maxTakeoffWeight);
        sb.append(", maxLoadWeight=").append(maxLoadWeight);
        sb.append(", supportLoadWeight=").append(supportLoadWeight);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}