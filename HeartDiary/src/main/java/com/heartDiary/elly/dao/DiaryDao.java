package com.heartDiary.elly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.heartDiary.elly.dto.Diary;

@Mapper
public interface DiaryDao {

	List<Diary> getDiaries();

}
