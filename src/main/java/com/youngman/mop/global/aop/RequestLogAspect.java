package com.youngman.mop.global.aop;

import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by YoungMan on 2019-06-17.
 */

@Slf4j
@Component
@Aspect
public class RequestLogAspect {

	@Pointcut("within(com.youngman.mop.domain.*.api.*)")//jwtApi 도 추가할 것
	public void onRequest() {
	}

	@Around("com.youngman.mop.global.aop.RequestLogAspect.onRequest()")
	public Object printRequestLog(ProceedingJoinPoint pjp) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes())
				.getRequest();

		String params = paramMapToString(request.getParameterMap());
		long start = System.currentTimeMillis();

		try {
			return pjp.proceed(pjp.getArgs());
		} finally {
			long end = System.currentTimeMillis();

			log.info("==============Request Log Start================");
			log.info("|");
			log.info("| Request Time => {}", LocalDateTime.now());
			log.info("| Request URL => {} {}{}", request.getMethod(), request.getRequestURI(), params);
			log.info("| Request Host => {}", request.getRemoteHost());
			log.info("| Take Time => {}ms", end - start);
			log.info("|");
			log.info("===============Request Log End=================");
		}
	}

	private String paramMapToString(Map<String, String[]> paramMap) {
		if (paramMap.isEmpty()) {
			return "";
		}

		return " [" + paramMap.entrySet().stream()
				.map(entry -> String.format("%s -> (%s)", entry.getKey(), Joiner.on(",").join(entry.getValue())))
				.collect(Collectors.joining(", ")) + "]";
	}
}
