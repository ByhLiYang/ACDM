package com.hq.acdm.util;

import com.hq.acdm.common.Const;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */

@Slf4j
public class CookieUtil {

    /** 缓存用户登录信息 */
    public final static String COOKIE_SESSION_NAME = "HQJC_ACDM_LOGIN_TOKEN";



    public static String readLoginToken(HttpServletRequest request, String cookisName){
        Cookie[] cks = request.getCookies();
        request.getCookies();
        if(null != cks){
            for(Cookie ck : cks){
                log.info("read cookieName:{},cookieValue:{}",ck.getName(),ck.getValue());
                if(StringUtils.equals(ck.getName(),cookisName)){
                    log.info("return cookieName:{},cookieValue:{}",ck.getName(),ck.getValue());
                    return ck.getValue();
                }
            }
        }
        return null;
    }

    public static void writeLoginToken(HttpServletResponse response, String token, String cookisName){
        Cookie ck = new Cookie(cookisName,token);
        ck.setPath("/");
        //如果是-1，代表永久,如果不设置MaxAge，cookie写在内存，只在当前页面有效
        ck.setMaxAge(-1);
        log.info("write cookieName:{},cookieValue{}",ck.getName(),ck.getValue());
        response.addCookie(ck);
    }

    public static void delLoginToken(HttpServletRequest request, HttpServletResponse response, String cookisName){
        Cookie[] cks = request.getCookies();
        if(null != cks){
            for(Cookie ck : cks){
                if(StringUtils.equals(ck.getName(),cookisName)){
                    ck.setPath("/");
                    ck.setMaxAge(0);//设置为0，代表删除此cookie
                    log.info("del cookieName:{},cookieValue:{}",ck.getName(),ck.getValue());
                    response.addCookie(ck);
                    return;
                }
            }
        }
    }
}
