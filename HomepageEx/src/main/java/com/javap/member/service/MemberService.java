package com.javap.member.service;

import java.util.Map;

public interface MemberService {
	
	
	void insertMember(Map<String, Object> map) throws Exception;
	
	Map<String, Object> memberInfo(Map<String, Object> map) throws Exception;

	void updateMember(Map<String, Object> map) throws Exception;

	void deleteMember(Map<String, Object> map) throws Exception;

	
}
