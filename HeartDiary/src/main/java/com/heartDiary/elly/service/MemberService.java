package com.heartDiary.elly.service;

import java.util.Map;

import com.heartDiary.elly.dto.Member;
import com.heartDiary.elly.model.ModelResult;

public interface MemberService {

	Member getMemberByLoginId(String loginId);

	Map<String, Object> join(Map<String, Object> param);

	ModelResult idCheck(String loginId);

	
}
