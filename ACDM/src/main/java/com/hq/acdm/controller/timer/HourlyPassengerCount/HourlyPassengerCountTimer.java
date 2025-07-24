package com.hq.acdm.controller.timer.HourlyPassengerCount;

import com.hq.acdm.model.timer.HourlyPassengerCount.initialData;
import com.hq.acdm.service.timer.HourlyPassengerCount.HourlyPassengerCountService;
import com.hq.acdm.service.timer.HourlyPassengerCount.impl.HourlyPassengerCountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.swing.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/11/8 0008 16:46
 */
@Slf4j
@Configuration
public class HourlyPassengerCountTimer extends TimerTask {
    private static boolean isRunning = false;
    private static boolean HistoricalFlightMasterIsRunning = false;
    private WebApplicationContext context = null;
    private HourlyPassengerCountService hourlyPassengerCountService = null;
    public HourlyPassengerCountTimer() {
    }
    public HourlyPassengerCountTimer(HourlyPassengerCountService hourlyPassengerCountService,WebApplicationContext context) {
        this.hourlyPassengerCountService = hourlyPassengerCountService;
        this.context = context;
    }

    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        if (!isRunning) {
                try{
                    isRunning = true;
                    context.getServletContext().log(df.format(new Date())+"：开始执行旅客计算指定任务");
                    System.out.println(df.format(new Date())+"：开始执行指定任务updateHourlyPassengerCount");
                    Map<String,BigDecimal> queryMap = hourlyPassengerCountService.queryHourlyPassengerCount();
                    if(queryMap.get("COUNTNUMBER").compareTo(new BigDecimal(0))==0){
                        System.out.println(df.format(new Date())+"：开始初始旅客计算当日数据");
                        context.getServletContext().log(df.format(new Date())+"：开始初始旅客计算当日数据");
                        List<initialData> list = new ArrayList<>();
                        for(int i=1;i<=23;i++){
                            list.add(new initialData(i,new Date(),0,0,0,1));
                        }
                        for(int i=1;i<=23;i++){
                            list.add(new initialData(i,new Date(),0,0,0,2));
                        }
                        hourlyPassengerCountService.initialHourlyPassengerCount(list);
                        System.out.println(df.format(new Date())+"：旅客计算初始数据end");
                        context.getServletContext().log(df.format(new Date())+"：旅客计算初始数据end");
                    }
                    hourlyPassengerCountService.updateHourlyPassengerCountT1();
                    hourlyPassengerCountService.updateHourlyPassengerCountT2();
                    System.out.println(df.format(new Date())+"：指定任务旅客计算执行结束");
                    isRunning = false;
                    context.getServletContext().log(df.format(new Date())+"：结束执行指定旅客计算任务");
                }
                catch (Exception e){
                    System.out.println(df.format(new Date())+"：旅客计算错误信息："+e.toString());
                    context.getServletContext().log(df.format(new Date())+"：旅客计算错误信息："+e.toString());
                }
                finally {
                    System.out.println(df.format(new Date())+"：十分钟之后再次旅客计算执行");
                    context.getServletContext().log(df.format(new Date())+"：十分钟之后再次旅客计算执行");
                }

            }else {
            System.out.println(df.format(new Date())+"：上一次任务执行旅客计算还未结束");
            context.getServletContext().log(df.format(new Date())+"：上一次任务执行旅客计算还未结束");
        }

    }
}
