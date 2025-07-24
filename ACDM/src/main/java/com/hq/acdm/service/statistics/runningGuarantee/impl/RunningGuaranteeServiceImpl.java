package com.hq.acdm.service.statistics.runningGuarantee.impl;

import com.hq.acdm.dao.statistics.RunningGuaranteeMapper;
import com.hq.acdm.model.statistics.runningGuarantee.RunningGuaranteeModel;
import com.hq.acdm.service.statistics.runningGuarantee.RunningGuaranteeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/12/7 0007 9:31
 */
@Service("RunningGuaranteeService")
public class RunningGuaranteeServiceImpl implements RunningGuaranteeService {
    @Resource
    private RunningGuaranteeMapper runningGuaranteeMapper;
    @Override
    public Map<String, Object> query(Map<String, Object> map) {
        List<RunningGuaranteeModel> listFXLBYHOUR = new ArrayList<>();
        List<RunningGuaranteeModel> listFXLBYTime = new ArrayList<>();
        List<RunningGuaranteeModel> listZCLByAIRLINE = new ArrayList<>();
        List<RunningGuaranteeModel> listZCLByHour = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        List<String> list5 = new ArrayList<>();
        List<String> list6 = new ArrayList<>();
        List<String> list7 = new ArrayList<>();
        List<String> list8 = new ArrayList<>();
        List<String> list9 = new ArrayList<>();
        List<String> list10 = new ArrayList<>();
        try{
            listFXLBYHOUR = runningGuaranteeMapper.getFXLBYHOUR(map);
            listFXLBYTime = runningGuaranteeMapper.getFXLBYTime(map);
            listZCLByAIRLINE = runningGuaranteeMapper.getZCLByAIRLINE(map);
            listZCLByHour = runningGuaranteeMapper.getZCLByHour(map);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        list1.add("时间");
        list2.add("总架次");
        list3.add("不正常架次");
        list4.add("放行率");
        list5.add("正常率");
        list6.add("航空公司");
        list7.add("总架次");
        list8.add("不正常架次");
        list9.add("正常率");
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        Map<String,Object> map3 = new HashMap<>();
        Map<String,Object> map4 = new HashMap<>();
        Map<String,Object> map5 = new HashMap<>();
        Map<String,Object> map6 = new HashMap<>();
        Map<String,Object> map7 = new HashMap<>();
        map1.put("name","总架次");
        map2.put("name","不正常架次");
        map3.put("name","放行率");
        map4.put("name","正常率");
        map5.put("name","总架次");
        map6.put("name","不正常架次");
        map7.put("name","正常率");
        List<Map<String,Object>> mapList1 = new ArrayList<>();
        List<Map<String,Object>> mapList2 = new ArrayList<>();
        if(listFXLBYHOUR.size()>0){
            for(int i=0;i<listFXLBYHOUR.size();i++){
                list1.add(Integer.toString(listFXLBYHOUR.get(i).getATOT()));
                list2.add(Integer.toString(listFXLBYHOUR.get(i).getZS()));
                list3.add(Integer.toString(listFXLBYHOUR.get(i).getYWS()));
                list4.add(listFXLBYHOUR.get(i).getFXL());
                list5.add(listZCLByHour.get(i).getZCS());
                map1.put(Integer.toString(listFXLBYHOUR.get(i).getATOT()),Integer.toString(listFXLBYHOUR.get(i).getZS()));
                map2.put(Integer.toString(listFXLBYHOUR.get(i).getATOT()),Integer.toString(listFXLBYHOUR.get(i).getYWS()));
                map3.put(Integer.toString(listFXLBYHOUR.get(i).getATOT()),listFXLBYHOUR.get(i).getFXL());
                map4.put(Integer.toString(listFXLBYHOUR.get(i).getATOT()),listZCLByHour.get(i).getZCS());
            }
        }
        if(listZCLByAIRLINE.size()>0){
            for(int i=0;i<listZCLByAIRLINE.size();i++){
                list6.add(listZCLByAIRLINE.get(i).getAIRLINE_CODE_IATA());
                list7.add(Integer.toString(listZCLByAIRLINE.get(i).getZS()));
                list8.add(Integer.toString(listZCLByAIRLINE.get(i).getYWS()));
                list9.add(listZCLByAIRLINE.get(i).getZCS());
                map5.put(listZCLByAIRLINE.get(i).getAIRLINE_CODE_IATA(),Integer.toString(listZCLByAIRLINE.get(i).getZS()));
                map6.put(listZCLByAIRLINE.get(i).getAIRLINE_CODE_IATA(),Integer.toString(listZCLByAIRLINE.get(i).getYWS()));
                map7.put(listZCLByAIRLINE.get(i).getAIRLINE_CODE_IATA(),listZCLByAIRLINE.get(i).getZCS());

            }
        }
        if(listFXLBYTime.size()>0){
            list10.add(listFXLBYTime.get(0).getFXL());
        }
        mapList1.add(map1);
        mapList1.add(map2);
        mapList1.add(map3);
        mapList1.add(map4);
        mapList2.add(map5);
        mapList2.add(map6);
        mapList2.add(map7);
        Map<String,Object> map10 = new HashMap<>();
        map10.put("total",list10);
        map10.put("time",mapList1);
        map10.put("timeZone",list1);
//        map10.put("timeFlight",list2);
//        map10.put("timeAbnormal",list3);
//        map10.put("timeFX",list4);
//        map10.put("timeZC",list5);
        map10.put("airline",mapList2);
        map10.put("airCompany",list6);
//        map10.put("airlineFlight",list7);
//        map10.put("airlineAbnormal",list8);
//        map10.put("airlineZC",list9);
        return map10;
    }
}
