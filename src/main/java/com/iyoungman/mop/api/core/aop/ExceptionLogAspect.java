package com.iyoungman.mop.api.core.aop;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by YoungMan on 2019-06-17.
 */

@Slf4j
@Component
@Aspect
public class ExceptionLogAspect {

    @AfterThrowing(value = "execution(* com.iyoungman.mop.api.domain.*.api.*.*(..))", throwing = "e")
    public void printExceptionLog(JoinPoint joinPoint, Exception e) {
        log.info("==============Exception Log Start=================");
        log.info("|");
        log.info("| Exception Time => {}", LocalDateTime.now());
        log.info("| Exception Method => {}", joinPoint.getSignature().getName());
        log.info("| Exception Message => {}", e.getMessage());
        log.info("|");
        log.info("===============Exception Log End==================");
    }
}
