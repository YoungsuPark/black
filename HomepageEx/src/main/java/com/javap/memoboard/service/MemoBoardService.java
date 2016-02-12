package com.javap.memoboard.service;

import java.util.Map;

public interface MemoBoardService {

	Map<String, Object> selectBoardList(Map<String, Object> map) throws Exception;
	Map<String, Object> selectMemoBoardDetail(Map<String, Object> map) throws Exception;
	void insertMemoBoard(Map<String, Object> map) throws Exception;
	void updateMemoBoard(Map<String, Object> map) throws Exception;
	void deleteMemoBoard(Map<String, Object> map)throws Exception;

}
