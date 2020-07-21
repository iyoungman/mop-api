//package com.youngman.mop.core.config;
//
//import java.io.IOException;
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Component;
//import redis.embedded.RedisServer;
//
///**
// * Created by iyoungman on 2020-07-20.
// */
//
//@Profile("test")
//@Component
//public class EmbeddedRedisConfig {
//
//    @Value("${spring.redis.port}")
//    private int redisPort;
//
//    @Bean
//    public RedisServerBean redisServer() {
//        return new RedisServerBean();
//    }
//
//    class RedisServerBean implements InitializingBean, DisposableBean {
//
//        private RedisServer redisServer;
//
//        public void afterPropertiesSet() throws Exception {
//            redisServer = new RedisServer(redisPort);
//            redisServer.start();
//        }
//
//        public void destroy() throws Exception {
//            if (redisServer != null) {
//                redisServer.stop();
//            }
//        }
//    }
//
//}
