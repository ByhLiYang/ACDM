package com.hq.acdm.service.rscMonitors.impl;

import com.hq.acdm.dao.rscMonitors.RealtimeStandMapper;
import com.hq.acdm.service.rscMonitors.RealtimeStandService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.rscMonitors.BaseStand;
import com.hq.acdm.vo.rscMonitors.StandStatusVo;
import com.hq.acdm.vo.rscMonitors.StandVo;
import com.hq.acdm.vo.rscMonitors.StandVo2;
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
public class RealtimeStandServiceImpl implements RealtimeStandService {
    @Resource
    private RealtimeStandMapper realtimeStandMapper;

    @Override
    public List<StandStatusVo> findStandInfo() {
        List<StandVo2> standVos = realtimeStandMapper.getStandInfo2();
        Map<String,List<StandVo2>> map =  new HashMap<>();
        String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//      将当前以占用或未来即将占用的机位数据，以机位为key放入map集合
        for (int i = 0; i < standVos.size(); i++) {
//           预计占用2小时外的不考虑
            if (DateTimeUtil.compareStr(standVos.get(i).getEit(),DateTimeUtil.addDateMinut(datetime,1))){
                if (map.containsKey(standVos.get(i).getStand())) {
                    boolean flag =true;
    //              遍历过滤重复记录，同机位2条记录的实际占用时间与预计占用时间相等，视为重复记录
                    for (int j = 0; j < map.get(standVos.get(i).getStand()).size(); j++) {
    //                  同机位，存在实际占用时间等于map记录中的预计占用时间，替换map中的记录
                        if (null!=standVos.get(i).getAit()&&standVos.get(i).getAit().equals(map.get(standVos.get(i).getStand()).get(j).getEit())) {
                            flag=false;
                            map.get(standVos.get(i).getStand()).set(j,standVos.get(i));
    //                  同机位，存在预计占用时间等于map记录中的实际占用时间，丢弃该条数据
                        }else if (null!=map.get(standVos.get(i).getStand()).get(j).getAit()&&map.get(standVos.get(i).getStand()).get(j).getAit().equals(standVos.get(i).getEit())) {
                            flag=false;
                        }
    //                  同机位，存在重复记录没有实际时间，以进港航班ID判断
                        if (null!=standVos.get(i).getFltIdA()&&standVos.get(i).getFltIdA().equals(map.get(standVos.get(i).getStand()).get(j).getFltIdA())) {
                            flag=false;
    //                        取预计占用时间小的
                            if (DateTimeUtil.compareStr(standVos.get(i).getEit(),map.get(standVos.get(i).getStand()).get(j).getEit())){
                                map.get(standVos.get(i).getStand()).set(j,standVos.get(i));
                            }
                        }
                    }
                    if (flag){
                        map.get(standVos.get(i).getStand()).add(standVos.get(i));
                    }
                } else {
                    List<StandVo2> temps = new ArrayList<>();
                    temps.add(standVos.get(i));
                    map.put(standVos.get(i).getStand(), temps);
                }
            }
        }
        List<StandStatusVo> ssvs = new ArrayList<>();
//        遍历出占用机位
        for(String standNo : map.keySet()) {
            StandStatusVo ssv = new StandStatusVo();
            List<String> flightIdAList = new ArrayList<>();
            List<String> flightIdDList = new ArrayList<>();
            List<String> fltNoAList = new ArrayList<>();
            List<String> fltNoDList = new ArrayList<>();
            List<String> startTimeList = new ArrayList<>();
            List<String> endTimeList = new ArrayList<>();
            for (int i = 0; i < map.get(standNo).size(); i++) {
//                预计占用时间小于当前时间
                if (DateTimeUtil.compareStr(map.get(standNo).get(i).getEit(),datetime)){
//                    预计释放在4小时内（包括小于当前时间的），为即将出港
                    if (DateTimeUtil.compareStr(map.get(standNo).get(i).getEot(),DateTimeUtil.addDateMinut(datetime,1))){
                        ssv.setStatus("3");
                    }else{
                        ssv.setStatus("1");
                    }
                    ssv.setFlnoA(null==map.get(standNo).get(i).getFltNoA()?"":map.get(standNo).get(i).getFltNoA());
                    ssv.setFlnoD(null==map.get(standNo).get(i).getFltNoD()?"":map.get(standNo).get(i).getFltNoD());
                    ssv.setStand(standNo);
                    flightIdAList.add(null==map.get(standNo).get(i).getFltIdA()?"":map.get(standNo).get(i).getFltIdA());
                    flightIdDList.add(null==map.get(standNo).get(i).getFltIdD()?"":map.get(standNo).get(i).getFltIdD());
                    fltNoAList.add(null==map.get(standNo).get(i).getFltNoA()?"":map.get(standNo).get(i).getFltNoA());
                    fltNoDList.add(null==map.get(standNo).get(i).getFltNoD()?"":map.get(standNo).get(i).getFltNoD());
                    startTimeList.add(null==map.get(standNo).get(i).getEit()?"":map.get(standNo).get(i).getEit());
//                   如果AOT不为空，取AOT为预计释放时间
//                   EOT，计划释放时间，AOT,实时更新的预计释放时间
                    if (StringUtil.isNotEmpty(map.get(standNo).get(i).getAot())){
                        endTimeList.add(null==map.get(standNo).get(i).getAot()?"":map.get(standNo).get(i).getAot());
                    }else{
                        endTimeList.add(null==map.get(standNo).get(i).getEot()?"":map.get(standNo).get(i).getEot());
                    }

                }
            }
            ssv.setFlightIdAList(flightIdAList);
            ssv.setFlightIdDList(flightIdDList);
            ssv.setFltNoAList(fltNoAList);
            ssv.setFltNoDList(fltNoDList);
            ssv.setStartTimeList(startTimeList);
            ssv.setEndTimeList(endTimeList);
            if (null!=ssv.getStand()) {
                ssvs.add(ssv);
            }
        }
//        遍历冲突机位
        for (int i = 0; i < ssvs.size(); i++) {
            for (int j = 0; j < map.get(ssvs.get(i).getStand()).size(); j++) {
//                存在机位预计占用时间，在第一条预计释放时间之前的，视为冲突
                if (DateTimeUtil.compareStr(datetime,map.get(ssvs.get(i).getStand()).get(j).getEit())
                        &&DateTimeUtil.compareStr(map.get(ssvs.get(i).getStand()).get(j).getEit(),ssvs.get(i).getEndTimeList().get(0))){
                    ssvs.get(i).setStatus("2");
                    ssvs.get(i).getFlightIdAList().add(null==map.get(ssvs.get(i).getStand()).get(j).getFltIdA()?"":map.get(ssvs.get(i).getStand()).get(j).getFltIdA());
                    ssvs.get(i).getFlightIdDList().add(null==map.get(ssvs.get(i).getStand()).get(j).getFltIdD()?"":map.get(ssvs.get(i).getStand()).get(j).getFltIdD());
                    ssvs.get(i).getFltNoAList().add(null==map.get(ssvs.get(i).getStand()).get(j).getFltNoA()?"":map.get(ssvs.get(i).getStand()).get(j).getFltNoA());
                    ssvs.get(i).getFltNoDList().add(null==map.get(ssvs.get(i).getStand()).get(j).getFltNoD()?"":map.get(ssvs.get(i).getStand()).get(j).getFltNoD());
                    ssvs.get(i).getStartTimeList().add(null==map.get(ssvs.get(i).getStand()).get(j).getEit()?"":map.get(ssvs.get(i).getStand()).get(j).getEit());
                    ssvs.get(i).getEndTimeList().add(null==map.get(ssvs.get(i).getStand()).get(j).getEot()?"":map.get(ssvs.get(i).getStand()).get(j).getEot());
                }
            }

        }
//        遍历出即将进港机位
        for(String standNo : map.keySet()) {
            boolean flag = true;
            for (int i = 0; i < ssvs.size(); i++) {
                if (standNo.equals(ssvs.get(i).getStand())){
                    flag = false;
                }
            }
//          无占用记录的，为空闲即将占用
            if (flag){
                StandStatusVo ssv = new StandStatusVo();
                List<String> flightIdAList = new ArrayList<>();
                List<String> flightIdDList = new ArrayList<>();
                List<String> fltNoAList = new ArrayList<>();
                List<String> fltNoDList = new ArrayList<>();
                List<String> startTimeList = new ArrayList<>();
                List<String> endTimeList = new ArrayList<>();
//                取第一条预计占用
                for (int i = 0; i < map.get(standNo).size()&&DateTimeUtil.compareStr(datetime,map.get(standNo).get(i).getEit()); i++) {
                    ssv.setStatus("0");
                    ssv.setStand(standNo);
                    if (startTimeList.size() > 0 && endTimeList.size() > 0) {
                        if (DateTimeUtil.compareStr(map.get(standNo).get(i).getEit(), startTimeList.get(0))) {
                            ssv.setFlnoA(null==map.get(standNo).get(i).getFltNoA()?"":map.get(standNo).get(i).getFltNoA());
                            ssv.setFlnoD(null==map.get(standNo).get(i).getFltNoD()?"":map.get(standNo).get(i).getFltNoD());
                            flightIdAList.set(0,null==map.get(standNo).get(i).getFltIdA()?"":map.get(standNo).get(i).getFltIdA());
                            flightIdDList.set(0,null==map.get(standNo).get(i).getFltIdD()?"":map.get(standNo).get(i).getFltIdD());
                            fltNoAList.set(0,null==map.get(standNo).get(i).getFltNoA()?"":map.get(standNo).get(i).getFltNoA());
                            fltNoDList.set(0,null==map.get(standNo).get(i).getFltNoD()?"":map.get(standNo).get(i).getFltNoD());
                            startTimeList.set(0,null==map.get(standNo).get(i).getEit()?"":map.get(standNo).get(i).getEit());
                            endTimeList.set(0,null==map.get(standNo).get(i).getEot()?"":map.get(standNo).get(i).getEot());
                        }
                    }else{
                        ssv.setFlnoA(null==map.get(standNo).get(i).getFltNoA()?"":map.get(standNo).get(i).getFltNoA());
                        ssv.setFlnoD(null==map.get(standNo).get(i).getFltNoD()?"":map.get(standNo).get(i).getFltNoD());
                        flightIdAList.add(null==map.get(standNo).get(i).getFltIdA()?"":map.get(standNo).get(i).getFltIdA());
                        flightIdDList.add(null==map.get(standNo).get(i).getFltIdD()?"":map.get(standNo).get(i).getFltIdD());
                        fltNoAList.add(null==map.get(standNo).get(i).getFltNoA()?"":map.get(standNo).get(i).getFltNoA());
                        fltNoDList.add(null==map.get(standNo).get(i).getFltNoD()?"":map.get(standNo).get(i).getFltNoD());
                        startTimeList.add(null==map.get(standNo).get(i).getEit()?"":map.get(standNo).get(i).getEit());
                        endTimeList.add(null==map.get(standNo).get(i).getEot()?"":map.get(standNo).get(i).getEot());
                    }
                }
                ssv.setFlightIdAList(flightIdAList);
                ssv.setFlightIdDList(flightIdDList);
                ssv.setFltNoAList(fltNoAList);
                ssv.setFltNoDList(fltNoDList);
                ssv.setStartTimeList(startTimeList);
                ssv.setEndTimeList(endTimeList);
                if (null!=ssv.getStand()) {
                    ssvs.add(ssv);
                }
            }
        }
//      机位状态为空闲时取第二条预计占用记录，其他取第一条预计占用记录
        for (int i = 0; i < ssvs.size(); i++) {
            if (!"2".equals(ssvs.get(i).getStatus())){
            int size = ssvs.get(i).getStartTimeList().size();
//           预计时间大于当前时间，并且预计时间大于第一条记录的预计时间时，取最小值记录
            for (int j = 0; j < map.get(ssvs.get(i).getStand()).size(); j++) {
                if (DateTimeUtil.compareStr(ssvs.get(i).getStartTimeList().get(0), map.get(ssvs.get(i).getStand()).get(j).getEit())
                        &&DateTimeUtil.compareStr(datetime, map.get(ssvs.get(i).getStand()).get(j).getEit())) {
//               取一条记录后修改
                    if (ssvs.get(i).getStartTimeList().size() > size) {
//                    比较获取最小值记录
                        if (DateTimeUtil.compareStr(map.get(ssvs.get(i).getStand()).get(j).getEit(), ssvs.get(i).getStartTimeList().get(ssvs.get(i).getStartTimeList().size() - 1))) {
                            ssvs.get(i).getFlightIdAList().set(ssvs.get(i).getStartTimeList().size() - 1, null==map.get(ssvs.get(i).getStand()).get(j).getFltIdA()?"":map.get(ssvs.get(i).getStand()).get(j).getFltIdA());
                            ssvs.get(i).getFlightIdDList().set(ssvs.get(i).getStartTimeList().size() - 1, null==map.get(ssvs.get(i).getStand()).get(j).getFltIdD()?"":map.get(ssvs.get(i).getStand()).get(j).getFltIdD());
                            ssvs.get(i).getFltNoAList().set(ssvs.get(i).getStartTimeList().size() - 1, null==map.get(ssvs.get(i).getStand()).get(j).getFltNoA()?"":map.get(ssvs.get(i).getStand()).get(j).getFltNoA());
                            ssvs.get(i).getFltNoDList().set(ssvs.get(i).getStartTimeList().size() - 1, null==map.get(ssvs.get(i).getStand()).get(j).getFltNoD()?"":map.get(ssvs.get(i).getStand()).get(j).getFltNoD());
                            ssvs.get(i).getStartTimeList().set(ssvs.get(i).getStartTimeList().size() - 1, null==map.get(ssvs.get(i).getStand()).get(j).getEit()?"":map.get(ssvs.get(i).getStand()).get(j).getEit());
                            ssvs.get(i).getEndTimeList().set(ssvs.get(i).getStartTimeList().size() - 1, null==map.get(ssvs.get(i).getStand()).get(j).getEot()?"":map.get(ssvs.get(i).getStand()).get(j).getEot());
                        }
                    } else {
                        ssvs.get(i).getFlightIdAList().add(null==map.get(ssvs.get(i).getStand()).get(j).getFltIdA()?"":map.get(ssvs.get(i).getStand()).get(j).getFltIdA());
                        ssvs.get(i).getFlightIdDList().add(null==map.get(ssvs.get(i).getStand()).get(j).getFltIdD()?"":map.get(ssvs.get(i).getStand()).get(j).getFltIdD());
                        ssvs.get(i).getFltNoAList().add(null==map.get(ssvs.get(i).getStand()).get(j).getFltNoA()?"":map.get(ssvs.get(i).getStand()).get(j).getFltNoA());
                        ssvs.get(i).getFltNoDList().add(null==map.get(ssvs.get(i).getStand()).get(j).getFltNoD()?"":map.get(ssvs.get(i).getStand()).get(j).getFltNoD());
                        ssvs.get(i).getStartTimeList().add(null==map.get(ssvs.get(i).getStand()).get(j).getEit()?"":map.get(ssvs.get(i).getStand()).get(j).getEit());
                        ssvs.get(i).getEndTimeList().add(null==map.get(ssvs.get(i).getStand()).get(j).getEot()?"":map.get(ssvs.get(i).getStand()).get(j).getEot());
                    }
                }
            }
            }
        }
        return ssvs;
    }

    @Override
    public int findJWZS() {
        return realtimeStandMapper.getJWZS();
    }

    @Override
    public int findBKYS() {
        return realtimeStandMapper.getBKYS();
    }

    @Override
    public int findJRTC() {
        return realtimeStandMapper.getJRTC();
    }

    @Override
    public int findGYHB() {
        return realtimeStandMapper.getGYHB();
    }

    @Override
    public List<BaseStand> findBaseStand() {
        return realtimeStandMapper.getBaseStand();
    }

    @Override
    public int findJJWZS() {
        return 0;
    }

    @Override
    public int findYJWZS() {
        return 0;
    }

}
