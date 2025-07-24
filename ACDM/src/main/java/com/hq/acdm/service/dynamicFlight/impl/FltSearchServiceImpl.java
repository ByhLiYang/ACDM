package com.hq.acdm.service.dynamicFlight.impl;

import com.hq.acdm.dao.dynamicFlight.FltSearchMapper;
import com.hq.acdm.dao.realtimeSituation.TPresetFieldMapper;
import com.hq.acdm.model.realtimeSituation.TPresetField;
import com.hq.acdm.service.dynamicFlight.FltSearchService;
import com.hq.acdm.vo.dynamicFlight.FlightInfoVo;
import com.hq.acdm.vo.dynamicFlight.FlightInquiryVo;
import com.hq.acdm.vo.dynamicFlight.PresetFieldCXVo;
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
public class FltSearchServiceImpl implements FltSearchService {

    @Resource
    private FltSearchMapper fltSearchMapper;
    @Resource
    private TPresetFieldMapper tPresetFieldMapper;

    @Override
    public List<FlightInfoVo> findAllFltInfo(@Param("params") Map params) {
        return fltSearchMapper.findAllFltInfo(params);
    }

    //首页传参查询航班列表
    public List<FlightInfoVo> findIndexFltDetailInfo(@Param("params") Map params){
        return fltSearchMapper.findIndexFltDetailInfo(params);
    }

    //航班查询预设字段查询
    public List<PresetFieldCXVo> findPresetFieldCX(@Param("params") Map params){
        List<PresetFieldCXVo> listVo = new ArrayList<PresetFieldCXVo>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("loginName",params.get("loginName"));
        queryMap.put("pageType","HBCX");
        List<TPresetField> pfList = tPresetFieldMapper.findTPresetField(queryMap);
        PresetFieldCXVo vo = new PresetFieldCXVo();
        if(pfList != null && pfList.size()>0){
            TPresetField pf = pfList.get(0);
            if(!pf.getPresetField().equals("")){
                String []arr = pf.getPresetField().split(",");
                for(int i=0;i<arr.length;i++){
                    if("flno".equals(arr[i].substring(0,arr[i].length()-2))){vo.setFlno(arr[i].substring(arr[i].length()-1));}
                    if("dora".equals(arr[i].substring(0,arr[i].length()-2))){vo.setDora(arr[i].substring(arr[i].length()-1));}
                    if("status".equals(arr[i].substring(0,arr[i].length()-2))){vo.setStatus(arr[i].substring(arr[i].length()-1));}
                    if("craftTypeIcao".equals(arr[i].substring(0,arr[i].length()-2))){vo.setCraftTypeIcao(arr[i].substring(arr[i].length()-1));}
                    if("regn".equals(arr[i].substring(0,arr[i].length()-2))){vo.setRegn(arr[i].substring(arr[i].length()-1));}
                    if("airlines".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAirlines(arr[i].substring(arr[i].length()-1));}
                    if("adepAdes".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAdepAdes(arr[i].substring(arr[i].length()-1));}
                    if("execDate".equals(arr[i].substring(0,arr[i].length()-2))){vo.setExecDate(arr[i].substring(arr[i].length()-1));}
                    if("stand".equals(arr[i].substring(0,arr[i].length()-2))){vo.setStand(arr[i].substring(arr[i].length()-1));}
                    if("runway".equals(arr[i].substring(0,arr[i].length()-2))){vo.setRunway(arr[i].substring(arr[i].length()-1));}
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
//                    if("aibt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAibt(arr[i].substring(arr[i].length()-1));}
//                    if("aobt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAobt(arr[i].substring(arr[i].length()-1));}
//                    if("atdo".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAtdo(arr[i].substring(arr[i].length()-1));}
//                    if("atdc".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAtdc(arr[i].substring(arr[i].length()-1));}
//                    if("atfo".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAtfo(arr[i].substring(arr[i].length()-1));}
//                    if("atfc".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAtfc(arr[i].substring(arr[i].length()-1));}
//                    if("asct".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAsct(arr[i].substring(arr[i].length()-1));}
//                    if("afct".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAfct(arr[i].substring(arr[i].length()-1));}
//                    if("asc".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAsc(arr[i].substring(arr[i].length()-1));}
//                    if("aec".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAec(arr[i].substring(arr[i].length()-1));}
//                    if("asr".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAsr(arr[i].substring(arr[i].length()-1));}
//                    if("aer".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAer(arr[i].substring(arr[i].length()-1));}
//                    if("asbt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAsbt(arr[i].substring(arr[i].length()-1));}
//                    if("aebt".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAebt(arr[i].substring(arr[i].length()-1));}
//                    if("arsl".equals(arr[i].substring(0,arr[i].length()-2))){vo.setArsl(arr[i].substring(arr[i].length()-1));}
//                    if("alsw".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAlsw(arr[i].substring(arr[i].length()-1));}
//                    if("agrndTsfTm".equals(arr[i].substring(0,arr[i].length()-2))){vo.setAgrndTsfTm(arr[i].substring(arr[i].length()-1));}
//                    if("dgrndTsfTm".equals(arr[i].substring(0,arr[i].length()-2))){vo.setDgrndTsfTm(arr[i].substring(arr[i].length()-1));}
                    if("delayTime".equals(arr[i].substring(0,arr[i].length()-2))){vo.setDelayTime(arr[i].substring(arr[i].length()-1));}
                }
            }
        }
        listVo.add(vo);
        return listVo;
    }

