package com.javap.memoboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.javap.memoboard.dao.MemoBoardDAO;

@Service("mbService")
public class MemoBoardServiceImpl implements MemoBoardService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="mbDAO")
	private MemoBoardDAO mbDAO;
	
	@Override
	public Map<String, Object> selectBoardList(Map<String, Object> map) throws Exception {
		
		int numOfRecords = mbDAO.numOfRecords();
		int recordPerPage = 2;
		int numOfPages = (int)(numOfRecords / recordPerPage + (numOfRecords % recordPerPage == 0? 0:1));
		int currentPage = 1;
		
		if(map.get("page") != null) {
			currentPage = Integer.parseInt((String)(map.get("page")));
			
			if (currentPage == 0 ){
				currentPage = 1;
			} 
			else if (currentPage > numOfPages){
				currentPage = numOfPages;
			}
		}
		
		int startNumPerPage = recordPerPage * (currentPage - 1);
		
		map.put("startNumPerPage", startNumPerPage);
		map.put("recordPerPage", recordPerPage);
	
		List<Map<String, Object>> list = mbDAO.selectBoardList(map);	
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", list);
		resultMap.put("numOfPages", numOfPages);
		resultMap.put("currentPage", currentPage);
		log.debug("numOfPages : " + numOfPages);
		log.debug("numOfRecords : " + numOfRecords);
		log.debug("startNumPerPage : " + startNumPerPage);
		log.debug("recordPerPage : " + recordPerPage);
		log.debug("resultMap : " + resultMap);
		return resultMap;
	}
	
	@Override
	public void insertMemoBoard(Map<String, Object> map) throws Exception {
		mbDAO.insertMemoBoard(map);	
	}
	
	@Override
	public Map<String, Object> selectMemoBoardDetail(Map<String, Object> map) throws Exception {
		mbDAO.updateHitCnt(map);
		Map<String, Object> resultMap = mbDAO.selectMemoBoardDetail(map);
		return resultMap;
	}
	
	@Override
	public void updateMemoBoard(Map<String, Object> map) throws Exception {
		mbDAO.updateMemoBoard(map);
	}
	
	@Override
	public void deleteMemoBoard(Map<String, Object> map) throws Exception {
		mbDAO.deleteMemoBoard(map);		
	}
}
