package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TOndutyInfo implements Serializable {
    private String id;

    private String orgId;

    private String orgName;

    private String ondutyEmpId;

    private String ondutyEmp;

    private String tel;

    private String mobilePhone;

    private Date ondutyTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOndutyEmpId() {
        return ondutyEmpId;
    }

    public void setOndutyEmpId(String ondutyEmpId) {
        this.ondutyEmpId = ondutyEmpId == null ? null : ondutyEmpId.trim();
    }

    public String getOndutyEmp() {
        return ondutyEmp;
    }

    public void setOndutyEmp(String ondutyEmp) {
        this.ondutyEmp = ondutyEmp == null ? null : ondutyEmp.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public Date getOndutyTime() {
        return ondutyTime;
    }

    public void setOndutyTime(Date ondutyTime) {
        this.ondutyTime = ondutyTime;
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
        TOndutyInfo other = (TOndutyInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getOndutyEmpId() == null ? other.getOndutyEmpId() == null : this.getOndutyEmpId().equals(other.getOndutyEmpId()))
            && (this.getOndutyEmp() == null ? other.getOndutyEmp() == null : this.getOndutyEmp().equals(other.getOndutyEmp()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getMobilePhone() == null ? other.getMobilePhone() == null : this.getMobilePhone().equals(other.getMobilePhone()))
            && (this.getOndutyTime() == null ? other.getOndutyTime() == null : this.getOndutyTime().equals(other.getOndutyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getOndutyEmpId() == null) ? 0 : getOndutyEmpId().hashCode());
        result = prime * result + ((getOndutyEmp() == null) ? 0 : getOndutyEmp().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getMobilePhone() == null) ? 0 : getMobilePhone().hashCode());
        result = prime * result + ((getOndutyTime() == null) ? 0 : getOndutyTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orgId=").append(orgId);
        sb.append(", orgName=").append(orgName);
        sb.append(", ondutyEmpId=").append(ondutyEmpId);
        sb.append(", ondutyEmp=").append(ondutyEmp);
        sb.append(", tel=").append(tel);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", ondutyTime=").append(ondutyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}