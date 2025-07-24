package com.hq.acdm.controller.ADSB;

import com.hq.acdm.model.ADSB.ADSBModel;
import com.hq.acdm.service.ADSB.ADSBService;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 * @author wangshuhao
 * @date 2018/11/19 0019 15:07
 */
public class ADSBDuplicateController extends TimerTask {
    private WebApplicationContext applicationContext = null;
    private ADSBService adsbService = null;
    private static boolean ADSBDuplicateIsRunning = false;

    public ADSBDuplicateController(WebApplicationContext applicationContext, ADSBService adsbService) {
        this.applicationContext = applicationContext;
        this.adsbService = adsbService;
    }

    public ADSBDuplicateController() {
    }

    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        SimpleDateFormat onlyDate = new SimpleDateFormat("yyyy-mm-dd");
        if(!ADSBDuplicateIsRunning){
            try {
                ADSBDuplicateIsRunning = true;
                applicationContext.getServletContext().log(df.format(new Date()) + "：开始转存ADSB数据");
                System.out.println(df.format(new Date()) + "：开始转存ADSB数据");
                List<ADSBModel> list = adsbService.queryADSBSHA();
                List<ADSBModel> list1 = adsbService.queryADSBOTHERS();
                if(list.size()>0){
                    for(int i=0;i<list.size();i++){
                        List<ADSBModel> ifExist = adsbService.queryADSBDATAisExist(list.get(i));
                        if(ifExist.size()>0){
                            adsbService.deleteADSBSHA(list.get(i));
                        }else{
                            adsbService.insertADSBDATA(list.get(i));
                            adsbService.deleteADSBSHA(list.get(i));
                        }
                    }
                    ADSBDuplicateIsRunning = false;
                    applicationContext.getServletContext().log(df.format(new Date()) + "：结束转存ADSB");
                    System.out.println(df.format(new Date()) + "：结束转存ADSB");
                }else{
                    applicationContext.getServletContext().log(df.format(new Date()) + "：没有最新ADSB数据");
                    System.out.println(df.format(new Date()) + "：没有最新ADSB数据");
                }

                if(list1.size()>0){
                    for(int i=0;i<list1.size();i++){
                        List<ADSBModel> ifExist1 = adsbService.queryADSBDATAisExist(list1.get(i));
                        if(ifExist1.size()>0){
                            adsbService.deleteADSBOTHERS(list1.get(i));
                        }else{
                            adsbService.insertADSBDATA(list1.get(i));
                            adsbService.deleteADSBOTHERS(list1.get(i));
                        }
                    }
                    ADSBDuplicateIsRunning = false;
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
