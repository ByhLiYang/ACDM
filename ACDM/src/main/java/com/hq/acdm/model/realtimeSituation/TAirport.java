package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TAirport implements Serializable {
    private String id;

    private String airportIata;

    private String airportIcao;

    private String attribute;

    private String chineseName;

    private String englishName;

    private String isOpen;

    private String shortName;

    private Date createTime;

    private Date updateTime;

    private Integer isDelete;

    private String inCity;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAirportIata() {
        return airportIata;
    }

    public void setAirportIata(String airportIata) {
        this.airportIata = airportIata == null ? null : airportIata.trim();
    }

    public String getAirportIcao() {
        return airportIcao;
    }

    public void setAirportIcao(String airportIcao) {
        this.airportIcao = airportIcao == null ? null : airportIcao.trim();
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

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen == null ? null : isOpen.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
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

    public String getInCity() {
        return inCity;
    }

    public void setInCity(String inCity) {
        this.inCity = inCity == null ? null : inCity.trim();
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
        TAirport other = (TAirport) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAirportIata() == null ? other.getAirportIata() == null : this.getAirportIata().equals(other.getAirportIata()))
            && (this.getAirportIcao() == null ? other.getAirportIcao() == null : this.getAirportIcao().equals(other.getAirportIcao()))
            && (this.getAttribute() == null ? other.getAttribute() == null : this.getAttribute().equals(other.getAttribute()))
            && (this.getChineseName() == null ? other.getChineseName() == null : this.getChineseName().equals(other.getChineseName()))
            && (this.getEnglishName() == null ? other.getEnglishName() == null : this.getEnglishName().equals(other.getEnglishName()))
            && (this.getIsOpen() == null ? other.getIsOpen() == null : this.getIsOpen().equals(other.getIsOpen()))
            && (this.getShortName() == null ? other.getShortName() == null : this.getShortName().equals(other.getShortName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getInCity() == null ? other.getInCity() == null : this.getInCity().equals(other.getInCity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAirportIata() == null) ? 0 : getAirportIata().hashCode());
        result = prime * result + ((getAirportIcao() == null) ? 0 : getAirportIcao().hashCode());
        result = prime * result + ((getAttribute() == null) ? 0 : getAttribute().hashCode());
        result = prime * result + ((getChineseName() == null) ? 0 : getChineseName().hashCode());
        result = prime * result + ((getEnglishName() == null) ? 0 : getEnglishName().hashCode());
        result = prime * result + ((getIsOpen() == null) ? 0 : getIsOpen().hashCode());
        result = prime * result + ((getShortName() == null) ? 0 : getShortName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getInCity() == null) ? 0 : getInCity().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", airportIata=").append(airportIata);
        sb.append(", airportIcao=").append(airportIcao);
        sb.append(", attribute=").append(attribute);
        sb.append(", chineseName=").append(chineseName);
        sb.append(", englishName=").append(englishName);
        sb.append(", isOpen=").append(isOpen);
        sb.append(", shortName=").append(shortName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", inCity=").append(inCity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}