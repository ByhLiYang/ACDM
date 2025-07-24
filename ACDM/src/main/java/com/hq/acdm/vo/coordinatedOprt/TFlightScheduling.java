package com.hq.acdm.vo.coordinatedOprt;

import java.io.Serializable;
import java.util.Date;

public class TFlightScheduling implements Serializable {
    private String id;

    private String ffid;

    private String exdt;

    private String flio;

    private String dpcd;

    private String dpct;

    private String arcd;

    private String arct;

    private String awcd;

    private String flno;

    private String fptt;

    private String fplt;

    private String cftp;

    private String issp;

    private String issh;

    private String sfno;

    private Integer dstn;

    private String food;

    private String artm;

    private String mttm;

    private String uptm;

    private String isdel;

    private String rmk;

    private String createTm;

    private String updateTm;

    private String createUsr;

    private String updateUsr;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFfid() {
        return ffid;
    }

    public void setFfid(String ffid) {
        this.ffid = ffid == null ? null : ffid.trim();
    }

    public String getExdt() {
        return exdt;
    }

    public void setExdt(String exdt) {
        this.exdt = exdt;
    }

    public String getFlio() {
        return flio;
    }

    public void setFlio(String flio) {
        this.flio = flio == null ? null : flio.trim();
    }

    public String getDpcd() {
        return dpcd;
    }

    public void setDpcd(String dpcd) {
        this.dpcd = dpcd == null ? null : dpcd.trim();
    }

    public String getDpct() {
        return dpct;
    }

    public void setDpct(String dpct) {
        this.dpct = dpct == null ? null : dpct.trim();
    }

    public String getArcd() {
        return arcd;
    }

    public void setArcd(String arcd) {
        this.arcd = arcd == null ? null : arcd.trim();
    }

    public String getArct() {
        return arct;
    }

    public void setArct(String arct) {
        this.arct = arct == null ? null : arct.trim();
    }

    public String getAwcd() {
        return awcd;
    }

    public void setAwcd(String awcd) {
        this.awcd = awcd == null ? null : awcd.trim();
    }

    public String getFlno() {
        return flno;
    }

    public void setFlno(String flno) {
        this.flno = flno == null ? null : flno.trim();
    }

    public String getFptt() {
        return fptt;
    }

    public void setFptt(String fptt) {
        this.fptt = fptt;
    }

    public String getFplt() {
        return fplt;
    }

    public void setFplt(String fplt) {
        this.fplt = fplt;
    }

    public String getCftp() {
        return cftp;
    }

    public void setCftp(String cftp) {
        this.cftp = cftp == null ? null : cftp.trim();
    }

    public String getIssp() {
        return issp;
    }

    public void setIssp(String issp) {
        this.issp = issp == null ? null : issp.trim();
    }

