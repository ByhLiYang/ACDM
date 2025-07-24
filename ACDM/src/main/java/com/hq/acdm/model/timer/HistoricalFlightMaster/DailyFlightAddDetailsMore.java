package com.hq.acdm.model.timer.HistoricalFlightMaster;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
public class DailyFlightAddDetailsMore implements Serializable {
    private String flightNoIata;

    private Date operationalDate;

    private String aOrD;

    private String flightRepeatCount;

    private Date prevEtot;

    private Date acct1;

    private Date acct2;

    private Date acct3;

    private Date acct4;

    private Date acct5;

    private Date acct6;

    private Date acct7;

    private String shareFlightNo1;

    private Short shareFlightRp1;

    private String shareFlightNo2;

    private Short shareFlightRp2;

    private String shareFlightNo3;

    private Short shareFlightRp3;

    private String shareFlightNo4;

    private Short shareFlightRp4;

    private String shareFlightNo5;

    private Short shareFlightRp5;

    private String shareFlightNo6;

    private Short shareFlightRp6;

    private Date nxtAldt;

    private Date nxtEldt;

    private Date awmd;

    private Date aand;

    private Date aibegi;

    private Date adumet;

    private Date tTobt;

    private Date cTobt;

    private Date gate1Opendatetime4;

    private Date gate1Closedatetime4;

    private Date asrt2;

    private Date asat2;

    private Date axit2;

    private Date axot2;

    private String ctrlreason;

    private String preflno;

    private int countNumber;


    private static final long serialVersionUID = 1L;

    public String getFlightNoIata() {
        return flightNoIata;
    }

    public void setFlightNoIata(String flightNoIata) {
        this.flightNoIata = flightNoIata == null ? null : flightNoIata.trim();
    }

    public Date getOperationalDate() {
        return operationalDate;
    }

    public void setOperationalDate(Date operationalDate) {
        this.operationalDate = operationalDate;
    }

    public String getaOrD() {
        return aOrD;
    }

    public void setaOrD(String aOrD) {
        this.aOrD = aOrD == null ? null : aOrD.trim();
    }

    public String getFlightRepeatCount() {
        return flightRepeatCount;
    }

    public void setFlightRepeatCount(String flightRepeatCount) {
        this.flightRepeatCount = flightRepeatCount == null ? null : flightRepeatCount.trim();
    }

    public Date getPrevEtot() {
        return prevEtot;
    }

    public void setPrevEtot(Date prevEtot) {
        this.prevEtot = prevEtot;
    }

    public Date getAcct1() {
        return acct1;
    }

    public void setAcct1(Date acct1) {
        this.acct1 = acct1;
    }

    public Date getAcct2() {
        return acct2;
    }

    public void setAcct2(Date acct2) {
        this.acct2 = acct2;
    }

    public Date getAcct3() {
        return acct3;
    }

    public void setAcct3(Date acct3) {
        this.acct3 = acct3;
    }

    public Date getAcct4() {
        return acct4;
    }

    public void setAcct4(Date acct4) {
        this.acct4 = acct4;
    }

    public Date getAcct5() {
        return acct5;
    }

    public void setAcct5(Date acct5) {
        this.acct5 = acct5;
    }

    public Date getAcct6() {
        return acct6;
    }

    public void setAcct6(Date acct6) {
        this.acct6 = acct6;
    }

    public Date getAcct7() {
        return acct7;
    }

    public void setAcct7(Date acct7) {
        this.acct7 = acct7;
    }

    public String getShareFlightNo1() {
        return shareFlightNo1;
    }

    public void setShareFlightNo1(String shareFlightNo1) {
        this.shareFlightNo1 = shareFlightNo1 == null ? null : shareFlightNo1.trim();
    }

    public Short getShareFlightRp1() {
        return shareFlightRp1;
    }

    public void setShareFlightRp1(Short shareFlightRp1) {
        this.shareFlightRp1 = shareFlightRp1;
    }

    public String getShareFlightNo2() {
        return shareFlightNo2;
    }

    public void setShareFlightNo2(String shareFlightNo2) {
        this.shareFlightNo2 = shareFlightNo2 == null ? null : shareFlightNo2.trim();
    }

