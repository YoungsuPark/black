package com.javap.memoboard.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javap.common.dao.AbstractDAO;

@Repository("mbDAO")
public class MemoBoardDAO extends AbstractDAO {
	/**
	 * 게시판 한 페에지에 보여줄 목록의 데이터를 가져오는 메서드.
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("memoboard.selectBoardList", map);
	}
	
	/**
	 * 게시판의 글 작성 시에 대한 데이터 입력
	 * @param map
	 * @throws Exception
	 */
	public void insertMemoBoard(Map<String, Object> map) throws Exception {
		insert("memoboard.insertBoard", map);
	}
	
	/**
	 * 게시판 파일 첨부 시에 대한 데이터 입력
	 * @param map
	 * @throws Exception
	 */
	public void inserFile(Map<String, Object> map) throws Exception {
		log.debug("DAO : " + map);
		insert("memoboard.insertFile", map);
		
	}
	
	/**
	 * 게시판 조회 할 때 마다 기존 조회수 + 1로 데이터 업데이트
	 * @param map
	 * @throws Exception
	 */
	public void updateHitCnt(Map<String, Object> map) throws Exception {
		update("memoboard.updateHitCnt", map);
	}
	
	/**
	 * 게시글 상세 보기에 대한 데이터 가져오기
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectMemoBoardDetail(Map<String, Object> map) throws Exception {
		return (Map<String, Object>) selectOne("memoboard.selectBoardDetail", map);
	}
	
	/**
	 * 게시글 조회 후 수정했을 시에 대한 데이터 업데이트 
	 * @param map
	 * @throws Exception
	 */
	public void updateMemoBoard(Map<String, Object> map) throws Exception {
		update("memoboard.updateBoard", map);
	}
	
	/**
	 * 댓글, 댓글이 안 달린 게시글 삭제 : del_gb 컬럼의 변수의 데이터를 업데이트 
	 * @param map
	 * @throws Exception
	 */
	public void deleteMemoBoard(Map<String, Object> map) throws Exception{
		update("memoboard.deleteBoard", map);
	}
	
	/**
	 * 댓글이 달렸을 시에 원글에 대한 게시글 삭제
	 * @param map
	 * @throws Exception
	 */
	public void deleteParaentMemoBoard(Map<String, Object> map) throws Exception{
		update("memoboard.deleteParentBoard", map);
	}
	
	/**
	 * 페이징 처리에 사용 되는 변수를 위한 데이터 조회 : 총 게시글의 수를 카운트해서 반환
	 * @return
	 * @throws Exception
	 */
	public int numOfRecords() throws Exception {
		return (int)getNums("memoboard.numOfRecords");
	}
	
	/**
	 * 게시판에 댓글 입력에 대한 데이터 입력
	 * @param map
	 * @throws Exception
	 */
	public void insertReply(Map<String, Object> map) throws Exception {
		insert("memoboard.insertReply", map);	
	}
	
	/**
	 * 계층형 게시판에 사용 되는 변수를 위한  데이터 업데이트
	 * @param map
	 * @throws Exception
	 */
	public void updateFamliy(Map<String, Object> map) throws Exception {
		update("memoboard.updateFamliy", map);	
	}
	
	/**
	 * 계층형 게시판에 사용 되는 변수 정보 업데이트
	 * @param map
	 * @throws Exception
	 */
	public void updateDepth(Map<String, Object> map)throws Exception {
		update("memoboard.updateDepth", map);
	}
	
	/**
	 * 계시글 삭제 시 댓글이 달려있는 게시글인지 아닌지 판단하기 위한 데이터 조회 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int checkReply(Map<String, Object> map) throws Exception {
		return (int)getNums("memoboard.numOfParents", map);
	}



}
