package com.hq.acdm.service.rscMonitors.impl;

import com.hq.acdm.dao.dynamicFlight.FltSearchMapper;
import com.hq.acdm.dao.rscMonitors.DeicingSupervisionMapper;
import com.hq.acdm.model.realtimeSituation.TSchedulingNoticeInfo;
import com.hq.acdm.service.rscMonitors.DeicingSupervisionService;
import com.hq.acdm.service.rscMonitors.RealtimeStandService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.util.mqadapter.MqUtil;
import com.hq.acdm.vo.dynamicFlight.FlightInfoVo;
import com.hq.acdm.vo.dynamicFlight.ServicedefineVo;
import com.hq.acdm.vo.rscMonitors.*;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/04/28 16:23
 * @Description
 */
@Service
public class DeicingSupervisionServiceImpl implements DeicingSupervisionService {
    @Resource
    private DeicingSupervisionMapper deicingSupervisionMapper;
    @Resource
    private FltSearchMapper fltSearchMapper;


    @Override
    public List<DeicingWaitVo> findDeicingWait() {
        return deicingSupervisionMapper.findDeicingWait();
    }

    @Override
    public List<DeicingNowVo> findDeicingNow() {
        return deicingSupervisionMapper.findDeicingNow();
    }

    @Override
    public List<DeicingOverVo> findDeicingOver() {
        return deicingSupervisionMapper.findDeicingOver();
    }

    @Override
    public List<DeicingInfoVo> findDeicingInfo() {
        return deicingSupervisionMapper.findDeicingInfo();
    }

    /**
     * 修改航班是否需要除冰时发送给智航
     * @param flag
     * @param flightId
     * @return
     */
    @Override
    public int updateDeicingFlt(String userId, String flag, String flightId) {
        Date now = new Date();
        String nowStr = DateTimeUtil.dateToStr(now).substring(0,16);
        String msg = ""+nowStr+" 发布除冰任务";
        //以下Json消息通过MQ发送到地服
        String isSend="";
        if ("1".equals(flag)){
            Map<String, Object> queryMap = new HashMap<>();
            queryMap.put("flightId",flightId);
            deicingSupervisionMapper.updateECDTEEDT(queryMap);
        }
        try {
            ServicedefineVo v=new ServicedefineVo();
            String flno = fltSearchMapper.findFLNOByID(flightId);
            v.setSender(userId);
            v.setFlightId(flightId+"");
            if (null!=flno&&!"".equals(flno)){
                v.setFlno(flno);
            }
            if ("0".equals(flag)){
                v.setNodeCode("CBQX");
            }else{
                v.setNodeCode("CB");
            }
            if (StringUtil.isNotEmpty(v.getNodeCode())){
                JSONObject J=  new JSONObject(v);
                boolean label= MqUtil.splitToListInt(J.toString());
                if (label){
                    isSend="消息发送成功";
                }else {
                    isSend="消息发送失败";
                }

            }else {
                isSend="没有对应调度信息";
            }

        }catch (Exception e){
            isSend="消息配置信息有误，请联系管理员";
        }
        return deicingSupervisionMapper.updDeicingFlt(flag,flightId);
    }

    @Override
    public int updateDeicingBit(String number) {
        return deicingSupervisionMapper.updateDeicingBit(number);
    }

    @Override
    public int updateDeicingCar(String number) {
        return deicingSupervisionMapper.updateDeicingCar(number);
    }

    @Override
    public List<DeicingEChartVo> findDeicingEChartInfo() {
        return deicingSupervisionMapper.findDeicingEChartInfo();
    }

