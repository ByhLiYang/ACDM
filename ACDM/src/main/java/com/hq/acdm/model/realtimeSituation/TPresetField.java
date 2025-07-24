package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;

public class TPresetField implements Serializable {
    private String id;

    private String loginName;

    private String pageType;

    private String presetField;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType == null ? null : pageType.trim();
    }

    public String getPresetField() {
        return presetField;
    }

    public void setPresetField(String presetField) {
        this.presetField = presetField == null ? null : presetField.trim();
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
        TPresetField other = (TPresetField) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getPageType() == null ? other.getPageType() == null : this.getPageType().equals(other.getPageType()))
            && (this.getPresetField() == null ? other.getPresetField() == null : this.getPresetField().equals(other.getPresetField()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getPageType() == null) ? 0 : getPageType().hashCode());
        result = prime * result + ((getPresetField() == null) ? 0 : getPresetField().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginName=").append(loginName);
        sb.append(", pageType=").append(pageType);
        sb.append(", presetField=").append(presetField);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}