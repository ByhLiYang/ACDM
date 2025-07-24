package com.hq.acdm.model.timer.HistoricalFlightMaster;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author wangshuhao
 * @date 2018/11/11 0011 16:36
 */
@Getter
@Setter
public class DailyFlightAddDetails {
    private String ARN;			//飞行器注册号
    private String TYPE;	//	机型
    private Date OPERATIONAL_DATE; //航班计划时间
    private String FLIGHT_NO_IATA	;	//	航班IATA代码
    private String FLIGHT_NO_ICAO;		//	航班ICAO代码
    private String A_OR_D;		//	进港或出港
    private String FLIGHT_REPEAT_COUNT;		//	航班重复号
    private String FLIGHT_IATA_SUFFIX;		//	航班（IATA）前缀
    private String FLIGHT_ICAO_SUFFIX;		//	航班（ICAO）前缀
    private String AIRCRAFT_CALLSIGN;		//	飞行器呼号
    private String OWNER_IATA_CODE;		//	飞行器所有者（IATA）代码
    private int PAX_CAPACITY;		//	飞行器最大承载容量
    private String AIRCRAFT_IATA_SUBTYPE;		//	飞行器子类型IATA
    private String AIRCRAFT_TERMINAL_CODE;		//	飞行器所停靠航站楼代码
    private String AIRLINE_TERMINAL_CODE;		//	航空公司所在杭州刘代码
    private Date BELT_1_CLOSEDATETIME;	//号行李帯关闭时间
    private Date BELT_2_CLOSEDATETIME;		//号行李帯关闭时间
    private Date BELT_3_CLOSEDATETIME;		//号行李帯关闭时间
    private Date BELT_1_OPENDATETIME;		//号行李提取处开放时间
    private Date BELT_2_OPENDATETIME;		//号行李提取处开放时间
    private Date BELT_3_OPENDATETIME;		//号行李提取处开放时间
    private String BELT_1_POSITION_ROLE;		//号行李带位置
    private String BELT_2_POSITION_ROLE;		//号行李带位置
    private String BELT_3_POSITION_ROLE;
    private String RECLAIM_BELT_1;
    private String RECLAIM_BELT_2;
    private String RECLAIM_BELT_3;
    private String RECLAIM_BELT_1_ROLE;
    private String RECLAIM_BELT_2_ROLE;
    private String RECLAIM_BELT_3_ROLE;
    private Date RECLAIM_BELT_1_CLOSEDATETIME;	//号行李提取处关闭时间
    private Date RECLAIM_BELT_2_CLOSEDATETIME;	//号行李提取处关闭时间
    private Date RECLAIM_BELT_3_CLOSEDATETIME;	//号行李提取处关闭时间
    private Date RECLAIM_BELT_1_OPENDATETIME;	//号行李提取处开放时间
    private Date RECLAIM_BELT_2_OPENDATETIME;	//号行李提取处开放时间
    private Date RECLAIM_BELT_3_OPENDATETIME;	//号行李提取处开放时间
    private String RECLAIM_BELT_1_EXITDOORNO;
    private String RECLAIM_BELT_2_EXITDOORNO;
    private String RECLAIM_BELT_3_EXITDOORNO;
    private Date RECLAIM_BELT_1_FBDATETIME;	//第一件行李处理时间 - 1号行李提取处
    private Date RECLAIM_BELT_2_FBDATETIME;	//第一件行李处理时间 - 2号行李提取处
    private Date RECLAIM_BELT_3_FBDATETIME;	//第一件行李处理时间 - 3号行李提取处
    private Date RECLAIM_BELT_1_LBDATETIME;	//最后一件行李处理时间 - 1号行李提取处
    private Date RECLAIM_BELT_2_LBDATETIME;	//最后一件行李处理时间 - 2号行李提取处
    private Date RECLAIM_BELT_3_LBDATETIME;	//最后一件行李处理时间 - 3号行李提取处
    private String BAGGAGE_TERMINAL_CODE_1;		//	行李所在航站楼代码
    private String BAGGAGE_TERMINAL_CODE_2;		//	行李所在航站楼代码
    private String BAGGAGE_TERMINAL_CODE_3;		//	行李所在航站楼代码
    private String IS_BUS_REQUIRED;		//	是否需要公交
    private String CHECKIN_CLUSTED_ID_1;		
    private String CHECKIN_CLUSTED_ID_2	;	
    private String CHECKIN_CLUSTED_ID_3	;	
    private String CHECKIN_DESKRANGE_1;		//	值机柜台范围
    private String CHECKIN_DESKRANGE_2;		//	值机柜台范围
    private String CHECKIN_DESKRANGE_3;		//	值机柜台范围
    private String CHECKIN_ROLE_1;		
    private String CHECKIN_ROLE_2;		
    private String CHECKIN_ROLE_3;		
    private String CHECKIN_TYPE_CODE_1;		//	值机类型代码
    private String CHECKIN_TYPE_CODE_2;		//	值机类型代码
    private String CHECKIN_TYPE_CODE_3;		//	值机类型代码
    private Date CHECKIN_1_OPENDATETIME	;//	值机开启时间
    private Date CHECKIN_2_OPENDATETIME	;//	值机开启时间

