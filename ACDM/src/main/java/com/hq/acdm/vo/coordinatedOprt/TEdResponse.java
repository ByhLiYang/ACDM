package com.hq.acdm.vo.coordinatedOprt;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TEdResponse implements Serializable {
    private String id;

    private String edId;

    private String level;

    private String factorsPeriod;

    private String descendCapacity;

    private String curdatePlana;

    private String curdatePland;

    private String curtimePlana;

    private String curtimePland;

    private String executedA;

    private String executedD;

    private String canceledA;

    private String canceledD;

    private String returnAlternate;

    private String hourPlana;

    private String hourActuala;

    private String hourPland;

    private String hourActuald;

    private String freeStand;

    private String delayRatio;

    private String delayFlno;

    private String dclsRatio;

    private String dclsFlno;

    private String executiveCdtn;

    private String specialPlane;

    private String terminalOrder;

    private String mattersCoordinated;

    private String otherSpecial;

    private String curdateManager;

    private String curdateManagerPhone;

    private String curdateApmng;

    private String curdateApmngPhone;

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

    public String getCurdatePlana() {
        return curdatePlana;
    }

    public void setCurdatePlana(String curdatePlana) {
        this.curdatePlana = curdatePlana == null ? null : curdatePlana.trim();
    }

    public String getCurdatePland() {
        return curdatePland;
    }

    public void setCurdatePland(String curdatePland) {
        this.curdatePland = curdatePland == null ? null : curdatePland.trim();
    }

    public String getCurtimePlana() {
        return curtimePlana;
    }

    public void setCurtimePlana(String curtimePlana) {
        this.curtimePlana = curtimePlana == null ? null : curtimePlana.trim();
    }

    public String getCurtimePland() {
        return curtimePland;
    }

    public void setCurtimePland(String curtimePland) {
        this.curtimePland = curtimePland == null ? null : curtimePland.trim();
    }

    public String getExecutedA() {
        return executedA;
    }

    public void setExecutedA(String executedA) {
        this.executedA = executedA == null ? null : executedA.trim();
    }

    public String getExecutedD() {
        return executedD;
    }

    public void setExecutedD(String executedD) {
        this.executedD = executedD == null ? null : executedD.trim();
    }

    public String getCanceledA() {
        return canceledA;
    }

    public void setCanceledA(String canceledA) {
        this.canceledA = canceledA == null ? null : canceledA.trim();
    }

    public String getCanceledD() {
        return canceledD;
    }

    public void setCanceledD(String canceledD) {
        this.canceledD = canceledD == null ? null : canceledD.trim();
    }

    public String getReturnAlternate() {
        return returnAlternate;
    }

    public void setReturnAlternate(String returnAlternate) {
        this.returnAlternate = returnAlternate == null ? null : returnAlternate.trim();
    }

    public String getHourPlana() {
        return hourPlana;
    }

    public void setHourPlana(String hourPlana) {
        this.hourPlana = hourPlana == null ? null : hourPlana.trim();
    }

    public String getHourActuala() {
        return hourActuala;
    }

    public void setHourActuala(String hourActuala) {
        this.hourActuala = hourActuala == null ? null : hourActuala.trim();
    }

    public String getHourPland() {
        return hourPland;
    }

    public void setHourPland(String hourPland) {
        this.hourPland = hourPland == null ? null : hourPland.trim();
    }

    public String getHourActuald() {
        return hourActuald;
    }

    public void setHourActuald(String hourActuald) {
        this.hourActuald = hourActuald == null ? null : hourActuald.trim();
    }

    public String getFreeStand() {
        return freeStand;
    }

    public void setFreeStand(String freeStand) {
        this.freeStand = freeStand == null ? null : freeStand.trim();
    }

    public String getDelayRatio() {
        return delayRatio;
    }

    public void setDelayRatio(String delayRatio) {
        this.delayRatio = delayRatio == null ? null : delayRatio.trim();
    }

    public String getDelayFlno() {
        return delayFlno;
    }

    public void setDelayFlno(String delayFlno) {
        this.delayFlno = delayFlno == null ? null : delayFlno.trim();
    }

    public String getDclsRatio() {
        return dclsRatio;
    }

    public void setDclsRatio(String dclsRatio) {
        this.dclsRatio = dclsRatio == null ? null : dclsRatio.trim();
    }

    public String getDclsFlno() {
        return dclsFlno;
    }

    public void setDclsFlno(String dclsFlno) {
        this.dclsFlno = dclsFlno == null ? null : dclsFlno.trim();
    }

    public String getExecutiveCdtn() {
        return executiveCdtn;
    }

    public void setExecutiveCdtn(String executiveCdtn) {
        this.executiveCdtn = executiveCdtn == null ? null : executiveCdtn.trim();
    }

    public String getSpecialPlane() {
        return specialPlane;
    }

    public void setSpecialPlane(String specialPlane) {
        this.specialPlane = specialPlane == null ? null : specialPlane.trim();
    }

    public String getTerminalOrder() {
        return terminalOrder;
    }

    public void setTerminalOrder(String terminalOrder) {
        this.terminalOrder = terminalOrder == null ? null : terminalOrder.trim();
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

    public String getCurdateManager() {
        return curdateManager;
    }

    public void setCurdateManager(String curdateManager) {
        this.curdateManager = curdateManager == null ? null : curdateManager.trim();
    }

    public String getCurdateManagerPhone() {
        return curdateManagerPhone;
    }

    public void setCurdateManagerPhone(String curdateManagerPhone) {
        this.curdateManagerPhone = curdateManagerPhone == null ? null : curdateManagerPhone.trim();
    }

    public String getCurdateApmng() {
        return curdateApmng;
    }

    public void setCurdateApmng(String curdateApmng) {
        this.curdateApmng = curdateApmng == null ? null : curdateApmng.trim();
    }

    public String getCurdateApmngPhone() {
        return curdateApmngPhone;
    }

    public void setCurdateApmngPhone(String curdateApmngPhone) {
        this.curdateApmngPhone = curdateApmngPhone;
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
        TEdResponse other = (TEdResponse) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEdId() == null ? other.getEdId() == null : this.getEdId().equals(other.getEdId()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getFactorsPeriod() == null ? other.getFactorsPeriod() == null : this.getFactorsPeriod().equals(other.getFactorsPeriod()))
            && (this.getDescendCapacity() == null ? other.getDescendCapacity() == null : this.getDescendCapacity().equals(other.getDescendCapacity()))
            && (this.getCurdatePlana() == null ? other.getCurdatePlana() == null : this.getCurdatePlana().equals(other.getCurdatePlana()))
            && (this.getCurdatePland() == null ? other.getCurdatePland() == null : this.getCurdatePland().equals(other.getCurdatePland()))
            && (this.getCurtimePlana() == null ? other.getCurtimePlana() == null : this.getCurtimePlana().equals(other.getCurtimePlana()))
            && (this.getCurtimePland() == null ? other.getCurtimePland() == null : this.getCurtimePland().equals(other.getCurtimePland()))
            && (this.getExecutedA() == null ? other.getExecutedA() == null : this.getExecutedA().equals(other.getExecutedA()))
            && (this.getExecutedD() == null ? other.getExecutedD() == null : this.getExecutedD().equals(other.getExecutedD()))
            && (this.getCanceledA() == null ? other.getCanceledA() == null : this.getCanceledA().equals(other.getCanceledA()))
            && (this.getCanceledD() == null ? other.getCanceledD() == null : this.getCanceledD().equals(other.getCanceledD()))
            && (this.getReturnAlternate() == null ? other.getReturnAlternate() == null : this.getReturnAlternate().equals(other.getReturnAlternate()))
            && (this.getHourPlana() == null ? other.getHourPlana() == null : this.getHourPlana().equals(other.getHourPlana()))
            && (this.getHourActuala() == null ? other.getHourActuala() == null : this.getHourActuala().equals(other.getHourActuala()))
            && (this.getHourPland() == null ? other.getHourPland() == null : this.getHourPland().equals(other.getHourPland()))
            && (this.getHourActuald() == null ? other.getHourActuald() == null : this.getHourActuald().equals(other.getHourActuald()))
            && (this.getFreeStand() == null ? other.getFreeStand() == null : this.getFreeStand().equals(other.getFreeStand()))
            && (this.getDelayRatio() == null ? other.getDelayRatio() == null : this.getDelayRatio().equals(other.getDelayRatio()))
            && (this.getDelayFlno() == null ? other.getDelayFlno() == null : this.getDelayFlno().equals(other.getDelayFlno()))
            && (this.getDclsRatio() == null ? other.getDclsRatio() == null : this.getDclsRatio().equals(other.getDclsRatio()))
            && (this.getDclsFlno() == null ? other.getDclsFlno() == null : this.getDclsFlno().equals(other.getDclsFlno()))
            && (this.getExecutiveCdtn() == null ? other.getExecutiveCdtn() == null : this.getExecutiveCdtn().equals(other.getExecutiveCdtn()))
            && (this.getSpecialPlane() == null ? other.getSpecialPlane() == null : this.getSpecialPlane().equals(other.getSpecialPlane()))
            && (this.getTerminalOrder() == null ? other.getTerminalOrder() == null : this.getTerminalOrder().equals(other.getTerminalOrder()))
            && (this.getMattersCoordinated() == null ? other.getMattersCoordinated() == null : this.getMattersCoordinated().equals(other.getMattersCoordinated()))
            && (this.getOtherSpecial() == null ? other.getOtherSpecial() == null : this.getOtherSpecial().equals(other.getOtherSpecial()))
            && (this.getCurdateManager() == null ? other.getCurdateManager() == null : this.getCurdateManager().equals(other.getCurdateManager()))
            && (this.getCurdateManagerPhone() == null ? other.getCurdateManagerPhone() == null : this.getCurdateManagerPhone().equals(other.getCurdateManagerPhone()))
            && (this.getCurdateApmng() == null ? other.getCurdateApmng() == null : this.getCurdateApmng().equals(other.getCurdateApmng()))
            && (this.getCurdateApmngPhone() == null ? other.getCurdateApmngPhone() == null : this.getCurdateApmngPhone().equals(other.getCurdateApmngPhone()))
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
        result = prime * result + ((getCurdatePlana() == null) ? 0 : getCurdatePlana().hashCode());
        result = prime * result + ((getCurdatePland() == null) ? 0 : getCurdatePland().hashCode());
        result = prime * result + ((getCurtimePlana() == null) ? 0 : getCurtimePlana().hashCode());
        result = prime * result + ((getCurtimePland() == null) ? 0 : getCurtimePland().hashCode());
        result = prime * result + ((getExecutedA() == null) ? 0 : getExecutedA().hashCode());
        result = prime * result + ((getExecutedD() == null) ? 0 : getExecutedD().hashCode());
        result = prime * result + ((getCanceledA() == null) ? 0 : getCanceledA().hashCode());
        result = prime * result + ((getCanceledD() == null) ? 0 : getCanceledD().hashCode());
        result = prime * result + ((getReturnAlternate() == null) ? 0 : getReturnAlternate().hashCode());
        result = prime * result + ((getHourPlana() == null) ? 0 : getHourPlana().hashCode());
        result = prime * result + ((getHourActuala() == null) ? 0 : getHourActuala().hashCode());
        result = prime * result + ((getHourPland() == null) ? 0 : getHourPland().hashCode());
        result = prime * result + ((getHourActuald() == null) ? 0 : getHourActuald().hashCode());
        result = prime * result + ((getFreeStand() == null) ? 0 : getFreeStand().hashCode());
        result = prime * result + ((getDelayRatio() == null) ? 0 : getDelayRatio().hashCode());
        result = prime * result + ((getDelayFlno() == null) ? 0 : getDelayFlno().hashCode());
        result = prime * result + ((getDclsRatio() == null) ? 0 : getDclsRatio().hashCode());
        result = prime * result + ((getDclsFlno() == null) ? 0 : getDclsFlno().hashCode());
        result = prime * result + ((getExecutiveCdtn() == null) ? 0 : getExecutiveCdtn().hashCode());
        result = prime * result + ((getSpecialPlane() == null) ? 0 : getSpecialPlane().hashCode());
        result = prime * result + ((getTerminalOrder() == null) ? 0 : getTerminalOrder().hashCode());
        result = prime * result + ((getMattersCoordinated() == null) ? 0 : getMattersCoordinated().hashCode());
        result = prime * result + ((getOtherSpecial() == null) ? 0 : getOtherSpecial().hashCode());
        result = prime * result + ((getCurdateManager() == null) ? 0 : getCurdateManager().hashCode());
        result = prime * result + ((getCurdateManagerPhone() == null) ? 0 : getCurdateManagerPhone().hashCode());
        result = prime * result + ((getCurdateApmng() == null) ? 0 : getCurdateApmng().hashCode());
        result = prime * result + ((getCurdateApmngPhone() == null) ? 0 : getCurdateApmngPhone().hashCode());
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
        sb.append(", curdatePlana=").append(curdatePlana);
        sb.append(", curdatePland=").append(curdatePland);
        sb.append(", curtimePlana=").append(curtimePlana);
        sb.append(", curtimePland=").append(curtimePland);
        sb.append(", executedA=").append(executedA);
        sb.append(", executedD=").append(executedD);
        sb.append(", canceledA=").append(canceledA);
        sb.append(", canceledD=").append(canceledD);
        sb.append(", returnAlternate=").append(returnAlternate);
        sb.append(", hourPlana=").append(hourPlana);
        sb.append(", hourActuala=").append(hourActuala);
        sb.append(", hourPland=").append(hourPland);
        sb.append(", hourActuald=").append(hourActuald);
        sb.append(", freeStand=").append(freeStand);
        sb.append(", delayRatio=").append(delayRatio);
        sb.append(", delayFlno=").append(delayFlno);
        sb.append(", dclsRatio=").append(dclsRatio);
        sb.append(", dclsFlno=").append(dclsFlno);
        sb.append(", executiveCdtn=").append(executiveCdtn);
        sb.append(", specialPlane=").append(specialPlane);
        sb.append(", terminalOrder=").append(terminalOrder);
        sb.append(", mattersCoordinated=").append(mattersCoordinated);
        sb.append(", otherSpecial=").append(otherSpecial);
        sb.append(", curdateManager=").append(curdateManager);
        sb.append(", curdateManagerPhone=").append(curdateManagerPhone);
        sb.append(", curdateApmng=").append(curdateApmng);
        sb.append(", curdateApmngPhone=").append(curdateApmngPhone);
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