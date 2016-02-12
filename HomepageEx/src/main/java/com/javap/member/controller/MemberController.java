package com.javap.member.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javap.common.commandmap.CommandMap;
import com.javap.member.service.MemberService;

@Controller
public class MemberController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	@RequestMapping(value="/member/openJoinPage.do")
	public ModelAndView openJoinPage(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/member/joinPage");
		return mv;
	}
	
	@RequestMapping(value="/member/insertMember.do", method = RequestMethod.POST)
	public ModelAndView insertMember(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/home/welcomeHome.do");
		memberService.insertMember(commandMap.getMap());
		log.debug(commandMap);
		return mv;
	}
	
	@RequestMapping(value="/member/loginMember.do", method = RequestMethod.POST)
	public ModelAndView loginMember(CommandMap commandMap, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("/home/welcomeHome");
		Map<String, Object> userCheck = memberService.loginMember(commandMap.getMap());
		mv.addObject("memberInfo", userCheck);
		
		if( userCheck != null){
			session.setAttribute("sessionId", commandMap.get("ID"));
			session.setAttribute("authId", commandMap.get("auth_id"));
		} else {
			mv.addObject("errorMessage", "아이디와 비밀번호를 다시 확인주세요.");
		}
		return mv;
	}
	
	@RequestMapping(value="/member/logoutMember.do")
	public ModelAndView logoutMember(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/home/welcomeHome.do");
		session.invalidate();
		return mv;
	}

	@RequestMapping(value = "/member/memberInfo.do", method = RequestMethod.POST)
	public ModelAndView memberInfo(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/member/memberInfo_view");
		Map<String, Object> map = memberService.memberInfo(commandMap.getMap());
		mv.addObject("memberInfo", map);
		log.debug(map);
		return mv;
	}
	
	@RequestMapping(value = "/member/openModifyMemberContentView.do", method = RequestMethod.POST)
	public ModelAndView openModifyMemberContentView(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/member/memberInfo_modify");
		Map<String, Object> map = memberService.memberInfo(commandMap.getMap());
		mv.addObject("memberInfo", map);
		return mv;
	}
	
	@RequestMapping(value = "/member/modifyMember.do", method = RequestMethod.POST)
	public ModelAndView modifyMember(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/member/memberInfo_view");
		memberService.updateMember(commandMap.getMap());
		return mv;
	}
	
	@RequestMapping(value = "/member/deleteMember.do", method = RequestMethod.POST)
	public ModelAndView deleteMember(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/home/welcomeHome.do");
		memberService.deleteMember(commandMap.getMap());
		return mv;
	}
}