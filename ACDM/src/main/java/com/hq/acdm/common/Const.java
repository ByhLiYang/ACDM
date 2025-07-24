package com.hq.acdm.common;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
public class Const {

    /**
     * 用户redis信息失效时间
     */
    public interface RedisCacheExtime{
        /**
         * 登录失效时间30分钟
         */
//        int REDIS_SESSION_EXTIME = 60 * 30;
        int REDIS_SESSION_EXTIME = 60 * 7200;

        /**
         * 权限失效时间10分钟
         */
        int REDIS_ACLS_EXTIME = 60 * 10;
    }
}
