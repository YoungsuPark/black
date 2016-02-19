package com.javap.home.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javap.common.dao.AbstractDAO;

@Repository("homeDAO")
public class HomeDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public Map<String, Object> login(Map<String, Object> map) throws Exception {
		return (Map<String, Object>) selectOne("home.login", map);
	}
}
