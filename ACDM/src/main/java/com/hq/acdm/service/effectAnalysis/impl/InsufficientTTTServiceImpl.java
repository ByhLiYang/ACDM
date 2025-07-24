package com.hq.acdm.service.effectAnalysis.impl;


import com.hq.acdm.dao.effectAnalysis.InsufficientTTTMapper;

import com.hq.acdm.dao.realtimeSituation.FlightIndexMapper;
import com.hq.acdm.service.effectAnalysis.InsufficientTTTService;

import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.effectAnalysis.FltDelayTypeVo;
import com.hq.acdm.vo.effectAnalysis.FltDelayVo;
import com.hq.acdm.vo.effectAnalysis.InsufficientTTTVo;

import com.hq.acdm.vo.effectAnalysis.LlgkVo;
import com.hq.acdm.vo.realtimeSituation.BackVo;
import com.hq.acdm.vo.realtimeSituation.FlightBackAVo;
import com.hq.acdm.vo.realtimeSituation.FlightBackVo;
import com.hq.acdm.vo.realtimeSituation.FltDetailIdxVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class InsufficientTTTServiceImpl implements InsufficientTTTService {

    @Resource
    private FlightIndexMapper flightIndexMapper;
    @Resource
    private InsufficientTTTMapper insufficientMapper;


    @Override
    public List<InsufficientTTTVo> selectGZBZ(@Param("params") Map params) {
        return insufficientMapper.selectGZBZ(params);
    }

    @Override
    public List<InsufficientTTTVo> selectGZBZHis(Map params) {
        return insufficientMapper.selectGZBZHis(params);
    }

    @Override
    public double getFltNormIdxByD(Map params) {
        return insufficientMapper.getFltNormIdxByD(params);
    }

    @Override
    public double getFltNormIdxByA(Map params) {
        return insufficientMapper.getFltNormIdxByA(params);
    }

    @Override
    public FltDetailIdxVo getDGNDetails(Map params) {
        return flightIndexMapper.getDGNDetails(params);
    }

    @Override
    public FltDetailIdxVo getDGJDetails(Map params) {
        return flightIndexMapper.getDGJDetails(params);
    }

    @Override
    public FltDetailIdxVo getAGNDetails(Map params) {
        return flightIndexMapper.getAGNDetails(params);
    }

    @Override
    public FltDetailIdxVo getAGJDetails(Map params) {
        return flightIndexMapper.getAGJDetails(params);
    }

    @Override
    public FltDelayVo selectFltDelay() {
        FltDelayVo fdv = new FltDelayVo();
        int ywywsc = insufficientMapper.selectYWYWSC();
        int yw015 = insufficientMapper.selectYW015();
        int yw1530 = insufficientMapper.selectYW1530();
        int yw3060 = insufficientMapper.selectYW3060();
        int yw60120 = insufficientMapper.selectYW60120();
        int yw120 = insufficientMapper.selectYW120();
        fdv.setYwywsc(ywywsc);
        fdv.setYw015(yw015);
        fdv.setYw1530(yw1530);
        fdv.setYw3060(yw3060);
        fdv.setYw60120(yw60120);
        fdv.setYw120(yw120);
        fdv.setYwywsl(yw015+yw1530+yw3060+yw60120+yw120);
        return fdv;
    }

    @Override
    public List<FltDelayTypeVo> selectYWType() {
        return insufficientMapper.selectYWType();
    }

    @Override
    public LlgkVo getAllFlightD(Map params) {
        LlgkVo bv=new LlgkVo();
        Date today=new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH");
        String nowH=format.format(today);
        SimpleDateFormat formatymd = new SimpleDateFormat("yyyy-MM-dd HH");
        String [] pa=new String [6];
        try {
            Date startDate=DateTimeUtil.plusHour(-4,today);
            pa[0]= format.format(startDate);
            pa[1]= format.format(DateTimeUtil.plusHour(-3,today));
            pa[2]= format.format(DateTimeUtil.plusHour(-2,today));
            pa[3]= format.format(DateTimeUtil.plusHour(-1,today));
            pa[4]= nowH;
            Date endDate=DateTimeUtil.plusHour(1,today);
            pa[5]= format.format(endDate);

            params.put("startTime",formatymd.format(startDate)+":00:00");
            params.put("endTime",formatymd.format(endDate)+":59:59");
            System.out.println(params.get("startTime")+" "+params.get("endTime"));
        } catch (ParseException e) {
            //e.printStackTrace();

        }


        int [] countES=new int[pa.length];//预计
        int [] countActual=new int[pa.length];//实际
        int [] countETotal=new int[pa.length];//积压


        for (int i = 0; i <pa.length ; i++) {
            countES[i]=0;
            countETotal[i]=0;
            countActual[i]=0;
        }

        List<FlightBackVo> list = insufficientMapper.getAllFlightD(params);
        String sobt="";
        String atot="";
        String sobth="";
        String atoth="";

        int delay=0;
        FlightBackVo vo=new FlightBackVo();
        for (int i = 0; i <pa.length ; i++) {
            if (pa[i].compareTo(pa[pa.length-1])>0){
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
                delay=vo.getDelayTime();
                if (StringUtil.isNotEmpty(vo.getAtot())){
                    atot=vo.getAtot();
                    atoth=atot.substring(8,10);
                    if (pa[i].equals(atoth)){
                        countActual[i]=countActual[i]+1;
                    }
                }

                if (pa[i].equals(sobth)){
                    /*if (StringUtil.isEmpty(atot)||(atot.compareTo(sobt)>0&&atoth.compareTo(hours[i])>0)){
                        countEHours[i]=countEHours[i]+1;
                    }*/
                    countES[i]=countES[i]+1;
                }
                if (pa[i].compareTo(sobth)>=0&&delay>0){

                    if (StringUtil.isEmpty(atot)||(atot.compareTo(sobt)>0&&atoth.compareTo(pa[i])>0)){

                        countETotal[i]=countETotal[i]+1;
                    }

                }
            }


        }
        List<int[]> staticData=new ArrayList<int[]>();

        staticData.add(countActual);
        staticData.add(countES);
        staticData.add(countETotal);

        bv.setLegendData(pa);
        bv.setStaticData(staticData);


        return bv;
    }

    @Override
    public LlgkVo getAllFlightA(Map params) {
        LlgkVo bv=new LlgkVo();
        Date today=new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH");
        String nowH=format.format(today);

        SimpleDateFormat formatymd = new SimpleDateFormat("yyyy-MM-dd HH");
        String [] pa=new String [6];
        try {
            Date startDate=DateTimeUtil.plusHour(-4,today);
            pa[0]= format.format(startDate);
            pa[1]= format.format(DateTimeUtil.plusHour(-3,today));
            pa[2]= format.format(DateTimeUtil.plusHour(-2,today));
            pa[3]= format.format(DateTimeUtil.plusHour(-1,today));
            pa[4]= nowH;
            Date endDate=DateTimeUtil.plusHour(1,today);
            pa[5]= format.format(endDate);

            params.put("startTime",formatymd.format(startDate)+":00:00");
            params.put("endTime",formatymd.format(endDate)+":59:59");
            System.out.println(params.get("startTime")+" "+params.get("endTime"));
        } catch (ParseException e) {
            //e.printStackTrace();

        }

        int [] countES=new int[pa.length];//预计
        int [] countActual=new int[pa.length];//实际
        int [] countETotal=new int[pa.length];//积压


        for (int i = 0; i <pa.length ; i++) {
            countES[i]=0;
            countETotal[i]=0;
            countActual[i]=0;
        }

        List<FlightBackAVo> list = insufficientMapper.getAllFlightA(params);
        String sibt="";
        String aldt="";
        String sibth="";
        String aldth="";

        int delay=0;
        FlightBackAVo vo=new FlightBackAVo();
        for (int i = 0; i <pa.length ; i++) {
            if (pa[i].compareTo(pa[pa.length-1])>0){
                break;
            }
            for (int j = 0; j <list.size() ; j++) {

                sibt="";
                aldt="";
                sibth="";
                aldth="";
                vo=list.get(j);
                sibt=vo.getSibt();
                sibth=sibt.substring(8,10);
                delay=vo.getDelayTime();
                if (StringUtil.isNotEmpty(vo.getAldt())){
                    aldt=vo.getAldt();
                    aldth=aldt.substring(8,10);
                    if (pa[i].equals(aldth)){
                        countActual[i]=countActual[i]+1;
                    }
                }

                if (pa[i].equals(sibth)){
                    /*if (StringUtil.isEmpty(atot)||(atot.compareTo(sobt)>0&&atoth.compareTo(hours[i])>0)){
                        countEHours[i]=countEHours[i]+1;
                    }*/
                    countES[i]=countES[i]+1;
                }
                if (pa[i].compareTo(sibth)>=0&&delay>0){

                    if (StringUtil.isEmpty(aldt)||(aldt.compareTo(sibt)>0&&aldth.compareTo(pa[i])>0)){

                        countETotal[i]=countETotal[i]+1;
                    }

                }
            }


        }
        List<int[]> staticData=new ArrayList<int[]>();
        staticData.add(countActual);
        staticData.add(countES);

        staticData.add(countETotal);

        bv.setLegendData(pa);
        bv.setStaticData(staticData);


        return bv;
    }


}
