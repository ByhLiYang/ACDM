package com.hq.acdm.service.statistics.optimize.impl;

import com.hq.acdm.dao.statistics.OptimizeMapper;
import com.hq.acdm.dao.timer.DailyRunWay.DailyRunWayMapper;
import com.hq.acdm.model.statistics.optimize.optimizeModel;
import com.hq.acdm.model.timer.DailyRunWay.DailyRunWay;
import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightMaster;
import com.hq.acdm.service.statistics.optimize.OptimizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/12/3 0003 15:04
 */
@Service("OptimizeService")
public class OptimizeServiceImpl implements OptimizeService {
    @Resource
    private OptimizeMapper optimizeMapper;
    @Resource
    private DailyRunWayMapper dailyRunWayMapper;
    @Override
    public Map<String,Object> queryByTime() throws ParseException {
        List<optimizeModel> listD = new ArrayList<>();
        List<optimizeModel> listA = new ArrayList<>();
        List<optimizeModel> listD_Modify = new ArrayList<>();
        List<optimizeModel> listA_Modify = new ArrayList<>();
        listD = optimizeMapper.queryD();
        listA = optimizeMapper.queryA();
        String startD = "";
        String endD  = "";
        String startA = "";
        String endA  = "";
        if(listD.size()>0){
            startD = listD.get(0).getCOBT();
            endD  = listD.get(listD.size()-1).getCOBT();
        }
        if(listA.size()>0){
            startA = listA.get(0).getELDT();
            endA = listA.get(listA.size()-1).getELDT();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDDate = simpleDateFormat.parse(startD);
        Date endDDate = simpleDateFormat.parse(endD);
        Date startADate = simpleDateFormat.parse(startA);
        Date endADate = simpleDateFormat.parse(endA);
        long gapD = endDDate.getTime()-startDDate.getTime();
        long minuteD = gapD/1000/60;
        long gapA = endADate.getTime()-startADate.getTime();
        long minuteA = gapA/1000/60;
        int indexMinuteD = (int) (minuteD/15);
        int restMinuteD = (int) (minuteD%15);
        int indexMinuteA = (int) (minuteA/15);
        int restMinuteA = (int) (minuteA%15);
        Set<String> setD = new TreeSet<>();
        Set<String> setA = new TreeSet<>();
        for(int i=0;i<indexMinuteD+1;i++){
            setD.add(simpleDateFormat.format(startDDate.getTime()+i*15*60*1000));
        }
        for(int i=0;i<indexMinuteA+1;i++){
            setA.add(simpleDateFormat.format(startADate.getTime()+i*15*60*1000));
        }

        Map<String,List<optimizeModel>> mapD = new TreeMap<>();
        Map<String,List<optimizeModel>> mapA = new TreeMap<>();
        Map<String,List<optimizeModel>> ListD = new HashMap<>();
        Map<String,List<optimizeModel>> ListA = new HashMap<>();
        List<String> mapKeyD = new ArrayList<>();
        List<String> mapKeyA = new ArrayList<>();
        Map<String,Object> mapTotal =  new HashMap<>();
        for(String key:setD){
            List<optimizeModel> list = new ArrayList<>();
            mapD.put(key,list);
            mapKeyD.add(key);
        }
        for(String key:setA){
            List<optimizeModel> list = new ArrayList<>();
            mapA.put(key,list);
            mapKeyA.add(key);
        }
        for(String key:setD){
            for(optimizeModel model:listD){
                if((simpleDateFormat.parse(model.getCOBT()).getTime()-simpleDateFormat.parse(key).getTime())<15*60*1000
                        &&(simpleDateFormat.parse(model.getCOBT()).getTime()-simpleDateFormat.parse(key).getTime())>=0){
                    List<optimizeModel> list = mapD.get(key);
                    list.add(model);
                    mapD.put(key,list);
                }
            }
        }
        for(String key:setA){
            for(optimizeModel model:listA){
                if((simpleDateFormat.parse(model.getELDT()).getTime()-simpleDateFormat.parse(key).getTime())<15*60*1000
                        &&(simpleDateFormat.parse(model.getELDT()).getTime()-simpleDateFormat.parse(key).getTime())>=0){
                    List<optimizeModel> list = mapA.get(key);
                    list.add(model);
                    mapA.put(key,list);
                }
            }
        }
        List<DailyRunWay> dailyRunWayList = dailyRunWayMapper.queryLastest();
        for(DailyRunWay dailyRunWay:dailyRunWayList){
            if (dailyRunWay.getA_OR_D().equals("A")){
                mapTotal.put("A",dailyRunWay.getRWY());
            }else {
                mapTotal.put("D",dailyRunWay.getRWY());
            }
        }
        for(optimizeModel model:listD){
            if(!"".equals(model.getCOBT()) && model.getCOBT()!=null){
                listD_Modify.add(model);
            }
        }
        for(optimizeModel model:listA){
            if(!"".equals(model.getCOBT()) && model.getCOBT()!=null){
                listA_Modify.add(model);
            }
        }
        ListD.put("D",listD_Modify);
        ListA.put("A",listA_Modify);
        mapTotal.put("timed",mapKeyD);
        mapTotal.put("timea",mapKeyA);
        mapTotal.put("datad",mapD);
        mapTotal.put("dataa",mapA);
        mapTotal.put("listd",ListD);
        mapTotal.put("lista",ListA);
        return mapTotal;
    }

    @Override
    public optimizeModel queryOne(Map<String,Object> map) {
        return optimizeMapper.queryOne(map);
    }


}
