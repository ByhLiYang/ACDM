package com.hq.acdm.controller.timer.ShiftDuty;

import com.hq.acdm.model.index.CompanyDuty;
import com.hq.acdm.service.index.CompanyDutyService;
import com.hq.acdm.service.timer.Historical_Flight_Master.HistoricalFlightMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 * @author wangshuhao
 * @date 2018/11/12 0012 13:41
 */
@Slf4j
@Configuration
public class ShiftDuty implements Runnable{
    private static boolean companyDutyServiceIsRunning = false;
    private WebApplicationContext context = null;
    private CompanyDutyService companyDutyService = null;
    public ShiftDuty() {
    }
    public ShiftDuty(CompanyDutyService companyDutyService, WebApplicationContext context) {
        this.companyDutyService = companyDutyService;
        this.context = context;
    }
    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat onlyDate = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");

        if(!companyDutyServiceIsRunning){
            try{
                context.getServletContext().log(df.format(new Date())+"：开始执行SHIFT DUTY任务");
                System.out.println(df.format(new Date())+"：开始执行SHIFT DUTY任务");
                List<CompanyDuty> list = companyDutyService.selectOrderByDate();
                if(list.size()==0){
                    context.getServletContext().log(df.format(new Date())+"：原始表中无数据，请手动创建");
                    System.out.println(df.format(new Date())+"：原始表中无数据，请手动创建");
                }else{
                    Date dutyDay = new Date();
                    CompanyDuty companyDuty = list.get(0);
                    companyDuty.setDutyDate(dutyDay);
                    List<CompanyDuty> maxId = companyDutyService.maxId();
                    companyDuty.setId(maxId.get(0).getId().add(new BigDecimal(1)));
                    companyDutyService.insert(companyDuty);
                    context.getServletContext().log(df.format(new Date())+"：完成执行SHIFT DUTY任务");
                    System.out.println(df.format(new Date())+"：完成执行SHIFT DUTY任务");
                }
            }catch (Exception e){
                System.out.println(df.format(new Date())+"：SHIFT DUTY错误信息："+e.toString());
                context.getServletContext().log(df.format(new Date())+"：SHIFT DUTY错误信息："+e.toString());
            }finally {
                System.out.println(df.format(new Date())+"：明日一点再次SHIFT DUTY执行");
                context.getServletContext().log(df.format(new Date())+"：明日一点再次SHIFT DUTY执行");
            }

        }else {
            System.out.println(df.format(new Date())+"：上一次任务执行SHIFT DUTY还未结束");
            context.getServletContext().log(df.format(new Date())+"：上一次任务执行SHIFT DUTY还未结束");
        }
    }
}
