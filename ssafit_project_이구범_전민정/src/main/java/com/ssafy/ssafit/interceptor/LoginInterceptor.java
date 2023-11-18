package com.ssafy.ssafit.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	// preHandle : Controller 동작 이전에 실행되는 Interceptor
	// WebConfig 파일에서 해당하는 컨트롤러 지정 가능
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("loginUser"));
		if(session.getAttribute("loginUser") == null) {
//			response.sendRedirect("/login");
			return false;
		}
		return true;
	}
}
