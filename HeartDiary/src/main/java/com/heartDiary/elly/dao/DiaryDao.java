package com.heartDiary.elly.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.heartDiary.elly.dto.Diary;

@Mapper
public interface DiaryDao {

	List<Diary> getDiaries();

	Diary getDiary(@Param("id") int id);

	void writeDiary(Map<String, Object> param);

	void deleteDiary(int id);

	void modifyDiary(Map<String, Object> param);

}
