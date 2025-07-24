package com.hq.acdm.service.effectAnalysis.impl;


import com.hq.acdm.dao.effectAnalysis.SmallDelayAnalysisMapper;
import com.hq.acdm.service.effectAnalysis.SmallDelayAnalysisService;
import com.hq.acdm.vo.effectAnalysis.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class SmallDelayAnalysisServiceImpl implements SmallDelayAnalysisService {


    @Resource
    private SmallDelayAnalysisMapper smallDelayAnalysisMapper;


    @Override
    public List<SmallDelayAnalysisVo> findSmallDelayInfo(Map params) {
        return smallDelayAnalysisMapper.findSmallDelayInfo(params);
    }

    @Override
    public List<SmallDelaySumVo> findSmallDelaySum(Map params) {
        return smallDelayAnalysisMapper.findSmallDelaySum(params);
    }

    @Override
    public List<SmallDelaySumVo> findSmallDelayInfoByAdes(Map params) {
        return smallDelayAnalysisMapper.findSmallDelayInfoByAdes(params);
    }

    @Override
    public List<SmallDelayNameValueVo> findSmallDelayInfoByCraftTypeIcao(Map params) {
        return smallDelayAnalysisMapper.findSmallDelayInfoByCraftTypeIcao(params);
    }

    @Override
    public List<SmallDelayNameValueVo> findSmallDelayInfoByAirlines(Map params) {
        return smallDelayAnalysisMapper.findSmallDelayInfoByAirlines(params);
    }

    @Override
    public List<SmallDelayAdesVo> findSmallDelayAdes(Map params) {
        return smallDelayAnalysisMapper.findSmallDelayAdes(params);
    }

    @Override
    public List<SmallDelayAnalysisVo> findSmallDelayInfoByTimeSegment(Map params) {
        return smallDelayAnalysisMapper.findSmallDelayInfoByTimeSegment(params);
    }

    @Override
    public Map<String, Object> findSmallDelayAllInfo(Map params) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<SmallDelayAnalysisVo> list = new ArrayList<SmallDelayAnalysisVo>();
        List<SmallDelayAnalysisVo> listVo = this.findSmallDelayInfo(params);
        List<SmallDelaySumVo> listSum = findSmallDelaySum(params);
        List<SmallDelayAdesVo> hxList = findSmallDelayAdes(params);
        for(int i=0;i<listVo.size();i++){
            SmallDelayAnalysisVo vo = listVo.get(i);
            for(int j=0;j<listSum.size();j++){
                SmallDelaySumVo sumVo = listSum.get(j);
                if(vo.getExecDate().equals(sumVo.getExecDate())){
                    vo.setDaySum(sumVo.getTotal());
                }
            }
            list.add(vo);
        }
        String []xAxisData = new String[list.size()];
        String []delayTime_1s = new String[list.size()];
        String []delayTime_2s = new String[list.size()];
        String []delayTime_3s = new String[list.size()];
        String []delayTime_4s = new String[list.size()];
        String []delayTime_5s = new String[list.size()];
        String []delayedSchedule = new String[list.size()];
        for (int k=0;k<list.size();k++){
            SmallDelayAnalysisVo vo = list.get(k);
            if(!"0".equals(vo.getTotal())){
                xAxisData[k] = vo.getExecDate();
                delayTime_1s[k] = new BigDecimal(vo.getDelayTime1()).divide(new BigDecimal(vo.getTotal()),4,BigDecimal.ROUND_HALF_UP).toString();
                delayTime_2s[k] = new BigDecimal(vo.getDelayTime2()).divide(new BigDecimal(vo.getTotal()),4,BigDecimal.ROUND_HALF_UP).toString();
                delayTime_3s[k] = new BigDecimal(vo.getDelayTime3()).divide(new BigDecimal(vo.getTotal()),4,BigDecimal.ROUND_HALF_UP).toString();
                delayTime_4s[k] = new BigDecimal(vo.getDelayTime4()).divide(new BigDecimal(vo.getTotal()),4,BigDecimal.ROUND_HALF_UP).toString();
                delayTime_5s[k] = new BigDecimal(vo.getDelayTime5()).divide(new BigDecimal(vo.getTotal()),4,BigDecimal.ROUND_HALF_UP).toString();
                delayedSchedule[k] = new BigDecimal(vo.getTotal()).divide(new BigDecimal(vo.getDaySum()),4,BigDecimal.ROUND_HALF_UP).toString();
            }else{
                xAxisData[k] = vo.getExecDate();
                delayTime_1s[k] = "0";
                delayTime_2s[k] = "0";
                delayTime_3s[k] = "0";
                delayTime_4s[k] = "0";
                delayTime_5s[k] = "0";
                delayedSchedule[k] = "0";
            }

        }
        Map<String, Object> delayTimeMap = new HashMap<String, Object>();

        map.put("startDate",params.get("startDateStr"));
        map.put("endDate",params.get("endDateStr"));
        map.put("xAxisData",xAxisData);
        delayTimeMap.put("delayTime_1s",delayTime_1s);
        delayTimeMap.put("delayTime_2s",delayTime_2s);
        delayTimeMap.put("delayTime_3s",delayTime_3s);
        delayTimeMap.put("delayTime_4s",delayTime_4s);
        delayTimeMap.put("delayTime_5s",delayTime_5s);
        map.put("delayTime",delayTimeMap);
        map.put("delayedSchedule",delayedSchedule);
        map.put("hxList",hxList);

        return map;
    }

    @Override
    public Map<String, Object> findSmallDelayAllInfoByAdes(Map params) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<SmallDelaySumVo> voList = this.findSmallDelayInfoByAdes(params);
        String []xAxisData = new String[voList.size()];
        String []yAxisData = new String[voList.size()];
        for(int i=0;i<voList.size();i++){
            xAxisData[i] = voList.get(i).getExecDate();
            yAxisData[i] = voList.get(i).getTotal();
        }
        map.put("xAxisData",xAxisData);
        map.put("yAxisData",yAxisData);
        map.put("startDate",params.get("startDateStr"));
        map.put("endDate",params.get("endDateStr"));
        map.put("legend",new String[]{params.get("ades").toString()});

        return map;
    }

    @Override
    public Map<String, Object> findSmallDelayDetails(Map params) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<SmallDelayNameValueVo> airlineShare = this.findSmallDelayInfoByCraftTypeIcao(params);
        List<SmallDelayNameValueVo> airlineCompany = this.findSmallDelayInfoByAirlines(params);
        String []order = new String[airlineCompany.size()];
        String []orderName = new String[airlineCompany.size()];
        for(int i=0;i<airlineCompany.size();i++){
            order[i] = airlineCompany.get(i).getValue();
            orderName[i] = airlineCompany.get(i).getName();
        }
        List<SmallDelayNameValueVo> flightDelayTime = new ArrayList<SmallDelayNameValueVo>();
        List<SmallDelayAnalysisVo> listTS = findSmallDelayInfoByTimeSegment(params);
        if(listTS != null && listTS.size()>0){
            SmallDelayAnalysisVo vo = listTS.get(0);
            if(!"".equals(vo.getDelayTime1())){
                SmallDelayNameValueVo sdnvVo1 = new SmallDelayNameValueVo();
                sdnvVo1.setName("1");
                sdnvVo1.setValue(vo.getDelayTime1());
                flightDelayTime.add(sdnvVo1);
            }
            if(!"".equals(vo.getDelayTime2())){
                SmallDelayNameValueVo sdnvVo2 = new SmallDelayNameValueVo();
                sdnvVo2.setName("2");
                sdnvVo2.setValue(vo.getDelayTime2());
                flightDelayTime.add(sdnvVo2);
            }
            if(!"".equals(vo.getDelayTime3())){
                SmallDelayNameValueVo sdnvVo3 = new SmallDelayNameValueVo();
                sdnvVo3.setName("3");
                sdnvVo3.setValue(vo.getDelayTime3());
                flightDelayTime.add(sdnvVo3);
            }
            if(!"".equals(vo.getDelayTime4())){
                SmallDelayNameValueVo sdnvVo4 = new SmallDelayNameValueVo();
                sdnvVo4.setName("4");
                sdnvVo4.setValue(vo.getDelayTime4());
                flightDelayTime.add(sdnvVo4);
            }
            if(!"".equals(vo.getDelayTime5())){
                SmallDelayNameValueVo sdnvVo5 = new SmallDelayNameValueVo();
                sdnvVo5.setName("5");
                sdnvVo5.setValue(vo.getDelayTime5());
                flightDelayTime.add(sdnvVo5);
            }
        }
        map.put("airlineShare",airlineShare);
        map.put("airlineCompany",airlineCompany);
        map.put("order",order);
        map.put("orderName",orderName);
        map.put("flightDelayTime",flightDelayTime);

        return map;
    }




}


