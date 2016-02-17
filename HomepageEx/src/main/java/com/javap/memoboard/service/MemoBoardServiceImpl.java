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
		int currentPage = 1; // 현재 페이지
		int recordPerPage = 10; // 한 페이지당 보여줄 record 수
		int pagesPerGroup = 5; // 한 그룹당 보여줄 page 수	
		int numOfRecords = mbDAO.numOfRecords(); // 총 record 수
		int numOfPages = (int)(numOfRecords / recordPerPage + (numOfRecords % recordPerPage == 0? 0:1)); // 총 페이지 수
		
		if(map.get("page") != null){
			currentPage = Integer.parseInt((String)(map.get("page")));
			if(currentPage < 1){
				currentPage = 1;
			} else if(currentPage >= numOfPages){
				currentPage = numOfPages;
			}
		}
		int startNumPerPage = recordPerPage * (currentPage - 1); // 한 페이지 당 게시물의 스타트 번호 
		int groupNum = (int)(currentPage / pagesPerGroup + (currentPage % pagesPerGroup == 0? 0:1)); // 현재 그룹
		
		int endPageNumPerGroup = groupNum * pagesPerGroup; // 한 그룹당 끝 페이지 번호
		int startPageNumPerGroup = endPageNumPerGroup - (pagesPerGroup - 1);
		if(endPageNumPerGroup >= numOfPages){
			endPageNumPerGroup = numOfPages;
		}
		map.put("startNumPerPage", startNumPerPage);
		map.put("recordPerPage", recordPerPage);
		
		List<Map<String, Object>> list = mbDAO.selectBoardList(map);	
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", list);
		resultMap.put("currentPage", currentPage);
		resultMap.put("pagesPerGroup", pagesPerGroup);
		resultMap.put("startPageNumPerGroup", startPageNumPerGroup);
		resultMap.put("endPageNumPerGroup", endPageNumPerGroup);
	
		return resultMap;
	}
	
	@Override
	public void insertMemoBoard(Map<String, Object> map) throws Exception {
		mbDAO.insertMemoBoard(map);
		if(map != null){
			map.put("IDX", (int)map.get("idx"));
			mbDAO.updateFamliy(map);
		}
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
	public Map<String, Object> deleteMemoBoard(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		int checkReply = mbDAO.checkReply(map);
		if(checkReply == 0){
			mbDAO.deleteMemoBoard(map);	
			resultMap.put("deleteMessage", "삭제되었습니다.");
		} else {
			resultMap.put("deleteMessage", "댓글이 달린 글은 삭제 할 수 없습니다.");
		}
		return resultMap;
	}
	
	@Override
	public void insetReply(Map<String, Object> map) throws Exception {
		mbDAO.updateDepth(map);
		mbDAO.insertReply(map);
	}
}
