package com.hq.acdm.service.dynamicFlight.impl;

import com.hq.acdm.dao.dynamicFlight.FltSituationMapper;
import com.hq.acdm.dao.realtimeSituation.TDelayCoordinationMapper;
import com.hq.acdm.model.realtimeSituation.TDelayCoordination;
import com.hq.acdm.service.dynamicFlight.FltSituationService;
import com.hq.acdm.vo.dynamicFlight.*;
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
public class FltSituationServiceImpl implements FltSituationService {

    @Resource
    private FltSituationMapper fltSituationMapper;

    @Resource
    private TDelayCoordinationMapper tDelayCoordinationMapper;

    @Override
    public List<CriticalFltAVo> findCriticalFltA() {
        return fltSituationMapper.getCriticalFltA();
    }

    @Override
    public List<CriticalFltRlsVo> findCriticalFltRls(Map param) {
        return fltSituationMapper.getCriticalFltRls(param);
    }

    @Override
    public List<CriticalFltRlsVo> findCriticalFltRlsOpen(Map params) {
        return fltSituationMapper.getCriticalFltRlsOpen(params);
    }


    @Override
    public List<CriticalFltRlsVo> findCriticalFltIWt(Map param) {
        return fltSituationMapper.getCriticalFltIWt(param);
    }

    @Override
    public List<CriticalFltDVo> findCriticalFltD() {
        return fltSituationMapper.getCriticalFltD();
    }

    //航班关注
    @Override
    public int updateFlightFocus(@Param("params") Map params){
        return fltSituationMapper.updateFlightFocus(params);
    }

    @Override
    public List<FltSchedulingVo> findFltSchedulingByTime(){ return fltSituationMapper.getFltSchedulingByTime();}

    @Override
    public List<FltSchedulingVo> findFltScheduling() {
        List<FltSchedulingVo> returnList = new ArrayList<FltSchedulingVo>();
        List<FltSchedulingVo> listByTime = this.findFltSchedulingByTime();
        List<FltSchedulingVo> list = fltSituationMapper.getFltScheduling();
        if(listByTime != null && listByTime.size() > 0){
            for(int i=0;i<list.size();i++){
                FltSchedulingVo vo = list.get(i);
                String t = vo.getTime();
                for(int j=0;j<listByTime.size();j++){
                    FltSchedulingVo voByTime = listByTime.get(j);
                    String time = voByTime.getTime();
                    if(t!= null && t.equals(time)){
                        vo.setFltIdD(voByTime.getFltId());
                    }
                }
                returnList.add(vo);
            }
        }else{
            returnList = list;
        }
        return  returnList;
    }

    @Override
    public List<FltTimeAxisVo> findFltTimeAxis(@Param("params") Map params) {
        return fltSituationMapper.getFltTimeAxis(params);
    }

    @Override
    public List<ControlInfoVo> findControlId(Map params) {
        return fltSituationMapper.findControlId(params);
    }

    @Override
    public int updateTimeAxis(@Param("params") Map params) {
        return fltSituationMapper.updateTimeAxis(params);
    }

    @Override
    public List<FltTimeAxisVo> findFltTimeAxisTobt(Map params) {
        return fltSituationMapper.getFltTimeAxisTobt(params);
    }

    @Override
    public TCoordinatedDisposal selectByFlid(String id) {
        return fltSituationMapper.selectByFlid(id);
    }

    @Override
    public int insertCDSelective(TCoordinatedDisposal record) {
        return fltSituationMapper.insertCDSelective(record);
    }

    @Override
    public int updateCDByPrimaryKeySelective(TCoordinatedDisposal record) {
        return fltSituationMapper.updateCDByPrimaryKeySelective(record);
    }

    //小延误协调
    @Override
    public List<DelayCoordinationVo> findDelayCoordinationInfo(@Param("params") Map params){
        return fltSituationMapper.getDelayCoordinationInfo(params);
    }
    //协调完成（以前方法TOBT大于COBT）
    @Override
    public List<DelayCoordinationVo> findTobtToCobtInfo(@Param("params") Map params){
        return fltSituationMapper.getTobtToCobtInfo(params);
    }

    //小延误协调数据查询
    public List<TDelayCoordination> selectDelayCoordinationInfo(@Param("params") Map params){
        return fltSituationMapper.findDelayCoordinationInfo(params);
    }

    //保存小延误协调数据
    public int insertTDelayCoordination(@Param("params")TDelayCoordination model){
        return tDelayCoordinationMapper.insert(model);
    }

    @Override
    public List<TDelayCoordination> selectByFlightId(String flightId) {
        return tDelayCoordinationMapper.selectByFlightId(flightId);
    }

    @Override
    public String findIsCoordination(String flightId) {
        String state = tDelayCoordinationMapper.getIsCoordination(flightId);
        if (null!=state){
            return state;
        }
        return "0";
    }

    @Override
    public String findFlightTm(String flightId) {
        return tDelayCoordinationMapper.getFlightTm(flightId);
    }

    @Override
    public int updateTDelayCoordinationState(Map params) {
        return tDelayCoordinationMapper.updateTDelayCoordinationState(params);
    }

    @Override
    public List<CoordinationDelayCountVo> findCoordinationDelayCountInfo(Map params) {
        return fltSituationMapper.findCoordinationDelayCountInfo(params);
    }

    @Override
    public int updateTDelayCoordinationContent(Map params) {
        return fltSituationMapper.updateTDelayCoordinationContent(params);
    }
}
