package com.javap.memoboard.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javap.common.commandmap.CommandMap;
import com.javap.memoboard.service.MemoBoardService;

@Controller
public class MemoBoardController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="mbService")
	private MemoBoardService mbService;
	
	@RequestMapping(value="/memoboard/openMemoBoardList.do")
	public ModelAndView openMemoBoardList(CommandMap commandMap) throws Exception {
		log.debug("commandMap : " + commandMap.getMap());
		ModelAndView mv = new ModelAndView("/memoboard/memoBoardList");	
		Map<String, Object> resultMap = mbService.selectBoardList(commandMap.getMap());
		mv.addObject("list", resultMap.get("list"));
		mv.addObject("currentPage", resultMap.get("currentPage"));
		mv.addObject("numOfPages", resultMap.get("numOfPages"));
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
