package com.javap.home.service;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.javap.home.dao.HomeDAO;

@Service("homeService")
public class HomeServiceImpl implements HomeService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="homeDAO")
	private HomeDAO homeDAO;
	
	@Override
	public Map<String, Object> login(Map<String, Object> map, HttpSession session) throws Exception {
		log.debug("login info : " + map);
		Map<String, Object> user = homeDAO.login(map);
		log.debug("user info : " + user);
		if(user != null){
			session.setAttribute("sessionId", user.get("ID"));
			session.setAttribute("sessionIdx", user.get("IDX"));
			session.setAttribute("name", user.get("NAME"));
		} 
		return user;
	}
}