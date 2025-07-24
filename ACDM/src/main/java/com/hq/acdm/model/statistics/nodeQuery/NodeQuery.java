package com.hq.acdm.model.statistics.nodeQuery;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class NodeQuery {
 // var data={"SIBT":"计划上轮挡时间","ALDT":"实际落地时间","AIBT":"实际上轮档时间","AXIT":"实际滑入时间","SOBT":"计划撤轮档时间","TOBT":"目标撤轮档时间",
 // "COBT":"空管计算撤轮档时间","T_TOBT":"空管目标撤轮档时间","A_TOBT":"机场目标撤轮档时间","ASBT":"实际开始登机时间","ARDT":"实际结束登机时间","ACCT":"实际关舱门时间",
 // "AOBT":"实际撤轮档时间","CTOT":"空管计算起飞时间","ATOT":"实际起飞时间","AXOT":"实际滑出时间","ATTT":"实际过站时间","A_TMO":"十海里时间","A_AIBT":"入位时间",
 // "A_AOBT":"离位时间"};
 //进港航班/日期/机位
 private String FLIGHT_NO_IATA_DATE_A;

 //始发站/经停站
 private String ORIGIN_AIRPORT_IATA;
 //SIBT
 private String SIBT;
 private String ATOT;
 //A_TMO
 private String A_TMO;
 //ALDT
 private String ALDT;
 //AIBT
 private String AIBT;
 //A_AIBT
 private String A_AIBT;
 //AXIT
 private String AXIT;
 private String EXIT;
 private String ASBT;
 private String A_TOBT;


 private String  ACCT;
 private String GATE_1_CLOSEDATETIME;
 private String GATE_2_CLOSEDATETIME;
 private String GATE_3_CLOSEDATETIME;
 private String GATE_1_BOARDSTATUS;
 private String GATE_2_BOARDSTATUS;
 private String GATE_3_BOARDSTATUS;
 private String BOARDSTATUS;

 private String CTOT;
 private String CtrlContent;

 private String FLIGHT_NO_IATA_A;
 private String FLIGHT_NO_IATA_D;
 private String stand_D;
 private String stand_A;

 //出港航班/日期/机位
 private String FLIGHT_NO_IATA_DATE_D;//<a href='javascript:void(0);' onclick='showDetail(\""+index+"\",\""+D+"\")'>  查看</a>

 private String OPERATIONAL_DATE_D;

 //目的站/经停站
 private String DEST_AIRPORT_IATA;

 //日期
 private String OPERATIONAL_DATE_A;
 //航空公司
 private String FLIGHT_NO_IATA;
 //执行航班数
 private int FLIGHT_NO_ICAO;
 //SOBT
 private String SOBT;
 //预警时间
 private String YJSJ;

 private String AOBT;//实际撤轮档时间

 //TOBT
 private String TOBT;
 //正常起点航班
 private String COBT;
 //正常非起点航班
 private String T_TOBT;

 private String AXOT;
 //tobt遵从度
 private String ATTT;

 private String ARDT;

 //预计延误时间
 private String TEDT;
 private String yjyw;//延误预警 1-预警
 //机上等待时间
 private String MHWT;
 //延误原因

 //是否严格流控
 private int IsStrictCtrl;
 //是否除冰
 private String WHEHER;
 //除冰开始时间
 private String ACZT;
 //除冰结束时间
 private String AEZT;

 private String Cobt_Aldt;//cobt-aldt<1小时 颜色I变

 public String getSOBT() {
  String date=this.SOBT;
  //if (this.SOBT != null && this.SOBT.length() >= 18)date = this.SOBT.substring(11, 19);
  return SOBT;
 }
 public String getCOBT() {
  String date=this.COBT;
  //if (this.COBT != null && this.COBT.length() >= 18)date = this.COBT.substring(11, 19);
  return date;
 }
 public String getSIBT() {
  String date=this.SIBT;
  if (this.SIBT != null && this.SIBT.length() >= 18)date = this.SIBT.substring(11, 19);
  return date;
 }
 public String getYJSJ() {
  try {
   if (ATOT == null) {
    if (this.getOPERATIONAL_DATE_A() != null && this.getOPERATIONAL_DATE_D()!=null && !this.getOPERATIONAL_DATE_A().equals(this.getOPERATIONAL_DATE_D())) {
     if (SOBT != null) {
      java.text.SimpleDateFormat sss = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      java.util.Date datesobt = new java.util.Date(sss.parse(SOBT).getTime() + 1800000);//1800000=30 min
      java.text.SimpleDateFormat ssss = new java.text.SimpleDateFormat("HH:mm:ss");
      YJSJ = ssss.format(datesobt);
     }
    }else{
       if(ALDT==null)YJSJ="";
       else{
        if (SOBT != null&&SIBT!=null) {
         java.text.SimpleDateFormat sss = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         java.util.Date datesobt = new java.util.Date(sss.parse(ALDT).getTime() + sss.parse(SOBT).getTime() - sss.parse(SIBT).getTime() + 600000 + 1800000);
         if (datesobt.getTime() - sss.parse(SOBT).getTime() > 1800000) {
          java.text.SimpleDateFormat ssss = new java.text.SimpleDateFormat("HH:mm:ss");
          //   System.out.println(aldt+","+sobt+","+sibt+","+ssss.format(datesobt));
          YJSJ = ssss.format(datesobt);
         }
        }
       }


    }
   }
  }catch(Exception e){e.printStackTrace();}
  return YJSJ;
 }


 public String getA_TMO() {
  String date=this.A_TMO;
  if (A_TMO != null && A_TMO.length() >= 18) date = this.A_TMO.substring(11, 19);
  return date;
 }
 public String getCTOT() {
  String date=this.CTOT;
  //if (this.CTOT != null && this.CTOT.length() > 18) date = this.CTOT.substring(11, 19);
  return date;
 }
 public String getARDT() {
  String date=this.ARDT;
  if(date!=null&&!date.equals(""))return date;
  else if(this.GATE_1_CLOSEDATETIME!=null&&!this.GATE_1_CLOSEDATETIME.equals("")&&GATE_1_BOARDSTATUS!=null&&GATE_1_BOARDSTATUS.equals("C")){
   return this.GATE_1_CLOSEDATETIME;
  }else if(this.GATE_2_CLOSEDATETIME!=null&&!this.GATE_2_CLOSEDATETIME.equals("")&&GATE_1_BOARDSTATUS!=null&&GATE_1_BOARDSTATUS.equals("C")){
   return this.GATE_2_CLOSEDATETIME;
  }else if(this.GATE_3_CLOSEDATETIME!=null&&!this.GATE_3_CLOSEDATETIME.equals("")&&GATE_1_BOARDSTATUS!=null&&GATE_1_BOARDSTATUS.equals("C")){
   return this.GATE_3_CLOSEDATETIME;
  }

  return date;
 }
 public String getASBT() {
  String date=this.ARDT;
  if(this.GATE_1_BOARDSTATUS!=null&&(this.GATE_1_BOARDSTATUS.equals("O")||GATE_1_BOARDSTATUS!=null&&GATE_1_BOARDSTATUS.equals("A")
            ||GATE_1_BOARDSTATUS!=null&&GATE_1_BOARDSTATUS.equals("B")||GATE_1_BOARDSTATUS!=null&&GATE_1_BOARDSTATUS.equals("C")||GATE_1_BOARDSTATUS!=null&&GATE_1_BOARDSTATUS.equals("L"))){
   return this.ASBT;
  }

  return "";
 }
 public String getALDT() {
  String aldt=this.ALDT;
  //if (this.ALDT != null && this.ALDT.length() > 18) aldt = ALDT.substring(11, 19);
  return aldt;
 }
 public String getT_TOBT() {
  String date=this.T_TOBT;
  //if (this.T_TOBT != null && this.T_TOBT.length() > 18) date = T_TOBT.substring(11, 19);
  return date;
 }
 public String getAIBT() {
  String date=this.AIBT;
  //if (this.AIBT != null && this.AIBT.length() > 18) date = AIBT.substring(11, 19);
  return date;
 }
 public String getAOBT() {
  String date=this.AOBT;
 // if (this.AOBT != null && this.AOBT.length() > 18) date = AOBT.substring(11, 19);
  return date;
 }
 public String getOPERATIONAL_DATE_A() {
  String date = this.OPERATIONAL_DATE_A;
  if (date != null && date.length() > 10) date = date.substring(0, 10);
  return date;
 }

 public String getOPERATIONAL_DATE_D() {
  String date = this.OPERATIONAL_DATE_D;
  if (date != null && date.length() > 10) date = date.substring(0, 10);
  return date;
 }

 public String getCobt_Aldt() {//cobt-aldt  小于1小时 颜色变
  int hour= com.hq.acdm.model.DataUtil.getHours(this.ALDT,this.COBT);
 // System.out.println("----------------------cobt:"+this.COBT+"---------:aldt:"+this.ALDT+"--------------:"+hour);
  return String.valueOf( java.lang.Math.abs(hour) );
 }
 public String getCtot_Sobt() {//CTOT颜色预警 Ctot_Sobt<40分钟  and Ctot_Sobt>40分钟颜色变
  int hour= (int)(com.hq.acdm.model.DataUtil.getSecond(this.CTOT,this.SOBT)/60);
  //System.out.println("----------------------cobt:"+this.COBT+"---------:aldt:"+this.ALDT+"--------------:"+hour);
  return String.valueOf( java.lang.Math.abs(hour) );
 }

  public int getYjyw(){//延误预警 =1 预警 =0 不预警
     int SysYJYW=60/60;//com.hq.acdm.model.DataUtil.getAssysDictValue("EW","YJYW");
   if(this.AOBT==null&&this.COBT!=null&&this.SOBT!=null){
       int early = com.hq.acdm.model.DataUtil.getHours(this.COBT,this.SOBT);

    long diff = com.hq.acdm.model.DataUtil.getSecond(this.COBT,this.SOBT);
      this.TEDT=com.hq.acdm.model.DataUtil.getDate(diff);
   // System.out.println("----------------------early:"+early+"---------:TEDT:"+TEDT+"--------------:diff"+diff);
      if(early>SysYJYW)return 1;
     }else if (this.AOBT==null&&this.SOBT!=null){
      int early = com.hq.acdm.model.DataUtil.getHours(this.AOBT,this.SOBT);
      long diff = com.hq.acdm.model.DataUtil.getSecond(this.AOBT,this.SOBT);
      this.TEDT=com.hq.acdm.model.DataUtil.getDate(diff);
     // System.out.println("----------------------early:"+early+"---------:TEDT:"+TEDT+"--------------:diff"+diff);
      if(early>SysYJYW)return 1;

     }return 0;
  }

  public String getMHWT(){// 机上等待
   if (this.ACCT!=null&&this.ACCT.length()>0){System.out.println("----------"+this.ACCT);
    String now=com.hq.acdm.model.DataUtil.formatDate(new java.sql.Timestamp(System.currentTimeMillis()),"yyyy-MM-dd HH:mm:SS");
    long diff = com.hq.acdm.model.DataUtil.getSecond(now,this.ACCT);
  //  System.out.println("----------------------now:"+now+"---------:ACCT:"+ACCT+"--------------:diff"+diff);
    this.MHWT=com.hq.acdm.model.DataUtil.getDate(diff);
   }else if (this.GATE_1_CLOSEDATETIME!=null&&this.GATE_1_CLOSEDATETIME.length()>0&&this.BOARDSTATUS!=null){
    String now=com.hq.acdm.model.DataUtil.formatDate(new java.sql.Timestamp(System.currentTimeMillis()),"yyyy-MM-dd HH:mm:SS");
    long diff = com.hq.acdm.model.DataUtil.getSecond(now,this.GATE_1_CLOSEDATETIME);
 //   System.out.println("----------------------now:"+now+"---------:ACCT:"+ACCT+"--------------:diff"+diff);
    this.MHWT=com.hq.acdm.model.DataUtil.getDate(diff);
   }else if (this.GATE_2_CLOSEDATETIME!=null&&this.GATE_2_CLOSEDATETIME.length()>0&&this.BOARDSTATUS!=null){
    String now=com.hq.acdm.model.DataUtil.formatDate(new java.sql.Timestamp(System.currentTimeMillis()),"yyyy-MM-dd HH:mm:SS");
    long diff = com.hq.acdm.model.DataUtil.getSecond(now,this.GATE_2_CLOSEDATETIME);
 //   System.out.println("----------------------now:"+now+"---------:ACCT:"+ACCT+"--------------:diff"+diff);
    this.MHWT=com.hq.acdm.model.DataUtil.getDate(diff);
   }else if (this.GATE_3_CLOSEDATETIME!=null&&this.GATE_3_CLOSEDATETIME.length()>0&&this.BOARDSTATUS!=null){
    String now=com.hq.acdm.model.DataUtil.formatDate(new java.sql.Timestamp(System.currentTimeMillis()),"yyyy-MM-dd HH:mm:SS");
    long diff = com.hq.acdm.model.DataUtil.getSecond(now,this.GATE_3_CLOSEDATETIME);
 //   System.out.println("----------------------now:"+now+"---------:ACCT:"+ACCT+"--------------:diff"+diff);
    this.MHWT=com.hq.acdm.model.DataUtil.getDate(diff);
   }
     return this.MHWT;
  }

}