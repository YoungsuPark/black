package com.javap.memoboard.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javap.common.dao.AbstractDAO;

@Repository("mbDAO")
public class MemoBoardDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("memoboard.selectBoardList", map);
	}

	public void insertMemoBoard(Map<String, Object> map) throws Exception {
		insert("memoboard.insertBoard", map);
		
	}

	public void updateHitCnt(Map<String, Object> map) throws Exception {
		update("memoboard.updateHitCnt", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> selectMemoBoardDetail(Map<String, Object> map) throws Exception {
		return (Map<String, Object>) selectOne("memoboard.selectBoardDetail", map);
	}

	public void updateMemoBoard(Map<String, Object> map) throws Exception {
		update("memoboard.updateBoard", map);
		
	}

	public void deleteMemoBoard(Map<String, Object> map) {
		update("memoboard.deleteBoard", map);
	}
	
	
}
