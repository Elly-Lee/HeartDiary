package com.heartDiary.elly.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.heartDiary.elly.dto.Member;
import com.heartDiary.elly.model.ModelResult;

@Mapper
public interface MemberDao {

	Member getMemberByLoginId(@Param("loginId") String loginId);	

	void joinMember(Map<String, Object> param);

	int idCheck(String loginId);
	
}
