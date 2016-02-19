package com.javap.home.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javap.common.commandmap.CommandMap;
import com.javap.home.service.HomeService;

@Controller
public class HomeController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="homeService")
	private HomeService homeSerivce;
	
	/**
	 * 홈으로 이동
	 * @param commandMap
	 * @return
	 */
	@RequestMapping(value="/home/mainHome.do")
	public ModelAndView mainHome(CommandMap commandMap){
		ModelAndView mv = new ModelAndView("/home/mainHome");
		return mv;
	}
	/**
	 * 회원가입 페이지로 이동
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/home/openJoinPage.do")
	public ModelAndView openJoinPage() throws Exception {
		ModelAndView mv = new ModelAndView("/home/joinPage");
		return mv;
	}
	
	/**
	 * 로그인
	 * @param commandMap
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/home/login.do", method = RequestMethod.POST)
	public ModelAndView login(CommandMap commandMap, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/home/mainHome.do");
		Map<String, Object> user = homeSerivce.login(commandMap.getMap(), session);
		mv.addObject("userInfo", user);
		return mv;
	}
	/**
	 * 로그아웃
	 * @param commandMap
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/home/logoutMember.do")
	public ModelAndView logout(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/home/mainHome.do");
		session.invalidate();
		return mv;
	}
	
}
