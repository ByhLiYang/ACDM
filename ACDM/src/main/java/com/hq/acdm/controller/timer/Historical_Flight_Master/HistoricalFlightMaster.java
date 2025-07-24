package com.hq.acdm.controller.timer.Historical_Flight_Master;

import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightMaster;
import com.hq.acdm.service.timer.Historical_Flight_Master.HistoricalFlightMasterService;
import com.hq.acdm.service.timer.HourlyPassengerCount.HourlyPassengerCountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

import javax.management.ObjectName;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/11/11 0011 13:39
 */
@Slf4j
@Configuration
public class HistoricalFlightMaster implements Runnable {
    private static boolean HistoricalFlightMasterIsRunning = false;
    private WebApplicationContext context = null;
    private HistoricalFlightMasterService historicalFlightMasterService = null;
    public HistoricalFlightMaster() {
    }
    public HistoricalFlightMaster(HistoricalFlightMasterService historicalFlightMasterService, WebApplicationContext context) {
        this.historicalFlightMasterService = historicalFlightMasterService;
        this.context = context;
    }
    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat onlyDate = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        if(!HistoricalFlightMasterIsRunning){
        try{

                HistoricalFlightMasterIsRunning = true;
                context.getServletContext().log(df.format(new Date())+"：开始执行HistoricalFlightMaster指定任务");
                System.out.println(df.format(new Date())+"：开始执行HistoricalFlightMaster指定任务");
                int tempNumberCount = historicalFlightMasterService.countDFM().getCountNumber();
                int deleteCount = 0;
                if(tempNumberCount>0){
                    List<DailyFlightMaster> list = historicalFlightMasterService.queryDFM();
                    for(int i=0;i<list.size();i++){
                        Map<String,Object> map = new HashMap<>();
                        map.put("operational_date",onlyDate.format(list.get(i).getOperational_date()));
                        map.put("flight_no_iata",list.get(i).getFlight_no_iata());
                        map.put("a_or_d",list.get(i).getA_or_d());
                        map.put("flight_repeat_count",list.get(i).getFlight_repeat_count());
                        if(historicalFlightMasterService.queryByCondition(map).getCountNumber()>0){
                            deleteCount = deleteCount +1;
                            historicalFlightMasterService.deleteHistorical(map);
                        }
                        historicalFlightMasterService.insertHistoricalFlightMaster(list.get(i));
                        historicalFlightMasterService.deleteDFM(map);//删除dailyflightmaster
                    }

                    context.getServletContext().log(df.format(new Date())+"：删除："+String.valueOf(deleteCount)+"  插入："+String.valueOf(list.size()));
                    System.out.println(df.format(new Date())+"：删除："+String.valueOf(deleteCount)+"  插入："+String.valueOf(list.size()));
                }
                HistoricalFlightMasterIsRunning = false;
                context.getServletContext().log(df.format(new Date())+"：完成执行指定任务HistoricalFlightMaster");
                System.out.println(df.format(new Date())+"：完成执行指定任务HistoricalFlightMaster");


        }
        catch (Exception e){
            System.out.println(df.format(new Date())+"：DailyFlightMaster错误信息："+e.toString());
            context.getServletContext().log(df.format(new Date())+"：DailyFlightMaster错误信息："+e.toString());
        }
        finally {
            System.out.println(df.format(new Date())+"：12小时之后再次DailyFlightMaster执行");
            context.getServletContext().log(df.format(new Date())+"：12小时之后再次DailyFlightMaster执行");
        }
        }else{
            System.out.println(df.format(new Date())+"：上一次任务执行DailyFlightMaster转存还未结束");
            context.getServletContext().log(df.format(new Date())+"：上一次任务执行DailyFlightMaster转存还未结束");
        }
    }
}
