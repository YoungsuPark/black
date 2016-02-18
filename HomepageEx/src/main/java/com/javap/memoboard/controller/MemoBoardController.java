package com.javap.memoboard.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	
	/**
	 * Controller : 게시판 리스트 목록 보기 요청에 해당하는비즈니스 로직(mbService.selectBoardList())에 연결. 
	 * 				게시판 리스트, 페이징처리에 필요한 값들을 모델에 저장 후 View(memoBoardList.jsp)에 렌더링.
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/memoboard/openMemoBoardList.do")
	public ModelAndView openMemoBoardList(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/memoboard/memoBoardList");	
		Map<String, Object> resultMap = mbService.selectBoardList(commandMap.getMap());
		mv.addObject("list", resultMap.get("list"));
		mv.addObject("currentPage", resultMap.get("currentPage"));
		mv.addObject("pagesPerGroup", resultMap.get("pagesPerGroup"));
		mv.addObject("startPageNumPerGroup", resultMap.get("startPageNumPerGroup"));
		mv.addObject("endPageNumPerGroup", resultMap.get("endPageNumPerGroup"));
		return mv;
	}
	/**
	 * Controller : 게시판 작성하기 페이지로 이동 요청.
	 * 			    View(memoBoardWrite.jsp)로 이동.
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/memoboard/openMemoBoardWrite.do")
	public ModelAndView openMemoBoardWrite(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/memoboard/memoBoardWrite");
	    return mv;
	}
	/**
	 * 컨트롤러 : "게시물 작성 하기" 로직에 맵핑, 게시판 목록으로 이동
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/memoboard/insertMemoBoard.do")
	public ModelAndView insertMemoBoard(CommandMap commandMap, HttpServletRequest request) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/memoboard/openMemoBoardList.do");
	    mbService.insertMemoBoard(commandMap.getMap(), request);
	    return mv;
	}
	/**
	 * 게시물 상세보기
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/memoboard/openMemoBoardDetail.do")
	public ModelAndView openMemoBoardDetail(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/memoboard/memoBoardDetail");
	    Map<String,Object> map = mbService.selectMemoBoardDetail(commandMap.getMap());
	    mv.addObject("map", map);
	    return mv;
	}
	/**
	 * 게시물 수정하기 페이지로 이동
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/memoboard/openMemoBoardUpdate.do")
	public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/memoboard/memoBoardUpdate"); 
	    Map<String,Object> map = mbService.selectMemoBoardDetail(commandMap.getMap());
	    mv.addObject("map", map);
	    return mv;
	}
	 /**
	  * 게시물 수정하기
	  * @param commandMap
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="/memoboard/updateMemoBoard.do")
	public ModelAndView updateBoard(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/memoboard/openMemoBoardDetail.do");
	    mbService.updateMemoBoard(commandMap.getMap()); 
	    mv.addObject("IDX", commandMap.get("IDX"));
	    return mv;
	}	
	/**
	 * 게시물 삭제하기
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/memoboard/deleteMemoBoard.do")
	public ModelAndView deleteBoard(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/memoboard/openMemoBoardList.do");
	    mbService.deleteMemoBoard(commandMap.getMap());
	    return mv;
	}
	
	/**
	 * 답글 작성하기 페이지로 이동
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/memoboard/openReplyWrite.do")
	public ModelAndView openReplyWrite(CommandMap commandMap)throws Exception{
		ModelAndView mv = new ModelAndView("/memoboard/replyWrite");
		Map<String, Object> map = mbService.selectMemoBoardDetail(commandMap.getMap());
		mv.addObject("map", map);
		return mv;
	}
	/**
	 * 답글 작성하기
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/memoboard/insertReply.do")
	public ModelAndView insertReply(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/memoboard/openMemoBoardList.do");
		mbService.insetReply(commandMap.getMap());
		return mv;
	}

/*	@RequestMapping(value="/memo/{memoSeq}", method = RequestMethod.GET)
	public ModelAndView memoDetail(@PathVariable("memoSeq") int memoSeq) throws Exception {
		ModelAndView mv = new ModelAndView("/memoboard/memoBoardDetail");
		CommandMap commandMap = new CommandMap();
		commandMap.put("IDX", memoSeq);
	    Map<String,Object> map = mbService.selectMemoBoardDetail(commandMap.getMap());
	    mv.addObject("map", map);
		return mv;
	}*/
}
