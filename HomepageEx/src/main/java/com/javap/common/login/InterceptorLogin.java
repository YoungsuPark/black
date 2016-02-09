package com.javap.common.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorLogin extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String id = (String)request.getSession().getAttribute("sessionId");
		String uri = request.getRequestURI();
		
		if( !uri.equals("/") 
			&& !uri.equals("/home/welcomeHome.do") 
			&& !uri.equals("/member/loginMember.do")
			&& !uri.equals("/member/openJoinPage.do")
			&& !uri.equals("/member/insertMember.do") ) 
			{
				if (id == null) 
				{
					response.sendRedirect("/");
					return false;
				}
			}
		return true;
	}
}