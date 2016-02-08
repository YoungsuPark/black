package com.javap.memoboard.service;

import java.util.List;
import java.util.Map;

public interface MemoBoardService {

	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;
	Map<String, Object> selectMemoBoardDetail(Map<String, Object> map) throws Exception;
	void insertMemoBoard(Map<String, Object> map) throws Exception;
	void updateMemoBoard(Map<String, Object> map) throws Exception;
	void deleteMemoBoard(Map<String, Object> map)throws Exception;

}
