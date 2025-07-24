package com.hq.acdm.service.statistics.GateAreaMaintenance.impl;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.dao.statistics.GateAreaMaintenanceMapper;
import com.hq.acdm.model.statistics.gateAreaMaintenance.GateAreaMaintenance;
import com.hq.acdm.service.statistics.GateAreaMaintenance.GateAreaMaintenanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/9/27 0027 9:12
 */
@Service("GateAreaMaintenanceService")
public class GateAreaMaintenanceServiceImpl implements GateAreaMaintenanceService {
    @Resource
    private GateAreaMaintenanceMapper gateAreaMaintenanceMapper;

    @Override
    public List<GateAreaMaintenance> queryGateAreaMaintenance(Map params) {
        List<GateAreaMaintenance> gateAreaMaintenances = gateAreaMaintenanceMapper.queryGateAreaMaintenance(params);
        List<GateAreaMaintenance> modifyList = new ArrayList<>();
        Map<String,String> gateMap = new HashMap<>();
        Set<String> areaidSet = new TreeSet<>();
        for(int i=0;i<gateAreaMaintenances.size();i++){
            areaidSet.add(gateAreaMaintenances.get(i).getAREAID());
        }
        for (String value : areaidSet) {
            String temp_gate = "";
            for(int i=0;i<gateAreaMaintenances.size();i++){
                if(value.equals(gateAreaMaintenances.get(i).getAREAID())){
                    temp_gate = temp_gate + gateAreaMaintenances.get(i).getGATE()+",";
                }
            }
            temp_gate = temp_gate.substring(0,temp_gate.length()-1);
            gateMap.put(value,temp_gate);
        }
        for(Map.Entry<String, String> entry: gateMap.entrySet()) {
            GateAreaMaintenance gateAreaMaintenance = new GateAreaMaintenance();
            for(int i=0;i<gateAreaMaintenances.size();i++)
            {
//                System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
                if(gateAreaMaintenances.get(i).getAREAID().equals(entry.getKey())){
                    gateAreaMaintenance.setNAME(gateAreaMaintenances.get(i).getNAME());
                    gateAreaMaintenance.setGATE(entry.getValue());
                    gateAreaMaintenance.setPAX_THRESHOLD(gateAreaMaintenances.get(i).getPAX_THRESHOLD());
                    gateAreaMaintenance.setAREAID(gateAreaMaintenances.get(i).getAREAID());
                    gateAreaMaintenance.setTERMINAL(gateAreaMaintenances.get(i).getTERMINAL());
                    modifyList.add(gateAreaMaintenance);
                    break;
                }
            }

        }
        return modifyList;
    }

    @Override
    public List<GateAreaMaintenance> queryGate(String terminal) {
        return gateAreaMaintenanceMapper.queryGate(terminal);
    }

    @Override
    public List<GateAreaMaintenance> queryArea() {
        return gateAreaMaintenanceMapper.queryArea();
    }


