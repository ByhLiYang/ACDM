package com.hq.acdm.model.statistics.nodeQuery;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class NodeDetail {
 // var data={"SIBT":"计划上轮挡时间","ALDT":"实际落地时间","AIBT":"实际上轮档时间","AXIT":"实际滑入时间","SOBT":"计划撤轮档时间","TOBT":"目标撤轮档时间",
 // "COBT":"空管计算撤轮档时间","T_TOBT":"空管目标撤轮档时间","A_TOBT":"机场目标撤轮档时间","ASBT":"实际开始登机时间","ARDT":"实际结束登机时间","ACCT":"实际关舱门时间",
 // "AOBT":"实际撤轮档时间","CTOT":"空管计算起飞时间","ATOT":"实际起飞时间","AXOT":"实际滑出时间","ATTT":"实际过站时间","A_TMO":"十海里时间","A_AIBT":"入位时间",
 // "A_AOBT":"离位时间"};
 //进港航班/日期/机位
 private String FLIGHT_NO_IATA_DATE_A;
 private String OPERATIONAL_DATE;//日期
 private String FLIGHT_REPEAT_COUNT;//航班表示重复数
 private String ARN;//航班注册器
 private String ORIGIN_AIRPORT_IATA;//IATA 始发站
 private String DEST_AIRPORT_IATA;//目的站
 private String AIRPORT_VIA_IATA_1;//经停站1
 private String AIRPORT_VIA_IATA_2;//经停站2
 private String AIRPORT_VIA_IATA_3;//经停站1
 private String ORIGIN_AIRPORT_ICAO;//ICAO 始发站
 private String DEST_AIRPORT_ICAO;//目的站
 private String AIRPORT_VIA_ICAO_1;//经停站1
 private String AIRPORT_VIA_ICAO_2;//经停站2
 private String AIRPORT_VIA_ICAO_3;//经停站3

 // private String ORIGIN_AIRPORT_IATA;//基地机场 IATA_A
 private String AIRCRAFT_TERMINAL_CODE;//航班航站楼 TERMAINAL_A
 private String GAGE_1;//登机门
 private String FLIGHT_NATURE_CODE;//航班性质
 private String FN_DESCRIPTION;//航班性质描述
 private String FLIGHT_CLASS_CODE;//航班类别代码
 private String FC_DESCRIPTION;//航班类别描述
 private String FUWUTYPEDAIMA_A;//服务类型代码
 private String FUWUTYPE_A;//服务类型描述
 private String XIZHI_A;//航班性质
 private String XIZHIMIAOSHU_A;//航班性质描述

 private String REMARK_1_CODE;//通用备注
 private String FLIGHT_CANCEL_CODE;//航班是否取消
 private String SHARE_FLIGHT_NO;//共享航班号
 private String LNK_FLIGHT_NO;//联班航班号

//航班资源信息
 private String FLIGHT_NO_IATA;//航班
 private String AIRLINE_TERMINAL_CODE;//航空公司
 private String PAX_TERMINAL_CODE;//旅客候机楼
 private String STAND;//机位
 private String RWY;//跑道方向
 private String GATE_1_ROLE;//登机门1
 private String GATE_1_BOARDSTATUS;//状态
 private String GATE_1_OPENDATETIME;//开始时间
 private String GATE_1_CLOSEDATETIME;//关闭时间
 private String GATE_2_ROLE;//登机门2
 private String GATE_2_BOARDSTATUS;//状态
 private String GATE_2_OPENDATETIME;//开始时间
 private String GATE_2_CLOSEDATETIME;//关闭时间

 private String RECLAIM_BELT_1;//行李转盘1
 private String RECLAIM_BELT_1_FBDATETIME;//第一件行李时间
 private String RECLAIM_BELT_1_LBDATETIME;//最后一件行李时间
 private String RECLAIM_BELT_1_EXITDOORNO;//出口1
 private String RECLAIM_BELT_2;//行李转盘2
 private String RECLAIM_BELT_2_FBDATETIME;//第一件行李时间
 private String RECLAIM_BELT_2_LBDATETIME;//最后一件行李时间
 private String RECLAIM_BELT_2_EXITDOORNO;//出口1

 private String FLIGHT_SERVICE_TYPE;//服务类型代码
 private String FS_DESCRIPTION;//服务类型描述
 private String IATA_CODE;//服务类型描述

 //航班时间节点信息
 private String PREV_ELDT;//前站预计起飞时间
 private String PREV_ACCT;//前站实际关舱门时间
 private String PREV_ASAT;//前站实际推出时间
 private String SIBT;//计划上轮挡时间
 private String SLDT;//计划落地时间
 private String ALDT;//实际落地时间
 private String AIBT;//实际上轮挡时间
 private String EXIT;//预计滑入时间
 private String AXIT;//实际滑入时间
 private String DELAY_A;//进港延误时间
 private String CtrlContent;

 private String COBT;//进港延误时间
 private String EOBT;//
 private String ctot;//
 private String atot;//
 private String exot;//
 private String axot;//
 private String attt;//
 private String description;//
 private String acct;//
 private String sobt;//
 private String cobt;//

 //航班时间节点信息
//协商撤轮档时间
 private String DOBT;

 //地面移交    3
 private String A_GROUND_TRANSFER;

 //目标撤轮档时间 4
 private String A_TOBT;
 //靠桥客梯对接  5
 private String ARSL;
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

 private String CTOT;//计算起飞时间
 private String EXOT;//计算起飞时间
 private String AXOT;//实际滑出时间
 private String ATTT;//实际过站时间
 private String DELAY_D;//出港延误时间
 public String getASBT() {
  if(this.GATE_1_OPENDATETIME!=null)this.ASBT=this.GATE_1_OPENDATETIME;
  if(this.GATE_2_OPENDATETIME!=null)this.ASBT=this.GATE_1_OPENDATETIME;
  return this.ASBT;
 }
 public String getARDT() {
  if(this.GATE_1_CLOSEDATETIME!=null)this.ASBT=this.GATE_1_CLOSEDATETIME;
  if(this.GATE_2_CLOSEDATETIME!=null)this.ASBT=this.GATE_2_CLOSEDATETIME;
  return this.ASBT;
 }
}