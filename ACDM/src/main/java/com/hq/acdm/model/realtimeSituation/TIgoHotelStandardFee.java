package com.hq.acdm.model.realtimeSituation;

import java.io.Serializable;
import java.util.Date;

public class TIgoHotelStandardFee implements Serializable {
    private String id;

    private String hotelName;

    private String hotelAddres;

    private String hotelTel;

    private String hotelManagerTel;

    private String nameOfPartyB;

    private Date agreementStartDate;

    private Date agreementEndDate;

    private Double bed;

    private Double homeBreakfast;

    private Double homeLunch;

    private Double homeDinner;

    private Double internationalBreakfast;

    private Double internationalLunch;

    private Double internationalDinner;

    private Double nightSnack;

    private String rmk;

    private Date createTm;

    private Date updateTm;

    private String createEmp;

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

    public String getHotelManagerTel() {
        return hotelManagerTel;
    }

    public void setHotelManagerTel(String hotelManagerTel) {
        this.hotelManagerTel = hotelManagerTel == null ? null : hotelManagerTel.trim();
    }

    public String getNameOfPartyB() {
        return nameOfPartyB;
    }

    public void setNameOfPartyB(String nameOfPartyB) {
        this.nameOfPartyB = nameOfPartyB == null ? null : nameOfPartyB.trim();
    }

    public Date getAgreementStartDate() {
        return agreementStartDate;
    }

    public void setAgreementStartDate(Date agreementStartDate) {
        this.agreementStartDate = agreementStartDate;
    }

    public Date getAgreementEndDate() {
        return agreementEndDate;
    }

    public void setAgreementEndDate(Date agreementEndDate) {
        this.agreementEndDate = agreementEndDate;
    }

    public Double getBed() {
        return bed;
    }

    public void setBed(Double bed) {
        this.bed = bed;
    }

    public Double getHomeBreakfast() {
        return homeBreakfast;
    }

    public void setHomeBreakfast(Double homeBreakfast) {
        this.homeBreakfast = homeBreakfast;
    }

    public Double getHomeLunch() {
        return homeLunch;
    }

    public void setHomeLunch(Double homeLunch) {
        this.homeLunch = homeLunch;
    }

    public Double getHomeDinner() {
        return homeDinner;
    }

    public void setHomeDinner(Double homeDinner) {
        this.homeDinner = homeDinner;
    }

    public Double getInternationalBreakfast() {
        return internationalBreakfast;
    }

    public void setInternationalBreakfast(Double internationalBreakfast) {
        this.internationalBreakfast = internationalBreakfast;
    }

    public Double getInternationalLunch() {
        return internationalLunch;
    }

    public void setInternationalLunch(Double internationalLunch) {
        this.internationalLunch = internationalLunch;
    }

    public Double getInternationalDinner() {
        return internationalDinner;
    }

    public void setInternationalDinner(Double internationalDinner) {
        this.internationalDinner = internationalDinner;
    }

    public Double getNightSnack() {
        return nightSnack;
    }

