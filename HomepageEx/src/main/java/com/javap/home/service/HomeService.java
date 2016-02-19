package com.javap.home.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface HomeService {

	Map<String, Object> login(Map<String, Object> map, HttpSession session) throws Exception;

}
