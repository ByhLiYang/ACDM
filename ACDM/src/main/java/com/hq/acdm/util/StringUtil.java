package com.hq.acdm.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
public class StringUtil {

    public static List<Integer> splitToListInt(String str) {
        List<String> strList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str);
        List<Integer> intList = new ArrayList<>();
        for (String strItem : strList) {
            intList.add(Integer.parseInt(strItem));
        }
        return intList;
    }

    /**
     * 判断字符串是否为空.
     *
     * @param str 字符串
     * @return 返回判断结果
     */
    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(Object str) {
        return !(str == null || "".equals(str));
    }

    public static boolean isNotEmpty2(Object str) {
        return !(str == null || "".equals(str)|| "null".equals(str));
    }

    public static boolean isAllNotEmpty(Object... args) {
        for (Object str : args) {
            if (str == null || "".equals(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * aA_Bb_CC_dd转换AaBbCcDd.
     *
     * @param str 需要处理的字符串
     * @return 返回处理后的字符串
     */
    public static String convert1(String str) {
        String[] parts=str.split("_");
        String newStr = "";
        for (String part : parts) {
            if(part.length()>=1){
                newStr+=part.toUpperCase().substring(0, 1) + part.toLowerCase().substring(1);
            }
        }
        return newStr;
    }
    /**
     * 首字母小写
     *
     * @param str 需要处理的字符串（长度大于1）
     * @return 返回处理后的字符串
     */
    public static String convert2(String str) {
        if(null!=str&&str.length()>1){
            String newStr = str.toLowerCase().substring(0, 1) + str.substring(1);
            return newStr;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println("你妹"+11);
    }
}
