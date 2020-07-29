package com.heartDiary.elly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heartDiary.elly.dao.DiaryDao;
import com.heartDiary.elly.dto.Diary;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryDao diaryDao;

	@Override
	public List<Diary> getDiaries() {
		return diaryDao.getDiaries();
	}
	
}
