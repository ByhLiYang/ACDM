package com.hq.acdm.service.realtimeSituation.impl;

import com.hq.acdm.dao.realtimeSituation.FlightChartMapper;
import com.hq.acdm.service.realtimeSituation.FlightChartService;
import com.hq.acdm.vo.realtimeSituation.HBSPerHour;
import com.hq.acdm.vo.realtimeSituation.HBSPerHourVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class FlightChartServiceImpl implements FlightChartService {
    @Resource
    private FlightChartMapper flightChartMapper;
    @Override
    public List<HBSPerHour> findAJHSPerHour(@Param("params") Map params) {
        return flightChartMapper.getAJHSPerHour(params);
    }

    @Override
    public List<HBSPerHour> findASJSPerHour(@Param("params") Map params) {
        return flightChartMapper.getASJSPerHour(params);
    }

    @Override
    public List<HBSPerHour> findDJHSPerHour(@Param("params") Map params) {
        return flightChartMapper.getDJHSPerHour(params);
    }

    @Override
    public List<HBSPerHour> findDSJSPerHour(@Param("params") Map params) {
        return flightChartMapper.getDSJSPerHour(params);
    }

    @Override
    public HBSPerHourVo findHBSPerHour(@Param("params") Map params) {
        HBSPerHourVo hphv =new HBSPerHourVo();
        List<HBSPerHour> aJHSList = flightChartMapper.getAJHSPerHour(params);
        List<HBSPerHour> aSJSList = flightChartMapper.getASJSPerHour(params);
        List<HBSPerHour> dJHSList = flightChartMapper.getDJHSPerHour(params);
        List<HBSPerHour> dSJSList = flightChartMapper.getDSJSPerHour(params);
        List<Integer> aJHS = new ArrayList<>();
        List<Integer> aSJS = new ArrayList<>();
        List<Integer> dJHS = new ArrayList<>();
        List<Integer> dSJS = new ArrayList<>();
       for (int i = 0; i < 24; i++) {
            aJHS.add(0);
            aSJS.add(0);
            dJHS.add(0);
            dSJS.add(0);
        }
/*         for (int i = 0; i < 24; i++) {
            for (HBSPerHour hph : aJHSList) {
                if (i<6&&Integer.parseInt(hph.getTime_H())==i){
                    aJHS.set(i+18,hph.getHBS());
                }else if(i>=6&&Integer.parseInt(hph.getTime_H())==i){
                    aJHS.set(i-6,hph.getHBS());
                }
            }
            for (HBSPerHour hph : aSJSList) {
                if (i<6&&Integer.parseInt(hph.getTime_H())==i){
                    aSJS.set(i+18,hph.getHBS());
                }else if(i>=6&&Integer.parseInt(hph.getTime_H())==i){
                    aSJS.set(i-6,hph.getHBS());
                }
            }
            for (HBSPerHour hph : dJHSList) {
                if (i<6&&Integer.parseInt(hph.getTime_H())==i){
                    dJHS.set(i+18,hph.getHBS());
                }else if(i>=6&&Integer.parseInt(hph.getTime_H())==i){
                    dJHS.set(i-6,hph.getHBS());
                }
            }
            for (HBSPerHour hph : dSJSList) {
                if (i<6&&Integer.parseInt(hph.getTime_H())==i){
                    dSJS.set(i+18,hph.getHBS());
                }else if(i>=6&&Integer.parseInt(hph.getTime_H())==i){
                    dSJS.set(i-6,hph.getHBS());
                }
            }
        }*/
//原先的6到6点改为0到24点
        for (int i = 0; i < 24; i++) {
            for (HBSPerHour hph : aJHSList) {
                if (Integer.parseInt(hph.getTime_H())==i){
                    aJHS.set(i,hph.getHBS());
                }
            }
            for (HBSPerHour hph : aSJSList) {
                if (Integer.parseInt(hph.getTime_H())==i){
                    aSJS.set(i,hph.getHBS());
                }
            }
            for (HBSPerHour hph : dJHSList) {
                if (Integer.parseInt(hph.getTime_H())==i){
                    dJHS.set(i,hph.getHBS());
                }
            }
            for (HBSPerHour hph : dSJSList) {
                if (Integer.parseInt(hph.getTime_H())==i){
                    dSJS.set(i,hph.getHBS());
                }
            }
        }
        hphv.setAJHS(aJHS);
        hphv.setASJS(aSJS);
        hphv.setDJHS(dJHS);
        hphv.setDSJS(dSJS);
        return hphv;
    }
}
