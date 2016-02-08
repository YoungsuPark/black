package com.javap.common.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javap.common.commandmap.CommandMap;

@Controller
public class HomeController {
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/home/welcomeHome.do")
	public ModelAndView welcomeHome(CommandMap commandMap){
		ModelAndView mv = new ModelAndView("/home/welcomeHome");
		return mv;
	}
	
	
}
