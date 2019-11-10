//package com.youngman.mop.global.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.SessionCallback;
//import org.springframework.data.redis.core.script.RedisScript;
//import org.springframework.data.redis.serializer.RedisSerializer;
//
//import java.util.List;
//
///**
// * Created by YoungMan on 2019-10-26.
// */
//
//@Slf4j
//public class LoggingRedisTemplate<K, V> extends RedisTemplate<K, V> {
//
//    @Override
//    public <T> T execute(final RedisCallback<T> action, final boolean exposeConnection, final boolean pipeline) {
//        try {
//            return super.execute(action, exposeConnection, pipeline);
//        } catch (final Throwable t) {
//            log.info("Error executing cache operation: {}", t.getMessage());
//            return null;
//        }
//    }
//
//    @Override
//    public <T> T execute(final RedisScript<T> script, final List<K> keys, final Object... args) {
//        try {
//            return super.execute(script, keys, args);
//        } catch (final Throwable t) {
//            log.info("Error executing cache operation: {}", t.getMessage());
//            return null;
//        }
//    }
//
//    @Override
//    public <T> T execute(final RedisScript<T> script, final RedisSerializer<?> argsSerializer,
//                         final RedisSerializer<T> resultSerializer, final List<K> keys, final Object... args) {
//        try {
//            return super.execute(script, argsSerializer, resultSerializer, keys, args);
//        } catch (final Throwable t) {
//            log.info("Error executing cache operation: {}", t.getMessage());
//            return null;
//        }
//    }
//
//    @Override
//    public <T> T execute(final SessionCallback<T> session) {
//        try {
//            return super.execute(session);
//        } catch (final Throwable t) {
//            log.info("Error executing cache operation: {}", t.getMessage());
//            return null;
//        }
//    }
//}
