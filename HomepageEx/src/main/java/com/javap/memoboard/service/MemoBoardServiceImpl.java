package com.javap.memoboard.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.javap.common.utils.FileUtil;
import com.javap.common.utils.PaginationUtil;
import com.javap.memoboard.dao.MemoBoardDAO;

@Service("mbService")
public class MemoBoardServiceImpl implements MemoBoardService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="fileUtil")
	private FileUtil fileUtil;
	
	@Resource(name="paginationUtil")
	private PaginationUtil paginationUtil;
	
	@Resource(name="mbDAO")
	private MemoBoardDAO mbDAO;
	
	@Override
	public Map<String, Object> selectBoardList(Map<String, Object> map) throws Exception {	
		Map<String, Object> resultMap = paginationUtil.pagination(map);
		List<Map<String, Object>> list = mbDAO.selectBoardList(map);
		resultMap.put("list", list);
		return resultMap;
	}
	
	@Override
	public void insertMemoBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
		mbDAO.insertMemoBoard(map);
		
		if(map != null){
			map.put("IDX", (int)map.get("idx"));
			mbDAO.updateFamliy(map);
		}
		List<Map<String, Object>> list = fileUtil.InsertFileInfo(map, request);
		for(int i=0, size=list.size(); i<size; i++)
			mbDAO.inserFile(list.get(i));
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
		if(mbDAO.checkReply(map) == 0)
			mbDAO.deleteMemoBoard(map);
		 else 
			mbDAO.deleteParaentMemoBoard(map);
	}
	
	@Override
	public void insetReply(Map<String, Object> map) throws Exception {
		mbDAO.updateDepth(map);
		mbDAO.insertReply(map);
	}
}
