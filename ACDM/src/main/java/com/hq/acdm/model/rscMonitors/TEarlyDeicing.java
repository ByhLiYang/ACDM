package com.hq.acdm.model.rscMonitors;

import java.io.Serializable;

public class TEarlyDeicing implements Serializable {
    private String id;

    private String flno;

    private String execDate;

    private String sobt;

    private String atot;

    private String type;

    private String ecdt;

    private String lcdt;

    private String acdt;

    private String aedt;

    private String ltdc;

    private String area;

    private String stand;

    private String status;

    private String manual;

    private String remark;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFlno() {
        return flno;
    }

    public void setFlno(String flno) {
        this.flno = flno == null ? null : flno.trim();
    }

    public String getExecDate() {
        return execDate;
    }

    public void setExecDate(String execDate) {
        this.execDate = execDate;
    }

    public String getSobt() {
        return sobt;
    }

    public void setSobt(String sobt) {
        this.sobt = sobt;
    }

    public String getAtot() {
        return atot;
    }

    public void setAtot(String atot) {
        this.atot = atot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getEcdt() {
        return ecdt;
    }

    public void setEcdt(String ecdt) {
        this.ecdt = ecdt;
    }

    public String getLcdt() {
        return lcdt;
    }

    public void setLcdt(String lcdt) {
        this.lcdt = lcdt;
    }

    public String getAcdt() {
        return acdt;
    }

    public void setAcdt(String acdt) {
        this.acdt = acdt;
    }

    public String getAedt() {
        return aedt;
    }

    public void setAedt(String aedt) {
        this.aedt = aedt;
    }

    public String getLtdc() {
        return ltdc;
    }

    public void setLtdc(String ltdc) {
        this.ltdc = ltdc;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand == null ? null : stand.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual == null ? null : manual.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        TEarlyDeicing other = (TEarlyDeicing) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFlno() == null ? other.getFlno() == null : this.getFlno().equals(other.getFlno()))
            && (this.getExecDate() == null ? other.getExecDate() == null : this.getExecDate().equals(other.getExecDate()))
            && (this.getSobt() == null ? other.getSobt() == null : this.getSobt().equals(other.getSobt()))
            && (this.getAtot() == null ? other.getAtot() == null : this.getAtot().equals(other.getAtot()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getEcdt() == null ? other.getEcdt() == null : this.getEcdt().equals(other.getEcdt()))
            && (this.getLcdt() == null ? other.getLcdt() == null : this.getLcdt().equals(other.getLcdt()))
            && (this.getAcdt() == null ? other.getAcdt() == null : this.getAcdt().equals(other.getAcdt()))
            && (this.getAedt() == null ? other.getAedt() == null : this.getAedt().equals(other.getAedt()))
            && (this.getLtdc() == null ? other.getLtdc() == null : this.getLtdc().equals(other.getLtdc()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getStand() == null ? other.getStand() == null : this.getStand().equals(other.getStand()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getManual() == null ? other.getManual() == null : this.getManual().equals(other.getManual()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFlno() == null) ? 0 : getFlno().hashCode());
        result = prime * result + ((getExecDate() == null) ? 0 : getExecDate().hashCode());
        result = prime * result + ((getSobt() == null) ? 0 : getSobt().hashCode());
        result = prime * result + ((getAtot() == null) ? 0 : getAtot().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getEcdt() == null) ? 0 : getEcdt().hashCode());
        result = prime * result + ((getLcdt() == null) ? 0 : getLcdt().hashCode());
        result = prime * result + ((getAcdt() == null) ? 0 : getAcdt().hashCode());
        result = prime * result + ((getAedt() == null) ? 0 : getAedt().hashCode());
        result = prime * result + ((getLtdc() == null) ? 0 : getLtdc().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getStand() == null) ? 0 : getStand().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getManual() == null) ? 0 : getManual().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", flno=").append(flno);
        sb.append(", execDate=").append(execDate);
        sb.append(", sobt=").append(sobt);
        sb.append(", atot=").append(atot);
        sb.append(", type=").append(type);
        sb.append(", ecdt=").append(ecdt);
        sb.append(", lcdt=").append(lcdt);
        sb.append(", acdt=").append(acdt);
        sb.append(", aedt=").append(aedt);
        sb.append(", ltdc=").append(ltdc);
        sb.append(", area=").append(area);
        sb.append(", stand=").append(stand);
        sb.append(", status=").append(status);
        sb.append(", manual=").append(manual);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}