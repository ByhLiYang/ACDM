package com.hq.acdm.service;

import com.hq.acdm.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

import javax.annotation.Resource;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Service
@Slf4j
public class SysCacheService {

//    @Resource(name = "redisSentinelPool")
//    private RedisSentinelPool redisPool;
//
//    public Long expire(String key, int exTime){
//        Jedis shardedJedis = null;
//        Long result = null;
//
//        try {
//            shardedJedis = redisPool.instance();
//            result = shardedJedis.expire(key, exTime);
//            return result;
//        } catch (Exception e) {
//            log.error("expire key:{} error",key,e);
//            return result;
//        } finally {
//            redisPool.safeClose(shardedJedis);
//        }
//    }
//
//    public void saveCache(String toSavedValue, int timeoutSeconds, String key) {
//        if (toSavedValue == null) {
//            return;
//        }
//        Jedis shardedJedis = null;
//        try {
//            shardedJedis = redisPool.instance();
//            shardedJedis.setex(key, timeoutSeconds, toSavedValue);
//        } catch (Exception e) {
//            log.error("save cache exception,  key:{}",  JsonMapper.obj2String(key), e);
//        } finally {
//            redisPool.safeClose(shardedJedis);
//        }
//    }
//
//    public String getFromCache(String key) {
//        Jedis shardedJedis = null;
//        try {
//            shardedJedis = redisPool.instance();
//            String value = shardedJedis.get(key);
//            return value;
//        } catch (Exception e) {
//            log.error("get from cache exception, key:{}",  JsonMapper.obj2String(key), e);
//            return null;
//        } finally {
//            redisPool.safeClose(shardedJedis);
//        }
//    }
//
//    public Long delFromCache(String key) {
//        if (null == key) {
//            return null;
//        }
//        Jedis shardedJedis = null;
//        Long result = null;
//        try {
//            shardedJedis = redisPool.instance();
//            result = shardedJedis.del(key);
//            return result;
//        } catch (Exception e) {
//            log.error("get from cache exception, key:{}",JsonMapper.obj2String(key), e);
//            return result;
//        } finally {
//            redisPool.safeClose(shardedJedis);
//        }
//    }

    @Resource(name = "redisPool")
    private RedisPool redisPool;

   public Long expire(String key, int exTime){
        ShardedJedis shardedJedis = null;
        Long result = null;

        try {
            shardedJedis = redisPool.instance();
            result = shardedJedis.expire(key, exTime);
            return result;
        } catch (Exception e) {
            log.error("expire key:{} error",key,e);
            return result;
        } finally {
            redisPool.safeClose(shardedJedis);
        }
    }

    public void saveCache(String toSavedValue, int timeoutSeconds, String key) {
        if (toSavedValue == null) {
            return;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = redisPool.instance();
            shardedJedis.setex(key, timeoutSeconds, toSavedValue);
        } catch (Exception e) {
            log.error("save cache exception,  key:{}",  JsonMapper.obj2String(key), e);
        } finally {
            redisPool.safeClose(shardedJedis);
        }
    }

    public String getFromCache(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = redisPool.instance();
            String value = shardedJedis.get(key);
            return value;
        } catch (Exception e) {
            log.error("get from cache exception, key:{}",  JsonMapper.obj2String(key), e);
            return null;
        } finally {
            redisPool.safeClose(shardedJedis);
        }
    }

    public Long delFromCache(String key) {
        if (null == key) {
            return null;
        }
        ShardedJedis shardedJedis = null;
        Long result = null;
        try {
            shardedJedis = redisPool.instance();
            result = shardedJedis.del(key);
            return result;
        } catch (Exception e) {
            log.error("get from cache exception, key:{}",JsonMapper.obj2String(key), e);
            return result;
        } finally {
            redisPool.safeClose(shardedJedis);
        }
    }

}
