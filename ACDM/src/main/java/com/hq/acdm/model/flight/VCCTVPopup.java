package com.hq.acdm.model.flight;


import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class VCCTVPopup implements Serializable {
    private Date cobt;

    private String stand;


    private String gate1;

    private String type;


    private String flightNoIata;

    private String arn;


    private String aOrD;


    private String operationalDate;


    private String flightRepeatCount;

    private Date sibt;

    private Date eibt;


    private Date aibt1;

    private Date sobt;

    private Date eobt;


    private Date aobt1;

    private Date tot;

    private Date ldt;


    private String codeShareStatus;


    private String flightCancelCode;


    private String flightClassCode;

    private static final long serialVersionUID = 1L;

    public Date getCobt() {
        return cobt;
    }

    public void setCobt(Date cobt) {
        this.cobt = cobt;
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand == null ? null : stand.trim();
    }

    public String getGate1() {
        return gate1;
    }

    public void setGate1(String gate1) {
        this.gate1 = gate1 == null ? null : gate1.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFlightNoIata() {
        return flightNoIata;
    }

    public void setFlightNoIata(String flightNoIata) {
        this.flightNoIata = flightNoIata == null ? null : flightNoIata.trim();
    }

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        this.arn = arn == null ? null : arn.trim();
    }

    public String getaOrD() {
        return aOrD;
    }

    public void setaOrD(String aOrD) {
        this.aOrD = aOrD == null ? null : aOrD.trim();
    }

    public String getOperationalDate() {
        return operationalDate;
    }

    public void setOperationalDate(String operationalDate) {
        this.operationalDate = operationalDate;
    }

    public String getFlightRepeatCount() {
        return flightRepeatCount;
    }

    public void setFlightRepeatCount(String flightRepeatCount) {
        this.flightRepeatCount = flightRepeatCount == null ? null : flightRepeatCount.trim();
    }

    public Date getSibt() {
        return sibt;
    }

    public void setSibt(Date sibt) {
        this.sibt = sibt;
    }

    public Date getEibt() {
        return eibt;
    }

    public void setEibt(Date eibt) {
        this.eibt = eibt;
    }

    public Date getAibt1() {
        return aibt1;
    }

    public void setAibt1(Date aibt1) {
        this.aibt1 = aibt1;
    }

    public Date getSobt() {
        return sobt;
    }

    public void setSobt(Date sobt) {
        this.sobt = sobt;
    }

    public Date getEobt() {
        return eobt;
    }

    public void setEobt(Date eobt) {
        this.eobt = eobt;
    }

    public Date getAobt1() {
        return aobt1;
    }

    public void setAobt1(Date aobt1) {
        this.aobt1 = aobt1;
    }

    public Date getTot() {
        return tot;
    }

    public void setTot(Date tot) {
        this.tot = tot;
    }

    public Date getLdt() {
        return ldt;
    }

    public void setLdt(Date ldt) {
        this.ldt = ldt;
    }

    public String getCodeShareStatus() {
        return codeShareStatus;
    }

    public void setCodeShareStatus(String codeShareStatus) {
        this.codeShareStatus = codeShareStatus == null ? null : codeShareStatus.trim();
    }

    public String getFlightCancelCode() {
        return flightCancelCode;
    }

    public void setFlightCancelCode(String flightCancelCode) {
        this.flightCancelCode = flightCancelCode == null ? null : flightCancelCode.trim();
    }

    public String getFlightClassCode() {
        return flightClassCode;
    }

    public void setFlightClassCode(String flightClassCode) {
        this.flightClassCode = flightClassCode == null ? null : flightClassCode.trim();
    }
 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cobt=").append(cobt);
        sb.append(", stand=").append(stand);
        sb.append(", gate1=").append(gate1);
        sb.append(", type=").append(type);
        sb.append(", flightNoIata=").append(flightNoIata);
        sb.append(", arn=").append(arn);
        sb.append(", aOrD=").append(aOrD);
        sb.append(", operationalDate=").append(operationalDate);
        sb.append(", flightRepeatCount=").append(flightRepeatCount);
        sb.append(", sibt=").append(sibt);
        sb.append(", eibt=").append(eibt);
        sb.append(", aibt1=").append(aibt1);
        sb.append(", sobt=").append(sobt);
        sb.append(", eobt=").append(eobt);
        sb.append(", aobt1=").append(aobt1);
        sb.append(", tot=").append(tot);
        sb.append(", ldt=").append(ldt);
        sb.append(", codeShareStatus=").append(codeShareStatus);
        sb.append(", flightCancelCode=").append(flightCancelCode);
        sb.append(", flightClassCode=").append(flightClassCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