    //航班查询预设字段存储
    public int insertPresetFieldCX(@Param("params") Map params){
        String jsonStr = params.get("data").toString();
        JSONArray jsonArray = null;
        String str = "";
        try {
            jsonArray = new  JSONArray(jsonStr);
            for(int i=0 ; i < jsonArray.length() ;i++) {
                JSONObject vo = jsonArray.getJSONObject(i);
                str +="flno:"+vo.getString("flno")+",";
                str +="dora:"+vo.getString("dora")+",";
                str +="status:"+vo.getString("status")+",";
                str +="craftTypeIcao:"+vo.getString("craftTypeIcao")+",";
                str +="regn:"+vo.getString("regn")+",";
                str +="airlines:"+vo.getString("airlines")+",";
                str +="adepAdes:"+vo.getString("adepAdes")+",";
                str +="execDate:"+vo.getString("execDate")+",";
                str +="stand:"+vo.getString("stand")+",";
                str +="runway:"+vo.getString("runway")+",";
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
//                str +="aibt:"+vo.getString("aibt")+",";
//                str +="aobt:"+vo.getString("aobt")+",";
//                str +="atdo:"+vo.getString("atdo")+",";
//                str +="atdc:"+vo.getString("atdc")+",";
//                str +="atfo:"+vo.getString("atfo")+",";
//                str +="atfc:"+vo.getString("atfc")+",";
//                str +="asct:"+vo.getString("asct")+",";
//                str +="afct:"+vo.getString("afct")+",";
//                str +="asc:"+vo.getString("asc")+",";
//                str +="aec:"+vo.getString("aec")+",";
//                str +="asr:"+vo.getString("asr")+",";
//                str +="aer:"+vo.getString("aer")+",";
//                str +="asbt:"+vo.getString("asbt")+",";
//                str +="aebt:"+vo.getString("aebt")+",";
//                str +="arsl:"+vo.getString("arsl")+",";
//                str +="alsw:"+vo.getString("alsw")+",";
//                str +="agrndTsfTm:"+vo.getString("agrndTsfTm")+",";
//                str +="dgrndTsfTm:"+vo.getString("dgrndTsfTm")+",";
                str +="delayTime:"+vo.getString("delayTime")+",";
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //查询是否有此对象
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("loginName",params.get("loginName"));
        queryMap.put("pageType","HBCX");
        List<TPresetField> pfList = tPresetFieldMapper.findTPresetField(queryMap);
        if(pfList != null && pfList.size()>0){
            TPresetField tpf = pfList.get(0);
            tpf.setPresetField(str.substring(0,str.length()-1));
            return tPresetFieldMapper.updateByPrimaryKey(tpf);
        }else{
            TPresetField pf = new TPresetField();
            pf.setId(UUID.randomUUID().toString().replaceAll("-",""));
            pf.setLoginName(params.get("loginName").toString());
            pf.setPageType("HBCX");
            pf.setPresetField(str.substring(0,str.length()-1));
            return tPresetFieldMapper.insert(pf);
        }
    }

    @Override
    public String findCOBTByID(String flightId) {
        return fltSearchMapper.findCOBTByID(flightId);
    }

    @Override
    public String findFLNOByID(String flightId) {
        return fltSearchMapper.findFLNOByID(flightId);
    }

    @Override
    public List<FlightInquiryVo> selectAllFlightInfo(Map params) {
        return fltSearchMapper.selectAllFlightInfo(params);
    }

}
