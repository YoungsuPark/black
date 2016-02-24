package com.javap.file.service;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javap.file.dao.FileDAO;

@Service("fileService")
@Transactional
public class FileServiceImpl implements FileService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="fileDAO")
	private FileDAO fileDAO;
	
	/**
	 * DB에 파일 정보 가져오기
	 */
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return fileDAO.selectFileInfo(map);
	}
}
