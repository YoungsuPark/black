package com.javap.file.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javap.common.dao.AbstractDAO;

@Repository("fileDAO")
public class FileDAO extends AbstractDAO{
	/**
	 * 첨부 파일 정보 조회
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return (Map<String, Object>) selectOne("file.selectFileInfo", map);
	}
}
