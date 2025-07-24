package com.hq.acdm.controller.ADSB;

import com.hq.acdm.model.ADSB.ADSBModel;
import com.hq.acdm.service.ADSB.ADSBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 18:32
 */
@Slf4j
@Configuration
public class  ADSBController extends TimerTask {
    private WebApplicationContext applicationContext = null;
    private ADSBService adsbService = null;
    private static boolean ADSBIsRunning = false;

    public ADSBController(WebApplicationContext applicationContext, ADSBService adsbService) {
        this.applicationContext = applicationContext;
        this.adsbService = adsbService;
    }

    public ADSBController() {
    }

    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        SimpleDateFormat onlyDate = new SimpleDateFormat("yyyy-mm-dd");
        if(!ADSBIsRunning){
            try {
                ADSBIsRunning = true;
                applicationContext.getServletContext().log(df.format(new Date()) + "：开始转存ADSB数据");
                System.out.println(df.format(new Date()) + "：开始转存ADSB数据");
                List<ADSBModel> list = adsbService.queryADSB();
                if(list.size()>0){
                    for(int i=0;i<list.size();i++){
                        if("SHA".equals(list.get(i).getDA())||"SHA".equals(list.get(i).getOA())){
                            List<ADSBModel> shaList = adsbService.queryADSBSHAisExist(list.get(i));
                            if(shaList.size()>0){
                                adsbService.deleteADSBDATA(list.get(i));
                            }else{
                                applicationContext.getServletContext().log(df.format(new Date()) + "：插入ADSBSHA数据库");
                                System.out.println(df.format(new Date()) + "：插入ADSBSHA数据库");
                                adsbService.insertADSBSHA(list.get(i));
                                adsbService.deleteADSBDATA(list.get(i));
                            }
                        }else{
                            List<ADSBModel> othersList = adsbService.queryADSBOTHERSisExist(list.get(i));
                            if(othersList.size()>0){
                                adsbService.deleteADSBDATA(list.get(i));
                            }else{
                                applicationContext.getServletContext().log(df.format(new Date()) + "：插入ADSBOTHERS数据库");
                                System.out.println(df.format(new Date()) + "：插入ADSBOTHERS数据库");
                                adsbService.insertADSBOTHERS(list.get(i));
                                adsbService.deleteADSBDATA(list.get(i));
                            }
                        }
                    }
                    ADSBIsRunning = false;
                    applicationContext.getServletContext().log(df.format(new Date()) + "：结束转存ADSB");
                    System.out.println(df.format(new Date()) + "：结束转存ADSB");
                }else{
                    applicationContext.getServletContext().log(df.format(new Date()) + "：没有最新ADSB数据");
                    System.out.println(df.format(new Date()) + "：没有最新ADSB数据");
                }

            }catch (Exception e){
                System.out.println(df.format(new Date())+"：ADSB错误信息："+e.toString());
                applicationContext.getServletContext().log(df.format(new Date())+"：ADSB错误信息："+e.toString());
            }finally {
                System.out.println(df.format(new Date())+"：一小时之后再次执行ADSB转存");
                applicationContext.getServletContext().log(df.format(new Date())+"：一小时之后再次执行ADSB转存");
            }

        }else{
            System.out.println(df.format(new Date())+"：上一次ADSB任务还未结束");
            applicationContext.getServletContext().log(df.format(new Date())+"：上一次ADSB任务还未结束");
        }
    }
}
