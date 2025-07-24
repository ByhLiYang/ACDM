package com.hq.acdm.service.effectAnalysis.impl;

import com.hq.acdm.dao.dynamicFlight.FltMonitorMapper;
import com.hq.acdm.dao.effectAnalysis.FltHistoryMonitorMapper;
import com.hq.acdm.dao.realtimeSituation.TPresetFieldMapper;
import com.hq.acdm.model.realtimeSituation.TPresetField;
import com.hq.acdm.service.dynamicFlight.FltMonitorService;
import com.hq.acdm.service.effectAnalysis.FltHistoryMonitorService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.vo.dynamicFlight.*;
import org.apache.ibatis.annotations.Param;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class FltHistoryMonitorServiceImpl implements FltHistoryMonitorService {

    @Resource
    private FltHistoryMonitorMapper fltHistoryMonitorMapper;
    @Resource
    private TPresetFieldMapper tPresetFieldMapper;

    @Override
    public List<String> findAllCompany() {
        return fltHistoryMonitorMapper.findAllCompany();
    }

    @Override
    public List<String> findAllAirCode() {
        return fltHistoryMonitorMapper.findAllAirCode();
    }

    @Override
    public List<TLocalFlightInfoVo> findFltInfo(@Param("params") Map params) {
        List<TLocalFlightInfoVo> list = new ArrayList<TLocalFlightInfoVo>();
        List<TLocalFlightInfoVo> listFltInfo = fltHistoryMonitorMapper.getFltInfo(params);
        if(listFltInfo != null && listFltInfo.size()>0){
            for(int i=0;i<listFltInfo.size();i++){
                TLocalFlightInfoVo vo = listFltInfo.get(i);
                vo.setSobt(DateTimeUtil.timeDayFormatByStr(vo.getSobt()));
                vo.setSibt(DateTimeUtil.timeDayFormatByStr(vo.getSibt()));
                vo.setCobt(DateTimeUtil.timeDayFormatByStr(vo.getCobt()));
                vo.setCtot(DateTimeUtil.timeDayFormatByStr(vo.getCtot()));
                vo.setTobt(DateTimeUtil.timeDayFormatByStr(vo.getTobt()));
                vo.setEibt(DateTimeUtil.timeDayFormatByStr(vo.getEibt()));
                vo.setAibt(DateTimeUtil.timeDayFormatByStr(vo.getAibt()));
                vo.setEobt(DateTimeUtil.timeDayFormatByStr(vo.getEobt()));
                vo.setAobt(DateTimeUtil.timeDayFormatByStr(vo.getAobt()));
                vo.setEtdo(DateTimeUtil.timeDayFormatByStr(vo.getEtdo()));
                vo.setEtdc(DateTimeUtil.timeDayFormatByStr(vo.getEtdc()));
                vo.setAtdo(DateTimeUtil.timeDayFormatByStr(vo.getAtdo()));
                vo.setAtdc(DateTimeUtil.timeDayFormatByStr(vo.getAtdc()));
                vo.setEtfo(DateTimeUtil.timeDayFormatByStr(vo.getEtfo()));
                vo.setEtfc(DateTimeUtil.timeDayFormatByStr(vo.getEtfc()));
                vo.setAtfo(DateTimeUtil.timeDayFormatByStr(vo.getAtfo()));
                vo.setAtfc(DateTimeUtil.timeDayFormatByStr(vo.getAtfc()));
                vo.setEsct(DateTimeUtil.timeDayFormatByStr(vo.getEsct()));
                vo.setEfct(DateTimeUtil.timeDayFormatByStr(vo.getEfct()));
                vo.setAsct(DateTimeUtil.timeDayFormatByStr(vo.getAsct()));
                vo.setAfct(DateTimeUtil.timeDayFormatByStr(vo.getAfct()));
                vo.setEsc(DateTimeUtil.timeDayFormatByStr(vo.getEsc()));
                vo.setEec(DateTimeUtil.timeDayFormatByStr(vo.getEec()));
                vo.setAsc(DateTimeUtil.timeDayFormatByStr(vo.getAsc()));
                vo.setAec(DateTimeUtil.timeDayFormatByStr(vo.getAec()));
                vo.setEsr(DateTimeUtil.timeDayFormatByStr(vo.getEsr()));
                vo.setEer(DateTimeUtil.timeDayFormatByStr(vo.getEer()));
                vo.setAsr(DateTimeUtil.timeDayFormatByStr(vo.getAsr()));
                vo.setAer(DateTimeUtil.timeDayFormatByStr(vo.getAer()));
                vo.setEsbt(DateTimeUtil.timeDayFormatByStr(vo.getEsbt()));
                vo.setEebt(DateTimeUtil.timeDayFormatByStr(vo.getEebt()));
                vo.setAsbt(DateTimeUtil.timeDayFormatByStr(vo.getAsbt()));
                vo.setAebt(DateTimeUtil.timeDayFormatByStr(vo.getAebt()));
                vo.setErsl(DateTimeUtil.timeDayFormatByStr(vo.getErsl()));
                vo.setElsw(DateTimeUtil.timeDayFormatByStr(vo.getElsw()));
                vo.setArsl(DateTimeUtil.timeDayFormatByStr(vo.getArsl()));
                vo.setAlsw(DateTimeUtil.timeDayFormatByStr(vo.getAlsw()));
                vo.setATobt(DateTimeUtil.timeDayFormatByStr(vo.getATobt()));
                vo.setAGrndTsfTm(DateTimeUtil.timeDayFormatByStr(vo.getAGrndTsfTm()));
                vo.setDGrndTsfTm(DateTimeUtil.timeDayFormatByStr(vo.getDGrndTsfTm()));
                vo.setAact(DateTimeUtil.timeDayFormatByStr(vo.getAact()));
                vo.setTrdt(DateTimeUtil.timeDayFormatByStr(vo.getTrdt()));
                vo.setMpbt(DateTimeUtil.timeDayFormatByStr(vo.getMpbt()));
                vo.setMpet(DateTimeUtil.timeDayFormatByStr(vo.getMpet()));
                list.add(vo);
            }
            return list;
        }else{
            return listFltInfo;
        }


    }

    @Override
    public List<TControlInfoVo> findAllControlInfo(@Param("params") Map params) {
        return fltHistoryMonitorMapper.findAllControlInfo(params);
    }

    //航班详细信息
    @Override
    public List<FlightDetailsInfoVo> findFlightDetails(@Param("params") Map params){
        List<FlightDetailsInfoVo> fltList = fltHistoryMonitorMapper.findFlightDetails(params);
        if(fltList != null && fltList.size()>0){
            Map<String, Object> queryMap = new HashMap<>();
            int flightIdInt = 0;
            if (fltList.get(0).getFlightIdD() != null && !"".equals(fltList.get(0).getFlightIdD())){
                flightIdInt = Integer.parseInt(fltList.get(0).getFlightIdD());
            }
            queryMap.put("flightId",flightIdInt);
            List<FlightDetailsGuestInfoVo> passList = this.findFlightPassenger(queryMap);
            if(passList != null && passList.size()>0){
                if(passList.get(0) != null){
                    fltList.get(0).setBagCount(passList.get(0).getBagCount() == null ? "" : passList.get(0).getBagCount());
                    fltList.get(0).setOverStation(passList.get(0).getOverStation() == null ? "" : passList.get(0).getOverStation());
                    fltList.get(0).setCheckIn(passList.get(0).getCheckIn() == null ? "" : passList.get(0).getCheckIn());
                    fltList.get(0).setSecurityCheck(passList.get(0).getSecurityCheck() == null ? "" : passList.get(0).getSecurityCheck());
                    fltList.get(0).setBoarding(passList.get(0).getBoarding() == null ? "" : passList.get(0).getBoarding());
                }else{
                    fltList.get(0).setBagCount("");
                    fltList.get(0).setOverStation("");
                    fltList.get(0).setCheckIn("");
                    fltList.get(0).setSecurityCheck("");
                    fltList.get(0).setBoarding("");
                }
            }else{
                fltList.get(0).setBagCount("");
                fltList.get(0).setOverStation("");
                fltList.get(0).setCheckIn("");
                fltList.get(0).setSecurityCheck("");
                fltList.get(0).setBoarding("");
            }
        }

        return fltList;
    }

    //航班旅客详细信息
    @Override
    public List<FlightDetailsGuestInfoVo> findFlightPassenger(@Param("params") Map params){
        return fltHistoryMonitorMapper.findFlightPassenger(params);
    }

    //航班鱼骨图详细信息
    @Override
    public Map<String,Object> findFishboneDiagramInfo(@Param("params") Map params){
        return fltHistoryMonitorMapper.findFishboneDiagramInfo(params);
    }

    //鱼骨图节点对应字段信息
    @Override
    public List<FishboneDiagramVo> findNodeConfigColumnInfo(){
        return fltHistoryMonitorMapper.findNodeConfigColumnInfo();
    }


    //航班事件查询
    public  FlightEventReturnVo findFlightEvent(@Param("params") Map params){
        List<FlightEventVo> listFE = fltHistoryMonitorMapper.findFlightEvent(params);
        FlightEventReturnVo vo = new FlightEventReturnVo();
        if(listFE != null && listFE.size()>0){
            vo.setDate(listFE.get(0).getDate());
            vo.setInfo(listFE);
        }

        return vo;
    }

    //航班监控预设字段查询
    public List<PresetFieldJKVo> findPresetFieldJK(@Param("params") Map params){
        List<PresetFieldJKVo> listVo = new ArrayList<PresetFieldJKVo>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("loginName",params.get("loginName"));
        queryMap.put("pageType","LSJK");
        List<TPresetField> pfList = tPresetFieldMapper.findTPresetField(queryMap);
        PresetFieldJKVo vo = new PresetFieldJKVo();
        if(pfList != null && pfList.size()>0){
            TPresetField pf = pfList.get(0);
            if(!pf.getPresetField().equals("")){
                String []arr = pf.getPresetField().split(",");
                for(int i=0;i<arr.length;i++){
                    if("flno".equals(arr[i].substring(0,arr[i].length()-2))){vo.setFlno(arr[i].substring(arr[i].length()-1));}
                    if("status".equals(arr[i].substring(0,arr[i].length()-2))){vo.setStatus(arr[i].substring(arr[i].length()-1));}
                    if("craftTypeIcao".equals(arr[i].substring(0,arr[i].length()-2))){vo.setCraftTypeIcao(arr[i].substring(arr[i].length()-1));}
                    if("regn".equals(arr[i].substring(0,arr[i].length()-2))){vo.setRegn(arr[i].substring(arr[i].length()-1));}
                    if("airlines".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAirlines(arr[i].substring(arr[i].length()-1));}
                    if("adepAdes".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAdepAdes(arr[i].substring(arr[i].length()-1));}
                    if("execDateA".equals(arr[i].substring(0,arr[i].length()-2))){vo.setExecDateA(arr[i].substring(arr[i].length()-1));}
                    if("execDateD".equals(arr[i].substring(0,arr[i].length()-2))){vo.setExecDateD(arr[i].substring(arr[i].length()-1));}
                    if("standA".equals(arr[i].substring(0,arr[i].length()-2))){vo.setStandA(arr[i].substring(arr[i].length()-1));}
                    if("standD".equals(arr[i].substring(0,arr[i].length()-2))){vo.setStandD(arr[i].substring(arr[i].length()-1));}
                    if("runwayA".equals(arr[i].substring(0,arr[i].length()-2))){vo.setRunwayA(arr[i].substring(arr[i].length()-1));}
                    if("runwayD".equals(arr[i].substring(0,arr[i].length()-2))){vo.setRunwayD(arr[i].substring(arr[i].length()-1));}
                    if("changeTimeA".equals(arr[i].substring(0,arr[i].length()-2))){vo.setChangeTimeA(arr[i].substring(arr[i].length()-1));}
                    if("changeTimeD".equals(arr[i].substring(0,arr[i].length()-2))){vo.setChangeTimeD(arr[i].substring(arr[i].length()-1));}
                    if("sibt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setSibt(arr[i].substring(arr[i].length()-1));}
                    if("sobt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setSobt(arr[i].substring(arr[i].length()-1));}
                    if("aldt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAldt(arr[i].substring(arr[i].length()-1));}
                    if("atot".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAtot(arr[i].substring(arr[i].length()-1));}
                    if("cobt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setCobt(arr[i].substring(arr[i].length()-1));}
                    if("ctot".equals(arr[i].substring(0,arr[i].length()-2))){vo.setCtot(arr[i].substring(arr[i].length()-1));}
                    if("tobt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setTobt(arr[i].substring(arr[i].length()-1));}
                    if("atobt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAtobt(arr[i].substring(arr[i].length()-1));}
                    if("iscontrol".equals(arr[i].substring(0,arr[i].length()-2))){vo.setIscontrol(arr[i].substring(arr[i].length()-1));}
                    if("aibt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAibt(arr[i].substring(arr[i].length()-1));}
                    if("aobt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAobt(arr[i].substring(arr[i].length()-1));}
                    if("atdo".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAtdo(arr[i].substring(arr[i].length()-1));}
                    if("atdc".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAtdc(arr[i].substring(arr[i].length()-1));}
                    if("atfo".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAtfo(arr[i].substring(arr[i].length()-1));}
                    if("atfc".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAtfc(arr[i].substring(arr[i].length()-1));}
                    if("asct".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAsct(arr[i].substring(arr[i].length()-1));}
                    if("afct".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAfct(arr[i].substring(arr[i].length()-1));}
                    if("asc".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAsc(arr[i].substring(arr[i].length()-1));}
                    if("aec".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAec(arr[i].substring(arr[i].length()-1));}
                    if("asr".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAsr(arr[i].substring(arr[i].length()-1));}
                    if("aer".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAer(arr[i].substring(arr[i].length()-1));}
                    if("asbt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAsbt(arr[i].substring(arr[i].length()-1));}
                    if("aebt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAebt(arr[i].substring(arr[i].length()-1));}
                    if("arsl".equals(arr[i].substring(0,arr[i].length()-2))){vo.setArsl(arr[i].substring(arr[i].length()-1));}
                    if("alsw".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAlsw(arr[i].substring(arr[i].length()-1));}
                    if("agrndTsfTm".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAgrndTsfTm(arr[i].substring(arr[i].length()-1));}
                    if("dgrndTsfTm".equals(arr[i].substring(0,arr[i].length()-2))){vo.setDgrndTsfTm(arr[i].substring(arr[i].length()-1));}
                    if("delayTime".equals(arr[i].substring(0,arr[i].length()-2))){vo.setDelayTime(arr[i].substring(arr[i].length()-1));}
                    if("mpbt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setMpbt(arr[i].substring(arr[i].length()-1));}
                    if("mpet".equals(arr[i].substring(0,arr[i].length()-2))){vo.setMpet(arr[i].substring(arr[i].length()-1));}
                    if("trdt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setTrdt(arr[i].substring(arr[i].length()-1));}
                    if("aact".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAact(arr[i].substring(arr[i].length()-1));}
                    if("reasonFc".equals(arr[i].substring(0,arr[i].length()-2))){vo.setReasonFc(arr[i].substring(arr[i].length()-1));}
                    if("reasonType".equals(arr[i].substring(0,arr[i].length()-2))){vo.setReasonType(arr[i].substring(arr[i].length()-1));}
                    if("reasonsForFelay".equals(arr[i].substring(0,arr[i].length()-2))){vo.setReasonsForFelay(arr[i].substring(arr[i].length()-1));}
                }
            }
        }
        listVo.add(vo);
        return listVo;
    }


    //保存预设字段
    public int insertPresetFieldJK(@Param("params") Map params){
        String jsonStr = params.get("data").toString();
        JSONArray jsonArray = null;
        String str = "";
        try {
            jsonArray = new  JSONArray(jsonStr);
            for(int i=0 ; i < jsonArray.length() ;i++) {
                JSONObject vo = jsonArray.getJSONObject(i);
                str +="flno:"+vo.getString("flno")+",";
                str +="status:"+vo.getString("status")+",";
                str +="craftTypeIcao:"+vo.getString("craftTypeIcao")+",";
                str +="regn:"+vo.getString("regn")+",";
                str +="airlines:"+vo.getString("airlines")+",";
                str +="adepAdes:"+vo.getString("adepAdes")+",";
                str +="execDateA:"+vo.getString("execDateA")+",";
                str +="execDateD:"+vo.getString("execDateD")+",";
                str +="standA:"+vo.getString("standA")+",";
                str +="standD:"+vo.getString("standD")+",";
                str +="runwayA:"+vo.getString("runwayA")+",";
                str +="runwayD:"+vo.getString("runwayD")+",";
                str +="changeTimeA:"+vo.getString("changeTimeA")+",";
                str +="changeTimeD:"+vo.getString("changeTimeD")+",";
                str +="sibt:"+vo.getString("sibt")+",";
                str +="sobt:"+vo.getString("sobt")+",";
                str +="aldt:"+vo.getString("aldt")+",";
                str +="atot:"+vo.getString("atot")+",";
                str +="cobt:"+vo.getString("cobt")+",";
                str +="ctot:"+vo.getString("ctot")+",";
                str +="tobt:"+vo.getString("tobt")+",";
                str +="atobt:"+vo.getString("atobt")+",";
                str +="iscontrol:"+vo.getString("iscontrol")+",";
                str +="aibt:"+vo.getString("aibt")+",";
                str +="aobt:"+vo.getString("aobt")+",";
                str +="atdo:"+vo.getString("atdo")+",";
                str +="atdc:"+vo.getString("atdc")+",";
                str +="atfo:"+vo.getString("atfo")+",";
                str +="atfc:"+vo.getString("atfc")+",";
                str +="asct:"+vo.getString("asct")+",";
                str +="afct:"+vo.getString("afct")+",";
                str +="asc:"+vo.getString("asc")+",";
                str +="aec:"+vo.getString("aec")+",";
                str +="asr:"+vo.getString("asr")+",";
                str +="aer:"+vo.getString("aer")+",";
                str +="asbt:"+vo.getString("asbt")+",";
                str +="aebt:"+vo.getString("aebt")+",";
                str +="arsl:"+vo.getString("arsl")+",";
                str +="alsw:"+vo.getString("alsw")+",";
                str +="agrndTsfTm:"+vo.getString("agrndTsfTm")+",";
                str +="dgrndTsfTm:"+vo.getString("dgrndTsfTm")+",";
                str +="delayTime:"+vo.getString("delayTime")+",";
                str +="mpbt:"+vo.getString("mpbt")+",";
                str +="mpet:"+vo.getString("mpet")+",";
                str +="trdt:"+vo.getString("trdt")+",";
                str +="aact:"+vo.getString("aact")+",";
                str +="reasonFc:"+vo.getString("reasonFc")+",";
                str +="reasonType:"+vo.getString("reasonType")+",";
                str +="reasonsForFelay:"+vo.getString("reasonsForFelay")+",";
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //查询是否有此对象
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("loginName",params.get("loginName"));
        queryMap.put("pageType","HBJK");
        List<TPresetField> pfList = tPresetFieldMapper.findTPresetField(queryMap);
        if(pfList != null && pfList.size()>0){
            TPresetField tpf = pfList.get(0);
            tpf.setPresetField(str.substring(0,str.length()-1));
            return tPresetFieldMapper.updateByPrimaryKey(tpf);
        }else{
            TPresetField pf = new TPresetField();
            pf.setId(UUID.randomUUID().toString().replaceAll("-",""));
            pf.setLoginName(params.get("loginName").toString());
            pf.setPageType("LSJK");
            pf.setPresetField(str.substring(0,str.length()-1));
            return tPresetFieldMapper.insert(pf);
        }

    }

    /**
     * 查询所有航班信息无时间格式化（用于历史航班信息EXECL导出）
     * @param params
     * @return
     */
    @Override
    public List<TLocalFlightInfoVo> findFltInfoNoDateFormat(@Param("params") Map params) {
        return fltHistoryMonitorMapper.getFltInfo(params);
    }

}
