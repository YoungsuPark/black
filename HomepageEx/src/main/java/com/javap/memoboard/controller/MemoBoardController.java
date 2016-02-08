package com.javap.memoboard.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javap.common.common.CommandMap;
import com.javap.memoboard.service.MemoBoardService;

@Controller
public class MemoBoardController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="mbService")
	private MemoBoardService mbService;
	
	@RequestMapping(value="/memoboard/testMapArgumentResolver.do")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("");
		log.debug(commandMap.toString());
		return mv; 
	}
	
	@RequestMapping(value="/memoboard/openMemoBoardList.do")
	public ModelAndView openMemoBoardList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/memoboard/memoBoardList");	
		List<Map<String, Object>> list = mbService.selectBoardList(commandMap);
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping(value="/memoboard/openMemoBoardWrite.do")
	public ModelAndView openMemoBoardWrite(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/memoboard/memoBoardWrite");
	    return mv;
	}
	
	@RequestMapping(value="/memoboard/insertMemoBoard.do")
	public ModelAndView insertMemoBoard(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/memoboard/openMemoBoardList.do");
	    mbService.insertMemoBoard(commandMap.getMap());  
	    return mv;
	}
	
	@RequestMapping(value="/memoboard/openMemoBoardDetail.do")
	public ModelAndView openMemoBoardDetail(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/memoboard/memoBoardDetail");
	    Map<String,Object> map = mbService.selectMemoBoardDetail(commandMap.getMap());
	    mv.addObject("map", map);
	    return mv;
	}

	@RequestMapping(value="/memoboard/openMemoBoardUpdate.do")
	public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/memoboard/memoBoardUpdate"); 
	    Map<String,Object> map = mbService.selectMemoBoardDetail(commandMap.getMap());
	    mv.addObject("map", map);
	    return mv;
	}
	 
	@RequestMapping(value="/memoboard/updateMemoBoard.do")
	public ModelAndView updateBoard(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/memoboard/openMemoBoardDetail.do");
	    mbService.updateMemoBoard(commandMap.getMap()); 
	    mv.addObject("IDX", commandMap.get("IDX"));
	    return mv;
	}	
	
	@RequestMapping(value="/memoboard/deleteMemoBoard.do")
	public ModelAndView deleteBoard(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/memoboard/openMemoBoardList.do");
	    mbService.deleteMemoBoard(commandMap.getMap());
	    return mv;
	}
}
