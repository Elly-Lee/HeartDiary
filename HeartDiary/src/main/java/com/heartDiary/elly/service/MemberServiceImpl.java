package com.heartDiary.elly.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heartDiary.elly.dao.MemberDao;
import com.heartDiary.elly.dto.Member;
import com.heartDiary.elly.model.ModelResult;
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	
	}	

	@Override
	public Map<String, Object> join(Map<String, Object> param) {
		Map<String,Object> rs = new HashMap<>();
		String loginId = (String)param.get("loginId");
		
		Member member = memberDao.getMemberByLoginId(loginId);
		
		if(member!=null) {
			rs.put("resultCode", "F-1");
			rs.put("msg", String.format("(%s)는 사용할수없는 아이디입니다.", loginId));
		}
		
		memberDao.joinMember(param);
		rs.put("resultCode", "S-1");
		rs.put("msg", "회원가입 완료.");
		
		return rs;
	}

	@Override
	public ModelResult idCheck(String loginId) {
		
		int result = memberDao.idCheck(loginId);
		System.out.println("memberDao result is " + result);
		
		ModelResult modelResult = new ModelResult();
		if (result == 0) {//id empty
			modelResult.setMsg("아이디가 존재하지 않습니다.");
			modelResult.setSuccess(false);
		} else {//
			modelResult.setMsg("아이디가 존재합니다.");
			modelResult.setSuccess(true);
		}
		
		
		
		//result = sqlSession.selectOne("memberDao.idCheck", loginId);
		//System.out.println("sqlSession result is " + result);
		
		return modelResult;
	}	
}
