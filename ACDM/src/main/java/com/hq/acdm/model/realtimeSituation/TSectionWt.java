package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;

public class TSectionWt implements Serializable {
    private String id;

    private String section;

    private String visb;

    private String wspd;

    private String wdrt;

    private String cbht;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section == null ? null : section.trim();
    }

    public String getVisb() {
        return visb;
    }

    public void setVisb(String visb) {
        this.visb = visb == null ? null : visb.trim();
    }

    public String getWspd() {
        return wspd;
    }

    public void setWspd(String wspd) {
        this.wspd = wspd == null ? null : wspd.trim();
    }

    public String getWdrt() {
        return wdrt;
    }

    public void setWdrt(String wdrt) {
        this.wdrt = wdrt == null ? null : wdrt.trim();
    }

    public String getCbht() {
        return cbht;
    }

    public void setCbht(String cbht) {
        this.cbht = cbht == null ? null : cbht.trim();
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
        TSectionWt other = (TSectionWt) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSection() == null ? other.getSection() == null : this.getSection().equals(other.getSection()))
            && (this.getVisb() == null ? other.getVisb() == null : this.getVisb().equals(other.getVisb()))
            && (this.getWspd() == null ? other.getWspd() == null : this.getWspd().equals(other.getWspd()))
            && (this.getWdrt() == null ? other.getWdrt() == null : this.getWdrt().equals(other.getWdrt()))
            && (this.getCbht() == null ? other.getCbht() == null : this.getCbht().equals(other.getCbht()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSection() == null) ? 0 : getSection().hashCode());
        result = prime * result + ((getVisb() == null) ? 0 : getVisb().hashCode());
        result = prime * result + ((getWspd() == null) ? 0 : getWspd().hashCode());
        result = prime * result + ((getWdrt() == null) ? 0 : getWdrt().hashCode());
        result = prime * result + ((getCbht() == null) ? 0 : getCbht().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", section=").append(section);
        sb.append(", visb=").append(visb);
        sb.append(", wspd=").append(wspd);
        sb.append(", wdrt=").append(wdrt);
        sb.append(", cbht=").append(cbht);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}