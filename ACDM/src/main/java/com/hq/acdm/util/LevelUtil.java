package com.hq.acdm.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
public class LevelUtil {

    public final static String SEPARATOR = ".";

    public final static String ROOT = "0";

    // 0
    // 0.1
    // 0.1.2
    // 0.1.3
    // 0.4
    public static String calculateLevel(String parentLevel, int parentId) {
        if (StringUtils.isBlank(parentLevel)) {
            return ROOT;
        } else {
            return StringUtils.join(parentLevel, SEPARATOR, parentId);
        }
    }

    public static String subtractionLevel(String parentLevel) {
        if (StringUtils.isBlank(parentLevel)) {
            return ROOT;
        } else {
            return StringUtils.substring(parentLevel, 0, parentLevel.lastIndexOf("."));
        }
    }

    public static void main(String[] args) {
        System.out.println(calculateLevel("0.6",8));
        System.out.println(subtractionLevel("0.2.6"));
    }
}
