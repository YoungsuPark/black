package com.javap.common.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUtil")
public class FileUtil {
	protected Log log = LogFactory.getLog(FileUtil.class);
	
	private static final String filePath = "C:\\devP\\file\\";
	
	public static String getRandomString(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	/**
	 * 첨부된 파일을 입력 시키기 위한 파일의 정보를 가공 해주는 메서드
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> InsertFileInfo(Map<String, Object> map, HttpServletRequest request) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		int boardIdx = (int)map.get("idx");
		
		File file = new File(filePath);
		if(file.exists() == false){
			file.mkdirs();
		}
		
		while(iterator.hasNext()){
			multipartFile = multipartRequest.getFile(iterator.next());
			
			if(multipartFile.isEmpty() == false){
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = getRandomString() + originalFileExtension;
				
				log.debug("-------------file start-------------");
				log.debug("name : " + multipartFile.getName());
				log.debug("filename : " + originalFileName);
				log.debug("storedFileName : " + storedFileName );
				log.debug("size : " + multipartFile.getSize());
				log.debug("-------------file end-------------\n");

				file = new File(filePath + storedFileName);
				multipartFile.transferTo(file);
				
				listMap.put("BOARD_IDX", boardIdx);
				listMap.put("ORIGINAL_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
				list.add(listMap);
			}
		}
		return list;
	}
}