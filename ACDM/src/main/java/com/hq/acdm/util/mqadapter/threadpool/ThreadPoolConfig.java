package com.hq.acdm.util.mqadapter.threadpool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * create by: Wang Xieqin
 * description:消息处理线程池配置
 * create time: 10:38 2018/11/2
 */

@Configuration
public class ThreadPoolConfig {
    //最大线程个数
    @Value("${threadPool.maxPoolSize:1}")
    private int maxPoolSize;

    //获得一个线程池
    @Bean
    public ExecutorService getThreadPool(){
        return Executors.newFixedThreadPool (maxPoolSize);
    }

}
