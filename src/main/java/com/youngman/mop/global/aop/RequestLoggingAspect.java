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
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by YoungMan on 2019-06-17.
 */

@Slf4j
@Component
@Aspect
public class RequestLoggingAspect {

	private String paramMapToString(Map<String, String[]> paramMap) {
		return paramMap.entrySet().stream()
				.map(entry -> String.format("%s -> (%s)",
						entry.getKey(), Joiner.on(",").join(entry.getValue())))
				.collect(Collectors.joining(", "));
	}

	@Pointcut("within(com.youngman.mop.domain.member.api.MemberApi)")
	public void onRequest() {}

	@Around("com.youngman.mop.global.aop.RequestLoggingAspect.onRequest()")
	public Object printLogging(ProceedingJoinPoint pjp) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();

		Map<String, String[]> paramMap = request.getParameterMap();
		String params = "";
		if (paramMap.isEmpty() == false) {
			params = " [" + paramMapToString(paramMap) + "]";
		}

		long start = System.currentTimeMillis();
		try {
			return pjp.proceed(pjp.getArgs()); // 6
		} finally {
			long end = System.currentTimeMillis();
			log.info("Request: {} {}{} < {} ({}ms)", request.getMethod(), request.getRequestURI(),
					params, request.getRemoteHost(), end - start);
		}
	}
}
