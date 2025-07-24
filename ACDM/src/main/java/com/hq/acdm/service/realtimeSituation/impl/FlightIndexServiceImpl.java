package com.hq.acdm.service.realtimeSituation.impl;

import com.google.common.collect.Lists;
import com.hq.acdm.dao.index.VForecastMapper;
import com.hq.acdm.dao.realtimeSituation.FlightIndexMapper;
import com.hq.acdm.dao.realtimeSituation.FltRlsIdxMapper;
import com.hq.acdm.model.monitoring.passager.PassagerFlow;
import com.hq.acdm.service.realtimeSituation.FlightIndexService;
import com.hq.acdm.service.rscMonitors.RealtimeStandService;
import com.hq.acdm.vo.index.FlightNumVo;
import com.hq.acdm.vo.realtimeSituation.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/04/01 09:11
 * @Description
 */
@Service
public class FlightIndexServiceImpl implements FlightIndexService {
    @Resource
    private FlightIndexMapper flightIndexMapper;
    @Resource
    private FltRlsIdxMapper fltRlsIdxMapper;
    @Resource
    private VForecastMapper vForecastMapper;
    @Override
    public FlightIndexVo findFlightIndex(@Param("params") Map params) {
        FlightIndexVo fiv = new FlightIndexVo();
        fiv.setZCS(flightIndexMapper.getZCS(params));
        fiv.setZCSA(flightIndexMapper.getZCSA(params));
        fiv.setZCSD(flightIndexMapper.getZCSD(params));
        fiv.setFHSA(flightIndexMapper.getFHSA(params));
        fiv.setBJSA(flightIndexMapper.getBJSA(params));
        fiv.setFHSD(flightIndexMapper.getFHSD(params));
        fiv.setBJSD(flightIndexMapper.getBJSD(params));
        fiv.setYWS(flightIndexMapper.getYWS(params));
        fiv.setYWSA(flightIndexMapper.getYWSA(params));
        fiv.setFXYWS(flightIndexMapper.getFXYWS(params));
        fiv.setQXS(flightIndexMapper.getQXS(params));
        fiv.setQXSA(flightIndexMapper.getQXSA(params));
        fiv.setQXSD(flightIndexMapper.getQXSD(params));
        fiv.setETA30(flightIndexMapper.getETA30(params));
        fiv.setLDHX(flightIndexMapper.getLDHX(params));
        fiv.setDMBZ(flightIndexMapper.getDMBZ(params));
        fiv.setZBJX(flightIndexMapper.getZBJX(params));
        fiv.setLGHX(flightIndexMapper.getLGHX(params));
        fiv.setKYJW(flightIndexMapper.getJWZS(params)-flightIndexMapper.getZYJW(params));
        fiv.setYYJW(flightIndexMapper.getZYJW(params));
        fiv.setJWLYL(flightIndexMapper.getZYJW(params)/flightIndexMapper.getJWZS(params));
        double gmzdl = 0;
        if(flightIndexMapper.getGMZDL(params) != null){
            gmzdl = new BigDecimal(flightIndexMapper.getGMZDL(params)).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        fiv.setGMZDL(gmzdl);
        fiv.setKQL(new BigDecimal(flightIndexMapper.getKQL(params)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fiv.setZHB(flightIndexMapper.getZHB(params));
        fiv.setLK(flightIndexMapper.getLK(params));
        fiv.setXL(flightIndexMapper.getXL(params));
        fiv.setJGZXL(new BigDecimal(flightIndexMapper.getJGZXL(params)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fiv.setCGZXL(new BigDecimal(flightIndexMapper.getCGZXL(params)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        return fiv;
    }

    @Override
    public List<FltDetailIdxVo> findAFltDetailIdx(@Param("params") Map params) {
        List<FltDetailIdxVo> list = new ArrayList<>();
        FltDetailIdxVo agn = flightIndexMapper.getAGNDetails(params);
        agn.setAttribute("国内");
        FltDetailIdxVo agj = flightIndexMapper.getAGJDetails(params);
        agj.setAttribute("国际");
        FltDetailIdxVo adq = flightIndexMapper.getADQDetails(params);
        adq.setAttribute("地区");
        FltDetailIdxVo ahh = flightIndexMapper.getAHHDetails(params);
        ahh.setAttribute("混合");
        FltDetailIdxVo ahj = flightIndexMapper.getAHJDetails(params);
        ahj.setAttribute("合计");
        list.add(agn);
        list.add(agj);
        list.add(adq);
        list.add(ahh);
        list.add(ahj);
        return list;
    }

    @Override
    public List<FltDetailIdxVo> findDFltDetailIdx(@Param("params") Map params) {
        List<FltDetailIdxVo> list = new ArrayList<>();
        FltDetailIdxVo dgn = flightIndexMapper.getDGNDetails(params);
        dgn.setAttribute("国内");
        FltDetailIdxVo dgj = flightIndexMapper.getDGJDetails(params);
        dgj.setAttribute("国际");
        FltDetailIdxVo ddq = flightIndexMapper.getDDQDetails(params);
        ddq.setAttribute("地区");
        FltDetailIdxVo dhh = flightIndexMapper.getDHHDetails(params);
        dhh.setAttribute("混合");
        FltDetailIdxVo dhj = flightIndexMapper.getDHJDetails(params);
        dhj.setAttribute("合计");
        list.add(dgn);
        list.add(dgj);
        list.add(ddq);
        list.add(dhh);
        list.add(dhj);
        return list;
    }

    @Override
    public FltRlsIdxVo findFltRlsIdx(@Param("params") Map params) {
        FltRlsIdxVo fltRlsIdxVo = new FltRlsIdxVo();
        fltRlsIdxVo.setZCL(new BigDecimal(fltRlsIdxMapper.getFltNormIdx(params)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxVo.setFXL(new BigDecimal(fltRlsIdxMapper.getFltRlsIdx(params)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        return fltRlsIdxVo;
    }

    @Override
    public FltRlsIdxAptVo findFltRlsIdxByApt(@Param("params") Map params) {
        Map<String,Object> mapPEK = new HashMap<String,Object>();
        mapPEK.put("airport","PEK");
        mapPEK.put("dept",params.get("dept"));
        mapPEK.put("agent",params.get("agent"));
        Map<String,Object> mapSHA = new HashMap<String,Object>();
        mapSHA.put("airport","SHA");
        mapSHA.put("dept",params.get("dept"));
        mapSHA.put("agent",params.get("agent"));
        Map<String,Object> mapCAN = new HashMap<String,Object>();
        mapCAN.put("airport","CAN");
        mapCAN.put("dept",params.get("dept"));
        mapCAN.put("agent",params.get("agent"));
        Map<String,Object> mapCTU = new HashMap<String,Object>();
        mapCTU.put("airport","CTU");
        mapCTU.put("dept",params.get("dept"));
        mapCTU.put("agent",params.get("agent"));

        Map<String,Object> mapKMG = new HashMap<String,Object>();
        mapKMG.put("airport","KMG");
        mapKMG.put("dept",params.get("dept"));
        mapKMG.put("agent",params.get("agent"));
        Map<String,Object> mapCKG = new HashMap<String,Object>();
        mapCKG.put("airport","CKG");
        mapCKG.put("dept",params.get("dept"));
        mapCKG.put("agent",params.get("agent"));
        Map<String,Object> mapPVG = new HashMap<String,Object>();
        mapPVG.put("airport","PVG");
        mapPVG.put("dept",params.get("dept"));
        mapPVG.put("agent",params.get("agent"));
        Map<String,Object> mapHAK = new HashMap<String,Object>();
        mapHAK.put("airport","HAK");
        mapHAK.put("dept",params.get("dept"));
        mapHAK.put("agent",params.get("agent"));
        Map<String,Object> mapXMN = new HashMap<String,Object>();
        mapXMN.put("airport","XMN");
        mapXMN.put("dept",params.get("dept"));
        mapXMN.put("agent",params.get("agent"));
        Map<String,Object> mapURC = new HashMap<String,Object>();
        mapURC.put("airport","URC");
        mapURC.put("dept",params.get("dept"));
        mapURC.put("agent",params.get("agent"));
        Map<String,Object> mapHRB = new HashMap<String,Object>();
        mapHRB.put("airport","HRB");
        mapHRB.put("dept",params.get("dept"));
        mapHRB.put("agent",params.get("agent"));
        Map<String,Object> mapSHE = new HashMap<String,Object>();
        mapSHE.put("airport","SHE");
        mapSHE.put("dept",params.get("dept"));
        mapSHE.put("agent",params.get("agent"));
        Map<String,Object> mapDLC = new HashMap<String,Object>();
        mapDLC.put("airport","DLC");
        mapDLC.put("dept",params.get("dept"));
        mapDLC.put("agent",params.get("agent"));
        FltRlsIdxAptVo fltRlsIdxAptVo = new FltRlsIdxAptVo();
        fltRlsIdxAptVo.setPEK(new BigDecimal(fltRlsIdxMapper.getFltRlsIdxByApt(mapPEK)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxAptVo.setSHA(new BigDecimal(fltRlsIdxMapper.getFltRlsIdxByApt(mapSHA)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxAptVo.setCAN(new BigDecimal(fltRlsIdxMapper.getFltRlsIdxByApt(mapCAN)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxAptVo.setCTU(new BigDecimal(fltRlsIdxMapper.getFltRlsIdxByApt(mapCTU)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxAptVo.setKMG(new BigDecimal(fltRlsIdxMapper.getFltRlsIdxByApt(mapKMG)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxAptVo.setCKG(new BigDecimal(fltRlsIdxMapper.getFltRlsIdxByApt(mapCKG)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxAptVo.setPVG(new BigDecimal(fltRlsIdxMapper.getFltRlsIdxByApt(mapPVG)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxAptVo.setHAK(new BigDecimal(fltRlsIdxMapper.getFltRlsIdxByApt(mapHAK)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxAptVo.setXMN(new BigDecimal(fltRlsIdxMapper.getFltRlsIdxByApt(mapXMN)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxAptVo.setURC(new BigDecimal(fltRlsIdxMapper.getFltRlsIdxByApt(mapURC)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxAptVo.setHRB(new BigDecimal(fltRlsIdxMapper.getFltRlsIdxByApt(mapHRB)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxAptVo.setSHE(new BigDecimal(fltRlsIdxMapper.getFltRlsIdxByApt(mapSHE)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        fltRlsIdxAptVo.setDLC(new BigDecimal(fltRlsIdxMapper.getFltRlsIdxByApt(mapDLC)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        return fltRlsIdxAptVo;
    }

    @Override
    public FlightHandTerminalVo findFltJGS(@Param("params") Map params){
        return flightIndexMapper.findFltJGS(params);
    }
    @Override
    public FlightHandTerminalVo findFltCGS(@Param("params") Map params){
        return flightIndexMapper.findFltCGS(params);
    }
    @Override
    public FlightHandTerminalVo findFltCountByAttribute(@Param("params") Map params){
        return flightIndexMapper.findFltCountByAttribute(params);
    }

    @Override
    public FlightHandTerminalVo findFltCountByDorA(Map params) {

            String [] hours={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
            List<HBSPerHour> aJHSList1 = vForecastMapper.getplanFlightNum("D");
            List<HBSPerHour> aJHSList2 = vForecastMapper.getactualFlightNum("D");
            List<HBSPerHour> aJHSList3 = vForecastMapper.getquarantineNum("D");

            int [] countEOne=new int[hours.length];
            int [] countETwo=new int[hours.length];
            int [] countWOne=new int[hours.length];
            for (int i = 0; i <hours.length ; i++) {
                countEOne[i]=0;
                countETwo[i]=0;
                countWOne[i]=0;
            }

            for (int i = 0; i <hours.length ; i++) {
                for (int j = 0; j <aJHSList1.size() ; j++) {

                    if (hours[i].equals(aJHSList1.get(j).getTime_H())){
                        countEOne[i]=aJHSList1.get(j).getHBS();


                        break;
                    }
                }

                for (int j = 0; j <aJHSList2.size() ; j++) {

                    if (hours[i].equals(aJHSList2.get(j).getTime_H())){
                        countETwo[i]=aJHSList2.get(j).getHBS();

                        break;
                    }
                }

                for (int j = 0; j <aJHSList3.size() ; j++) {

                    if (hours[i].equals(aJHSList3.get(j).getTime_H())){
                        countWOne[i]=aJHSList3.get(j).getHBS();

                        break;
                    }
                }



            }
            int BoardingSum=0;
            int CheckinSum=0;
            int SecuritySum=0;

            for (int i = 0; i <hours.length ; i++) {
                BoardingSum+=countEOne[i];
                CheckinSum+=countETwo[i];
                SecuritySum+=countWOne[i];
            }
        FlightHandTerminalVo v=new FlightHandTerminalVo();
        v.setBjs(BoardingSum);
        v.setBkys(CheckinSum);
        v.setBsy(SecuritySum);
        return v;
    }

    @Override
    public FlightHandTerminalVo findFltToHandTerminal(@Param("params") Map params){
        FlightHandTerminalVo vo =  new FlightHandTerminalVo();
        FlightIndexVo flt = this.findFlightIndex(params);
        FltRlsIdxVo friVo = this.findFltRlsIdx(params);
        FlightHandTerminalVo htJgs = this.findFltJGS(params);
        FlightHandTerminalVo htCgs = this.findFltCGS(params);
        FlightHandTerminalVo htAttrib = this.findFltCountByAttribute(params);
        //组装数据
        vo.setZhbs(flt.getZHB());
        vo.setYjgs(htJgs.getYjgs());
        vo.setZjgs(htJgs.getZjgs());
        vo.setYcgs(htCgs.getYcgs());
        vo.setZcgs(htCgs.getZcgs());
        vo.setGjhbs(htAttrib.getGjhbs());
        vo.setGnhbs(htAttrib.getGnhbs());
        vo.setDqhbs(htAttrib.getDqhbs());
        vo.setHhhbs(htAttrib.getHhhbs());
        vo.setZcl(friVo.getZCL());
        vo.setFxl(friVo.getFXL());
        vo.setZcs(flt.getZCS());
        vo.setYws(flt.getYWS());
        vo.setQxs(flt.getQXS());
        vo.setFhs(flt.getFHSA()+flt.getFHSD());
        vo.setBjs(flt.getBJSA()+flt.getBJSD());
        vo.setSyjw(flt.getKYJW());
        return vo;
    }

}