    public Short getShareFlightRp2() {
        return shareFlightRp2;
    }

    public void setShareFlightRp2(Short shareFlightRp2) {
        this.shareFlightRp2 = shareFlightRp2;
    }

    public String getShareFlightNo3() {
        return shareFlightNo3;
    }

    public void setShareFlightNo3(String shareFlightNo3) {
        this.shareFlightNo3 = shareFlightNo3 == null ? null : shareFlightNo3.trim();
    }

    public Short getShareFlightRp3() {
        return shareFlightRp3;
    }

    public void setShareFlightRp3(Short shareFlightRp3) {
        this.shareFlightRp3 = shareFlightRp3;
    }

    public String getShareFlightNo4() {
        return shareFlightNo4;
    }

    public void setShareFlightNo4(String shareFlightNo4) {
        this.shareFlightNo4 = shareFlightNo4 == null ? null : shareFlightNo4.trim();
    }

    public Short getShareFlightRp4() {
        return shareFlightRp4;
    }

    public void setShareFlightRp4(Short shareFlightRp4) {
        this.shareFlightRp4 = shareFlightRp4;
    }

    public String getShareFlightNo5() {
        return shareFlightNo5;
    }

    public void setShareFlightNo5(String shareFlightNo5) {
        this.shareFlightNo5 = shareFlightNo5 == null ? null : shareFlightNo5.trim();
    }

    public Short getShareFlightRp5() {
        return shareFlightRp5;
    }

    public void setShareFlightRp5(Short shareFlightRp5) {
        this.shareFlightRp5 = shareFlightRp5;
    }

    public String getShareFlightNo6() {
        return shareFlightNo6;
    }

    public void setShareFlightNo6(String shareFlightNo6) {
        this.shareFlightNo6 = shareFlightNo6 == null ? null : shareFlightNo6.trim();
    }

    public Short getShareFlightRp6() {
        return shareFlightRp6;
    }

    public void setShareFlightRp6(Short shareFlightRp6) {
        this.shareFlightRp6 = shareFlightRp6;
    }

    public Date getNxtAldt() {
        return nxtAldt;
    }

    public void setNxtAldt(Date nxtAldt) {
        this.nxtAldt = nxtAldt;
    }

    public Date getNxtEldt() {
        return nxtEldt;
    }

    public void setNxtEldt(Date nxtEldt) {
        this.nxtEldt = nxtEldt;
    }

    public Date getAwmd() {
        return awmd;
    }

    public void setAwmd(Date awmd) {
        this.awmd = awmd;
    }

    public Date getAand() {
        return aand;
    }

    public void setAand(Date aand) {
        this.aand = aand;
    }

    public Date getAibegi() {
        return aibegi;
    }

    public void setAibegi(Date aibegi) {
        this.aibegi = aibegi;
    }

    public Date getAdumet() {
        return adumet;
    }

    public void setAdumet(Date adumet) {
        this.adumet = adumet;
    }

    public Date gettTobt() {
        return tTobt;
    }

    public void settTobt(Date tTobt) {
        this.tTobt = tTobt;
    }

    public Date getcTobt() {
        return cTobt;
    }

    public void setcTobt(Date cTobt) {
        this.cTobt = cTobt;
    }

    public Date getGate1Opendatetime4() {
        return gate1Opendatetime4;
    }

    public void setGate1Opendatetime4(Date gate1Opendatetime4) {
        this.gate1Opendatetime4 = gate1Opendatetime4;
    }

    public Date getGate1Closedatetime4() {
        return gate1Closedatetime4;
    }

    public void setGate1Closedatetime4(Date gate1Closedatetime4) {
        this.gate1Closedatetime4 = gate1Closedatetime4;
    }

    public Date getAsrt2() {
        return asrt2;
    }

    public void setAsrt2(Date asrt2) {
        this.asrt2 = asrt2;
    }

    public Date getAsat2() {
        return asat2;
    }

    public void setAsat2(Date asat2) {
        this.asat2 = asat2;
    }

    public Date getAxit2() {
        return axit2;
    }

    public void setAxit2(Date axit2) {
        this.axit2 = axit2;
    }

    public Date getAxot2() {
        return axot2;
    }

