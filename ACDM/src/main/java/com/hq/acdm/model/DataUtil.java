package com.hq.acdm.model;

import com.hq.acdm.model.statistics.aosssysdic.Aosssysdic;
import com.hq.acdm.service.statistics.aosssysdic.AosssysdicService;
import com.hq.acdm.service.statistics.aosssysdic.impl.AosssysdicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class DataUtil {


    /**
     * 描述：取两个日期相隔的小时数
     *
     * @param da
     * @param db
     * @return long
     */
    public static int getHours(String da, String db) {
        if(da==null||db==null)return 0;
        java.util.Date d1 = formatDate(da, "yyyy-MM-dd HH:mm:SS");
        java.util.Date d2 = formatDate(db, "yyyy-MM-dd HH:mm:SS");
        long elapsed = 0;
        long l1 = d1.getTime();
        long l2 = d2.getTime();
        long difference = l2 - l1;//Math.abs(l2 - l1);
        elapsed = difference / 1000 / 3600;
        return Math.abs(Math.round(elapsed));
    }
    public static long getSecond(String da, String db) {
        if(da==null||db==null)return 0;
        java.util.Date d1 = formatDate(da, "yyyy-MM-dd HH:mm:SS");
        java.util.Date d2 = formatDate(db, "yyyy-MM-dd HH:mm:SS");
        long elapsed = 0;
        long l1 = d1.getTime();
        long l2 = d2.getTime();
        long difference = l2 - l1;//Math.abs(l2 - l1);
        return Math.abs(difference/1000);
    }


    public static java.sql.Date formatDate(String date, String szFormat) {
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(szFormat);
        try {
            if (date == null || date.equals("")) return null;
            java.sql.Date t = new java.sql.Date(format.parse(date).getTime());
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 将指定的日期转换成指定的字符格式返回
     * @param date 给顶日期
     * @param szFormat  日期格式，如"yyyyMMdd"
     * @return
     */
    public static String formatDate(java.sql.Timestamp date, String szFormat) {
        if(date==null)return "";
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(szFormat);
        return format.format(date);
    }
    //取预警值
    @Resource
    private AosssysdicService aosssysdicService;
    public static int  getAssysDictValue(String typecode,String paracode){
        AosssysdicService aosssysdicService=new AosssysdicServiceImpl();;
        List<Aosssysdic> aosssysdiclist = aosssysdicService.selectDefinedParawvalue(typecode,paracode,"","");
        if(aosssysdiclist.size()>0){
            Aosssysdic dict=  (Aosssysdic)aosssysdiclist.iterator().next();
            String str= dict.getPARAMVALUE();
            if(str==null)str="0";
            return Integer.parseInt(str);
        }
        return 0;
    }

    public static String getDate(long l){
        String H=l/1000/60/60+"";
        String M=l/1000/60%60+"";
        String S=l/1000%60+"";
        if(H.length()==1){
            H="0"+H;
        } if(M.length()==1){
            M="0"+M;
        } if(S.length()==1){
            S="0"+S;
        }
        return H+":"+M+":"+S;
    }

}
