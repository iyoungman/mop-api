package com.youngman.mop.global.interceptor;

import com.youngman.mop.global.error.UserDefineException;
import com.youngman.mop.domain.member.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YoungMan on 2019-06-15.
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {

	private final String HEADER_AUTH = "token";
	private final JwtService jwtService;


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		final String jwtToken = request.getHeader(HEADER_AUTH);

		if (jwtToken != null && jwtService.isUsable(jwtToken)) {
			return true;
		}
		throw new UserDefineException("올바르지 않은 JWT 토큰입니다");
	}

}