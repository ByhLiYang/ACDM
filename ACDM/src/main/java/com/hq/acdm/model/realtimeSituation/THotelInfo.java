package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class THotelInfo implements Serializable {
    private String id;

    private String hotelName;

    private String hotelAddres;

    private String hotelTel;

    private String hotelRoomType;

    private Long hotelRoomNum;

    private Long hotelPrice;

    private Long hotelPeopleNum;

    private String hotelManagerTel;

    private String rmk;

    private Date createTm;

    private String createEmp;

    private Date updateTm;

    private String updateEmp;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public String getHotelAddres() {
        return hotelAddres;
    }

    public void setHotelAddres(String hotelAddres) {
        this.hotelAddres = hotelAddres == null ? null : hotelAddres.trim();
    }

    public String getHotelTel() {
        return hotelTel;
    }

    public void setHotelTel(String hotelTel) {
        this.hotelTel = hotelTel == null ? null : hotelTel.trim();
    }

    public String getHotelRoomType() {
        return hotelRoomType;
    }

    public void setHotelRoomType(String hotelRoomType) {
        this.hotelRoomType = hotelRoomType == null ? null : hotelRoomType.trim();
    }

    public Long getHotelRoomNum() {
        return hotelRoomNum;
    }

    public void setHotelRoomNum(Long hotelRoomNum) {
        this.hotelRoomNum = hotelRoomNum;
    }

    public Long getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(Long hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public Long getHotelPeopleNum() {
        return hotelPeopleNum;
    }

    public void setHotelPeopleNum(Long hotelPeopleNum) {
        this.hotelPeopleNum = hotelPeopleNum;
    }

    public String getHotelManagerTel() {
        return hotelManagerTel;
    }

    public void setHotelManagerTel(String hotelManagerTel) {
        this.hotelManagerTel = hotelManagerTel == null ? null : hotelManagerTel.trim();
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public String getCreateEmp() {
        return createEmp;
    }

    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp == null ? null : createEmp.trim();
    }

    public Date getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(Date updateTm) {
        this.updateTm = updateTm;
    }

    public String getUpdateEmp() {
        return updateEmp;
    }

    public void setUpdateEmp(String updateEmp) {
        this.updateEmp = updateEmp == null ? null : updateEmp.trim();
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
        THotelInfo other = (THotelInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHotelName() == null ? other.getHotelName() == null : this.getHotelName().equals(other.getHotelName()))
            && (this.getHotelAddres() == null ? other.getHotelAddres() == null : this.getHotelAddres().equals(other.getHotelAddres()))
            && (this.getHotelTel() == null ? other.getHotelTel() == null : this.getHotelTel().equals(other.getHotelTel()))
            && (this.getHotelRoomType() == null ? other.getHotelRoomType() == null : this.getHotelRoomType().equals(other.getHotelRoomType()))
            && (this.getHotelRoomNum() == null ? other.getHotelRoomNum() == null : this.getHotelRoomNum().equals(other.getHotelRoomNum()))
            && (this.getHotelPrice() == null ? other.getHotelPrice() == null : this.getHotelPrice().equals(other.getHotelPrice()))
            && (this.getHotelPeopleNum() == null ? other.getHotelPeopleNum() == null : this.getHotelPeopleNum().equals(other.getHotelPeopleNum()))
            && (this.getHotelManagerTel() == null ? other.getHotelManagerTel() == null : this.getHotelManagerTel().equals(other.getHotelManagerTel()))
            && (this.getRmk() == null ? other.getRmk() == null : this.getRmk().equals(other.getRmk()))
            && (this.getCreateTm() == null ? other.getCreateTm() == null : this.getCreateTm().equals(other.getCreateTm()))
            && (this.getCreateEmp() == null ? other.getCreateEmp() == null : this.getCreateEmp().equals(other.getCreateEmp()))
            && (this.getUpdateTm() == null ? other.getUpdateTm() == null : this.getUpdateTm().equals(other.getUpdateTm()))
            && (this.getUpdateEmp() == null ? other.getUpdateEmp() == null : this.getUpdateEmp().equals(other.getUpdateEmp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHotelName() == null) ? 0 : getHotelName().hashCode());
        result = prime * result + ((getHotelAddres() == null) ? 0 : getHotelAddres().hashCode());
        result = prime * result + ((getHotelTel() == null) ? 0 : getHotelTel().hashCode());
        result = prime * result + ((getHotelRoomType() == null) ? 0 : getHotelRoomType().hashCode());
        result = prime * result + ((getHotelRoomNum() == null) ? 0 : getHotelRoomNum().hashCode());
        result = prime * result + ((getHotelPrice() == null) ? 0 : getHotelPrice().hashCode());
        result = prime * result + ((getHotelPeopleNum() == null) ? 0 : getHotelPeopleNum().hashCode());
        result = prime * result + ((getHotelManagerTel() == null) ? 0 : getHotelManagerTel().hashCode());
        result = prime * result + ((getRmk() == null) ? 0 : getRmk().hashCode());
        result = prime * result + ((getCreateTm() == null) ? 0 : getCreateTm().hashCode());
        result = prime * result + ((getCreateEmp() == null) ? 0 : getCreateEmp().hashCode());
        result = prime * result + ((getUpdateTm() == null) ? 0 : getUpdateTm().hashCode());
        result = prime * result + ((getUpdateEmp() == null) ? 0 : getUpdateEmp().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hotelName=").append(hotelName);
        sb.append(", hotelAddres=").append(hotelAddres);
        sb.append(", hotelTel=").append(hotelTel);
        sb.append(", hotelRoomType=").append(hotelRoomType);
        sb.append(", hotelRoomNum=").append(hotelRoomNum);
        sb.append(", hotelPrice=").append(hotelPrice);
        sb.append(", hotelPeopleNum=").append(hotelPeopleNum);
        sb.append(", hotelManagerTel=").append(hotelManagerTel);
        sb.append(", rmk=").append(rmk);
        sb.append(", createTm=").append(createTm);
        sb.append(", createEmp=").append(createEmp);
        sb.append(", updateTm=").append(updateTm);
        sb.append(", updateEmp=").append(updateEmp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}