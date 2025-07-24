package com.hq.acdm.model.monitoring.sameDayFlight;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class FlightInfo {

 //进港航班/日期/机位
 private String FLIGHT_NO_IATA_DATE_A;

 //始发站/经停站
 private String ORIGIN_AIRPORT_IATA;
 //计划上轮挡时间
 private String SIBT;
 //计划撤轮档时间
 private String SOBT;
 //正常起点航班
 private String COBT;
 //ELDT
 private String ELDT;

 //实际起飞时间-前站起飞 1
 private String PRE_ATOT;

 //实际落地时间    2
 private String ALDT;

 //地面移交    3
 private String A_GROUND_TRANSFER;

 //实际上轮档时间 4
 private String AIBT;
 //靠桥客梯对接  5
 private String ARSL;
 //开客舱门  6
 private String ATDO;
 //开货舱门 7
 private String ATFO;
 //开始保洁8
 private String  ASCT;
 //完成保洁9
 private String  AFCT;
 //开始加油10
 private String ASR;
 //完成加油11
 private String AER;
//开始配餐12
 private String TASC;
 //完成配餐13
 private String AEC;
 //实际开始登机时间 14
 private String ASBT;
 //完成登机15
 private String AEBT;
 //关客舱门16
 private String ATDC;
 //关货仓门17
 private String ATFC;
 //机务放行18
 private String AACT;
 //离桥/客梯撤离19
 private String LSW;
 //实际撤轮档时间20
 private String AOBT;
 //实际撤轮档时间21
 private String D_GROUND_TRANSFER;
 //起飞22
 private String ATOT;
 //值机人数
 private String Checkin;
 //安检人数
 private String Check;
 //登机人数
 private String Boarding;


 public void setCheckin(String checkin) {
  Checkin = checkin;
 }
 public void setCheck(String check){
   this.Check=check;
 }
 public  void setBoarding(String boarding){
  this.Boarding=boarding;
 }

 private java.util.Collection<FlightInfoNode> data=new java.util.ArrayList<FlightInfoNode>();
 public  void addNode(FlightInfoNode node){
  data.add(node);
 }

 private Integer currentStep;//22个点当前到哪个步骤


 private String FLIGHT_NO_IATA_A;
 private String FLIGHT_NO_IATA_D;
 private String stand_D;
 private String stand_A;

 //出港日期
 private String OPERATIONAL_DATE_D;


 //日期
 private String OPERATIONAL_DATE;
 //航空公司
 private String FLIGHT_NO_IATA;
 //执行航班数
 private int FLIGHT_NO_ICAO;



/*

 public String getSOBT(){
  if(this.SOBT!=null&&this.SOBT.length()>=18)this.SOBT=SOBT.substring(11,19);
  return this.SOBT;
 }
 public String getSIBT(){
  if(this.SIBT!=null&&this.SIBT.length()>=18)this.SIBT=SIBT.substring(11,19);
  return this.SIBT;
 }

 public String getALDT(){
  if(this.ALDT!=null&&this.ALDT.length()>18)this.ALDT=ALDT.substring(11,19);
  return this.ALDT;
 }
 public String getAIBT(){
  if(this.AIBT!=null&&this.AIBT.length()>18)this.AIBT=AIBT.substring(11,19);
  return this.AIBT;
 }*/
 public String getA_GROUND_TRANSFER() {
  return A_GROUND_TRANSFER;
 }
 public String getAACT() {
  return AACT;
 }
 public String getAEBT() {
  return AEBT;
 }
 public String getAER() {
  return AER;
 }
 public String getAEC() {
  return AEC;
 }
 public String getAFCT() {
  return AFCT;
 }
 public String getAIBT() {
  return AIBT;
 }
 public String getALDT() {
  return ALDT;
 }
 public String getARSL() {
  return ARSL;
 }
 public String getAOBT() {
  return AOBT;
 }
 public String getASBT() {
  return ASBT;
 }
 public String getASCT() {
  return ASCT;
 }
 public String getASR() {
  return ASR;
 }
 public String getATDC() {
  return ATDC;
 }
 public String getATDO() {
  return ATDO;
 }
 public String getATFC() {
  return ATFC;
 }
 public String getATFO() {
  return ATFO;
 }
 public String getATOT() {
  return ATOT;
 }
 public String getCOBT() {
  return COBT;
 }
 public Integer getCurrentStep() {
  return currentStep;
 }
 public String getD_GROUND_TRANSFER() {
  return D_GROUND_TRANSFER;
 }
 public String getELDT() {
  return ELDT;
 }
 public String getFLIGHT_NO_IATA() {
  return FLIGHT_NO_IATA;
 }
 public String getFLIGHT_NO_IATA_A() {
  return FLIGHT_NO_IATA_A;
 }
 public String getFLIGHT_NO_IATA_D() {
  return FLIGHT_NO_IATA_D;
 }
 public String getFLIGHT_NO_IATA_DATE_A() {
  return FLIGHT_NO_IATA_DATE_A;
 }
 public int getFLIGHT_NO_ICAO() {
  return FLIGHT_NO_ICAO;
 }
 public String getLSW() {
  return LSW;
 }
 public String getOPERATIONAL_DATE() {
  return OPERATIONAL_DATE;
 }
 public String getOPERATIONAL_DATE_D() {
  return OPERATIONAL_DATE_D;
 }
 public String getORIGIN_AIRPORT_IATA() {
  return ORIGIN_AIRPORT_IATA;
 }
 public String getPRE_ATOT() {
  return PRE_ATOT;
 }
 public String getSOBT() {
  return SOBT;
 }
 public String getSIBT() {
  return SIBT;
 }
 public String getStand_A() {
  return stand_A;
 }
 public String getStand_D() {
  return stand_D;
 }
 public String getTASC() {
  return TASC;
 }
}