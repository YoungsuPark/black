package com.javap.member.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javap.common.commandmap.CommandMap;
import com.javap.member.service.MemberService;

@Controller
public class MemberController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	/**
	 * 회원가입
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/member/insertMember.do")
	public ModelAndView insertMember(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/home/mainHome.do");
		memberService.insertMember(commandMap.getMap());
		log.debug(commandMap);
		return mv;
	}
	/**
	 * 회원정보 상세 보기
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/member/openMemberInfo.do")
	public ModelAndView memberInfo(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/member/memberInfoDetail");
		Map<String, Object> map = memberService.memberInfo(commandMap.getMap());
		mv.addObject("memberInfo", map);
		return mv;
	}
	/**
	 * 회원정보 수정 페이지로 이동
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/member/openMemberInfoUpdate.do")
	public ModelAndView openMemberInfoUpdatePage(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/member/memberInfoUpdate");
		Map<String, Object> map = memberService.memberInfo(commandMap.getMap());
		mv.addObject("memberInfo", map);
		return mv;
	}
	/**
	 * 회원정보 수정
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/member/memberInfoUpdate.do")
	public ModelAndView modifyMember(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/home/mainHome.do");
		memberService.updateMember(commandMap.getMap());
		return mv;
	}
	/**
	 * 회원 탈퇴
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/member/deleteMember.do")
	public ModelAndView deleteMember(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/home/mailHome.do");
		memberService.deleteMember(commandMap.getMap());
		return mv;
	}
	/**
	 * 
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/member/openPasswordUpdate.do")
	public ModelAndView openPasswordUpdatePage(CommandMap commandMap)throws Exception{
		ModelAndView mv = new ModelAndView("/member/error");
		return mv;
	}
}