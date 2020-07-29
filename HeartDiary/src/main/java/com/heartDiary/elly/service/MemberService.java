package com.heartDiary.elly.service;

import com.heartDiary.elly.dto.Member;

public interface MemberService {

	Member getMemberByLoginId(String loginId);

	Member getMemberById(int loginedMemberId);

}
