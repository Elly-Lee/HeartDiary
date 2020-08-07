package com.heartDiary.elly.service;

import java.util.List;
import java.util.Map;

import com.heartDiary.elly.dto.Diary;

public interface DiaryService {

	List<Diary> getDiaries();

	Diary getDiary(int id);

	Map<String, Object> write(Map<String, Object> param);

	Map<String, Object> deleteDiary(int id);

	Map<String, Object> modifyDiary(Map<String, Object> param);

}
