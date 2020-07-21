package com.youngman.mop.core.interceptor;

import com.youngman.mop.core.exception.InvalidTokenException;
import com.youngman.mop.core.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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

    private static final String HEADER_AUTH = "token";

    private final JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        final String token = request.getHeader(HEADER_AUTH);

        if (StringUtils.isNotBlank(token) && jwtService.isValidate(token)) {
            return true;
        }
        throw new InvalidTokenException();
    }

}