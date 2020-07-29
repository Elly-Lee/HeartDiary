package com.heartDiary.elly.dao;

import org.apache.ibatis.annotations.Mapper;

import com.heartDiary.elly.dto.Member;

@Mapper
public interface MemberDao {

	Member getMemberByLoginId(String loginId);

	Member getMemberById(int loginedId);

}
