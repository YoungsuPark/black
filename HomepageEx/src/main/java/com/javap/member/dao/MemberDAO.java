package com.javap.member.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javap.common.dao.AbstractDAO;

@Repository("memberDAO")
public class MemberDAO extends AbstractDAO{

	public void insertMember(Map<String, Object> map) throws Exception {
		insert("member.insertMember", map);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> loginMember(Map<String, Object> map) throws Exception {
		return (Map<String, Object>)selectOne("member.loginMember", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> memberInfo(Map<String, Object> map) throws Exception {
		return (Map<String, Object>)selectOne("member.memberInfo", map);
	}

	public void updateMember(Map<String, Object> map) {
		update("member.updateMember", map);
	}

	public void deleteMember(Map<String, Object> map) {
		delete("member.deleteMember", map);
		
	}

}
