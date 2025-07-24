package com.hq.acdm.model.statistics.detainedPassage;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class DetainedPassage {
    //日期
    private String operational_date;
    //航空公司
    private String AIRLINE_CODE_IATA;
    //航站楼
    private String aircraft_terminal_code;
    //区域
    private String areaid;
    //登机口
    private String gate_1;
    //航班号
    private String flight_no_iata;
    //正常起点航班
  //  private int operational_date;
    //目标机场
    private String dest_airport_iata;

    private String sobt;
    //tobt遵从度
    private String eobt;

    private int retention;
    private String wait;

    //cobt遵从度
    private String atot;
    //cobt执行
    private String description;

    private int chkcnt;
    private int boarcnt;

    //机上人数
    private int secucnt;

    private Timestamp gate_1_closedatetime;
    private Timestamp gate_2_closedatetime;
    private Timestamp gate_3_closedatetime;
    private String gate_1_boardstatus;
    private String gate_2_boardstatus;
    private String gate_3_boardstatus;

    public String getWait(){
        java.util.Date date=new java.util.Date();
        long l=0;
        if(gate_1_closedatetime!=null&&gate_1_boardstatus!=null&&gate_1_boardstatus.equals("C")&&atot==null)l=date.getTime()-gate_1_closedatetime.getTime();
        if(gate_2_closedatetime!=null&&gate_2_boardstatus!=null&&gate_2_boardstatus.equals("C")&&atot==null)l=date.getTime()-gate_2_closedatetime.getTime();
        if(gate_3_closedatetime!=null&&gate_3_boardstatus!=null&&gate_3_boardstatus.equals("C")&&atot==null)l=date.getTime()-gate_3_closedatetime.getTime();
      //  System.out.println("-----------------------------------l:"+l);
        float waits=l/(1000*60);
        return String.valueOf(waits);
    }

}