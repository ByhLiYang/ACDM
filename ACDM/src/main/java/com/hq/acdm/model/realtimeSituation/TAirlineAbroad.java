package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;

public class TAirlineAbroad implements Serializable {
    private String id;

    private String twoCharCd;

    private String threeCharCd;

    private String attribute;

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
        TAirlineAbroad other = (TAirlineAbroad) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTwoCharCd() == null ? other.getTwoCharCd() == null : this.getTwoCharCd().equals(other.getTwoCharCd()))
            && (this.getThreeCharCd() == null ? other.getThreeCharCd() == null : this.getThreeCharCd().equals(other.getThreeCharCd()))
            && (this.getAttribute() == null ? other.getAttribute() == null : this.getAttribute().equals(other.getAttribute()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTwoCharCd() == null) ? 0 : getTwoCharCd().hashCode());
        result = prime * result + ((getThreeCharCd() == null) ? 0 : getThreeCharCd().hashCode());
        result = prime * result + ((getAttribute() == null) ? 0 : getAttribute().hashCode());
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}