    @Override
    public String[] findDeicingEChartData() {
        List<DeicingEChartVo> list = this.findDeicingEChartInfo();
        String []hbs = new String[]{"0","0","0","0","0","0","0","0","0","0","0"
                ,"0","0","0","0","0","0","0","0","0","0","0","0","0",};
        if(list != null && list.size()>0){
            for(int i=0;i<list.size();i++){
                if("00".equals(list.get(i).getTimeH())){
                    hbs[0] = list.get(i).getHbs();
                }
                if("01".equals(list.get(i).getTimeH())){
                    hbs[1] = list.get(i).getHbs();
                }
                if("02".equals(list.get(i).getTimeH())){
                    hbs[2] = list.get(i).getHbs();
                }
                if("03".equals(list.get(i).getTimeH())){
                    hbs[3] = list.get(i).getHbs();
                }
                if("04".equals(list.get(i).getTimeH())){
                    hbs[4] = list.get(i).getHbs();
                }
                if("05".equals(list.get(i).getTimeH())){
                    hbs[5] = list.get(i).getHbs();
                }
                if("06".equals(list.get(i).getTimeH())){
                    hbs[6] = list.get(i).getHbs();
                }
                if("07".equals(list.get(i).getTimeH())){
                    hbs[7] = list.get(i).getHbs();
                }
                if("08".equals(list.get(i).getTimeH())){
                    hbs[8] = list.get(i).getHbs();
                }
                if("09".equals(list.get(i).getTimeH())){
                    hbs[9] = list.get(i).getHbs();
                }
                if("10".equals(list.get(i).getTimeH())){
                    hbs[10] = list.get(i).getHbs();
                }
                if("11".equals(list.get(i).getTimeH())){
                    hbs[11] = list.get(i).getHbs();
                }
                if("12".equals(list.get(i).getTimeH())){
                    hbs[12] = list.get(i).getHbs();
                }
                if("13".equals(list.get(i).getTimeH())){
                    hbs[13] = list.get(i).getHbs();
                }
                if("14".equals(list.get(i).getTimeH())){
                    hbs[14] = list.get(i).getHbs();
                }
                if("15".equals(list.get(i).getTimeH())){
                    hbs[15] = list.get(i).getHbs();
                }
                if("16".equals(list.get(i).getTimeH())){
                    hbs[16] = list.get(i).getHbs();
                }
                if("17".equals(list.get(i).getTimeH())){
                    hbs[17] = list.get(i).getHbs();
                }
                if("18".equals(list.get(i).getTimeH())){
                    hbs[18] = list.get(i).getHbs();
                }
                if("19".equals(list.get(i).getTimeH())){
                    hbs[19] = list.get(i).getHbs();
                }
                if("20".equals(list.get(i).getTimeH())){
                    hbs[20] = list.get(i).getHbs();
                }
                if("21".equals(list.get(i).getTimeH())){
                    hbs[21] = list.get(i).getHbs();
                }
                if("22".equals(list.get(i).getTimeH())){
                    hbs[22] = list.get(i).getHbs();
                }
                if("23".equals(list.get(i).getTimeH())){
                    hbs[23] = list.get(i).getHbs();
                }
            }

        }
        return hbs;
    }

    @Override
    public int updateDeicingResourcesData(Map params) {
        return deicingSupervisionMapper.updateDeicingResourcesData(params);
    }

    @Override
    public int findDeicingUseCar() {
        return deicingSupervisionMapper.findDeicingUseCar();
    }

    @Override
    public DeicingRunwayVo findDeicingRunwayData(Map params) {
        return deicingSupervisionMapper.findDeicingRunwayData(params);
    }

    @Override
    public int updateDeicingRunwayData(Map params) {
        return deicingSupervisionMapper.updateDeicingRunwayData(params);
    }

    @Override
    public int insertDeicingRunwayData(Map params) {
        return deicingSupervisionMapper.insertDeicingRunwayData(params);
    }

    @Override
    public int updateDeicingFluidByFlightId(Map params) {
        return deicingSupervisionMapper.updateDeicingFluidByFlightId(params);
    }

    @Override
    public int insertDeicingFluidByFlightId(Map params) {
        return deicingSupervisionMapper.insertDeicingFluidByFlightId(params);
    }

    @Override
    public DeicingFluidVo selectDeicingFluidByFlightId(Map params) {
        return deicingSupervisionMapper.selectDeicingFluidByFlightId(params);
    }

    @Override
    public List<DeicingCarVo> selectDeicingCarInfo() {
        return deicingSupervisionMapper.selectDeicingCarInfo();
    }

    @Override
    public List<TVehicleTracksVo> selectTVehicleTracksInfo(Map params) {
        return deicingSupervisionMapper.selectTVehicleTracksInfo(params);
    }

    @Override
    public List<TVehicleTracksVo> findLatelyVehicleTracks(Map params) {
        return deicingSupervisionMapper.findLatelyVehicleTracks(params);
    }

    @Override
    public List<TVehicleTracksVo> selectTVehicleTracksInfoGroupBy3(Map params) {
        return deicingSupervisionMapper.selectTVehicleTracksInfoGroupBy3(params);
    }

    @Override
    public DeicingResourcesVo findDeicingResourcesData() {
        int number = this.findDeicingUseCar();
        Map<String,Object> queryMap = new HashMap<String,Object>();
        queryMap.put("number",number);
        this.updateDeicingResourcesData(queryMap);
        return deicingSupervisionMapper.findDeicingResourcesData();
    }
}
