package com.youngman.mop.core.config;

import com.youngman.mop.core.interceptor.JwtInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by YoungMan on 2019-06-15.
 */

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

	private static final String[] EXCLUDE_PATHS = {
			"/mop/member/signin",
			"/mop/member/signup"
	};

	private final JwtInterceptor jwtInterceptor;

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(jwtInterceptor)
//				.addPathPatterns("/**")
//				.excludePathPatterns(EXCLUDE_PATHS)
//		;
//	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("mop/club/image/**")
				.addResourceLocations("file:///C:/Users/LG/Desktop/dwdw/");
	}
}
