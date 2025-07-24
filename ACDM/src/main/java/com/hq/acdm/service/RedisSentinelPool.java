package com.hq.acdm.service;

import com.hq.acdm.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @Author lizhifeng
 * @Date 2018/9/13 0013
 * @Description:
 */
@Service("redisSentinelPool")
@Slf4j
@PropertySource(value ="classpath:settings.properties",encoding = "utf-8")
public class RedisSentinelPool {
    private static  volatile   JedisSentinelPool pool;
    @Value("#{'${redisAddress}'.split(',')}")
    private List<String> redisAddrs;
    private void initJedisSentinelPool() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxTotal(10);
//        jedisPoolConfig.setMaxIdle(5);
//        jedisPoolConfig.setMinIdle(5);
//
//        Set<String> sentinels = new HashSet<>(redisAddrs);
//
//        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
//        poolConfig.setMaxTotal(10);
//        poolConfig.setMaxIdle(5);
//        poolConfig.setMinIdle(5);
//        pool=new JedisSentinelPool("mymaster", sentinels, jedisPoolConfig);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMinIdle(5);


        log.info("redisAddrs"+redisAddrs);

        System.out.println("redisAddrs"+redisAddrs);

        Properties properties=new Properties();
        try {
            File file=new File(ResourceUtils.getFile("classpath:settings.properties").getAbsolutePath());

            properties.load(new FileReader(file));
        } catch (IOException e) {
        }
        String strRedisAddress= properties.getProperty("redisAddress");
        log.info("strRedisAddress:"+strRedisAddress);
        String pwd=properties.getProperty("pwd");
//        if (StringUtil.isEmpty(pwd)){
//            pwd="A-cdm@2019";
//        }
        //集群模式
        Set<String> sentinels = new HashSet<>(Arrays.asList(strRedisAddress.split(",")));
        pool = new JedisSentinelPool("mymaster", sentinels, jedisPoolConfig,pwd);
    }

    public Jedis instance() {
        if(pool==null){
            initJedisSentinelPool();
        }
        return pool.getResource();
    }

    public void safeClose(Jedis jedis) {
        try {
            if (jedis != null) {
                jedis.close();
            }
        } catch (Exception e) {
            log.error("return redis resource exception", e);
        }
    }

    /*public Long expire(String key, int seconds){
        Jedis shardedJedis = null;
        Long result = null;

        try {
            shardedJedis = pool.instance();
            shardedJedis.set(key, "key");
            result = shardedJedis.expire(key, seconds);

            return result;
        } catch (Exception e) {
            log.error("expire key:{} error",key,e);
            return result;
        } finally {
            pool.safeClose(shardedJedis);
        }
    }*/

    public static void main(String[] args) throws Exception {
        String key1 = "key1";
        RedisSentinelPool p=new RedisSentinelPool();
        p.instance();
        try (Jedis jedis = pool.getResource()) {
            jedis.set(key1, "222");
            System.out.println(jedis.get(key1));
            jedis.expire(key1, 3600);
            long a=jedis.ttl(key1);
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