    private Date CHECKIN_3_OPENDATETIME	;//	0	0	-1	0	值机开启时间
    private Date CHECKIN_1_CLOSEDATETIME	;//	0	0	-1	0	值机关闭时间
    private Date CHECKIN_2_CLOSEDATETIME	;//	0	0	-1	0	值机关闭时间
    private Date CHECKIN_3_CLOSEDATETIME	;//	0	0	-1	0	值机关闭时间
    private String GATE_1_ROLE		;//
    private String GATE_2_ROLE		;//
    private String GATE_3_ROLE		;//
    private Date GATE_1_OPENDATETIME	;//	0	0	-1	0	登机门开启时间
    private Date GATE_2_OPENDATETIME	;//	0	0	-1	0	登机门开启时间
    private Date GATE_3_OPENDATETIME	;//	0	0	-1	0	登机门开启时间
    private Date GATE_1_CLOSEDATETIME	;//	0	0	-1	0	登机门关闭时间
    private Date GATE_2_CLOSEDATETIME	;//	0	0	-1	0	登机门关闭时间
    private Date GATE_3_CLOSEDATETIME	;//	0	0	-1	0	登机门关闭时间
    private String PAX_TERMINAL_CODE		;//	旅客航站楼代码
    private String REMARK_1_CODE		;//	备注码
    private String REMARK_2_CODE		;//	备注码
    private String REMARK_3_CODE		;//	备注码
    private String REMARK_4_CODE		;//	备注码
    private String REMARK_5_CODE		;//	备注码
    private String REMARK_1_TYPE		;//	备注类型
    private String REMARK_2_TYPE		;//	备注类型
    private String REMARK_3_TYPE		;//	备注类型
    private String REMARK_4_TYPE		;//	备注类型
    private String REMARK_5_TYPE		;//	备注类型
    private String IS_SECURE_STAND_REQUIRED		;//	是否需要安保停机位
    private String SUPP_INFO_TEXT		;//	保障信息
    private String SUPP_INFO_TYPE		;//	保障类型
    private String ACCOUNT_CODE		;//	账户编码
    private String CODE_SHARE_STATUS		;//	共享航班状态
    private String DIVERT_AIRPORT		;//	备降机场
    private String FLIGHT_CANCEL_CODE		;//	航班取消代码
    private String FLIGHT_CLASS_CODE		;//	航班类别代码
    private String FLIGHT_NATURE_CODE		;//	航班属性编码(training,cargo)
    private String IS_OVERNIGHT		;//	是否过夜
    private String FLIGHT_SECTOR_CODE		;//	航班归属，如国内、或国际
    private String FLIGHT_SERVICE_TYPE		;//	服务类型IATA,举例：J = Normal Passenger Service, M = Mail Only
    private String FLIGHT_STATUS_CODE		;//	航班状态编码
    private String FLIGHT_TRANSIT_CODE		;//	转机编码
    private String HANDLING_AGENT_1_CODE		;//	航务代理IATA编码
    private String HANDLING_AGENT_2_CODE		;//	航务代理IATA编码
    private String HANDLING_AGENT_3_CODE		;//	航务代理IATA编码
    private String HANDLING_AGENT_4_CODE		;//	航务代理IATA编码
    private String HANDLING_AGENT_5_CODE		;//	航务代理IATA编码
    private String HANDLING_AGENT_1_SERVICE		;//	航务代理服务
    private String HANDLING_AGENT_2_SERVICE		;//	航务代理服务
    private String HANDLING_AGENT_3_SERVICE		;//	航务代理服务
    private String HANDLING_AGENT_4_SERVICE		;//	航务代理服务
    private String HANDLING_AGENT_5_SERVICE		;//	航务代理服务
    private String IRR_1_IATA_CODE		;//	IRR TATA编码
    private String IRR_2_IATA_CODE		;//	IRR IATA编码
    private String IRR_3_IATA_CODE		;//	IRR IATA编码
    private String IRR_1_NUM_CODE		;//	IRR数字编码
    private String IRR_2_NUM_CODE		;//	IRR数字编码
    private String IRR_3_NUM_CODE		;//	IRR数字编码
    private String IRR_1_ROLE		;//
    private String IRR_2_ROLE		;//
    private String IRR_3_ROLE		;//
    private String IS_GEN_AVIAT_FLIGHT		;//	是否为通航
    private String IS_RETURN_FLIGHT		;//	是否为返航
    private String IS_TRANSFER_FLIGHT		;//	是否为调机
    private String LNK_CARRIER_CODE		;//	运输编号
    private String LNK_FLIGHT_NO		;//	联班号
    private String LNK_FLIGHT_SUFFIX		;//	联班号前缀
    private int LNK_FLIGHT_REPEAT_COUNT	;//	0	0	-1	0	联班号重复次数
    private Date LNK_SCHEDULE_DATE;	//	7	0	-1	0	联班计划执行时间
    private String OPERATION_TYPE_CODE		;//	执行类型编号
    private String OPERATION_TYPE_ROLE		;//	执行类型角色
    private String SHARE_CARRIER_CODE		;//	共享运输号
    private String SHARE_FLIGHT_NO		;//	共享航班号
    private int SHARE_FLIGHT_REPEAT_COUNT	;//	0	0	-1	0	共享航班重复次数
    private int TOTAL_BAG_COUNT	;//	0	0	-1	0	总行李数
    private int TOTAL_BAG_WEIGHT	;//	0	0	-1	0	行李总重
    private int TOTAL_FREIGHT_WEIGHT	;//	0	0	-1	0	货物总重
    private int TOTAL_LOAD_WEIGHT	;//	0	0	-1	0	总承载
    private int TOTAL_MAIL_WEIGHT	;//	0	0	-1	0	邮件总重
    private int TRANSFER_BAG_COUNT	;//	0	0	-1	0	调机行李总数
    private int TRANSFER_BAG_WEIGHT	;//	0	0	-1	0	调机行李总重
    private int TRANSFER_CARGO_WEIGHT	;//	0	0	-1	0	调机货物总重
    private int TRANSFER_MAIL_WEIGHT	;//	0	0	-1	0	调机邮件总重
    private int TRANSIT_BAG_COUNT	;//	0	0	-1	0	中转行李总数
    private int TRANSIT_BAG_WEIGHT	;//	0	0	-1	0	中转行李重量
    private int ADULT_PAX_COUNT	;//	0	0	-1	0	成人旅客数
    private int CHILD_PAX_COUNT	;//	0	0	-1	0	儿童旅客数
    private int INFANT_PAX_COUNT	;//	0	0	-1	0	婴儿旅客数
    private int DOM_PAX_COUNT	;//	0	0	-1	0	国内旅客数
    private int INT_PAX_COUNT	;//	0	0	-1	0	国际旅客数
    private int FC_PAX_COUNT	;//	0	0	-1	0	一等舱旅客人数
    private int BC_PAX_COUNT	;//	0	0	-1	0	商务舱旅客人数
    private int ECON_PAX_COUNT	;//	0	0	-1	0	经济舱旅客人数
    private int LOCAL_PAX_COUNT	;//	0	0	-1	0	本地旅客人数
    private int NT_PAX_COUNT	;//	0	0	-1	0	非中转旅客人数
    private int TX_PAX_COUNT	;//	0	0	-1	0	中转旅客人数
    private int TRANSIT_PAX_COUNT	;//	0	0	-1	0
    private int WC_PAX_COUNT	;//	0	0	-1	0	轮椅旅客人数
    private int TOTAL_PAX_COUNT	;//	0	0	-1	0	旅客总人数
    private int TOTAL_CREW_COUNT	;//	0	0	-1	0	机组人数
    private String PUBLIC_FLIGHT_ID		;//	公开航班号
    private String PUBLIC_CARRIED_ID		;//	公开货运号
    private Date PUBLIC_DATETIME	;//	0	0	-1	0	公开事件
    private String IRR_1_DURATION		;//
    private String IRR_2_DURATION		;//
    private String IRR_3_DURATION		;//
    private String OPERATION_TYPE_CODE_1		;//	操作类型编号
    private String OPERATION_TYPE_CODE_2		;//	操作类型编号
    private String OPERATION_TYPE_ROLE_1		;//	操作类型角色
    private String OPERATION_TYPE_ROLE_2		;//	操作类型角色
    private String AIRPORT_VIA_IATA_1		;//	过站机场IATA
    private String AIRPORT_VIA_IATA_2		;//	过站机场IATA
    private String AIRPORT_VIA_IATA_3		;//	过站机场IATA
    private String AIRPORT_VIA_IATA_4		;//	过站机场IATA
    private String AIRPORT_VIA_IATA_5		;//	过站机场IATA
    private String AIRPORT_VIA_IATA_6		;//	过站机场IATA
    private String AIRPORT_VIA_IATA_7		;//	过站机场IATA
    private String AIRPORT_VIA_ICAO_1		;//	过站机场ICAO
    private String AIRPORT_VIA_ICAO_2		;//	过站机场ICAO
    private String AIRPORT_VIA_ICAO_3		;//	过站机场ICAO
    private String AIRPORT_VIA_ICAO_4		;//	过站机场ICAO
    private String AIRPORT_VIA_ICAO_5		;//	过站机场ICAO
    private String AIRPORT_VIA_ICAO_6		;//	过站机场ICAO
    private String AIRPORT_VIA_ICAO_7		;//	过站机场ICAO
    private String GATE_1_BOARDSTATUS		;//	登机门状态
    private String GATE_2_BOARDSTATUS		;//	登机门状态
    private String GATE_3_BOARDSTATUS		;//	登机门状态
    private String MASTER_FLIGHT_IDENTITY		;//
    private String MASTER_FLIGHT_REPEAT_COUNT		;//
    private Date PREV_ELDT	;//	0	0	-1	0	前站预计落地时间
    private Date PREV_ACCT	;//	0	0	-1	0	前站实际关舱门时间
    private Date PREV_ASAT	;//	0	0	-1	0	前站实际推出时间
    private Date CTOT	;//	0	0	-1	0	计算起飞时间
    private Date COBT	;//	0	0	-1	0	计算撤轮档时间
    private Date DOBT	;//	0	0	-1	0	协商撤轮档时间
    private Date A_TOBT	;//	0	0	-1	0	目标撤轮档时间（机场）
    private int ISSTRICTCTRL	;//	0	0	-1	0	是否严格流控
    private Date AIBT_1	;//	0	0	-1	0	AIBT(IBM)
    private Date AIBT_2	;//	0	0	-1	0	AIBT(ATC)
    private Date AIBT_3	;//	0	0	-1	0	AIBT(CCTV)
    private Date AIBT_4	;//	0	0	-1	0	AIBT(AIRLINE)
    private Date AIBT_5	;//	0	0	-1	0	AIBT(手工值)
    private Date AIBT_6	;//	0	0	-1	0	AIBT(备用1)
    private Date AIBT_7	;//	0	0	-1	0	AIBT(备用2)
    private Date AOBT_1	;//	0	0	-1	0	AOBT(IBM)
    private Date AOBT_2	;//	0	0	-1	0	AOBT(ATC)
    private Date AOBT_3	;//	0	0	-1	0	AOBT(CCTV)
    private Date AOBT_4	;//	0	0	-1	0	AOBT(AIRLINE)
    private Date AOBT_5	;//	0	0	-1	0	AOBT(手工值)
    private Date AOBT_6	;//	0	0	-1	0	AOBT(备用1)
    private Date AOBT_7	;//	0	0	-1	0	AOBT(备用2)
    private Date ATOT_1	;//	0	0	-1	0	ATOT(IBM)
    private Date ATOT_2	;//	0	0	-1	0	ATOT(ATC)
    private Date ATOT_3	;//	0	0	-1	0	ATOT(CCTV)
    private Date ATOT_4	;//	0	0	-1	0	ATOT(AIRLINE)
    private Date ATOT_5	;//	0	0	-1	0	ATOT(手工值)
    private Date ATOT_6	;//	0	0	-1	0	ATOT(备用1)
    private Date ATOT_7	;//	0	0	-1	0	ATOT(备用2)
    private Date ELDT_1	;//	0	0	-1	0	ELDT(IBM)
    private Date ELDT_2	;//	0	0	-1	0	ELDT(ATC)
    private Date ELDT_3	;//	0	0	-1	0	ELDT(CCTV)
    private Date ELDT_4	;//	0	0	-1	0	ELDT(AIRLINE)
    private Date ELDT_5	;//	0	0	-1	0	ELDT(手工值)
    private Date ELDT_6	;//	0	0	-1	0	ELDT(备用1)
    private Date ELDT_7	;//	0	0	-1	0	ELDT(备用2)
    private Date ALDT_1	;//	0	0	-1	0	ALDT(IBM)
    private Date ALDT_2	;//	0	0	-1	0	ALDT(ATC))
    private Date ALDT_3	;//	0	0	-1	0	ALDT(CCTV)
    private Date ALDT_4	;//	0	0	-1	0	ALDT(AIRLINE)
    private Date ALDT_5	;//	0	0	-1	0	ALDT(手工值)
    private Date ALDT_6	;//	0	0	-1	0	ALDT(备用1)
    private Date ALDT_7	;//	0	0	-1	0	ALDT(备用2)
    private Date TLDT	;//	0	0	-1	0	雷达更新目标着落时间（空管）
    private String CTRLCONTENT;	//	400	0	-1	0	流控内容（空管）
    private String CTRLPOINT;		//25;//	流控点（空管）
    private int ISREQUIREDDEICING	;//	0	0	-1	0	是否需要去冰
    private int DEICINGTYPE	;//	0	0	-1	0	去冰类型
    private int DECINGSTAND	;//	0	0	-1	0	去冰停机位号
    private  int countNumber;

}
