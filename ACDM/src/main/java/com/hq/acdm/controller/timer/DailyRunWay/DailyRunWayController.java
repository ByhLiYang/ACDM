package com.hq.acdm.controller.timer.DailyRunWay;

import com.hq.acdm.model.index.CompanyDuty;
import com.hq.acdm.model.timer.DailyRunWay.DailyRunWay;
import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightMaster;
import com.hq.acdm.service.index.CompanyDutyService;
import com.hq.acdm.service.timer.DailyRunWay.DailyRunWayService;
import org.springframework.web.context.WebApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/11/13 0013 16:45
 */
public class DailyRunWayController extends TimerTask{
    private static boolean DailyRunWayServiceIsRunning = false;
    private WebApplicationContext context = null;
    private DailyRunWayService dailyRunWayService = null;
    public DailyRunWayController() {
    }
    public DailyRunWayController(DailyRunWayService dailyRunWayService, WebApplicationContext context) {
        this.dailyRunWayService = dailyRunWayService;
        this.context = context;
    }
    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(!DailyRunWayServiceIsRunning){
            DailyRunWayServiceIsRunning = true;
            try{
                context.getServletContext().log(df.format(new Date())+"：开始执行Daily Runway任务");
                System.out.println(df.format(new Date())+"：开始执行Daily Runway任务");
                List<DailyFlightMaster> list = dailyRunWayService.queryLatestRWY();
                Map<String,Object> map= new HashMap<>();
                Map<String,Object> map1= new HashMap<>();
                if(list.size()>0){
//                    List<DailyRunWay> dailyRunWayList = dailyRunWayService.queryLastest();
                    context.getServletContext().log(df.format(new Date())+"：已有Daily Flight Master");
                    System.out.println(df.format(new Date())+"：已有Daily Flight Master");
                    DailyFlightMaster dailyFlightMaster = list.get(0);
                    if(dailyFlightMaster.getA_or_d().equals("A")){
                        if(dailyFlightMaster.getRwy().equals("36R")){

                            map.put("RWY","36R");
                            map.put("A_OR_D","A");
                            map.put("EDITOR","aocU01");
                            map1.put("RWY","36L");
                            map1.put("A_OR_D","D");
                            map1.put("EDITOR","aocU01");
                        }else if(dailyFlightMaster.getRwy().equals("36L")){

                            map.put("RWY","36L");
                            map.put("A_OR_D","A");
                            map.put("EDITOR","aocU01");
                            map1.put("RWY","36R");
                            map1.put("A_OR_D","D");
                            map1.put("EDITOR","aocU01");
                        }else if(dailyFlightMaster.getRwy().equals("18L")){

                            map.put("RWY","18L");
                            map.put("A_OR_D","A");
                            map.put("EDITOR","aocU01");
                            map1.put("RWY","18R");
                            map1.put("A_OR_D","D");
                            map1.put("EDITOR","aocU01");
                        }else if(dailyFlightMaster.getRwy().equals("18R")){

                            map.put("RWY","18R");
                            map.put("A_OR_D","A");
                            map.put("EDITOR","aocU01");
                            map1.put("RWY","18L");
                            map1.put("A_OR_D","D");
                            map1.put("EDITOR","aocU01");
                        }
                    }else if(dailyFlightMaster.getA_or_d().equals("D")){
                        if(dailyFlightMaster.getRwy().equals("36R")){

                            map.put("RWY","36R");
                            map.put("A_OR_D","D");
                            map.put("EDITOR","aocU01");
                            map1.put("RWY","36L");
                            map1.put("A_OR_D","A");
                            map1.put("EDITOR","aocU01");
                        }else if(dailyFlightMaster.getRwy().equals("36L")){

                            map.put("RWY","36L");
                            map.put("A_OR_D","D");
                            map.put("EDITOR","aocU01");
                            map1.put("RWY","36R");
                            map1.put("A_OR_D","A");
                            map1.put("EDITOR","aocU01");
                        }else if(dailyFlightMaster.getRwy().equals("18L")){

                            map.put("RWY","18L");
                            map.put("A_OR_D","D");
                            map.put("EDITOR","aocU01");
                            map1.put("RWY","18R");
                            map1.put("A_OR_D","A");
                            map1.put("EDITOR","aocU01");
                        }else if(dailyFlightMaster.getRwy().equals("18R")){

                            map.put("RWY","18R");
                            map.put("A_OR_D","D");
                            map.put("EDITOR","aocU01");
                            map1.put("RWY","18L");
                            map1.put("A_OR_D","A");
                            map1.put("EDITOR","aocU01");
                        }
                    }


                    List<DailyRunWay> dailyRunWayList = dailyRunWayService.queryByConditionIfExist(map);
                    List<DailyRunWay> dailyRunWayList1 = dailyRunWayService.queryByConditionIfExist(map1);
                    if(dailyRunWayList.size()>0 || dailyRunWayList1.size()>0){
                        context.getServletContext().log(df.format(new Date())+"：Daily Runway不变");
                        System.out.println(df.format(new Date())+"：Daily Runway不变");
                    }else{
                        List<DailyRunWay> latest = dailyRunWayService.queryTodayDailyRunWay();
                        if(latest.size()>0){
                            for(int j=0;j<latest.size();j++){
                                DailyRunWay dailyRunWay1 = latest.get(j);
                                dailyRunWayService.updateDailyRunWay(dailyRunWay1);
                            }
                        }else{
                            dailyRunWayService.insertCondition(map);
                            dailyRunWayService.insertCondition(map1);
                            context.getServletContext().log(df.format(new Date())+"：Daily Runway插入已有daily flight master数据");
                            System.out.println(df.format(new Date())+"：Daily Runway插入已有daily flight master数据");
                        }
                    }
                }else{
                    context.getServletContext().log(df.format(new Date())+"：daily flight master原始表中无数据");
                    System.out.println(df.format(new Date())+"：daily flight master原始表中无数据");
                    List<DailyRunWay> todayList = dailyRunWayService.queryTodayDailyRunWay();
                    if (todayList.size()>0){
                        context.getServletContext().log(df.format(new Date())+"：Daily Runway不变");
                        System.out.println(df.format(new Date())+"：Daily Runway不变");
                    }else{
                        dailyRunWayService.insertDRWD();
                        dailyRunWayService.insertDRWA();
                        context.getServletContext().log(df.format(new Date())+"：插入当天默认值");
                        System.out.println(df.format(new Date())+"：插入当天默认值");
                    }

                }
                context.getServletContext().log(df.format(new Date())+"：完成执行Daily Runway任务");
                System.out.println(df.format(new Date())+"：完成执行Daily Runway任务");
                DailyRunWayServiceIsRunning = false;
            }catch (Exception e){
                System.out.println(df.format(new Date())+"：Daily Runway错误信息："+e.toString());
                context.getServletContext().log(df.format(new Date())+"：Daily Runway错误信息："+e.toString());
            }finally {
                System.out.println(df.format(new Date())+"：每十分钟再次Daily Runway执行");
                context.getServletContext().log(df.format(new Date())+"：每十分钟再次Daily Runway执行");
            }

        }else {
            System.out.println(df.format(new Date())+"：上一次任务执行Daily Runway还未结束");
            context.getServletContext().log(df.format(new Date())+"：上一次任务执行Daily Runway还未结束");
        }
    }
}