    public void setNightSnack(Double nightSnack) {
        this.nightSnack = nightSnack;
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

    public Date getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(Date updateTm) {
        this.updateTm = updateTm;
    }

    public String getCreateEmp() {
        return createEmp;
    }

    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp == null ? null : createEmp.trim();
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
        TIgoHotelStandardFee other = (TIgoHotelStandardFee) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHotelName() == null ? other.getHotelName() == null : this.getHotelName().equals(other.getHotelName()))
            && (this.getHotelAddres() == null ? other.getHotelAddres() == null : this.getHotelAddres().equals(other.getHotelAddres()))
            && (this.getHotelTel() == null ? other.getHotelTel() == null : this.getHotelTel().equals(other.getHotelTel()))
            && (this.getHotelManagerTel() == null ? other.getHotelManagerTel() == null : this.getHotelManagerTel().equals(other.getHotelManagerTel()))
            && (this.getNameOfPartyB() == null ? other.getNameOfPartyB() == null : this.getNameOfPartyB().equals(other.getNameOfPartyB()))
            && (this.getAgreementStartDate() == null ? other.getAgreementStartDate() == null : this.getAgreementStartDate().equals(other.getAgreementStartDate()))
            && (this.getAgreementEndDate() == null ? other.getAgreementEndDate() == null : this.getAgreementEndDate().equals(other.getAgreementEndDate()))
            && (this.getBed() == null ? other.getBed() == null : this.getBed().equals(other.getBed()))
            && (this.getHomeBreakfast() == null ? other.getHomeBreakfast() == null : this.getHomeBreakfast().equals(other.getHomeBreakfast()))
            && (this.getHomeLunch() == null ? other.getHomeLunch() == null : this.getHomeLunch().equals(other.getHomeLunch()))
            && (this.getHomeDinner() == null ? other.getHomeDinner() == null : this.getHomeDinner().equals(other.getHomeDinner()))
            && (this.getInternationalBreakfast() == null ? other.getInternationalBreakfast() == null : this.getInternationalBreakfast().equals(other.getInternationalBreakfast()))
            && (this.getInternationalLunch() == null ? other.getInternationalLunch() == null : this.getInternationalLunch().equals(other.getInternationalLunch()))
            && (this.getInternationalDinner() == null ? other.getInternationalDinner() == null : this.getInternationalDinner().equals(other.getInternationalDinner()))
            && (this.getNightSnack() == null ? other.getNightSnack() == null : this.getNightSnack().equals(other.getNightSnack()))
            && (this.getRmk() == null ? other.getRmk() == null : this.getRmk().equals(other.getRmk()))
            && (this.getCreateTm() == null ? other.getCreateTm() == null : this.getCreateTm().equals(other.getCreateTm()))
            && (this.getUpdateTm() == null ? other.getUpdateTm() == null : this.getUpdateTm().equals(other.getUpdateTm()))
            && (this.getCreateEmp() == null ? other.getCreateEmp() == null : this.getCreateEmp().equals(other.getCreateEmp()))
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
        result = prime * result + ((getHotelManagerTel() == null) ? 0 : getHotelManagerTel().hashCode());
        result = prime * result + ((getNameOfPartyB() == null) ? 0 : getNameOfPartyB().hashCode());
        result = prime * result + ((getAgreementStartDate() == null) ? 0 : getAgreementStartDate().hashCode());
        result = prime * result + ((getAgreementEndDate() == null) ? 0 : getAgreementEndDate().hashCode());
        result = prime * result + ((getBed() == null) ? 0 : getBed().hashCode());
        result = prime * result + ((getHomeBreakfast() == null) ? 0 : getHomeBreakfast().hashCode());
        result = prime * result + ((getHomeLunch() == null) ? 0 : getHomeLunch().hashCode());
        result = prime * result + ((getHomeDinner() == null) ? 0 : getHomeDinner().hashCode());
        result = prime * result + ((getInternationalBreakfast() == null) ? 0 : getInternationalBreakfast().hashCode());
        result = prime * result + ((getInternationalLunch() == null) ? 0 : getInternationalLunch().hashCode());
        result = prime * result + ((getInternationalDinner() == null) ? 0 : getInternationalDinner().hashCode());
        result = prime * result + ((getNightSnack() == null) ? 0 : getNightSnack().hashCode());
        result = prime * result + ((getRmk() == null) ? 0 : getRmk().hashCode());
        result = prime * result + ((getCreateTm() == null) ? 0 : getCreateTm().hashCode());
        result = prime * result + ((getUpdateTm() == null) ? 0 : getUpdateTm().hashCode());
        result = prime * result + ((getCreateEmp() == null) ? 0 : getCreateEmp().hashCode());
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
        sb.append(", hotelManagerTel=").append(hotelManagerTel);
        sb.append(", nameOfPartyB=").append(nameOfPartyB);
        sb.append(", agreementStartDate=").append(agreementStartDate);
        sb.append(", agreementEndDate=").append(agreementEndDate);
        sb.append(", bed=").append(bed);
        sb.append(", homeBreakfast=").append(homeBreakfast);
        sb.append(", homeLunch=").append(homeLunch);
        sb.append(", homeDinner=").append(homeDinner);
        sb.append(", internationalBreakfast=").append(internationalBreakfast);
        sb.append(", internationalLunch=").append(internationalLunch);
        sb.append(", internationalDinner=").append(internationalDinner);
        sb.append(", nightSnack=").append(nightSnack);
        sb.append(", rmk=").append(rmk);
        sb.append(", createTm=").append(createTm);
        sb.append(", updateTm=").append(updateTm);
        sb.append(", createEmp=").append(createEmp);
        sb.append(", updateEmp=").append(updateEmp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}