package com.heartDiary.elly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heartDiary.elly.dao.MemberDao;
import com.heartDiary.elly.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	
	}

	@Override
	public Member getMemberById(int loginedId) {
		return memberDao.getMemberById(loginedId);
	}

}
