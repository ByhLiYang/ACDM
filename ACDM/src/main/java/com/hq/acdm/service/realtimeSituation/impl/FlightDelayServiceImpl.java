package com.hq.acdm.service.realtimeSituation.impl;


import com.hq.acdm.dao.realtimeSituation.FlightDelayMapper;
import com.hq.acdm.service.realtimeSituation.FlightDelayService;

import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.realtimeSituation.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/04/01 09:11
 * @Description
 */
@Service
public class FlightDelayServiceImpl implements FlightDelayService {
    @Resource
    private FlightDelayMapper flightDelayMapper;

    @Override
    public FlightDelayVo findDelayRlsIdx(@Param("params") Map params) {
        FlightDelayVo fltRlsIdxVo = flightDelayMapper.getDelayRlsIdx(params);
        FlightDelayVo fltRlsIdxVofxl = flightDelayMapper.getFXL(params);
        if (fltRlsIdxVofxl!=null){
            fltRlsIdxVo.setZCL(fltRlsIdxVofxl.getZCL());
        }
        FlightDelayVo fltRlsIdxVozcl = flightDelayMapper.getZCL(params);
        if (fltRlsIdxVozcl!=null){
            fltRlsIdxVo.setZCL(fltRlsIdxVozcl.getZCL());
        }
        FlightDelayVo fltRlsIdxVozl = flightDelayMapper.getDelayZL(params);
        if (fltRlsIdxVozl!=null){
            fltRlsIdxVo.setZL(fltRlsIdxVozl.getZL());
        }
        fltRlsIdxVo.setZCL(new BigDecimal(fltRlsIdxVo.getZCL()*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxVo.setFXL(new BigDecimal(fltRlsIdxVo.getFXL()*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());


        return fltRlsIdxVo;
    }


    @Override
    public FDelayVo findDelayTimeCount(Map params) {

        return flightDelayMapper.getDelayTimeCount(params);
    }

    @Override
    public SPassengersVo findSPassengersCount(String [] hours) {
        SPassengersVo svo=new SPassengersVo();
        List<HBSPerHour> aJHSList1 = flightDelayMapper.getWDelayHourCount();
        List<HBSPerHour> aJHSList2 = flightDelayMapper.getWDelayHourCount2();
        List<HBSPerHour> aJHSList3 = flightDelayMapper.getEDelayHourCount();
        List<HBSPerHour> aJHSList4 = flightDelayMapper.getEDelayHourCount2();
        int [] countEOne=new int[hours.length];
        int [] countETwo=new int[hours.length];
        int [] countWOne=new int[hours.length];
        int [] countWTwo=new int[hours.length];
        int [] countEAll=new int[hours.length];
        for (int i = 0; i <hours.length ; i++) {
            countEOne[i]=0;
            countETwo[i]=0;
            countWOne[i]=0;
            countWTwo[i]=0;
            countEAll[i]=0;

        }


        for (int i = 0; i <hours.length ; i++) {
            for (int j = 0; j <aJHSList1.size() ; j++) {

                if (hours[i].equals(aJHSList1.get(j).getTime_H())){
                    countWOne[i]=aJHSList1.get(j).getHBS();
                    countEAll[i]=countEAll[i]+aJHSList1.get(j).getHBS();

                    break;
                }
            }

            for (int j = 0; j <aJHSList2.size() ; j++) {

                if (hours[i].equals(aJHSList2.get(j).getTime_H())){
                    countWTwo[i]=aJHSList2.get(j).getHBS();
                    countEAll[i]=countEAll[i]+aJHSList2.get(j).getHBS();

                    break;
                }
            }

            for (int j = 0; j <aJHSList3.size() ; j++) {

                if (hours[i].equals(aJHSList3.get(j).getTime_H())){
                    countEOne[i]=aJHSList3.get(j).getHBS();
                    countEAll[i]=countEAll[i]+aJHSList3.get(j).getHBS();

                    break;
                }
            }

            for (int j = 0; j <aJHSList4.size() ; j++) {

                if (hours[i].equals(aJHSList4.get(j).getTime_H())){
                    countETwo[i]=aJHSList4.get(j).getHBS();
                    countEAll[i]=countEAll[i]+aJHSList4.get(j).getHBS();

                    break;
                }
            }

        }
        svo.setCountEAll(countEAll);
        svo.setCountEOne(countEOne);
        svo.setCountWOne(countWOne);
        svo.setCountWTwo(countWTwo);
        svo.setCountETwo(countETwo);
        return svo;
    }

    @Override
    public BackVo findAllFlight(String [] hours) {
        BackVo bv=new BackVo();
        int [] countEHours=new int[hours.length];
        int [] countETotal=new int[hours.length];
        int [] countAll=new int[hours.length];

        for (int i = 0; i <hours.length ; i++) {
            countEHours[i]=0;
            countETotal[i]=0;
            countAll[i]=0;
        }

        List<FlightBackVo> list = flightDelayMapper.getAllFlight();
        String sobt="";
        String atot="";
        String sobth="";
        String atoth="";
        SimpleDateFormat format = new SimpleDateFormat("HH");
        String nowH=format.format(new Date());

        FlightBackVo vo=new FlightBackVo();
        for (int i = 0; i <hours.length ; i++) {
            if (hours[i].compareTo(nowH)>0){
                break;
            }
            for (int j = 0; j <list.size() ; j++) {

                 sobt="";
                 atot="";
                 sobth="";
                 atoth="";
                vo=list.get(j);
                sobt=vo.getSobt();
                sobth=sobt.substring(8,10);

                if (StringUtil.isNotEmpty(vo.getAtot())){
                    atot=vo.getAtot();
                    atoth=atot.substring(8,10);
                }

                if (hours[i].equals(sobth)){
                    if (StringUtil.isEmpty(atot)||(atot.compareTo(sobt)>0&&atoth.compareTo(hours[i])>0)){
                        countEHours[i]=countEHours[i]+1;
                    }
                }
                if (hours[i].compareTo(sobth)>=0){

                    if (StringUtil.isEmpty(atot)||(atot.compareTo(sobt)>0&&atoth.compareTo(hours[i])>0)){

                        countETotal[i]=countETotal[i]+1;
                    }

                }
            }


        }

        bv.setCountEHours(countEHours);
        bv.setCountETotal(countETotal);
        bv.setCountAll(countETotal);

        return bv;
    }

    @Override
    public List<TmdmcDgrmVo> findTmdmcDgrm() {
        return flightDelayMapper.getTmdmcDgrm();
    }

    @Override
    public int findPsgCountByFloor(String floor) {
        return flightDelayMapper.getPsgCountByFloor(floor);
    }

    @Override
    public int []  findAvgWaitTime(String [] hours) {

            SPassengersVo svo=new SPassengersVo();
            List<HBSPerHour> aJHSList1 = flightDelayMapper.getAvgWaitTime();
            int [] countAVG=new int[hours.length] ;
            for (int i = 0; i <hours.length ; i++) {
                countAVG[i]=0;
            }


            for (int i = 0; i <hours.length ; i++) {
                for (int j = 0; j <aJHSList1.size() ; j++) {

                    if (hours[i].equals(aJHSList1.get(j).getTime_H())){
                        countAVG[i]=aJHSList1.get(j).getHBS();
                        break;
                    }
                }

            }

            return countAVG;

    }

    @Override
    public FlightDelayVo findDelayRetentionP(Map params) {
        FlightDelayVo revo=new FlightDelayVo();
        FlightDelayVo fltRlsIdxVo = flightDelayMapper.getDelayRetentionP(params);
        if (fltRlsIdxVo!=null){
            revo.setGh(new BigDecimal(fltRlsIdxVo.getGh()*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            revo.setNh(new BigDecimal(fltRlsIdxVo.getNh()*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            revo.setDh(new BigDecimal(fltRlsIdxVo.getDh()*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            revo.setDf(new BigDecimal(fltRlsIdxVo.getDf()*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        }else {
            revo.setGh(0);
            revo.setNh(0);
            revo.setDh(0);
            revo.setDf(0);
        }



        return revo;
    }

    @Override
    public List<FltDelayStartEndTimeVo> findStandStartEndTime() {
        return flightDelayMapper.findStandStartEndTime();
    }

    @Override
    public List<FltDelayTimeAndNumVo> findRunwayInfoA() {
        return flightDelayMapper.findRunwayInfoA();
    }

    @Override
    public List<FltDelayTimeAndNumVo> findRunwayInfoD() {
        return flightDelayMapper.findRunwayInfoD();
    }

    @Override
    public List<FltDelayStartEndTimeVo> findTerminalBuilding() {
        return flightDelayMapper.findTerminalBuilding();
    }

    @Override
    public Map<String, Object> findAirportBearerInfo() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<FltDelayTimeAndNumVo> runwayAList = this.findRunwayInfoA();
        List<FltDelayTimeAndNumVo> runwayDList = this.findRunwayInfoD();
        String []runwayA = new String[]{"0","0","0","0","0","0","0","0","0","0","0"
                ,"0","0","0","0","0","0","0","0","0","0","0","0","0",};
        String []runwayD = new String[]{"0","0","0","0","0","0","0","0","0","0","0"
                ,"0","0","0","0","0","0","0","0","0","0","0","0","0",};
        if(runwayAList != null && runwayAList.size()>0) {
            for (int i = 0; i < runwayAList.size(); i++) {
                if ("00".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[0] = runwayAList.get(i).getHbs();
                }
                if ("01".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[1] = runwayAList.get(i).getHbs();
                }
                if ("02".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[2] = runwayAList.get(i).getHbs();
                }
                if ("03".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[3] = runwayAList.get(i).getHbs();
                }
                if ("04".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[4] = runwayAList.get(i).getHbs();
                }
                if ("05".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[5] = runwayAList.get(i).getHbs();
                }
                if ("06".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[6] = runwayAList.get(i).getHbs();
                }
                if ("07".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[7] = runwayAList.get(i).getHbs();
                }
                if ("08".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[8] = runwayAList.get(i).getHbs();
                }
                if ("09".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[9] = runwayAList.get(i).getHbs();
                }
                if ("10".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[10] = runwayAList.get(i).getHbs();
                }
                if ("11".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[11] = runwayAList.get(i).getHbs();
                }
                if ("12".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[12] = runwayAList.get(i).getHbs();
                }
                if ("13".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[13] = runwayAList.get(i).getHbs();
                }
                if ("14".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[14] = runwayAList.get(i).getHbs();
                }
                if ("15".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[15] = runwayAList.get(i).getHbs();
                }
                if ("16".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[16] = runwayAList.get(i).getHbs();
                }
                if ("17".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[17] = runwayAList.get(i).getHbs();
                }
                if ("18".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[18] = runwayAList.get(i).getHbs();
                }
                if ("19".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[19] = runwayAList.get(i).getHbs();
                }
                if ("20".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[20] = runwayAList.get(i).getHbs();
                }
                if ("21".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[21] = runwayAList.get(i).getHbs();
                }
                if ("22".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[22] = runwayAList.get(i).getHbs();
                }
                if ("23".equals(runwayAList.get(i).getTimeH())) {
                    runwayA[23] = runwayAList.get(i).getHbs();
                }
            }
        }
        if(runwayDList != null && runwayDList.size()>0) {
            for (int i = 0; i < runwayDList.size(); i++) {
                if ("00".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[0] = runwayDList.get(i).getHbs();
                }
                if ("01".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[1] = runwayDList.get(i).getHbs();
                }
                if ("02".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[2] = runwayDList.get(i).getHbs();
                }
                if ("03".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[3] = runwayDList.get(i).getHbs();
                }
                if ("04".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[4] = runwayDList.get(i).getHbs();
                }
                if ("05".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[5] = runwayDList.get(i).getHbs();
                }
                if ("06".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[6] = runwayDList.get(i).getHbs();
                }
                if ("07".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[7] = runwayDList.get(i).getHbs();
                }
                if ("08".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[8] = runwayDList.get(i).getHbs();
                }
                if ("09".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[9] = runwayDList.get(i).getHbs();
                }
                if ("10".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[10] = runwayDList.get(i).getHbs();
                }
                if ("11".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[11] = runwayDList.get(i).getHbs();
                }
                if ("12".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[12] = runwayDList.get(i).getHbs();
                }
                if ("13".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[13] = runwayDList.get(i).getHbs();
                }
                if ("14".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[14] = runwayDList.get(i).getHbs();
                }
                if ("15".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[15] = runwayDList.get(i).getHbs();
                }
                if ("16".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[16] = runwayDList.get(i).getHbs();
                }
                if ("17".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[17] = runwayDList.get(i).getHbs();
                }
                if ("18".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[18] = runwayDList.get(i).getHbs();
                }
                if ("19".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[19] = runwayDList.get(i).getHbs();
                }
                if ("20".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[20] = runwayDList.get(i).getHbs();
                }
                if ("21".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[21] = runwayDList.get(i).getHbs();
                }
                if ("22".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[22] = runwayDList.get(i).getHbs();
                }
                if ("23".equals(runwayDList.get(i).getTimeH())) {
                    runwayD[23] = runwayDList.get(i).getHbs();
                }
            }
        }

        map.put("runwayA",runwayA);
        map.put("runwayD",runwayD);

        //一天24小时
        String []hourArr = new String[]{"00","01","02","03","04","05","06","07","08","09","10",
                "11","12","13","14","15","16","17","18","19","20","21","22","23"};

        List<FltDelayStartEndTimeVo> standList = this.findStandStartEndTime();
        List<FltDelayStartEndTimeVo> terminalList = this.findTerminalBuilding();
        int []stand = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int []terminal = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        if(standList != null && standList.size()>0){
            for (int j=0;j<hourArr.length;j++){
                for(int i=0;i<standList.size();i++){
                    if((hourArr[j].compareTo(standList.get(i).getStartTimeH()) >= 0)
                            && (hourArr[j].compareTo(standList.get(i).getEndTimeH()) <= 0)){
                        stand[j] = stand[j] + 1;
                    }
                }
            }
        }

        if(terminalList != null && terminalList.size()>0){
            for (int j=0;j<hourArr.length;j++){
                for(int i=0;i<terminalList.size();i++){
                    if((hourArr[j].compareTo(terminalList.get(i).getStartTimeH()) >= 0)
                            && (hourArr[j].compareTo(terminalList.get(i).getEndTimeH()) <= 0)){
                        terminal[j] = terminal[j] + 1;
                    }
                }
            }
        }

        map.put("stand",stand);
        map.put("terminal",terminal);

        return map;
    }


}
