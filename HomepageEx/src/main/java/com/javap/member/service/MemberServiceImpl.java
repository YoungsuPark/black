package com.javap.member.service;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.javap.member.dao.MemberDAO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="memberDAO")
	private MemberDAO memberDAO;
	
	@Override
	public void insertMember(Map<String, Object> map) throws Exception {
		memberDAO.insertMember(map);
	}
	
	@Override
	public Map<String, Object> loginMember(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = memberDAO.loginMember(map);
		return resultMap;
	}
	
	@Override
	public Map<String, Object> memberInfo(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = memberDAO.memberInfo(map);
		return resultMap;
	}
	
	@Override
	public void updateMember(Map<String, Object> map) throws Exception {
		memberDAO.updateMember(map);
	}
	
	@Override
	public void deleteMember(Map<String, Object> map) throws Exception {
		memberDAO.deleteMember(map);
		
	}

}