    public void setAxot2(Date axot2) {
        this.axot2 = axot2;
    }

    public String getCtrlreason() {
        return ctrlreason;
    }

    public void setCtrlreason(String ctrlreason) {
        this.ctrlreason = ctrlreason == null ? null : ctrlreason.trim();
    }

    public String getPreflno() {
        return preflno;
    }

    public void setPreflno(String preflno) {
        this.preflno = preflno == null ? null : preflno.trim();
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
        DailyFlightAddDetailsMore other = (DailyFlightAddDetailsMore) that;
        return (this.getFlightNoIata() == null ? other.getFlightNoIata() == null : this.getFlightNoIata().equals(other.getFlightNoIata()))
            && (this.getOperationalDate() == null ? other.getOperationalDate() == null : this.getOperationalDate().equals(other.getOperationalDate()))
            && (this.getaOrD() == null ? other.getaOrD() == null : this.getaOrD().equals(other.getaOrD()))
            && (this.getFlightRepeatCount() == null ? other.getFlightRepeatCount() == null : this.getFlightRepeatCount().equals(other.getFlightRepeatCount()))
            && (this.getPrevEtot() == null ? other.getPrevEtot() == null : this.getPrevEtot().equals(other.getPrevEtot()))
            && (this.getAcct1() == null ? other.getAcct1() == null : this.getAcct1().equals(other.getAcct1()))
            && (this.getAcct2() == null ? other.getAcct2() == null : this.getAcct2().equals(other.getAcct2()))
            && (this.getAcct3() == null ? other.getAcct3() == null : this.getAcct3().equals(other.getAcct3()))
            && (this.getAcct4() == null ? other.getAcct4() == null : this.getAcct4().equals(other.getAcct4()))
            && (this.getAcct5() == null ? other.getAcct5() == null : this.getAcct5().equals(other.getAcct5()))
            && (this.getAcct6() == null ? other.getAcct6() == null : this.getAcct6().equals(other.getAcct6()))
            && (this.getAcct7() == null ? other.getAcct7() == null : this.getAcct7().equals(other.getAcct7()))
            && (this.getShareFlightNo1() == null ? other.getShareFlightNo1() == null : this.getShareFlightNo1().equals(other.getShareFlightNo1()))
            && (this.getShareFlightRp1() == null ? other.getShareFlightRp1() == null : this.getShareFlightRp1().equals(other.getShareFlightRp1()))
            && (this.getShareFlightNo2() == null ? other.getShareFlightNo2() == null : this.getShareFlightNo2().equals(other.getShareFlightNo2()))
            && (this.getShareFlightRp2() == null ? other.getShareFlightRp2() == null : this.getShareFlightRp2().equals(other.getShareFlightRp2()))
            && (this.getShareFlightNo3() == null ? other.getShareFlightNo3() == null : this.getShareFlightNo3().equals(other.getShareFlightNo3()))
            && (this.getShareFlightRp3() == null ? other.getShareFlightRp3() == null : this.getShareFlightRp3().equals(other.getShareFlightRp3()))
            && (this.getShareFlightNo4() == null ? other.getShareFlightNo4() == null : this.getShareFlightNo4().equals(other.getShareFlightNo4()))
            && (this.getShareFlightRp4() == null ? other.getShareFlightRp4() == null : this.getShareFlightRp4().equals(other.getShareFlightRp4()))
            && (this.getShareFlightNo5() == null ? other.getShareFlightNo5() == null : this.getShareFlightNo5().equals(other.getShareFlightNo5()))
            && (this.getShareFlightRp5() == null ? other.getShareFlightRp5() == null : this.getShareFlightRp5().equals(other.getShareFlightRp5()))
            && (this.getShareFlightNo6() == null ? other.getShareFlightNo6() == null : this.getShareFlightNo6().equals(other.getShareFlightNo6()))
            && (this.getShareFlightRp6() == null ? other.getShareFlightRp6() == null : this.getShareFlightRp6().equals(other.getShareFlightRp6()))
            && (this.getNxtAldt() == null ? other.getNxtAldt() == null : this.getNxtAldt().equals(other.getNxtAldt()))
            && (this.getNxtEldt() == null ? other.getNxtEldt() == null : this.getNxtEldt().equals(other.getNxtEldt()))
            && (this.getAwmd() == null ? other.getAwmd() == null : this.getAwmd().equals(other.getAwmd()))
            && (this.getAand() == null ? other.getAand() == null : this.getAand().equals(other.getAand()))
            && (this.getAibegi() == null ? other.getAibegi() == null : this.getAibegi().equals(other.getAibegi()))
            && (this.getAdumet() == null ? other.getAdumet() == null : this.getAdumet().equals(other.getAdumet()))
            && (this.gettTobt() == null ? other.gettTobt() == null : this.gettTobt().equals(other.gettTobt()))
            && (this.getcTobt() == null ? other.getcTobt() == null : this.getcTobt().equals(other.getcTobt()))
            && (this.getGate1Opendatetime4() == null ? other.getGate1Opendatetime4() == null : this.getGate1Opendatetime4().equals(other.getGate1Opendatetime4()))
            && (this.getGate1Closedatetime4() == null ? other.getGate1Closedatetime4() == null : this.getGate1Closedatetime4().equals(other.getGate1Closedatetime4()))
            && (this.getAsrt2() == null ? other.getAsrt2() == null : this.getAsrt2().equals(other.getAsrt2()))
            && (this.getAsat2() == null ? other.getAsat2() == null : this.getAsat2().equals(other.getAsat2()))
            && (this.getAxit2() == null ? other.getAxit2() == null : this.getAxit2().equals(other.getAxit2()))
            && (this.getAxot2() == null ? other.getAxot2() == null : this.getAxot2().equals(other.getAxot2()))
            && (this.getCtrlreason() == null ? other.getCtrlreason() == null : this.getCtrlreason().equals(other.getCtrlreason()))
            && (this.getPreflno() == null ? other.getPreflno() == null : this.getPreflno().equals(other.getPreflno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFlightNoIata() == null) ? 0 : getFlightNoIata().hashCode());
        result = prime * result + ((getOperationalDate() == null) ? 0 : getOperationalDate().hashCode());
        result = prime * result + ((getaOrD() == null) ? 0 : getaOrD().hashCode());
        result = prime * result + ((getFlightRepeatCount() == null) ? 0 : getFlightRepeatCount().hashCode());
        result = prime * result + ((getPrevEtot() == null) ? 0 : getPrevEtot().hashCode());
        result = prime * result + ((getAcct1() == null) ? 0 : getAcct1().hashCode());
        result = prime * result + ((getAcct2() == null) ? 0 : getAcct2().hashCode());
        result = prime * result + ((getAcct3() == null) ? 0 : getAcct3().hashCode());
        result = prime * result + ((getAcct4() == null) ? 0 : getAcct4().hashCode());
        result = prime * result + ((getAcct5() == null) ? 0 : getAcct5().hashCode());
        result = prime * result + ((getAcct6() == null) ? 0 : getAcct6().hashCode());
        result = prime * result + ((getAcct7() == null) ? 0 : getAcct7().hashCode());
        result = prime * result + ((getShareFlightNo1() == null) ? 0 : getShareFlightNo1().hashCode());
        result = prime * result + ((getShareFlightRp1() == null) ? 0 : getShareFlightRp1().hashCode());
        result = prime * result + ((getShareFlightNo2() == null) ? 0 : getShareFlightNo2().hashCode());
        result = prime * result + ((getShareFlightRp2() == null) ? 0 : getShareFlightRp2().hashCode());
        result = prime * result + ((getShareFlightNo3() == null) ? 0 : getShareFlightNo3().hashCode());
        result = prime * result + ((getShareFlightRp3() == null) ? 0 : getShareFlightRp3().hashCode());
        result = prime * result + ((getShareFlightNo4() == null) ? 0 : getShareFlightNo4().hashCode());
        result = prime * result + ((getShareFlightRp4() == null) ? 0 : getShareFlightRp4().hashCode());
        result = prime * result + ((getShareFlightNo5() == null) ? 0 : getShareFlightNo5().hashCode());
        result = prime * result + ((getShareFlightRp5() == null) ? 0 : getShareFlightRp5().hashCode());
        result = prime * result + ((getShareFlightNo6() == null) ? 0 : getShareFlightNo6().hashCode());
        result = prime * result + ((getShareFlightRp6() == null) ? 0 : getShareFlightRp6().hashCode());
        result = prime * result + ((getNxtAldt() == null) ? 0 : getNxtAldt().hashCode());
        result = prime * result + ((getNxtEldt() == null) ? 0 : getNxtEldt().hashCode());
        result = prime * result + ((getAwmd() == null) ? 0 : getAwmd().hashCode());
        result = prime * result + ((getAand() == null) ? 0 : getAand().hashCode());
        result = prime * result + ((getAibegi() == null) ? 0 : getAibegi().hashCode());
        result = prime * result + ((getAdumet() == null) ? 0 : getAdumet().hashCode());
        result = prime * result + ((gettTobt() == null) ? 0 : gettTobt().hashCode());
        result = prime * result + ((getcTobt() == null) ? 0 : getcTobt().hashCode());
        result = prime * result + ((getGate1Opendatetime4() == null) ? 0 : getGate1Opendatetime4().hashCode());
        result = prime * result + ((getGate1Closedatetime4() == null) ? 0 : getGate1Closedatetime4().hashCode());
        result = prime * result + ((getAsrt2() == null) ? 0 : getAsrt2().hashCode());
        result = prime * result + ((getAsat2() == null) ? 0 : getAsat2().hashCode());
        result = prime * result + ((getAxit2() == null) ? 0 : getAxit2().hashCode());
        result = prime * result + ((getAxot2() == null) ? 0 : getAxot2().hashCode());
        result = prime * result + ((getCtrlreason() == null) ? 0 : getCtrlreason().hashCode());
        result = prime * result + ((getPreflno() == null) ? 0 : getPreflno().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", flightNoIata=").append(flightNoIata);
        sb.append(", operationalDate=").append(operationalDate);
        sb.append(", aOrD=").append(aOrD);
        sb.append(", flightRepeatCount=").append(flightRepeatCount);
        sb.append(", prevEtot=").append(prevEtot);
        sb.append(", acct1=").append(acct1);
        sb.append(", acct2=").append(acct2);
        sb.append(", acct3=").append(acct3);
        sb.append(", acct4=").append(acct4);
        sb.append(", acct5=").append(acct5);
        sb.append(", acct6=").append(acct6);
        sb.append(", acct7=").append(acct7);
        sb.append(", shareFlightNo1=").append(shareFlightNo1);
        sb.append(", shareFlightRp1=").append(shareFlightRp1);
        sb.append(", shareFlightNo2=").append(shareFlightNo2);
        sb.append(", shareFlightRp2=").append(shareFlightRp2);
        sb.append(", shareFlightNo3=").append(shareFlightNo3);
        sb.append(", shareFlightRp3=").append(shareFlightRp3);
        sb.append(", shareFlightNo4=").append(shareFlightNo4);
        sb.append(", shareFlightRp4=").append(shareFlightRp4);
        sb.append(", shareFlightNo5=").append(shareFlightNo5);
        sb.append(", shareFlightRp5=").append(shareFlightRp5);
        sb.append(", shareFlightNo6=").append(shareFlightNo6);
        sb.append(", shareFlightRp6=").append(shareFlightRp6);
        sb.append(", nxtAldt=").append(nxtAldt);
        sb.append(", nxtEldt=").append(nxtEldt);
        sb.append(", awmd=").append(awmd);
        sb.append(", aand=").append(aand);
        sb.append(", aibegi=").append(aibegi);
        sb.append(", adumet=").append(adumet);
        sb.append(", tTobt=").append(tTobt);
        sb.append(", cTobt=").append(cTobt);
        sb.append(", gate1Opendatetime4=").append(gate1Opendatetime4);
        sb.append(", gate1Closedatetime4=").append(gate1Closedatetime4);
        sb.append(", asrt2=").append(asrt2);
        sb.append(", asat2=").append(asat2);
        sb.append(", axit2=").append(axit2);
        sb.append(", axot2=").append(axot2);
        sb.append(", ctrlreason=").append(ctrlreason);
        sb.append(", preflno=").append(preflno);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}