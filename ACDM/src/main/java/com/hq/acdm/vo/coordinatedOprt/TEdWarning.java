package com.hq.acdm.vo.coordinatedOprt;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TEdWarning implements Serializable {
    private String id;

    private String edId;

    private String level;

    private String factorsPeriod;

    private String descendCapacity;

    private String isCoordinated;

    private String isScheduleAdjustmnet;

    private String adjustPeriod;

    private String adjustRatio;

    private String originalPlanGs;

    private String originalPlanMu;

    private String originalPlanCz;

    private String originalPlanCa;

    private String originalPlanBk;

    private String originalPlanHj;

    private String adjustPlanGs;

    private String adjustPlanMu;

    private String adjustPlanCz;

    private String adjustPlanCa;

    private String adjustPlanBk;

    private String adjustPlanHj;

    private String adjustedGs;

    private String adjustedMu;

    private String adjustedCz;

    private String adjustedCa;

    private String adjustedBk;

    private String adjustedHj;

    private String adjustedPlanSum;

    private String adjustedPlandSum;

    private String adjustedPlanaSum;

    private String specialPlane;

    private String mattersCoordinated;

    private String otherSpecial;

    private String ndManager;

    private String ndManagerPhone;

    private String ndApmng;

    private String ndApmngPhone;

    private String preparer;

    private Date fillingTime;

    private Date cutoffTime;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEdId() {
        return edId;
    }

    public void setEdId(String edId) {
        this.edId = edId == null ? null : edId.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getFactorsPeriod() {
        return factorsPeriod;
    }

    public void setFactorsPeriod(String factorsPeriod) {
        this.factorsPeriod = factorsPeriod == null ? null : factorsPeriod.trim();
    }

    public String getDescendCapacity() {
        return descendCapacity;
    }

    public void setDescendCapacity(String descendCapacity) {
        this.descendCapacity = descendCapacity == null ? null : descendCapacity.trim();
    }

    public String getIsCoordinated() {
        return isCoordinated;
    }

    public void setIsCoordinated(String isCoordinated) {
        this.isCoordinated = isCoordinated == null ? null : isCoordinated.trim();
    }

    public String getIsScheduleAdjustmnet() {
        return isScheduleAdjustmnet;
    }

    public void setIsScheduleAdjustmnet(String isScheduleAdjustmnet) {
        this.isScheduleAdjustmnet = isScheduleAdjustmnet == null ? null : isScheduleAdjustmnet.trim();
    }

    public String getAdjustPeriod() {
        return adjustPeriod;
    }

    public void setAdjustPeriod(String adjustPeriod) {
        this.adjustPeriod = adjustPeriod == null ? null : adjustPeriod.trim();
    }

    public String getAdjustRatio() {
        return adjustRatio;
    }

    public void setAdjustRatio(String adjustRatio) {
        this.adjustRatio = adjustRatio == null ? null : adjustRatio.trim();
    }

    public String getOriginalPlanGs() {
        return originalPlanGs;
    }

    public void setOriginalPlanGs(String originalPlanGs) {
        this.originalPlanGs = originalPlanGs == null ? null : originalPlanGs.trim();
    }

    public String getOriginalPlanMu() {
        return originalPlanMu;
    }

    public void setOriginalPlanMu(String originalPlanMu) {
        this.originalPlanMu = originalPlanMu == null ? null : originalPlanMu.trim();
    }

    public String getOriginalPlanCz() {
        return originalPlanCz;
    }

    public void setOriginalPlanCz(String originalPlanCz) {
        this.originalPlanCz = originalPlanCz == null ? null : originalPlanCz.trim();
    }

    public String getOriginalPlanCa() {
        return originalPlanCa;
    }

    public void setOriginalPlanCa(String originalPlanCa) {
        this.originalPlanCa = originalPlanCa == null ? null : originalPlanCa.trim();
    }

    public String getOriginalPlanBk() {
        return originalPlanBk;
    }

    public void setOriginalPlanBk(String originalPlanBk) {
        this.originalPlanBk = originalPlanBk == null ? null : originalPlanBk.trim();
    }

    public String getOriginalPlanHj() {
        return originalPlanHj;
    }

    public void setOriginalPlanHj(String originalPlanHj) {
        this.originalPlanHj = originalPlanHj == null ? null : originalPlanHj.trim();
    }

    public String getAdjustPlanGs() {
        return adjustPlanGs;
    }

    public void setAdjustPlanGs(String adjustPlanGs) {
        this.adjustPlanGs = adjustPlanGs == null ? null : adjustPlanGs.trim();
    }

    public String getAdjustPlanMu() {
        return adjustPlanMu;
    }

    public void setAdjustPlanMu(String adjustPlanMu) {
        this.adjustPlanMu = adjustPlanMu == null ? null : adjustPlanMu.trim();
    }

    public String getAdjustPlanCz() {
        return adjustPlanCz;
    }

    public void setAdjustPlanCz(String adjustPlanCz) {
        this.adjustPlanCz = adjustPlanCz == null ? null : adjustPlanCz.trim();
    }

    public String getAdjustPlanCa() {
        return adjustPlanCa;
    }

    public void setAdjustPlanCa(String adjustPlanCa) {
        this.adjustPlanCa = adjustPlanCa == null ? null : adjustPlanCa.trim();
    }

    public String getAdjustPlanBk() {
        return adjustPlanBk;
    }

    public void setAdjustPlanBk(String adjustPlanBk) {
        this.adjustPlanBk = adjustPlanBk == null ? null : adjustPlanBk.trim();
    }

    public String getAdjustPlanHj() {
        return adjustPlanHj;
    }

    public void setAdjustPlanHj(String adjustPlanHj) {
        this.adjustPlanHj = adjustPlanHj == null ? null : adjustPlanHj.trim();
    }

    public String getAdjustedGs() {
        return adjustedGs;
    }

    public void setAdjustedGs(String adjustedGs) {
        this.adjustedGs = adjustedGs == null ? null : adjustedGs.trim();
    }

    public String getAdjustedMu() {
        return adjustedMu;
    }

    public void setAdjustedMu(String adjustedMu) {
        this.adjustedMu = adjustedMu == null ? null : adjustedMu.trim();
    }

    public String getAdjustedCz() {
        return adjustedCz;
    }

    public void setAdjustedCz(String adjustedCz) {
        this.adjustedCz = adjustedCz == null ? null : adjustedCz.trim();
    }

    public String getAdjustedCa() {
        return adjustedCa;
    }

    public void setAdjustedCa(String adjustedCa) {
        this.adjustedCa = adjustedCa == null ? null : adjustedCa.trim();
    }

    public String getAdjustedBk() {
        return adjustedBk;
    }

    public void setAdjustedBk(String adjustedBk) {
        this.adjustedBk = adjustedBk == null ? null : adjustedBk.trim();
    }

    public String getAdjustedHj() {
        return adjustedHj;
    }

    public void setAdjustedHj(String adjustedHj) {
        this.adjustedHj = adjustedHj == null ? null : adjustedHj.trim();
    }

    public String getAdjustedPlanSum() {
        return adjustedPlanSum;
    }

    public void setAdjustedPlanSum(String adjustedPlanSum) {
        this.adjustedPlanSum = adjustedPlanSum == null ? null : adjustedPlanSum.trim();
    }

    public String getAdjustedPlandSum() {
        return adjustedPlandSum;
    }

    public void setAdjustedPlandSum(String adjustedPlandSum) {
        this.adjustedPlandSum = adjustedPlandSum == null ? null : adjustedPlandSum.trim();
    }

    public String getAdjustedPlanaSum() {
        return adjustedPlanaSum;
    }

    public void setAdjustedPlanaSum(String adjustedPlanaSum) {
        this.adjustedPlanaSum = adjustedPlanaSum == null ? null : adjustedPlanaSum.trim();
    }

    public String getSpecialPlane() {
        return specialPlane;
    }

    public void setSpecialPlane(String specialPlane) {
        this.specialPlane = specialPlane == null ? null : specialPlane.trim();
    }

    public String getMattersCoordinated() {
        return mattersCoordinated;
    }

    public void setMattersCoordinated(String mattersCoordinated) {
        this.mattersCoordinated = mattersCoordinated == null ? null : mattersCoordinated.trim();
    }

    public String getOtherSpecial() {
        return otherSpecial;
    }

    public void setOtherSpecial(String otherSpecial) {
        this.otherSpecial = otherSpecial == null ? null : otherSpecial.trim();
    }

    public String getNdManager() {
        return ndManager;
    }

    public void setNdManager(String ndManager) {
        this.ndManager = ndManager == null ? null : ndManager.trim();
    }

    public String getNdManagerPhone() {
        return ndManagerPhone;
    }

    public void setNdManagerPhone(String ndManagerPhone) {
        this.ndManagerPhone = ndManagerPhone == null ? null : ndManagerPhone.trim();
    }

    public String getNdApmng() {
        return ndApmng;
    }

    public void setNdApmng(String ndApmng) {
        this.ndApmng = ndApmng == null ? null : ndApmng.trim();
    }

    public String getNdApmngPhone() {
        return ndApmngPhone;
    }

    public void setNdApmngPhone(String ndApmngPhone) {
        this.ndApmngPhone = ndApmngPhone == null ? null : ndApmngPhone.trim();
    }

    public String getPreparer() {
        return preparer;
    }

    public void setPreparer(String preparer) {
        this.preparer = preparer == null ? null : preparer.trim();
    }

    public Date getFillingTime() {
        return fillingTime;
    }

    public void setFillingTime(Date fillingTime) {
        this.fillingTime = fillingTime;
    }

    public Date getCutoffTime() {
        return cutoffTime;
    }

    public void setCutoffTime(Date cutoffTime) {
        this.cutoffTime = cutoffTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        TEdWarning other = (TEdWarning) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEdId() == null ? other.getEdId() == null : this.getEdId().equals(other.getEdId()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getFactorsPeriod() == null ? other.getFactorsPeriod() == null : this.getFactorsPeriod().equals(other.getFactorsPeriod()))
            && (this.getDescendCapacity() == null ? other.getDescendCapacity() == null : this.getDescendCapacity().equals(other.getDescendCapacity()))
            && (this.getIsCoordinated() == null ? other.getIsCoordinated() == null : this.getIsCoordinated().equals(other.getIsCoordinated()))
            && (this.getIsScheduleAdjustmnet() == null ? other.getIsScheduleAdjustmnet() == null : this.getIsScheduleAdjustmnet().equals(other.getIsScheduleAdjustmnet()))
            && (this.getAdjustPeriod() == null ? other.getAdjustPeriod() == null : this.getAdjustPeriod().equals(other.getAdjustPeriod()))
            && (this.getAdjustRatio() == null ? other.getAdjustRatio() == null : this.getAdjustRatio().equals(other.getAdjustRatio()))
            && (this.getOriginalPlanGs() == null ? other.getOriginalPlanGs() == null : this.getOriginalPlanGs().equals(other.getOriginalPlanGs()))
            && (this.getOriginalPlanMu() == null ? other.getOriginalPlanMu() == null : this.getOriginalPlanMu().equals(other.getOriginalPlanMu()))
            && (this.getOriginalPlanCz() == null ? other.getOriginalPlanCz() == null : this.getOriginalPlanCz().equals(other.getOriginalPlanCz()))
            && (this.getOriginalPlanCa() == null ? other.getOriginalPlanCa() == null : this.getOriginalPlanCa().equals(other.getOriginalPlanCa()))
            && (this.getOriginalPlanBk() == null ? other.getOriginalPlanBk() == null : this.getOriginalPlanBk().equals(other.getOriginalPlanBk()))
            && (this.getOriginalPlanHj() == null ? other.getOriginalPlanHj() == null : this.getOriginalPlanHj().equals(other.getOriginalPlanHj()))
            && (this.getAdjustPlanGs() == null ? other.getAdjustPlanGs() == null : this.getAdjustPlanGs().equals(other.getAdjustPlanGs()))
            && (this.getAdjustPlanMu() == null ? other.getAdjustPlanMu() == null : this.getAdjustPlanMu().equals(other.getAdjustPlanMu()))
            && (this.getAdjustPlanCz() == null ? other.getAdjustPlanCz() == null : this.getAdjustPlanCz().equals(other.getAdjustPlanCz()))
            && (this.getAdjustPlanCa() == null ? other.getAdjustPlanCa() == null : this.getAdjustPlanCa().equals(other.getAdjustPlanCa()))
            && (this.getAdjustPlanBk() == null ? other.getAdjustPlanBk() == null : this.getAdjustPlanBk().equals(other.getAdjustPlanBk()))
            && (this.getAdjustPlanHj() == null ? other.getAdjustPlanHj() == null : this.getAdjustPlanHj().equals(other.getAdjustPlanHj()))
            && (this.getAdjustedGs() == null ? other.getAdjustedGs() == null : this.getAdjustedGs().equals(other.getAdjustedGs()))
            && (this.getAdjustedMu() == null ? other.getAdjustedMu() == null : this.getAdjustedMu().equals(other.getAdjustedMu()))
            && (this.getAdjustedCz() == null ? other.getAdjustedCz() == null : this.getAdjustedCz().equals(other.getAdjustedCz()))
            && (this.getAdjustedCa() == null ? other.getAdjustedCa() == null : this.getAdjustedCa().equals(other.getAdjustedCa()))
            && (this.getAdjustedBk() == null ? other.getAdjustedBk() == null : this.getAdjustedBk().equals(other.getAdjustedBk()))
            && (this.getAdjustedHj() == null ? other.getAdjustedHj() == null : this.getAdjustedHj().equals(other.getAdjustedHj()))
            && (this.getAdjustedPlanSum() == null ? other.getAdjustedPlanSum() == null : this.getAdjustedPlanSum().equals(other.getAdjustedPlanSum()))
            && (this.getAdjustedPlandSum() == null ? other.getAdjustedPlandSum() == null : this.getAdjustedPlandSum().equals(other.getAdjustedPlandSum()))
            && (this.getAdjustedPlanaSum() == null ? other.getAdjustedPlanaSum() == null : this.getAdjustedPlanaSum().equals(other.getAdjustedPlanaSum()))
            && (this.getSpecialPlane() == null ? other.getSpecialPlane() == null : this.getSpecialPlane().equals(other.getSpecialPlane()))
            && (this.getMattersCoordinated() == null ? other.getMattersCoordinated() == null : this.getMattersCoordinated().equals(other.getMattersCoordinated()))
            && (this.getOtherSpecial() == null ? other.getOtherSpecial() == null : this.getOtherSpecial().equals(other.getOtherSpecial()))
            && (this.getNdManager() == null ? other.getNdManager() == null : this.getNdManager().equals(other.getNdManager()))
            && (this.getNdManagerPhone() == null ? other.getNdManagerPhone() == null : this.getNdManagerPhone().equals(other.getNdManagerPhone()))
            && (this.getNdApmng() == null ? other.getNdApmng() == null : this.getNdApmng().equals(other.getNdApmng()))
            && (this.getNdApmngPhone() == null ? other.getNdApmngPhone() == null : this.getNdApmngPhone().equals(other.getNdApmngPhone()))
            && (this.getPreparer() == null ? other.getPreparer() == null : this.getPreparer().equals(other.getPreparer()))
            && (this.getFillingTime() == null ? other.getFillingTime() == null : this.getFillingTime().equals(other.getFillingTime()))
            && (this.getCutoffTime() == null ? other.getCutoffTime() == null : this.getCutoffTime().equals(other.getCutoffTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEdId() == null) ? 0 : getEdId().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getFactorsPeriod() == null) ? 0 : getFactorsPeriod().hashCode());
        result = prime * result + ((getDescendCapacity() == null) ? 0 : getDescendCapacity().hashCode());
        result = prime * result + ((getIsCoordinated() == null) ? 0 : getIsCoordinated().hashCode());
        result = prime * result + ((getIsScheduleAdjustmnet() == null) ? 0 : getIsScheduleAdjustmnet().hashCode());
        result = prime * result + ((getAdjustPeriod() == null) ? 0 : getAdjustPeriod().hashCode());
        result = prime * result + ((getAdjustRatio() == null) ? 0 : getAdjustRatio().hashCode());
        result = prime * result + ((getOriginalPlanGs() == null) ? 0 : getOriginalPlanGs().hashCode());
        result = prime * result + ((getOriginalPlanMu() == null) ? 0 : getOriginalPlanMu().hashCode());
        result = prime * result + ((getOriginalPlanCz() == null) ? 0 : getOriginalPlanCz().hashCode());
        result = prime * result + ((getOriginalPlanCa() == null) ? 0 : getOriginalPlanCa().hashCode());
        result = prime * result + ((getOriginalPlanBk() == null) ? 0 : getOriginalPlanBk().hashCode());
        result = prime * result + ((getOriginalPlanHj() == null) ? 0 : getOriginalPlanHj().hashCode());
        result = prime * result + ((getAdjustPlanGs() == null) ? 0 : getAdjustPlanGs().hashCode());
        result = prime * result + ((getAdjustPlanMu() == null) ? 0 : getAdjustPlanMu().hashCode());
        result = prime * result + ((getAdjustPlanCz() == null) ? 0 : getAdjustPlanCz().hashCode());
        result = prime * result + ((getAdjustPlanCa() == null) ? 0 : getAdjustPlanCa().hashCode());
        result = prime * result + ((getAdjustPlanBk() == null) ? 0 : getAdjustPlanBk().hashCode());
        result = prime * result + ((getAdjustPlanHj() == null) ? 0 : getAdjustPlanHj().hashCode());
        result = prime * result + ((getAdjustedGs() == null) ? 0 : getAdjustedGs().hashCode());
        result = prime * result + ((getAdjustedMu() == null) ? 0 : getAdjustedMu().hashCode());
        result = prime * result + ((getAdjustedCz() == null) ? 0 : getAdjustedCz().hashCode());
        result = prime * result + ((getAdjustedCa() == null) ? 0 : getAdjustedCa().hashCode());
        result = prime * result + ((getAdjustedBk() == null) ? 0 : getAdjustedBk().hashCode());
        result = prime * result + ((getAdjustedHj() == null) ? 0 : getAdjustedHj().hashCode());
        result = prime * result + ((getAdjustedPlanSum() == null) ? 0 : getAdjustedPlanSum().hashCode());
        result = prime * result + ((getAdjustedPlandSum() == null) ? 0 : getAdjustedPlandSum().hashCode());
        result = prime * result + ((getAdjustedPlanaSum() == null) ? 0 : getAdjustedPlanaSum().hashCode());
        result = prime * result + ((getSpecialPlane() == null) ? 0 : getSpecialPlane().hashCode());
        result = prime * result + ((getMattersCoordinated() == null) ? 0 : getMattersCoordinated().hashCode());
        result = prime * result + ((getOtherSpecial() == null) ? 0 : getOtherSpecial().hashCode());
        result = prime * result + ((getNdManager() == null) ? 0 : getNdManager().hashCode());
        result = prime * result + ((getNdManagerPhone() == null) ? 0 : getNdManagerPhone().hashCode());
        result = prime * result + ((getNdApmng() == null) ? 0 : getNdApmng().hashCode());
        result = prime * result + ((getNdApmngPhone() == null) ? 0 : getNdApmngPhone().hashCode());
        result = prime * result + ((getPreparer() == null) ? 0 : getPreparer().hashCode());
        result = prime * result + ((getFillingTime() == null) ? 0 : getFillingTime().hashCode());
        result = prime * result + ((getCutoffTime() == null) ? 0 : getCutoffTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", edId=").append(edId);
        sb.append(", level=").append(level);
        sb.append(", factorsPeriod=").append(factorsPeriod);
        sb.append(", descendCapacity=").append(descendCapacity);
        sb.append(", isCoordinated=").append(isCoordinated);
        sb.append(", isScheduleAdjustmnet=").append(isScheduleAdjustmnet);
        sb.append(", adjustPeriod=").append(adjustPeriod);
        sb.append(", adjustRatio=").append(adjustRatio);
        sb.append(", originalPlanGs=").append(originalPlanGs);
        sb.append(", originalPlanMu=").append(originalPlanMu);
        sb.append(", originalPlanCz=").append(originalPlanCz);
        sb.append(", originalPlanCa=").append(originalPlanCa);
        sb.append(", originalPlanBk=").append(originalPlanBk);
        sb.append(", originalPlanHj=").append(originalPlanHj);
        sb.append(", adjustPlanGs=").append(adjustPlanGs);
        sb.append(", adjustPlanMu=").append(adjustPlanMu);
        sb.append(", adjustPlanCz=").append(adjustPlanCz);
        sb.append(", adjustPlanCa=").append(adjustPlanCa);
        sb.append(", adjustPlanBk=").append(adjustPlanBk);
        sb.append(", adjustPlanHj=").append(adjustPlanHj);
        sb.append(", adjustedGs=").append(adjustedGs);
        sb.append(", adjustedMu=").append(adjustedMu);
        sb.append(", adjustedCz=").append(adjustedCz);
        sb.append(", adjustedCa=").append(adjustedCa);
        sb.append(", adjustedBk=").append(adjustedBk);
        sb.append(", adjustedHj=").append(adjustedHj);
        sb.append(", adjustedPlanSum=").append(adjustedPlanSum);
        sb.append(", adjustedPlandSum=").append(adjustedPlandSum);
        sb.append(", adjustedPlanaSum=").append(adjustedPlanaSum);
        sb.append(", specialPlane=").append(specialPlane);
        sb.append(", mattersCoordinated=").append(mattersCoordinated);
        sb.append(", otherSpecial=").append(otherSpecial);
        sb.append(", ndManager=").append(ndManager);
        sb.append(", ndManagerPhone=").append(ndManagerPhone);
        sb.append(", ndApmng=").append(ndApmng);
        sb.append(", ndApmngPhone=").append(ndApmngPhone);
        sb.append(", preparer=").append(preparer);
        sb.append(", fillingTime=").append(fillingTime);
        sb.append(", cutoffTime=").append(cutoffTime);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}