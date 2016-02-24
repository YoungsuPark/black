package com.javap.file.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javap.common.dao.AbstractDAO;

@Repository("fileDAO")
public class FileDAO extends AbstractDAO{
	/**
	 * 파일 확인하기
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return (Map<String, Object>) selectOne("file.selectFileInfo", map);
	}
}
