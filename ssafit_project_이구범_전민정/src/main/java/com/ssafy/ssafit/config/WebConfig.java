package com.ssafy.ssafit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.ssafit.interceptor.JwtInterceptor;
import com.ssafy.ssafit.interceptor.LoginInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	// 가져다 쓸 인터셉터 ~ 
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

		registry.addResourceHandler("/swagger-ui/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");

	}

	// 일단, 인터셉터는 넣어둬~
	// 등록할 인터셉터가 있다면...
	// 필드를 통해 의존성을 주입 받고 등록 ㄱㄱ
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// addPathPatterns() 메서드 안의 요청이 들어왔을 때, 인터셉터 실행
		// excludePathPatterns() 메서드 안의 요청이 들어왔을 때, 인터셉터 미실행
//		registry.addInterceptor(loginInterceptor).addPathPatterns("/**/review").excludePathPatterns("/api/login", "/swagger-resources/**", "/swagger-ui/**", "/v2/api-docs");
	}
	
	//CORS 에러를 해결하기 위해서 컨트롤러에 각각 작성을 할수도 있지만 공통처리(전역처리)라면 요기다 한방에 가넝
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
	
	}
	
	
	

}