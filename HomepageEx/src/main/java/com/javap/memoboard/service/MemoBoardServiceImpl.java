package com.javap.memoboard.service;

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
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return mbDAO.selectBoardList(map);
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
