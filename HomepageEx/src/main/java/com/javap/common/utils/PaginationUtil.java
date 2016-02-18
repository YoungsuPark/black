package com.javap.common.utils;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.javap.memoboard.dao.MemoBoardDAO;

@Component("paginationUtil")
public class PaginationUtil {
	protected Log log = LogFactory.getLog(PaginationUtil.class);
	
	@Resource(name="mbDAO")
	private MemoBoardDAO mbDAO;
	public static int currentPage = 1; // 현재페이지 (초기값 1패이지)
	public static int recordPerPage = 10; // 한 페이지당 보여줄 레코드의 수
	public static int pagesPerGroup = 5; // 한 그룹당 보여줄 페이지의 수
	
	public Map<String, Object> pagination(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int numOfRecords = mbDAO.numOfRecords();
		int numOfPages = (int)(numOfRecords / recordPerPage + (numOfRecords % recordPerPage == 0? 0:1));
		
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
		
		resultMap.put("currentPage", currentPage);
		resultMap.put("pagesPerGroup", pagesPerGroup);
		resultMap.put("startPageNumPerGroup", startPageNumPerGroup);
		resultMap.put("endPageNumPerGroup", endPageNumPerGroup);
		
		return resultMap;
	}

}
