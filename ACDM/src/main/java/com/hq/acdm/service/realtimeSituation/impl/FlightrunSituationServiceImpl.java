package com.hq.acdm.service.realtimeSituation.impl;

import com.hq.acdm.dao.realtimeSituation.FlightrunSituationMapper;
import com.hq.acdm.dao.realtimeSituation.TSectionWtMapper;
import com.hq.acdm.model.realtimeSituation.TSectionWt;
import com.hq.acdm.service.realtimeSituation.FlightrunSituationService;
import com.hq.acdm.model.realtimeSituation.TRunwayMode;
import com.hq.acdm.vo.realtimeSituation.FlightIndexRunwayVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class FlightrunSituationServiceImpl implements FlightrunSituationService {

    @Resource
    private FlightrunSituationMapper flightrunSituationMapper;
    @Resource
    private TSectionWtMapper tSectionWtMapper;


    //获取跑道运行模式信息
    @Override
    public List<TRunwayMode> findRunwayModeInfo(Map params){
        return flightrunSituationMapper.findRunwayModeInfo(params);
    }
    @Override
    public int updateRunway(TRunwayMode recod) {
        return flightrunSituationMapper.updateRunway(recod);
    }

    @Override
    public int updateRunwayD(TRunwayMode recod) {
        return flightrunSituationMapper.updateRunwayD(recod);
    }

    @Override
    public int updateRunwayA(TRunwayMode recod) {
        return flightrunSituationMapper.updateRunwayA(recod);
    }

    @Override
    public FlightIndexRunwayVo findRunwayAllInfo() {
        return flightrunSituationMapper.findRunwayAllInfo();
    }

    @Override
    public int updateRunwayAllInfo(Map params) {
        return flightrunSituationMapper.updateRunwayAllInfo(params);
    }

    @Override
    public int insert(TSectionWt record) {
        return tSectionWtMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return tSectionWtMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(TSectionWt record) {
        return tSectionWtMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TSectionWt> selectAllTSectionWt() {
        return tSectionWtMapper.selectAllTSectionWt();
    }


}
