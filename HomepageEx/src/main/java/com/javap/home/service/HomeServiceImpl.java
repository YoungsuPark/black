package com.javap.home.service;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javap.home.dao.HomeDAO;

@Service("homeService")
@Transactional
public class HomeServiceImpl implements HomeService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="homeDAO")
	private HomeDAO homeDAO;

	/**
	 * 로그인
	 */
	@Override
	public Map<String, Object> login(Map<String, Object> map, HttpSession session) throws Exception {	
		Map<String, Object> user = homeDAO.login(map);	
		if(user != null){
			session.setAttribute("sessionId", user.get("ID"));
			session.setAttribute("sessionIdx", user.get("IDX"));
		} 
		return user;
	}
}