    public String getIssh() {
        return issh;
    }

    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }

    public String getSfno() {
        return sfno;
    }

    public void setSfno(String sfno) {
        this.sfno = sfno == null ? null : sfno.trim();
    }

    public Integer getDstn() {
        return dstn;
    }

    public void setDstn(Integer dstn) {
        this.dstn = dstn;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food == null ? null : food.trim();
    }

    public String getArtm() {
        return artm;
    }

    public void setArtm(String artm) {
        this.artm = artm == null ? null : artm.trim();
    }

    public String getMttm() {
        return mttm;
    }

    public void setMttm(String mttm) {
        this.mttm = mttm == null ? null : mttm.trim();
    }

    public String getUptm() {
        return uptm;
    }

    public void setUptm(String uptm) {
        this.uptm = uptm;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }

    public String getCreateTm() {
        return createTm;
    }

    public void setCreateTm(String createTm) {
        this.createTm = createTm;
    }

    public String getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(String updateTm) {
        this.updateTm = updateTm;
    }

    public String getCreateUsr() {
        return createUsr;
    }

    public void setCreateUsr(String createUsr) {
        this.createUsr = createUsr == null ? null : createUsr.trim();
    }

    public String getUpdateUsr() {
        return updateUsr;
    }

    public void setUpdateUsr(String updateUsr) {
        this.updateUsr = updateUsr == null ? null : updateUsr.trim();
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
        TFlightScheduling other = (TFlightScheduling) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFfid() == null ? other.getFfid() == null : this.getFfid().equals(other.getFfid()))
            && (this.getExdt() == null ? other.getExdt() == null : this.getExdt().equals(other.getExdt()))
            && (this.getFlio() == null ? other.getFlio() == null : this.getFlio().equals(other.getFlio()))
            && (this.getDpcd() == null ? other.getDpcd() == null : this.getDpcd().equals(other.getDpcd()))
            && (this.getDpct() == null ? other.getDpct() == null : this.getDpct().equals(other.getDpct()))
            && (this.getArcd() == null ? other.getArcd() == null : this.getArcd().equals(other.getArcd()))
            && (this.getArct() == null ? other.getArct() == null : this.getArct().equals(other.getArct()))
            && (this.getAwcd() == null ? other.getAwcd() == null : this.getAwcd().equals(other.getAwcd()))
            && (this.getFlno() == null ? other.getFlno() == null : this.getFlno().equals(other.getFlno()))
            && (this.getFptt() == null ? other.getFptt() == null : this.getFptt().equals(other.getFptt()))
            && (this.getFplt() == null ? other.getFplt() == null : this.getFplt().equals(other.getFplt()))
            && (this.getCftp() == null ? other.getCftp() == null : this.getCftp().equals(other.getCftp()))
            && (this.getIssp() == null ? other.getIssp() == null : this.getIssp().equals(other.getIssp()))
            && (this.getIssh() == null ? other.getIssh() == null : this.getIssh().equals(other.getIssh()))
            && (this.getSfno() == null ? other.getSfno() == null : this.getSfno().equals(other.getSfno()))
            && (this.getDstn() == null ? other.getDstn() == null : this.getDstn().equals(other.getDstn()))
            && (this.getFood() == null ? other.getFood() == null : this.getFood().equals(other.getFood()))
            && (this.getArtm() == null ? other.getArtm() == null : this.getArtm().equals(other.getArtm()))
            && (this.getMttm() == null ? other.getMttm() == null : this.getMttm().equals(other.getMttm()))
            && (this.getUptm() == null ? other.getUptm() == null : this.getUptm().equals(other.getUptm()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()))
            && (this.getRmk() == null ? other.getRmk() == null : this.getRmk().equals(other.getRmk()))
            && (this.getCreateTm() == null ? other.getCreateTm() == null : this.getCreateTm().equals(other.getCreateTm()))
            && (this.getUpdateTm() == null ? other.getUpdateTm() == null : this.getUpdateTm().equals(other.getUpdateTm()))
            && (this.getCreateUsr() == null ? other.getCreateUsr() == null : this.getCreateUsr().equals(other.getCreateUsr()))
            && (this.getUpdateUsr() == null ? other.getUpdateUsr() == null : this.getUpdateUsr().equals(other.getUpdateUsr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFfid() == null) ? 0 : getFfid().hashCode());
        result = prime * result + ((getExdt() == null) ? 0 : getExdt().hashCode());
        result = prime * result + ((getFlio() == null) ? 0 : getFlio().hashCode());
        result = prime * result + ((getDpcd() == null) ? 0 : getDpcd().hashCode());
        result = prime * result + ((getDpct() == null) ? 0 : getDpct().hashCode());
        result = prime * result + ((getArcd() == null) ? 0 : getArcd().hashCode());
        result = prime * result + ((getArct() == null) ? 0 : getArct().hashCode());
        result = prime * result + ((getAwcd() == null) ? 0 : getAwcd().hashCode());
        result = prime * result + ((getFlno() == null) ? 0 : getFlno().hashCode());
        result = prime * result + ((getFptt() == null) ? 0 : getFptt().hashCode());
        result = prime * result + ((getFplt() == null) ? 0 : getFplt().hashCode());
        result = prime * result + ((getCftp() == null) ? 0 : getCftp().hashCode());
        result = prime * result + ((getIssp() == null) ? 0 : getIssp().hashCode());
        result = prime * result + ((getIssh() == null) ? 0 : getIssh().hashCode());
        result = prime * result + ((getSfno() == null) ? 0 : getSfno().hashCode());
        result = prime * result + ((getDstn() == null) ? 0 : getDstn().hashCode());
        result = prime * result + ((getFood() == null) ? 0 : getFood().hashCode());
        result = prime * result + ((getArtm() == null) ? 0 : getArtm().hashCode());
        result = prime * result + ((getMttm() == null) ? 0 : getMttm().hashCode());
        result = prime * result + ((getUptm() == null) ? 0 : getUptm().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getRmk() == null) ? 0 : getRmk().hashCode());
        result = prime * result + ((getCreateTm() == null) ? 0 : getCreateTm().hashCode());
        result = prime * result + ((getUpdateTm() == null) ? 0 : getUpdateTm().hashCode());
        result = prime * result + ((getCreateUsr() == null) ? 0 : getCreateUsr().hashCode());
        result = prime * result + ((getUpdateUsr() == null) ? 0 : getUpdateUsr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ffid=").append(ffid);
        sb.append(", exdt=").append(exdt);
        sb.append(", flio=").append(flio);
        sb.append(", dpcd=").append(dpcd);
        sb.append(", dpct=").append(dpct);
        sb.append(", arcd=").append(arcd);
        sb.append(", arct=").append(arct);
        sb.append(", awcd=").append(awcd);
        sb.append(", flno=").append(flno);
        sb.append(", fptt=").append(fptt);
        sb.append(", fplt=").append(fplt);
        sb.append(", cftp=").append(cftp);
        sb.append(", issp=").append(issp);
        sb.append(", issh=").append(issh);
        sb.append(", sfno=").append(sfno);
        sb.append(", dstn=").append(dstn);
        sb.append(", food=").append(food);
        sb.append(", artm=").append(artm);
        sb.append(", mttm=").append(mttm);
        sb.append(", uptm=").append(uptm);
        sb.append(", isdel=").append(isdel);
        sb.append(", rmk=").append(rmk);
        sb.append(", createTm=").append(createTm);
        sb.append(", updateTm=").append(updateTm);
        sb.append(", createUsr=").append(createUsr);
        sb.append(", updateUsr=").append(updateUsr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}