    @Override
    public Map<String,Object> insert(String terminal, String gate, String description, String passengerMax, String gateArea) {
        String[] split = gate.split(",");
        List<GateAreaMaintenance> list = new ArrayList<>();
        List<GateAreaMaintenance> areaList = new ArrayList<>();
        areaList = gateAreaMaintenanceMapper.queryArea();
        List<String> gateTotalList = new ArrayList<>();
        List<String> gateDealList = new ArrayList<>();
        List<GateAreaMaintenance> gateList = new ArrayList<>();
        gateList = gateAreaMaintenanceMapper.queryGate(terminal);
        Boolean areaFlag = false;
        for (int i = 0; i < areaList.size(); i++) {
            if (gateArea.equals(areaList.get(i).getAREAID())) {
                areaFlag = true;
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < gateList.size(); i++) {
            stringList.add(gateList.get(i).getGATE());
        }
        for (int i = 0; i < split.length; i++) {
            gateTotalList.add(split[i]);
            for (int j = 0; j < gateList.size(); j++) {
                if (gateList.get(j).getGATE().equals(split[i])) {
                    gateDealList.add(split[i]);
                    break;
                }
            }
        }
        List<String> gateNotExistList = new ArrayList<>();
        for (String str2 : gateTotalList) {
            if (!stringList.contains(str2)) {
                // 打印出list1没有f,g
                System.out.println("ArrayList1里没有的是==>" + str2);
                gateNotExistList.add(str2);
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        System.out.println(areaFlag);
        if (areaFlag) {
            resultMap.put("status", 0);
            return resultMap;
        } else {
            if (gateDealList.size() <= 0) {
                resultMap.put("status", 1);
                resultMap.put("notExist", gateNotExistList);
                return resultMap;
            } else {
                for (int i = 0; i < gateDealList.size(); i++) {
                    GateAreaMaintenance gateAreaMaintenance = new GateAreaMaintenance();
                    gateAreaMaintenance.setAREAID(gateArea);
                    gateAreaMaintenance.setGATE(gateDealList.get(i));
                    gateAreaMaintenance.setPAX_THRESHOLD(passengerMax);
                    gateAreaMaintenance.setTERMINAL(terminal);
                    gateAreaMaintenance.setNAME(description);
                    gateAreaMaintenance.setSTAND_LAYOUT("Active");
                    list.add(gateAreaMaintenance);
                }
                Map<Object, Object> insertMap = new HashMap<>();
                insertMap.put("AREAID", gateArea);
                insertMap.put("TERMINAL", terminal);
                insertMap.put("PAX_THRESHOLD", passengerMax);
                insertMap.put("NAME", description);
                insertMap.put("STATUS", "0");
                int result_modeifyGate = gateAreaMaintenanceMapper.modifyGate(list);
                int result_insertArea = gateAreaMaintenanceMapper.insertArea(insertMap);
                resultMap.put("modify", result_modeifyGate);
                resultMap.put("insert", result_insertArea);
                resultMap.put("notExist", gateNotExistList);
            }


            return null;
        }
    }

    @Override
    public Map<String, Object> delete(String terminal, String gate, String description, String passengerMax, String gateArea, String oldTerminal) {
        String[] split = gate.split(",");
        Map<String,Object> resultMap = new HashMap<>();
        List<GateAreaMaintenance> gateList = new ArrayList<>();
        if ("1".equals(oldTerminal)){
            gateArea = "T1其他";
        }else{
            gateArea = "T2其他";
        }
        for(int i=0;i<split.length;i++){
            GateAreaMaintenance gateAreaMaintenance = new GateAreaMaintenance();
            gateAreaMaintenance.setAREAID(gateArea);
            gateAreaMaintenance.setGATE(split[i]);
            gateAreaMaintenance.setPAX_THRESHOLD(passengerMax);
            gateAreaMaintenance.setTERMINAL(terminal);
            gateAreaMaintenance.setNAME(description);
            gateAreaMaintenance.setSTAND_LAYOUT("Active");
            gateList.add(gateAreaMaintenance);
        }
        int result_modeifyGate = gateAreaMaintenanceMapper.modifyGate(gateList);
        int result_insertArea = gateAreaMaintenanceMapper.deleteArea(gateArea);
        resultMap.put("modify",result_modeifyGate);
        resultMap.put("delete",result_insertArea);
        return resultMap;
    }

    @Override
    public Map<String, Object> modify(String terminal, String gate, String description, String passengerMax, String gateArea, String oldTerminal) {
        String[] split = gate.split(",");
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> modifyMap = new HashMap<>();
        List<GateAreaMaintenance> gateList = new ArrayList<>();
        if ("1".equals(oldTerminal)){
            gateArea = "T1其他";
        }else{
            gateArea = "T2其他";
        }
        for(int i=0;i<split.length;i++){
            GateAreaMaintenance gateAreaMaintenance = new GateAreaMaintenance();
            gateAreaMaintenance.setAREAID(gateArea);
            gateAreaMaintenance.setGATE(split[i]);
            gateAreaMaintenance.setPAX_THRESHOLD(passengerMax);
            gateAreaMaintenance.setTERMINAL(terminal);
            gateAreaMaintenance.setNAME(description);
            gateAreaMaintenance.setSTAND_LAYOUT("Active");
            gateList.add(gateAreaMaintenance);
        }
        modifyMap.put("terminal",terminal);
        modifyMap.put("description",description);
        modifyMap.put("passengerMax",passengerMax);
        modifyMap.put("gateArea",gateArea);
        int result_modeifyGate = gateAreaMaintenanceMapper.modifyGate(gateList);
        int result_insertArea = gateAreaMaintenanceMapper.updateArea(modifyMap);
        resultMap.put("modify_Gate",result_modeifyGate);
        resultMap.put("modify_Area",result_insertArea);
        return resultMap;
    }

}
