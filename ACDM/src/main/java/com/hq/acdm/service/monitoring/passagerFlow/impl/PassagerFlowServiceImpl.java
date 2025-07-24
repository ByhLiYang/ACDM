package com.hq.acdm.service.monitoring.passagerFlow.impl;

import com.google.common.collect.Lists;
import com.hq.acdm.dao.index.VForecastMapper;
import com.hq.acdm.model.monitoring.passager.PassagerFlow;
import com.hq.acdm.service.monitoring.passagerFlow.PassagerFlowService;
import com.hq.acdm.vo.index.FlightNumVo;
import com.hq.acdm.vo.realtimeSituation.HBSPerHour;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("PassagerFlowService")
public class PassagerFlowServiceImpl implements PassagerFlowService {
    @Resource
    private com.hq.acdm.dao.monitioring.PassagerFlowMapper passagerFlowMapper;
    @Resource
    private VForecastMapper vForecastMapper;

    @Override
    public List<PassagerFlow> queryAirCompanyPassager(Map params) {
        System.out.println("------------SmallDelayServiceImpl-----------------");
        List<PassagerFlow> list = passagerFlowMapper.queryAirCompanyPassager(params);
        System.out.println(list);
        return list;
    }

    @Override
    public List<PassagerFlow> queryTerminalPassager(Map params) {
        System.out.println("------------SmallDelayServiceImpl-----------------");
        List<PassagerFlow> list = passagerFlowMapper.queryTerminalPassager(params);
        System.out.println(list);
        return list;
    }

    @Override
    public List<PassagerFlow> queryHourPassager(Map params) {
        System.out.println("------------SmallDelayServiceImpl-----------------");
     //   List<PassagerFlow> list = passagerFlowMapper.queryHourPassager(params);
////        System.out.println(list);
        List<PassagerFlow> list=new ArrayList<PassagerFlow>();
        String [] hours={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
            List<HBSPerHour> aJHSList1 = vForecastMapper.getplanFlightNum("D");
            List<HBSPerHour> aJHSList2 = vForecastMapper.getactualFlightNum("D");
            List<HBSPerHour> aJHSList3 = vForecastMapper.getquarantineNum("D");
            FlightNumVo vo = new FlightNumVo();
            List<Integer> planFlightNum= Lists.newArrayList();
            List<Integer> actualFlightNum= Lists.newArrayList();
            List<Integer> quarantineNum= Lists.newArrayList();
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
            for (int i = 0; i <hours.length ; i++) {
                PassagerFlow PassagerFlow = new PassagerFlow();
                PassagerFlow.setBoarding((short)countEOne[i]);
                PassagerFlow.setCheckin((short)countETwo[i]);
                PassagerFlow.setSecurity((short) countWOne[i]);
                list.add(PassagerFlow);
            }

            //return vo;

        return list;
    }

}
