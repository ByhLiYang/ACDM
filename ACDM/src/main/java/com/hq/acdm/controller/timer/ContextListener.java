package com.hq.acdm.controller.timer;

import com.hq.acdm.controller.ADSB.ADSBController;
import com.hq.acdm.controller.timer.Anjian.AnjianTimer;
import com.hq.acdm.controller.timer.DailyRunWay.DailyRunWayController;
import com.hq.acdm.controller.timer.GetTimeAVGByHour.GetTimeAVGByHourController;
import com.hq.acdm.controller.timer.Historical_Flight_Add_Details.HistoricalFlightAddDetails;
import com.hq.acdm.controller.timer.Historical_Flight_Add_Details_More.HistoricalFlightAddDetailsMore;
import com.hq.acdm.controller.timer.Historical_Flight_Master.HistoricalFlightMaster;
import com.hq.acdm.controller.timer.HourlyPassengerCount.HourlyPassengerCountTimer;
import com.hq.acdm.controller.timer.MilestoneHistoricalLog.MilestoneHistoricalLogTimer;
import com.hq.acdm.controller.timer.ShiftDuty.ShiftDuty;
import com.hq.acdm.service.ADSB.ADSBService;
import com.hq.acdm.service.index.CompanyDutyService;
import com.hq.acdm.service.timer.Anjian.AnjianService;
import com.hq.acdm.service.timer.DailyRunWay.DailyRunWayService;
import com.hq.acdm.service.timer.GetTimeAVGByHour.GetTimeAVGByHourService;
import com.hq.acdm.service.timer.Historical_Flight_Master.HistoricalFlightMasterService;
import com.hq.acdm.service.timer.HourlyPassengerCount.HourlyPassengerCountService;
import com.hq.acdm.service.timer.MilestoneHistoricalLog.MilestoneHistoricalLogService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wangshuhao
 * @date 2018/11/8 0008 16:46
 */
public class ContextListener extends HttpServlet implements ServletContextListener {
    public ContextListener() {
    }

    private java.util.Timer timer = null;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获得Spring容器
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        //从Spring容器中获得SelectDataServlet的实例
        HourlyPassengerCountService hourlyPassengerCountService = ctx.getBean(HourlyPassengerCountService.class);
        HistoricalFlightMasterService historicalFlightMasterService = ctx.getBean(HistoricalFlightMasterService.class);
        CompanyDutyService companyDutyService = ctx.getBean(CompanyDutyService.class);
        MilestoneHistoricalLogService milestoneHistoricalLogService = ctx.getBean(MilestoneHistoricalLogService.class);
        DailyRunWayService dailyRunWayService = ctx.getBean(DailyRunWayService.class);
        GetTimeAVGByHourService getTimeAVGByHourService = ctx.getBean(GetTimeAVGByHourService.class);
        AnjianService anjianService = ctx.getBean(AnjianService.class);
        ADSBService adsbService = ctx.getBean(ADSBService.class);
        timer = new java.util.Timer(true);
        ctx.getServletContext().log("定时器已启动");
        timer.schedule(new HourlyPassengerCountTimer(hourlyPassengerCountService, ctx), 0, 10*60*1000);
        timer.schedule(new DailyRunWayController(dailyRunWayService, ctx), 0, 10*60*1000);
        timer.schedule(new GetTimeAVGByHourController(getTimeAVGByHourService, ctx), 0, 60*60*1000);
        timer.schedule(new ADSBController(ctx,adsbService), 0, 60*60*1000);
//        timer.schedule(new ADSBDuplicateController(ctx,adsbService), 0, 60*60*1000);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(6);
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
        Date curDate = new Date();
        try{
            curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + "01:00:00");
        }catch (ParseException e) {
            e.printStackTrace();
        }
        long oneDay = 24*60*60*1000;
        long taskShiftDuty = curDate.getTime() - System.currentTimeMillis();
        taskShiftDuty = taskShiftDuty > 0 ? taskShiftDuty : oneDay + taskShiftDuty;
        executor.schedule(new ShiftDuty(companyDutyService,ctx),taskShiftDuty,TimeUnit.MILLISECONDS);
        executor.schedule(new DailyRunWayController(dailyRunWayService,ctx),taskShiftDuty,TimeUnit.MILLISECONDS);
        executor.schedule(new HistoricalFlightMaster(historicalFlightMasterService, ctx),taskShiftDuty,TimeUnit.MILLISECONDS);
        executor.schedule(new HistoricalFlightAddDetails(historicalFlightMasterService, ctx),taskShiftDuty,TimeUnit.MILLISECONDS);
        executor.schedule(new HistoricalFlightAddDetailsMore(historicalFlightMasterService, ctx),taskShiftDuty,TimeUnit.MILLISECONDS);
        executor.schedule(new MilestoneHistoricalLogTimer(milestoneHistoricalLogService, ctx),taskShiftDuty,TimeUnit.MILLISECONDS);
        executor.schedule(new AnjianTimer(ctx, anjianService),taskShiftDuty,TimeUnit.MILLISECONDS);
        ctx.getServletContext().log("已经添加任务调度表");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        timer.cancel();
        servletContextEvent.getServletContext().log("定时器销毁");
    }
}
